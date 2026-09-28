package bridges;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements OnInitializationCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Promise f13225a;

    public /* synthetic */ a(Promise promise) {
        this.f13225a = promise;
    }

    @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
    public final void a(InitializationStatus initializationStatus) {
        GAMInitializerModule.initialize$lambda$0(this.f13225a, initializationStatus);
    }
}
