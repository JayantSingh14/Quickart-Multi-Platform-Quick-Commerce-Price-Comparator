package io.sentry.android.replay;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata
/* loaded from: classes.dex */
public final class DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2 extends Lambda implements Function0<Regex> {

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2 f52404c = new DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Regex("_[a-z]");
    }
}
