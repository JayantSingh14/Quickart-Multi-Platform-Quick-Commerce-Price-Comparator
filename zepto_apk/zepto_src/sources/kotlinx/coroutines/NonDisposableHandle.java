package kotlinx.coroutines;

import kotlin.Metadata;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {

    /* renamed from: a, reason: collision with root package name */
    public static final NonDisposableHandle f54155a = new NonDisposableHandle();

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean b(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final Job getParent() {
        return null;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
