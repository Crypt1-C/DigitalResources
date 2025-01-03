package xyz.cryptix.digital_resources.Common.item;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xyz.cryptix.digital_resources.API.DResource;
import xyz.cryptix.digital_resources.API.ResourceType;

import java.util.List;

public class ModuleItem extends Item implements ItemColor {
    private final DResource resource;
    private final ResourceType resource_type;

    public ModuleItem(List<ModuleItem> pList, DResource pResource, ResourceType pResourceType) {
        super(new Properties().stacksTo(1));
        this.resource = pResource;
        this.resource_type = pResourceType;
        pList.add(this);
    }

    public DResource getResource() {
        return this.resource;
    }

    public ResourceType getResourceType() {
        return this.resource_type;
    }

    public String getResourceName() {
        return this.resource != null ? this.resource.getResourceName() : "blank";
    }

    @Override
    public int getColor(ItemStack itemStack, int i) {
        return i != 1 ? -1 : this.resource.getResourceColor();
    }
}
