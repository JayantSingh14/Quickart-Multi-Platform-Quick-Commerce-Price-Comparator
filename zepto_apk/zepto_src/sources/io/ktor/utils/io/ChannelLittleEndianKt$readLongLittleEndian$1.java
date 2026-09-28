package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", l = {35}, m = "readLongLittleEndian")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelLittleEndianKt$readLongLittleEndian$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51113a;

    /* renamed from: b, reason: collision with root package name */
    public int f51114b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51113a = obj;
        int i2 = (this.f51114b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51114b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51114b = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return new Long(Long.reverseBytes(((Number) obj).longValue()));
    }
}
