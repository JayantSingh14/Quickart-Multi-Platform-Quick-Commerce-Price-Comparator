package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes4.dex */
class f {

    /* renamed from: e, reason: collision with root package name */
    private static f f49152e;

    /* renamed from: a, reason: collision with root package name */
    private Handler f49153a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f49154b;

    /* renamed from: c, reason: collision with root package name */
    private int f49155c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final Object f49156d = new Object();

    private f() {
    }

    private void a() {
        synchronized (this.f49156d) {
            try {
                if (this.f49153a == null) {
                    if (this.f49155c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f49154b = handlerThread;
                    handlerThread.start();
                    this.f49153a = new Handler(this.f49154b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f c() {
        if (f49152e == null) {
            f49152e = new f();
        }
        return f49152e;
    }

    private void d() {
        synchronized (this.f49156d) {
            this.f49154b.quit();
            this.f49154b = null;
            this.f49153a = null;
        }
    }

    public void b() {
        synchronized (this.f49156d) {
            try {
                int i2 = this.f49155c - 1;
                this.f49155c = i2;
                if (i2 == 0) {
                    d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Runnable runnable) {
        synchronized (this.f49156d) {
            a();
            this.f49153a.post(runnable);
        }
    }

    public void b(Runnable runnable) {
        synchronized (this.f49156d) {
            this.f49155c++;
            a(runnable);
        }
    }
}
