package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11796a = new ArrayList();

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void J(int i2, double d2) {
        a(i2, Double.valueOf(d2));
    }

    public final void a(int i2, Object obj) {
        int size;
        int i3 = i2 - 1;
        ArrayList arrayList = this.f11796a;
        if (i3 >= arrayList.size() && (size = arrayList.size()) <= i3) {
            while (true) {
                arrayList.add(null);
                if (size == i3) {
                    break;
                } else {
                    size++;
                }
            }
        }
        arrayList.set(i3, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void e1(int i2, long j2) {
        a(i2, Long.valueOf(j2));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void i1(int i2, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void m(int i2, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void y1(int i2) {
        a(i2, null);
    }
}
