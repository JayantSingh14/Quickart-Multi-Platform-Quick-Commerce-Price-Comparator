package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", f = "Combine.kt", l = {WKSRecord.Service.LOCUS_MAP}, m = "emit")
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f55024a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1 f55025b;

    /* renamed from: c, reason: collision with root package name */
    public int f55026c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1$2$1$emit$1(CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f55025b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f55024a = obj;
        this.f55026c |= Integer.MIN_VALUE;
        return this.f55025b.a(null, this);
    }
}
