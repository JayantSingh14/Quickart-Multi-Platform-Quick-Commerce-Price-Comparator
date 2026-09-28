package app.cash.sqldelight.db;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface QueryResult<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f13140a = Companion.f13142a;

    @Metadata
    @JvmInline
    public static final class AsyncValue<T> implements QueryResult<T> {

        /* renamed from: b, reason: collision with root package name */
        public final SuspendLambda f13141b;

        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
        @Override // app.cash.sqldelight.db.QueryResult
        public final Object a(ContinuationImpl continuationImpl) {
            return this.f13141b.invoke(continuationImpl);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof AsyncValue) {
                return this.f13141b.equals(((AsyncValue) obj).f13141b);
            }
            return false;
        }

        @Override // app.cash.sqldelight.db.QueryResult
        public final Object getValue() {
            DefaultImpls.a();
            throw null;
        }

        public final int hashCode() {
            return this.f13141b.hashCode();
        }

        public final String toString() {
            return "AsyncValue(getter=" + this.f13141b + ')';
        }
    }

    @Metadata
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f13142a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final Unit f13143b = Unit.f53572a;
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void a() {
            throw new IllegalStateException("The driver used with SQLDelight is asynchronous, so SQLDelight should be configured for\nasynchronous usage:\n\nsqldelight {\n  databases {\n    MyDatabase {\n      generateAsync = true\n    }\n  }\n}");
        }
    }

    @Metadata
    @JvmInline
    public static final class Value<T> implements QueryResult<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Object f13144b;

        @Override // app.cash.sqldelight.db.QueryResult
        public final Object a(ContinuationImpl continuationImpl) {
            return this.f13144b;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Value) {
                return Intrinsics.b(this.f13144b, ((Value) obj).f13144b);
            }
            return false;
        }

        @Override // app.cash.sqldelight.db.QueryResult
        public final Object getValue() {
            return this.f13144b;
        }

        public final int hashCode() {
            Object obj = this.f13144b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public final String toString() {
            return "Value(value=" + this.f13144b + ')';
        }
    }

    Object a(ContinuationImpl continuationImpl);

    Object getValue();
}
