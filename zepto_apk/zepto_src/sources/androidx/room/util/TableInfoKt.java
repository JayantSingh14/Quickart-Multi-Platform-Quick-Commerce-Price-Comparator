package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TableInfoKt {
    public static final List a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(CLConstants.SHARED_PREFERENCE_ITEM_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        ListBuilder builder = CollectionsKt.u();
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            builder.add(new TableInfo.ForeignKeyWithSequence(i2, i3, string, string2));
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        return CollectionsKt.X(builder.j());
    }

    public static final TableInfo.Index b(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, boolean z) {
        Cursor cursorA = frameworkSQLiteDatabase.a("PRAGMA index_xinfo(`" + str + "`)");
        try {
            Cursor cursor = cursorA;
            int columnIndex = cursor.getColumnIndex("seqno");
            int columnIndex2 = cursor.getColumnIndex("cid");
            int columnIndex3 = cursor.getColumnIndex(CLConstants.FIELD_PAY_INFO_NAME);
            int columnIndex4 = cursor.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursor.moveToNext()) {
                    if (cursor.getInt(columnIndex2) >= 0) {
                        int i2 = cursor.getInt(columnIndex);
                        String columnName = cursor.getString(columnIndex3);
                        String str2 = cursor.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i2);
                        Intrinsics.checkNotNullExpressionValue(columnName, "columnName");
                        treeMap.put(numValueOf, columnName);
                        treeMap2.put(Integer.valueOf(i2), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "columnsMap.values");
                List listE0 = CollectionsKt.e0(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues2, "ordersMap.values");
                TableInfo.Index index = new TableInfo.Index(str, z, listE0, CollectionsKt.e0(collectionValues2));
                CloseableKt.a(cursorA, null);
                return index;
            }
            CloseableKt.a(cursorA, null);
            return null;
        } finally {
        }
    }
}
