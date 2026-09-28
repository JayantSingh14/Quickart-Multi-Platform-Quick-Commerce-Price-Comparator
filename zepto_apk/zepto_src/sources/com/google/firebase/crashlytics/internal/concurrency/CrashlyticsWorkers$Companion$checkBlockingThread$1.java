package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
final /* synthetic */ class CrashlyticsWorkers$Companion$checkBlockingThread$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((CrashlyticsWorkers.Companion) this.receiver).getClass();
        String threadName = CrashlyticsWorkers.Companion.b();
        Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
        return Boolean.valueOf(StringsKt.n(threadName, "Firebase Blocking Thread #", false));
    }
}
