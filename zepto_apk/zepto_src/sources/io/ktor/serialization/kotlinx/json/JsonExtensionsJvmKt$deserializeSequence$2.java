package io.ktor.serialization.kotlinx.json;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt$deserializeSequence$2", f = "JsonExtensionsJvm.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class JsonExtensionsJvmKt$deserializeSequence$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Sequence<? extends Object>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f50382a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypeInfo f50383b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Json f50384c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonExtensionsJvmKt$deserializeSequence$2(TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation, Json json) {
        super(2, continuation);
        this.f50382a = byteReadChannel;
        this.f50383b = typeInfo;
        this.f50384c = json;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new JsonExtensionsJvmKt$deserializeSequence$2(this.f50383b, this.f50382a, continuation, this.f50384c);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((JsonExtensionsJvmKt$deserializeSequence$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        BlockingKt.a(this.f50382a, null);
        KotlinxSerializationJsonExtensionsKt.a(this.f50383b);
        throw null;
    }
}
