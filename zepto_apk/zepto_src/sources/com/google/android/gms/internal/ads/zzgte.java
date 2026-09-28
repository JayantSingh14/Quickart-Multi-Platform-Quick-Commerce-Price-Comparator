package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgte {

    /* renamed from: a, reason: collision with root package name */
    public final Object f33184a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f33185b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f33186c;

    public zzgte(Object obj, Object obj2, Object obj3) {
        this.f33184a = obj;
        this.f33185b = obj2;
        this.f33186c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f33184a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.f33185b);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.f33186c);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 33 + length2 + 5 + strValueOf3.length() + 1 + strValueOf4.length());
        android.support.v4.media.b.B(sb, "Multiple entries with same key: ", strValueOf, "=", strValueOf2);
        return new IllegalArgumentException(android.support.v4.media.a.n(sb, " and ", strValueOf3, "=", strValueOf4));
    }
}
