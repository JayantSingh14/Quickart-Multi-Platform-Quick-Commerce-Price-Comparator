package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback;

/* loaded from: classes4.dex */
public class d implements ResultPointCallback {

    /* renamed from: a, reason: collision with root package name */
    private b f49056a;

    public void a(b bVar) {
        this.f49056a = bVar;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        b bVar = this.f49056a;
        if (bVar != null) {
            bVar.foundPossibleResultPoint(resultPoint);
        }
    }
}
