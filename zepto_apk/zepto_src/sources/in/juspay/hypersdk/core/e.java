package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48557a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidInterface f48558b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48559c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48560d;

    public /* synthetic */ e(int i2, AndroidInterface androidInterface, String str, String str2) {
        this.f48557a = i2;
        this.f48558b = androidInterface;
        this.f48559c = str;
        this.f48560d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48557a) {
            case 0:
                this.f48558b.lambda$runCmdsInBg$9(this.f48559c, this.f48560d);
                break;
            case 1:
                this.f48558b.lambda$updateProperties$11(this.f48559c, this.f48560d);
                break;
            case 2:
                this.f48558b.lambda$runInUI$8(this.f48559c, this.f48560d);
                break;
            default:
                this.f48558b.lambda$runCmdsInUI$10(this.f48559c, this.f48560d);
                break;
        }
    }
}
