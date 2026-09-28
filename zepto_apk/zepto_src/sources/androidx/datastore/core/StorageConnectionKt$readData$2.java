package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {WKSRecord.Service.NETRJS_4}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class StorageConnectionKt$readData$2 extends SuspendLambda implements Function3<ReadScope<Object>, Boolean, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f3638a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ ReadScope f3639b;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ((Boolean) obj2).getClass();
        StorageConnectionKt$readData$2 storageConnectionKt$readData$2 = new StorageConnectionKt$readData$2(3, (Continuation) obj3);
        storageConnectionKt$readData$2.f3639b = (ReadScope) obj;
        return storageConnectionKt$readData$2.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f3638a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ReadScope readScope = this.f3639b;
        this.f3638a = 1;
        Object objA = readScope.a(this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
