package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzagk implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final long f23014a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzagm f23015b;

    public zzagk(zzagm zzagmVar, long j2) {
        Objects.requireNonNull(zzagmVar);
        this.f23015b = zzagmVar;
        this.f23014a = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzagm zzagmVar = this.f23015b;
        zzafp zzafpVarA = zzagmVar.f23026i[0].a(j2);
        int i2 = 1;
        while (true) {
            zzagp[] zzagpVarArr = zzagmVar.f23026i;
            if (i2 >= zzagpVarArr.length) {
                return zzafpVarA;
            }
            zzafp zzafpVarA2 = zzagpVarArr[i2].a(j2);
            if (zzafpVarA2.f22955a.f22961b < zzafpVarA.f22955a.f22961b) {
                zzafpVarA = zzafpVarA2;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23014a;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
