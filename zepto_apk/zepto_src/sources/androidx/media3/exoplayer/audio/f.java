package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import in.juspay.hypersdk.services.HyperPaymentsServices;
import io.sentry.android.core.AppComponentsBreadcrumbsIntegration;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6648a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6649b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6650c;

    public /* synthetic */ f(Object obj, int i2, long j2) {
        this.f6648a = i2;
        this.f6650c = obj;
        this.f6649b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j2 = this.f6649b;
        Object obj = this.f6650c;
        switch (this.f6648a) {
            case 0:
                AudioRendererEventListener.EventDispatcher eventDispatcher = (AudioRendererEventListener.EventDispatcher) obj;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f6524b.l(j2);
                break;
            case 1:
                ((HyperPaymentsServices) obj).lambda$terminate$12(j2);
                break;
            default:
                ((AppComponentsBreadcrumbsIntegration) obj).a(null, j2);
                break;
        }
    }
}
