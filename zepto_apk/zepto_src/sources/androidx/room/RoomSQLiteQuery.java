package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* renamed from: i, reason: collision with root package name */
    public static final TreeMap f11834i = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    public final int f11835a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f11836b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f11837c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f11838d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f11839e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[][] f11840f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f11841g;

    /* renamed from: h, reason: collision with root package name */
    public int f11842h;

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    /* loaded from: classes3.dex */
    public @interface Binding {
    }

    @Metadata
    public static final class Companion {
    }

    public RoomSQLiteQuery(int i2) {
        this.f11835a = i2;
        int i3 = i2 + 1;
        this.f11841g = new int[i3];
        this.f11837c = new long[i3];
        this.f11838d = new double[i3];
        this.f11839e = new String[i3];
        this.f11840f = new byte[i3][];
    }

    public static final RoomSQLiteQuery a(int i2, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        TreeMap treeMap = f11834i;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (entryCeilingEntry == null) {
                Unit unit = Unit.f53572a;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i2);
                Intrinsics.checkNotNullParameter(query, "query");
                roomSQLiteQuery.f11836b = query;
                roomSQLiteQuery.f11842h = i2;
                return roomSQLiteQuery;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            RoomSQLiteQuery sqliteQuery = (RoomSQLiteQuery) entryCeilingEntry.getValue();
            sqliteQuery.getClass();
            Intrinsics.checkNotNullParameter(query, "query");
            sqliteQuery.f11836b = query;
            sqliteQuery.f11842h = i2;
            Intrinsics.checkNotNullExpressionValue(sqliteQuery, "sqliteQuery");
            return sqliteQuery;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void J(int i2, double d2) {
        this.f11841g[i2] = 3;
        this.f11838d[i2] = d2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String c() {
        String str = this.f11836b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void e(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int i2 = this.f11842h;
        if (1 > i2) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = this.f11841g[i3];
            if (i4 == 1) {
                statement.y1(i3);
            } else if (i4 == 2) {
                statement.e1(i3, this.f11837c[i3]);
            } else if (i4 == 3) {
                statement.J(i3, this.f11838d[i3]);
            } else if (i4 == 4) {
                String str = this.f11839e[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.m(i3, str);
            } else if (i4 == 5) {
                byte[] bArr = this.f11840f[i3];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.i1(i3, bArr);
            }
            if (i3 == i2) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void e1(int i2, long j2) {
        this.f11841g[i2] = 2;
        this.f11837c[i2] = j2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void i1(int i2, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f11841g[i2] = 5;
        this.f11840f[i2] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void m(int i2, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f11841g[i2] = 4;
        this.f11839e[i2] = value;
    }

    public final void release() {
        TreeMap treeMap = f11834i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f11835a), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
            Unit unit = Unit.f53572a;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void y1(int i2) {
        this.f11841g[i2] = 1;
    }
}
