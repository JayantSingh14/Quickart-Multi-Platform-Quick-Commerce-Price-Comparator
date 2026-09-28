package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

@RequiresApi
/* loaded from: classes4.dex */
final class zzzj {

    /* renamed from: a, reason: collision with root package name */
    public final Spatializer f35957a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35958b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f35959c;

    /* renamed from: d, reason: collision with root package name */
    public final Spatializer$OnSpatializerStateChangedListener f35960d;

    public zzzj(Context context, zzzu zzzuVar, Boolean bool) {
        AudioManager audioManagerA = context == null ? null : zzcj.a(context);
        if (audioManagerA == null || (bool != null && bool.booleanValue())) {
            this.f35957a = null;
            this.f35958b = false;
            this.f35959c = null;
            this.f35960d = null;
            return;
        }
        Spatializer spatializer = audioManagerA.getSpatializer();
        this.f35957a = spatializer;
        this.f35958b = spatializer.getImmersiveAudioLevel() != 0;
        zzzh zzzhVar = new zzzh(this, zzzuVar);
        this.f35960d = zzzhVar;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        final Handler handler = new Handler(looperMyLooper);
        this.f35959c = handler;
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzzi
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zzzhVar);
    }
}
