package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {

    /* renamed from: a, reason: collision with root package name */
    public final transient JobSupport f54122a;

    public JobCancellationException(String str, Throwable th, JobSupport jobSupport) {
        super(str);
        this.f54122a = jobSupport;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final /* bridge */ /* synthetic */ Throwable a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JobCancellationException)) {
            return false;
        }
        JobCancellationException jobCancellationException = (JobCancellationException) obj;
        return Intrinsics.b(jobCancellationException.getMessage(), getMessage()) && Intrinsics.b(jobCancellationException.f54122a, this.f54122a) && Intrinsics.b(jobCancellationException.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        Intrinsics.c(message);
        int iHashCode = (this.f54122a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f54122a;
    }
}
