package com.abstractlabs.toe.skill.arenalism;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.abstractlabs.toe.reference.Skill;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArenalismGUI extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
	
	public static int lvl;
	public static int percent;

	private String texture = Skill.texture_arenalism;
	private String texture_gold = Skill.texture_arenalism_gold;
	private int xPos = Skill.guiX_16;
	private int yPos = Skill.guiY_16;

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.type != ElementType.EXPERIENCE) { 
			return;
		}
		
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int h = scaledresolution.getScaledHeight();
		int w = scaledresolution.getScaledWidth();
		
		if(lvl == Skill.maxLevel) {
			this.mc.renderEngine.bindTexture(new ResourceLocation(texture_gold));
		} else {
			this.mc.renderEngine.bindTexture(new ResourceLocation(texture));
		}
		
		int y = yPos;
		int x = w - xPos;
		this.drawTexturedModalRect(x, y, 0, 0, 16, 16);
      
		Helper.drawStringWithBorder(mc, x, y-2, lvl, 16777215, 0);
      
		this.mc.renderEngine.bindTexture(new ResourceLocation("toe:textures/gui/percentageBar.png"));
		y += 14;
	      
		if (lvl != Skill.maxLevel) {
			this.drawTexturedModalRect(x, y, 0, 0, 14, 1);
			this.drawTexturedModalRect(x, y, 0, 1, (int)(14D * (percent / 100D)), 2);
		} else {
			this.drawTexturedModalRect(x, y, 0, 1, 14, 2);
		}
	}
}