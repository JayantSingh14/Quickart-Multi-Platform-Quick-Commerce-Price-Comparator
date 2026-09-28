package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.Rect;
import android.util.Log;

/* loaded from: classes4.dex */
public class g extends l {

    /* renamed from: b, reason: collision with root package name */
    private static final String f49157b = "g";

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public float a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        if (iVar.f49078a <= 0 || iVar.f49079b <= 0) {
            return 0.0f;
        }
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVarB = iVar.b(iVar2);
        float fPow = (iVarB.f49078a * 1.0f) / iVar.f49078a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f2 = ((iVarB.f49079b * 1.0f) / iVar2.f49079b) + ((iVarB.f49078a * 1.0f) / iVar2.f49078a);
        return ((1.0f / f2) / f2) * fPow;
    }

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public Rect b(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVarB = iVar.b(iVar2);
        Log.i(f49157b, "Preview: " + iVar + "; Scaled: " + iVarB + "; Want: " + iVar2);
        int i2 = (iVarB.f49078a - iVar2.f49078a) / 2;
        int i3 = (iVarB.f49079b - iVar2.f49079b) / 2;
        return new Rect(-i2, -i3, iVarB.f49078a - i2, iVarB.f49079b - i3);
    }
}
