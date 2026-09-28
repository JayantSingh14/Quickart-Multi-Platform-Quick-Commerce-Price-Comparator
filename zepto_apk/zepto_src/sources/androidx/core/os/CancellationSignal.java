package androidx.core.os;

import androidx.media3.exoplayer.analytics.q;

@Deprecated
/* loaded from: classes3.dex */
public final class CancellationSignal {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2873a;

    /* renamed from: b, reason: collision with root package name */
    public q f2874b;

    /* renamed from: c, reason: collision with root package name */
    public android.os.CancellationSignal f2875c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2876d;

    public interface OnCancelListener {
    }

    public final void a() {
        synchronized (this) {
            try {
                if (this.f2873a) {
                    return;
                }
                this.f2873a = true;
                this.f2876d = true;
                q qVar = this.f2874b;
                android.os.CancellationSignal cancellationSignal = this.f2875c;
                if (qVar != null) {
                    try {
                        qVar.b();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f2876d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
                synchronized (this) {
                    this.f2876d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }
}
