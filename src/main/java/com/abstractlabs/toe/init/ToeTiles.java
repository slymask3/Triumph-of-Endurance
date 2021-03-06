package com.abstractlabs.toe.init;

import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceDiamond;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceEmerald;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceGold;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceIron;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceRedstone;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;
import com.abstractlabs.toe.tileentity.TileEntityPedestal;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.tileentity.TileEntityTransmutation;
import com.abstractlabs.toe.tileentity.TileEntityUtility;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;
import com.abstractlabs.toe.world.arena.Arena;

public class ToeTiles {
	public static void init() {
		TileEntity.addMapping(Arena.class, "TileEntityArena");
		TileEntity.addMapping(TileEntityWeaponry.class, "TileEntityWeaponry");
		TileEntity.addMapping(TileEntityUtility.class, "TileEntityUtility");
		TileEntity.addMapping(TileEntityBlockArmoury.class, "TileEntityBlockArmoury");
		TileEntity.addMapping(TileEntityRecall.class, "TileEntityRecall");
		TileEntity.addMapping(TileEntityLockedChest.class, "TileEntityLockedChest");
		TileEntity.addMapping(TileEntityLandmine.class, "TileEntityLandmine");
		TileEntity.addMapping(TileEntityStatueBiped.class, "TileEntityStatueBiped");
		TileEntity.addMapping(TileEntityATM.class, "TileEntityATM");
		TileEntity.addMapping(TileEntityFurnaceIron.class, "TileEntityFurnaceIron");
		TileEntity.addMapping(TileEntityFurnaceGold.class, "TileEntityFurnaceGold");
		TileEntity.addMapping(TileEntityFurnaceDiamond.class, "TileEntityFurnaceDiamond");
		TileEntity.addMapping(TileEntityFurnaceEmerald.class, "TileEntityFurnaceEmerald");
		TileEntity.addMapping(TileEntityFurnaceRedstone.class, "TileEntityFurnaceRedstone");
		TileEntity.addMapping(TileEntityDisplayCase.class, "TileEntityDisplayCase");
		TileEntity.addMapping(TileEntityPedestal.class, "TileEntityPedestal");
		TileEntity.addMapping(TileEntityTransmutation.class, "TileEntityTransmutation");
	}
}