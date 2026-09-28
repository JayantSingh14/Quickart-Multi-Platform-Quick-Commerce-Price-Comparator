package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
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

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1", f = "AdSelectionManagerFutures.kt", l = {373}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdSelectionOutcome>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f11206a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl f11207b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PersistAdSelectionResultRequest f11208c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation continuation) {
        super(2, continuation);
        this.f11207b = api33Ext4JavaImpl;
        this.f11208c = persistAdSelectionResultRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this.f11207b, this.f11208c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 adSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 = (AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.f53572a;
        adSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f11206a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Intrinsics.c(null);
        this.f11206a = 1;
        throw null;
    }
}
