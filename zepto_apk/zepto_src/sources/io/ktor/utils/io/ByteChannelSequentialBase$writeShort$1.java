package io.ktor.utils.io;

import io.ktor.utils.io.core.InsufficientSpaceException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {156}, m = "writeShort$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeShort$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51037a;

    /* renamed from: b, reason: collision with root package name */
    public short f51038b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51039c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51040d;

    /* renamed from: e, reason: collision with root package name */
    public int f51041e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeShort$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51040d = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws InsufficientSpaceException {
        this.f51039c = obj;
        this.f51041e |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.i0(this.f51040d, (short) 0, this);
        return CoroutineSingletons.f53689a;
    }
}
