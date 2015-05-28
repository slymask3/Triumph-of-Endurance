package com.abstractlabs.toe.skill;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public abstract class AbstractGUI extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
	public static int value;
	public static int percent;
	
	protected String texture;
	protected int xPos;
	protected int yPos;

	protected AbstractGUI(String texture, int xPos, int yPos) {
		this.texture = texture;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.type != ElementType.EXPERIENCE) { 
			return;
		}
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int h = scaledresolution.getScaledHeight();
		int w = scaledresolution.getScaledWidth();
		this.mc.renderEngine.bindTexture(new ResourceLocation(texture));
		int y = yPos;
		int x = w - xPos;
		this.drawTexturedModalRect(x, y, 0, 0, 25, 25);
      
		if (value == 100)
			x -= 8;
		mc.fontRenderer.drawString("" + value, x + 8, y - 1, 0);
		mc.fontRenderer.drawString("" + value, x + 8, y - 3, 0);
		mc.fontRenderer.drawString("" + value, x + 9, y - 2, 0);
		mc.fontRenderer.drawString("" + value, x + 7, y - 2, 0);
      
		mc.fontRenderer.drawString("" + value, x + 8, y - 2, 16777215);
		if (value == 100) {
			x += 8;
		}
		this.mc.renderEngine.bindTexture(new ResourceLocation("nevermine:textures/gui/percentageBar.png"));
		y += 20;
      
		if (value != 100) {
			this.drawTexturedModalRect(x, y, 0, 0, 25, 5);
			this.drawTexturedModalRect(x, y, 0, 5, (int)(3.125D * (percent / 13.5D)), 10);
		} else {
			this.drawTexturedModalRect(x, y, 0, 5, 25, 10);
		}
	}
}