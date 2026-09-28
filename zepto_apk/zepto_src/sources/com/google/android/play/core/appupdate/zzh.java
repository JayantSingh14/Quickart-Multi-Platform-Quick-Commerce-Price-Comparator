package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes.dex */
public final class zzh implements zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final zzaf f41719a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaf f41720b;

    /* renamed from: c, reason: collision with root package name */
    public final zzk f41721c;

    public zzh(zzaf zzafVar, zzaf zzafVar2, zzk zzkVar) {
        this.f41719a = zzafVar;
        this.f41720b = zzafVar2;
        this.f41721c = zzkVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        return new zzg((zzr) this.f41719a.zza(), (zzc) this.f41720b.zza(), this.f41721c.f41724a.f41722a);
    }
}
