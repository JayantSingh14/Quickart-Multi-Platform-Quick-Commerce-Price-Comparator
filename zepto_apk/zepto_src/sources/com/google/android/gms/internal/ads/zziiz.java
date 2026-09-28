package com.google.android.gms.internal.ads;

import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class zziiz {

    /* renamed from: j, reason: collision with root package name */
    public static final zziiz f34866j = new zziiz(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: k, reason: collision with root package name */
    public static final zziiz f34867k = new zziiz(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: l, reason: collision with root package name */
    public static final zziiz f34868l = new zziiz(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: m, reason: collision with root package name */
    public static final zziiz f34869m = new zziiz(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a, reason: collision with root package name */
    public final double f34870a;

    /* renamed from: b, reason: collision with root package name */
    public final double f34871b;

    /* renamed from: c, reason: collision with root package name */
    public final double f34872c;

    /* renamed from: d, reason: collision with root package name */
    public final double f34873d;

    /* renamed from: e, reason: collision with root package name */
    public final double f34874e;

    /* renamed from: f, reason: collision with root package name */
    public final double f34875f;

    /* renamed from: g, reason: collision with root package name */
    public final double f34876g;

    /* renamed from: h, reason: collision with root package name */
    public final double f34877h;

    /* renamed from: i, reason: collision with root package name */
    public final double f34878i;

    public zziiz(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.f34870a = d6;
        this.f34871b = d7;
        this.f34872c = d8;
        this.f34873d = d2;
        this.f34874e = d3;
        this.f34875f = d4;
        this.f34876g = d5;
        this.f34877h = d9;
        this.f34878i = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zziiz.class != obj.getClass()) {
            return false;
        }
        zziiz zziizVar = (zziiz) obj;
        return Double.compare(zziizVar.f34873d, this.f34873d) == 0 && Double.compare(zziizVar.f34874e, this.f34874e) == 0 && Double.compare(zziizVar.f34875f, this.f34875f) == 0 && Double.compare(zziizVar.f34876g, this.f34876g) == 0 && Double.compare(zziizVar.f34877h, this.f34877h) == 0 && Double.compare(zziizVar.f34878i, this.f34878i) == 0 && Double.compare(zziizVar.f34870a, this.f34870a) == 0 && Double.compare(zziizVar.f34871b, this.f34871b) == 0 && Double.compare(zziizVar.f34872c, this.f34872c) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f34870a);
        long j2 = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f34871b);
        long j3 = jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32);
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f34872c);
        long j4 = jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32);
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f34873d);
        long j5 = jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32);
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.f34874e);
        long j6 = jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32);
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.f34875f);
        long j7 = jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32);
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.f34876g);
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.f34877h);
        long j8 = jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32);
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.f34878i);
        return (((((((((((((((((int) j2) * 31) + ((int) j3)) * 31) + ((int) j4)) * 31) + ((int) j5)) * 31) + ((int) j6)) * 31) + ((int) j7)) * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)))) * 31) + ((int) j8)) * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(f34866j)) {
            return "Rotate 0°";
        }
        if (equals(f34867k)) {
            return "Rotate 90°";
        }
        if (equals(f34868l)) {
            return "Rotate 180°";
        }
        if (equals(f34869m)) {
            return "Rotate 270°";
        }
        StringBuilder sb = new StringBuilder(Type.AMTRELAY);
        sb.append("Matrix{u=");
        sb.append(this.f34870a);
        sb.append(", v=");
        sb.append(this.f34871b);
        sb.append(", w=");
        sb.append(this.f34872c);
        sb.append(", a=");
        sb.append(this.f34873d);
        sb.append(", b=");
        sb.append(this.f34874e);
        sb.append(", c=");
        sb.append(this.f34875f);
        sb.append(", d=");
        sb.append(this.f34876g);
        sb.append(", tx=");
        sb.append(this.f34877h);
        sb.append(", ty=");
        sb.append(this.f34878i);
        sb.append("}");
        return sb.toString();
    }
}
