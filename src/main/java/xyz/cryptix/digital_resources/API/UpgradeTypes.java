package xyz.cryptix.digital_resources.API;

public enum UpgradeTypes {
    SPEED("speed"),
    STACK("stack"),
    ENERGY("energy");

    private final String upgrade_type;

    UpgradeTypes(String pType) {
        this.upgrade_type = pType;
    }

    public String getUpgradeType() {
        return upgrade_type;
    }
}
