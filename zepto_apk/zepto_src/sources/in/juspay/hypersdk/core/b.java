package in.juspay.hypersdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48536a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48537b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48538c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48539d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48540e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f48541f;

    public /* synthetic */ b(AndroidInterface androidInterface, JSONObject jSONObject, String str, String str2, String str3) {
        this.f48536a = 1;
        this.f48537b = androidInterface;
        this.f48541f = jSONObject;
        this.f48538c = str;
        this.f48539d = str2;
        this.f48540e = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48536a) {
            case 0:
                ((AndroidInterface) this.f48537b).lambda$runInUI$7(this.f48538c, this.f48539d, this.f48540e, (String) this.f48541f);
                break;
            case 1:
                ((AndroidInterface) this.f48537b).lambda$render$0((JSONObject) this.f48541f, this.f48538c, this.f48539d, this.f48540e);
                break;
            case 2:
                SdkTracker.lambda$trackBootException$4(this.f48538c, this.f48539d, this.f48540e, (String) this.f48541f, (Throwable) this.f48537b);
                break;
            case 3:
                ((SdkTracker) this.f48537b).lambda$trackLifecycle$7(this.f48538c, this.f48539d, this.f48540e, (JSONObject) this.f48541f);
                break;
            default:
                ((SdkTracker) this.f48537b).lambda$trackContext$12(this.f48538c, this.f48539d, this.f48540e, this.f48541f);
                break;
        }
    }

    public /* synthetic */ b(Object obj, String str, String str2, String str3, Object obj2, int i2) {
        this.f48536a = i2;
        this.f48537b = obj;
        this.f48538c = str;
        this.f48539d = str2;
        this.f48540e = str3;
        this.f48541f = obj2;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, Throwable th) {
        this.f48536a = 2;
        this.f48538c = str;
        this.f48539d = str2;
        this.f48540e = str3;
        this.f48541f = str4;
        this.f48537b = th;
    }
}
