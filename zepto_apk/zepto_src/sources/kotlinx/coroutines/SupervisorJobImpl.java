package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
final class SupervisorJobImpl extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean C(Throwable th) {
        return false;
    }
}
