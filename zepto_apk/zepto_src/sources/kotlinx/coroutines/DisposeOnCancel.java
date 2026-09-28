package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
final class DisposeOnCancel implements CancelHandler {

    /* renamed from: a, reason: collision with root package name */
    public final DisposableHandle f54094a;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.f54094a = disposableHandle;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void b(Throwable th) {
        this.f54094a.dispose();
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.f54094a + ']';
    }
}
