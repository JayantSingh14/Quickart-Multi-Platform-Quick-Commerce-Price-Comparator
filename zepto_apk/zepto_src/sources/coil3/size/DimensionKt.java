package coil3.size;

import coil3.size.Dimension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class DimensionKt {
    public static final int Dimension(int i2) {
        return Dimension.Pixels.m37constructorimpl(i2);
    }

    public static final int pxOrElse(@NotNull Dimension dimension, @NotNull Function0<Integer> function0) {
        return dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).m42unboximpl() : ((Number) function0.invoke()).intValue();
    }
}
