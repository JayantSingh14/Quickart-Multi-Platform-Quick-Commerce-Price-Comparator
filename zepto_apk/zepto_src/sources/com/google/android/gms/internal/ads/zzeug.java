package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeug implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzfer f30343a;

    public zzeug(zzfer zzferVar) {
        this.f30343a = zzferVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzfer zzferVar = this.f30343a;
        if (zzferVar == null) {
            return zzgym.a(new zzeuf(null));
        }
        String str = zzferVar.f30986a;
        return Strings.isEmptyOrWhitespace(str) ? zzgym.a(new zzeuf(null)) : zzgym.a(new zzeuf(str));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 15;
    }
}
