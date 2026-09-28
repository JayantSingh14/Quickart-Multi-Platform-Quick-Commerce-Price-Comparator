package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzfis implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcir f31230a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcra f31231b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfpi f31232c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzehu f31233d;

    public zzfis(zzcir zzcirVar, zzcra zzcraVar, zzfpi zzfpiVar, zzehu zzehuVar) {
        this.f31230a = zzcirVar;
        this.f31231b = zzcraVar;
        this.f31232c = zzfpiVar;
        this.f31233d = zzehuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzcra zzcraVar;
        String str = (String) obj;
        zzcir zzcirVar = this.f31230a;
        zzfhr zzfhrVarV = zzcirVar.v();
        if (zzfhrVarV != null && !zzfhrVarV.i0) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzfhrVarV.x0;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hb)).booleanValue() || (zzcraVar = this.f31231b) == null || !zzcra.b(str)) {
                this.f31232c.b(str, zzvVar, null, null);
                return;
            }
            zzfpi zzfpiVar = this.f31232c;
            Random random = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ListenableFuture listenableFutureG = zzgym.g(zzcraVar.c(str, zzcraVar.f26931d.f28591a, random), ((Integer) r1.f21153c.a(zzbgk.ub)).intValue(), TimeUnit.MILLISECONDS, zzcraVar.f26934g);
            listenableFutureG.q(new zzgyk(listenableFutureG, new zzcqt(zzcraVar, zzfpiVar, str, zzvVar)), zzcraVar.f26932e);
            return;
        }
        zzfhu zzfhuVarE = zzcirVar.e();
        if (zzfhuVarE == null) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("BufferingGmsgHandlers.getBufferingClickGmsgHandler", new IllegalArgumentException("Common configuration cannot be null"));
            return;
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
        boolean zI = zztVar.f21684h.i(zzcirVar.getContext());
        boolean z = false;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.T6)).booleanValue() && zzfhrVarV != null && zzfhrVarV.S;
        if (zzfhrVarV != null && zzfhrVarV.d0 != null) {
            z = true;
        }
        zzehw zzehwVar = new zzehw(jCurrentTimeMillis, zzfhuVarE.f31167b, str, (zI || z2 || z) ? 2 : 1);
        zzehu zzehuVar = this.f31233d;
        zzehuVar.getClass();
        zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
    }
}
