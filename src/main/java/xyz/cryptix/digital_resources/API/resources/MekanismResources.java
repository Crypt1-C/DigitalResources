package xyz.cryptix.digital_resources.API.resources;

public enum MekanismResources {

    BRONZE("bronze", 0xb36525),
    REFINED_OBSIDIAN("refined_obsidian", 0x6d5887),
    REFINED_GLOWSTONE("refined_glowstone", 0xdcc37f),
    STEEL("steel", 0x586672),
    OSMIUM("osmium", 0x9aa8b5),
    TIN("tin", 0x698c97),
    LEAD("lead", 0x3a3e63),
    URANIUM("uranium", 0x639333);

    private final String resource_name;
    private final int resource_color;

    MekanismResources(String pResourceName, int pColor) {
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
