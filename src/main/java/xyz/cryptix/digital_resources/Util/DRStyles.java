package xyz.cryptix.digital_resources.Util;

import net.minecraft.network.chat.Style;

public class DRStyles {
    public static final Style PURPLE = customStyle(0x7e23a8);

    public static final Style GOLD = customStyle(0xf79e02);

    public static final Style LIME = customStyle(0x9df702);

    public static Style customStyle(int pColor) {
        return Style.EMPTY.withColor(pColor);
    }
}
