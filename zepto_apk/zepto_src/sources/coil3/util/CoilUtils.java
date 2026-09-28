package coil3.util;

import android.view.View;
import coil3.request.ImageResult;
import coil3.request.ViewTargetRequestManagerKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class CoilUtils {

    @NotNull
    public static final CoilUtils INSTANCE = new CoilUtils();

    private CoilUtils() {
    }

    @JvmStatic
    public static final void dispose(@NotNull View view) {
        ViewTargetRequestManagerKt.getRequestManager(view).dispose();
    }

    @JvmStatic
    @Nullable
    public static final ImageResult result(@NotNull View view) {
        return ViewTargetRequestManagerKt.getRequestManager(view).getResult();
    }
}
