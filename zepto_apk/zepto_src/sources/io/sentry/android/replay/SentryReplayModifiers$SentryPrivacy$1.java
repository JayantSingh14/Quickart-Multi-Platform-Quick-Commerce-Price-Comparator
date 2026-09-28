package io.sentry.android.replay;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class SentryReplayModifiers$SentryPrivacy$1 extends Lambda implements Function2<String, String, String> {

    /* renamed from: c, reason: collision with root package name */
    public static final SentryReplayModifiers$SentryPrivacy$1 f52492c = new SentryReplayModifiers$SentryPrivacy$1(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter((String) obj2, "<anonymous parameter 1>");
        return str;
    }
}
