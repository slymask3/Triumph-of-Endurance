package com.abstractlabs.toe;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldType;

import com.abstractlabs.toe.client.gui.GuiHandler;
import com.abstractlabs.toe.command.CommandToe;
import com.abstractlabs.toe.handler.ConfigHandler;
import com.abstractlabs.toe.init.ToeBiomes;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeBusses;
import com.abstractlabs.toe.init.ToeDimensions;
import com.abstractlabs.toe.init.ToeGenBiome;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.init.ToeMobs;
import com.abstractlabs.toe.init.ToePackets;
import com.abstractlabs.toe.init.ToePotions;
import com.abstractlabs.toe.init.ToeRecipes;
import com.abstractlabs.toe.init.ToeRenders;
import com.abstractlabs.toe.init.ToeTiles;
import com.abstractlabs.toe.network.PacketPipeline;
import com.abstractlabs.toe.proxy.IProxy;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;
import com.abstractlabs.toe.world.WorldTypeToe;
import com.abstractlabs.toe.world.gen.WorldGeneratorToe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)
public class Toe {
	@Instance(Reference.MOD_ID)
	public static Toe instance = new Toe();
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();

	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		packetPipeline.init();
		
		ToePackets.init();
		ToeBlocks.init();
		ToeItems.init();
		ToeRenders.init();
		ToeMobs.init();
		ToeBusses.init();
		ToeTiles.init();
		ToeBiomes.init();
		ToeDimensions.init();
		ToePotions.init();
		ToeRecipes.init();
		
		ToeGenBiome.mainRegistry();
		
		proxy.registerInformation();
		
		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGeneratorToe(), 1000);
		//MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeHandler());
		
//		List<IResourcePack> defaultResourcePacks = ObfuscationReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "defaultResourcePacks", "field_110449_ao");
//		defaultResourcePacks.add(new ResourceLoc());
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityFishingHook.class, new RenderFishHook());
		
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Complete!");
		
		//WorldType HOLLOWS = new WorldTypesToe("hollows");
		
		WorldType MOON = new WorldTypeToe("moon");
	}
	
	@Mod.EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ServerCommandManager command = (ServerCommandManager) server.getCommandManager();
		
		command.registerCommand(new CommandToe());
	}
}
