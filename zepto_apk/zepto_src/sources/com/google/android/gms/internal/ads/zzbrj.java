package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbrj implements zzcdx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrl f25476a;

    public zzbrj(zzbrl zzbrlVar) {
        Objects.requireNonNull(zzbrlVar);
        this.f25476a = zzbrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("Releasing engine reference.");
        this.f25476a.f25479d.e();
    }
}
