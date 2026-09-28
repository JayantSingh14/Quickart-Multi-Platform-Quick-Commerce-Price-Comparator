package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48646a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DynamicUI f48647b;

    public /* synthetic */ q(DynamicUI dynamicUI, int i2) {
        this.f48646a = i2;
        this.f48647b = dynamicUI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48646a) {
            case 0:
                this.f48647b.createWebView();
                break;
            default:
                this.f48647b.loadData();
                break;
        }
    }
}
