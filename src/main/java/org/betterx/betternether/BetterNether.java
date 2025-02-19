package org.betterx.betternether;

//import org.betterx.bclib.BCLib;
//import org.betterx.betternether.advancements.BNCriterion;
//import org.betterx.betternether.commands.CommandRegistry;
//import org.betterx.betternether.config.Config;
//import org.betterx.betternether.config.Configs;
//import org.betterx.betternether.loot.BNLoot;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.betterx.betternether.blocks.BNNetherBrick;
import org.betterx.betternether.registry.*;
//import org.betterx.betternether.registry.features.configured.NetherVegetation;
//import org.betterx.betternether.tab.BECreativeTabs;
//import org.betterx.betternether.world.BNWorldGenerator;
import org.betterx.betternether.tab.BECreativeTabs;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.core.api.ModCore;
//import org.betterx.wover.state.api.WorldConfig;


import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BetterNether.MOD_ID)
public class BetterNether
{
    public static final ModCore C = ModCore.create("betternether");
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "betternether";
    // Directly reference a slf4j logger
    @SuppressWarnings({"nousage", "unused"})
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public BetterNether(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        NetherBlocks.register();
        NetherItems.register();


        C.BlocksRegistry.register(modEventBus);
        C.ItemsRegistry.register(modEventBus);
        BECreativeTabs.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (BetterNether) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            final BlockRegistry blockRegistry = NetherBlocks.getBlockRegistry();
            blockRegistry.registerFlammables();
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
