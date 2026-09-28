package io.sentry.android.core;

import android.app.Activity;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52239a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityFramesTracker f52240b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f52241c;

    public /* synthetic */ b(ActivityFramesTracker activityFramesTracker, Activity activity, int i2) {
        this.f52239a = i2;
        this.f52240b = activityFramesTracker;
        this.f52241c = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52239a) {
            case 0:
                this.f52240b.f51996a.a(this.f52241c);
                break;
            default:
                this.f52240b.f51996a.c(this.f52241c);
                break;
        }
    }
}
