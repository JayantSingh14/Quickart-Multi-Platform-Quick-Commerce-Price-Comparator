package in.juspay.hypersdk.core;

import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JuspayServices f48624b;

    public /* synthetic */ n(JuspayServices juspayServices, int i2) {
        this.f48623a = i2;
        this.f48624b = juspayServices;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48623a) {
            case 0:
                this.f48624b.terminate();
                break;
            case 1:
                this.f48624b.lambda$removeFragment$12();
                break;
            case 2:
                this.f48624b.lambda$setBundleParameter$3();
                break;
            case 3:
                this.f48624b.lambda$reset$9();
                break;
            default:
                this.f48624b.lambda$initiate$6();
                break;
        }
    }
}
