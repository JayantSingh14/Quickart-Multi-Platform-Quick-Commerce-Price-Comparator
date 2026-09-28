package com.zeptoconsumerapp.ShakeDetector;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import coil3.decode.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ShakeSensor implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final a f47540a;

    /* renamed from: b, reason: collision with root package name */
    public final SensorManager f47541b;

    /* renamed from: c, reason: collision with root package name */
    public final Sensor f47542c;

    /* renamed from: d, reason: collision with root package name */
    public long f47543d;

    @Metadata
    public static final class Companion {
    }

    public ShakeSensor(Context context, a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47540a = aVar;
        try {
            Object systemService = context.getSystemService("sensor");
            SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
            this.f47541b = sensorManager;
            this.f47542c = sensorManager != null ? sensorManager.getDefaultSensor(1) : null;
        } catch (Exception unused) {
        }
    }

    public final void a() {
        SensorManager sensorManager = this.f47541b;
        if (sensorManager == null || this.f47542c == null || sensorManager == null) {
            return;
        }
        try {
            sensorManager.unregisterListener(this);
        } catch (Exception unused) {
        }
    }

    public final void b() {
        Sensor sensor;
        SensorManager sensorManager = this.f47541b;
        if (sensorManager == null || (sensor = this.f47542c) == null || sensorManager == null) {
            return;
        }
        try {
            sensorManager.registerListener(this, sensor, 3);
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            float[] fArr = event.values;
            float f2 = fArr[0] / 9.80665f;
            float f3 = fArr[1] / 9.80665f;
            float f4 = fArr[2] / 9.80665f;
            if (Math.sqrt((f4 * f4) + (f3 * f3) + (f2 * f2)) > 2.700000047683716d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f47543d < 1000) {
                    return;
                }
                this.f47543d = jCurrentTimeMillis;
                this.f47540a.invoke();
            }
        } catch (Exception unused) {
        }
    }
}
