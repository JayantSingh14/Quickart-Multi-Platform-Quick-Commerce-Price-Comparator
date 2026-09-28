package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.Rect;

/* loaded from: classes4.dex */
public class j extends l {
    private static float a(float f2) {
        return f2 < 1.0f ? 1.0f / f2 : f2;
    }

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public Rect b(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        return new Rect(0, 0, iVar2.f49078a, iVar2.f49079b);
    }

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public float a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        int i2 = iVar.f49078a;
        if (i2 <= 0 || iVar.f49079b <= 0) {
            return 0.0f;
        }
        float fA = (1.0f / a((i2 * 1.0f) / iVar2.f49078a)) / a((iVar.f49079b * 1.0f) / iVar2.f49079b);
        float fA2 = a(((iVar.f49078a * 1.0f) / iVar.f49079b) / ((iVar2.f49078a * 1.0f) / iVar2.f49079b));
        return (((1.0f / fA2) / fA2) / fA2) * fA;
    }
}
