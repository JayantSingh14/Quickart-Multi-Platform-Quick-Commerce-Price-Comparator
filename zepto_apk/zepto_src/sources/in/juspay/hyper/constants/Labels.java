package in.juspay.hyper.constants;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class Labels {

    @NotNull
    public static final Labels INSTANCE = new Labels();

    @Metadata
    public static final class Android {

        @NotNull
        public static final String BACK_PRESSED = "on_back_pressed";

        @NotNull
        public static final String FRAGMENT_LIFECYCLE_EVENT = "fragment_lifecycle_event";

        @NotNull
        public static final String FRAGMENT_OPERATION = "fragment_operation";

        @NotNull
        public static final Android INSTANCE = new Android();

        @NotNull
        public static final String ON_ACTIVITY_RESULT = "on_activity_result";

        @NotNull
        public static final String ON_EVENT = "on_event";

        @NotNull
        public static final String START_INTENT_SENDER_FOR_RESULT = "start_intent_sender_for_result";

        @NotNull
        public static final String WEBVIEW = "webview";

        private Android() {
        }
    }

    @Metadata
    public static final class Device {

        @NotNull
        public static final String IDENTIFIERS = "identifiers";

        @NotNull
        public static final Device INSTANCE = new Device();

        @NotNull
        public static final String MEMORY = "memory";

        @NotNull
        public static final String PHONE_STATE = "phone_state";

        @NotNull
        public static final String SESSION_INFO = "session_info";

        private Device() {
        }
    }

    @Keep
    @Metadata
    public static final class HyperSdk {

        @NotNull
        public static final String ADD_BRIDGE = "add_bridge";

        @NotNull
        public static final String AUTO_FALLBACK = "auto_fallback";

        @NotNull
        public static final String DUI_READY = "dui_ready";

        @NotNull
        public static final String EVENT = "on_event";

        @NotNull
        public static final String EXCEPTION_HANDLER = "hyper_exception_handler";

        @NotNull
        public static final String EXIT_SDK_ERROR = "exit_sdk_error";

        @NotNull
        public static final String FIRST_TIME_SETUP = "first_time_setup";

        @NotNull
        public static final String HYPER_SERVICE = "hyper_service";

        @NotNull
        public static final String INITIATE = "initiate";

        @NotNull
        public static final HyperSdk INSTANCE = new HyperSdk();

        @NotNull
        public static final String JP_CONSUMING_BACK_PRESS = "jp_consuming_backpress";

        @NotNull
        public static final String JUSPAY_SERVICES = "juspay_services";

        @NotNull
        public static final String MYSTIQUE = "mystique";

        @NotNull
        public static final String ON_BACKPRESSED_CALLBACK = "on_back_pressed_callback";

        @NotNull
        public static final String ON_DUI_READY = "on_dui_ready";

        @NotNull
        public static final String ON_HTML_READY = "on_html_ready";

        @NotNull
        public static final String ON_JOS_READY = "on_jos_ready";

        @NotNull
        public static final String ON_MICRO_APP_LOADED = "on_micro_app_loaded";

        @NotNull
        public static final String ON_MICRO_APP_LOAD_ERROR = "on_micro_app_load_error";

        @NotNull
        public static final String ON_SCRIPT_ERROR = "on_script_error";

        @NotNull
        public static final String PREFETCH = "prefetch";

        @NotNull
        public static final String PROCESS = "process";

        @NotNull
        public static final String PROCESS_WAIT_QUEUE = "process_wait_queue";

        @NotNull
        public static final String RUN_IN_JUSPAY_BROWSER = "run_in_juspay_browser";

        @NotNull
        public static final String SET_BUNDLE_PARAMS = "set_bundle_parameters";

        @NotNull
        public static final String TERMINATE = "terminate";

        @NotNull
        public static final String TERMINATE_PROCESS = "terminate_process";

        private HyperSdk() {
        }
    }

    @Metadata
    public static final class Network {

        @NotNull
        public static final String BEFORE_REQUEST = "before_request";

        @NotNull
        public static final String CANCEL_API = "cancel_api";

        @NotNull
        public static final Network INSTANCE = new Network();

        @NotNull
        public static final String NETWORK_CALL = "network_call";

        private Network() {
        }
    }

    @Metadata
    public static final class SDK {

        @NotNull
        public static final String AMAZON_UTILS = "amazon_utils";

        @NotNull
        public static final String CUSTOM_TAB = "custom_tab";

        @NotNull
        public static final SDK INSTANCE = new SDK();

        @NotNull
        public static final String PAYPAL_UTILS = "paypal_utils";

        @NotNull
        public static final String PAYTM_UTILS = "paytm_utils";

        @NotNull
        public static final String RECEIVER_CALLBACK = "receiver_callback";

        @NotNull
        public static final String WEBVIEW_CLIENT = "webview_client";

        private SDK() {
        }
    }

    @Metadata
    public static final class System {

        @NotNull
        public static final String ADD_WEBVIEW = "add_web_view";

        @NotNull
        public static final String CL_ELIGIBILITY = "cl_eligibility";

        @NotNull
        public static final String FILE_PROVIDER_SERVICE = "file_provider_service";

        @NotNull
        public static final String GODEL_SERVICE_CONNECTION = "godel_service_connection";

        @NotNull
        public static final String GODEL_SERVICE_RESPONSE_HANDLER = "godel_service_response_handler";

        @NotNull
        public static final String GODEL_WEBVIEW_WHITELIST = "godel_webview_whitelist";

        @NotNull
        public static final String HELPER = "helper";

        @NotNull
        public static final String INITIALISE_JUSPAY_WEBVIEW = "initialise_juspay_webview";

        @NotNull
        public static final System INSTANCE = new System();

        @NotNull
        public static final String IS_NETWORK_AVAILABLE = "is_network_available";

        @NotNull
        public static final String JBRIDGE = "jbridge";

        @NotNull
        public static final String JUSPAY_WEBVIEW_CLIENT = "juspay_webview_client";

        @NotNull
        public static final String KEYBOARD = "keyboard";

        @NotNull
        public static final String LOAD_PAGE = "load_page";

        @NotNull
        public static final String LOG_PUSHER = "log_pusher";

        @NotNull
        public static final String MPIN_UTIL = "mpin_util";

        @NotNull
        public static final String ON_DUI_RELEASED = "on_dui_released";

        @NotNull
        public static final String ON_RENDER_PROCESS_GONE = "on_render_process_gone";

        @NotNull
        public static final String ON_REQUEST_PERMISSION_RESULT = "on_request_permission_result";

        @NotNull
        public static final String ON_WEBVIEW_READY = "on_webview_ready";

        @NotNull
        public static final String PAYMENT_SESSION_INFO = "payment_session_info";

        @NotNull
        public static final String PERMISSION = "permission";

        @NotNull
        public static final String PLAY_AUDIO = "play_audio";

        @NotNull
        public static final String READ_SMS_PERMISSION = "read_sms_permission";

        @NotNull
        public static final String REMOTE_ASSET_SERVICE = "remote_asset_service";

        @NotNull
        public static final String RUN_IN_JUSPAY_WEBVIEW = "run_in_juspay_webview";

        @NotNull
        public static final String SDK_CRASHED = "sdk_crashed";

        @NotNull
        public static final String SESSION_INFO = "session_info";

        @NotNull
        public static final String SHARED_PREF = "SharedPref";

        @NotNull
        public static final String UPI_UTILS = "upi_utils";

        @NotNull
        public static final String UTIL = "util";

        private System() {
        }
    }

    @Metadata
    public static final class User {

        @NotNull
        public static final User INSTANCE = new User();

        @NotNull
        public static final String SHOULD_DISABLE_GODEL = "should_disable_godel";

        private User() {
        }
    }

    private Labels() {
    }
}
