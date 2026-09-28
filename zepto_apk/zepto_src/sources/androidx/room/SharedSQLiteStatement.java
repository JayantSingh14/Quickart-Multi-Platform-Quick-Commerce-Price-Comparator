package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11846a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f11847b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f11848c;

    public SharedSQLiteStatement(RoomDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.f11846a = database;
        this.f11847b = new AtomicBoolean(false);
        this.f11848c = LazyKt.b(new Function0<SupportSQLiteStatement>() { // from class: androidx.room.SharedSQLiteStatement$stmt$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f11849c.b();
            }
        });
    }

    public final SupportSQLiteStatement a() {
        this.f11846a.a();
        return this.f11847b.compareAndSet(false, true) ? (SupportSQLiteStatement) this.f11848c.getValue() : b();
    }

    public final SupportSQLiteStatement b() {
        String sql = c();
        RoomDatabase roomDatabase = this.f11846a;
        roomDatabase.getClass();
        Intrinsics.checkNotNullParameter(sql, "sql");
        roomDatabase.a();
        roomDatabase.b();
        return roomDatabase.g().m1().N0(sql);
    }

    public abstract String c();

    public final void d(SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (statement == ((SupportSQLiteStatement) this.f11848c.getValue())) {
            this.f11847b.set(false);
        }
    }
}
