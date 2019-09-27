package com.williambl.mawhemenuscrop;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MawhemenusCrop.MODID, name = MawhemenusCrop.NAME, version = MawhemenusCrop.VERSION)
public class MawhemenusCrop
{
    public static final String MODID = "mawhemenuscrop";
    public static final String NAME = "Mawhemenus Crop";
    public static final String VERSION = "1.0";

    private static Logger logger;

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
                    nameItem(new ItemFood(2, false).setCreativeTab(CreativeTabs.FOOD), "mawhemenus_fruit"),
                    nameItem(new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND), "mawhemenus_bulb")
            );
        }

        private static Item nameItem(Item itemIn, String name) {
            return itemIn.setRegistryName(name).setUnlocalizedName(itemIn.getRegistryName().toString().replace(":", "."));
        }
    }
}
