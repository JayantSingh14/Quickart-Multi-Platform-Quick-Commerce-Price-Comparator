package io.sentry.android.replay;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ReplayCache$persistSegmentValues$2 extends Lambda implements Function1<Map.Entry<String, String>, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final ReplayCache$persistSegmentValues$2 f52427c = new ReplayCache$persistSegmentValues$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
    }
}
