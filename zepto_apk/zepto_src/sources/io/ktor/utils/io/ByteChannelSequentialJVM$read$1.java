package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {196}, m = "read")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$read$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51043a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f51044b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51045c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51046d;

    /* renamed from: e, reason: collision with root package name */
    public int f51047e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$read$1(ByteChannelSequentialJVM byteChannelSequentialJVM, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51046d = byteChannelSequentialJVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51045c = obj;
        this.f51047e |= Integer.MIN_VALUE;
        this.f51046d.E(0, null, this);
        return CoroutineSingletons.f53689a;
    }
}
