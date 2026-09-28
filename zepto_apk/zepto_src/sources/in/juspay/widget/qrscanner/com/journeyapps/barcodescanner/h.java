package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private int f49073a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f49074b;

    /* renamed from: c, reason: collision with root package name */
    private OrientationEventListener f49075c;

    /* renamed from: d, reason: collision with root package name */
    private g f49076d;

    public class a extends OrientationEventListener {
        public a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            int rotation;
            WindowManager windowManager = h.this.f49074b;
            g gVar = h.this.f49076d;
            if (h.this.f49074b == null || gVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == h.this.f49073a) {
                return;
            }
            h.this.f49073a = rotation;
            gVar.a(rotation);
        }
    }

    public void a() {
        OrientationEventListener orientationEventListener = this.f49075c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f49075c = null;
        this.f49074b = null;
        this.f49076d = null;
    }

    public void a(Context context, g gVar) {
        a();
        Context applicationContext = context.getApplicationContext();
        this.f49076d = gVar;
        this.f49074b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f49075c = aVar;
        aVar.enable();
        this.f49073a = this.f49074b.getDefaultDisplay().getRotation();
    }
}
