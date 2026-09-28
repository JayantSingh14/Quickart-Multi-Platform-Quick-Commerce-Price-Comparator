package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzny extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznz f39524e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzny(zznz zznzVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zznzVar);
        this.f39524e = zznzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zznz zznzVar = this.f39524e;
        zzob zzobVar = zznzVar.f39528d;
        zzobVar.g();
        zzib zzibVar = zzobVar.f39180a;
        zznzVar.a(zzibVar.f39094k.elapsedRealtime(), false, false);
        zzd zzdVar = zzibVar.n;
        zzib.i(zzdVar);
        zzdVar.j(zzibVar.f39094k.elapsedRealtime());
    }
}
