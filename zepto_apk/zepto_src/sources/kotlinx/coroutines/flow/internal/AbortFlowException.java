package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class AbortFlowException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object f54937a;

    public AbortFlowException(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.f54937a = obj;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
