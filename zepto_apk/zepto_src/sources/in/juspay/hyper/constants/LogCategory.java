package in.juspay.hyper.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class LogCategory {

    @NotNull
    public static final String ACTION = "action";

    @NotNull
    public static final String API_CALL = "api_call";

    @NotNull
    public static final String CONTEXT = "context";

    @NotNull
    public static final LogCategory INSTANCE = new LogCategory();

    @NotNull
    public static final String LIFECYCLE = "lifecycle";

    private LogCategory() {
    }
}
