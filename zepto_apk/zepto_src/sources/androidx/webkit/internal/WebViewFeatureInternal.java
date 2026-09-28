package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.StartupApiFeature;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class WebViewFeatureInternal {

    /* renamed from: a, reason: collision with root package name */
    public static final ApiFeature.N f12447a;

    /* renamed from: b, reason: collision with root package name */
    public static final ApiFeature.M f12448b;

    /* renamed from: c, reason: collision with root package name */
    public static final ApiFeature.M f12449c;

    /* renamed from: d, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f12450d;

    /* renamed from: e, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12451e;

    /* renamed from: f, reason: collision with root package name */
    public static final ApiFeature.O f12452f;

    /* renamed from: g, reason: collision with root package name */
    public static final ApiFeature.P f12453g;

    /* renamed from: h, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12454h;

    /* renamed from: i, reason: collision with root package name */
    public static final ApiFeature.Q f12455i;

    /* renamed from: j, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12456j;

    /* renamed from: k, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12457k;

    /* renamed from: l, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12458l;

    /* renamed from: m, reason: collision with root package name */
    public static final ApiFeature.NoFramework f12459m;
    public static final ApiFeature.NoFramework n;
    public static final ApiFeature.NoFramework o;

    /* renamed from: androidx.webkit.internal.WebViewFeatureInternal$2, reason: invalid class name */
    public class AnonymousClass2 extends ApiFeature.NoFramework {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean d() {
            if (!super.d() || !WebViewFeature.a("MULTI_PROCESS")) {
                return false;
            }
            int i2 = WebViewCompat.f12427a;
            if (WebViewFeatureInternal.f12454h.d()) {
                return WebViewGlueCommunicator.c().getStatics().isMultiProcessEnabled();
            }
            throw WebViewFeatureInternal.a();
        }
    }

    static {
        new ApiFeature.M("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        new ApiFeature.M("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        new ApiFeature.O("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        new ApiFeature.N("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        new ApiFeature.O_MR1("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        new ApiFeature.O_MR1("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        f12447a = new ApiFeature.N("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        new ApiFeature.N("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        new ApiFeature.N("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        new ApiFeature.N("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        new ApiFeature.N("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        new ApiFeature.N("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        new ApiFeature.M("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        new ApiFeature.M("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        new ApiFeature.N("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        new ApiFeature.O_MR1("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        new ApiFeature.N("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        f12448b = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        f12449c = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        f12450d = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        new ApiFeature.M("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        new ApiFeature.M("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        f12451e = new ApiFeature.NoFramework("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
        new ApiFeature.M("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        new ApiFeature.M("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        new ApiFeature.M("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        new ApiFeature.M("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        f12452f = new ApiFeature.O("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        new ApiFeature.O("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        new ApiFeature.Q("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        new ApiFeature.Q("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        f12453g = new ApiFeature.P("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        new StartupApiFeature.P();
        new StartupApiFeature.NoFramework();
        new ApiFeature.Q("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        new ApiFeature.T() { // from class: androidx.webkit.internal.WebViewFeatureInternal.1

            /* renamed from: d, reason: collision with root package name */
            public final Pattern f12460d = Pattern.compile("\\A\\d+");

            @Override // androidx.webkit.internal.ApiFeature
            public final boolean d() {
                int i2;
                PackageInfo packageInfoB;
                boolean zD = super.d();
                if (!zD || (i2 = Build.VERSION.SDK_INT) >= 29) {
                    return zD;
                }
                int i3 = WebViewCompat.f12427a;
                if (i2 >= 26) {
                    packageInfoB = WebView.getCurrentWebViewPackage();
                } else {
                    try {
                        packageInfoB = WebViewCompat.b();
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        packageInfoB = null;
                    }
                }
                if (packageInfoB == null) {
                    return false;
                }
                Matcher matcher = this.f12460d.matcher(packageInfoB.versionName);
                return matcher.find() && Integer.parseInt(packageInfoB.versionName.substring(matcher.start(), matcher.end())) >= 105;
            }
        };
        new ApiFeature.NoFramework("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        f12454h = new ApiFeature.NoFramework("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        f12455i = new ApiFeature.Q("FORCE_DARK", "FORCE_DARK");
        f12456j = new ApiFeature.NoFramework("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        f12457k = new ApiFeature.NoFramework("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        f12458l = new ApiFeature.NoFramework("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        new ApiFeature.NoFramework("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        f12459m = new ApiFeature.NoFramework("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        new ApiFeature.NoFramework("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        new ApiFeature.NoFramework("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        new ApiFeature.NoFramework("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
        new ApiFeature.NoFramework("USER_AGENT_METADATA", "USER_AGENT_METADATA");
        n = new AnonymousClass2("MULTI_PROFILE", "MULTI_PROFILE");
        new ApiFeature.NoFramework("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");
        new ApiFeature.NoFramework("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
        o = new ApiFeature.NoFramework("MUTE_AUDIO", "MUTE_AUDIO");
        new ApiFeature.NoFramework("WEB_AUTHENTICATION", "WEB_AUTHENTICATION");
        new ApiFeature.NoFramework("SPECULATIVE_LOADING_STATUS", "SPECULATIVE_LOADING");
        new ApiFeature.NoFramework("BACK_FORWARD_CACHE", "BACK_FORWARD_CACHE");
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
}
