package in.juspay.hyperupi;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48771a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CLUtils f48772b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48773c;

    public /* synthetic */ b(CLUtils cLUtils, String str, int i2) {
        this.f48771a = i2;
        this.f48772b = cLUtils;
        this.f48773c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48771a) {
            case 0:
                CLUtils.unbindNPCICL$lambda$14(this.f48772b, this.f48773c);
                break;
            default:
                CLUtils.isUpiLiteSupported$lambda$8(this.f48772b, this.f48773c);
                break;
        }
    }
}
