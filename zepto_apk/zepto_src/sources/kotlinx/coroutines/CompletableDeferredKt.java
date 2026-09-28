package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CompletableDeferredKt {
    public static CompletableDeferred a() {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(true);
        completableDeferredImpl.S(null);
        return completableDeferredImpl;
    }
}
