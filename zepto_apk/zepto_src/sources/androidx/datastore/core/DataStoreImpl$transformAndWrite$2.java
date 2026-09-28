package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {330, 331, 337}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$transformAndWrite$2 extends SuspendLambda implements Function1<Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f3514a;

    /* renamed from: b, reason: collision with root package name */
    public int f3515b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3516c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f3517d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function2 f3518e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2(DataStoreImpl dataStoreImpl, CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.f3516c = dataStoreImpl;
        this.f3517d = coroutineContext;
        this.f3518e = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$transformAndWrite$2(this.f3516c, this.f3517d, this.f3518e, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((DataStoreImpl$transformAndWrite$2) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f3515b
            androidx.datastore.core.DataStoreImpl r2 = r8.f3516c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2b
            if (r1 == r5) goto L27
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            java.lang.Object r0 = r8.f3514a
            kotlin.ResultKt.b(r9)
            return r0
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.f3514a
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            kotlin.ResultKt.b(r9)
            goto L4f
        L27:
            kotlin.ResultKt.b(r9)
            goto L37
        L2b:
            kotlin.ResultKt.b(r9)
            r8.f3515b = r5
            java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.f(r2, r5, r8)
            if (r9 != r0) goto L37
            goto L6f
        L37:
            r1 = r9
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r9 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            kotlin.jvm.functions.Function2 r6 = r8.f3518e
            r7 = 0
            r9.<init>(r6, r1, r7)
            r8.f3514a = r1
            r8.f3515b = r4
            kotlin.coroutines.CoroutineContext r4 = r8.f3517d
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.e(r4, r9, r8)
            if (r9 != r0) goto L4f
            goto L6f
        L4f:
            java.lang.Object r4 = r1.f3378b
            if (r4 == 0) goto L58
            int r4 = r4.hashCode()
            goto L59
        L58:
            r4 = 0
        L59:
            int r6 = r1.f3379c
            if (r4 != r6) goto L71
            java.lang.Object r1 = r1.f3378b
            boolean r1 = kotlin.jvm.internal.Intrinsics.b(r1, r9)
            if (r1 != 0) goto L70
            r8.f3514a = r9
            r8.f3515b = r3
            java.lang.Object r1 = r2.j(r9, r5, r8)
            if (r1 != r0) goto L70
        L6f:
            return r0
        L70:
            return r9
        L71:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data in DataStore was mutated but DataStore is only compatible with Immutable types."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
