package xyz.cryptix.digital_resources.API.resources;

public enum ThermalResources {

    SIGNALUM("signalum", 0xce3912),
    LUMIUM("lumium", 0xe2b773),
    ENDERIUM("enderium", 0x16576c),
    TIN("tin", 0x698c97),
    LEAD("lead", 0x3a3e63),
    SILVER("silver", 0x687481),
    NICKEL("nickel", 0xa28861),
    BRONZE("bronze", 0xb36525),
    ELECTRUM("electrum", 0xc3b35f),
    INVAR("invar", 0x869a97),
    CONSTANTAN("constantan", 0xb37c3c),
    COAL_COKE("coal_coke", 0x34373a),
    APATITE("apatite", 0x2f8cad),
    NITER("niter", 0x99898d),
    SULFUR("sulfur", 0xd4c468),
    CINNABAR("cinnabar", 0x9a334b);

    private final String resource_name;
    private final int resource_color;

    ThermalResources(String pResourceName, int pColor) {
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
