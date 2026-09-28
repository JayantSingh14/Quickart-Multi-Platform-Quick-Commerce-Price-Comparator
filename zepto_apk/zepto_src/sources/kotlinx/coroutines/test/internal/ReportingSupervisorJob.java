package kotlinx.coroutines.test.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.JobImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReportingSupervisorJob extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean C(Throwable th) {
        try {
            throw null;
        } catch (Throwable th2) {
            ExceptionsKt.a(th, th2);
            CoroutineExceptionHandlerKt.a(this, th);
            Unit unit = Unit.f53572a;
            return false;
        }
    }
}
