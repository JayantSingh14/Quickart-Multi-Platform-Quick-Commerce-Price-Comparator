package coil3.size;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ViewSizeResolverKt {
    @JvmOverloads
    @NotNull
    public static final <T extends View> ViewSizeResolver<T> ViewSizeResolver(@NotNull T t) {
        return ViewSizeResolver$default(t, false, 2, null);
    }

    public static /* synthetic */ ViewSizeResolver ViewSizeResolver$default(View view, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return ViewSizeResolver(view, z);
    }

    @JvmOverloads
    @NotNull
    public static final <T extends View> ViewSizeResolver<T> ViewSizeResolver(@NotNull T t, boolean z) {
        return new RealViewSizeResolver(t, z);
    }
}
