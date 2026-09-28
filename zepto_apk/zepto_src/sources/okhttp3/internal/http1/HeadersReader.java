package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.RealBufferedSource;

@Metadata
/* loaded from: classes3.dex */
public final class HeadersReader {

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSource f56594a;

    /* renamed from: b, reason: collision with root package name */
    public long f56595b;

    @Metadata
    public static final class Companion {
    }

    public HeadersReader(RealBufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56594a = source;
        this.f56595b = 262144L;
    }
}
