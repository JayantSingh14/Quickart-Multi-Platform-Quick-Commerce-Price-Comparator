package in.juspay.hypersdk.analytics;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogPusher f48517b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48518c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f48519d;

    public /* synthetic */ b(LogPusher logPusher, String str, JSONObject jSONObject, int i2) {
        this.f48516a = i2;
        this.f48517b = logPusher;
        this.f48518c = str;
        this.f48519d = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48516a) {
            case 0:
                this.f48517b.lambda$setHeaders$3(this.f48518c, this.f48519d);
                break;
            default:
                this.f48517b.lambda$setLogHeaderValues$4(this.f48518c, this.f48519d);
                break;
        }
    }
}
