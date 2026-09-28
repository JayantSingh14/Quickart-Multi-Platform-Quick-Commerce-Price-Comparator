package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.ComponentActivity$fullyDrawnReporter$2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f189a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f190b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f189a = i2;
        this.f190b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f189a) {
            case 0:
                ComponentActivity.ReportFullyDrawnExecutorImpl this$0 = (ComponentActivity.ReportFullyDrawnExecutorImpl) this.f190b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Runnable runnable = this$0.f128b;
                if (runnable != null) {
                    runnable.run();
                    this$0.f128b = null;
                    return;
                }
                return;
            case 1:
                FullyDrawnReporter this$02 = (FullyDrawnReporter) this.f190b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                synchronized (this$02.f143c) {
                    try {
                        if (!this$02.f144d) {
                            ((ComponentActivity$fullyDrawnReporter$2.AnonymousClass1) this$02.f142b).invoke();
                            this$02.a();
                        }
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                ComponentDialog.a((ComponentDialog) this.f190b);
                return;
        }
    }
}
