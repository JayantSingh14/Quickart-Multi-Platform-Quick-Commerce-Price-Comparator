package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.internal.zzcb;

/* loaded from: classes4.dex */
public final class zzah implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzcb f42095a;

    public zzah(zzcb zzcbVar) {
        this.f42095a = zzcbVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        zzl zzlVar = (zzl) this.f42095a.zza();
        if (zzlVar != null) {
            return zzlVar;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
