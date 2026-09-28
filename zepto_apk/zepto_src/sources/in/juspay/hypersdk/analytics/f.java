package in.juspay.hypersdk.analytics;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48525a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogSessioniser f48526b;

    public /* synthetic */ f(LogSessioniser logSessioniser, int i2) {
        this.f48525a = i2;
        this.f48526b = logSessioniser;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48525a) {
            case 0:
                this.f48526b.lambda$pushLogsToPusher$2();
                break;
            case 1:
                this.f48526b.lambda$stopLogSessioniserOnTerminate$3();
                break;
            case 2:
                this.f48526b.lambda$startLogSessioniserOnLogCount$1();
                break;
            default:
                this.f48526b.lambda$startLogSessioniser$0();
                break;
        }
    }
}
