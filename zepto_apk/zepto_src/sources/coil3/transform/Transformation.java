package coil3.transform;

import android.graphics.Bitmap;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public abstract class Transformation {
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Transformation) && Intrinsics.b(getCacheKey(), ((Transformation) obj).getCacheKey());
    }

    @NotNull
    public abstract String getCacheKey();

    public int hashCode() {
        return getCacheKey().hashCode();
    }

    @NotNull
    public String toString() {
        return "Transformation(cacheKey=" + getCacheKey() + ')';
    }

    @Nullable
    public abstract Object transform(@NotNull Bitmap bitmap, @NotNull Size size, @NotNull Continuation<? super Bitmap> continuation);
}
