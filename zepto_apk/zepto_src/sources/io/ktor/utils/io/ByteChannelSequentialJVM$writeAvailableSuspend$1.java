package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {41, 42}, m = "writeAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$writeAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51059a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f51060b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51061c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51062d;

    /* renamed from: e, reason: collision with root package name */
    public int f51063e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$writeAvailableSuspend$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation continuation) {
        super(continuation);
        this.f51062d = byteChannelSequentialJVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51061c = obj;
        this.f51063e |= Integer.MIN_VALUE;
        int i2 = ByteChannelSequentialJVM.f51042g;
        return this.f51062d.l0(null, this);
    }
}
