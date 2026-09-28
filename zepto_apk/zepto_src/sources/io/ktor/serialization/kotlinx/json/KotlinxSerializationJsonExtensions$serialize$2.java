package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2", f = "KotlinxSerializationJsonExtensions.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class KotlinxSerializationJsonExtensions$serialize$2 extends SuspendLambda implements Function2<ByteWriteChannel, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50403a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50404b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationJsonExtensions f50405c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f50406d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ KSerializer f50407e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Charset f50408f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$serialize$2(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Object obj, KSerializer kSerializer, Charset charset, Continuation continuation) {
        super(2, continuation);
        this.f50405c = kotlinxSerializationJsonExtensions;
        this.f50406d = obj;
        this.f50407e = kSerializer;
        this.f50408f = charset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        KotlinxSerializationJsonExtensions$serialize$2 kotlinxSerializationJsonExtensions$serialize$2 = new KotlinxSerializationJsonExtensions$serialize$2(this.f50405c, this.f50406d, this.f50407e, this.f50408f, continuation);
        kotlinxSerializationJsonExtensions$serialize$2.f50404b = obj;
        return kotlinxSerializationJsonExtensions$serialize$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((KotlinxSerializationJsonExtensions$serialize$2) create((ByteWriteChannel) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50403a;
        if (i2 == 0) {
            ResultKt.b(obj);
            ByteWriteChannel byteWriteChannel = (ByteWriteChannel) this.f50404b;
            Object obj2 = this.f50406d;
            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<*>");
            KSerializer kSerializer = this.f50407e;
            Intrinsics.d(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            this.f50403a = 1;
            if (KotlinxSerializationJsonExtensions.c(this.f50405c, (Flow) obj2, kSerializer, this.f50408f, byteWriteChannel, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
