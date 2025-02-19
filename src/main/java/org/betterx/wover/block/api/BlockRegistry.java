package org.betterx.wover.block.api;
// https://github.com/quiqueck/WorldWeaver/blob/1.21/wover-block-api/src/main/java/org/betterx/wover/block/api/BlockRegistry.java

//import org.betterx.wover.block.impl.WoverBlockItemImpl;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.betterx.betternether.blocks.BNNetherBrick;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.item.api.ItemRegistry;
//import org.betterx.wover.loot.api.BlockLootProvider;
//import org.betterx.wover.loot.api.LootLookupProvider;
//import org.betterx.wover.loot.api.LootTableManager;
//import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;

//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public class BlockRegistry {
    private static final Map<ModCore, BlockRegistry> REGISTRIES = new HashMap<>();
    public final ModCore C;
    private final Map<ResourceLocation, DeferredBlock<? extends Block>> blocks = new HashMap<>();
    private Map<DeferredBlock<? extends Block>, TagKey<Block>[]> datagenTags;
    private final ItemRegistry itemRegistry;

    private BlockRegistry(ModCore modeCore) {
        this.C = modeCore;
        this.itemRegistry = ItemRegistry.forMod(modeCore);

        if (ModCore.isDatagen()) {
            datagenTags = new HashMap<>();
        }
    }

    public static Stream<BlockRegistry> streamAll() {
        return REGISTRIES.values().stream();
    }

    public static BlockRegistry forMod(ModCore modCore) {
        return REGISTRIES.computeIfAbsent(modCore, c -> new BlockRegistry(modCore));
    }

    public Stream<DeferredBlock<? extends Block>> allBlocks() {
        return blocks.values().stream();
    }

    public Stream<BlockItem> allBlockItems() {
        return blocks
                .values()
                .stream()
                .filter(block -> block.asItem() instanceof BlockItem)
                .map(block -> (BlockItem) block.asItem());
    }

    @SafeVarargs
    public final <B extends Block> DeferredBlock<B> register(String path, Supplier<? extends B> blockSupplier, TagKey<Block>... tags) {
        return register(path, blockSupplier, tags, null);
    }

    public void registerFlammables()
    {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        blocks.values().forEach(deferredBlock -> {
            if (deferredBlock.get().defaultBlockState().ignitedByLava())
                fireBlock.setFlammable(deferredBlock.get(), 5, 5);
        });
    }

    public <B extends Block> DeferredBlock<B> register(String path, Supplier<? extends B> blockSupplier, TagKey<Block>[] tags, TagKey<Item>[] itemTags) {
        DeferredBlock<B> dBlock = null;
        if (blockSupplier != null) {
            dBlock = tags == null
                    ? _registerBlockOnly(path, blockSupplier)
                    : _registerBlockOnly(path, blockSupplier, tags);


            if (itemTags == null)
                registerBlockItem(path, dBlock);
            else
                registerBlockItem(path, dBlock, itemTags);
        }
        return dBlock;
    }

    @SafeVarargs
    private <B extends Block> DeferredBlock<B> _registerBlockOnly(String path, Supplier<? extends B> blockSupplier, TagKey<Block>... tags)
    {
        ResourceLocation id = C.mk(path);
        DeferredBlock<B> dBlock = C.BlocksRegistry.register(path, blockSupplier); //Registry.register(BuiltInRegistries.BLOCK, id, blockSupplier);
        blocks.put(id, dBlock);

        if (datagenTags != null && tags != null && tags.length > 0) datagenTags.put(dBlock, tags);
        return dBlock;
    }

    @SafeVarargs
    public final <B extends Block> DeferredBlock<B> registerBlockOnly(String path, Supplier<? extends B> blockSupplier, TagKey<Block>... tags) {
        return _registerBlockOnly(path, blockSupplier, tags);
    }

    @SafeVarargs
    private <B extends Block> void registerBlockItem(String path, DeferredBlock<B> dBlock, TagKey<Item>... tags) {
        this.itemRegistry.register(path, dBlock, tags);
    }

    protected Item.Properties defaultBlockItemSettings() {
        return new Item.Properties();
    }

    /*public void bootstrapBlockTags(TagBootstrapContext<Block> ctx) {
        if (datagenTags != null) {
            datagenTags.forEach(ctx::add);
        }

        blocks
                .entrySet()
                .stream()
                .filter(b -> b.getValue() instanceof BlockTagProvider)
                .forEach(b -> ((BlockTagProvider) b.getValue()).registerBlockTags(b.getKey(), ctx));
    }*/

    /*public void bootstrapBlockLoot(
            @NotNull HolderLookup.Provider lookup,
            @NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer
    ) {
        LootLookupProvider provider = new LootLookupProvider(lookup);
        blocks
                .entrySet()
                .stream()
                .filter(b -> b.getValue() instanceof BlockLootProvider)
                .forEach(b -> {
                    var key = LootTableManager.getBlockLootTableKey(C, b.getKey());
                    var builder = ((BlockLootProvider) b.getValue()).registerBlockLoot(b.getKey(), provider, key);

                    if (builder != null)
                        biConsumer.accept(key, builder);
                });
    }*/
}