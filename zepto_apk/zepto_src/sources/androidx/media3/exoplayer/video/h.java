package androidx.media3.exoplayer.video;

import android.content.res.Configuration;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import in.juspay.hypersdk.services.HyperPaymentsServices;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.SentryLevel;
import io.sentry.android.core.AppComponentsBreadcrumbsIntegration;
import io.sentry.android.core.internal.util.DeviceOrientations;
import io.sentry.protocol.Device;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8363b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8364c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8365d;

    public /* synthetic */ h(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j2) {
        this.f8362a = 0;
        this.f8364c = eventDispatcher;
        this.f8365d = obj;
        this.f8363b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f8365d;
        long j2 = this.f8363b;
        Object obj2 = this.f8364c;
        switch (this.f8362a) {
            case 0:
                VideoRendererEventListener.EventDispatcher eventDispatcher = (VideoRendererEventListener.EventDispatcher) obj2;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f8347b.o(j2, obj);
                break;
            case 1:
                ((HyperPaymentsServices) obj2).lambda$doProcess$11(j2, (JSONObject) obj);
                break;
            default:
                AppComponentsBreadcrumbsIntegration appComponentsBreadcrumbsIntegration = (AppComponentsBreadcrumbsIntegration) obj2;
                if (appComponentsBreadcrumbsIntegration.f52094b != null) {
                    Device.DeviceOrientation deviceOrientationA = DeviceOrientations.a(appComponentsBreadcrumbsIntegration.f52093a.getResources().getConfiguration().orientation);
                    String lowerCase = deviceOrientationA != null ? deviceOrientationA.name().toLowerCase(Locale.ROOT) : "undefined";
                    Breadcrumb breadcrumb = new Breadcrumb(j2);
                    breadcrumb.f51558d = "navigation";
                    breadcrumb.f51560f = "device.orientation";
                    breadcrumb.b(lowerCase, "position");
                    breadcrumb.f51562h = SentryLevel.INFO;
                    Hint hint = new Hint();
                    hint.c((Configuration) obj, "android:configuration");
                    appComponentsBreadcrumbsIntegration.f52094b.b(breadcrumb, hint);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ h(Object obj, long j2, Object obj2, int i2) {
        this.f8362a = i2;
        this.f8364c = obj;
        this.f8363b = j2;
        this.f8365d = obj2;
    }
}
