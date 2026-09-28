package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata
/* loaded from: classes3.dex */
final class UnsafeBlockingTrampoline extends CoroutineDispatcher {

    /* renamed from: b, reason: collision with root package name */
    public static final UnsafeBlockingTrampoline f51345b = new UnsafeBlockingTrampoline();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext context, Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        block.run();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return true;
    }
}
