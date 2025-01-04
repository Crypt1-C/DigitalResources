package xyz.cryptix.digital_resources.Common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import xyz.cryptix.digital_resources.API.UpgradeType;
import xyz.cryptix.digital_resources.Util.DRPropreties;
import xyz.cryptix.digital_resources.Util.DRStyles;

import java.util.List;

public class UpgradeItem extends Item {

    private final UpgradeType upgrade_type;

    public UpgradeItem(List<Item> pList, UpgradeType pUpgradeType) {
        super(DRPropreties.MISC_PROPRETIES.stacksTo(16));
        this.upgrade_type = pUpgradeType;
        pList.add(this);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if (Screen.hasShiftDown()) {
            if (this.upgrade_type != null) {
                pTooltipComponents.add(Component.translatable(String.format("item.upgrade.%s.tooltip", this.upgrade_type.getUpgradeName())).withStyle(ChatFormatting.GRAY));
            } else {
                pTooltipComponents.add(Component.translatable("item.upgrade.blank.tooltip").withStyle(ChatFormatting.GRAY));
            }
        } else {
            pTooltipComponents.add(Component.translatable("item.tooltip.shift").withStyle(DRStyles.PURPLE));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public UpgradeType getUpgradeType() {
        return this.upgrade_type;
    }

    public String getUpgradeName() {
        return this.upgrade_type != null ? upgrade_type.getUpgradeName() : "";
    }

}
