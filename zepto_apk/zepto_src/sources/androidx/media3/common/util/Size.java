package androidx.media3.common.util;

@UnstableApi
/* loaded from: classes3.dex */
public final class Size {

    /* renamed from: c, reason: collision with root package name */
    public static final Size f5730c = new Size(-1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f5731a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5732b;

    static {
        new Size(0, 0);
    }

    public Size(int i2, int i3) {
        Assertions.a((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0));
        this.f5731a = i2;
        this.f5732b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f5731a == size.f5731a && this.f5732b == size.f5732b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f5731a;
        return ((i2 >>> 16) | (i2 << 16)) ^ this.f5732b;
    }

    public final String toString() {
        return this.f5731a + "x" + this.f5732b;
    }
}
