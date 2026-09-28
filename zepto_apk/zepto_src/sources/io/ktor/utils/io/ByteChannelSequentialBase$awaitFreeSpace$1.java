package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {799}, m = "awaitFreeSpace$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$awaitFreeSpace$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50899a;

    /* renamed from: b, reason: collision with root package name */
    public int f50900b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50899a = obj;
        this.f50900b |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        throw null;
    }
}
