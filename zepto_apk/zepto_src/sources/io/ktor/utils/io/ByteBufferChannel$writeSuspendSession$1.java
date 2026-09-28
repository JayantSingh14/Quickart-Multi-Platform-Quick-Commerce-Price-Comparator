package io.ktor.utils.io;

import io.ktor.utils.io.internal.WriteSessionImpl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1835}, m = "writeSuspendSession$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeSuspendSession$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public WriteSessionImpl f50868a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50869b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50870c;

    /* renamed from: d, reason: collision with root package name */
    public int f50871d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspendSession$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50870c = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50869b = obj;
        this.f50871d |= Integer.MIN_VALUE;
        return ByteBufferChannel.g1(this.f50870c, null, this);
    }
}
