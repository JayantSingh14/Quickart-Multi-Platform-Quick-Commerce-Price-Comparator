package in.juspay.hypersdk.core;

import android.app.Activity;
import android.webkit.PermissionRequest;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes4.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48612a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48613b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48614c;

    public /* synthetic */ l(int i2, Object obj, Object obj2) {
        this.f48612a = i2;
        this.f48614c = obj;
        this.f48613b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        switch (this.f48612a) {
            case 0:
                ((AndroidInterface) this.f48614c).lambda$processPendingAddScreen$21((String) this.f48613b);
                break;
            case 1:
                ((DynamicUI) this.f48614c).lambda$addJsToWebView$1((String) this.f48613b);
                break;
            case 2:
                ((DuiInterface) this.f48614c).lambda$clearMerchantViews$0((Activity) this.f48613b);
                break;
            case 3:
                ((DuiInterface) this.f48614c).lambda$requestKeyboardShow$7((String) this.f48613b);
                break;
            case 4:
                ((PermissionRequest) this.f48614c).grant((String[]) this.f48613b);
                break;
            case 5:
                ((JsInterface) this.f48614c).lambda$addLogProperties$0((String) this.f48613b);
                break;
            case 6:
                ((JuspayServices) this.f48614c).lambda$addFragment$11((FragmentActivity) this.f48613b);
                break;
            case 7:
                ((JuspayServices) this.f48614c).lambda$initiate$4((String) this.f48613b);
                break;
            case 8:
                ((JuspayServices) this.f48614c).lambda$initiate$5((Runnable) this.f48613b);
                break;
            case 9:
                ((Renderer) this.f48614c).lambda$initCache$0((String[]) this.f48613b);
                break;
            case 10:
                ((Renderer) this.f48614c).lambda$replenishCache$1((String) this.f48613b);
                break;
            default:
                ((SdkTracker) this.f48614c).lambda$setEndPointSandbox$18((Boolean) this.f48613b);
                break;
        }
    }
}
