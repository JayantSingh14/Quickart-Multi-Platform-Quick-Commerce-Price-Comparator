package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", l = {231}, m = "selectAds")
/* loaded from: classes3.dex */
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f11174a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11175b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion f11176c;

    /* renamed from: d, reason: collision with root package name */
    public int f11177d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, Continuation continuation) {
        super(continuation);
        this.f11176c = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11175b = obj;
        this.f11177d |= Integer.MIN_VALUE;
        return this.f11176c.c(null, null, this);
    }
}
