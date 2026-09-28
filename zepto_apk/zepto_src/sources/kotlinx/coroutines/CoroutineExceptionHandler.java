package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f54075a = new Key();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
