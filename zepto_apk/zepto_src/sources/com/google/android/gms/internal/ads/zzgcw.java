package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final /* synthetic */ class zzgcw implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgda f32280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f32281b;

    public /* synthetic */ zzgcw(zzgda zzgdaVar, int i2) {
        this.f32280a = zzgdaVar;
        this.f32281b = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        int i2 = this.f32281b - 1;
        zzgda zzgdaVar = this.f32280a;
        if (i2 == 1) {
            return (zzgct) zzgdaVar.f32290a.zzb();
        }
        if (i2 == 2) {
            return (zzgct) zzgdaVar.f32291b.zzb();
        }
        if (i2 == 3) {
            return (zzgct) zzgdaVar.f32292c.zzb();
        }
        zzgdaVar.getClass();
        throw new IllegalArgumentException();
    }
}
