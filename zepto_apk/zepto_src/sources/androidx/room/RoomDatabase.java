package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile FrameworkSQLiteDatabase f11797a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f11798b;

    /* renamed from: c, reason: collision with root package name */
    public TransactionExecutor f11799c;

    /* renamed from: d, reason: collision with root package name */
    public SupportSQLiteOpenHelper f11800d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11802f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f11803g;

    /* renamed from: k, reason: collision with root package name */
    public final Map f11807k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f11808l;

    /* renamed from: e, reason: collision with root package name */
    public final InvalidationTracker f11801e = d();

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f11804h = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final ReentrantReadWriteLock f11805i = new ReentrantReadWriteLock();

    /* renamed from: j, reason: collision with root package name */
    public final ThreadLocal f11806j = new ThreadLocal();

    @Metadata
    @SourceDebugExtension
    public static class Builder<T extends RoomDatabase> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f11809a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f11810b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11811c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f11812d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f11813e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f11814f;

        /* renamed from: g, reason: collision with root package name */
        public Executor f11815g;

        /* renamed from: h, reason: collision with root package name */
        public Executor f11816h;

        /* renamed from: i, reason: collision with root package name */
        public c f11817i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11818j;

        /* renamed from: k, reason: collision with root package name */
        public final JournalMode f11819k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f11820l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f11821m;
        public final long n;
        public final MigrationContainer o;
        public final LinkedHashSet p;
        public HashSet q;

        public Builder(Context context, Class klass, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(klass, "klass");
            this.f11809a = context;
            this.f11810b = klass;
            this.f11811c = str;
            this.f11812d = new ArrayList();
            this.f11813e = new ArrayList();
            this.f11814f = new ArrayList();
            this.f11819k = JournalMode.f11822a;
            this.f11820l = true;
            this.n = -1L;
            this.o = new MigrationContainer();
            this.p = new LinkedHashSet();
        }

        public final void a(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            if (this.q == null) {
                this.q = new HashSet();
            }
            for (Migration migration : migrations) {
                HashSet hashSet = this.q;
                Intrinsics.c(hashSet);
                hashSet.add(Integer.valueOf(migration.f11857a));
                HashSet hashSet2 = this.q;
                Intrinsics.c(hashSet2);
                hashSet2.add(Integer.valueOf(migration.f11858b));
            }
            this.o.a((Migration[]) Arrays.copyOf(migrations, migrations.length));
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.room.RoomDatabase b() throws java.lang.ClassNotFoundException {
            /*
                Method dump skipped, instructions count: 938
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.Builder.b():androidx.room.RoomDatabase");
        }
    }

    @Metadata
    public static abstract class Callback {
        public void a(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }
    }

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class JournalMode {

        /* renamed from: a, reason: collision with root package name */
        public static final JournalMode f11822a;

        /* renamed from: b, reason: collision with root package name */
        public static final JournalMode f11823b;

        /* renamed from: c, reason: collision with root package name */
        public static final JournalMode f11824c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ JournalMode[] f11825d;

        static {
            JournalMode journalMode = new JournalMode("AUTOMATIC", 0);
            f11822a = journalMode;
            JournalMode journalMode2 = new JournalMode("TRUNCATE", 1);
            f11823b = journalMode2;
            JournalMode journalMode3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            f11824c = journalMode3;
            f11825d = new JournalMode[]{journalMode, journalMode2, journalMode3};
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) f11825d.clone();
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class MigrationContainer {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f11826a = new LinkedHashMap();

        public final void a(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (Migration migration : migrations) {
                int i2 = migration.f11857a;
                LinkedHashMap linkedHashMap = this.f11826a;
                Integer numValueOf = Integer.valueOf(i2);
                Object treeMap = linkedHashMap.get(numValueOf);
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    linkedHashMap.put(numValueOf, treeMap);
                }
                TreeMap treeMap2 = (TreeMap) treeMap;
                int i3 = migration.f11858b;
                if (treeMap2.containsKey(Integer.valueOf(i3))) {
                    Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i3)) + " with " + migration);
                }
                treeMap2.put(Integer.valueOf(i3), migration);
            }
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static abstract class PrepackagedDatabaseCallback {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface QueryCallback {
    }

    public RoomDatabase() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f11807k = mapSynchronizedMap;
        this.f11808l = new LinkedHashMap();
    }

    public static Object p(Class cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return p(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).a());
        }
        return null;
    }

    public final void a() {
        if (!this.f11802f && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!g().m1().z1() && this.f11806j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        a();
        SupportSQLiteDatabase supportSQLiteDatabaseM1 = g().m1();
        this.f11801e.e(supportSQLiteDatabaseM1);
        if (supportSQLiteDatabaseM1.E1()) {
            supportSQLiteDatabaseM1.U();
        } else {
            supportSQLiteDatabaseM1.w();
        }
    }

    public abstract InvalidationTracker d();

    public abstract SupportSQLiteOpenHelper e(DatabaseConfiguration databaseConfiguration);

    public List f(LinkedHashMap autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return EmptyList.f53609a;
    }

    public final SupportSQLiteOpenHelper g() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f11800d;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.h("internalOpenHelper");
        throw null;
    }

    public Set h() {
        return EmptySet.f53611a;
    }

    public Map i() {
        return MapsKt.c();
    }

    public final void j() {
        g().m1().e0();
        if (g().m1().z1()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.f11801e;
        if (invalidationTracker.f11768f.compareAndSet(false, true)) {
            Executor executor = invalidationTracker.f11763a.f11798b;
            if (executor != null) {
                executor.execute(invalidationTracker.n);
            } else {
                Intrinsics.h("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final void k(FrameworkSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "db");
        InvalidationTracker invalidationTracker = this.f11801e;
        invalidationTracker.getClass();
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (invalidationTracker.f11775m) {
            if (invalidationTracker.f11769g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.C("PRAGMA temp_store = MEMORY;");
            database.C("PRAGMA recursive_triggers='ON';");
            database.C("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            invalidationTracker.e(database);
            invalidationTracker.f11770h = database.N0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            invalidationTracker.f11769g = true;
            Unit unit = Unit.f53572a;
        }
    }

    public final boolean l() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.f11797a;
        return frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.f11908a.isOpen();
    }

    public final Cursor m(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        a();
        b();
        return g().m1().m0(query);
    }

    public final Object n(Callable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        c();
        try {
            Object objCall = body.call();
            o();
            return objCall;
        } finally {
            j();
        }
    }

    public final void o() {
        g().m1().S();
    }
}
