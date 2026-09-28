package in.juspay.hyperqr;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48487a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48488b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48489c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f48490d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f48491e;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f48487a = i2;
        this.f48488b = obj;
        this.f48489c = obj2;
        this.f48490d = obj3;
        this.f48491e = obj4;
    }

    private final void a() {
        CameraStreamScanner.startCamera$lambda$4$lambda$3((CameraStreamScanner) this.f48488b, (CameraSelector) this.f48489c, (Preview) this.f48490d, (ImageAnalysis) this.f48491e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48487a) {
            case 0:
                a();
                break;
            default:
                QrBridge.generateCustomQRCode$lambda$11$lambda$10((ImageView) this.f48488b, (Bitmap) this.f48489c, (QrBridge) this.f48490d, (String) this.f48491e);
                break;
        }
    }
}
