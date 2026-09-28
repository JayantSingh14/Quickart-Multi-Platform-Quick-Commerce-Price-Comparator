package coil3.network.internal;

import android.content.Context;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Utils_androidKt {
    public static final void assertNotOnMainThread() {
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            throw new NetworkOnMainThreadException();
        }
    }

    public static final boolean isPermissionGranted(@NotNull Context context, @NotNull String str) {
        return ContextCompat.a(context, str) == 0;
    }
}
