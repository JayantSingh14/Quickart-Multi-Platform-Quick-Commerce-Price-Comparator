package androidx.media3.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class VersionTable {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5816a = 0;

    static {
        MediaLibraryInfo.a("media3.database");
    }

    public static int a(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException {
        try {
            if (!Util.g0(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", new String[]{Integer.toString(i2), str}, null, null, null);
            try {
                if (cursorQuery.getCount() == 0) {
                    cursorQuery.close();
                    return -1;
                }
                cursorQuery.moveToNext();
                int i3 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i3;
            } finally {
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException, SQLException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i2));
            contentValues.put("instance_uid", str);
            contentValues.put("version", (Integer) 1);
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
