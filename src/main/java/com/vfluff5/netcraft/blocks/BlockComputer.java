package com.vfluff5.netcraft.blocks;

import com.vfluff5.netcraft.Netcraft;
import com.vfluff5.netcraft.tileentities.TileEntityComputer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockComputer extends BlockContainer {
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);
	public String name = "computer";

	public BlockComputer() {
		super(Material.iron);
		this.setHardness(2);
		this.setUnlocalizedName(name);
		this.setLightLevel(2f);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName().substring(5);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityComputer();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(LEVEL)).intValue();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{LEVEL});
	}
}
