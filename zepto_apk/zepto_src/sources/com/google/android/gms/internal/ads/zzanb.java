package com.google.android.gms.internal.ads;

import android.text.Layout;

/* loaded from: classes4.dex */
final class zzanb {

    /* renamed from: a, reason: collision with root package name */
    public String f23704a;

    /* renamed from: b, reason: collision with root package name */
    public int f23705b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23706c;

    /* renamed from: d, reason: collision with root package name */
    public int f23707d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23708e;

    /* renamed from: k, reason: collision with root package name */
    public float f23714k;

    /* renamed from: l, reason: collision with root package name */
    public String f23715l;
    public Layout.Alignment o;
    public Layout.Alignment p;
    public zzamu r;
    public String t;
    public String u;

    /* renamed from: f, reason: collision with root package name */
    public int f23709f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f23710g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f23711h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f23712i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f23713j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f23716m = -1;
    public int n = -1;
    public int q = -1;
    public float s = Float.MAX_VALUE;

    public final String a() {
        return this.t;
    }

    public final String b() {
        return this.u;
    }

    public final void c(zzanb zzanbVar) {
        int i2;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzanbVar != null) {
            if (!this.f23706c && zzanbVar.f23706c) {
                this.f23705b = zzanbVar.f23705b;
                this.f23706c = true;
            }
            if (this.f23711h == -1) {
                this.f23711h = zzanbVar.f23711h;
            }
            if (this.f23712i == -1) {
                this.f23712i = zzanbVar.f23712i;
            }
            if (this.f23704a == null && (str = zzanbVar.f23704a) != null) {
                this.f23704a = str;
            }
            if (this.f23709f == -1) {
                this.f23709f = zzanbVar.f23709f;
            }
            if (this.f23710g == -1) {
                this.f23710g = zzanbVar.f23710g;
            }
            if (this.n == -1) {
                this.n = zzanbVar.n;
            }
            if (this.o == null && (alignment2 = zzanbVar.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = zzanbVar.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = zzanbVar.q;
            }
            if (this.f23713j == -1) {
                this.f23713j = zzanbVar.f23713j;
                this.f23714k = zzanbVar.f23714k;
            }
            if (this.r == null) {
                this.r = zzanbVar.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = zzanbVar.s;
            }
            if (this.t == null) {
                this.t = zzanbVar.t;
            }
            if (this.u == null) {
                this.u = zzanbVar.u;
            }
            if (!this.f23708e && zzanbVar.f23708e) {
                this.f23707d = zzanbVar.f23707d;
                this.f23708e = true;
            }
            if (this.f23716m != -1 || (i2 = zzanbVar.f23716m) == -1) {
                return;
            }
            this.f23716m = i2;
        }
    }

    public final String d() {
        return this.f23715l;
    }
}
