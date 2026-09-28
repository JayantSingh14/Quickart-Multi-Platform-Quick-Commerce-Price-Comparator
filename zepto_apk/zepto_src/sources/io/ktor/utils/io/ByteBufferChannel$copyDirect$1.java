package io.ktor.utils.io;

import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1200, 1271, 1279}, m = "copyDirect$ktor_io")
/* loaded from: classes3.dex */
final class ByteBufferChannel$copyDirect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50627a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBufferChannel f50628b;

    /* renamed from: c, reason: collision with root package name */
    public JoiningState f50629c;

    /* renamed from: d, reason: collision with root package name */
    public Ref.LongRef f50630d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBufferChannel f50631e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBufferChannel f50632f;

    /* renamed from: g, reason: collision with root package name */
    public RingBufferCapacity f50633g;

    /* renamed from: h, reason: collision with root package name */
    public RingBufferCapacity f50634h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f50635i;

    /* renamed from: j, reason: collision with root package name */
    public ByteBufferChannel f50636j;

    /* renamed from: k, reason: collision with root package name */
    public long f50637k;

    /* renamed from: l, reason: collision with root package name */
    public long f50638l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f50639m;
    public /* synthetic */ Object n;
    public final /* synthetic */ ByteBufferChannel o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$copyDirect$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.o = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= Integer.MIN_VALUE;
        return this.o.W(null, 0L, this);
    }
}
