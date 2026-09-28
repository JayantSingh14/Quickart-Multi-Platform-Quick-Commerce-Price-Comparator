package retrofit2;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {WKSRecord.Service.NNTP}, m = "suspendAndThrow")
/* loaded from: classes5.dex */
final class KotlinExtensions$suspendAndThrow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f58112a;

    /* renamed from: b, reason: collision with root package name */
    public int f58113b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f58112a = obj;
        this.f58113b |= Integer.MIN_VALUE;
        KotlinExtensions.c(null, this);
        return CoroutineSingletons.f53689a;
    }
}
