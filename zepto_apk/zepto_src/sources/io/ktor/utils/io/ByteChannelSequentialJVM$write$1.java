package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {234}, m = "write")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$write$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51054a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f51055b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51056c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51057d;

    /* renamed from: e, reason: collision with root package name */
    public int f51058e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$write$1(ByteChannelSequentialJVM byteChannelSequentialJVM, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51057d = byteChannelSequentialJVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51056c = obj;
        this.f51058e |= Integer.MIN_VALUE;
        this.f51057d.C(0, null, this);
        return CoroutineSingletons.f53689a;
    }
}
