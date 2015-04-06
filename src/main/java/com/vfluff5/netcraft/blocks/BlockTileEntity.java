package com.vfluff5.netcraft.blocks;


import com.vfluff5.netcraft.gui.GuiRouter;
import com.vfluff5.netcraft.tileentities.TileEntityComputer;
import com.vfluff5.netcraft.tileentities.TileEntityRouter;
import com.vfluff5.netcraft.tileentities.TileEntitySwitch;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTileEntity extends BlockContainer {
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	String t;
	public BlockTileEntity(Material m, String name, boolean UseLight, CreativeTabs tab, String tileentity) {
		super(m);
		this.setHardness(2);
		this.setUnlocalizedName(name);
		if(UseLight)
		this.setLightLevel(2f);
		this.setCreativeTab(tab);
		t = tileentity;
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public boolean isFullCube()
	{
		return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	//@Override
	public int getRenderType()
	{
		return -1;
	}


	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName().substring(5);
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if(t.equals("computer"))
			return new TileEntityComputer();
		if(t.equals("router"))
			return new TileEntityRouter();
		if(t.equals("switch"))
			return new TileEntitySwitch();
		System.out.println("You're an idiot...");
		return null;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, FACING);
	}


	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(t.equals("router")) {

			Minecraft.getMinecraft().displayGuiScreen(new GuiRouter((TileEntityRouter) worldIn.getTileEntity(pos)));
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);

	}
}

