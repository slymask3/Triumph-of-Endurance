package com.abstractlabs.toe.skill.brewing;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class BrewingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public BrewingPacket() {}
	
	public BrewingPacket(int level, int per) {
		this.lvl = level;
		this.percent = per;
	}
	
	public void fromBytes(ByteBuf buf) {
		this.lvl = buf.readInt();
		this.percent = buf.readInt();
	}
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.lvl);
		buf.writeInt(this.percent);
	}
	
	public static class Handler implements IMessageHandler<BrewingPacket, IMessage> {
		public IMessage onMessage(BrewingPacket msg, MessageContext ctx) {
			BrewingGUI.lvl = msg.lvl;
			BrewingGUI.percent = msg.percent;
			DescriptionGUI.lvl_brewing = msg.lvl;
			return null;
		}
	}
}