package io.ktor.websocket;

import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: classes3.dex */
public final class NonDisposableHandle implements DisposableHandle {

    /* renamed from: a, reason: collision with root package name */
    public static final NonDisposableHandle f51460a = new NonDisposableHandle();

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
