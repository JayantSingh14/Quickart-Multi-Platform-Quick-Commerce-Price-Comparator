package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {

    /* renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f12437a;

    /* renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f12438b;

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        this.f12438b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public final void a() throws IllegalArgumentException {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.f12450d;
        if (o_mr1.c()) {
            if (this.f12437a == null) {
                WebkitToCompatConverter webkitToCompatConverter = WebViewGlueCommunicator.LAZY_COMPAT_CONVERTER_HOLDER.f12461a;
                this.f12437a = a.d(webkitToCompatConverter.f12468a.convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.f12438b)));
            }
            this.f12437a.showInterstitial(true);
            return;
        }
        if (!o_mr1.d()) {
            throw WebViewFeatureInternal.a();
        }
        if (this.f12438b == null) {
            WebkitToCompatConverter webkitToCompatConverter2 = WebViewGlueCommunicator.LAZY_COMPAT_CONVERTER_HOLDER.f12461a;
            this.f12438b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, webkitToCompatConverter2.f12468a.convertSafeBrowsingResponse(this.f12437a));
        }
        this.f12438b.showInterstitial(true);
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        this.f12437a = safeBrowsingResponse;
    }
}
