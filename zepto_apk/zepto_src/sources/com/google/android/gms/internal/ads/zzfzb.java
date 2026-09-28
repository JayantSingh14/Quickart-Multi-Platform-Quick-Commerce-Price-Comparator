package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzfzb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32084a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32085b;

    public zzfzb(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f32084a = zzijfVar;
        this.f32085b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        DataStore dataStore = (DataStore) this.f32084a.zzb();
        zzgyw executorService = zzcdo.f25982a;
        zzijo.a(executorService);
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        return new zzfza(dataStore, new zzfzd(executorService), (zzduo) this.f32085b.zzb(), new zzfyc());
    }
}
