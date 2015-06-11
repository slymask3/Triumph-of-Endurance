package com.abstractlabs.toe.gui;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiScreenOverlay extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
	
	public static int showTicks = 0;
	public static int image;
   
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event) { 
		if ((event.isCanceled()) || (event.type != RenderGameOverlayEvent.ElementType.HELMET)) {
			//LogHelper.info("renderoverlay | rip");
			return;
		}

		//LogHelper.info("renderoverlay | ticks == " + showTicks);
		
		if (showTicks > 0) {
			//drawOverlay();
			showTicks--;
		}
	}
   
	public void drawOverlay() {
		//LogHelper.info("drawoverlay");
		ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int h = res.getScaledHeight();
		int w = res.getScaledWidth();
		
		GL11.glDisable(2929);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GL11.glDisable(3008);
	     
	    if (image == 1) {
	    	this.mc.renderEngine.bindTexture(new ResourceLocation("toe:textures/gui/overlay/beam.png"));
	    }
	     
	    Tessellator tessellator = Tessellator.instance;
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(0.0D, res.getScaledHeight_double(), -90.0D, 0.0D, 1.0D);
	    tessellator.addVertexWithUV(res.getScaledWidth_double(), res.getScaledHeight_double(), -90.0D, 1.0D, 1.0D);
	    tessellator.addVertexWithUV(res.getScaledWidth_double(), 0.0D, -90.0D, 1.0D, 0.0D);
	    tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
	    tessellator.draw();
	    
	    //this.drawTexturedModalRect(0, 0, 0, 0, 384, 256);
	    
	    GL11.glDepthMask(true);
	    GL11.glEnable(2929);
	    GL11.glEnable(3008);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}