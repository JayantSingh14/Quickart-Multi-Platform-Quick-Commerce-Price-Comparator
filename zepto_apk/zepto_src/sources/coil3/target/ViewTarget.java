package coil3.target;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface ViewTarget<T extends View> extends Target {
    @NotNull
    T getView();
}
