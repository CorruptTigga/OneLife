package com.doitbetter.onelife.component;

public enum ComponentQuality {
    ROUGH(1),
    STANDARD(2),
    FINE(3),
    SUPERIOR(4),
    MASTERWORK(5);

    private final int level;

    ComponentQuality(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}