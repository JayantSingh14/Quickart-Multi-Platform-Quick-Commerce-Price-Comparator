package in.juspay.hypersdk.core;

import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48544a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48545b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48546c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f48547d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f48548e;

    public /* synthetic */ c(AndroidInterface androidInterface, String str, int i2, JSONArray jSONArray) {
        this.f48545b = androidInterface;
        this.f48546c = str;
        this.f48547d = i2;
        this.f48548e = jSONArray;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48544a) {
            case 0:
                ((AndroidInterface) this.f48545b).lambda$updateAnim$19((String) this.f48546c, this.f48547d, (JSONArray) this.f48548e);
                break;
            case 1:
                ((AndroidInterface) this.f48545b).lambda$replaceView$4((String) this.f48546c, (JSONObject) this.f48548e, this.f48547d);
                break;
            default:
                ((JBridge) this.f48545b).lambda$drawIcon$2(this.f48547d, (Drawable) this.f48546c, (SdkTracker) this.f48548e);
                break;
        }
    }

    public /* synthetic */ c(AndroidInterface androidInterface, String str, JSONObject jSONObject, int i2) {
        this.f48545b = androidInterface;
        this.f48546c = str;
        this.f48548e = jSONObject;
        this.f48547d = i2;
    }

    public /* synthetic */ c(JBridge jBridge, int i2, Drawable drawable, SdkTracker sdkTracker) {
        this.f48545b = jBridge;
        this.f48547d = i2;
        this.f48546c = drawable;
        this.f48548e = sdkTracker;
    }
}
