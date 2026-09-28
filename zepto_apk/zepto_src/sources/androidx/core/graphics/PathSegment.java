package androidx.core.graphics;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public final class PathSegment {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f2815a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2816b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f2817c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2818d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.f2816b, pathSegment.f2816b) == 0 && Float.compare(this.f2818d, pathSegment.f2818d) == 0 && this.f2815a.equals(pathSegment.f2815a) && this.f2817c.equals(pathSegment.f2817c);
    }

    public final int hashCode() {
        int iHashCode = this.f2815a.hashCode() * 31;
        float f2 = this.f2816b;
        int iHashCode2 = (this.f2817c.hashCode() + ((iHashCode + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31)) * 31;
        float f3 = this.f2818d;
        return iHashCode2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
    }

    public final String toString() {
        return "PathSegment{start=" + this.f2815a + ", startFraction=" + this.f2816b + ", end=" + this.f2817c + ", endFraction=" + this.f2818d + '}';
    }
}
