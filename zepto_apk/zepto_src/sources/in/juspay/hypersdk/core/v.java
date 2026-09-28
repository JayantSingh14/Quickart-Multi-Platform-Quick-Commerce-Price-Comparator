package in.juspay.hypersdk.core;

import android.webkit.PermissionRequest;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48701b;

    public /* synthetic */ v(Object obj, int i2) {
        this.f48700a = i2;
        this.f48701b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48700a) {
            case 0:
                ((InflateView) this.f48701b).lambda$dismissPopUp$12();
                break;
            case 1:
                ((PermissionRequest) this.f48701b).deny();
                break;
            default:
                SdkTracker.lambda$addToBootLogs$1((String) this.f48701b);
                break;
        }
    }
}
