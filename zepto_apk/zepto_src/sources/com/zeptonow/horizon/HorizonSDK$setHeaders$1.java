package com.zeptonow.horizon;

import com.zeptonow.horizon.di.DependencyContainer;
import com.zeptonow.horizon.network.NetworkClient;
import com.zeptonow.horizon.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.HorizonSDK$setHeaders$1", f = "HorizonSDK.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class HorizonSDK$setHeaders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f47839a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonSDK$setHeaders$1(String str, Continuation continuation) {
        super(2, continuation);
        this.f47839a = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HorizonSDK$setHeaders$1(this.f47839a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HorizonSDK$setHeaders$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NetworkClient networkClient;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        Json json = SerializationUtilsKt.f48279b;
        String string = this.f47839a;
        json.getClass();
        Intrinsics.checkNotNullParameter(string, "string");
        JsonObject jsonObjectE = JsonElementKt.e((JsonElement) json.b(string, JsonElementSerializer.f55978a));
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        if (dependencyContainer != null && (networkClient = (NetworkClient) dependencyContainer.f47854k.getValue()) != null) {
            networkClient.a(jsonObjectE);
        }
        return Unit.f53572a;
    }
}
