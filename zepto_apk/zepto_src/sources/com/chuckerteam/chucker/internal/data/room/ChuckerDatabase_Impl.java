package com.chuckerteam.chucker.internal.data.room;

import android.database.SQLException;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.amazon.apay.hardened.external.model.APayConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class ChuckerDatabase_Impl extends ChuckerDatabase {

    /* renamed from: m, reason: collision with root package name */
    public volatile HttpTransactionDao_Impl f16724m;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker d() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "transactions");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper e(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper callback = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate() { // from class: com.chuckerteam.chucker.internal.data.room.ChuckerDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `transactions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `requestDate` INTEGER, `responseDate` INTEGER, `tookMs` INTEGER, `protocol` TEXT, `method` TEXT, `url` TEXT, `host` TEXT, `path` TEXT, `scheme` TEXT, `responseTlsVersion` TEXT, `responseCipherSuite` TEXT, `requestPayloadSize` INTEGER, `requestContentType` TEXT, `requestHeaders` TEXT, `requestHeadersSize` INTEGER, `requestBody` TEXT, `isRequestBodyEncoded` INTEGER NOT NULL, `responseCode` INTEGER, `responseMessage` TEXT, `error` TEXT, `responsePayloadSize` INTEGER, `responseContentType` TEXT, `responseHeaders` TEXT, `responseHeadersSize` INTEGER, `responseBody` TEXT, `isResponseBodyEncoded` INTEGER NOT NULL, `responseImageData` BLOB, `graphQlDetected` INTEGER NOT NULL, `graphQlOperationName` TEXT)");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                frameworkSQLiteDatabase.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ac72c06b37efb89e6417a7707016d4f5')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void b(FrameworkSQLiteDatabase db) throws SQLException {
                db.C("DROP TABLE IF EXISTS `transactions`");
                ArrayList arrayList = ChuckerDatabase_Impl.this.f11803g;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void c(FrameworkSQLiteDatabase db) {
                ArrayList arrayList = ChuckerDatabase_Impl.this.f11803g;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                ChuckerDatabase_Impl.this.f11797a = frameworkSQLiteDatabase;
                ChuckerDatabase_Impl.this.k(frameworkSQLiteDatabase);
                ArrayList arrayList = ChuckerDatabase_Impl.this.f11803g;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).a(frameworkSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void f(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
                DBUtil.a(frameworkSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final RoomOpenHelper.ValidationResult g(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                HashMap map = new HashMap(30);
                map.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, new TableInfo.Column(1, 1, CLConstants.SHARED_PREFERENCE_ITEM_ID, "INTEGER", null, true));
                map.put("requestDate", new TableInfo.Column(0, 1, "requestDate", "INTEGER", null, false));
                map.put("responseDate", new TableInfo.Column(0, 1, "responseDate", "INTEGER", null, false));
                map.put("tookMs", new TableInfo.Column(0, 1, "tookMs", "INTEGER", null, false));
                map.put("protocol", new TableInfo.Column(0, 1, "protocol", "TEXT", null, false));
                map.put("method", new TableInfo.Column(0, 1, "method", "TEXT", null, false));
                map.put("url", new TableInfo.Column(0, 1, "url", "TEXT", null, false));
                map.put("host", new TableInfo.Column(0, 1, "host", "TEXT", null, false));
                map.put("path", new TableInfo.Column(0, 1, "path", "TEXT", null, false));
                map.put("scheme", new TableInfo.Column(0, 1, "scheme", "TEXT", null, false));
                map.put("responseTlsVersion", new TableInfo.Column(0, 1, "responseTlsVersion", "TEXT", null, false));
                map.put("responseCipherSuite", new TableInfo.Column(0, 1, "responseCipherSuite", "TEXT", null, false));
                map.put("requestPayloadSize", new TableInfo.Column(0, 1, "requestPayloadSize", "INTEGER", null, false));
                map.put("requestContentType", new TableInfo.Column(0, 1, "requestContentType", "TEXT", null, false));
                map.put("requestHeaders", new TableInfo.Column(0, 1, "requestHeaders", "TEXT", null, false));
                map.put("requestHeadersSize", new TableInfo.Column(0, 1, "requestHeadersSize", "INTEGER", null, false));
                map.put("requestBody", new TableInfo.Column(0, 1, "requestBody", "TEXT", null, false));
                map.put("isRequestBodyEncoded", new TableInfo.Column(0, 1, "isRequestBodyEncoded", "INTEGER", null, true));
                map.put(APayConstants.RESPONSE_CODE, new TableInfo.Column(0, 1, APayConstants.RESPONSE_CODE, "INTEGER", null, false));
                map.put("responseMessage", new TableInfo.Column(0, 1, "responseMessage", "TEXT", null, false));
                map.put("error", new TableInfo.Column(0, 1, "error", "TEXT", null, false));
                map.put("responsePayloadSize", new TableInfo.Column(0, 1, "responsePayloadSize", "INTEGER", null, false));
                map.put("responseContentType", new TableInfo.Column(0, 1, "responseContentType", "TEXT", null, false));
                map.put("responseHeaders", new TableInfo.Column(0, 1, "responseHeaders", "TEXT", null, false));
                map.put("responseHeadersSize", new TableInfo.Column(0, 1, "responseHeadersSize", "INTEGER", null, false));
                map.put("responseBody", new TableInfo.Column(0, 1, "responseBody", "TEXT", null, false));
                map.put("isResponseBodyEncoded", new TableInfo.Column(0, 1, "isResponseBodyEncoded", "INTEGER", null, true));
                map.put("responseImageData", new TableInfo.Column(0, 1, "responseImageData", "BLOB", null, false));
                map.put("graphQlDetected", new TableInfo.Column(0, 1, "graphQlDetected", "INTEGER", null, true));
                map.put("graphQlOperationName", new TableInfo.Column(0, 1, "graphQlOperationName", "TEXT", null, false));
                TableInfo tableInfo = new TableInfo("transactions", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfoA = TableInfo.a(frameworkSQLiteDatabase, "transactions");
                if (tableInfo.equals(tableInfoA)) {
                    return new RoomOpenHelper.ValidationResult(null, true);
                }
                return new RoomOpenHelper.ValidationResult("transactions(com.chuckerteam.chucker.internal.data.entity.HttpTransaction).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA, false);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            }
        }, "ac72c06b37efb89e6417a7707016d4f5", "a70b1841a05694f746087779f5a5c887");
        SupportSQLiteOpenHelper.Configuration.Builder builderA = SupportSQLiteOpenHelper.Configuration.Companion.a(databaseConfiguration.f11740a);
        builderA.f11902b = databaseConfiguration.f11741b;
        Intrinsics.checkNotNullParameter(callback, "callback");
        builderA.f11903c = callback;
        return databaseConfiguration.f11742c.g(builderA.a());
    }

    @Override // androidx.room.RoomDatabase
    public final List f(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set h() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map i() {
        HashMap map = new HashMap();
        map.put(HttpTransactionDao.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.chuckerteam.chucker.internal.data.room.ChuckerDatabase
    public final HttpTransactionDao q() {
        HttpTransactionDao_Impl httpTransactionDao_Impl;
        if (this.f16724m != null) {
            return this.f16724m;
        }
        synchronized (this) {
            try {
                if (this.f16724m == null) {
                    this.f16724m = new HttpTransactionDao_Impl(this);
                }
                httpTransactionDao_Impl = this.f16724m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return httpTransactionDao_Impl;
    }
}
