package coil3.size;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class RealViewSizeResolver<T extends View> implements ViewSizeResolver<T> {
    private final boolean subtractPadding;

    @NotNull
    private final T view;

    public RealViewSizeResolver(@NotNull T t, boolean z) {
        this.view = t;
        this.subtractPadding = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealViewSizeResolver)) {
            return false;
        }
        RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj;
        return Intrinsics.b(this.view, realViewSizeResolver.view) && this.subtractPadding == realViewSizeResolver.subtractPadding;
    }

    @Override // coil3.size.ViewSizeResolver
    public boolean getSubtractPadding() {
        return this.subtractPadding;
    }

    @Override // coil3.size.ViewSizeResolver
    @NotNull
    public T getView() {
        return this.view;
    }

    public int hashCode() {
        return Boolean.hashCode(this.subtractPadding) + (this.view.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "RealViewSizeResolver(view=" + this.view + ", subtractPadding=" + this.subtractPadding + ')';
    }
}
