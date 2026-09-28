package coil3.size;

import coil3.size.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class SizeKt {
    @NotNull
    public static final Size Size(int i2, @NotNull Dimension dimension) {
        return new Size(Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i2)), dimension);
    }

    public static final boolean isOriginal(@NotNull Size size) {
        return Intrinsics.b(size, Size.ORIGINAL);
    }

    @NotNull
    public static final Size Size(@NotNull Dimension dimension, int i2) {
        return new Size(dimension, Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i2)));
    }

    @NotNull
    public static final Size Size(int i2, int i3) {
        return new Size(Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i2)), Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i3)));
    }
}
