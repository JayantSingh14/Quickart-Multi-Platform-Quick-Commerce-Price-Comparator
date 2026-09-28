package in.juspay.hypersmshandler;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48758a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmsConsentHandler f48759b;

    public /* synthetic */ a(SmsConsentHandler smsConsentHandler, int i2) {
        this.f48758a = i2;
        this.f48759b = smsConsentHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48758a) {
            case 0:
                SmsConsentHandler.a(this.f48759b);
                break;
            default:
                SmsConsentHandler.b(this.f48759b);
                break;
        }
    }
}
