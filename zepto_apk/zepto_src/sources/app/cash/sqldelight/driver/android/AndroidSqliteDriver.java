package app.cash.sqldelight.driver.android;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.coroutines.a;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import com.zeptonow.horizon.storage.shared.EventDatabaseImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidSqliteDriver implements SqlDriver {

    /* renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper f13154a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f13155b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f13156c;

    /* renamed from: d, reason: collision with root package name */
    public final AndroidSqliteDriver$statements$1 f13157d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f13158e;

    @Metadata
    public static class Callback extends SupportSQLiteOpenHelper.Callback {

        /* renamed from: b, reason: collision with root package name */
        public final EventDatabaseImpl.Schema f13159b;

        /* renamed from: c, reason: collision with root package name */
        public final AfterVersion[] f13160c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(AfterVersion... callbacks) {
            super((int) 2);
            EventDatabaseImpl.Schema schema = EventDatabaseImpl.Schema.f48226a;
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            this.f13159b = schema;
            this.f13160c = callbacks;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public final void c(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            AndroidSqliteDriver driver = new AndroidSqliteDriver(db);
            this.f13159b.getClass();
            Intrinsics.checkNotNullParameter(driver, "driver");
            driver.b0(null, "CREATE TABLE EventEntity (\n  eventId TEXT NOT NULL PRIMARY KEY,\n  name TEXT NOT NULL,\n  properties TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  failureCount INTEGER NOT NULL,\n  status TEXT NOT NULL,\n  lastFailureReason TEXT,\n  eventType TEXT NOT NULL DEFAULT \"EVENTS_V1\"\n)", null);
            QueryResult.f13140a.getClass();
            new QueryResult.Value(QueryResult.Companion.f13143b);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public final void f(FrameworkSQLiteDatabase db, int i2, int i3) {
            Intrinsics.checkNotNullParameter(db, "db");
            AndroidSqliteDriver driver = new AndroidSqliteDriver(db);
            long j2 = i2;
            long j3 = i3;
            AfterVersion[] afterVersionArr = this.f13160c;
            AfterVersion[] callbacks = (AfterVersion[]) Arrays.copyOf(afterVersionArr, afterVersionArr.length);
            this.f13159b.getClass();
            Intrinsics.checkNotNullParameter(driver, "driver");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            ArrayList arrayList = new ArrayList();
            for (AfterVersion afterVersion : callbacks) {
                afterVersion.getClass();
                if (j2 <= 0 && 0 < j3) {
                    arrayList.add(afterVersion);
                }
            }
            Iterator it = CollectionsKt.Y(new Comparator() { // from class: com.zeptonow.horizon.storage.shared.EventDatabaseImpl$Schema$migrate-zeHU3Mk$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    ((AfterVersion) obj).getClass();
                    ((AfterVersion) obj2).getClass();
                    return ComparisonsKt.a(0L, 0L);
                }
            }, arrayList).iterator();
            if (it.hasNext()) {
                ((AfterVersion) it.next()).getClass();
                EventDatabaseImpl.Schema.a(driver, j2, 1L);
                throw null;
            }
            if (j2 < j3) {
                EventDatabaseImpl.Schema.a(driver, j2, j3);
            }
            QueryResult.f13140a.getClass();
            new QueryResult.Value(QueryResult.Companion.f13143b);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public final class Transaction extends Transacter.Transaction {
    }

    public AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, final FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i2) {
        this.f13154a = supportSQLiteOpenHelper;
        if (!((supportSQLiteOpenHelper != null) ^ (frameworkSQLiteDatabase != null))) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f13155b = new ThreadLocal();
        this.f13156c = LazyKt.b(new Function0<SupportSQLiteDatabase>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$database$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SupportSQLiteDatabase supportSQLiteDatabaseM1;
                SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.f13161c.f13154a;
                if (supportSQLiteOpenHelper2 != null && (supportSQLiteDatabaseM1 = supportSQLiteOpenHelper2.m1()) != null) {
                    return supportSQLiteDatabaseM1;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = frameworkSQLiteDatabase;
                Intrinsics.c(frameworkSQLiteDatabase2);
                return frameworkSQLiteDatabase2;
            }
        });
        this.f13157d = new AndroidSqliteDriver$statements$1(i2);
        this.f13158e = new LinkedHashMap();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void I0(String[] queryKeys, Query.Listener listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f13158e) {
            try {
                for (String str : queryKeys) {
                    Set set = (Set) this.f13158e.get(str);
                    if (set != null) {
                        set.remove(listener);
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void O0(String[] queryKeys, a listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f13158e) {
            try {
                for (String str : queryKeys) {
                    LinkedHashMap linkedHashMap = this.f13158e;
                    Object linkedHashSet = linkedHashMap.get(str);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        linkedHashMap.put(str, linkedHashSet);
                    }
                    ((Set) linkedHashSet).add(listener);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final Transacter.Transaction V0() {
        return (Transacter.Transaction) this.f13155b.get();
    }

    public final Object a(Integer num, Function0 function0, Function1 function1, Function1 function12) {
        AndroidSqliteDriver$statements$1 androidSqliteDriver$statements$1 = this.f13157d;
        AndroidStatement androidStatementRemove = num != null ? androidSqliteDriver$statements$1.remove(num) : null;
        if (androidStatementRemove == null) {
            androidStatementRemove = (AndroidStatement) function0.invoke();
        }
        if (function1 != null) {
            try {
                function1.invoke(androidStatementRemove);
            } catch (Throwable th) {
                if (num != null) {
                    AndroidStatement androidStatementPut = androidSqliteDriver$statements$1.put(num, androidStatementRemove);
                    if (androidStatementPut != null) {
                        androidStatementPut.close();
                    }
                } else {
                    androidStatementRemove.close();
                }
                throw th;
            }
        }
        Object objInvoke = function12.invoke(androidStatementRemove);
        if (num == null) {
            androidStatementRemove.close();
            return objInvoke;
        }
        AndroidStatement androidStatementPut2 = androidSqliteDriver$statements$1.put(num, androidStatementRemove);
        if (androidStatementPut2 != null) {
            androidStatementPut2.close();
        }
        return objInvoke;
    }

    public final SupportSQLiteDatabase b() {
        return (SupportSQLiteDatabase) this.f13156c.getValue();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult b0(Integer num, final String sql, Function1 function1) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return new QueryResult.Value(a(num, new Function0<AndroidStatement>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$execute$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new AndroidPreparedStatement(this.f13163c.b().N0(sql));
            }
        }, function1, AndroidSqliteDriver$execute$2.f13165c));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Unit unit;
        this.f13157d.evictAll();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f13154a;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.close();
            unit = Unit.f53572a;
        } else {
            unit = null;
        }
        if (unit == null) {
            b().close();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void g1(String... queryKeys) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.f13158e) {
            try {
                for (String str : queryKeys) {
                    Set set = (Set) this.f13158e.get(str);
                    if (set != null) {
                        linkedHashSet.addAll(set);
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((Query.Listener) it.next()).a();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult r1(Integer num, final String sql, final Function1 mapper, Function1 function1) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new QueryResult.Value(a(num, new Function0<AndroidStatement>(this) { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$executeQuery$1

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AndroidSqliteDriver f13167d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f13167d = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new AndroidQuery(sql, this.f13167d.b());
            }
        }, function1, new Function1<AndroidStatement, Object>(mapper) { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$executeQuery$2

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Lambda f13168c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.f13168c = (Lambda) mapper;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AndroidStatement execute = (AndroidStatement) obj;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                return execute.b(this.f13168c);
            }
        }));
    }

    public /* synthetic */ AndroidSqliteDriver(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        this(null, frameworkSQLiteDatabase, 1);
    }
}
