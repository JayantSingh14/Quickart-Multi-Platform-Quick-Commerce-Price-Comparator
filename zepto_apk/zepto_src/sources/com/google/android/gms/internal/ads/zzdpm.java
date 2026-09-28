package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdpm implements zzdbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzdnm f28175a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdnq f28176b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f28177c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f28178d;

    public zzdpm(zzdnm zzdnmVar, zzdnq zzdnqVar, Executor executor, zzgyw zzgywVar) {
        this.f28175a = zzdnmVar;
        this.f28176b = zzdnqVar;
        this.f28177c = executor;
        this.f28178d = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        ListenableFuture listenableFuture;
        ListenableFuture listenableFuture2;
        zzcdt zzcdtVar;
        if (this.f28176b.f28042e) {
            zzdnm zzdnmVar = this.f28175a;
            zzejb zzejbVarK = zzdnmVar.k();
            if (zzejbVarK == null) {
                synchronized (zzdnmVar) {
                    listenableFuture = zzdnmVar.f28038m;
                }
                if (listenableFuture != null && ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c6)).booleanValue()) {
                    synchronized (zzdnmVar) {
                        listenableFuture2 = zzdnmVar.f28038m;
                    }
                    synchronized (zzdnmVar) {
                        zzcdtVar = zzdnmVar.n;
                    }
                    if (listenableFuture2 == null || zzcdtVar == null) {
                        return;
                    }
                    zzgxv zzgxvVar = new zzgxv(zzgtd.s(new ListenableFuture[]{listenableFuture2, zzcdtVar}), false);
                    zzgxvVar.q(new zzgyk(zzgxvVar, new zzdpk(this)), this.f28178d);
                    return;
                }
            }
            if (zzejbVarK != null) {
                zzcir zzcirVarJ = zzdnmVar.j();
                zzcir zzcirVarH = zzdnmVar.h();
                if (zzcirVarJ == null) {
                    zzcirVarJ = zzcirVarH == null ? null : zzcirVarH;
                }
                if (zzcirVarJ != null) {
                    this.f28177c.execute(new zzdpl(zzcirVarJ));
                }
            }
        }
    }
}
