package androidx.media3.session;

import android.os.Handler;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Log;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class SequencedFutureManager {

    /* renamed from: b, reason: collision with root package name */
    public int f10221b;

    /* renamed from: d, reason: collision with root package name */
    public a0 f10223d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f10224e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10225f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f10220a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f10222c = new ArrayMap();

    public static final class SequencedFuture<T> extends AbstractFuture<T> {

        /* renamed from: h, reason: collision with root package name */
        public final int f10226h;

        /* renamed from: i, reason: collision with root package name */
        public final SessionResult f10227i;

        public SequencedFuture(int i2, SessionResult sessionResult) {
            this.f10226h = i2;
            this.f10227i = sessionResult;
        }

        public final void r() {
            super.n(this.f10227i);
        }
    }

    public final int a() {
        int i2;
        synchronized (this.f10220a) {
            i2 = this.f10221b;
            this.f10221b = i2 + 1;
        }
        return i2;
    }

    public final void b() {
        ArrayList arrayList;
        synchronized (this.f10220a) {
            try {
                this.f10225f = true;
                arrayList = new ArrayList(this.f10222c.values());
                this.f10222c.clear();
                if (this.f10223d != null) {
                    Handler handler = this.f10224e;
                    handler.getClass();
                    handler.post(this.f10223d);
                    this.f10223d = null;
                    this.f10224e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).r();
        }
    }

    public final void c(int i2, Object obj) {
        synchronized (this.f10220a) {
            try {
                SequencedFuture sequencedFuture = (SequencedFuture) this.f10222c.remove(Integer.valueOf(i2));
                if (sequencedFuture != null) {
                    if (SessionResult.class == obj.getClass()) {
                        sequencedFuture.n(obj);
                    } else {
                        Log.h("SequencedFutureManager", "Type mismatch, expected " + SessionResult.class + ", but was " + obj.getClass());
                    }
                }
                if (this.f10223d != null && this.f10222c.isEmpty()) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
