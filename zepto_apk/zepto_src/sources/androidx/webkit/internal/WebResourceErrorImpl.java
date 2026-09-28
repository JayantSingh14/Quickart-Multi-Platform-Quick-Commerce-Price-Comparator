package androidx.webkit.internal;

import android.webkit.WebResourceError;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class WebResourceErrorImpl extends WebResourceErrorCompat {

    /* renamed from: a, reason: collision with root package name */
    public WebResourceError f12445a;

    /* renamed from: b, reason: collision with root package name */
    public final WebResourceErrorBoundaryInterface f12446b;

    public WebResourceErrorImpl(InvocationHandler invocationHandler) {
        this.f12446b = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    public final CharSequence a() throws IllegalArgumentException {
        WebViewFeatureInternal.f12448b.getClass();
        if (this.f12445a == null) {
            WebkitToCompatConverter webkitToCompatConverter = WebViewGlueCommunicator.LAZY_COMPAT_CONVERTER_HOLDER.f12461a;
            this.f12445a = (WebResourceError) webkitToCompatConverter.f12468a.convertWebResourceError(Proxy.getInvocationHandler(this.f12446b));
        }
        return this.f12445a.getDescription();
    }

    public final int b() throws IllegalArgumentException {
        WebViewFeatureInternal.f12449c.getClass();
        if (this.f12445a == null) {
            WebkitToCompatConverter webkitToCompatConverter = WebViewGlueCommunicator.LAZY_COMPAT_CONVERTER_HOLDER.f12461a;
            this.f12445a = (WebResourceError) webkitToCompatConverter.f12468a.convertWebResourceError(Proxy.getInvocationHandler(this.f12446b));
        }
        return this.f12445a.getErrorCode();
    }

    public WebResourceErrorImpl(WebResourceError webResourceError) {
        this.f12445a = webResourceError;
    }
}
