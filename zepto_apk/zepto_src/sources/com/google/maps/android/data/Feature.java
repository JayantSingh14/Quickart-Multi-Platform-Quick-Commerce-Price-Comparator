package com.google.maps.android.data;

import java.util.HashMap;
import java.util.Observable;

/* loaded from: classes4.dex */
public class Feature extends Observable {

    /* renamed from: a, reason: collision with root package name */
    public final String f45524a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f45525b;

    /* renamed from: c, reason: collision with root package name */
    public final Geometry f45526c;

    public Feature(Geometry geometry, String str, HashMap map) {
        this.f45526c = geometry;
        this.f45524a = str;
        this.f45525b = map;
    }

    public final Geometry a() {
        return this.f45526c;
    }

    public final String b(String str) {
        return (String) this.f45525b.get(str);
    }

    public final boolean c() {
        return this.f45526c != null;
    }

    public final boolean d(String str) {
        return this.f45525b.containsKey(str);
    }
}
