package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes.dex */
public final class zzj implements zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final zzaf f41723a;

    public zzj(zzaf zzafVar) {
        this.f41723a = zzafVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        zzg zzgVar = (zzg) this.f41723a.zza();
        if (zzgVar != null) {
            return zzgVar;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
