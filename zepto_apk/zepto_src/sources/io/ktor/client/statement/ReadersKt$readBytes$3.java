package io.ktor.client.statement;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {24}, m = "readBytes")
/* loaded from: classes3.dex */
final class ReadersKt$readBytes$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50093a;

    /* renamed from: b, reason: collision with root package name */
    public int f50094b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50093a = obj;
        int i2 = (this.f50094b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f50094b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return StringsKt.c((ByteReadPacket) obj);
    }
}
