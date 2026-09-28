package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@JvmName
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DBUtil {
    public static final void a(FrameworkSQLiteDatabase db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        ListBuilder builder = CollectionsKt.u();
        Cursor cursorA = db.a("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = cursorA;
            while (cursor.moveToNext()) {
                builder.add(cursor.getString(0));
            }
            Unit unit = Unit.f53572a;
            CloseableKt.a(cursorA, null);
            Intrinsics.checkNotNullParameter(builder, "builder");
            Iterator it = builder.j().iterator();
            while (it.hasNext()) {
                String triggerName = (String) it.next();
                Intrinsics.checkNotNullExpressionValue(triggerName, "triggerName");
                if (StringsKt.O(triggerName, "room_fts_content_sync_", false)) {
                    db.C("DROP TRIGGER IF EXISTS ".concat(triggerName));
                }
            }
        } finally {
        }
    }

    public static final Cursor b(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sqLiteQuery, "sqLiteQuery");
        Cursor c2 = db.m(sqLiteQuery);
        if (z && (c2 instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) c2;
            int count = abstractWindowedCursor.getCount();
            if ((abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) {
                Intrinsics.checkNotNullParameter(c2, "c");
                try {
                    MatrixCursor matrixCursor = new MatrixCursor(c2.getColumnNames(), c2.getCount());
                    while (c2.moveToNext()) {
                        Object[] objArr = new Object[c2.getColumnCount()];
                        int columnCount = c2.getColumnCount();
                        for (int i2 = 0; i2 < columnCount; i2++) {
                            int type = c2.getType(i2);
                            if (type == 0) {
                                objArr[i2] = null;
                            } else if (type == 1) {
                                objArr[i2] = Long.valueOf(c2.getLong(i2));
                            } else if (type == 2) {
                                objArr[i2] = Double.valueOf(c2.getDouble(i2));
                            } else if (type == 3) {
                                objArr[i2] = c2.getString(i2);
                            } else {
                                if (type != 4) {
                                    throw new IllegalStateException();
                                }
                                objArr[i2] = c2.getBlob(i2);
                            }
                        }
                        matrixCursor.addRow(objArr);
                    }
                    CloseableKt.a(c2, null);
                    return matrixCursor;
                } finally {
                }
            }
        }
        return c2;
    }
}
