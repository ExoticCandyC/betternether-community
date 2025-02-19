package org.betterx.betternether.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

/*import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;*/

public class BNNetherBrick extends Block /*BlockBase.Stone*/ {
    public BNNetherBrick() {
        super(Blocks.NETHER_BRICKS.properties());
        /*super(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS));*/
    }
}