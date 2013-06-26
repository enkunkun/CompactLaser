package net.enkun.mods.CompactLaser;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		CommonProxy.laserBlockModel = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new SiliconRenderBlock());
	}

	@Override
	public void registerTextures() {
		MinecraftForgeClient.preloadTexture("/net/enkun/mods/CompactLaser/sprite.png");
	}
}
