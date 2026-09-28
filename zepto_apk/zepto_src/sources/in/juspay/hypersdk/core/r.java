package in.juspay.hypersdk.core;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hypersdk.safe.JuspayWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48654a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48655b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48656c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f48657d;

    public /* synthetic */ r(JsInterface jsInterface, String str, Object obj, int i2) {
        this.f48654a = i2;
        this.f48656c = jsInterface;
        this.f48655b = str;
        this.f48657d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48654a) {
            case 0:
                ((DynamicUI) this.f48656c).lambda$addJavascriptInterface$2(this.f48657d, (String) this.f48655b);
                break;
            case 1:
                DuiInterface.lambda$loadUrl$6((String) this.f48655b, (JuspayWebView) this.f48656c, (String) this.f48657d);
                break;
            case 2:
                ((DuiInterface) this.f48656c).lambda$runInJuspayWebView$5((String) this.f48655b, (JuspayWebView) this.f48657d);
                break;
            case 3:
                ((DuiInterface) this.f48656c).lambda$runInJuspayBrowser$3((String) this.f48655b, (SdkTracker) this.f48657d);
                break;
            case 4:
                ((JsInterface) this.f48656c).lambda$requestPendingLogs$2((String) this.f48655b, (String) this.f48657d);
                break;
            case 5:
                ((JsInterface) this.f48656c).lambda$setAnalyticsHeader$1((JSONObject) this.f48657d, (String) this.f48655b);
                break;
            case 6:
                ((JuspayServices) this.f48656c).lambda$process$8((ViewGroup) this.f48657d, (FragmentActivity) this.f48655b);
                break;
            default:
                ((JuspayServices) this.f48656c).lambda$logMemoryInfo$1((Context) this.f48657d, (SdkTracker) this.f48655b);
                break;
        }
    }

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, int i2) {
        this.f48654a = i2;
        this.f48656c = obj;
        this.f48657d = obj2;
        this.f48655b = obj3;
    }

    public /* synthetic */ r(String str, JuspayWebView juspayWebView, String str2) {
        this.f48654a = 1;
        this.f48655b = str;
        this.f48656c = juspayWebView;
        this.f48657d = str2;
    }
}
