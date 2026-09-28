package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhhl {

    /* renamed from: a, reason: collision with root package name */
    public final zzhhk f33805a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f33806b;

    public zzhhl(zzhhk zzhhkVar, long[] jArr) {
        this.f33805a = zzhhkVar;
        this.f33806b = jArr;
    }

    public static void a(zzhhl zzhhlVar, zzhhj zzhhjVar) {
        zzhhk zzhhkVar = zzhhlVar.f33805a;
        long[] jArr = zzhhkVar.f33802a;
        zzhhk zzhhkVar2 = zzhhjVar.f33800a;
        long[] jArr2 = zzhhkVar2.f33802a;
        long[] jArr3 = zzhhjVar.f33801b;
        zzhht.e(jArr, jArr2, jArr3);
        long[] jArr4 = zzhhkVar.f33803b;
        long[] jArr5 = zzhhkVar2.f33803b;
        long[] jArr6 = zzhhkVar2.f33804c;
        zzhht.e(jArr4, jArr5, jArr6);
        zzhht.e(zzhhkVar.f33804c, jArr6, jArr3);
        zzhht.e(zzhhlVar.f33806b, jArr2, jArr5);
    }

    public zzhhl() {
        this(new zzhhk(), new long[10]);
    }

    public zzhhl(zzhhj zzhhjVar) {
        this();
        a(this, zzhhjVar);
    }
}
