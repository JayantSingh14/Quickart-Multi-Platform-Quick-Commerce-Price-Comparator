package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class PercentageRating extends Rating {

    /* renamed from: c, reason: collision with root package name */
    public static final String f5413c;

    /* renamed from: b, reason: collision with root package name */
    public final float f5414b;

    static {
        int i2 = Util.f5744a;
        f5413c = Integer.toString(1, 36);
    }

    public PercentageRating() {
        this.f5414b = -1.0f;
    }

    @Override // androidx.media3.common.Rating
    public final boolean b() {
        return this.f5414b != -1.0f;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f5450a, 1);
        bundle.putFloat(f5413c, this.f5414b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PercentageRating) {
            return this.f5414b == ((PercentageRating) obj).f5414b;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5414b)});
    }

    public PercentageRating(float f2) {
        Assertions.b(f2 >= 0.0f && f2 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f5414b = f2;
    }
}
