package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdw extends zzbi {

    /* renamed from: a, reason: collision with root package name */
    public final Long f37648a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f37649b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f37650c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f37651d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f37652e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f37653f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f37654g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f37655h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f37656i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f37657j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f37658k;

    public zzdw() {
    }

    @Override // com.google.android.gms.internal.pal.zzbi
    public final HashMap b() {
        HashMap map = new HashMap();
        map.put(0, this.f37648a);
        map.put(1, this.f37649b);
        map.put(2, this.f37650c);
        map.put(3, this.f37651d);
        map.put(4, this.f37652e);
        map.put(5, this.f37653f);
        map.put(6, this.f37654g);
        map.put(7, this.f37655h);
        map.put(8, this.f37656i);
        map.put(9, this.f37657j);
        map.put(10, this.f37658k);
        return map;
    }

    public zzdw(String str) {
        HashMap mapA = zzbi.a(str);
        if (mapA != null) {
            this.f37648a = (Long) mapA.get(0);
            this.f37649b = (Long) mapA.get(1);
            this.f37650c = (Long) mapA.get(2);
            this.f37651d = (Long) mapA.get(3);
            this.f37652e = (Long) mapA.get(4);
            this.f37653f = (Long) mapA.get(5);
            this.f37654g = (Long) mapA.get(6);
            this.f37655h = (Long) mapA.get(7);
            this.f37656i = (Long) mapA.get(8);
            this.f37657j = (Long) mapA.get(9);
            this.f37658k = (Long) mapA.get(10);
        }
    }
}
