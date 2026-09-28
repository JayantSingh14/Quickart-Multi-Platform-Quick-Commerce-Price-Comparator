package coil3.size;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class RealSizeResolver implements SizeResolver {

    @NotNull
    private final Size size;

    public RealSizeResolver(@NotNull Size size) {
        this.size = size;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RealSizeResolver) && Intrinsics.b(this.size, ((RealSizeResolver) obj).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }

    @Override // coil3.size.SizeResolver
    @Nullable
    public Object size(@NotNull Continuation<? super Size> continuation) {
        return this.size;
    }

    @NotNull
    public String toString() {
        return "RealSizeResolver(size=" + this.size + ')';
    }
}
