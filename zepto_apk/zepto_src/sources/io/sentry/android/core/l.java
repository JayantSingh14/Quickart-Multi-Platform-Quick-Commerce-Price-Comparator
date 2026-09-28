package io.sentry.android.core;

import io.sentry.FullyDisplayedReporter;
import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.Session;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements ScopeCallback, FullyDisplayedReporter.FullyDisplayedReporterListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52353b;

    public /* synthetic */ l(Object obj, int i2) {
        this.f52352a = i2;
        this.f52353b = obj;
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope iScope) {
        Session sessionY;
        Object obj = this.f52353b;
        switch (this.f52352a) {
            case 0:
                AtomicLong atomicLong = ((LifecycleWatcher) obj).f52144a;
                if (atomicLong.get() == 0 && (sessionY = iScope.y()) != null) {
                    Date date = sessionY.f51894a;
                    if ((date == null ? null : (Date) date.clone()) != null) {
                        atomicLong.set((date != null ? (Date) date.clone() : null).getTime());
                        break;
                    }
                }
                break;
            case 1:
                iScope.B((String) obj);
                break;
            default:
                int i2 = SentryAndroid.f52194b;
                Session sessionY2 = iScope.y();
                if (sessionY2 != null) {
                    Date date2 = sessionY2.f51894a;
                    if ((date2 != null ? (Date) date2.clone() : null) != null) {
                        ((AtomicBoolean) obj).set(true);
                        break;
                    }
                }
                break;
        }
    }
}
