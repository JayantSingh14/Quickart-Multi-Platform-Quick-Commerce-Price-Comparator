package androidx.core.util;

import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public final class SizeFCompat {

    /* renamed from: a, reason: collision with root package name */
    private final float f2995a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2996b;

    @RequiresApi
    public static final class Api21Impl {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        return sizeFCompat.f2995a == this.f2995a && sizeFCompat.f2996b == this.f2996b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2995a) ^ Float.floatToIntBits(this.f2996b);
    }

    public String toString() {
        return this.f2995a + "x" + this.f2996b;
    }
}
