package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Singleton
@WorkerThread
/* loaded from: classes.dex */
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {

    /* renamed from: f, reason: collision with root package name */
    public static final Encoding f20937f = new Encoding("proto");

    /* renamed from: a, reason: collision with root package name */
    public final SchemaManager f20938a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f20939b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f20940c;

    /* renamed from: d, reason: collision with root package name */
    public final EventStoreConfig f20941d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f20942e;

    public interface Function<T, U> {
        Object apply(Object obj);
    }

    /* loaded from: classes3.dex */
    public static class Metadata {

        /* renamed from: a, reason: collision with root package name */
        public final String f20943a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20944b;

        public Metadata(String str, String str2) {
            this.f20943a = str;
            this.f20944b = str2;
        }
    }

    public interface Producer<T> {
    }

    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, Provider provider) {
        this.f20938a = schemaManager;
        this.f20939b = clock;
        this.f20940c = clock2;
        this.f20941d = eventStoreConfig;
        this.f20942e = provider;
    }

    public static String A(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((PersistedEvent) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object D(Cursor cursor, Function function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static Long r(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            Cursor cursor = cursorQuery;
            return !cursor.moveToNext() ? null : Long.valueOf(cursor.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final boolean A0(TransportContext transportContext) {
        Boolean bool;
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            Long lR = r(sQLiteDatabaseL, transportContext);
            if (lR == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = l().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lR.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            sQLiteDatabaseL.setTransactionSuccessful();
            sQLiteDatabaseL.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th2) {
            sQLiteDatabaseL.endTransaction();
            throw th2;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void C0(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + A(iterable);
            SQLiteDatabase sQLiteDatabaseL = l();
            sQLiteDatabaseL.beginTransaction();
            try {
                sQLiteDatabaseL.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseL.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                try {
                    Cursor cursor = cursorRawQuery;
                    while (cursor.moveToNext()) {
                        e(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
                    }
                    cursorRawQuery.close();
                    sQLiteDatabaseL.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    sQLiteDatabaseL.setTransactionSuccessful();
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            } finally {
                sQLiteDatabaseL.endTransaction();
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final PersistedEvent C1(TransportContext transportContext, EventInternal eventInternal) {
        Logging.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.l(), transportContext.b());
        long jLongValue = ((Long) s(new c(this, eventInternal, transportContext, 0))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return PersistedEvent.a(jLongValue, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable L() {
        return (Iterable) s(new a(0));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable P0(final TransportContext transportContext) {
        return (Iterable) s(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.d
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore = this.f20964a;
                EventStoreConfig eventStoreConfig = sQLiteEventStore.f20941d;
                int iC = eventStoreConfig.c();
                TransportContext transportContext2 = transportContext;
                ArrayList arrayListX = sQLiteEventStore.x(sQLiteDatabase, transportContext2, iC);
                for (Priority priority : Priority.values()) {
                    if (priority != transportContext2.d()) {
                        int iC2 = eventStoreConfig.c() - arrayListX.size();
                        if (iC2 <= 0) {
                            break;
                        }
                        arrayListX.addAll(sQLiteEventStore.x(sQLiteDatabase, transportContext2.e(priority), iC2));
                    }
                }
                HashMap map = new HashMap();
                StringBuilder sb = new StringBuilder("event_id IN (");
                for (int i2 = 0; i2 < arrayListX.size(); i2++) {
                    sb.append(((PersistedEvent) arrayListX.get(i2)).c());
                    if (i2 < arrayListX.size() - 1) {
                        sb.append(',');
                    }
                }
                sb.append(')');
                SQLiteEventStore.D(sQLiteDatabase.query("event_metadata", new String[]{"event_id", CLConstants.FIELD_PAY_INFO_NAME, CLConstants.FIELD_PAY_INFO_VALUE}, sb.toString(), null, null, null, null), new f(map, 1));
                ListIterator listIterator = arrayListX.listIterator();
                while (listIterator.hasNext()) {
                    PersistedEvent persistedEvent = (PersistedEvent) listIterator.next();
                    if (map.containsKey(Long.valueOf(persistedEvent.c()))) {
                        EventInternal.Builder builderN = persistedEvent.b().n();
                        for (SQLiteEventStore.Metadata metadata : (Set) map.get(Long.valueOf(persistedEvent.c()))) {
                            builderN.a(metadata.f20943a, metadata.f20944b);
                        }
                        listIterator.set(new AutoValue_PersistedEvent(persistedEvent.c(), persistedEvent.d(), builderN.b()));
                    }
                }
                return arrayListX;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void a() {
        s(new f(this, 0));
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public final Object b(SynchronizationGuard.CriticalSection criticalSection) {
        SQLiteDatabase sQLiteDatabaseL = l();
        Clock clock = this.f20940c;
        long jA = clock.a();
        while (true) {
            try {
                sQLiteDatabaseL.beginTransaction();
                try {
                    Object objD = criticalSection.d();
                    sQLiteDatabaseL.setTransactionSuccessful();
                    return objD;
                } finally {
                    sQLiteDatabaseL.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e2) {
                if (clock.a() >= this.f20941d.a() + jA) {
                    throw new SynchronizationException("Timed out while trying to acquire the lock.", e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final ClientMetrics c() {
        ClientMetrics.Builder builderA = ClientMetrics.a();
        HashMap map = new HashMap();
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            ClientMetrics clientMetrics = (ClientMetrics) D(sQLiteDatabaseL.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new c(this, map, builderA, 2));
            sQLiteDatabaseL.setTransactionSuccessful();
            return clientMetrics;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f20938a.close();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void e(final long j2, final LogEventDropped.Reason reason, final String str) {
        s(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) throws SQLException {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding = SQLiteEventStore.f20937f;
                int i2 = reason.f20825a;
                String string = Integer.toString(i2);
                String str2 = str;
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str2, string});
                try {
                    Encoding encoding2 = SQLiteEventStore.f20937f;
                    boolean z = cursorRawQuery.getCount() > 0;
                    cursorRawQuery.close();
                    long j3 = j2;
                    if (z) {
                        sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j3 + " WHERE log_source = ? AND reason = ?", new String[]{str2, Integer.toString(i2)});
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("log_source", str2);
                    contentValues.put("reason", Integer.valueOf(i2));
                    contentValues.put("events_dropped_count", Long.valueOf(j3));
                    sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                    return null;
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final int f() {
        long jA = this.f20939b.a() - this.f20941d.b();
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            String[] strArr = {String.valueOf(jA)};
            Cursor cursorRawQuery = sQLiteDatabaseL.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
            try {
                Cursor cursor = cursorRawQuery;
                while (cursor.moveToNext()) {
                    e(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
                }
                cursorRawQuery.close();
                int iDelete = sQLiteDatabaseL.delete("events", "timestamp_ms < ?", strArr);
                sQLiteDatabaseL.setTransactionSuccessful();
                return iDelete;
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    public final SQLiteDatabase l() {
        SchemaManager schemaManager = this.f20938a;
        Objects.requireNonNull(schemaManager);
        Clock clock = this.f20940c;
        long jA = clock.a();
        while (true) {
            try {
                return schemaManager.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e2) {
                if (clock.a() >= this.f20941d.a() + jA) {
                    throw new SynchronizationException("Timed out while trying to open db.", e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final Object s(Function function) {
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            Object objApply = function.apply(sQLiteDatabaseL);
            sQLiteDatabaseL.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void u1(final long j2, final TransportContext transportContext) {
        s(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding = SQLiteEventStore.f20937f;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j2));
                TransportContext transportContext2 = transportContext;
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext2.b(), String.valueOf(PriorityMapping.a(transportContext2.d()))}) < 1) {
                    contentValues.put("backend_name", transportContext2.b());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext2.d())));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final long w0(TransportContext transportContext) {
        Cursor cursorRawQuery = l().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))});
        try {
            Cursor cursor = cursorRawQuery;
            Long lValueOf = cursor.moveToNext() ? Long.valueOf(cursor.getLong(0)) : 0L;
            cursorRawQuery.close();
            return lValueOf.longValue();
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public final ArrayList x(SQLiteDatabase sQLiteDatabase, TransportContext transportContext, int i2) {
        ArrayList arrayList = new ArrayList();
        Long lR = r(sQLiteDatabase, transportContext);
        if (lR == null) {
            return arrayList;
        }
        D(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", PaymentConstants.PAYLOAD, "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lR.toString()}, null, null, null, String.valueOf(i2)), new c(this, arrayList, transportContext, 1));
        return arrayList;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void y(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            l().compileStatement("DELETE FROM events WHERE _id in " + A(iterable)).execute();
        }
    }
}
