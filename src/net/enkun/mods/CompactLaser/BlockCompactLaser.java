/**
 * Copyright (c) SpaceToad, 2011
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.enkun.mods.CompactLaser;

import java.util.ArrayList;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.DefaultProps;

public class BlockCompactLaser extends BlockContainer {

	public BlockCompactLaser(int i) {
		super(i, Material.iron);
		setHardness(0.5F);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
	}

	@Override
	public int getRenderType() {
		return CommonProxy.laserBlockModel;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isACube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileLaser();
	}

	@Override
	public String getTextureFile() {
		return "/net/enkun/mods/CompactLaser/sprite.png";
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		if (i == ForgeDirection.values()[j].getOpposite().ordinal())
			return 2;
		else if (i == j)
			return 1;
		else
			return 0;

	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float par6, float par7, float par8, int meta) {
		super.onBlockPlaced(world, x, y, z, side, par6, par7, par8, meta);

		if (side <= 6) {
			meta = side;
		}

		return meta;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addCreativeItems(ArrayList itemList) {
		itemList.add(new ItemStack(this));
	}
}
