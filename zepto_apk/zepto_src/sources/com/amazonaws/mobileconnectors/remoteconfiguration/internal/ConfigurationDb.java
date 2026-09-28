package com.amazonaws.mobileconnectors.remoteconfiguration.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.media.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Configuration;
import com.amazonaws.mobileconnectors.remoteconfiguration.exceptions.ConfigurationNotFoundException;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear.Checks;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfigurationImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class ConfigurationDb {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f15273d = {"json", "timestamp"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f15274e = {"json", "timestamp", "entity_tag", "origin"};

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, ConfigurationDb> f15275f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final a f15276a;

    /* renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f15277b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f15278c = new AtomicInteger(0);

    public static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        public final File f15279a;

        public a(Context context, String str) {
            super(context, a(str), (SQLiteDatabase.CursorFactory) null, 2);
            this.f15279a = context.getDatabasePath(a(str));
        }

        public static String a(String str) {
            return b.k(str, "_ConfigurationCache.db");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws Throwable {
            String[] strArr = ConfigurationDb.f15273d;
            boolean z = true;
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("CREATE TABLE configuration (_id INTEGER PRIMARY KEY, json TEXT, origin INTEGER NOT NULL CHECK (origin IN (1,2,3)), timestamp INTEGER, entity_tag TEXT);");
                sQLiteDatabase.beginTransaction();
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL((String) it.next());
                        String[] strArr2 = ConfigurationDb.f15273d;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    try {
                        String[] strArr3 = ConfigurationDb.f15273d;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            this.f15279a.delete();
                            String[] strArr4 = ConfigurationDb.f15273d;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    sQLiteDatabase.endTransaction();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            throw new DowngradeException();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) throws SQLException {
            super.onOpen(sQLiteDatabase);
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
            if (i2 != 1 || i3 != 2) {
                throw new IllegalArgumentException(b.d(i2, i3, "Illegal upgrade: ", " to "));
            }
            String[] strArr = ConfigurationDb.f15273d;
            sQLiteDatabase.execSQL("DROP INDEX e_tag_idx_configuration;");
            sQLiteDatabase.execSQL("DROP INDEX configuration_type_idx_configuration;");
            sQLiteDatabase.execSQL("ALTER TABLE configuration RENAME TO configuration_old;");
            sQLiteDatabase.execSQL("CREATE TABLE configuration (_id INTEGER PRIMARY KEY, json TEXT, origin INTEGER NOT NULL CHECK (origin IN (1,2,3)), timestamp INTEGER, entity_tag TEXT);");
            sQLiteDatabase.execSQL("INSERT INTO configuration(_id, json, origin, entity_tag, timestamp) SELECT _id, value, CASE WHEN e_tag IS NULL THEN 1 ELSE 2 END AS origin, e_tag, last_load_time FROM configuration_old WHERE configuration_type = 1;");
            sQLiteDatabase.execSQL("DROP TABLE configuration_old;");
        }
    }

    public ConfigurationDb(a aVar) {
        this.f15276a = aVar;
    }

    public static ConfigurationDb getOrCreateInstance(Context context, String str) {
        ConfigurationDb configurationDb;
        String strReplace = str.replace("/", "");
        Map<String, ConfigurationDb> map = f15275f;
        synchronized (map) {
            configurationDb = map.get(strReplace);
            if (configurationDb == null) {
                a aVar = new a(context, strReplace);
                try {
                    aVar.getWritableDatabase();
                } catch (DowngradeException unused) {
                    context.deleteDatabase(a.a(strReplace));
                    aVar = new a(context, strReplace);
                }
                ConfigurationDb configurationDb2 = new ConfigurationDb(aVar);
                f15275f.put(strReplace, configurationDb2);
                configurationDb = configurationDb2;
            }
        }
        return configurationDb;
    }

    public final synchronized void a() {
        SQLiteDatabase sQLiteDatabase;
        if (this.f15278c.decrementAndGet() == 0 && (sQLiteDatabase = this.f15277b) != null) {
            sQLiteDatabase.close();
        }
    }

    public synchronized SQLiteDatabase b() {
        try {
            if (this.f15278c.incrementAndGet() == 1) {
                this.f15277b = this.f15276a.getWritableDatabase();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15277b;
    }

    public synchronized void deleteConfiguration() {
        SQLiteDatabase sQLiteDatabaseB;
        Throwable th;
        try {
            sQLiteDatabaseB = b();
            try {
                sQLiteDatabaseB.beginTransaction();
                sQLiteDatabaseB.delete(CLConstants.INPUT_CONFIGURATION, null, null);
                sQLiteDatabaseB.setTransactionSuccessful();
                sQLiteDatabaseB.endTransaction();
                a();
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabaseB != null) {
                    sQLiteDatabaseB.endTransaction();
                }
                a();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteDatabaseB = null;
            th = th3;
        }
    }

    public synchronized Configuration readConfiguration() throws ConfigurationNotFoundException {
        SQLiteDatabase sQLiteDatabaseB;
        Configuration configurationA;
        Cursor cursor = null;
        try {
            sQLiteDatabaseB = b();
            try {
                sQLiteDatabaseB.beginTransaction();
                Cursor cursorQuery = sQLiteDatabaseB.query(CLConstants.INPUT_CONFIGURATION, f15273d, null, null, null, null, null);
                sQLiteDatabaseB.setTransactionSuccessful();
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new ConfigurationNotFoundException("Configuration not found");
                }
                configurationA = a(cursorQuery);
                cursorQuery.close();
                sQLiteDatabaseB.endTransaction();
                a();
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabaseB != null) {
                    sQLiteDatabaseB.endTransaction();
                }
                a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseB = null;
        }
        return configurationA;
    }

    public synchronized RemoteConfiguration readRemoteConfiguration(String str) {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseB;
        Cursor cursor = null;
        try {
            sQLiteDatabaseB = b();
            try {
                sQLiteDatabaseB.beginTransaction();
                Cursor cursorQuery = sQLiteDatabaseB.query(CLConstants.INPUT_CONFIGURATION, f15274e, null, null, null, null, null);
                try {
                    sQLiteDatabaseB.setTransactionSuccessful();
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        sQLiteDatabaseB.endTransaction();
                        a();
                        return null;
                    }
                    RemoteConfigurationImpl remoteConfigurationImpl = new RemoteConfigurationImpl(a(cursorQuery), str, cursorQuery.getInt(3), cursorQuery.getString(2), false);
                    cursorQuery.close();
                    sQLiteDatabaseB.endTransaction();
                    a();
                    return remoteConfigurationImpl;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseB != null) {
                        sQLiteDatabaseB.endTransaction();
                    }
                    a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabaseB = null;
        }
    }

    public void saveConfiguration(RemoteConfiguration remoteConfiguration) throws Throwable {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseB;
        if (remoteConfiguration == null) {
            throw new NullPointerException("The RemoteConfiguration may not be null");
        }
        if (remoteConfiguration.getConfiguration() == null) {
            throw new NullPointerException("The contained Configuration may not be null");
        }
        if (remoteConfiguration.getConfiguration().getTimestamp() == null) {
            throw new NullPointerException("The Configuration's timestamp may not be null");
        }
        String asJsonString = remoteConfiguration.getConfiguration().getAsJsonString();
        int origin = remoteConfiguration.getOrigin();
        Long lValueOf = Long.valueOf(remoteConfiguration.getConfiguration().getTimestamp().getTime());
        String entityTag = remoteConfiguration.getEntityTag();
        synchronized (this) {
            try {
                try {
                    Checks.checkNotNull(asJsonString, "configuration cannot be null");
                    Checks.checkNotNull(lValueOf, "timestamp cannot be null for non-default configuration");
                    try {
                        sQLiteDatabaseB = b();
                        try {
                            sQLiteDatabaseB.beginTransaction();
                            try {
                                a(sQLiteDatabaseB, asJsonString, origin, lValueOf, entityTag);
                                sQLiteDatabaseB.setTransactionSuccessful();
                                sQLiteDatabaseB.endTransaction();
                                a();
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                if (sQLiteDatabaseB != null) {
                                    sQLiteDatabaseB.endTransaction();
                                }
                                a();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabaseB = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str, int i2, Long l2, String str2) throws SQLException {
        Integer numValueOf = Integer.valueOf(i2);
        ContentValues contentValues = new ContentValues();
        if (str != null) {
            contentValues.put("json", str);
        } else {
            contentValues.putNull("json");
        }
        contentValues.put("origin", numValueOf);
        if (l2 != null) {
            contentValues.put("timestamp", l2);
        } else {
            contentValues.putNull("timestamp");
        }
        if (str2 != null) {
            contentValues.put("entity_tag", str2);
        } else {
            contentValues.putNull("entity_tag");
        }
        if (a(sQLiteDatabase)) {
            int iUpdate = sQLiteDatabase.update(CLConstants.INPUT_CONFIGURATION, contentValues, null, null);
            if (iUpdate == 1) {
                contentValues.toString();
                return;
            }
            throw new IllegalStateException(b.g(iUpdate, "Updated ", " rows while was intending to update one and only one row in configuration"));
        }
        sQLiteDatabase.insertOrThrow(CLConstants.INPUT_CONFIGURATION, null, contentValues);
        contentValues.toString();
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = sQLiteDatabase.query(CLConstants.INPUT_CONFIGURATION, new String[]{"_id"}, null, null, null, null, null, "1");
        if (cursorQuery == null) {
            return false;
        }
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        cursorQuery.close();
        return zMoveToFirst;
    }

    public final Configuration a(Cursor cursor) {
        if (cursor.getString(0) != null) {
            return new ConfigurationImpl(cursor.getString(0), cursor.isNull(1) ? null : new Date(cursor.getLong(1)));
        }
        throw new ConfigurationNotFoundException("Configuration not found");
    }
}
