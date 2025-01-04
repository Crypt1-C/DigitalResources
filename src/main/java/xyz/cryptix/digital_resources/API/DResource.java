package xyz.cryptix.digital_resources.API;

public enum DResource {

    COAL("coal", 0x242225, ResourceType.OTHER),
    COPPER("copper", 0xdc4a19, ResourceType.INGOT),
    IRON("iron", 0xe8e8e8, ResourceType.INGOT),
    GOLD("gold", 0xf1bd2e, ResourceType.INGOT),
    DIAMOND("diamond", 0x2ee5d5, ResourceType.GEM),
    EMERALD("emerald", 0x12c243, ResourceType.GEM),
    NETHERITE("netherite", 0x3f393b, ResourceType.INGOT),
    AMETHYST("amethyst", 0x8e4be6, ResourceType.CRYSTAL),
    GLOWSTONE("glowstone", 0xdd7e1b, ResourceType.DUST),
    QUARTZ("quartz", 0xf2e4d8, ResourceType.CRYSTAL),
    LAPIS("lapis", 0x114ac1, ResourceType.CRYSTAL),
    ZINC("zinc", 0x72907f, ResourceType.INGOT),
    OSMIUM("osmium", 0x6eaae1, ResourceType.INGOT),
    ALUMINUM("aluminum", 0xa3a3a3, ResourceType.INGOT),
    BRASS("brass", 0xedb158, ResourceType.INGOT),
    COAL_COKE("coal_coke", 0x34373a, ResourceType.OTHER),
    REFINED_GLOWSTONE("refined_glowstone", 0xf1cd6a, ResourceType.INGOT),
    REFINED_OBSIDIAN("refined_obsidian", 0x6d5887, ResourceType.INGOT),
    BRONZE("bronze", 0xb36525, ResourceType.INGOT),
    CONSTANTAN("constantan", 0xb37c3c, ResourceType.INGOT),
    ELECTRUM("electrum", 0xc3b35f, ResourceType.INGOT),
    ENDERIUM("enderium", 0x095e79, ResourceType.INGOT),
    INVAR("invar", 0x869a97, ResourceType.INGOT),
    LEAD("lead", 0x3a3e63, ResourceType.INGOT),
    LUMIUM("lumium", 0xe2b773, ResourceType.INGOT),
    NICKEL("nickel", 0xa28861, ResourceType.INGOT),
    SIGNALUM("signalum", 0xd93307, ResourceType.INGOT),
    SILVER("silver", 0x687481, ResourceType.INGOT),
    TIN("tin", 0x698c97, ResourceType.INGOT),
    URANIUM("uranium", 0x63be08, ResourceType.INGOT),
    CLAY("clay", 0x747a8b, ResourceType.OTHER),
    STEEL("steel", 0x586672, ResourceType.INGOT),
    APATITE("apatite", 0x1399c9, ResourceType.CRYSTAL),
    NITER("niter", 0x99898d, ResourceType.CRYSTAL),
    SULFUR("sulfur", 0xeed64e, ResourceType.CRYSTAL),
    CINNABAR("cinnabar", 0xb9143b, ResourceType.CRYSTAL),
    REDSTONE("redstone", 0xc40a00, ResourceType.DUST),
    ANDESITE_ALLOY("andesite_alloy", 0x81897f, ResourceType.INGOT);

    private final String resource_name;
    private final int resource_color;
    private final ResourceType resource_type;

    DResource(String pResourceName, int pColor, ResourceType pResourceType) {
        this.resource_name = pResourceName;
        this.resource_color = pColor;
        this.resource_type = pResourceType;
    }

    public int getResourceColor() {
        return resource_color;
    }

    public String getResourceName() {
        return resource_name;
    }

    public ResourceType getResourceType() {
        return resource_type;
    }
}