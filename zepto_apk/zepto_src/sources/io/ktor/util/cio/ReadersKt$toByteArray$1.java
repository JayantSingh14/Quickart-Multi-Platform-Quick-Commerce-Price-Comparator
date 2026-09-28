package io.ktor.util.cio;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.util.cio.ReadersKt", f = "Readers.kt", l = {15}, m = "toByteArray")
/* loaded from: classes3.dex */
final class ReadersKt$toByteArray$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50525a;

    /* renamed from: b, reason: collision with root package name */
    public int f50526b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50525a = obj;
        int i2 = (this.f50526b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f50526b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f50526b = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return StringsKt.c((ByteReadPacket) obj);
    }
}
