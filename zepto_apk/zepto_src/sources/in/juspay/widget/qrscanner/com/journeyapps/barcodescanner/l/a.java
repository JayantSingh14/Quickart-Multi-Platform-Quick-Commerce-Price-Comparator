package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static final String f49086i = "a";

    /* renamed from: j, reason: collision with root package name */
    private static final Collection<String> f49087j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f49088a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f49089b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f49090c;

    /* renamed from: d, reason: collision with root package name */
    private final Camera f49091d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f49092e;

    /* renamed from: f, reason: collision with root package name */
    private int f49093f = 1;

    /* renamed from: g, reason: collision with root package name */
    private final Handler.Callback f49094g;

    /* renamed from: h, reason: collision with root package name */
    private final Camera.AutoFocusCallback f49095h;

    /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a$a, reason: collision with other inner class name */
    public class C0058a implements Handler.Callback {
        public C0058a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f49093f) {
                return false;
            }
            a.this.c();
            return true;
        }
    }

    public class b implements Camera.AutoFocusCallback {

        /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a$b$a, reason: collision with other inner class name */
        public class RunnableC0059a implements Runnable {
            public RunnableC0059a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f49089b = false;
                a.this.a();
            }
        }

        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            a.this.f49092e.post(new RunnableC0059a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f49087j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, d dVar) {
        C0058a c0058a = new C0058a();
        this.f49094g = c0058a;
        this.f49095h = new b();
        this.f49092e = new Handler(c0058a);
        this.f49091d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = dVar.c() && f49087j.contains(focusMode);
        this.f49090c = z;
        Log.i(f49086i, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        d();
    }

    private void b() {
        this.f49092e.removeMessages(this.f49093f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.f49090c || this.f49088a || this.f49089b) {
            return;
        }
        try {
            this.f49091d.autoFocus(this.f49095h);
            this.f49089b = true;
        } catch (RuntimeException e2) {
            Log.w(f49086i, "Unexpected exception while focusing", e2);
            a();
        }
    }

    public void e() {
        this.f49088a = true;
        this.f49089b = false;
        b();
        if (this.f49090c) {
            try {
                this.f49091d.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f49086i, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        if (!this.f49088a && !this.f49092e.hasMessages(this.f49093f)) {
            Handler handler = this.f49092e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f49093f), 2000L);
        }
    }

    public void d() {
        this.f49088a = false;
        c();
    }
}
