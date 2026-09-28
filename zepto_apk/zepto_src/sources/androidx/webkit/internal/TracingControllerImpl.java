package androidx.webkit.internal;

import androidx.webkit.TracingController;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.WebViewGlueCommunicator;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

/* loaded from: classes3.dex */
public class TracingControllerImpl extends TracingController {

    /* renamed from: a, reason: collision with root package name */
    public final TracingControllerBoundaryInterface f12441a;

    public TracingControllerImpl() {
        ApiFeature.P p = WebViewFeatureInternal.f12453g;
        if (p.c()) {
            android.webkit.TracingController.getInstance();
        } else {
            if (!p.d()) {
                throw WebViewFeatureInternal.a();
            }
            this.f12441a = WebViewGlueCommunicator.LAZY_FACTORY_HOLDER.f12462a.getTracingController();
        }
    }
}
