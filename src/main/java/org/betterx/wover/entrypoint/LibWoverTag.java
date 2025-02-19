package org.betterx.wover.entrypoint;
//https://github.com/quiqueck/WorldWeaver/blob/1.21/wover-tag-api/src/main/java/org/betterx/wover/entrypoint/LibWoverTag.java

import org.betterx.wover.core.api.ModCore;
/*import org.betterx.wover.datagen.api.WoverDataGenEntryPoint;
import org.betterx.wover.datagen.impl.AutoBiomeTagProvider;
import org.betterx.wover.datagen.impl.AutoBlockTagProvider;
import org.betterx.wover.datagen.impl.AutoItemTagProvider;
import org.betterx.wover.events.api.WorldLifecycle;
import org.betterx.wover.tag.api.predefined.*;
import org.betterx.wover.tag.impl.TagBootstrapContextImpl;

import static org.betterx.wover.events.impl.AbstractEvent.SYSTEM_PRIORITY;*/

public class LibWoverTag /*implements ModInitializer*/ {
    public static final ModCore C = ModCore.create("wover-tag", "wover");

    /*@Override
    public void onInitialize() {
        WoverDataGenEntryPoint.registerAutoProvider(AutoBlockTagProvider::new);
        WoverDataGenEntryPoint.registerAutoProvider(AutoItemTagProvider::new);
        WoverDataGenEntryPoint.registerAutoProvider(AutoBiomeTagProvider::new);

        CommonBiomeTags.ensureStaticallyLoaded();
        CommonBlockTags.ensureStaticallyLoaded();
        CommonItemTags.ensureStaticallyLoaded();
        CommonPoiTags.ensureStaticallyLoaded();

        MineableTags.ensureStaticallyLoaded();
        ToolTags.ensureStaticallyLoaded();

        WorldLifecycle
                .BEFORE_LOADING_RESOURCES
                .subscribe((resourceManager, featureFlagSet) -> TagBootstrapContextImpl.invalidateCaches(), SYSTEM_PRIORITY);
    }*/
}