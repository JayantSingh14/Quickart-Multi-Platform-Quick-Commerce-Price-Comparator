package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
class SnackbarManager {

    /* renamed from: e, reason: collision with root package name */
    public static SnackbarManager f41202e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f41203a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f41204b = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager snackbarManager = SnackbarManager.this;
            SnackbarRecord snackbarRecord = (SnackbarRecord) message.obj;
            synchronized (snackbarManager.f41203a) {
                try {
                    if (snackbarManager.f41205c == snackbarRecord || snackbarManager.f41206d == snackbarRecord) {
                        snackbarManager.a(snackbarRecord, 2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public SnackbarRecord f41205c;

    /* renamed from: d, reason: collision with root package name */
    public SnackbarRecord f41206d;

    public interface Callback {
        void a();

        void b(int i2);
    }

    public static class SnackbarRecord {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f41208a;

        /* renamed from: b, reason: collision with root package name */
        public int f41209b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f41210c;

        public SnackbarRecord(int i2, BaseTransientBottomBar.AnonymousClass5 anonymousClass5) {
            this.f41208a = new WeakReference(anonymousClass5);
            this.f41209b = i2;
        }
    }

    public static SnackbarManager b() {
        if (f41202e == null) {
            f41202e = new SnackbarManager();
        }
        return f41202e;
    }

    public final boolean a(SnackbarRecord snackbarRecord, int i2) {
        Callback callback = (Callback) snackbarRecord.f41208a.get();
        if (callback == null) {
            return false;
        }
        this.f41204b.removeCallbacksAndMessages(snackbarRecord);
        callback.b(i2);
        return true;
    }

    public final boolean c(Callback callback) {
        SnackbarRecord snackbarRecord = this.f41205c;
        return (snackbarRecord == null || callback == null || snackbarRecord.f41208a.get() != callback) ? false : true;
    }

    public final void d(BaseTransientBottomBar.AnonymousClass5 anonymousClass5) {
        synchronized (this.f41203a) {
            try {
                if (c(anonymousClass5)) {
                    SnackbarRecord snackbarRecord = this.f41205c;
                    if (!snackbarRecord.f41210c) {
                        snackbarRecord.f41210c = true;
                        this.f41204b.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(BaseTransientBottomBar.AnonymousClass5 anonymousClass5) {
        synchronized (this.f41203a) {
            try {
                if (c(anonymousClass5)) {
                    SnackbarRecord snackbarRecord = this.f41205c;
                    if (snackbarRecord.f41210c) {
                        snackbarRecord.f41210c = false;
                        f(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(SnackbarRecord snackbarRecord) {
        int i2 = snackbarRecord.f41209b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
        }
        Handler handler = this.f41204b;
        handler.removeCallbacksAndMessages(snackbarRecord);
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i2);
    }
}
