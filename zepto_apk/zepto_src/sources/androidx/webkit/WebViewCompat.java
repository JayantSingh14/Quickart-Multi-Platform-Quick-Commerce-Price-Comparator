package androidx.webkit;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.WebMessageListenerAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class WebViewCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12427a = 0;

    public interface VisualStateCallback {
    }

    public interface WebMessageListener {
        void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    static {
        Uri.parse("*");
        Uri.parse("");
    }

    public static void a(WebView webView, String str, Set set, WebMessageListener webMessageListener) {
        if (!WebViewFeatureInternal.f12457k.d()) {
            throw WebViewFeatureInternal.a();
        }
        WebViewProviderAdapter webViewProviderAdapterC = c(webView);
        webViewProviderAdapterC.f12463a.addWebMessageListener(str, (String[]) set.toArray(new String[0]), BoundaryInterfaceReflectionUtil.b(new WebMessageListenerAdapter(webMessageListener)));
    }

    public static PackageInfo b() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static WebViewProviderAdapter c(WebView webView) {
        return new WebViewProviderAdapter(WebViewGlueCommunicator.c().createWebView(webView));
    }

    public static String d() {
        if (WebViewFeatureInternal.f12459m.d()) {
            return WebViewGlueCommunicator.c().getStatics().getVariationsHeader();
        }
        throw WebViewFeatureInternal.a();
    }

    public static WebViewClient e(WebView webView) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ApiFeature.O o = WebViewFeatureInternal.f12452f;
        if (o.c()) {
            return webView.getWebViewClient();
        }
        if (!o.d()) {
            throw WebViewFeatureInternal.a();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Looper webViewLooper = webView.getWebViewLooper();
            if (webViewLooper != Looper.myLooper()) {
                throw new RuntimeException("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + webViewLooper + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
            }
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("checkThread", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(webView, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        return c(webView).f12463a.getWebViewClient();
    }
}
