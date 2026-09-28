package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class PlaybackParameters {

    /* renamed from: d, reason: collision with root package name */
    public static final PlaybackParameters f5424d = new PlaybackParameters(1.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final String f5425e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f5426f;

    /* renamed from: a, reason: collision with root package name */
    public final float f5427a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5428b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5429c;

    static {
        int i2 = Util.f5744a;
        f5425e = Integer.toString(0, 36);
        f5426f = Integer.toString(1, 36);
    }

    public PlaybackParameters(float f2) {
        this(f2, 1.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PlaybackParameters.class == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.f5427a == playbackParameters.f5427a && this.f5428b == playbackParameters.f5428b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f5428b) + ((Float.floatToRawIntBits(this.f5427a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f5427a), Float.valueOf(this.f5428b)};
        int i2 = Util.f5744a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }

    public PlaybackParameters(float f2, float f3) {
        Assertions.a(f2 > 0.0f);
        Assertions.a(f3 > 0.0f);
        this.f5427a = f2;
        this.f5428b = f3;
        this.f5429c = Math.round(f2 * 1000.0f);
    }
}
