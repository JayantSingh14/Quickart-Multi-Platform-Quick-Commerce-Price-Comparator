package coil3.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public class ImageViewTarget extends GenericViewTarget<ImageView> {

    @NotNull
    private final ImageView view;

    public ImageViewTarget(@NotNull ImageView imageView) {
        this.view = imageView;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageViewTarget) && Intrinsics.b(this.view, ((ImageViewTarget) obj).view);
    }

    @Override // coil3.target.GenericViewTarget, coil3.transition.TransitionTarget
    @Nullable
    public Drawable getDrawable() {
        return getView().getDrawable();
    }

    public int hashCode() {
        return this.view.hashCode();
    }

    @Override // coil3.target.GenericViewTarget
    public void setDrawable(@Nullable Drawable drawable) {
        getView().setImageDrawable(drawable);
    }

    @NotNull
    public String toString() {
        return "ImageViewTarget(view=" + this.view + ')';
    }

    @Override // coil3.target.ViewTarget, coil3.transition.TransitionTarget
    @NotNull
    public ImageView getView() {
        return this.view;
    }
}
