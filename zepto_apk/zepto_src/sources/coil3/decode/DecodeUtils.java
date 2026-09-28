package coil3.decode;

import coil3.annotation.ExperimentalCoilApi;
import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.IntPair;
import coil3.util.UtilsKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DecodeUtils {

    @NotNull
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(int i2, int i3, int i4, int i5, @NotNull Scale scale) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(i2 / i4);
        int iHighestOneBit2 = Integer.highestOneBit(i3 / i5);
        int i6 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i6 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i6 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        if (iMin < 1) {
            return 1;
        }
        return iMin;
    }

    @JvmStatic
    @ExperimentalCoilApi
    /* renamed from: computeDstSize-sEdh43o, reason: not valid java name */
    public static final long m1computeDstSizesEdh43o(int i2, int i3, @NotNull Size size, @NotNull Scale scale, @NotNull Size size2) {
        int iM42unboximpl;
        int iM42unboximpl2;
        if (!SizeKt.isOriginal(size)) {
            DecodeUtils decodeUtils = INSTANCE;
            int px = decodeUtils.toPx(size.getWidth(), scale);
            i3 = decodeUtils.toPx(size.getHeight(), scale);
            i2 = px;
        }
        if ((size2.getWidth() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i2) && i2 > (iM42unboximpl2 = ((Dimension.Pixels) size2.getWidth()).m42unboximpl())) {
            i2 = iM42unboximpl2;
        }
        if ((size2.getHeight() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i3) && i3 > (iM42unboximpl = ((Dimension.Pixels) size2.getHeight()).m42unboximpl())) {
            i3 = iM42unboximpl;
        }
        return IntPair.m47constructorimpl(i2, i3);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int i2, int i3, int i4, int i5, @NotNull Scale scale) {
        double d2 = i4 / i2;
        double d3 = i5 / i3;
        int i6 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i6 == 1) {
            return Math.max(d2, d3);
        }
        if (i6 == 2) {
            return Math.min(d2, d3);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).m42unboximpl();
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i2 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i2 == 2) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float f2, float f3, float f4, float f5, @NotNull Scale scale) {
        float f6 = f4 / f2;
        float f7 = f5 / f3;
        int i2 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i2 == 1) {
            return Math.max(f6, f7);
        }
        if (i2 == 2) {
            return Math.min(f6, f7);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double d2, double d3, double d4, double d5, @NotNull Scale scale) {
        double d6 = d4 / d2;
        double d7 = d5 / d3;
        int i2 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i2 == 1) {
            return Math.max(d6, d7);
        }
        if (i2 == 2) {
            return Math.min(d6, d7);
        }
        throw new NoWhenBranchMatchedException();
    }
}
