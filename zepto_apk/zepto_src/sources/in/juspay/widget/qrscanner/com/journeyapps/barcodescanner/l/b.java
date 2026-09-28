package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R;

/* loaded from: classes4.dex */
public class b {
    private static final String n = "b";

    /* renamed from: a, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.f f49099a;

    /* renamed from: b, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e f49100b;

    /* renamed from: c, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.c f49101c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f49102d;

    /* renamed from: e, reason: collision with root package name */
    private h f49103e;

    /* renamed from: h, reason: collision with root package name */
    private Handler f49106h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f49104f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f49105g = true;

    /* renamed from: i, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d f49107i = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d();

    /* renamed from: j, reason: collision with root package name */
    private Runnable f49108j = new c();

    /* renamed from: k, reason: collision with root package name */
    private Runnable f49109k = new d();

    /* renamed from: l, reason: collision with root package name */
    private Runnable f49110l = new e();

    /* renamed from: m, reason: collision with root package name */
    private Runnable f49111m = new f();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f49112a;

        public a(boolean z) {
            this.f49112a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f49101c.b(this.f49112a);
        }
    }

    /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b$b, reason: collision with other inner class name */
    public class RunnableC0060b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f49114a;

        /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f49101c.a(RunnableC0060b.this.f49114a);
            }
        }

        public RunnableC0060b(k kVar) {
            this.f49114a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f49104f) {
                b.this.f49099a.a(new a());
            } else {
                Log.d(b.n, "Camera is closed, not requesting preview");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.n, "Opening camera");
                b.this.f49101c.j();
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.n, "Failed to open camera", e2);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.n, "Configuring camera");
                b.this.f49101c.d();
                if (b.this.f49102d != null) {
                    b.this.f49102d.obtainMessage(R.id.zxing_prewiew_size_ready, b.this.e()).sendToTarget();
                }
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.n, "Failed to configure camera", e2);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.n, "Starting preview");
                b.this.f49101c.a(b.this.f49100b);
                b.this.f49101c.l();
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.n, "Failed to start preview", e2);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.n, "Closing camera");
                b.this.f49101c.m();
                b.this.f49101c.c();
            } catch (Exception e2) {
                Log.e(b.n, "Failed to close camera", e2);
            }
            b.this.f49105g = true;
            b.this.f49102d.sendEmptyMessage(R.id.zxing_camera_closed);
            b.this.f49099a.b();
        }
    }

    public b(Context context) {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        this.f49099a = in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.f.c();
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.c cVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.c(context);
        this.f49101c = cVar;
        cVar.a(this.f49107i);
        this.f49106h = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i e() {
        return this.f49101c.g();
    }

    private void i() {
        if (!this.f49104f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public void b() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        if (this.f49104f) {
            this.f49099a.a(this.f49111m);
        } else {
            this.f49105g = true;
        }
        this.f49104f = false;
    }

    public void g() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        this.f49104f = true;
        this.f49105g = false;
        this.f49099a.b(this.f49108j);
    }

    public void h() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        i();
        this.f49099a.a(this.f49110l);
    }

    public void c() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        i();
        this.f49099a.a(this.f49109k);
    }

    public h d() {
        return this.f49103e;
    }

    public boolean f() {
        return this.f49105g;
    }

    public void a(Handler handler) {
        this.f49102d = handler;
    }

    public void a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d dVar) {
        if (this.f49104f) {
            return;
        }
        this.f49107i = dVar;
        this.f49101c.a(dVar);
    }

    public void a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e eVar) {
        this.f49100b = eVar;
    }

    public void a(h hVar) {
        this.f49103e = hVar;
        this.f49101c.a(hVar);
    }

    public void a(k kVar) {
        this.f49106h.post(new RunnableC0060b(kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        Handler handler = this.f49102d;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public void a(boolean z) {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.k.a();
        if (this.f49104f) {
            this.f49099a.a(new a(z));
        }
    }
}
