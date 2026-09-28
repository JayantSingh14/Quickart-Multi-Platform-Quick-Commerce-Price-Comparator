package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzbso {

    /* renamed from: a, reason: collision with root package name */
    public final zzbrr f25528a;

    /* renamed from: b, reason: collision with root package name */
    public ListenableFuture f25529b;

    public zzbso(zzbrr zzbrrVar) {
        this.f25528a = zzbrrVar;
    }

    public final void a() {
        if (this.f25529b == null) {
            final zzcdt zzcdtVar = new zzcdt();
            this.f25529b = zzcdtVar;
            this.f25528a.b().a(new zzcdx() { // from class: com.google.android.gms.internal.ads.zzbsn
                @Override // com.google.android.gms.internal.ads.zzcdx
                public final /* synthetic */ void zza(Object obj) {
                    zzcdtVar.b((zzbrs) obj);
                }
            }, new zzcdv() { // from class: com.google.android.gms.internal.ads.zzbsk
                @Override // com.google.android.gms.internal.ads.zzcdv
                public final void zza() {
                    zzcdtVar.c(new zzbru("Cannot get Javascript Engine"));
                }
            });
        }
    }
}
