package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ThumbRating extends Rating {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5462d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5463e;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5464b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5465c;

    static {
        int i2 = Util.f5744a;
        f5462d = Integer.toString(1, 36);
        f5463e = Integer.toString(2, 36);
    }

    public ThumbRating() {
        this.f5464b = false;
        this.f5465c = false;
    }

    @Override // androidx.media3.common.Rating
    public final boolean b() {
        return this.f5464b;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f5450a, 3);
        bundle.putBoolean(f5462d, this.f5464b);
        bundle.putBoolean(f5463e, this.f5465c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.f5465c == thumbRating.f5465c && this.f5464b == thumbRating.f5464b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f5464b), Boolean.valueOf(this.f5465c)});
    }

    public ThumbRating(boolean z) {
        this.f5464b = true;
        this.f5465c = z;
    }
}
