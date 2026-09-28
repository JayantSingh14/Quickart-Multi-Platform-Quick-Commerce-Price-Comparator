package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzne {

    /* renamed from: a, reason: collision with root package name */
    public final zznd f37139a;

    public zzne(zzos zzosVar, zzos zzosVar2) {
        this.f37139a = new zznd(zzosVar, zzosVar2);
    }

    public static void a(zzll zzllVar, zznd zzndVar, Object obj, Object obj2) {
        zzlv.d(zzllVar, zzndVar.f37137a, 1, obj);
        zzlv.d(zzllVar, zzndVar.f37138b, 2, obj2);
    }

    public static int b(zznd zzndVar, Object obj, Object obj2) {
        return zzlv.e(zzndVar.f37137a, 1, obj) + zzlv.e(zzndVar.f37138b, 2, obj2);
    }
}
