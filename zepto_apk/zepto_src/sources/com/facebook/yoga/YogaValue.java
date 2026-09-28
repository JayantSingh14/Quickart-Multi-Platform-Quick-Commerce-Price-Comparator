package com.facebook.yoga;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
public class YogaValue {

    /* renamed from: c, reason: collision with root package name */
    public static final YogaValue f20423c = new YogaValue(Float.NaN, YogaUnit.UNDEFINED);

    /* renamed from: d, reason: collision with root package name */
    public static final YogaValue f20424d = new YogaValue(Float.NaN, YogaUnit.AUTO);

    /* renamed from: a, reason: collision with root package name */
    public final float f20425a;

    /* renamed from: b, reason: collision with root package name */
    public final YogaUnit f20426b;

    /* renamed from: com.facebook.yoga.YogaValue$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20427a;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            f20427a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20427a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20427a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20427a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public YogaValue(float f2, YogaUnit yogaUnit) {
        this.f20425a = f2;
        this.f20426b = yogaUnit;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof YogaValue) {
            YogaValue yogaValue = (YogaValue) obj;
            YogaUnit yogaUnit = yogaValue.f20426b;
            YogaUnit yogaUnit2 = this.f20426b;
            if (yogaUnit2 == yogaUnit) {
                return yogaUnit2 == YogaUnit.UNDEFINED || yogaUnit2 == YogaUnit.AUTO || Float.compare(this.f20425a, yogaValue.f20425a) == 0;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f20425a) + this.f20426b.f20422a;
    }

    public final String toString() {
        int iOrdinal = this.f20426b.ordinal();
        if (iOrdinal == 0) {
            return "undefined";
        }
        float f2 = this.f20425a;
        if (iOrdinal == 1) {
            return Float.toString(f2);
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return "auto";
            }
            throw new IllegalStateException();
        }
        return f2 + "%";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public YogaValue(float f2, int i2) {
        YogaUnit yogaUnit;
        switch (i2) {
            case 0:
                yogaUnit = YogaUnit.UNDEFINED;
                break;
            case 1:
                yogaUnit = YogaUnit.POINT;
                break;
            case 2:
                yogaUnit = YogaUnit.PERCENT;
                break;
            case 3:
                yogaUnit = YogaUnit.AUTO;
                break;
            case 4:
                yogaUnit = YogaUnit.MAX_CONTENT;
                break;
            case 5:
                yogaUnit = YogaUnit.FIT_CONTENT;
                break;
            case 6:
                yogaUnit = YogaUnit.STRETCH;
                break;
            default:
                throw new IllegalArgumentException(b.f(i2, "Unknown enum value: "));
        }
        this(f2, yogaUnit);
    }
}
