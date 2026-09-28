package kotlinx.coroutines.test;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TestCoroutineExceptionHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55300a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f55301b;

    public TestCoroutineExceptionHandler() {
        super(CoroutineExceptionHandler.Key.f54075a);
        this.f55300a = new ArrayList();
        this.f55301b = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        synchronized (this.f55301b) {
            this.f55300a.add(th);
            Unit unit = Unit.f53572a;
        }
    }
}
