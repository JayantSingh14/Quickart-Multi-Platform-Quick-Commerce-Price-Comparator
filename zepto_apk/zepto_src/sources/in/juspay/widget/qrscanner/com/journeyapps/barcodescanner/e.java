package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.zxing.client.android.R;
import in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource;
import in.juspay.widget.qrscanner.com.google.zxing.Result;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: k, reason: collision with root package name */
    private static final String f49057k = "e";

    /* renamed from: a, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b f49058a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f49059b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f49060c;

    /* renamed from: d, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.b f49061d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f49062e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f49063f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f49064g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Object f49065h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private final Handler.Callback f49066i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.k f49067j = new b();

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == R.id.zxing_decode) {
                e.this.b((j) message.obj);
                return true;
            }
            if (i2 != R.id.zxing_preview_failed) {
                return true;
            }
            e.this.a();
            return true;
        }
    }

    public class b implements in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.k {
        public b() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.k
        public void a(j jVar) {
            synchronized (e.this.f49065h) {
                try {
                    if (e.this.f49064g) {
                        e.this.f49060c.obtainMessage(R.id.zxing_decode, jVar).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.k
        public void a(Exception exc) {
            synchronized (e.this.f49065h) {
                try {
                    if (e.this.f49064g) {
                        e.this.f49060c.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public e(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.b bVar2, Handler handler) {
        k.a();
        this.f49058a = bVar;
        this.f49061d = bVar2;
        this.f49062e = handler;
    }

    public LuminanceSource a(j jVar) {
        if (this.f49063f == null) {
            return null;
        }
        return jVar.a();
    }

    public void c() {
        k.a();
        synchronized (this.f49065h) {
            this.f49064g = false;
            this.f49060c.removeCallbacksAndMessages(null);
            this.f49059b.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f49058a.a(this.f49067j);
    }

    public void b() {
        k.a();
        HandlerThread handlerThread = new HandlerThread(f49057k);
        this.f49059b = handlerThread;
        handlerThread.start();
        this.f49060c = new Handler(this.f49059b.getLooper(), this.f49066i);
        this.f49064g = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar) {
        Message messageObtain;
        long jCurrentTimeMillis = System.currentTimeMillis();
        jVar.a(this.f49063f);
        LuminanceSource luminanceSourceA = a(jVar);
        Result resultA = luminanceSourceA != null ? this.f49061d.a(luminanceSourceA) : null;
        if (resultA != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f49057k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.f49062e != null) {
                messageObtain = Message.obtain(this.f49062e, R.id.zxing_decode_succeeded, new BarcodeResult(resultA, jVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f49062e;
            if (handler != null) {
                messageObtain = Message.obtain(handler, R.id.zxing_decode_failed);
                messageObtain.sendToTarget();
            }
        }
        if (this.f49062e != null) {
            Message.obtain(this.f49062e, R.id.zxing_possible_result_points, this.f49061d.a()).sendToTarget();
        }
        a();
    }

    public void a(Rect rect) {
        this.f49063f = rect;
    }

    public void a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.b bVar) {
        this.f49061d = bVar;
    }
}
