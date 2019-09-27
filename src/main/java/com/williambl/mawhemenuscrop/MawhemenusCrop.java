package com.williambl.mawhemenuscrop;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
}
