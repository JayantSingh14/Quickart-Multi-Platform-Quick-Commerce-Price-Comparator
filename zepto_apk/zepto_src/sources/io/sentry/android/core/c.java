package io.sentry.android.core;

import io.sentry.ISpan;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52242a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityLifecycleIntegration f52243b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ISpan f52244c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ISpan f52245d;

    public /* synthetic */ c(ActivityLifecycleIntegration activityLifecycleIntegration, ISpan iSpan, ISpan iSpan2, int i2) {
        this.f52242a = i2;
        this.f52243b = activityLifecycleIntegration;
        this.f52244c = iSpan;
        this.f52245d = iSpan2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52242a) {
            case 0:
                this.f52243b.r(this.f52244c, this.f52245d);
                break;
            case 1:
                this.f52243b.r(this.f52244c, this.f52245d);
                break;
            default:
                this.f52243b.getClass();
                ActivityLifecycleIntegration.b(this.f52244c, this.f52245d);
                break;
        }
    }
}
