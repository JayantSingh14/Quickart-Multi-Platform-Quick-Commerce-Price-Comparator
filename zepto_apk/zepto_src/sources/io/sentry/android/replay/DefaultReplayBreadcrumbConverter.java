package io.sentry.android.replay;

import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.ReplayBreadcrumbConverter;
import java.util.HashSet;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@StabilityInferred(parameters = 0)
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class DefaultReplayBreadcrumbConverter implements ReplayBreadcrumbConverter {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f52401b = LazyKt.a(LazyThreadSafetyMode.f53530c, DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2.f52404c);

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f52402c;

    /* renamed from: a, reason: collision with root package name */
    public String f52403a;

    @Metadata
    public static final class Companion {
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("status_code");
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add("http.response_content_length");
        hashSet.add("http.request_content_length");
        f52402c = hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c0  */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, kotlin.Lazy] */
    @Override // io.sentry.ReplayBreadcrumbConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.rrweb.RRWebEvent a(io.sentry.Breadcrumb r11) {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.DefaultReplayBreadcrumbConverter.a(io.sentry.Breadcrumb):io.sentry.rrweb.RRWebEvent");
    }
}
