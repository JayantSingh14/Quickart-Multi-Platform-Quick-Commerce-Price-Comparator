package in.juspay.hypersdk.core;

import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48625a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SdkTracker f48626b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48627c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48628d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48629e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f48630f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f48631g;

    public /* synthetic */ n0(SdkTracker sdkTracker, String str, String str2, String str3, String str4, Object obj, int i2) {
        this.f48625a = i2;
        this.f48626b = sdkTracker;
        this.f48627c = str;
        this.f48628d = str2;
        this.f48629e = str3;
        this.f48630f = str4;
        this.f48631g = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48625a) {
            case 0:
                this.f48626b.lambda$trackLifecycle$6(this.f48627c, this.f48628d, this.f48629e, this.f48630f, this.f48631g);
                break;
            case 1:
                this.f48626b.lambda$trackAction$8(this.f48627c, this.f48628d, this.f48629e, this.f48630f, this.f48631g);
                break;
            default:
                this.f48626b.lambda$trackContext$11(this.f48627c, this.f48628d, this.f48629e, this.f48630f, this.f48631g);
                break;
        }
    }
}
