package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;

/* loaded from: classes4.dex */
public final class zzcj {

    /* renamed from: a, reason: collision with root package name */
    public static AudioManager f26362a;

    public static synchronized AudioManager a(Context context) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                f26362a = null;
            }
            AudioManager audioManager = f26362a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                final zzdq zzdqVar = new zzdq();
                zzdh.a().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzci
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcj.f26362a = (AudioManager) applicationContext.getSystemService("audio");
                        zzdqVar.a();
                    }
                });
                zzdqVar.b();
                AudioManager audioManager2 = f26362a;
                if (audioManager2 != null) {
                    return audioManager2;
                }
                throw null;
            }
            AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
            f26362a = audioManager3;
            if (audioManager3 != null) {
                return audioManager3;
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
