package androidx.core.graphics;

import android.support.v4.media.b;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class Insets {

    /* renamed from: e, reason: collision with root package name */
    public static final Insets f2807e = new Insets(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2808a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2809b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2810c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2811d;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api29Impl {
        public static android.graphics.Insets a(int i2, int i3, int i4, int i5) {
            return android.graphics.Insets.of(i2, i3, i4, i5);
        }
    }

    public Insets(int i2, int i3, int i4, int i5) {
        this.f2808a = i2;
        this.f2809b = i3;
        this.f2810c = i4;
        this.f2811d = i5;
    }

    public static Insets a(Insets insets, Insets insets2) {
        return c(Math.max(insets.f2808a, insets2.f2808a), Math.max(insets.f2809b, insets2.f2809b), Math.max(insets.f2810c, insets2.f2810c), Math.max(insets.f2811d, insets2.f2811d));
    }

    public static Insets b(Insets insets, Insets insets2) {
        return c(Math.min(insets.f2808a, insets2.f2808a), Math.min(insets.f2809b, insets2.f2809b), Math.min(insets.f2810c, insets2.f2810c), Math.min(insets.f2811d, insets2.f2811d));
    }

    public static Insets c(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f2807e : new Insets(i2, i3, i4, i5);
    }

    public static Insets d(android.graphics.Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final android.graphics.Insets e() {
        return Api29Impl.a(this.f2808a, this.f2809b, this.f2810c, this.f2811d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.f2811d == insets.f2811d && this.f2808a == insets.f2808a && this.f2810c == insets.f2810c && this.f2809b == insets.f2809b;
    }

    public final int hashCode() {
        return (((((this.f2808a * 31) + this.f2809b) * 31) + this.f2810c) * 31) + this.f2811d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f2808a);
        sb.append(", top=");
        sb.append(this.f2809b);
        sb.append(", right=");
        sb.append(this.f2810c);
        sb.append(", bottom=");
        return b.n(sb, this.f2811d, '}');
    }
}
