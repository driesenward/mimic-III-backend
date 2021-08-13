package com.driesen.ward.mimic.domain.model.calculations;

/***
 * AgeGroup Enum Object.
 *
 * For each enum value we have a certain age group specified.
 */
public enum AgeGroup {
    TEENS ("16 - 20"),
    TWENTIES ("20 - 30"),
    THIRTIES ("30 - 40"),
    FORTIES ("40 - 50"),
    FIFTIES ("50 - 60"),
    SIXTIES ("60 - 70"),
    SEVENTIES ("70 - 80"),
    EIGHTIES ("80 - 90"),
    NINETIES ("90 - ...");

    private final String name;

    AgeGroup(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
