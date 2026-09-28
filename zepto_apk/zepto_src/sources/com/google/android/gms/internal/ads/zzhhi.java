package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhhi extends zzhhh {

    /* renamed from: d, reason: collision with root package name */
    public final long[] f33799d;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzhhi(zzhhl zzhhlVar) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        super(jArr, jArr2, jArr4);
        this.f33799d = jArr3;
        zzhhk zzhhkVar = zzhhlVar.f33805a;
        zzhht.a(jArr, zzhhkVar.f33803b, zzhhkVar.f33802a);
        zzhht.b(jArr2, zzhhkVar.f33803b, zzhhkVar.f33802a);
        System.arraycopy(zzhhkVar.f33804c, 0, jArr3, 0, 10);
        zzhht.e(jArr4, zzhhlVar.f33806b, zzhho.f33813b);
    }

    @Override // com.google.android.gms.internal.ads.zzhhh
    public final void a(long[] jArr, long[] jArr2) {
        zzhht.e(jArr, jArr2, this.f33799d);
    }
}
