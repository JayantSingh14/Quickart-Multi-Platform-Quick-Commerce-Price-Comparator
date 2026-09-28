package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class PublicCancelFutureOnCancel implements CancelHandler {
    @Override // kotlinx.coroutines.CancelHandler
    public final void b(Throwable th) {
        if (th != null) {
            throw null;
        }
    }

    public final String toString() {
        return "CancelFutureOnCancel[null]";
    }
}
