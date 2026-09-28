package in.juspay.hypernfc;

import in.juspay.hypernfc.NfcActivity;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48483a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NfcActivity f48484b;

    public /* synthetic */ c(NfcActivity nfcActivity, int i2) {
        this.f48483a = i2;
        this.f48484b = nfcActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48483a) {
            case 0:
                NfcActivity.onNewIntent$lambda$3(this.f48484b);
                break;
            default:
                NfcActivity.AnonymousClass4.run$lambda$0(this.f48484b);
                break;
        }
    }
}
