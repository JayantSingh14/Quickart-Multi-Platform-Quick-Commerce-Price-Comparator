package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.builders.SetBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class InvalidationTracker {
    public static final String[] o = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11763a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f11764b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f11765c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f11766d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f11767e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f11768f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f11769g;

    /* renamed from: h, reason: collision with root package name */
    public volatile SupportSQLiteStatement f11770h;

    /* renamed from: i, reason: collision with root package name */
    public final ObservedTableTracker f11771i;

    /* renamed from: j, reason: collision with root package name */
    public final InvalidationLiveDataContainer f11772j;

    /* renamed from: k, reason: collision with root package name */
    public final SafeIterableMap f11773k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f11774l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f11775m;
    public final InvalidationTracker$refreshRunnable$1 n;

    @Metadata
    public static final class Companion {
        public static String a(String tableName, String triggerType) {
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class ObservedTableTracker {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f11776a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f11777b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f11778c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11779d;

        @Metadata
        public static final class Companion {
        }

        public ObservedTableTracker(int i2) {
            this.f11776a = new long[i2];
            this.f11777b = new boolean[i2];
            this.f11778c = new int[i2];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.f11779d) {
                        return null;
                    }
                    long[] jArr = this.f11776a;
                    int length = jArr.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        int i4 = i3 + 1;
                        int i5 = 1;
                        boolean z = jArr[i2] > 0;
                        boolean[] zArr = this.f11777b;
                        if (z != zArr[i3]) {
                            int[] iArr = this.f11778c;
                            if (!z) {
                                i5 = 2;
                            }
                            iArr[i3] = i5;
                        } else {
                            this.f11778c[i3] = 0;
                        }
                        zArr[i3] = z;
                        i2++;
                        i3 = i4;
                    }
                    this.f11779d = false;
                    return (int[]) this.f11778c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static abstract class Observer {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f11780a;

        public Observer(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.f11780a = tables;
        }

        public final String[] a() {
            return this.f11780a;
        }

        public abstract void b(Set set);
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class ObserverWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Observer f11781a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f11782b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f11783c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f11784d;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            this.f11781a = observer;
            this.f11782b = tableIds;
            this.f11783c = tableNames;
            this.f11784d = tableNames.length == 0 ? EmptySet.f53611a : SetsKt.e(tableNames[0]);
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final int[] a() {
            return this.f11782b;
        }

        public final void b(Set invalidatedTablesIds) {
            Set setA;
            Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.f11782b;
            int length = iArr.length;
            if (length != 0) {
                int i2 = 0;
                if (length != 1) {
                    SetBuilder setBuilder = new SetBuilder();
                    int length2 = iArr.length;
                    int i3 = 0;
                    while (i2 < length2) {
                        int i4 = i3 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr[i2]))) {
                            setBuilder.add(this.f11783c[i3]);
                        }
                        i2++;
                        i3 = i4;
                    }
                    setA = SetsKt.a(setBuilder);
                } else {
                    setA = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.f11784d : EmptySet.f53611a;
                }
            } else {
                setA = EmptySet.f53611a;
            }
            if (setA.isEmpty()) {
                return;
            }
            this.f11781a.b(setA);
        }

        public final void c(String[] tables) {
            Set setA;
            Intrinsics.checkNotNullParameter(tables, "tables");
            String[] strArr = this.f11783c;
            int length = strArr.length;
            if (length == 0) {
                setA = EmptySet.f53611a;
            } else if (length == 1) {
                int length2 = tables.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        setA = EmptySet.f53611a;
                        break;
                    } else {
                        if (StringsKt.t(tables[i2], strArr[0], true)) {
                            setA = this.f11784d;
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                SetBuilder setBuilder = new SetBuilder();
                for (String str : tables) {
                    for (String str2 : strArr) {
                        if (StringsKt.t(str2, str, true)) {
                            setBuilder.add(str2);
                        }
                    }
                }
                setA = SetsKt.a(setBuilder);
            }
            if (setA.isEmpty()) {
                return;
            }
            this.f11781a.b(setA);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class WeakObserver extends Observer {

        /* renamed from: b, reason: collision with root package name */
        public final InvalidationTracker f11785b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference f11786c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker tracker, RoomTrackingLiveData$observer$1 delegate) {
            super(delegate.f11780a);
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f11785b = tracker;
            this.f11786c = new WeakReference(delegate);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public final void b(Set tables) {
            ObserverWrapper observerWrapper;
            boolean z;
            Intrinsics.checkNotNullParameter(tables, "tables");
            Observer observer = (Observer) this.f11786c.get();
            if (observer != null) {
                observer.b(tables);
                return;
            }
            InvalidationTracker invalidationTracker = this.f11785b;
            invalidationTracker.getClass();
            Intrinsics.checkNotNullParameter(this, "observer");
            synchronized (invalidationTracker.f11773k) {
                observerWrapper = (ObserverWrapper) invalidationTracker.f11773k.f(this);
            }
            if (observerWrapper != null) {
                ObservedTableTracker observedTableTracker = invalidationTracker.f11771i;
                int[] iArrA = observerWrapper.a();
                int[] tableIds = Arrays.copyOf(iArrA, iArrA.length);
                observedTableTracker.getClass();
                Intrinsics.checkNotNullParameter(tableIds, "tableIds");
                synchronized (observedTableTracker) {
                    try {
                        z = false;
                        for (int i2 : tableIds) {
                            long[] jArr = observedTableTracker.f11776a;
                            long j2 = jArr[i2];
                            jArr[i2] = j2 - 1;
                            if (j2 == 1) {
                                observedTableTracker.f11779d = true;
                                z = true;
                            }
                        }
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    RoomDatabase roomDatabase = invalidationTracker.f11763a;
                    if (roomDatabase.l()) {
                        invalidationTracker.e(roomDatabase.g().m1());
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.room.InvalidationTracker$refreshRunnable$1] */
    public InvalidationTracker(RoomDatabase database, HashMap shadowTablesMap, HashMap viewTables, String... tableNames) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f11763a = database;
        this.f11764b = shadowTablesMap;
        this.f11765c = viewTables;
        this.f11768f = new AtomicBoolean(false);
        this.f11771i = new ObservedTableTracker(tableNames.length);
        this.f11772j = new InvalidationLiveDataContainer(database);
        this.f11773k = new SafeIterableMap();
        this.f11774l = new Object();
        this.f11775m = new Object();
        this.f11766d = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = tableNames[i2];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f11766d.put(lowerCase2, Integer.valueOf(i2));
            String str2 = (String) this.f11764b.get(tableNames[i2]);
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                lowerCase = str2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i2] = lowerCase2;
        }
        this.f11767e = strArr;
        for (Map.Entry entry : this.f11764b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase3 = str3.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f11766d.containsKey(lowerCase3)) {
                String str4 = (String) entry.getKey();
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase4 = str4.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f11766d;
                linkedHashMap.put(lowerCase4, MapsKt.d(lowerCase3, linkedHashMap));
            }
        }
        this.n = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            public final SetBuilder a() {
                InvalidationTracker invalidationTracker = this.f11787a;
                SetBuilder setBuilder = new SetBuilder();
                Cursor cursorM = invalidationTracker.f11763a.m(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                try {
                    Cursor cursor = cursorM;
                    while (cursor.moveToNext()) {
                        setBuilder.add(Integer.valueOf(cursor.getInt(0)));
                    }
                    Unit unit = Unit.f53572a;
                    CloseableKt.a(cursorM, null);
                    SetBuilder setBuilderA = SetsKt.a(setBuilder);
                    if (setBuilderA.f53674a.isEmpty()) {
                        return setBuilderA;
                    }
                    if (this.f11787a.f11770h == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    SupportSQLiteStatement supportSQLiteStatement = this.f11787a.f11770h;
                    if (supportSQLiteStatement == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    supportSQLiteStatement.H();
                    return setBuilderA;
                } finally {
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Set setA;
                ReentrantReadWriteLock.ReadLock lock = this.f11787a.f11763a.f11805i.readLock();
                Intrinsics.checkNotNullExpressionValue(lock, "readWriteLock.readLock()");
                lock.lock();
                try {
                    try {
                    } finally {
                        lock.unlock();
                        this.f11787a.getClass();
                    }
                } catch (SQLiteException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    setA = EmptySet.f53611a;
                } catch (IllegalStateException e3) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
                    setA = EmptySet.f53611a;
                }
                if (this.f11787a.b()) {
                    if (this.f11787a.f11768f.compareAndSet(true, false)) {
                        if (this.f11787a.f11763a.g().m1().z1()) {
                            return;
                        }
                        SupportSQLiteDatabase supportSQLiteDatabaseM1 = this.f11787a.f11763a.g().m1();
                        supportSQLiteDatabaseM1.U();
                        try {
                            setA = a();
                            supportSQLiteDatabaseM1.S();
                            if (setA.isEmpty()) {
                                return;
                            }
                            InvalidationTracker invalidationTracker = this.f11787a;
                            synchronized (invalidationTracker.f11773k) {
                                try {
                                    Iterator it = invalidationTracker.f11773k.iterator();
                                    while (it.hasNext()) {
                                        ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).b(setA);
                                    }
                                    Unit unit = Unit.f53572a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } finally {
                            supportSQLiteDatabaseM1.e0();
                        }
                    }
                }
            }
        };
    }

    public final RoomTrackingLiveData a(String[] tableNames, Callable computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        String[] tableNames2 = c(tableNames);
        for (String str : tableNames2) {
            LinkedHashMap linkedHashMap = this.f11766d;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!linkedHashMap.containsKey(lowerCase)) {
                throw new IllegalArgumentException("There is no table with name ".concat(str).toString());
            }
        }
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.f11772j;
        invalidationLiveDataContainer.getClass();
        Intrinsics.checkNotNullParameter(tableNames2, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        return new RoomTrackingLiveData(invalidationLiveDataContainer.f11761a, invalidationLiveDataContainer, computeFunction, tableNames2);
    }

    public final boolean b() {
        if (!this.f11763a.l()) {
            return false;
        }
        if (!this.f11769g) {
            this.f11763a.g().m1();
        }
        if (this.f11769g) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final String[] c(String[] strArr) {
        SetBuilder setBuilder = new SetBuilder();
        for (String str : strArr) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            HashMap map = this.f11765c;
            if (map.containsKey(lowerCase)) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map.get(lowerCase2);
                Intrinsics.c(obj);
                setBuilder.addAll((Collection) obj);
            } else {
                setBuilder.add(str);
            }
        }
        return (String[]) SetsKt.a(setBuilder).toArray(new String[0]);
    }

    public final void d(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        supportSQLiteDatabase.C("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f11767e[i2];
        String[] strArr = o;
        for (int i3 = 0; i3 < 3; i3++) {
            String str2 = strArr[i3];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.a(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i2 + " AND invalidated = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.C(str3);
        }
    }

    public final void e(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.z1()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.f11763a.f11805i.readLock();
            Intrinsics.checkNotNullExpressionValue(lock, "readWriteLock.readLock()");
            lock.lock();
            try {
                synchronized (this.f11774l) {
                    int[] iArrA = this.f11771i.a();
                    if (iArrA != null) {
                        Intrinsics.checkNotNullParameter(database, "database");
                        if (database.E1()) {
                            database.U();
                        } else {
                            database.w();
                        }
                        try {
                            int length = iArrA.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                int i4 = iArrA[i2];
                                int i5 = i3 + 1;
                                if (i4 == 1) {
                                    d(database, i3);
                                } else if (i4 == 2) {
                                    String str = this.f11767e[i3];
                                    String[] strArr = o;
                                    for (int i6 = 0; i6 < 3; i6++) {
                                        String str2 = "DROP TRIGGER IF EXISTS " + Companion.a(str, strArr[i6]);
                                        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder().apply(builderAction).toString()");
                                        database.C(str2);
                                    }
                                }
                                i2++;
                                i3 = i5;
                            }
                            database.S();
                            database.e0();
                            Unit unit = Unit.f53572a;
                        } catch (Throwable th) {
                            database.e0();
                            throw th;
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        } catch (SQLiteException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        } catch (IllegalStateException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        }
    }
}
