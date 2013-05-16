/**
 * BuildCraft is open-source. It is distributed under the terms of the
 * BuildCraft Open Source License. It grants rights to read, modify, compile
 * or run the code. It does *NOT* grant the right to redistribute this software
 * or its modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package net.enkun.mods.AdvancedLaser;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Property;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.api.bptblocks.BptBlockInventory;
import buildcraft.api.bptblocks.BptBlockRotateMeta;
import buildcraft.api.recipes.AssemblyRecipe;
import buildcraft.core.DefaultProps;
import buildcraft.core.Version;
import buildcraft.core.proxy.CoreProxy;
import net.enkun.mods.AdvancedLaser.BlockAdvLaser;
import net.enkun.mods.AdvancedLaser.CommonProxy;
import net.enkun.mods.AdvancedLaser.TileLaser;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = "AdvancedLaser", version = "0.1", useMetadata = false, modid = "AdvLaser", dependencies = "required-after:BuildCraft|Core;required-after:BuildCraft|Silicon;required-after:BuildCraft|Transport")
@NetworkMod(channels = { "AdvLsr" }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
public class AdvancedLaser {
	public static BlockAdvLaser AdvlaserBlock;

	@Instance("AdvLaser")
	public static AdvancedLaser instance;

	@Init
	public void load(FMLInitializationEvent evt) {
		CoreProxy.proxy.registerTileEntity(TileLaser.class, "net.enkun.mods.AdvancedLaser.TileLaser");

		new BptBlockRotateMeta(AdvlaserBlock.blockID, new int[] { 2, 5, 3, 4 }, true);

		CommonProxy.proxy.registerRenderers();
		
		CoreProxy.proxy.addCraftingRecipe(new ItemStack(AdvlaserBlock),
				new Object[] { "LLL", "L L", "LLL", Character.valueOf('L'), BuildCraftSilicon.laserBlock });
		
	}

	@PreInit
	public void initialize(FMLPreInitializationEvent evt) {

		AdvlaserBlock = new BlockAdvLaser(1300);
		AdvlaserBlock.setBlockName("AdvancedLaser");
		LanguageRegistry.addName(AdvlaserBlock, "Advanced Laser");
		GameRegistry.registerBlock(AdvlaserBlock);

	}
}
