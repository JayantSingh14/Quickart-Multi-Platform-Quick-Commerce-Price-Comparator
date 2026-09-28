package coil3.size;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class SizeResolverKt {
    @NotNull
    public static final SizeResolver SizeResolver(@NotNull Size size) {
        return new RealSizeResolver(size);
    }
}
