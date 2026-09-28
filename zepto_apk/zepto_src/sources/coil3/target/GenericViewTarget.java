package coil3.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {
    private boolean isStarted;

    @Override // coil3.transition.TransitionTarget
    @Nullable
    public abstract Drawable getDrawable();

    @Override // coil3.target.Target
    public void onError(@Nullable Image image) {
        updateImage(image);
    }

    @Override // coil3.target.Target
    public void onStart(@Nullable Image image) {
        updateImage(image);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        this.isStarted = false;
        updateAnimation();
    }

    @Override // coil3.target.Target
    public void onSuccess(@NotNull Image image) {
        updateImage(image);
    }

    public abstract void setDrawable(@Nullable Drawable drawable);

    public final void updateAnimation() {
        Object drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.isStarted) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final void updateImage(@Nullable Image image) {
        Drawable drawableAsDrawable = image != null ? Image_androidKt.asDrawable(image, getView().getResources()) : null;
        Object drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
        setDrawable(drawableAsDrawable);
        updateAnimation();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        this.isStarted = true;
        updateAnimation();
    }
}
