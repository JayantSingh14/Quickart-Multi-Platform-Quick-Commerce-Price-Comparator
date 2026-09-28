package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes.dex */
public final class zzs implements zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final zzk f41742a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaf f41743b;

    public zzs(zzk zzkVar, zzaf zzafVar) {
        this.f41742a = zzkVar;
        this.f41743b = zzafVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        return new zzr(this.f41742a.f41724a.f41722a, (zzt) this.f41743b.zza());
    }
}
