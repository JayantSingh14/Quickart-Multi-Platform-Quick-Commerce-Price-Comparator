package io.sentry.android.core.performance;

import android.os.Handler;
import android.os.Looper;
import io.sentry.ITransactionProfiler;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52385a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppStartMetrics f52386b;

    public /* synthetic */ a(AppStartMetrics appStartMetrics, int i2) {
        this.f52385a = i2;
        this.f52386b = appStartMetrics;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52385a) {
            case 0:
                AppStartMetrics appStartMetrics = AppStartMetrics.o;
                AppStartMetrics appStartMetrics2 = this.f52386b;
                appStartMetrics2.getClass();
                new Handler(Looper.getMainLooper()).post(new a(appStartMetrics2, 3));
                break;
            case 1:
                AppStartMetrics appStartMetrics3 = AppStartMetrics.o;
                this.f52386b.c();
                break;
            case 2:
                AppStartMetrics appStartMetrics4 = AppStartMetrics.o;
                this.f52386b.c();
                break;
            default:
                AppStartMetrics appStartMetrics5 = this.f52386b;
                if (appStartMetrics5.f52378l.get() == 0) {
                    appStartMetrics5.f52368b = false;
                    ITransactionProfiler iTransactionProfiler = appStartMetrics5.f52374h;
                    if (iTransactionProfiler != null && iTransactionProfiler.isRunning()) {
                        appStartMetrics5.f52374h.close();
                        appStartMetrics5.f52374h = null;
                        break;
                    }
                }
                break;
        }
    }
}
