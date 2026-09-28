package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48568a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f48569b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48570c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f48571d;

    public /* synthetic */ f(AndroidInterface androidInterface, String str, int i2) {
        this.f48571d = androidInterface;
        this.f48570c = str;
        this.f48569b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48568a) {
            case 0:
                ((AndroidInterface) this.f48571d).lambda$removeView$6(this.f48570c, this.f48569b);
                break;
            default:
                ((DuiInterface) this.f48571d).lambda$attachMerchantView$1(this.f48569b, this.f48570c);
                break;
        }
    }

    public /* synthetic */ f(DuiInterface duiInterface, int i2, String str) {
        this.f48571d = duiInterface;
        this.f48569b = i2;
        this.f48570c = str;
    }
}
