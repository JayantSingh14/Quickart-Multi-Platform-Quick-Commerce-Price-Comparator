package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import com.swmansion.reanimated.nativeProxy.SensorSetter;

/* loaded from: classes4.dex */
public class ReanimatedSensorListener implements SensorEventListener {
    private final Display display;
    private final double interval;
    private SensorSetter setter;
    private double lastRead = System.currentTimeMillis();
    private float[] rotation = new float[9];
    private float[] orientation = new float[3];
    private float[] quaternion = new float[4];

    public ReanimatedSensorListener(SensorSetter sensorSetter, double d2, Display display) {
        this.setter = sensorSetter;
        this.interval = d2;
        this.display = display;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double dCurrentTimeMillis = System.currentTimeMillis();
        if (dCurrentTimeMillis - this.lastRead < this.interval) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        this.lastRead = dCurrentTimeMillis;
        int rotation = this.display.getRotation();
        int i2 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
        if (type == 2 || type == 4) {
            float[] fArr = sensorEvent.values;
            this.setter.sensorSetter(new float[]{fArr[0], fArr[1], fArr[2]}, i2);
            return;
        }
        switch (type) {
            case 9:
            case 10:
                float[] fArr2 = sensorEvent.values;
                this.setter.sensorSetter(new float[]{-fArr2[0], -fArr2[1], -fArr2[2]}, i2);
                return;
            case 11:
                SensorManager.getQuaternionFromVector(this.quaternion, sensorEvent.values);
                SensorManager.getRotationMatrixFromVector(this.rotation, sensorEvent.values);
                SensorManager.getOrientation(this.rotation, this.orientation);
                float[] fArr3 = this.quaternion;
                float f2 = fArr3[1];
                float f3 = fArr3[3];
                float f4 = -fArr3[2];
                float f5 = fArr3[0];
                float[] fArr4 = this.orientation;
                this.setter.sensorSetter(new float[]{f2, f3, f4, f5, -fArr4[0], -fArr4[1], fArr4[2]}, i2);
                return;
            default:
                throw new IllegalArgumentException("[Reanimated] Unknown sensor type.");
        }
    }
}
