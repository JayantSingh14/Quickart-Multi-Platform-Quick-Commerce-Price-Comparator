package com.google.maps.android.geometry;

/* loaded from: classes4.dex */
public class Bounds {

    /* renamed from: a, reason: collision with root package name */
    public final double f45590a;

    /* renamed from: b, reason: collision with root package name */
    public final double f45591b;

    /* renamed from: c, reason: collision with root package name */
    public final double f45592c;

    /* renamed from: d, reason: collision with root package name */
    public final double f45593d;

    /* renamed from: e, reason: collision with root package name */
    public final double f45594e;

    /* renamed from: f, reason: collision with root package name */
    public final double f45595f;

    public Bounds(double d2, double d3, double d4, double d5) {
        this.f45590a = d2;
        this.f45591b = d4;
        this.f45592c = d3;
        this.f45593d = d5;
        this.f45594e = (d2 + d3) / 2.0d;
        this.f45595f = (d4 + d5) / 2.0d;
    }

    public final boolean a(double d2, double d3) {
        return this.f45590a <= d2 && d2 <= this.f45592c && this.f45591b <= d3 && d3 <= this.f45593d;
    }

    public final boolean b(Bounds bounds) {
        if (bounds.f45590a >= this.f45592c || this.f45590a >= bounds.f45592c) {
            return false;
        }
        return bounds.f45591b < this.f45593d && this.f45591b < bounds.f45593d;
    }
}
