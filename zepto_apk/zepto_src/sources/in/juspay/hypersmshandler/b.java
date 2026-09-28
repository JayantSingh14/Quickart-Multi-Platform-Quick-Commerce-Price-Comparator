package in.juspay.hypersmshandler;

import com.google.android.gms.tasks.OnSuccessListener;
import in.juspay.hyperupi.UPIBridge;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f48761b;

    public /* synthetic */ b(int i2, Function1 function1) {
        this.f48760a = i2;
        this.f48761b = function1;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        switch (this.f48760a) {
            case 0:
                SmsConsentHandler.a(this.f48761b, obj);
                break;
            case 1:
                SmsRetriever.a(this.f48761b, obj);
                break;
            case 2:
                UPIBridge.prepareIntegrityTokenProvider$lambda$2(this.f48761b, obj);
                break;
            case 3:
                UPIBridge.getPhoneNumber$lambda$8(this.f48761b, obj);
                break;
            default:
                UPIBridge.requestIntegrityToken$lambda$0(this.f48761b, obj);
                break;
        }
    }
}
