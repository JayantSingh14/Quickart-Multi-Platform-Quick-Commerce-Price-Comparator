package com.facebook.drawee.generic;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundingParams {

    /* renamed from: a, reason: collision with root package name */
    public RoundingMethod f17427a = RoundingMethod.f17436b;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17428b = false;

    /* renamed from: c, reason: collision with root package name */
    public float[] f17429c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f17430d = 0;

    /* renamed from: e, reason: collision with root package name */
    public float f17431e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public int f17432f = 0;

    /* renamed from: g, reason: collision with root package name */
    public float f17433g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17434h = false;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RoundingMethod {

        /* renamed from: a, reason: collision with root package name */
        public static final RoundingMethod f17435a;

        /* renamed from: b, reason: collision with root package name */
        public static final RoundingMethod f17436b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RoundingMethod[] f17437c;

        static {
            RoundingMethod roundingMethod = new RoundingMethod("OVERLAY_COLOR", 0);
            f17435a = roundingMethod;
            RoundingMethod roundingMethod2 = new RoundingMethod("BITMAP_ONLY", 1);
            f17436b = roundingMethod2;
            f17437c = new RoundingMethod[]{roundingMethod, roundingMethod2};
        }

        public static RoundingMethod valueOf(String str) {
            return (RoundingMethod) Enum.valueOf(RoundingMethod.class, str);
        }

        public static RoundingMethod[] values() {
            return (RoundingMethod[]) f17437c.clone();
        }
    }

    public final void a(int i2) {
        this.f17430d = i2;
        this.f17427a = RoundingMethod.f17435a;
    }

    public final void b() {
        this.f17427a = RoundingMethod.f17436b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.f17428b == roundingParams.f17428b && this.f17430d == roundingParams.f17430d && Float.compare(roundingParams.f17431e, this.f17431e) == 0 && this.f17432f == roundingParams.f17432f && Float.compare(roundingParams.f17433g, this.f17433g) == 0 && this.f17427a == roundingParams.f17427a && this.f17434h == roundingParams.f17434h) {
            return Arrays.equals(this.f17429c, roundingParams.f17429c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.f17427a.hashCode() * 31) + (this.f17428b ? 1 : 0)) * 31;
        float[] fArr = this.f17429c;
        int iHashCode2 = (((iHashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f17430d) * 31;
        float f2 = this.f17431e;
        int iFloatToIntBits = (((iHashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f17432f) * 31;
        float f3 = this.f17433g;
        return ((iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 961) + (this.f17434h ? 1 : 0);
    }
}
