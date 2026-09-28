package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48632a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DuiInterface f48633b;

    public /* synthetic */ o(DuiInterface duiInterface, int i2) {
        this.f48632a = i2;
        this.f48633b = duiInterface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48632a) {
            case 0:
                this.f48633b.lambda$requestKeyboardHide$9();
                break;
            case 1:
                this.f48633b.lambda$onDuiReady$2();
                break;
            default:
                this.f48633b.lambda$suppressKeyboard$8();
                break;
        }
    }
}
