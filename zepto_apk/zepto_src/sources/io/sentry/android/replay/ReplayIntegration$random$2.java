package io.sentry.android.replay;

import io.sentry.util.Random;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class ReplayIntegration$random$2 extends Lambda implements Function0<Random> {

    /* renamed from: c, reason: collision with root package name */
    public static final ReplayIntegration$random$2 f52453c = new ReplayIntegration$random$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Random();
    }
}
