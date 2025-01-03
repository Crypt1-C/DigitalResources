package xyz.cryptix.digital_resources.API.resources;

public enum VanillaResources {

    COAL("coal", 0x242225),
    COPPER("copper", 0xb65d3f),
    IRON("iron", 0x9c9c9c),
    GOLD("gold", 0xdcb343),
    DIAMOND("diamond", 0x55beb5),
    EMERALD("emerald", 0x2da74f),
    NETHERITE("netherite", 0x3f393b),
    AMETHYST("amethyst", 0x9371c0),
    GLOWSTONE("glowstone", 0xb47d44),
    QUARTZ("quartz", 0xbaada1),
    LAPIS("lapis", 0x2a53a8),
    CLAY("clay", 0x747a8b),
    REDSTONE("redstone", 0x7e0801);

    private final String resource_name;
    private final int resource_color;

    VanillaResources(String pResourceName, int pColor) {
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
