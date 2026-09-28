package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.ExecutableQuery;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "app.cash.sqldelight.async.coroutines.QueryExtensionsKt", f = "QueryExtensions.kt", l = {29}, m = "awaitAsOne")
/* loaded from: classes.dex */
final class QueryExtensionsKt$awaitAsOne$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ExecutableQuery f13091a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13092b;

    /* renamed from: c, reason: collision with root package name */
    public int f13093c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13092b = obj;
        this.f13093c |= Integer.MIN_VALUE;
        return QueryExtensionsKt.b(null, this);
    }
}
