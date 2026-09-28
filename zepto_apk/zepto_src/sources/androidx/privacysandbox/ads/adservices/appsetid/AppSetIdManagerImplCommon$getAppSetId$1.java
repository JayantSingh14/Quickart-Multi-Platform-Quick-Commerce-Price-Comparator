package androidx.privacysandbox.ads.adservices.appsetid;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {Type.A6}, m = "getAppSetId$suspendImpl")
/* loaded from: classes3.dex */
public final class AppSetIdManagerImplCommon$getAppSetId$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AppSetIdManagerImplCommon f11189a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11190b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppSetIdManagerImplCommon f11191c;

    /* renamed from: d, reason: collision with root package name */
    public int f11192d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSetIdManagerImplCommon$getAppSetId$1(AppSetIdManagerImplCommon appSetIdManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f11191c = appSetIdManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11190b = obj;
        this.f11192d |= Integer.MIN_VALUE;
        return AppSetIdManagerImplCommon.b(this.f11191c, this);
    }
}
