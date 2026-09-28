package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Optional;

/* loaded from: classes4.dex */
final class zzgiz {

    /* renamed from: a, reason: collision with root package name */
    public final zzath f32695a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32696b;

    /* renamed from: c, reason: collision with root package name */
    public final long f32697c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32698d;

    public zzgiz(zzath zzathVar, long j2, long j3, String str) {
        this.f32695a = zzathVar;
        this.f32696b = j2;
        this.f32697c = j3;
        this.f32698d = str;
    }

    public static zzgiz a(zzath zzathVar, byte[] bArr) throws zzatb, zzatf {
        zzathVar.a();
        zzathVar.f24315a.f24400d.f24384b = zzatw.e(bArr);
        List list = (List) zzathVar.b(Optional.empty());
        long jLongValue = ((Long) list.get(0)).longValue();
        long jLongValue2 = ((Long) list.get(1)).longValue();
        long jLongValue3 = ((Long) list.get(2)).longValue();
        zzathVar.c(jLongValue, Optional.empty());
        byte[] bArrA = zzatg.a();
        return new zzgiz(zzathVar, jLongValue2, jLongValue3, "3.815976881.".concat(zzgvy.f33275a.g(bArrA.length, bArrA)));
    }
}
