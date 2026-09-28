package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1163, 1171}, m = "joinFromSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$joinFromSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50646a;

    /* renamed from: b, reason: collision with root package name */
    public int f50647b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50646a = obj;
        this.f50647b |= Integer.MIN_VALUE;
        throw null;
    }
}
