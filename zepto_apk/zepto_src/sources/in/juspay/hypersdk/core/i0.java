package in.juspay.hypersdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JuspayServices f48596b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f48597c;

    public /* synthetic */ i0(JuspayServices juspayServices, JSONObject jSONObject, int i2) {
        this.f48595a = i2;
        this.f48596b = juspayServices;
        this.f48597c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48595a) {
            case 0:
                this.f48596b.lambda$new$0(this.f48597c);
                break;
            default:
                this.f48596b.lambda$setBundleParameter$2(this.f48597c);
                break;
        }
    }
}
