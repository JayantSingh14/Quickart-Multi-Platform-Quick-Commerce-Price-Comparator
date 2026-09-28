package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {WKSRecord.Service.INGRES_NET, WKSRecord.Service.LOC_SRV}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$incrementCollector$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f3470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3471b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(2, continuation);
        this.f3471b = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DataStoreImpl$incrementCollector$2$1(this.f3471b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DataStoreImpl$incrementCollector$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r6.c(r1, r5) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f3470a
            androidx.datastore.core.DataStoreImpl r2 = r5.f3471b
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1e
            if (r1 == r4) goto L1a
            if (r1 != r3) goto L12
            kotlin.ResultKt.b(r6)
            goto L4d
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L33
        L1e:
            kotlin.ResultKt.b(r6)
            r5.f3470a = r4
            androidx.datastore.core.DataStoreImpl$InitDataStore r6 = r2.f3404i
            kotlinx.coroutines.CompletableDeferred r6 = r6.f3607b
            java.lang.Object r6 = r6.V(r5)
            if (r6 != r0) goto L2e
            goto L30
        L2e:
            kotlin.Unit r6 = kotlin.Unit.f53572a
        L30:
            if (r6 != r0) goto L33
            goto L4c
        L33:
            androidx.datastore.core.InterProcessCoordinator r6 = r2.g()
            kotlinx.coroutines.flow.Flow r6 = r6.b()
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.c(r6)
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1 r1 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1
            r1.<init>()
            r5.f3470a = r3
            java.lang.Object r6 = r6.c(r1, r5)
            if (r6 != r0) goto L4d
        L4c:
            return r0
        L4d:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
