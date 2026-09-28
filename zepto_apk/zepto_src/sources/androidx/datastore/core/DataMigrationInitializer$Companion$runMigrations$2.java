package androidx.datastore.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f3387a;

    /* renamed from: b, reason: collision with root package name */
    public DataMigration f3388b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3389c;

    /* renamed from: d, reason: collision with root package name */
    public int f3390d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f3391e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f3392f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3393g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2(List list, ArrayList arrayList, Continuation continuation) {
        super(2, continuation);
        this.f3392f = list;
        this.f3393g = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.f3392f, this.f3393g, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.f3391e = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:11:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f3390d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.util.Iterator r1 = r8.f3387a
            java.lang.Object r4 = r8.f3391e
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.b(r9)
            goto L3e
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            java.lang.Object r1 = r8.f3389c
            androidx.datastore.core.DataMigration r4 = r8.f3388b
            java.util.Iterator r5 = r8.f3387a
            java.lang.Object r6 = r8.f3391e
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r9)
            r7 = r6
            r6 = r4
            r4 = r7
            goto L61
        L2f:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f3391e
            java.util.List r1 = r8.f3392f
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            java.util.ArrayList r4 = r8.f3393g
        L3e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L83
            java.lang.Object r5 = r1.next()
            androidx.datastore.core.DataMigration r5 = (androidx.datastore.core.DataMigration) r5
            r8.f3391e = r4
            r8.f3387a = r1
            r8.f3388b = r5
            r8.f3389c = r9
            r8.f3390d = r3
            r5.h(r8)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            if (r6 != r0) goto L5c
            return r0
        L5c:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L61:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L6c
            r9 = r1
            r1 = r5
            goto L3e
        L6c:
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r9 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r0 = 0
            r9.<init>(r6, r0)
            r4.add(r9)
            r8.f3391e = r4
            r8.f3387a = r5
            r8.f3388b = r0
            r8.f3389c = r0
            r8.f3390d = r2
            r6.g()
            throw r0
        L83:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
