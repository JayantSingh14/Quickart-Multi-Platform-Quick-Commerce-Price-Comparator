package in.juspay.hyperutil.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class Labels {

    @NotNull
    public static final Labels INSTANCE = new Labels();

    @Keep
    @Metadata
    public static final class HyperOTA {

        @NotNull
        public static final String AUTO_FALLBACK = "auto_fallback";

        @NotNull
        public static final String FIRST_TIME_SETUP = "first_time_setup";

        @NotNull
        public static final HyperOTA INSTANCE = new HyperOTA();

        private HyperOTA() {
        }
    }

    @Metadata
    public static final class Network {

        @NotNull
        public static final String CANCEL_API = "cancel_api";

        @NotNull
        public static final Network INSTANCE = new Network();

        private Network() {
        }
    }

    @Metadata
    public static final class System {

        @NotNull
        public static final String FILE_PROVIDER_SERVICE = "file_provider_service";

        @NotNull
        public static final String HELPER = "helper";

        @NotNull
        public static final System INSTANCE = new System();

        @NotNull
        public static final String REMOTE_ASSET_SERVICE = "remote_asset_service";

        private System() {
        }
    }

    private Labels() {
    }
}
