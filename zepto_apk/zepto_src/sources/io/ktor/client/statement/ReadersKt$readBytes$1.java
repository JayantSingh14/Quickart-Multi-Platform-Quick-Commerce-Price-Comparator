package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {16}, m = "readBytes")
/* loaded from: classes3.dex */
final class ReadersKt$readBytes$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50091a;

    /* renamed from: b, reason: collision with root package name */
    public int f50092b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50091a = obj;
        int i2 = (this.f50092b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f50092b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return null;
    }
}
