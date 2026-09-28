package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", l = {370, 371}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$readDataOrHandleCorruption$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Data<Object>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f3501a;

    /* renamed from: b, reason: collision with root package name */
    public int f3502b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f3503c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3504d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3505e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$2(DataStoreImpl dataStoreImpl, int i2, Continuation continuation) {
        super(2, continuation);
        this.f3504d = dataStoreImpl;
        this.f3505e = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(this.f3504d, this.f3505e, continuation);
        dataStoreImpl$readDataOrHandleCorruption$2.f3503c = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataOrHandleCorruption$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((DataStoreImpl$readDataOrHandleCorruption$2) create(bool, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f3502b
            androidx.datastore.core.DataStoreImpl r2 = r6.f3504d
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            java.lang.Object r0 = r6.f3501a
            kotlin.ResultKt.b(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            boolean r1 = r6.f3503c
            kotlin.ResultKt.b(r7)
            goto L32
        L22:
            kotlin.ResultKt.b(r7)
            boolean r1 = r6.f3503c
            r6.f3503c = r1
            r6.f3502b = r4
            java.lang.Object r7 = r2.i(r6)
            if (r7 != r0) goto L32
            goto L42
        L32:
            if (r1 == 0) goto L4c
            androidx.datastore.core.InterProcessCoordinator r1 = r2.g()
            r6.f3501a = r7
            r6.f3502b = r3
            java.lang.Object r1 = r1.c(r6)
            if (r1 != r0) goto L43
        L42:
            return r0
        L43:
            r0 = r7
            r7 = r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L51
        L4c:
            int r0 = r6.f3505e
            r5 = r0
            r0 = r7
            r7 = r5
        L51:
            androidx.datastore.core.Data r1 = new androidx.datastore.core.Data
            if (r0 == 0) goto L5a
            int r2 = r0.hashCode()
            goto L5b
        L5a:
            r2 = 0
        L5b:
            r1.<init>(r2, r7, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
