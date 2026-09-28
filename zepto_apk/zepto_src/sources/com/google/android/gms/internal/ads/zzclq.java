package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzclq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcli f26521a;

    public zzclq(zzcli zzcliVar) {
        this.f26521a = zzcliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        WeakReference weakReference = this.f26521a.f26512d;
        zzijo.a(weakReference);
        return weakReference;
    }
}
