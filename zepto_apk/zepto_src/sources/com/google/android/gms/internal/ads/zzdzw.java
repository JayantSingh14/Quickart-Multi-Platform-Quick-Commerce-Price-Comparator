package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* loaded from: classes4.dex */
public final class zzdzw extends zzfxo {

    /* renamed from: a, reason: collision with root package name */
    public final SensorManager f28875a;

    /* renamed from: b, reason: collision with root package name */
    public final Sensor f28876b;

    /* renamed from: c, reason: collision with root package name */
    public float f28877c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public Float f28878d = Float.valueOf(0.0f);

    /* renamed from: e, reason: collision with root package name */
    public long f28879e = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name */
    public int f28880f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f28881g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f28882h = false;

    /* renamed from: i, reason: collision with root package name */
    public zzeak f28883i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f28884j = false;

    public zzdzw(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f28875a = sensorManager;
        if (sensorManager != null) {
            this.f28876b = sensorManager.getDefaultSensor(4);
        } else {
            this.f28876b = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final void a(SensorEvent sensorEvent) {
        zzbgb zzbgbVar = zzbgk.ja;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            long j2 = this.f28879e;
            zzbgb zzbgbVar2 = zzbgk.la;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (j2 + ((Integer) zzbgiVar.a(zzbgbVar2)).intValue() < jCurrentTimeMillis) {
                this.f28880f = 0;
                this.f28879e = jCurrentTimeMillis;
                this.f28881g = false;
                this.f28882h = false;
                this.f28877c = this.f28878d.floatValue();
            }
            float fFloatValue = this.f28878d.floatValue() + (sensorEvent.values[1] * 4.0f);
            this.f28878d = Float.valueOf(fFloatValue);
            float f2 = this.f28877c;
            zzbgb zzbgbVar3 = zzbgk.ka;
            if (fFloatValue > ((Float) zzbgiVar.a(zzbgbVar3)).floatValue() + f2) {
                this.f28877c = this.f28878d.floatValue();
                this.f28882h = true;
            } else if (this.f28878d.floatValue() < this.f28877c - ((Float) zzbgiVar.a(zzbgbVar3)).floatValue()) {
                this.f28877c = this.f28878d.floatValue();
                this.f28881g = true;
            }
            if (this.f28878d.isInfinite()) {
                this.f28878d = Float.valueOf(0.0f);
                this.f28877c = 0.0f;
            }
            if (this.f28881g && this.f28882h) {
                com.google.android.gms.ads.internal.util.zze.k("Flick detected.");
                this.f28879e = jCurrentTimeMillis;
                int i2 = this.f28880f + 1;
                this.f28880f = i2;
                this.f28881g = false;
                this.f28882h = false;
                zzeak zzeakVar = this.f28883i;
                if (zzeakVar == null || i2 != ((Integer) zzbgiVar.a(zzbgk.ma)).intValue()) {
                    return;
                }
                zzeakVar.e(new zzeai(), zzeaj.f28931c);
            }
        }
    }

    public final void b() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ja)).booleanValue()) {
                    if (!this.f28884j && (sensorManager = this.f28875a) != null && (sensor = this.f28876b) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.f28884j = true;
                        com.google.android.gms.ads.internal.util.zze.k("Listening for flick gestures.");
                    }
                    if (this.f28875a == null || this.f28876b == null) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Flick detection failed to initialize. Failed to obtain gyroscope.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
