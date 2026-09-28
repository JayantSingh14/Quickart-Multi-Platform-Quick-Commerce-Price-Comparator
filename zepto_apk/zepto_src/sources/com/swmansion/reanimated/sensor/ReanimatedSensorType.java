package com.swmansion.reanimated.sensor;

/* loaded from: classes4.dex */
public enum ReanimatedSensorType {
    ACCELEROMETER(10),
    GYROSCOPE(4),
    GRAVITY(9),
    MAGNETIC_FIELD(2),
    ROTATION_VECTOR(11);

    private final int type;

    ReanimatedSensorType(int i2) {
        this.type = i2;
    }

    public static ReanimatedSensorType getInstanceById(int i2) {
        if (i2 == 1) {
            return ACCELEROMETER;
        }
        if (i2 == 2) {
            return GYROSCOPE;
        }
        if (i2 == 3) {
            return GRAVITY;
        }
        if (i2 == 4) {
            return MAGNETIC_FIELD;
        }
        if (i2 == 5) {
            return ROTATION_VECTOR;
        }
        throw new IllegalArgumentException("[Reanimated] Unknown sensor type.");
    }

    public int getType() {
        return this.type;
    }
}
