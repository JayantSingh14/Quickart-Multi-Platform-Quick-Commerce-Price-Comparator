package com.swmansion.gesturehandler.core;

import android.view.VelocityTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class Vector {

    /* renamed from: d, reason: collision with root package name */
    public static final Vector f46789d = new Vector(-1.0d, 0.0d);

    /* renamed from: e, reason: collision with root package name */
    public static final Vector f46790e = new Vector(1.0d, 0.0d);

    /* renamed from: f, reason: collision with root package name */
    public static final Vector f46791f = new Vector(0.0d, -1.0d);

    /* renamed from: g, reason: collision with root package name */
    public static final Vector f46792g = new Vector(0.0d, 1.0d);

    /* renamed from: h, reason: collision with root package name */
    public static final Vector f46793h = new Vector(1.0d, -1.0d);

    /* renamed from: i, reason: collision with root package name */
    public static final Vector f46794i = new Vector(1.0d, 1.0d);

    /* renamed from: j, reason: collision with root package name */
    public static final Vector f46795j = new Vector(-1.0d, -1.0d);

    /* renamed from: k, reason: collision with root package name */
    public static final Vector f46796k = new Vector(-1.0d, 1.0d);

    /* renamed from: l, reason: collision with root package name */
    public static final Vector f46797l = new Vector(0.0d, 0.0d);

    /* renamed from: a, reason: collision with root package name */
    public final double f46798a;

    /* renamed from: b, reason: collision with root package name */
    public final double f46799b;

    /* renamed from: c, reason: collision with root package name */
    public final double f46800c;

    @Metadata
    public static final class Companion {
        public static Vector a(int i2) {
            switch (i2) {
                case 1:
                    return Vector.f46790e;
                case 2:
                    return Vector.f46789d;
                case 3:
                case 7:
                default:
                    return Vector.f46797l;
                case 4:
                    return Vector.f46791f;
                case 5:
                    return Vector.f46793h;
                case 6:
                    return Vector.f46795j;
                case 8:
                    return Vector.f46792g;
                case 9:
                    return Vector.f46794i;
                case 10:
                    return Vector.f46796k;
            }
        }

        public static Vector b(VelocityTracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            tracker.computeCurrentVelocity(1000);
            return new Vector(tracker.getXVelocity(), tracker.getYVelocity());
        }
    }

    public Vector(double d2, double d3) {
        double dHypot = Math.hypot(d2, d3);
        this.f46800c = dHypot;
        boolean z = dHypot > 0.1d;
        this.f46798a = z ? d2 / dHypot : 0.0d;
        this.f46799b = z ? d3 / dHypot : 0.0d;
    }

    public final double a() {
        return this.f46800c;
    }

    public final boolean b(Vector vector, double d2) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        return (this.f46799b * vector.f46799b) + (this.f46798a * vector.f46798a) > d2;
    }
}
