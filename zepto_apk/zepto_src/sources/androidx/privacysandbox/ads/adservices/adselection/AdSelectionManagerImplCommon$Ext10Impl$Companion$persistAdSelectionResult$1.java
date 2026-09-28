package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", l = {231}, m = "persistAdSelectionResult")
/* loaded from: classes3.dex */
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f11170a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11171b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion f11172c;

    /* renamed from: d, reason: collision with root package name */
    public int f11173d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, Continuation continuation) {
        super(continuation);
        this.f11172c = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11171b = obj;
        this.f11173d |= Integer.MIN_VALUE;
        return this.f11172c.b(null, null, this);
    }
}
