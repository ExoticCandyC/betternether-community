package org.betterx.betternether.registry;

/*import org.betterx.bclib.BCLib;
import org.betterx.bclib.items.DebugDataItem;*/
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.neoforged.neoforge.registries.DeferredItem;
import org.betterx.betternether.BetterNether;
/*import org.betterx.betternether.blocks.BNBlockProperties.FoodShape;
import org.betterx.betternether.integrations.VanillaExcavatorsIntegration;
import org.betterx.betternether.integrations.VanillaHammersIntegration;
import org.betterx.betternether.items.ItemBlackApple;
import org.betterx.betternether.items.ItemBowlFood;
import org.betterx.betternether.items.complex.DiamondSet;
import org.betterx.betternether.items.complex.NetherSet;
import org.betterx.betternether.items.materials.BNArmorTiers;
import org.betterx.betternether.items.materials.BNToolMaterial;
import org.betterx.betternether.items.materials.BNToolTiers;
import org.betterx.betternether.loot.BNLoot;
import org.betterx.wover.complex.api.equipment.ArmorSlot;
import org.betterx.wover.complex.api.equipment.ToolSlot;*/
import org.betterx.betternether.items.ItemBowlFood;
import org.betterx.wover.item.api.ItemRegistry;
//import org.betterx.wover.state.api.WorldState;
//import org.betterx.wover.tag.api.predefined.CommonItemTags;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;

