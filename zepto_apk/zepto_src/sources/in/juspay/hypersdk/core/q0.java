package in.juspay.hypersdk.core;

import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48648a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48649b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48650c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48651d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48652e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f48653f;

    public /* synthetic */ q0(String str, String str2, String str3, String str4, Object obj, int i2) {
        this.f48648a = i2;
        this.f48649b = str;
        this.f48650c = str2;
        this.f48651d = str3;
        this.f48652e = str4;
        this.f48653f = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48648a) {
            case 0:
                SdkTracker.lambda$trackBootLifecycle$2(this.f48649b, this.f48650c, this.f48651d, this.f48652e, this.f48653f);
                break;
            default:
                SdkTracker.lambda$trackBootAction$3(this.f48649b, this.f48650c, this.f48651d, this.f48652e, this.f48653f);
                break;
        }
    }
}
