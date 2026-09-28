package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzcx {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f27322a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f27323b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f27324c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f27325d;

    /* renamed from: e, reason: collision with root package name */
    public final float f27326e;

    /* renamed from: f, reason: collision with root package name */
    public final int f27327f;

    /* renamed from: g, reason: collision with root package name */
    public final int f27328g;

    /* renamed from: h, reason: collision with root package name */
    public final float f27329h;

    /* renamed from: i, reason: collision with root package name */
    public final int f27330i;

    /* renamed from: j, reason: collision with root package name */
    public final float f27331j;

    /* renamed from: k, reason: collision with root package name */
    public final float f27332k;

    /* renamed from: l, reason: collision with root package name */
    public final int f27333l;

    /* renamed from: m, reason: collision with root package name */
    public final float f27334m;
    public final int n;
    public final float o;
    public final int p;

    static {
        zzcw zzcwVar = new zzcw();
        zzcwVar.a("");
        zzcwVar.b();
        String str = zzfj.f31254a;
        q = Integer.toString(0, 36);
        r = Integer.toString(17, 36);
        s = Integer.toString(1, 36);
        t = Integer.toString(2, 36);
        Integer.toString(3, 36);
        u = Integer.toString(18, 36);
        v = Integer.toString(4, 36);
        w = Integer.toString(5, 36);
        x = Integer.toString(6, 36);
        y = Integer.toString(7, 36);
        z = Integer.toString(8, 36);
        A = Integer.toString(9, 36);
        B = Integer.toString(10, 36);
        C = Integer.toString(11, 36);
        D = Integer.toString(12, 36);
        E = Integer.toString(13, 36);
        F = Integer.toString(14, 36);
        G = Integer.toString(15, 36);
        H = Integer.toString(16, 36);
        I = Integer.toString(19, 36);
    }

    public /* synthetic */ zzcx(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, int i6, float f7, int i7) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            zzgqa.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f27322a = SpannedString.valueOf(charSequence);
        } else {
            this.f27322a = charSequence != null ? charSequence.toString() : null;
        }
        this.f27323b = alignment;
        this.f27324c = alignment2;
        this.f27325d = bitmap;
        this.f27326e = f2;
        this.f27327f = i2;
        this.f27328g = i3;
        this.f27329h = f3;
        this.f27330i = i4;
        this.f27331j = f5;
        this.f27332k = f6;
        this.f27333l = i5;
        this.f27334m = f4;
        this.n = i6;
        this.o = f7;
        this.p = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzcx.class != obj.getClass()) {
            return false;
        }
        zzcx zzcxVar = (zzcx) obj;
        if (!TextUtils.equals(this.f27322a, zzcxVar.f27322a) || this.f27323b != zzcxVar.f27323b || this.f27324c != zzcxVar.f27324c) {
            return false;
        }
        Bitmap bitmap = zzcxVar.f27325d;
        Bitmap bitmap2 = this.f27325d;
        if (bitmap2 == null) {
            if (bitmap != null) {
                return false;
            }
        } else if (bitmap == null || !bitmap2.sameAs(bitmap)) {
            return false;
        }
        return this.f27326e == zzcxVar.f27326e && this.f27327f == zzcxVar.f27327f && this.f27328g == zzcxVar.f27328g && this.f27329h == zzcxVar.f27329h && this.f27330i == zzcxVar.f27330i && this.f27331j == zzcxVar.f27331j && this.f27332k == zzcxVar.f27332k && this.f27333l == zzcxVar.f27333l && this.f27334m == zzcxVar.f27334m && this.n == zzcxVar.n && this.o == zzcxVar.o && this.p == zzcxVar.p;
    }

    public final int hashCode() {
        Float fValueOf = Float.valueOf(this.f27326e);
        Integer numValueOf = Integer.valueOf(this.f27327f);
        Integer numValueOf2 = Integer.valueOf(this.f27328g);
        Float fValueOf2 = Float.valueOf(this.f27329h);
        Integer numValueOf3 = Integer.valueOf(this.f27330i);
        Float fValueOf3 = Float.valueOf(this.f27331j);
        Float fValueOf4 = Float.valueOf(this.f27332k);
        Boolean bool = Boolean.FALSE;
        Integer numValueOf4 = Integer.valueOf(this.f27333l);
        Float fValueOf5 = Float.valueOf(this.f27334m);
        Integer numValueOf5 = Integer.valueOf(this.n);
        Float fValueOf6 = Float.valueOf(this.o);
        Integer numValueOf6 = Integer.valueOf(this.p);
        return Objects.hash(this.f27322a, this.f27323b, this.f27324c, this.f27325d, fValueOf, numValueOf, numValueOf2, fValueOf2, numValueOf3, fValueOf3, fValueOf4, bool, -16777216, numValueOf4, fValueOf5, numValueOf5, fValueOf6, numValueOf6);
    }
}
