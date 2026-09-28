package androidx.media3.common;

import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
public final class VideoSize {

    /* renamed from: e, reason: collision with root package name */
    public static final VideoSize f5559e = new VideoSize(1.0f, 0, 0, 0);

    /* renamed from: f, reason: collision with root package name */
    public static final String f5560f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f5561g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f5562h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f5563i;

    /* renamed from: a, reason: collision with root package name */
    public final int f5564a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5565b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5566c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5567d;

    static {
        int i2 = Util.f5744a;
        f5560f = Integer.toString(0, 36);
        f5561g = Integer.toString(1, 36);
        f5562h = Integer.toString(2, 36);
        f5563i = Integer.toString(3, 36);
    }

    public VideoSize(float f2, int i2, int i3, int i4) {
        this.f5564a = i2;
        this.f5565b = i3;
        this.f5566c = i4;
        this.f5567d = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSize) {
            VideoSize videoSize = (VideoSize) obj;
            if (this.f5564a == videoSize.f5564a && this.f5565b == videoSize.f5565b && this.f5566c == videoSize.f5566c && this.f5567d == videoSize.f5567d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f5567d) + ((((((217 + this.f5564a) * 31) + this.f5565b) * 31) + this.f5566c) * 31);
    }
}
