package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class StarRating extends Rating {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5452d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5453e;

    /* renamed from: b, reason: collision with root package name */
    public final int f5454b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5455c;

    static {
        int i2 = Util.f5744a;
        f5452d = Integer.toString(1, 36);
        f5453e = Integer.toString(2, 36);
    }

    public StarRating(float f2, int i2) {
        boolean z = false;
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        if (f2 >= 0.0f && f2 <= i2) {
            z = true;
        }
        Assertions.b(z, "starRating is out of range [0, maxStars]");
        this.f5454b = i2;
        this.f5455c = f2;
    }

    @Override // androidx.media3.common.Rating
    public final boolean b() {
        return this.f5455c != -1.0f;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f5450a, 2);
        bundle.putInt(f5452d, this.f5454b);
        bundle.putFloat(f5453e, this.f5455c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.f5454b == starRating.f5454b && this.f5455c == starRating.f5455c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5454b), Float.valueOf(this.f5455c)});
    }

    public StarRating(int i2) {
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        this.f5454b = i2;
        this.f5455c = -1.0f;
    }
}
