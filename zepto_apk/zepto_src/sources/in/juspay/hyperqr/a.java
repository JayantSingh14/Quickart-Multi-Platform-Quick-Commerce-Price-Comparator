package in.juspay.hyperqr;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48486b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f48485a = i2;
        this.f48486b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48485a) {
            case 0:
                CameraStreamScanner.releaseCameraResources$lambda$5((CameraStreamScanner) this.f48486b);
                break;
            default:
                QrBridge.stopScanning$lambda$8((QrBridge) this.f48486b);
                break;
        }
    }
}
