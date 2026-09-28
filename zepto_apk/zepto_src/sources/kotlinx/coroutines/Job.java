package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface Job extends CoroutineContext.Element {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<Job> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f54121a = new Key();
    }

    DisposableHandle D(boolean z, boolean z2, Function1 function1);

    CancellationException O();

    ChildHandle T(JobSupport jobSupport);

    Object T0(Continuation continuation);

    boolean a();

    void e(CancellationException cancellationException);

    boolean isCancelled();

    DisposableHandle j0(Function1 function1);

    boolean start();
}
