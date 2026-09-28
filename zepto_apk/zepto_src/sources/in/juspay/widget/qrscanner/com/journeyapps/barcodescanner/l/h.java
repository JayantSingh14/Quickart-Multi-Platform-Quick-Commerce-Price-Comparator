package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i f49158a;

    /* renamed from: b, reason: collision with root package name */
    private int f49159b;

    /* renamed from: c, reason: collision with root package name */
    private l f49160c = new i();

    public h(int i2, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
        this.f49159b = i2;
        this.f49158a = iVar;
    }

    public int a() {
        return this.f49159b;
    }

    public Rect a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
        return this.f49160c.b(iVar, this.f49158a);
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i a(List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> list, boolean z) {
        return this.f49160c.b(list, a(z));
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i a(boolean z) {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar = this.f49158a;
        if (iVar == null) {
            return null;
        }
        return z ? iVar.a() : iVar;
    }

    public void a(l lVar) {
        this.f49160c = lVar;
    }
}
