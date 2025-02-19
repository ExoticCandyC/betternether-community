package org.betterx.betternether.tab;

//https://github.com/quiqueck/BetterNether/blob/1.21/src/main/java/org/betterx/betternether/tab/BECreativeTabs.java

//import org.betterx.bclib.behaviours.interfaces.BehaviourPlantLike;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.betterx.betternether.BetterNether;
/*import org.betterx.betternether.blocks.complex.WillowMaterial;
import org.betterx.betternether.blocks.complex.slots.NetherSlots;*/
import org.betterx.betternether.registry.NetherBlocks;
import org.betterx.betternether.registry.NetherItems;
import org.betterx.wover.block.api.BlockRegistry;
/*import org.betterx.betternether.registry.NetherItems;
import org.betterx.wover.complex.api.equipment.ToolSlot;
import org.betterx.wover.tabs.api.CreativeTabs;*/

public class BECreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterNether.MOD_ID);

    // Creates a creative tab with the id "betterend:example_tab" for the example item, that is placed after the combat tab
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> NATURE_TAB;
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCK_TAB;
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM_TAB;

    public static void register(IEventBus modEventBus)
    {
        NATURE_TAB = CREATIVE_MODE_TABS.register("nature", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.betternether.nature"))
                .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .icon(() -> NetherItems.BLACK_APPLE.asItem().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    /*
                        .setPredicate(item -> BehaviourPlantLike.TAB_PREDICATE.contains(item)
                                || item == NetherItems.AGAVE_LEAF
                                || item == NetherItems.BLACK_APPLE
                                || item == NetherBlocks.MAGMA_FLOWER.asItem()
                                || item == NetherBlocks.MAT_RUBEUS.getBlockItem(NetherSlots.CONE)
                                || item == NetherBlocks.MAT_WILLOW.getBlockItem(WillowMaterial.BLOCK_TORCH))
                     */
                    output.accept(NetherItems.BLACK_APPLE);
                    output.accept(NetherItems.AGAVE_LEAF);
                }).build());

        BLOCK_TAB = CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.betternether.blocks"))
                .withTabsBefore(NATURE_TAB.getKey())
                .icon(() -> NetherBlocks.NETHER_BRICK_TILE_LARGE.asItem().getDefaultInstance()) //NetherBlocks.JUNGLE_GRASS
                .displayItems((parameters, output) -> {
                    NetherBlocks.getBlockRegistry().allBlockItems().forEach(output::accept);
                }).build());

        ITEM_TAB = CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.betternether.items"))
                .withTabsBefore(BLOCK_TAB.getKey())
                .icon(() -> NetherBlocks.NETHER_BRICK_TILE_LARGE.asItem().getDefaultInstance()) //NetherItems.FLAMING_RUBY_SET.get(ToolSlot.PICKAXE_SLOT)
                .displayItems((parameters, output) -> {
                    NetherItems.getItemRegistry().allItems().forEach(output::accept);
                }).build());

        CREATIVE_MODE_TABS.register(modEventBus);
    }
}