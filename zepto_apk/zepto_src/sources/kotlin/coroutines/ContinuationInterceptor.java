package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {

    @NotNull
    public static final Key y0 = Key.f53684a;

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f53684a = new Key();
    }

    void s(Continuation continuation);

    DispatchedContinuation s0(ContinuationImpl continuationImpl);
}
