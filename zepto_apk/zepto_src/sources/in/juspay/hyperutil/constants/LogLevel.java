package in.juspay.hyperutil.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class LogLevel {

    @NotNull
    public static final String DEBUG = "debug";

    @NotNull
    public static final String ERROR = "error";

    @NotNull
    public static final String EXCEPTION = "exception";

    @NotNull
    public static final String INFO = "info";

    @NotNull
    public static final LogLevel INSTANCE = new LogLevel();

    @NotNull
    public static final String WARNING = "warning";

    private LogLevel() {
    }
}
