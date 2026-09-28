package coil3;

import coil3.util.Logger;
import coil3.util.LoggingKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Logger $logger$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, Logger logger) {
        super(key);
        this.$logger$inlined = logger;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Logger logger = this.$logger$inlined;
        if (logger != null) {
            LoggingKt.log(logger, "RealImageLoader", th);
        }
    }
}
