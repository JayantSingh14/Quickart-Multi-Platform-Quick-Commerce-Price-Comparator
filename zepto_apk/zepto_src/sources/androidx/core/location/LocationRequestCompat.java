package androidx.core.location;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class LocationRequestCompat {

    public static class Api19Impl {
    }

    @RequiresApi
    public static class Api31Impl {
    }

    public static final class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Quality {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        ((LocationRequestCompat) obj).getClass();
        return Float.compare(0.0f, 0.0f) == 0;
    }

    public final int hashCode() {
        int i2 = (int) 0;
        return (i2 * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request[@");
        Object obj = TimeUtils.f3013a;
        synchronized (obj) {
            if (TimeUtils.f3014b.length < 0) {
                TimeUtils.f3014b = new char[0];
            }
            char[] cArr = TimeUtils.f3014b;
            cArr[0] = '0';
            sb.append(cArr, 0, 1);
        }
        sb.append(", duration=");
        synchronized (obj) {
            if (TimeUtils.f3014b.length < 0) {
                TimeUtils.f3014b = new char[0];
            }
            char[] cArr2 = TimeUtils.f3014b;
            cArr2[0] = '0';
            sb.append(cArr2, 0, 1);
        }
        sb.append(", maxUpdates=0");
        if (0.0f > 0.0d) {
            sb.append(", minUpdateDistance=0.0");
        }
        sb.append(']');
        return sb.toString();
    }
}
