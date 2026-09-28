package in.juspay.hyper.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class LogSubCategory {

    @Keep
    @Metadata
    public static final class Action {

        @NotNull
        public static final String DUI = "dynamic_ui";

        @NotNull
        public static final Action INSTANCE = new Action();

        @NotNull
        public static final String SYSTEM = "system";

        @NotNull
        public static final String USER = "user";

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

        @NotNull
        public static final String SDK = "external_sdk";

        private ApiCall() {
        }
    }

    @Keep
    @Metadata
    public static final class Context {

        @NotNull
        public static final String DEVICE = "device";

        @NotNull
        public static final Context INSTANCE = new Context();

        private Context() {
        }
    }

    @Keep
    @Metadata
    public static final class LifeCycle {

        @NotNull
        public static final String ANDROID = "android";

        @NotNull
        public static final String HYPER_SDK = "hypersdk";

        @NotNull
        public static final LifeCycle INSTANCE = new LifeCycle();

        private LifeCycle() {
        }
    }
}
