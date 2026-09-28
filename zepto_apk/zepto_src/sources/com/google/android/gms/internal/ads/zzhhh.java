package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
class zzhhh {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f33796a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f33797b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f33798c;

    public zzhhh(long[] jArr, long[] jArr2, long[] jArr3) {
        this.f33796a = jArr;
        this.f33797b = jArr2;
        this.f33798c = jArr3;
    }

    public void a(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    public final void b(zzhhh zzhhhVar, int i2) {
        zzhhg.a(i2, this.f33796a, zzhhhVar.f33796a);
        zzhhg.a(i2, this.f33797b, zzhhhVar.f33797b);
        zzhhg.a(i2, this.f33798c, zzhhhVar.f33798c);
    }

    public zzhhh() {
        zzhhh zzhhhVar = zzhhm.f33807a;
        this.f33796a = Arrays.copyOf(zzhhhVar.f33796a, 10);
        this.f33797b = Arrays.copyOf(zzhhhVar.f33797b, 10);
        this.f33798c = Arrays.copyOf(zzhhhVar.f33798c, 10);
    }
}
