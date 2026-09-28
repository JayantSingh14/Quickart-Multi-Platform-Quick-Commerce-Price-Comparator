package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdsh implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f28416a;

    public zzdsh(zzdsp zzdspVar, Map map) {
        this.f28416a = map;
        Objects.requireNonNull(zzdspVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcir) obj).g("sendMessageToNativeJs", this.f28416a);
    }
}
