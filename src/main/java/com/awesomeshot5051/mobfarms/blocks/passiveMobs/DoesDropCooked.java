package com.awesomeshot5051.mobfarms.blocks.passiveMobs;

import com.awesomeshot5051.mobfarms.Main;
import net.neoforged.neoforge.common.ModConfigSpec;

public class DoesDropCooked {
    public static final ModConfigSpec.BooleanValue dropsCookedMeat = DoesDropCooked.getDoesDropCooked();
    public static ModConfigSpec.BooleanValue getDoesDropCooked(){
        return Main.SERVER_CONFIG.dropsCookedMeat;
    }
}
