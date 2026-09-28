package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzdun implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfzb f28599a;

    public zzdun(zzfzb zzfzbVar) {
        this.f28599a = zzfzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfzb zzfzbVar = this.f28599a;
        DataStore dataStore = (DataStore) zzfzbVar.f32084a.zzb();
        zzgyw executorService = zzcdo.f25982a;
        zzijo.a(executorService);
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        return new zzdum(new zzfza(dataStore, new zzfzd(executorService), (zzduo) zzfzbVar.f32085b.zzb(), new zzfyc()));
    }
}
