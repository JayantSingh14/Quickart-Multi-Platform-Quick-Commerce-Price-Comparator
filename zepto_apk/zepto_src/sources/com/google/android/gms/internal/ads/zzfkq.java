package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfkq implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfkt f31327a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfkv f31328b;

    public zzfkq(zzfkv zzfkvVar, zzfkt zzfktVar) {
        this.f31327a = zzfktVar;
        Objects.requireNonNull(zzfkvVar);
        this.f31328b = zzfkvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfkv zzfkvVar = this.f31328b;
        synchronized (zzfkvVar) {
            zzfkvVar.f31335d = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        zzfkv zzfkvVar = this.f31328b;
        synchronized (zzfkvVar) {
            zzfkvVar.f31335d = null;
            zzfkvVar.f31334c.addFirst(this.f31327a);
            if (zzfkvVar.f31336e == 1) {
                zzfkvVar.a();
            }
        }
    }
}
