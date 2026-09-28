package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbrm implements zzcdx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrl f25481a;

    public zzbrm(zzbrq zzbrqVar, zzbrl zzbrlVar) {
        this.f25481a = zzbrlVar;
        Objects.requireNonNull(zzbrqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("Getting a new session for JS Engine.");
        this.f25481a.f25997a.b(((zzbqm) obj).zzl());
    }
}
