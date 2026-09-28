package com.mixpanel.android.mpmetrics;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixpanel.android.util.MPLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class MPDbAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f46011b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final String f46012c = "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* renamed from: d, reason: collision with root package name */
    public static final String f46013d = "CREATE TABLE people (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* renamed from: e, reason: collision with root package name */
    public static final String f46014e = "CREATE TABLE groups (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* renamed from: f, reason: collision with root package name */
    public static final String f46015f = "CREATE TABLE anonymous_people (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";

    /* renamed from: g, reason: collision with root package name */
    public static final String f46016g = "CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);";

    /* renamed from: h, reason: collision with root package name */
    public static final String f46017h = "CREATE INDEX IF NOT EXISTS time_idx ON people (created_at);";

    /* renamed from: i, reason: collision with root package name */
    public static final String f46018i = "CREATE INDEX IF NOT EXISTS time_idx ON groups (created_at);";

    /* renamed from: j, reason: collision with root package name */
    public static final String f46019j = "CREATE INDEX IF NOT EXISTS time_idx ON anonymous_people (created_at);";

    /* renamed from: a, reason: collision with root package name */
    public final MPDatabaseHelper f46020a;

    public static class MPDatabaseHelper extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        public final File f46021a;

        /* renamed from: b, reason: collision with root package name */
        public final MPConfig f46022b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f46023c;

        public MPDatabaseHelper(Context context) {
            super(context, "mixpanel", (SQLiteDatabase.CursorFactory) null, 7);
            this.f46021a = context.getDatabasePath("mixpanel");
            this.f46022b = MPConfig.b(context);
            this.f46023c = context;
        }

        public final void a() {
            close();
            this.f46021a.delete();
        }

        public final void b(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(MPDbAdapter.f46015f);
            sQLiteDatabase.execSQL(MPDbAdapter.f46019j);
            Context context = this.f46023c;
            File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
            if (file.exists() && file.isDirectory()) {
                for (String str : file.list(new FilenameFilter() { // from class: com.mixpanel.android.mpmetrics.MPDbAdapter.MPDatabaseHelper.1
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file2, String str2) {
                        return str2.startsWith("com.mixpanel.android.mpmetrics.MixpanelAPI_");
                    }
                })) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(str.split("\\.xml")[0], 0);
                    String string = sharedPreferences.getString("waiting_array", null);
                    if (string != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            sQLiteDatabase.beginTransaction();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                try {
                                    try {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                        String string2 = jSONObject.getString("$token");
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("data", jSONObject.toString());
                                        contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                                        contentValues.put("automatic_data", Boolean.FALSE);
                                        contentValues.put(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, string2);
                                        sQLiteDatabase.insert("anonymous_people", null, contentValues);
                                    } catch (JSONException unused) {
                                    }
                                } catch (Throwable th) {
                                    sQLiteDatabase.endTransaction();
                                    throw th;
                                }
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                        } catch (JSONException unused2) {
                        }
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.remove("waiting_array");
                        editorEdit.apply();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            MPLog.e("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            sQLiteDatabase.execSQL(MPDbAdapter.f46012c);
            sQLiteDatabase.execSQL(MPDbAdapter.f46013d);
            sQLiteDatabase.execSQL(MPDbAdapter.f46014e);
            sQLiteDatabase.execSQL(MPDbAdapter.f46015f);
            sQLiteDatabase.execSQL(MPDbAdapter.f46016g);
            sQLiteDatabase.execSQL(MPDbAdapter.f46017h);
            sQLiteDatabase.execSQL(MPDbAdapter.f46018i);
            sQLiteDatabase.execSQL(MPDbAdapter.f46019j);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws JSONException, SQLException {
            int i4;
            int i5;
            MPLog.e("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            if (i2 < 4 || i3 > 7) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS people");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groups");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anonymous_people");
                sQLiteDatabase.execSQL(MPDbAdapter.f46012c);
                sQLiteDatabase.execSQL(MPDbAdapter.f46013d);
                sQLiteDatabase.execSQL(MPDbAdapter.f46014e);
                sQLiteDatabase.execSQL(MPDbAdapter.f46015f);
                sQLiteDatabase.execSQL(MPDbAdapter.f46016g);
                sQLiteDatabase.execSQL(MPDbAdapter.f46017h);
                sQLiteDatabase.execSQL(MPDbAdapter.f46018i);
                sQLiteDatabase.execSQL(MPDbAdapter.f46019j);
                return;
            }
            if (i2 == 4) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN automatic_data INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE people ADD COLUMN automatic_data INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN token STRING NOT NULL DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE people ADD COLUMN token STRING NOT NULL DEFAULT ''");
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM events", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        String string = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("data") >= 0 ? cursorRawQuery.getColumnIndex("data") : 1)).getJSONObject("properties").getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN);
                        i5 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("_id") >= 0 ? cursorRawQuery.getColumnIndex("_id") : 0);
                        try {
                            sQLiteDatabase.execSQL("UPDATE events SET " + CLConstants.SHARED_PREFERENCE_ITEM_TOKEN + " = '" + string + "' WHERE _id = " + i5);
                        } catch (JSONException unused) {
                            sQLiteDatabase.delete("events", "_id = " + i5, null);
                        }
                    } catch (JSONException unused2) {
                        i5 = 0;
                    }
                }
                Cursor cursorRawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM people", null);
                while (cursorRawQuery2.moveToNext()) {
                    try {
                        String string2 = new JSONObject(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("data") >= 0 ? cursorRawQuery2.getColumnIndex("data") : 1)).getString("$token");
                        i4 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("_id") >= 0 ? cursorRawQuery2.getColumnIndex("_id") : 0);
                        try {
                            sQLiteDatabase.execSQL("UPDATE people SET " + CLConstants.SHARED_PREFERENCE_ITEM_TOKEN + " = '" + string2 + "' WHERE _id = " + i4);
                        } catch (JSONException unused3) {
                            sQLiteDatabase.delete("people", "_id = " + i4, null);
                        }
                    } catch (JSONException unused4) {
                        i4 = 0;
                    }
                }
                sQLiteDatabase.execSQL(MPDbAdapter.f46014e);
                sQLiteDatabase.execSQL(MPDbAdapter.f46018i);
                b(sQLiteDatabase);
            }
            if (i2 == 5) {
                sQLiteDatabase.execSQL(MPDbAdapter.f46014e);
                sQLiteDatabase.execSQL(MPDbAdapter.f46018i);
                b(sQLiteDatabase);
            }
            if (i2 == 6) {
                b(sQLiteDatabase);
            }
        }
    }

    public enum Table {
        EVENTS("events"),
        PEOPLE("people"),
        ANONYMOUS_PEOPLE("anonymous_people"),
        GROUPS("groups");


        /* renamed from: a, reason: collision with root package name */
        public final String f46029a;

        Table(String str) {
            this.f46029a = str;
        }
    }

    public MPDbAdapter(Context context) {
        this.f46020a = new MPDatabaseHelper(context);
    }

    public static MPDbAdapter g(Context context) {
        MPDbAdapter mPDbAdapter;
        HashMap map = f46011b;
        synchronized (map) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (map.containsKey(applicationContext)) {
                    mPDbAdapter = (MPDbAdapter) map.get(applicationContext);
                } else {
                    mPDbAdapter = new MPDbAdapter(applicationContext);
                    map.put(applicationContext, mPDbAdapter);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mPDbAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082 A[PHI: r2
      0x0082: PHI (r2v5 android.database.Cursor) = (r2v4 android.database.Cursor), (r2v7 android.database.Cursor) binds: [B:18:0x0080, B:27:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(org.json.JSONObject r9, java.lang.String r10, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r11, boolean r12) throws java.lang.Throwable {
        /*
            r8 = this;
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r0 = r8.f46020a
            java.lang.String r1 = "SELECT COUNT(*) FROM "
            boolean r2 = r8.b()
            java.lang.String r3 = "MixpanelAPI.Database"
            if (r2 != 0) goto L13
            java.lang.String r9 = "There is not enough space left on the device to store Mixpanel data, so data was discarded"
            com.mixpanel.android.util.MPLog.b(r3, r9)
            r9 = -2
            return r9
        L13:
            java.lang.String r11 = r11.f46029a
            r2 = 0
            android.database.sqlite.SQLiteDatabase r4 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r5.<init>()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r6 = "data"
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r5.put(r6, r9)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r9 = "created_at"
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r5.put(r9, r6)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r9 = "automatic_data"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r5.put(r9, r12)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r9 = "token"
            r5.put(r9, r10)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r4.insert(r11, r2, r5)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r9.<init>(r1)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r9.append(r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r11 = " WHERE token='"
            r9.append(r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r9.append(r10)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r10 = "'"
            r9.append(r10)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            android.database.Cursor r9 = r4.rawQuery(r9, r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79 java.lang.OutOfMemoryError -> L7b
            r9.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.OutOfMemoryError -> L75 android.database.sqlite.SQLiteException -> L89
            r10 = 0
            int r10 = r9.getInt(r10)     // Catch: java.lang.Throwable -> L72 java.lang.OutOfMemoryError -> L75 android.database.sqlite.SQLiteException -> L89
            r9.close()
            r0.close()
            return r10
        L72:
            r10 = move-exception
            r2 = r9
            goto L9d
        L75:
            r2 = r9
            goto L7b
        L77:
            r10 = move-exception
            goto L9d
        L79:
            r9 = r2
            goto L89
        L7b:
            java.lang.String r9 = "Out of memory when adding Mixpanel data to table"
            com.mixpanel.android.util.MPLog.b(r3, r9)     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L85
        L82:
            r2.close()
        L85:
            r0.close()
            goto L9b
        L89:
            java.lang.String r10 = "Could not add Mixpanel data to table"
            com.mixpanel.android.util.MPLog.b(r3, r10)     // Catch: java.lang.Throwable -> L72
            if (r9 == 0) goto L94
            r9.close()     // Catch: java.lang.Throwable -> L72
            goto L95
        L94:
            r2 = r9
        L95:
            r0.a()     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L85
            goto L82
        L9b:
            r9 = -1
            return r9
        L9d:
            if (r2 == 0) goto La2
            r2.close()
        La2:
            r0.close()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.a(org.json.JSONObject, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, boolean):int");
    }

    public final boolean b() {
        MPDatabaseHelper mPDatabaseHelper = this.f46020a;
        File file = mPDatabaseHelper.f46021a;
        return !file.exists() || Math.max(file.getUsableSpace(), (long) mPDatabaseHelper.f46022b.f46002e) >= file.length();
    }

    public final void c(Table table, String str) {
        MPDatabaseHelper mPDatabaseHelper = this.f46020a;
        String str2 = table.f46029a;
        try {
            mPDatabaseHelper.getWritableDatabase().delete(str2, "token = '" + str + "'", null);
        } catch (SQLiteException e2) {
            MPLog.c("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + str2 + ". Re-initializing database.", e2);
            mPDatabaseHelper.a();
        } finally {
            mPDatabaseHelper.close();
        }
    }

    public final void d(Table table, String str) {
        MPDatabaseHelper mPDatabaseHelper = this.f46020a;
        String str2 = table.f46029a;
        try {
            mPDatabaseHelper.getWritableDatabase().delete(str2, "automatic_data = 1 AND token = '" + str + "'", null);
        } catch (SQLiteException e2) {
            MPLog.c("MixpanelAPI.Database", "Could not clean automatic Mixpanel records from " + str2 + ". Re-initializing database.", e2);
            mPDatabaseHelper.a();
        } finally {
            mPDatabaseHelper.close();
        }
    }

    public final void e(long j2, Table table) {
        MPDatabaseHelper mPDatabaseHelper = this.f46020a;
        String str = table.f46029a;
        try {
            mPDatabaseHelper.getWritableDatabase().delete(str, "created_at <= " + j2, null);
        } catch (SQLiteException e2) {
            MPLog.c("MixpanelAPI.Database", "Could not clean timed-out Mixpanel records from " + str + ". Re-initializing database.", e2);
            mPDatabaseHelper.a();
        } finally {
            mPDatabaseHelper.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String[] f(com.mixpanel.android.mpmetrics.MPDbAdapter.Table r13, java.lang.String r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.f(com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String, boolean):java.lang.String[]");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(12:85|11|(1:13)(1:17)|18|(1:20)(1:21)|22|(1:24)(1:25)|26|(1:28)(1:29)|30|31|(12:92|32|33|83|34|35|(1:37)(1:41)|42|43|44|45|97))|46|81|9) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(java.lang.String r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.h(java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "properties"
            java.lang.String r1 = "data"
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r2 = r9.f46020a
            java.lang.String r3 = "SELECT * FROM events WHERE token = '"
            boolean r4 = r9.b()
            java.lang.String r5 = "MixpanelAPI.Database"
            if (r4 != 0) goto L17
            java.lang.String r10 = "There is not enough space left on the device to store Mixpanel data, so data was discarded"
            com.mixpanel.android.util.MPLog.b(r5, r10)
            r10 = -2
            return r10
        L17:
            r4 = 0
            android.database.sqlite.SQLiteDatabase r6 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.append(r10)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r10 = "'"
            r8.append(r10)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r10 = r8.toString()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r10 = r7.toString()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r10 = r6.rawQuery(r10, r4)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L73
        L3d:
            boolean r3 = r10.moveToNext()     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L63
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            r3.<init>()     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            int r3 = r10.getColumnIndex(r1)     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            if (r3 < 0) goto L55
            int r3 = r10.getColumnIndex(r1)     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            goto L56
        L53:
            r0 = move-exception
            goto L75
        L55:
            r3 = 1
        L56:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            java.lang.String r3 = r10.getString(r3)     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            r7.<init>(r3)     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            r7.getJSONObject(r0)     // Catch: org.json.JSONException -> L3d java.lang.Throwable -> L53
            throw r4     // Catch: java.lang.Throwable -> L53
        L63:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L53
            r6.endTransaction()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L73
            r10.close()
        L6c:
            r2.close()
            goto L92
        L70:
            r0 = move-exception
            r4 = r10
            goto L94
        L73:
            r0 = move-exception
            goto L7d
        L75:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L73
            throw r0     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L73
        L79:
            r0 = move-exception
            goto L94
        L7b:
            r0 = move-exception
            r10 = r4
        L7d:
            java.lang.String r1 = "Could not re-write events history. Re-initializing database."
            com.mixpanel.android.util.MPLog.c(r5, r1, r0)     // Catch: java.lang.Throwable -> L70
            if (r10 == 0) goto L88
            r10.close()     // Catch: java.lang.Throwable -> L70
            goto L89
        L88:
            r4 = r10
        L89:
            r2.a()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L6c
            r4.close()
            goto L6c
        L92:
            r10 = 0
            return r10
        L94:
            if (r4 == 0) goto L99
            r4.close()
        L99:
            r2.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.i(java.lang.String):int");
    }
}
