package coil3.util;

import coil3.util.Logger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class DebugLogger implements Logger {

    @NotNull
    private Logger.Level minLevel;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DebugLogger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // coil3.util.Logger
    @NotNull
    public Logger.Level getMinLevel() {
        return this.minLevel;
    }

    @Override // coil3.util.Logger
    public void log(@NotNull String str, @NotNull Logger.Level level, @Nullable String str2, @Nullable Throwable th) {
        if (str2 != null) {
            Utils_androidKt.println(level, str, str2);
        }
        if (th != null) {
            Utils_androidKt.println(level, str, ExceptionsKt.b(th));
        }
    }

    @Override // coil3.util.Logger
    public void setMinLevel(@NotNull Logger.Level level) {
        this.minLevel = level;
    }

    @JvmOverloads
    public DebugLogger(@NotNull Logger.Level level) {
        this.minLevel = level;
    }

    public /* synthetic */ DebugLogger(Logger.Level level, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Logger.Level.Debug : level);
    }
}
