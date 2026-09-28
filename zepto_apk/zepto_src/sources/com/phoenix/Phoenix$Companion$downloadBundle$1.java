package com.phoenix;

import android.support.v4.media.b;
import com.facebook.react.bridge.Promise;
import com.phoenix.PhoenixUpdateManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.phoenix.Phoenix$Companion$downloadBundle$1", f = "Phoenix.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class Phoenix$Companion$downloadBundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46114a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46115b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46116c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f46117d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f46118e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Promise f46119f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Phoenix$Companion$downloadBundle$1(String str, String str2, int i2, int i3, Integer num, Promise promise, Continuation continuation) {
        super(2, continuation);
        this.f46114a = str;
        this.f46115b = str2;
        this.f46116c = i2;
        this.f46117d = i3;
        this.f46118e = num;
        this.f46119f = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Phoenix$Companion$downloadBundle$1(this.f46114a, this.f46115b, this.f46116c, this.f46117d, this.f46118e, this.f46119f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Phoenix$Companion$downloadBundle$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        try {
            PhoenixUpdateManager.Companion.d(this.f46114a, this.f46115b, this.f46116c, this.f46117d, this.f46118e, this.f46119f);
        } catch (Exception e2) {
            this.f46119f.reject("PHOENIX_DOWNLOAD_ERROR", b.C("Failed to download bundle: ", e2.getMessage()), e2);
        }
        return Unit.f53572a;
    }
}
