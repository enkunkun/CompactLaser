package net.enkun.mods.CompactLaser;

import cpw.mods.fml.common.SidedProxy;

public class CommonProxy {
	@SidedProxy(clientSide = "net.enkun.mods.CompactLaser.ClientProxy", serverSide = "net.enkun.mods.CompactLaser.CommonProxy")
	public static CommonProxy proxy;
	public static int laserBlockModel = -1;

	public void registerRenderers() {
	}
	
	public void registerTextures()	{
	}

}
