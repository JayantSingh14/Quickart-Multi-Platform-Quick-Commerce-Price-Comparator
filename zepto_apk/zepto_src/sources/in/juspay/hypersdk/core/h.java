package in.juspay.hypersdk.core;

import android.animation.ObjectAnimator;
import android.util.Pair;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48580a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48581b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48582c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48583d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f48584e;

    public /* synthetic */ h(AndroidInterface androidInterface, Object obj, String str, String str2, int i2) {
        this.f48580a = i2;
        this.f48581b = androidInterface;
        this.f48584e = obj;
        this.f48582c = str;
        this.f48583d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48580a) {
            case 0:
                ((AndroidInterface) this.f48581b).lambda$moveView$5(this.f48582c, this.f48583d, (String) this.f48584e);
                break;
            case 1:
                ((AndroidInterface) this.f48581b).lambda$startAnim$17((Pair) this.f48584e, this.f48582c, this.f48583d);
                break;
            case 2:
                ((AndroidInterface) this.f48581b).lambda$prepareAndStoreView$2(this.f48582c, (JSONObject) this.f48584e, this.f48583d);
                break;
            case 3:
                ((AndroidInterface) this.f48581b).lambda$cancelAnim$18((ObjectAnimator) this.f48584e, this.f48582c, this.f48583d);
                break;
            default:
                ((DuiInterface) this.f48581b).lambda$runInJuspayBrowser$4(this.f48582c, this.f48583d, (SdkTracker) this.f48584e);
                break;
        }
    }

    public /* synthetic */ h(AndroidInterface androidInterface, String str, JSONObject jSONObject, String str2) {
        this.f48580a = 2;
        this.f48581b = androidInterface;
        this.f48582c = str;
        this.f48584e = jSONObject;
        this.f48583d = str2;
    }

    public /* synthetic */ h(Object obj, String str, String str2, Object obj2, int i2) {
        this.f48580a = i2;
        this.f48581b = obj;
        this.f48582c = str;
        this.f48583d = str2;
        this.f48584e = obj2;
    }
}
