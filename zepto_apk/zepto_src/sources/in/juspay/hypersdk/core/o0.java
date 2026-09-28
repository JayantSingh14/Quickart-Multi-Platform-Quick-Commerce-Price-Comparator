package in.juspay.hypersdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SdkTracker f48635b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f48636c;

    public /* synthetic */ o0(SdkTracker sdkTracker, JSONObject jSONObject, int i2) {
        this.f48634a = i2;
        this.f48635b = sdkTracker;
        this.f48636c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48634a) {
            case 0:
                this.f48635b.lambda$addLogToPersistedQueue$14(this.f48636c);
                break;
            default:
                this.f48635b.lambda$track$17(this.f48636c);
                break;
        }
    }
}
