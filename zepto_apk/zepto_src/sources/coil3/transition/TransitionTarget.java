package coil3.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import coil3.target.Target;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface TransitionTarget extends Target {
    @Nullable
    Drawable getDrawable();

    @NotNull
    View getView();
}
