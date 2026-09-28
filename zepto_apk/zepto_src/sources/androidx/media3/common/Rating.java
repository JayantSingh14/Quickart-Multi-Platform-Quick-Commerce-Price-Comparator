package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
public abstract class Rating {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5450a;

    static {
        int i2 = Util.f5744a;
        f5450a = Integer.toString(0, 36);
    }

    public static Rating a(Bundle bundle) {
        String str = f5450a;
        int i2 = bundle.getInt(str, -1);
        if (i2 == 0) {
            String str2 = HeartRating.f5242d;
            Assertions.a(bundle.getInt(str, -1) == 0);
            return bundle.getBoolean(HeartRating.f5242d, false) ? new HeartRating(bundle.getBoolean(HeartRating.f5243e, false)) : new HeartRating();
        }
        if (i2 == 1) {
            String str3 = PercentageRating.f5413c;
            Assertions.a(bundle.getInt(str, -1) == 1);
            float f2 = bundle.getFloat(PercentageRating.f5413c, -1.0f);
            return f2 == -1.0f ? new PercentageRating() : new PercentageRating(f2);
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unknown RatingType: "));
            }
            String str4 = ThumbRating.f5462d;
            Assertions.a(bundle.getInt(str, -1) == 3);
            return bundle.getBoolean(ThumbRating.f5462d, false) ? new ThumbRating(bundle.getBoolean(ThumbRating.f5463e, false)) : new ThumbRating();
        }
        String str5 = StarRating.f5452d;
        Assertions.a(bundle.getInt(str, -1) == 2);
        int i3 = bundle.getInt(StarRating.f5452d, 5);
        float f3 = bundle.getFloat(StarRating.f5453e, -1.0f);
        return f3 == -1.0f ? new StarRating(i3) : new StarRating(f3, i3);
    }

    public abstract boolean b();

    public abstract Bundle c();
}
