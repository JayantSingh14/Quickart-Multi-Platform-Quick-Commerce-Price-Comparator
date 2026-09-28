package com.google.android.gms.internal.ads;

import android.os.Looper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbqu implements zzbqm, zzbqk {

    /* renamed from: a, reason: collision with root package name */
    public zzcir f25440a;

    public static final void h(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.ads.internal.util.zze.k("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.k("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.f21608l.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.f("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final void A0(String str, zzbnn zzbnnVar) {
        zzcir zzcirVar = this.f25440a;
        if (zzcirVar != null) {
            zzcirVar.k0(str, new zzbqn(this, zzbnnVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void a(final String str) {
        com.google.android.gms.ads.internal.util.zze.k("invokeJavascript on adWebView from js");
        h(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcir zzcirVar = this.f25438a.f25440a;
                if (zzcirVar != null) {
                    zzcirVar.a(str);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final void x0(String str, zzbnn zzbnnVar) {
        zzcir zzcirVar = this.f25440a;
        if (zzcirVar != null) {
            zzcirVar.c0(str, new zzbqs(zzbnnVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqm
    public final void zzj() {
        zzcir zzcirVar = this.f25440a;
        if (zzcirVar != null) {
            zzcirVar.destroy();
            this.f25440a = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqm
    public final boolean zzk() {
        zzcir zzcirVar = this.f25440a;
        return zzcirVar == null || zzcirVar.n();
    }

    @Override // com.google.android.gms.internal.ads.zzbqm
    public final zzbrt zzl() {
        return new zzbrt(this);
    }
}
