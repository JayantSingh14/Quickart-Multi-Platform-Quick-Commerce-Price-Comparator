package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.devsupport.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ShakeDetector implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final c f18698a;

    /* renamed from: b, reason: collision with root package name */
    public float f18699b;

    /* renamed from: c, reason: collision with root package name */
    public float f18700c;

    /* renamed from: d, reason: collision with root package name */
    public float f18701d;

    /* renamed from: e, reason: collision with root package name */
    public SensorManager f18702e;

    /* renamed from: f, reason: collision with root package name */
    public long f18703f;

    /* renamed from: g, reason: collision with root package name */
    public int f18704g;

    /* renamed from: h, reason: collision with root package name */
    public long f18705h;

    @Metadata
    public interface ShakeListener {
    }

    public ShakeDetector(c shakeListener) {
        Intrinsics.checkNotNullParameter(shakeListener, "shakeListener");
        this.f18698a = shakeListener;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        long j2 = sensorEvent.timestamp;
        if (j2 - this.f18703f < ShakeDetectorKt.f18706a) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2] - 9.80665f;
        this.f18703f = j2;
        if ((Math.abs(f2) > 13.042845f) && this.f18699b * f2 <= 0.0f) {
            this.f18705h = sensorEvent.timestamp;
            this.f18704g++;
            this.f18699b = f2;
        } else if (Math.abs(f3) > 13.042845f && this.f18700c * f3 <= 0.0f) {
            this.f18705h = sensorEvent.timestamp;
            this.f18704g++;
            this.f18700c = f3;
        } else if (Math.abs(f4) > 13.042845f && this.f18701d * f4 <= 0.0f) {
            this.f18705h = sensorEvent.timestamp;
            this.f18704g++;
            this.f18701d = f4;
        }
        long j3 = sensorEvent.timestamp;
        if (this.f18704g >= 16) {
            this.f18704g = 0;
            this.f18699b = 0.0f;
            this.f18700c = 0.0f;
            this.f18701d = 0.0f;
            this.f18698a.f18924a.A();
        }
        if (j3 - this.f18705h > ShakeDetectorKt.f18707b) {
            this.f18704g = 0;
            this.f18699b = 0.0f;
            this.f18700c = 0.0f;
            this.f18701d = 0.0f;
        }
    }
}
