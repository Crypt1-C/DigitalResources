package xyz.cryptix.digital_resources.API;

public enum UpgradeType {
    SPEED("speed"),
    STACK("stack"),
    ENERGY("energy");

    private final String upgrade_type;

    UpgradeType(String pType) {
        this.upgrade_type = pType;
    }

    public String getUpgradeName() {
        return upgrade_type;
    }
}
