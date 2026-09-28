package androidx.sqlite.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: a, reason: collision with root package name */
    public final String f11894a;

    @Metadata
    public static final class Companion {
    }

    public SimpleSQLiteQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(query, "query");
        this.f11894a = query;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String c() {
        return this.f11894a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void e(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Intrinsics.checkNotNullParameter(statement, "statement");
    }
}
