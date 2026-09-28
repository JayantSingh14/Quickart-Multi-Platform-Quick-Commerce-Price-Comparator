package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class HeartRating extends Rating {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5242d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5243e;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5244b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5245c;

    static {
        int i2 = Util.f5744a;
        f5242d = Integer.toString(1, 36);
        f5243e = Integer.toString(2, 36);
    }

    public HeartRating() {
        this.f5244b = false;
        this.f5245c = false;
    }

    @Override // androidx.media3.common.Rating
    public final boolean b() {
        return this.f5244b;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f5450a, 0);
        bundle.putBoolean(f5242d, this.f5244b);
        bundle.putBoolean(f5243e, this.f5245c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        return this.f5245c == heartRating.f5245c && this.f5244b == heartRating.f5244b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f5244b), Boolean.valueOf(this.f5245c)});
    }

    public HeartRating(boolean z) {
        this.f5244b = true;
        this.f5245c = z;
    }
}
