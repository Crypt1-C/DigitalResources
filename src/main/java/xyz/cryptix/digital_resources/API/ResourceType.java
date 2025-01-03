package xyz.cryptix.digital_resources.API;

public enum ResourceType {
    INGOT,
    GEM,
    DUST,
    CRYSTAL,
    OTHER;

    public String getName() {
        return super.toString().toLowerCase();
    }
}
