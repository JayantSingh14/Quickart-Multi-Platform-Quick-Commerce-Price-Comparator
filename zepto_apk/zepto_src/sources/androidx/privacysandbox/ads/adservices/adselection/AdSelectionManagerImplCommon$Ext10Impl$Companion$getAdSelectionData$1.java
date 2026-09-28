package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", l = {231}, m = "getAdSelectionData")
/* loaded from: classes3.dex */
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f11166a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11167b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion f11168c;

    /* renamed from: d, reason: collision with root package name */
    public int f11169d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, Continuation continuation) {
        super(continuation);
        this.f11168c = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11167b = obj;
        this.f11169d |= Integer.MIN_VALUE;
        return this.f11168c.a(null, null, this);
    }
}
