package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1507}, m = "write$suspendImpl")
/* loaded from: classes.dex */
final class ByteBufferChannel$write$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50786a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f50787b;

    /* renamed from: c, reason: collision with root package name */
    public int f50788c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50789d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50790e;

    /* renamed from: f, reason: collision with root package name */
    public int f50791f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$write$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50790e = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50789d = obj;
        this.f50791f |= Integer.MIN_VALUE;
        return ByteBufferChannel.P0(this.f50790e, 0, null, this);
    }
}
