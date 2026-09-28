package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {128}, m = "readFullySuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$readFullySuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51052a;

    /* renamed from: b, reason: collision with root package name */
    public int f51053b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51052a = obj;
        this.f51053b |= Integer.MIN_VALUE;
        int i2 = ByteChannelSequentialJVM.f51042g;
        throw null;
    }
}
