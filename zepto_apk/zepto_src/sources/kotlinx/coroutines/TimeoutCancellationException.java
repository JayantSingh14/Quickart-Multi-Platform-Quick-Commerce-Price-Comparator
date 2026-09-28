package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {

    /* renamed from: a, reason: collision with root package name */
    public final transient Job f54164a;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.f54164a = job;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.f54164a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
