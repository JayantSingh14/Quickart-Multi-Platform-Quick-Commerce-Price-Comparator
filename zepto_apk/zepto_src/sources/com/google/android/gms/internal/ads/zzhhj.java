package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhhj {

    /* renamed from: a, reason: collision with root package name */
    public final zzhhk f33800a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f33801b;

    public zzhhj(zzhhk zzhhkVar, long[] jArr) {
        this.f33800a = zzhhkVar;
        this.f33801b = jArr;
    }

    public zzhhj() {
        zzhhj zzhhjVar = zzhhm.f33808b;
        this.f33800a = new zzhhk(zzhhjVar.f33800a);
        this.f33801b = Arrays.copyOf(zzhhjVar.f33801b, 10);
    }
}
