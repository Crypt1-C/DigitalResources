package xyz.cryptix.digital_resources.API;

public enum DResource {

    COAL("coal", 0x242225, ResourceType.OTHER),
    COPPER("copper", 0xb65d3f, ResourceType.INGOT),
    IRON("iron", 0x9c9c9c, ResourceType.INGOT),
    GOLD("gold", 0xdcb343, ResourceType.INGOT),
    DIAMOND("diamond", 0x55beb5, ResourceType.GEM),
    EMERALD("emerald", 0x2da74f, ResourceType.GEM),
    NETHERITE("netherite", 0x3f393b, ResourceType.INGOT),
    AMETHYST("amethyst", 0x9371c0, ResourceType.CRYSTAL),
    GLOWSTONE("glowstone", 0xb47d44, ResourceType.DUST),
    QUARTZ("quartz", 0xbaada1, ResourceType.CRYSTAL),
    LAPIS("lapis", 0x2a53a8, ResourceType.CRYSTAL),
    ZINC("zinc", 0x72907f, ResourceType.INGOT),
    OSMIUM("osmium", 0x9aa8b5, ResourceType.INGOT),
    ALUMINUM("aluminum", 0xa3a3a3, ResourceType.INGOT),
    BRASS("brass", 0xb68958, ResourceType.INGOT),
    COAL_COKE("coal_coke", 0x34373a, ResourceType.OTHER),
    REFINED_GLOWSTONE("refined_glowstone", 0xdcc37f, ResourceType.INGOT),
    REFINED_OBSIDIAN("refined_obsidian", 0x6d5887, ResourceType.INGOT),
    BRONZE("bronze", 0xb36525, ResourceType.INGOT),
    CONSTANTAN("constantan", 0xb37c3c, ResourceType.INGOT),
    ELECTRUM("electrum", 0xc3b35f, ResourceType.INGOT),
    ENDERIUM("enderium", 0x16576c, ResourceType.INGOT),
    INVAR("invar", 0x869a97, ResourceType.INGOT),
    LEAD("lead", 0x3a3e63, ResourceType.INGOT),
    LUMIUM("lumium", 0xe2b773, ResourceType.INGOT),
    NICKEL("nickel", 0xa28861, ResourceType.INGOT),
    SIGNALUM("signalum", 0xce3912, ResourceType.INGOT),
    SILVER("silver", 0x687481, ResourceType.INGOT),
    TIN("tin", 0x698c97, ResourceType.INGOT),
    URANIUM("uranium", 0x639333, ResourceType.INGOT),
    CLAY("clay", 0x747a8b, ResourceType.OTHER),
    STEEL("steel", 0x586672, ResourceType.INGOT),
    APATITE("apatite", 0x2f8cad, ResourceType.CRYSTAL),
    NITER("niter", 0x99898d, ResourceType.CRYSTAL),
    SULFUR("sulfur", 0xd4c468, ResourceType.CRYSTAL),
    CINNABAR("cinnabar", 0x9a334b, ResourceType.CRYSTAL),
    REDSTONE("redstone", 0x7e0801, ResourceType.DUST),
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