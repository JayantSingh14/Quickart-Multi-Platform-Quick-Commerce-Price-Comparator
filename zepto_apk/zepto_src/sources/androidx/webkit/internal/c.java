package androidx.webkit.internal;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import androidx.work.impl.utils.IdGenerator;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12469a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12470b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f12469a = i2;
        this.f12470b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f12469a) {
            case 0:
                return new JavaScriptReplyProxyImpl((JsReplyProxyBoundaryInterface) this.f12470b);
            case 1:
                WebViewRenderProcessImpl webViewRenderProcessImpl = new WebViewRenderProcessImpl();
                webViewRenderProcessImpl.f12467a = (WebViewRendererBoundaryInterface) this.f12470b;
                return webViewRenderProcessImpl;
            case 2:
                IdGenerator this$0 = (IdGenerator) this.f12470b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                WorkDatabase workDatabase = this$0.f12976a;
                Long lB = workDatabase.r().b("next_alarm_manager_id");
                int iLongValue = lB != null ? (int) lB.longValue() : 0;
                workDatabase.r().a(new Preference("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
            case 3:
                BufferedDiskCache this$02 = (BufferedDiskCache) this.f12470b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                try {
                    this$02.f17736g.a();
                    this$02.f17730a.a();
                    return null;
                } catch (Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "th");
                    throw th;
                }
            case 4:
                FirebaseAnalytics.getInstance(((UniversalFirebaseAnalyticsModule) this.f12470b).f49247a).f43527a.x();
                return null;
            case 5:
                return ReactNativeFirebaseMessagingModule.lambda$deleteToken$8((FirebaseMessaging) this.f12470b);
            case 6:
                return ((ReactNativeFirebaseMessagingModule) this.f12470b).lambda$hasPermission$10();
            default:
                return ReactNativeFirebaseMessagingModule.lambda$sendMessage$12((ReadableMap) this.f12470b);
        }
    }
}
