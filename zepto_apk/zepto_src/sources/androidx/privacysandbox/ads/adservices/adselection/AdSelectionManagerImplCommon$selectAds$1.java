package androidx.privacysandbox.ads.adservices.adselection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon", f = "AdSelectionManagerImplCommon.kt", l = {44}, m = "selectAds$suspendImpl")
/* loaded from: classes3.dex */
public final class AdSelectionManagerImplCommon$selectAds$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f11179a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdSelectionManagerImplCommon f11180b;

    /* renamed from: c, reason: collision with root package name */
    public int f11181c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$selectAds$1(AdSelectionManagerImplCommon adSelectionManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f11180b = adSelectionManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11179a = obj;
        this.f11181c |= Integer.MIN_VALUE;
        return AdSelectionManagerImplCommon.k(this.f11180b, null, this);
    }
}
