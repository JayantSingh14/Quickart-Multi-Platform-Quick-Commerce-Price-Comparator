package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        static {
            new NaNLinearTransformation();
        }

        public final String toString() {
            return "NaN";
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {
        public final String toString() {
            Double dValueOf = Double.valueOf(0.0d);
            return String.format("y = %g * x + %g", dValueOf, dValueOf);
        }
    }

    public static final class VerticalLinearTransformation extends LinearTransformation {
        public final String toString() {
            return String.format("x = %g", Double.valueOf(0.0d));
        }
    }
}