import java.util.stream.Stream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class NetherItems {

    public static DeferredItem<Item> registerBlackApple(String name)
    {
        return registerItem(name, defaultSettings().food(new FoodProperties.Builder()
                .nutrition(6).saturationModifier(0.5F)
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1), 1).build()));
    }

    public static final DeferredItem<Item> BLACK_APPLE = registerBlackApple("black_apple");

    //public static final Item STALAGNATE_BOWL = registerItem("stalagnate_bowl", new ItemBowlFood(null, FoodShape.NONE)); // https://github.com/quiqueck/BetterNether/blob/1.20.3/src/main/java/org/betterx/betternether/blocks/BNBlockProperties.java#L141
    /*public static final Item STALAGNATE_BOWL_WART = registerItem(
            "stalagnate_bowl_wart",
            new ItemBowlFood(
                    Foods.COOKED_CHICKEN,
                    FoodShape.WART
            )
    );
    public static final Item STALAGNATE_BOWL_MUSHROOM = registerItem(
            "stalagnate_bowl_mushroom",
            new ItemBowlFood(
                    Foods.MUSHROOM_STEW,
                    FoodShape.MUSHROOM
            )
    );
    public static final Item STALAGNATE_BOWL_APPLE = registerItem(
            "stalagnate_bowl_apple",
            new ItemBowlFood(Foods.APPLE, FoodShape.APPLE)
    );*/
    public static final DeferredItem<Item> HOOK_MUSHROOM_COOKED = registerFood("hook_mushroom_cooked", 4, 0.4F);

    public static final DeferredItem<Item> CINCINNASITE = registerItem("cincinnasite", defaultSettings());
    /*public static final Item CINCINNASITE_INGOT = registerItem("cincinnasite_ingot", new Item(defaultSettings()),
            CommonItemTags.IRON_INGOTS
    );*/
    public static final DeferredItem<Item> NETHER_RUBY = registerItem("nether_ruby", defaultSettings());

    /*public static final NetherSet CINCINNASITE_SET = new NetherSet(
            "cincinnasite",
            BNToolTiers.CINCINNASITE,
            BNArmorTiers.CINCINNASITE,
            true
    );


    public static final NetherSet NETHER_RUBY_SET = new NetherSet(
            "nether_ruby",
            BNToolTiers.NETHER_RUBY,
            BNArmorTiers.NETHER_RUBY,
            false
    );

    public static final DiamondSet CINCINNASITE_DIAMOND_SET = new DiamondSet(CINCINNASITE_SET);

    public static final NetherSet FLAMING_RUBY_SET = new NetherSet(
            "flaming_ruby",
            BNToolTiers.FLAMING_RUBY,
            BNArmorTiers.FLAMING_RUBY,
            false,
            NETHER_RUBY_SET
    );
    public static final Item CINCINNASITE_HAMMER = registerItem(
            "cincinnasite_hammer",
            VanillaHammersIntegration.makeHammer(
                    BNToolMaterial.CINCINNASITE,
                    4,
                    -2.0F
            )
    );
    public static final Item CINCINNASITE_HAMMER_DIAMOND = registerItem(
            "cincinnasite_hammer_diamond",
            VanillaHammersIntegration.makeHammer(
                    BNToolMaterial.CINCINNASITE_DIAMOND,
                    5,
                    -2.0F
            )
    );
    public static final Item NETHER_RUBY_HAMMER = registerItem(
            "nether_ruby_hammer",
            VanillaHammersIntegration.makeHammer(
                    BNToolMaterial.NETHER_RUBY,
                    5,
                    -2.0F
            )
    );

    public static final Item CINCINNASITE_EXCAVATOR = registerItem(
            "cincinnasite_excavator",
            VanillaExcavatorsIntegration.makeExcavator(
                    BNToolMaterial.CINCINNASITE,
                    4,
                    -1.6F
            )
    );
    public static final Item CINCINNASITE_EXCAVATOR_DIAMOND = registerItem(
            "cincinnasite_excavator_diamond",
            VanillaExcavatorsIntegration.makeExcavator(
                    BNToolMaterial.CINCINNASITE_DIAMOND,
                    5,
                    -2.0F
            )
    );
    public static final Item NETHER_RUBY_EXCAVATOR = registerItem(
            "nether_ruby_excavator",
            VanillaExcavatorsIntegration.makeExcavator(
                    BNToolMaterial.NETHER_RUBY,
                    5,
                    -2.0F
            )
    );*/

    public static final DeferredItem<Item> GLOWSTONE_PILE = registerItem("glowstone_pile", defaultSettings());
    public static final DeferredItem<Item> LAPIS_PILE = registerItem("lapis_pile", defaultSettings());

    public static final DeferredItem<Item> AGAVE_LEAF = registerItem("agave_leaf", defaultSettings());
    public static final DeferredItem<Item> AGAVE_MEDICINE  = registerMedicine("agave_medicine" , 40, 2, true);
    public static final DeferredItem<Item> HERBAL_MEDICINE = registerMedicine("herbal_medicine", 10, 5, true);

    private NetherItems() {
    }

    private static ItemRegistry ITEMS_REGISTRY;

    @NotNull
    public static ItemRegistry getItemRegistry() {
        if (ITEMS_REGISTRY == null) {
            ITEMS_REGISTRY = ItemRegistry.forMod(BetterNether.C);
        }
        return ITEMS_REGISTRY;
    }

    public static Stream<DeferredItem<? extends Item>> getModItems() {
        return getItemRegistry().allItems();
    }


    /*public static Item registerShears(String name, Item item) {
        if (item != Items.AIR) {
            return getItemRegistry().registerAsTool(name, item);
        }

        return item;
    }

    public static Item registerTool(String name, Item item, TagKey<Item>... tags) {
        if (item != Items.AIR) {
            getItemRegistry().registerAsTool(name, item, tags);
        }

        return item;
    }*/


    @SafeVarargs
    public static DeferredItem<Item> registerItem(String name, Item.Properties props, TagKey<Item>... tags)
    {
        return getItemRegistry().register(name, props, tags);
    }

    /*
    public static Item registerItem(String name, Item item, TagKey<Item>... tags) { //Ported V1, needs more
        if (item != Items.AIR) {
            getItemRegistry().register(name, item, tags);
        }
        return item;
    }
    */

    public static DeferredItem<Item> registerFood(String name, int hunger, float saturationMultiplier) {
        return registerItem(name, defaultSettings().food(new FoodProperties.Builder()
                .nutrition(hunger).saturationModifier(saturationMultiplier).build()));
    }

    public static DeferredItem<Item> registerMedicine(String name, int ticks, int power, boolean bowl) {
        if (bowl)
            return registerItem(name, defaultSettings().food(new FoodProperties.Builder().usingConvertsTo(Items.BOWL) //NetherItems.STALAGNATE_BOWL) !!!!!!!!!!!!!!!
                    .alwaysEdible().effect(new MobEffectInstance(MobEffects.REGENERATION, ticks, power), 1).build()));
        return registerItem(name, defaultSettings().food(new FoodProperties.Builder()
                .alwaysEdible().effect(new MobEffectInstance(MobEffects.REGENERATION, ticks, power), 1).build()));
    }

    public static Properties defaultSettings() {
        return new Item.Properties();
    }

    /*public static Properties createDefaultNetherArmorSettings(ArmorItem.Type type, int durability) {
        return NetherItems.defaultSettings().fireResistant().durability(type.getDurability(durability));
    }

    public static Item.Properties createDefaultNetherToolSettings(
            Tier material,
            float attackDamage,
            float attackSpeed
    ) {
        return NetherItems
                .defaultSettings()
                .fireResistant()
                .attributes(DiggerItem.createAttributes(material, attackDamage, attackSpeed));
    }

    public static Item.Properties createDefaultNetherSwordSettings(
            Tier material,
            float attackDamage,
            float attackSpeed
    ) {
        return NetherItems
                .defaultSettings()
                .fireResistant()
                .attributes(SwordItem.createAttributes(material, (int) attackDamage, attackSpeed));
    }

    public static Item makeEgg(String name, EntityType<? extends Mob> type, int background, int dots) {
        SpawnEggItem egg = new SpawnEggItem(type, background, dots, defaultSettings());
        return getItemRegistry().registerEgg(name, egg);
    }

    public static Item registerNetherItem(String name, Item item) {
        return getItemRegistry().register(name, item);
    }*/

    /*static {
        if (BCLib.isDevEnvironment()) {
            BetterNether.C.log.warn("Generating Debug Helpers");

            registerNetherItem(
                    "debug/city_loot",
                    DebugDataItem.forLootTable(BNLoot.CITY_LOOT, Items.IRON_INGOT)
            );
            registerNetherItem(
                    "debug/city_loot_common",
                    DebugDataItem.forLootTable(BNLoot.CITY_LOOT_COMMON, Items.GOLD_INGOT)
            );
            registerNetherItem(
                    "debug/city_loot_surprise",
                    DebugDataItem.forLootTable(BNLoot.CITY_LOOT_SURPRISE, Items.DIAMOND)
            );
            registerNetherItem(
                    "debug/wither_tower_loot",
                    DebugDataItem.forLootTable(BNLoot.WITHER_TOWER_LOOT, NetherItems.CINCINNASITE_INGOT)
            );
            registerNetherItem(
                    "debug/wither_tower_bonus_loot",
                    DebugDataItem.forLootTable(BNLoot.WITHER_TOWER_BONUS_LOOT, NetherItems.NETHER_RUBY)
            );

            registerNetherItem(
                    "debug/city_spawner",
                    DebugDataItem.forSpawner(NetherItems::buildCitySpawnerData, Items.SPECTRAL_ARROW)
            );
        }
    }*/

    /*private static CompoundTag buildItem(int count, Item item, ResourceKey<Enchantment>... enchantments) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        CompoundTag tag = new CompoundTag();
        tag.putString("id", id.toString());
        tag.putByte("Count", (byte) count);

        if (enchantments.length > 0 && WorldState.registryAccess() != null) {
            ListTag chants = new ListTag();
            final var enchReg = WorldState.registryAccess().registryOrThrow(Registries.ENCHANTMENT);
            tag.put("Enchantments", chants);
            for (ResourceKey<Enchantment> e : enchantments) {
                final var ench = enchReg.get(e);
                final var eTag = new CompoundTag();
                eTag.putInt("lvl", ench.getMaxLevel());
                eTag.putString("id", e.location().toString());
                chants.add(eTag);
            }
        }
        return tag;
    }*/

    @NotNull
    private static CompoundTag buildCitySpawnerData() {
        ListTag handItems = new ListTag();
        //handItems.add(buildItem(1, CINCINNASITE_DIAMOND_SET.get(ToolSlot.SWORD_SLOT)));
        //handItems.add(buildItem(1, Items.SHIELD));

        ListTag armorItems = new ListTag();
        /*armorItems.add(buildItem(
                1,
                CINCINNASITE_SET.get(ArmorSlot.BOOTS_SLOT),
                Enchantments.PROTECTION
        ));
        armorItems.add(buildItem(
                1,
                CINCINNASITE_SET.get(ArmorSlot.LEGGINGS_SLOT),
                Enchantments.PROTECTION
        ));
        armorItems.add(buildItem(
                1,
                CINCINNASITE_SET.get(ArmorSlot.CHESTPLATE_SLOT),
                Enchantments.PROTECTION,
                Enchantments.THORNS
        ));
        armorItems.add(buildItem(
                1,
                CINCINNASITE_SET.get(ArmorSlot.HELMET_SLOT),
                Enchantments.PROTECTION
        ));
        */

        ListTag handDropChance = new ListTag();
        handDropChance.add(FloatTag.valueOf(0));
        handDropChance.add(FloatTag.valueOf(0));

        ListTag armorDropChance = new ListTag();
        armorDropChance.add(FloatTag.valueOf(0));
        armorDropChance.add(FloatTag.valueOf(0));
        armorDropChance.add(FloatTag.valueOf(0));
        armorDropChance.add(FloatTag.valueOf(0));


        CompoundTag entity = new CompoundTag();
        entity.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(EntityType.WITHER_SKELETON).toString());
        entity.putBoolean("PersistenceRequired", true);
        entity.put("HandItems", handItems);
        entity.put("ArmorItems", armorItems);
        entity.put("HandDropChances", handDropChance);
        entity.put("ArmorDropChances", armorDropChance);

        CompoundTag skyLightLimit = new CompoundTag();
        skyLightLimit.putByte("max_inclusive", (byte) 13);

        CompoundTag blockLightLimit = new CompoundTag();
        skyLightLimit.putByte("max_inclusive", (byte) 13);

        CompoundTag customSpawnRules = new CompoundTag();
        customSpawnRules.put("sky_light_limit", skyLightLimit);
        customSpawnRules.put("block_light_limit", blockLightLimit);

        CompoundTag spawnData = new CompoundTag();
        spawnData.put("entity", entity);
        spawnData.put("custom_spawn_rules", customSpawnRules);

        CompoundTag root = new CompoundTag();
        root.putShort("SpawnRange", (short) 4);
        root.putShort("SpawnCount", (short) 8);
        root.putShort("MaxNearbyEntities", (short) 18);
        root.putShort("Delay", (short) 499);
        root.putShort("MinSpawnDelay", (short) 300);
        root.putShort("MaxSpawnDelay", (short) 1600);
        root.putShort("RequiredPlayerRange", (short) 20);
        root.put("SpawnData", spawnData);


        return root;
    }


    @ApiStatus.Internal
    public static void register() {
        //NO-OP
    }
}
