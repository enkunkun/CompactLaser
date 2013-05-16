package net.enkun.mods.AdvancedLaser;

import cpw.mods.fml.common.SidedProxy;

public class CommonProxy {
	@SidedProxy(clientSide = "net.enkun.mods.AdvancedLaser.ClientProxy", serverSide = "net.enkun.mods.AdvancedLaser.CommonProxy")
	public static CommonProxy proxy;
	public static int laserBlockModel = -1;

	public void registerRenderers() {
	}

}
