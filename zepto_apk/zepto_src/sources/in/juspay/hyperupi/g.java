package in.juspay.hyperupi;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes4.dex */
public final /* synthetic */ class g implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48793a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UPIBridge f48794b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48795c;

    public /* synthetic */ g(UPIBridge uPIBridge, String str, int i2) {
        this.f48793a = i2;
        this.f48794b = uPIBridge;
        this.f48795c = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        switch (this.f48793a) {
            case 0:
                UPIBridge.prepareIntegrityTokenProvider$lambda$3(this.f48794b, this.f48795c, exc);
                break;
            default:
                UPIBridge.requestIntegrityToken$lambda$1(this.f48794b, this.f48795c, exc);
                break;
        }
    }
}
