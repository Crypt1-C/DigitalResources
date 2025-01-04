package xyz.cryptix.digital_resources.Common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.text.WordUtils;
import org.jetbrains.annotations.Nullable;
import xyz.cryptix.digital_resources.API.DResource;
import xyz.cryptix.digital_resources.API.ResourceType;
import xyz.cryptix.digital_resources.Util.DRStyles;

import java.util.List;
import java.util.Optional;

public class ProgramItem extends Item implements ItemColor {
    private final DResource resource;

    public ProgramItem(List<ProgramItem> pList, DResource pResource) {
        super(new Properties().stacksTo(1));
        this.resource = pResource;
        pList.add(this);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            if (this.resource != null) {
                pTooltipComponents.add(Component.translatable("item.program.tooltip").withStyle(ChatFormatting.GRAY).append(Component.literal(String.format("[%s.exe]", this.resource.getResourceName())).withStyle(Style.EMPTY.withColor(this.resource.getResourceColor()))));
            } else {
                pTooltipComponents.add(Component.translatable("item.program.blank.tooltip").withStyle(ChatFormatting.GRAY));
            }
        } else {
            pTooltipComponents.add(Component.translatable("item.tooltip.shift").withStyle(DRStyles.PURPLE));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public DResource getResource() {
        return this.resource;
    }

    public ResourceType getResourceType() {
        return this.resource.getResourceType();
    }

    public String getResourceName() {
        return this.resource != null ? this.resource.getResourceName() : "uninitialized";
    }

    @Override
    public int getColor(ItemStack itemStack, int i) {
        if (this.resource != null) {
            return i != 1 ? -1 : this.resource.getResourceColor();
        } else {
            return -1;
        }
    }
}
