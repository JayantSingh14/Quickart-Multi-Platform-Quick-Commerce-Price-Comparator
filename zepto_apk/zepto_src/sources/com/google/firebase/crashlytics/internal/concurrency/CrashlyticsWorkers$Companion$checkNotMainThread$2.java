package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes.dex */
final class CrashlyticsWorkers$Companion$checkNotMainThread$2 extends Lambda implements Function0<String> {

    /* renamed from: c, reason: collision with root package name */
    public static final CrashlyticsWorkers$Companion$checkNotMainThread$2 f43879c = new CrashlyticsWorkers$Companion$checkNotMainThread$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return "Must not be called on a main thread, was called on " + CrashlyticsWorkers.Companion.b() + ClassUtils.PACKAGE_SEPARATOR_CHAR;
    }
}
