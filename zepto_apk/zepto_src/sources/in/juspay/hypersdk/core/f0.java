package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48572a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JBridge f48573b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48574c;

    public /* synthetic */ f0(JBridge jBridge, String str, int i2) {
        this.f48572a = i2;
        this.f48573b = jBridge;
        this.f48574c = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        switch (this.f48572a) {
            case 0:
                this.f48573b.lambda$showJuspayLoader$0(this.f48574c);
                break;
            default:
                this.f48573b.lambda$hideJuspayLoader$1(this.f48574c);
                break;
        }
    }
}
