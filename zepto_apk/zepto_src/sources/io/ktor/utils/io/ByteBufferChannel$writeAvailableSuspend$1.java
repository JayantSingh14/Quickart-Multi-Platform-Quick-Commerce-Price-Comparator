package io.ktor.utils.io;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1072, 1074, 1076}, m = "writeAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50792a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f50793b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50794c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50795d;

    /* renamed from: e, reason: collision with root package name */
    public int f50796e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeAvailableSuspend$1(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        super(continuation);
        this.f50795d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50794c = obj;
        this.f50796e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50795d.U0(null, this);
    }
}
