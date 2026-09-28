package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;

/* loaded from: classes4.dex */
public final class zzaa {

    /* renamed from: c, reason: collision with root package name */
    public static volatile float f21453c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public static volatile long f21454d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f21455e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f21456a = false;

    /* renamed from: b, reason: collision with root package name */
    public float f21457b = 1.0f;

    public static float b(Context context) {
        zzbgb zzbgbVar = zzbgk.mf;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        float f2 = 0.0f;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return 0.0f;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            if (streamMaxVolume == 0) {
                return 0.0f;
            }
            return streamVolume / streamMaxVolume;
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
        long jIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.nf)).intValue();
        if (f21453c != -1.0f && jCurrentTimeMillis - f21454d < jIntValue) {
            return f21453c;
        }
        synchronized (f21455e) {
            try {
                long jCurrentTimeMillis2 = zztVar.f21687k.currentTimeMillis();
                if (f21453c != -1.0f && jCurrentTimeMillis2 - f21454d < jIntValue) {
                    return f21453c;
                }
                AudioManager audioManager2 = (AudioManager) context.getSystemService("audio");
                if (audioManager2 == null) {
                    f21453c = 0.0f;
                    f21454d = jCurrentTimeMillis2;
                    return 0.0f;
                }
                int streamMaxVolume2 = audioManager2.getStreamMaxVolume(3);
                int streamVolume2 = audioManager2.getStreamVolume(3);
                if (streamMaxVolume2 != 0) {
                    f2 = streamVolume2 / streamMaxVolume2;
                }
                f21453c = f2;
                f21454d = jCurrentTimeMillis2;
                return f21453c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized float a() {
        synchronized (this) {
            float f2 = this.f21457b;
            if (f2 >= 0.0f) {
                return f2;
            }
            return 1.0f;
        }
    }
}
