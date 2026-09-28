package in.juspay.hyperqr;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48492a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f48493b;

    public /* synthetic */ c(int i2, Function1 function1) {
        this.f48492a = i2;
        this.f48493b = function1;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        switch (this.f48492a) {
            case 0:
                InputImageScanner.scanImage$lambda$0(this.f48493b, obj);
                break;
            default:
                QRCodeAnalyzer.analyze$lambda$0(this.f48493b, obj);
                break;
        }
    }
}
