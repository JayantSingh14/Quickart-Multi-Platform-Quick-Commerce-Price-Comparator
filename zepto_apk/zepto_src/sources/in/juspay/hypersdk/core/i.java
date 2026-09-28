package in.juspay.hypersdk.core;

import java.text.ParseException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48587a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48588b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48589c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f48590d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48591e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f48592f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f48593g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f48594h;

    public /* synthetic */ i(AndroidInterface androidInterface, String str, JSONObject jSONObject, int i2, boolean z, String str2, String str3) {
        this.f48593g = androidInterface;
        this.f48588b = str;
        this.f48594h = jSONObject;
        this.f48590d = i2;
        this.f48592f = z;
        this.f48589c = str2;
        this.f48591e = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws ParseException {
        switch (this.f48587a) {
            case 0:
                ((AndroidInterface) this.f48593g).lambda$addViewToParent$1(this.f48588b, (JSONObject) this.f48594h, this.f48590d, this.f48592f, this.f48589c, this.f48591e);
                break;
            default:
                ((JBridge) this.f48593g).lambda$startDatePicker$5(this.f48588b, this.f48589c, this.f48590d, this.f48591e, (String) this.f48594h, this.f48592f);
                break;
        }
    }

    public /* synthetic */ i(JBridge jBridge, String str, String str2, int i2, String str3, String str4, boolean z) {
        this.f48593g = jBridge;
        this.f48588b = str;
        this.f48589c = str2;
        this.f48590d = i2;
        this.f48591e = str3;
        this.f48594h = str4;
        this.f48592f = z;
    }
}
