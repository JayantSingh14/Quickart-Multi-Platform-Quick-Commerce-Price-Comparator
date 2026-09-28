package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzedn implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f29144a;

    public zzedn(Context context) {
        this.f29144a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        if (((Boolean) zzbic.f25128h.c()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            zzbfv.a(this.f29144a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbic.f25130j.c()).booleanValue()) {
            zzbfv.a(this.f29144a);
        }
    }
}
