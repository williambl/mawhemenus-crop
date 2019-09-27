package com.williambl.mawhemenuscrop;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = MawhemenusCrop.MODID, name = MawhemenusCrop.NAME, version = MawhemenusCrop.VERSION)
public class MawhemenusCrop
{
    public static final String MODID = "mawhemenuscrop";
    public static final String NAME = "Mawhemenus Crop";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @GameRegistry.ObjectHolder(MODID+":juicy_mawhemenus_fruit")
    public static Item FRUIT;

    @GameRegistry.ObjectHolder(MODID+":mawhemenus_bulb")
    public static Item BULB;

    @GameRegistry.ObjectHolder(MODID+":mawhemenus_crop")
    public static Block CROP;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @Mod.EventBusSubscriber
    public static class RegistryHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    nameItem(new ItemFood(2, false).setCreativeTab(CreativeTabs.FOOD), "juicy_mawhemenus_fruit"),
                    nameItem(new ItemSeeds(CROP, Blocks.FARMLAND), "mawhemenus_bulb")
            );
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                nameBlock(new BlockMawhemenusCrop(), "mawhemenus_crop")
            );
        }

        @SubscribeEvent
        public static void registerItemModels(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(BULB, 0, new ModelResourceLocation(BULB.getRegistryName(), ""));
            ModelLoader.setCustomModelResourceLocation(FRUIT, 0, new ModelResourceLocation(FRUIT.getRegistryName(), ""));
        }

        private static Item nameItem(Item itemIn, String name) {
            return itemIn.setRegistryName(name).setTranslationKey(itemIn.getRegistryName().toString().replace(":", "."));
        }

        private static Block nameBlock(Block blockIn, String name) {
            return blockIn.setRegistryName(name).setTranslationKey(blockIn.getRegistryName().toString().replace(":", "."));
        }
    }
}
