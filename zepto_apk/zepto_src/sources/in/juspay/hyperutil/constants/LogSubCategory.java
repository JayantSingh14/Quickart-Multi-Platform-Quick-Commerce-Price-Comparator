package in.juspay.hyperutil.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class LogSubCategory {

    @NotNull
    public static final LogSubCategory INSTANCE = new LogSubCategory();

    @Keep
    @Metadata
    public static final class Action {

        @NotNull
        public static final Action INSTANCE = new Action();

        @NotNull
        public static final String SYSTEM = "system";

        private Action() {
        }
    }

    @Keep
    @Metadata
    public static final class ApiCall {

        @NotNull
        public static final ApiCall INSTANCE = new ApiCall();

        @NotNull
        public static final String NETWORK = "network";

        private ApiCall() {
        }
    }

    @Keep
    @Metadata
    public static final class LifeCycle {

        @NotNull
        public static final String HYPER_OTA = "hyperota";

        @NotNull
        public static final LifeCycle INSTANCE = new LifeCycle();

        private LifeCycle() {
        }
    }

    private LogSubCategory() {
    }
}
