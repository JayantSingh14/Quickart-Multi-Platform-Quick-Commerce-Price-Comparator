package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class LengthPercentage {

    /* renamed from: a, reason: collision with root package name */
    public final float f19391a;

    /* renamed from: b, reason: collision with root package name */
    public final LengthPercentageType f19392b;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f19393a;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f19393a = iArr;
            }
        }
    }

    public LengthPercentage(float f2, LengthPercentageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f19391a = f2;
        this.f19392b = type;
    }

    public final CornerRadii a(float f2, float f3) {
        LengthPercentageType lengthPercentageType = LengthPercentageType.f19395b;
        float f4 = this.f19391a;
        if (this.f19392b != lengthPercentageType) {
            return new CornerRadii(f4, f4);
        }
        float f5 = 100;
        return new CornerRadii((f4 / f5) * f2, (f4 / f5) * f3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LengthPercentage)) {
            return false;
        }
        LengthPercentage lengthPercentage = (LengthPercentage) obj;
        return Float.compare(this.f19391a, lengthPercentage.f19391a) == 0 && this.f19392b == lengthPercentage.f19392b;
    }

    public final int hashCode() {
        return this.f19392b.hashCode() + (Float.hashCode(this.f19391a) * 31);
    }

    public final String toString() {
        return "LengthPercentage(value=" + this.f19391a + ", type=" + this.f19392b + ")";
    }

    public LengthPercentage() {
        this(0.0f, LengthPercentageType.f19394a);
    }
}
