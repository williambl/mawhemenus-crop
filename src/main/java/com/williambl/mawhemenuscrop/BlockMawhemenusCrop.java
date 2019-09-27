package com.williambl.mawhemenuscrop;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMawhemenusCrop extends BlockCrops {

    private static final PropertyInteger MAWHEMENUS_AGE = PropertyInteger.create("age", 0, 3);
    private static final AxisAlignedBB[] MAWHEMENUS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};

    BlockMawhemenusCrop() {
        super();
    }

    @Override
    protected PropertyInteger getAgeProperty()
    {
        return MAWHEMENUS_AGE;
    }

    @Override
    public int getMaxAge()
    {
        return 3;
    }

    @Override
    protected Item getCrop() {
        return MawhemenusCrop.FRUIT;
    }

    @Override
    protected Item getSeed() {
        return MawhemenusCrop.BULB;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= getMaxAge())
        {
            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (rand.nextBoolean())
                {
                    drops.add(new ItemStack(this.getCrop(), 1, 0));
                }
            }
        }
        drops.add(new ItemStack(this.getSeed(), 1, 0));

        if (rand.nextDouble() < 0.05) {
            drops.add(new ItemStack(this.getSeed(), 1, 0));
        }
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 3;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, MAWHEMENUS_AGE);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MAWHEMENUS_AABB[state.getValue(this.getAgeProperty())];
    }
}
