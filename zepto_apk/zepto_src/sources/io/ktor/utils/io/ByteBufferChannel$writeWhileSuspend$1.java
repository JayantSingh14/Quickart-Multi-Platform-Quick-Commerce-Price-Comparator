package io.ktor.utils.io;

import io.ktor.utils.io.internal.RingBufferCapacity;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1537, 1549}, m = "writeWhileSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeWhileSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50873a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f50874b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.BooleanRef f50875c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBufferChannel f50876d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBufferChannel f50877e;

    /* renamed from: f, reason: collision with root package name */
    public RingBufferCapacity f50878f;

    /* renamed from: g, reason: collision with root package name */
    public RingBufferCapacity f50879g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f50880h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBufferChannel f50881i;

    /* renamed from: j, reason: collision with root package name */
    public long f50882j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f50883k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50884l;

    /* renamed from: m, reason: collision with root package name */
    public int f50885m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeWhileSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50884l = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50883k = obj;
        this.f50885m |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50884l.i1(null, this);
    }
}
