package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LimitedDispatcherKt {
    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Expected positive parallelism level, but got ").toString());
        }
    }
}
