package androidx.privacysandbox.ads.adservices.java.adid;

import androidx.privacysandbox.ads.adservices.adid.AdId;
import androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures;
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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1", f = "AdIdManagerFutures.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdId>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f11201a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdIdManagerFutures.Api33Ext4JavaImpl f11202b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(AdIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, Continuation continuation) {
        super(2, continuation);
        this.f11202b = api33Ext4JavaImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this.f11202b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1 adIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1 = (AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.f53572a;
        adIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f11201a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f11201a = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return obj;
    }
}
