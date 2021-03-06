package com.abstractlabs.toe.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleEffects {
	private static Minecraft mc = Minecraft.getMinecraft();
    private static World theWorld = mc.theWorld;
    private static TextureManager renderEngine = mc.renderEngine;
    
    public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12) {
    	if ((mc != null) && (mc.renderViewEntity != null) && (mc.effectRenderer != null)) {
    		int var14 = mc.gameSettings.particleSetting;

    		if ((var14 == 1) && (theWorld.rand.nextInt(3) == 0)) {
    			var14 = 2;
    		}

    		double var15 = mc.renderViewEntity.posX - par2;
    		double var17 = mc.renderViewEntity.posY - par4;
    		double var19 = mc.renderViewEntity.posZ - par6;
    		EntityFX var21 = null;
    		double var22 = 16.0D;

    		if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
    			return null;
    		}
    		if (var14 > 1) {
    			return null;
    		}

    		if (particleName.equals("portalCallisto")) {
    			var21 = new EntityCallistoPortalFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
    		} else if (particleName.equals("green")) {
    			var21 = new EntityGreenFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
    		} else if (particleName.equals("green2")) {
    			var21 = new EntityGreenFX(theWorld, par2, par4, par6, 100, (float)par8, (float)par10, (float)par12);
    		} else if (particleName.equals("tree")) {
    			var21 = new EntityTreeFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
    		} else if (particleName.equals("smokebomb")) {
    			var21 = new EntitySmokeBombFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
    		} else if (particleName.equals("portalNeptune")) {
    			var21 = new EntityNeptunePortalFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
    		}

    		mc.effectRenderer.addEffect(var21);
    		return var21;
    	}
    	return null;
    }
}