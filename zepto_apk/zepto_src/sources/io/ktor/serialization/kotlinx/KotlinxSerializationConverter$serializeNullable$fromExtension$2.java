package io.ktor.serialization.kotlinx;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2", f = "KotlinxSerializationConverter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class KotlinxSerializationConverter$serializeNullable$fromExtension$2 extends SuspendLambda implements Function2<OutgoingContent, Continuation<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50378a;

    public KotlinxSerializationConverter$serializeNullable$fromExtension$2() {
        super(2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        KotlinxSerializationConverter$serializeNullable$fromExtension$2 kotlinxSerializationConverter$serializeNullable$fromExtension$2 = new KotlinxSerializationConverter$serializeNullable$fromExtension$2(2, continuation);
        kotlinxSerializationConverter$serializeNullable$fromExtension$2.f50378a = obj;
        return kotlinxSerializationConverter$serializeNullable$fromExtension$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((KotlinxSerializationConverter$serializeNullable$fromExtension$2) create((OutgoingContent) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        return Boolean.valueOf(((OutgoingContent) this.f50378a) != null);
    }
}
