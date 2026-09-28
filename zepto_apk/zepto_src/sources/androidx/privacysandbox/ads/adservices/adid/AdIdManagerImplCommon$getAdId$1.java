package androidx.privacysandbox.ads.adservices.adid;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon", f = "AdIdManagerImplCommon.kt", l = {40}, m = "getAdId$suspendImpl")
/* loaded from: classes3.dex */
public final class AdIdManagerImplCommon$getAdId$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AdIdManagerImplCommon f11154a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11155b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdIdManagerImplCommon f11156c;

    /* renamed from: d, reason: collision with root package name */
    public int f11157d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdIdManagerImplCommon$getAdId$1(AdIdManagerImplCommon adIdManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f11156c = adIdManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11155b = obj;
        this.f11157d |= Integer.MIN_VALUE;
        return AdIdManagerImplCommon.b(this.f11156c, this);
    }
}
