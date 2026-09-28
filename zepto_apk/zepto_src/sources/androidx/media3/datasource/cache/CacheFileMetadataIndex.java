package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.database.VersionTable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
final class CacheFileMetadataIndex {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f5980c = {CLConstants.FIELD_PAY_INFO_NAME, "length", "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    public final StandaloneDatabaseProvider f5981a;

    /* renamed from: b, reason: collision with root package name */
    public String f5982b;

    public CacheFileMetadataIndex(StandaloneDatabaseProvider standaloneDatabaseProvider) {
        this.f5981a = standaloneDatabaseProvider;
    }

    public final HashMap a() {
        try {
            this.f5982b.getClass();
            Cursor cursorQuery = this.f5981a.getReadableDatabase().query(this.f5982b, f5980c, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    string.getClass();
                    map.put(string, new CacheFileMetadata(cursorQuery.getLong(1), cursorQuery.getLong(2)));
                }
                cursorQuery.close();
                return map;
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final void b(long j2) {
        StandaloneDatabaseProvider standaloneDatabaseProvider = this.f5981a;
        try {
            String hexString = Long.toHexString(j2);
            this.f5982b = "ExoPlayerCacheFileMetadata" + hexString;
            if (VersionTable.a(standaloneDatabaseProvider.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = standaloneDatabaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.b(writableDatabase, 2, hexString);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f5982b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f5982b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final void c(Set set) {
        this.f5982b.getClass();
        try {
            SQLiteDatabase writableDatabase = this.f5981a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f5982b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final void d(long j2, long j3, String str) {
        this.f5982b.getClass();
        try {
            SQLiteDatabase writableDatabase = this.f5981a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, str);
            contentValues.put("length", Long.valueOf(j2));
            contentValues.put("last_touch_timestamp", Long.valueOf(j3));
            writableDatabase.replaceOrThrow(this.f5982b, null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
