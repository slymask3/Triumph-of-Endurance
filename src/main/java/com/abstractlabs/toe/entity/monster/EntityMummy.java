package com.abstractlabs.toe.entity.monster;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.LogHelper;

public class EntityMummy extends EntityMob {

	public EntityMummy(World world) {
		super(world);
		this.setSize(0.6F, 1.8F);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
    
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }
	
	protected boolean isAIEnabled() {
        return true;
    }

	public void onLivingUpdate() {
        super.onLivingUpdate();
        //could maybe use this method for something later
    }
	
	public boolean attackEntityFrom(DamageSource src, float par2) {
        return super.attackEntityFrom(src, par2);
        //could maybe use this method for something later
    }
    
    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        //could maybe use this method for something later
    }
    
    public boolean interact(EntityPlayer player) {
        return super.interact(player);
        //could maybe use this method for something later
    }
    
    public void onDeath(DamageSource src) {
        super.onDeath(src);
        //could maybe use this method for something later
        
//        if(ArenalismHelper.getProperties(Minecraft.getMinecraft().thePlayer).inArena() && !this.worldObj.isRemote) {
//        	ArenalismHelper.getProperties(Minecraft.getMinecraft().thePlayer).updateEnemies(ArenalismHelper.getProperties(Minecraft.getMinecraft().thePlayer).getEnemiesRemaining()-1);
//            LogHelper.info("mummy died and in if statement.");
//        }
//        
//        LogHelper.info("mummy died.");
    }
	
	protected String getLivingSound() {
        return "mob.zombie.say";
    }

    protected String getHurtSound() {
        return "mob.wither.hurt";
    }
    
    protected String getDeathSound() {
        return "mob.wither.death";
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    protected boolean canDespawn() {
        return false;
    }
}