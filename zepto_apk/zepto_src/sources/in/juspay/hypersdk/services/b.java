package in.juspay.hypersdk.services;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48722a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HyperPaymentsServices f48723b;

    public /* synthetic */ b(HyperPaymentsServices hyperPaymentsServices, int i2) {
        this.f48722a = i2;
        this.f48723b = hyperPaymentsServices;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48722a) {
            case 0:
                this.f48723b.lambda$runProcessWaitQueue$5();
                break;
            case 1:
                this.f48723b.lambda$initiate$3();
                break;
            case 2:
                this.f48723b.lambda$handleOnEvent$1();
                break;
            default:
                this.f48723b.lambda$handleOnEvent$0();
                break;
        }
    }
}
