package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {54}, m = "writeFullySuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$writeFullySuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51064a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f51065b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51066c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51067d;

    /* renamed from: e, reason: collision with root package name */
    public int f51068e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$writeFullySuspend$1(ByteChannelSequentialJVM byteChannelSequentialJVM, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51067d = byteChannelSequentialJVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51066c = obj;
        this.f51068e |= Integer.MIN_VALUE;
        int i2 = ByteChannelSequentialJVM.f51042g;
        return this.f51067d.m0(null, this);
    }
}
