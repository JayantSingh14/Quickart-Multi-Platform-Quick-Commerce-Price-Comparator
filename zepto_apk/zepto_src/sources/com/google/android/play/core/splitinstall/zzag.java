package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.internal.zzcb;

/* loaded from: classes4.dex */
public final class zzag implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzac f42094a;

    public zzag(zzac zzacVar) {
        this.f42094a = zzacVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        zzx zzxVarC = zzx.c(this.f42094a.f42090a);
        if (zzxVarC != null) {
            return zzxVarC;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
