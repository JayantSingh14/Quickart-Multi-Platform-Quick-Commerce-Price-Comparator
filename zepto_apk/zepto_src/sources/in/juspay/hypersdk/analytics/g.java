package in.juspay.hypersdk.analytics;

import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48527a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimerTask f48528b;

    public /* synthetic */ g(TimerTask timerTask, int i2) {
        this.f48527a = i2;
        this.f48528b = timerTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48527a) {
            case 0:
                ((LogSessioniser.LogSessioniserTimerTask) this.f48528b).lambda$run$0();
                break;
            default:
                ((LogPusherExp.LogPushTimerTask) this.f48528b).lambda$run$0();
                break;
        }
    }
}
