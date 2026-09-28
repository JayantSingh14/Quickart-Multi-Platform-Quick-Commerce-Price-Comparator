package io.ktor.utils.io;

import io.ktor.utils.io.ChannelLittleEndianKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", l = {11}, m = "readInt")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelLittleEndianKt$readInt$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51107a;

    /* renamed from: b, reason: collision with root package name */
    public int f51108b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51107a = obj;
        int i2 = (this.f51108b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51108b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51108b = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        int i3 = ChannelLittleEndianKt.WhenMappings.f51098a;
        throw null;
    }
}
