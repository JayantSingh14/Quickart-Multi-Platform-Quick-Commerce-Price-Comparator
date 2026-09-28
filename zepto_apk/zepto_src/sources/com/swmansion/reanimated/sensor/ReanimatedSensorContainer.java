package com.swmansion.reanimated.sensor;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ReanimatedSensorContainer {
    private final WeakReference<ReactApplicationContext> reactContext;
    private int nextSensorId = 0;
    private final HashMap<Integer, ReanimatedSensor> sensors = new HashMap<>();

    public ReanimatedSensorContainer(WeakReference<ReactApplicationContext> weakReference) {
        this.reactContext = weakReference;
    }

    public int registerSensor(ReanimatedSensorType reanimatedSensorType, int i2, SensorSetter sensorSetter) {
        ReanimatedSensor reanimatedSensor = new ReanimatedSensor(this.reactContext, reanimatedSensorType, i2, sensorSetter);
        if (!reanimatedSensor.initialize()) {
            return -1;
        }
        int i3 = this.nextSensorId;
        this.nextSensorId = i3 + 1;
        this.sensors.put(Integer.valueOf(i3), reanimatedSensor);
        return i3;
    }

    public void unregisterSensor(int i2) {
        ReanimatedSensor reanimatedSensor = this.sensors.get(Integer.valueOf(i2));
        if (reanimatedSensor == null) {
            Log.e("Reanimated", "Tried to unregister nonexistent sensor");
        } else {
            reanimatedSensor.cancel();
            this.sensors.remove(Integer.valueOf(i2));
        }
    }
}
