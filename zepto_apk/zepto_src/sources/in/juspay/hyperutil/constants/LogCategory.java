package in.juspay.hyperutil.constants;

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
    public static final LogCategory INSTANCE = new LogCategory();

    @NotNull
    public static final String LIFECYCLE = "lifecycle";

    @NotNull
    public static final String SDK = "sdk";

    private LogCategory() {
    }
}
