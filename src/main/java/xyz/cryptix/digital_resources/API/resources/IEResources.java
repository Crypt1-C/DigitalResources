package xyz.cryptix.digital_resources.API.resources;

public enum IEResources {

    ALUMINUM("aluminum", 0xa3a3a3),
    LEAD("lead", 0x3a3e63),
    SILVER("silver", 0x687481),
    NICKEL("nickel", 0xa28861),
    URANIUM("uranium", 0x639333),
    CONSTANTAN("constantan", 0xb37c3c),
    ELECTRUM("electrum", 0xc3b35f),
    STEEL("steel", 0x586672),
    COAL_COKE("coal_coke", 0x34373a);

    private final String resource_name;
    private final int resource_color;

    IEResources(String pResourceName, int pColor) {
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
