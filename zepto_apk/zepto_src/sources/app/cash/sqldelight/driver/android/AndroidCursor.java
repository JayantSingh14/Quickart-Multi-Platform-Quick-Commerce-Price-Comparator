package app.cash.sqldelight.driver.android;

import android.database.Cursor;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
final class AndroidCursor implements SqlCursor {

    /* renamed from: a, reason: collision with root package name */
    public final Cursor f13145a;

    public AndroidCursor(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.f13145a = cursor;
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Long getLong(int i2) {
        Cursor cursor = this.f13145a;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final String getString(int i2) {
        Cursor cursor = this.f13145a;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final QueryResult.Value next() {
        return new QueryResult.Value(Boolean.valueOf(this.f13145a.moveToNext()));
    }
}
