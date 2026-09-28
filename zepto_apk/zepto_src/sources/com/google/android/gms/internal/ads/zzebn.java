package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* loaded from: classes4.dex */
public final class zzebn extends zzfxo {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29012a;

    /* renamed from: b, reason: collision with root package name */
    public SensorManager f29013b;

    /* renamed from: c, reason: collision with root package name */
    public Sensor f29014c;

    /* renamed from: d, reason: collision with root package name */
    public long f29015d;

    /* renamed from: e, reason: collision with root package name */
    public int f29016e;

    /* renamed from: f, reason: collision with root package name */
    public zzeak f29017f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f29018g;

    public zzebn(Context context) {
        this.f29012a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final void a(SensorEvent sensorEvent) {
        zzbgb zzbgbVar = zzbgk.ea;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0] / 9.80665f;
            float f3 = fArr[1] / 9.80665f;
            float f4 = fArr[2] / 9.80665f;
            float f5 = f4 * f4;
            float fSqrt = (float) Math.sqrt(f5 + (f3 * f3) + (f2 * f2));
            zzbgb zzbgbVar2 = zzbgk.fa;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (fSqrt >= ((Float) zzbgiVar.a(zzbgbVar2)).floatValue()) {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                if (this.f29015d + ((Integer) zzbgiVar.a(zzbgk.ga)).intValue() <= jCurrentTimeMillis) {
                    if (this.f29015d + ((Integer) zzbgiVar.a(zzbgk.ha)).intValue() < jCurrentTimeMillis) {
                        this.f29016e = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.k("Shake detected.");
                    this.f29015d = jCurrentTimeMillis;
                    int i2 = this.f29016e + 1;
                    this.f29016e = i2;
                    zzeak zzeakVar = this.f29017f;
                    if (zzeakVar == null || i2 != ((Integer) zzbgiVar.a(zzbgk.ia)).intValue()) {
                        return;
                    }
                    zzeakVar.e(new zzeah(), zzeaj.f28931c);
                }
            }
        }
    }

    public final void b() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ea)).booleanValue()) {
                    if (this.f29013b == null) {
                        SensorManager sensorManager2 = (SensorManager) this.f29012a.getSystemService("sensor");
                        this.f29013b = sensorManager2;
                        if (sensorManager2 == null) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.f("Shake detection failed to initialize. Failed to obtain accelerometer.");
                            return;
                        }
                        this.f29014c = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.f29018g && (sensorManager = this.f29013b) != null && (sensor = this.f29014c) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.f29015d = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - ((Integer) r1.f21153c.a(zzbgk.ga)).intValue();
                        this.f29018g = true;
                        com.google.android.gms.ads.internal.util.zze.k("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
