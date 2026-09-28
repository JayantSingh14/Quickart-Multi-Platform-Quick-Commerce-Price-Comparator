package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class ReanimatedSensor {
    private static final int DEFAULT_INTERVAL = 8;
    int interval;
    ReanimatedSensorListener listener;
    Sensor sensor;
    SensorManager sensorManager;
    ReanimatedSensorType sensorType;

    public ReanimatedSensor(WeakReference<ReactApplicationContext> weakReference, ReanimatedSensorType reanimatedSensorType, int i2, SensorSetter sensorSetter) {
        this.listener = new ReanimatedSensorListener(sensorSetter, i2, ((WindowManager) weakReference.get().getSystemService("window")).getDefaultDisplay());
        ReactApplicationContext reactApplicationContext = weakReference.get();
        weakReference.get();
        this.sensorManager = (SensorManager) reactApplicationContext.getSystemService("sensor");
        this.sensorType = reanimatedSensorType;
        if (i2 == -1) {
            this.interval = 8;
        } else {
            this.interval = i2;
        }
    }

    public void cancel() {
        this.sensorManager.unregisterListener(this.listener, this.sensor);
    }

    public boolean initialize() {
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(this.sensorType.getType());
        this.sensor = defaultSensor;
        if (defaultSensor == null) {
            return false;
        }
        this.sensorManager.registerListener(this.listener, defaultSensor, this.interval * 1000);
        return true;
    }
}
