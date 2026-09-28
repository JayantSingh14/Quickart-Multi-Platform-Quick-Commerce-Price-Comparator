package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.Rect;
import android.util.Log;

/* loaded from: classes4.dex */
public class i extends l {

    /* renamed from: b, reason: collision with root package name */
    private static final String f49161b = "i";

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public float a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        if (iVar.f49078a <= 0 || iVar.f49079b <= 0) {
            return 0.0f;
        }
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVarC = iVar.c(iVar2);
        float fPow = (iVarC.f49078a * 1.0f) / iVar.f49078a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f2 = ((iVar2.f49079b * 1.0f) / iVarC.f49079b) * ((iVar2.f49078a * 1.0f) / iVarC.f49078a);
        return (((1.0f / f2) / f2) / f2) * fPow;
    }

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l
    public Rect b(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVarC = iVar.c(iVar2);
        Log.i(f49161b, "Preview: " + iVar + "; Scaled: " + iVarC + "; Want: " + iVar2);
        int i2 = (iVarC.f49078a - iVar2.f49078a) / 2;
        int i3 = (iVarC.f49079b - iVar2.f49079b) / 2;
        return new Rect(-i2, -i3, iVarC.f49078a - i2, iVarC.f49079b - i3);
    }
}
