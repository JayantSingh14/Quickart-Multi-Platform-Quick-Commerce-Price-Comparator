package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* loaded from: classes3.dex */
final class AudioBecomingNoisyManager {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6096a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioBecomingNoisyReceiver f6097b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6098c;

    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final EventListener f6099a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f6100b;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.f6100b = handler;
            this.f6099a = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f6100b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AudioBecomingNoisyManager.this.f6098c) {
                this.f6099a.h();
            }
        }
    }

    public interface EventListener {
        void h();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f6096a = context.getApplicationContext();
        this.f6097b = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public final void a() {
        if (this.f6098c) {
            this.f6096a.unregisterReceiver(this.f6097b);
            this.f6098c = false;
        }
    }
}
