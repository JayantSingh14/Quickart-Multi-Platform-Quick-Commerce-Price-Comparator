package in.juspay.hypersdk.analytics;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48523a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogPusherExp f48524b;

    public /* synthetic */ e(LogPusherExp logPusherExp, int i2) {
        this.f48523a = i2;
        this.f48524b = logPusherExp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48523a) {
            case 0:
                this.f48524b.lambda$pushAllLogs$6();
                break;
            case 1:
                this.f48524b.pushCrashLogFile();
                break;
            case 2:
                this.f48524b.lambda$clearBacklog$1();
                break;
            default:
                this.f48524b.stopLogPusherOnTerminate();
                break;
        }
    }
}
