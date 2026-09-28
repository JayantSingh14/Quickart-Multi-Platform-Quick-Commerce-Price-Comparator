package io.sentry.android.replay.capture;

import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.util.HintUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements ScopeCallback, HintUtils.SentryHintFallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f52605a;

    public /* synthetic */ c(Object obj) {
        this.f52605a = obj;
    }

    public void a(Object obj) {
        ((io.sentry.transport.b) this.f52605a).a();
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope it) {
        int i2 = SessionCaptureStrategy.u;
        SessionCaptureStrategy this$0 = (SessionCaptureStrategy) this.f52605a;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        it.g(this$0.d());
        String strK = it.k();
        String strT = strK != null ? StringsKt.T(ClassUtils.PACKAGE_SEPARATOR_CHAR, strK, strK) : null;
        KProperty property = BaseCaptureStrategy.q[2];
        BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 = this$0.f52531l;
        baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52568a.getAndSet(strT);
        if (Intrinsics.b(andSet, strT)) {
            return;
        }
        BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass2(andSet, strT, baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52570c);
        BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52569b;
        boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
        SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
        if (zA) {
            ExecutorsKt.c(BaseCaptureStrategy.k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass1(anonymousClass2));
            return;
        }
        try {
            anonymousClass2.invoke();
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }
}
