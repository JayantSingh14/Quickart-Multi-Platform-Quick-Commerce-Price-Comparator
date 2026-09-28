package in.juspay.hyper.core;

import android.util.Log;
import androidx.annotation.Keep;
import in.juspay.hyper.constants.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class JuspayLogger {

    @NotNull
    public static final JuspayLogger INSTANCE = new JuspayLogger();

    private JuspayLogger() {
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String description) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(description, "description");
        if (JuspayCoreLib.isAppDebuggable()) {
            Log.d(tag, description);
        }
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String description) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(description, "description");
        if (JuspayCoreLib.isAppDebuggable()) {
            Log.e(tag, description);
        }
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String description) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(description, "description");
        if (JuspayCoreLib.isAppDebuggable()) {
            Log.i(tag, description);
        }
    }

    @JvmStatic
    public static final void log(@NotNull String tag, @NotNull String level, @NotNull String description) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(description, "description");
        switch (level.hashCode()) {
            case 3237038:
                if (level.equals("info")) {
                    i(tag, description);
                    return;
                }
                return;
            case 95458899:
                if (level.equals("debug")) {
                    d(tag, description);
                    return;
                }
                return;
            case 96784904:
                if (!level.equals("error")) {
                    return;
                }
                break;
            case 1124446108:
                if (level.equals("warning")) {
                    w(tag, description);
                    return;
                }
                return;
            case 1952151455:
                if (!level.equals(LogLevel.CRITICAL)) {
                    return;
                }
                break;
            default:
                return;
        }
        e(tag, description);
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String description) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(description, "description");
        if (JuspayCoreLib.isAppDebuggable()) {
            Log.w(tag, description);
        }
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String description, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (JuspayCoreLib.isAppDebuggable()) {
            Log.e(tag, description, throwable);
        }
    }
}
