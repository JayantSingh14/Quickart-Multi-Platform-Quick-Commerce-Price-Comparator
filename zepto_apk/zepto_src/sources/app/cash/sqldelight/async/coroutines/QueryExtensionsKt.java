package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class QueryExtensionsKt {
    public static final Object a(final ExecutableQuery executableQuery, Continuation continuation) {
        return executableQuery.a(new Function1<SqlCursor, QueryResult<List<Object>>>() { // from class: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2

            @Metadata
            @DebugMetadata(c = "app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2$1", f = "QueryExtensions.kt", l = {14, 15}, m = "invokeSuspend")
            /* renamed from: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2$1, reason: invalid class name */
            final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super List<Object>>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f13086a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ QueryResult.AsyncValue f13087b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ ArrayList f13088c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ExecutableQuery f13089d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ SqlCursor f13090e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(QueryResult.AsyncValue asyncValue, ArrayList arrayList, ExecutableQuery executableQuery, SqlCursor sqlCursor, Continuation continuation) {
                    super(1, continuation);
                    this.f13087b = asyncValue;
                    this.f13088c = arrayList;
                    this.f13089d = executableQuery;
                    this.f13090e = sqlCursor;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation) {
                    return new AnonymousClass1(this.f13087b, this.f13088c, this.f13089d, this.f13090e, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ((AnonymousClass1) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
                
                    if (r8 == r0) goto L18;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
                
                    if (r8 != r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Type inference failed for: r8v14, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r8v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
                /* JADX WARN: Type inference failed for: r8v7, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004b -> B:19:0x004e). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                    /*
                        r7 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                        int r1 = r7.f13086a
                        java.util.ArrayList r2 = r7.f13088c
                        app.cash.sqldelight.ExecutableQuery r3 = r7.f13089d
                        r4 = 2
                        r5 = 1
                        app.cash.sqldelight.db.SqlCursor r6 = r7.f13090e
                        if (r1 == 0) goto L22
                        if (r1 == r5) goto L1e
                        if (r1 != r4) goto L16
                        kotlin.ResultKt.b(r8)
                        goto L4e
                    L16:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r0)
                        throw r8
                    L1e:
                        kotlin.ResultKt.b(r8)
                        goto L32
                    L22:
                        kotlin.ResultKt.b(r8)
                        r7.f13086a = r5
                        app.cash.sqldelight.db.QueryResult$AsyncValue r8 = r7.f13087b
                        kotlin.coroutines.jvm.internal.SuspendLambda r8 = r8.f13141b
                        java.lang.Object r8 = r8.invoke(r7)
                        if (r8 != r0) goto L32
                        goto L4d
                    L32:
                        java.lang.Boolean r8 = (java.lang.Boolean) r8
                        boolean r8 = r8.booleanValue()
                        if (r8 == 0) goto L60
                        kotlin.jvm.internal.Lambda r8 = r3.f13077a
                        java.lang.Object r8 = r8.invoke(r6)
                        r2.add(r8)
                    L43:
                        app.cash.sqldelight.db.QueryResult$Value r8 = r6.next()
                        r7.f13086a = r4
                        java.lang.Object r8 = r8.f13144b
                        if (r8 != r0) goto L4e
                    L4d:
                        return r0
                    L4e:
                        java.lang.Boolean r8 = (java.lang.Boolean) r8
                        boolean r8 = r8.booleanValue()
                        if (r8 == 0) goto L60
                        kotlin.jvm.internal.Lambda r8 = r3.f13077a
                        java.lang.Object r8 = r8.invoke(r6)
                        r2.add(r8)
                        goto L43
                    L60:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r2v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlCursor cursor = (SqlCursor) obj;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                QueryResult.Value next = cursor.next();
                ArrayList arrayList = new ArrayList();
                if (!((Boolean) next.f13144b).booleanValue()) {
                    return new QueryResult.Value(arrayList);
                }
                ExecutableQuery executableQuery2 = executableQuery;
                arrayList.add(executableQuery2.f13077a.invoke(cursor));
                while (((Boolean) cursor.next().f13144b).booleanValue()) {
                    arrayList.add(executableQuery2.f13077a.invoke(cursor));
                }
                return new QueryResult.Value(arrayList);
            }
        }).a((ContinuationImpl) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(app.cash.sqldelight.ExecutableQuery r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOne$1
            if (r0 == 0) goto L13
            r0 = r5
            app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOne$1 r0 = (app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOne$1) r0
            int r1 = r0.f13093c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13093c = r1
            goto L18
        L13:
            app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOne$1 r0 = new app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOne$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13092b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f13093c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            app.cash.sqldelight.ExecutableQuery r4 = r0.f13091a
            kotlin.ResultKt.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            r0.f13091a = r4
            r0.f13093c = r3
            java.lang.Object r5 = c(r4, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            if (r5 == 0) goto L42
            return r5
        L42:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "ResultSet returned null for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.async.coroutines.QueryExtensionsKt.b(app.cash.sqldelight.ExecutableQuery, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Object c(final ExecutableQuery executableQuery, ContinuationImpl continuationImpl) {
        return executableQuery.a(new Function1<SqlCursor, QueryResult<Object>>() { // from class: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2

            @Metadata
            @DebugMetadata(c = "app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2$1", f = "QueryExtensions.kt", l = {40, 42}, m = "invokeSuspend")
            @SourceDebugExtension
            /* renamed from: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f13095a;

                /* renamed from: b, reason: collision with root package name */
                public int f13096b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ QueryResult.AsyncValue f13097c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ExecutableQuery f13098d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ SqlCursor f13099e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(QueryResult.AsyncValue asyncValue, ExecutableQuery executableQuery, SqlCursor sqlCursor, Continuation continuation) {
                    super(1, continuation);
                    this.f13097c = asyncValue;
                    this.f13098d = executableQuery;
                    this.f13099e = sqlCursor;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation) {
                    return new AnonymousClass1(this.f13097c, this.f13098d, this.f13099e, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ((AnonymousClass1) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
                /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
                /* JADX WARN: Type inference failed for: r6v7, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                    /*
                        r5 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                        int r1 = r5.f13096b
                        app.cash.sqldelight.ExecutableQuery r2 = r5.f13098d
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L20
                        if (r1 == r4) goto L1c
                        if (r1 != r3) goto L14
                        java.lang.Object r0 = r5.f13095a
                        kotlin.ResultKt.b(r6)
                        goto L51
                    L14:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1c:
                        kotlin.ResultKt.b(r6)
                        goto L30
                    L20:
                        kotlin.ResultKt.b(r6)
                        r5.f13096b = r4
                        app.cash.sqldelight.db.QueryResult$AsyncValue r6 = r5.f13097c
                        kotlin.coroutines.jvm.internal.SuspendLambda r6 = r6.f13141b
                        java.lang.Object r6 = r6.invoke(r5)
                        if (r6 != r0) goto L30
                        goto L4e
                    L30:
                        java.lang.Boolean r6 = (java.lang.Boolean) r6
                        boolean r6 = r6.booleanValue()
                        if (r6 != 0) goto L3a
                        r6 = 0
                        return r6
                    L3a:
                        kotlin.jvm.internal.Lambda r6 = r2.f13077a
                        app.cash.sqldelight.db.SqlCursor r1 = r5.f13099e
                        java.lang.Object r6 = r6.invoke(r1)
                        app.cash.sqldelight.db.QueryResult$Value r1 = r1.next()
                        r5.f13095a = r6
                        r5.f13096b = r3
                        java.lang.Object r1 = r1.f13144b
                        if (r1 != r0) goto L4f
                    L4e:
                        return r0
                    L4f:
                        r0 = r6
                        r6 = r1
                    L51:
                        java.lang.Boolean r6 = (java.lang.Boolean) r6
                        boolean r6 = r6.booleanValue()
                        if (r6 != 0) goto L5a
                        return r0
                    L5a:
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        java.lang.String r0 = "ResultSet returned more than 1 row for "
                        r6.<init>(r0)
                        r6.append(r2)
                        java.lang.String r6 = r6.toString()
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r6 = r6.toString()
                        r0.<init>(r6)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlCursor cursor = (SqlCursor) obj;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                QueryResult.Value next = cursor.next();
                ExecutableQuery executableQuery2 = executableQuery;
                if (!((Boolean) next.f13144b).booleanValue()) {
                    return new QueryResult.Value(null);
                }
                Object objInvoke = executableQuery2.f13077a.invoke(cursor);
                if (!((Boolean) cursor.next().f13144b).booleanValue()) {
                    return new QueryResult.Value(objInvoke);
                }
                throw new IllegalStateException(("ResultSet returned more than 1 row for " + executableQuery2).toString());
            }
        }).a(continuationImpl);
    }
}
