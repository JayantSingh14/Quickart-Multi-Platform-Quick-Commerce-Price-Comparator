package in.juspay.widget.qrscanner.com.google.zxing.client.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes4.dex */
public final class InactivityTimer {

    /* renamed from: a, reason: collision with root package name */
    private final Context f48852a;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f48856e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f48857f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f48854c = false;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f48853b = new PowerStatusReceiver();

    /* renamed from: d, reason: collision with root package name */
    private Handler f48855d = new Handler();

    public final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                InactivityTimer.this.f48855d.post(new Runnable() { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.InactivityTimer.PowerStatusReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InactivityTimer.this.a(z);
                    }
                });
            }
        }
    }

    public InactivityTimer(Context context, Runnable runnable) {
        this.f48852a = context;
        this.f48856e = runnable;
    }

    private void b() {
        if (this.f48854c) {
            return;
        }
        this.f48852a.registerReceiver(this.f48853b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f48854c = true;
    }

    private void c() {
        if (this.f48854c) {
            this.f48852a.unregisterReceiver(this.f48853b);
            this.f48854c = false;
        }
    }

    public void activity() {
        a();
        if (this.f48857f) {
            this.f48855d.postDelayed(this.f48856e, 300000L);
        }
    }

    public void cancel() {
        a();
        c();
    }

    public void start() {
        b();
        activity();
    }

    private void a() {
        this.f48855d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f48857f = z;
        if (this.f48854c) {
            activity();
        }
    }
}
