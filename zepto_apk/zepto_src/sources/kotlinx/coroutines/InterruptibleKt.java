package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: classes3.dex */
public final class InterruptibleKt {
    public static Object a(coil3.decode.a aVar, Continuation continuation) {
        return BuildersKt.e(EmptyCoroutineContext.f53685a, new InterruptibleKt$runInterruptible$2(aVar, null), continuation);
    }
}
