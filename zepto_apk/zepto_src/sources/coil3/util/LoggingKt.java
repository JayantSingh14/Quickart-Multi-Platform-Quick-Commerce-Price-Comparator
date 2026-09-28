package coil3.util;

import coil3.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class LoggingKt {
    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Throwable th) {
        Logger.Level minLevel = logger.getMinLevel();
        Logger.Level level = Logger.Level.Error;
        if (minLevel.compareTo(level) <= 0) {
            logger.log(str, level, null, th);
        }
    }

    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Logger.Level level, @NotNull Function0<String> function0) {
        if (logger.getMinLevel().compareTo(level) <= 0) {
            logger.log(str, level, (String) function0.invoke(), null);
        }
    }
}
