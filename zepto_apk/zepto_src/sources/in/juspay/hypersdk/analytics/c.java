package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.analytics.LogPusher;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48520a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogPusher.LogPushTimerTask f48521b;

    public /* synthetic */ c(LogPusher.LogPushTimerTask logPushTimerTask, int i2) {
        this.f48520a = i2;
        this.f48521b = logPushTimerTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48520a) {
            case 0:
                this.f48521b.lambda$run$1();
                break;
            default:
                this.f48521b.lambda$pushAllLogs$0();
                break;
        }
    }
}
