package com.google.android.gms.internal.ads;

import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
final class zzfrq extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfrs f31744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Timer f31745b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfrt f31746c;

    public zzfrq(zzfrt zzfrtVar, zzfrs zzfrsVar, Timer timer) {
        this.f31744a = zzfrsVar;
        this.f31745b = timer;
        Objects.requireNonNull(zzfrtVar);
        this.f31746c = zzfrtVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        zzfrt zzfrtVar = this.f31746c;
        zzfrtVar.getClass();
        int i2 = WebViewCompat.f12427a;
        if (!WebViewFeatureInternal.f12457k.d()) {
            throw WebViewFeatureInternal.a();
        }
        WebViewCompat.c(zzfrtVar.f31749b).f12463a.removeWebMessageListener("omidJsSessionService");
        zzcjn zzcjnVar = ((zzcjl) this.f31744a).f26408a;
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
        final zzcir zzcirVar = zzcjnVar.f26410a;
        Objects.requireNonNull(zzcirVar);
        zzfVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcji
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcirVar.destroy();
            }
        });
        this.f31745b.cancel();
    }
}
