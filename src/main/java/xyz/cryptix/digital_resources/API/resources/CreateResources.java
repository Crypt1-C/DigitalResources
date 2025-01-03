package xyz.cryptix.digital_resources.API.resources;

public enum CreateResources {

    ZINC("zinc", 0x72907f),
    BRASS("brass", 0xb68958),
    ANDESITE_ALLOY("andesite_alloy", 0x81897f);

    private final String resource_name;
    private final int resource_color;

    CreateResources(String pResourceName, int pColor) {
        this.resource_name = pResourceName;
        this.resource_color = pColor;
    }

    public int getResourceColor() {
        return this.resource_color;
    }

    public String getResourceName() {
        return resource_name;
    }

}
