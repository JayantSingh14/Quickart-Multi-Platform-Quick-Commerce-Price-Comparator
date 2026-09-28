package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzja {

    /* renamed from: a, reason: collision with root package name */
    public final Object f37822a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f37823b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f37824c;

    public zzja(Object obj, Object obj2, Object obj3) {
        this.f37822a = obj;
        this.f37823b = obj2;
        this.f37824c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f37822a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.f37823b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.f37824c);
        return new IllegalArgumentException(sb.toString());
    }
}
