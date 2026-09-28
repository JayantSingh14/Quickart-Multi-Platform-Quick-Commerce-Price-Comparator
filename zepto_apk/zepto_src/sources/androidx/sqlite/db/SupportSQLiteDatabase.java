package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void C(String str);

    boolean E1();

    boolean F();

    void H1(long j2);

    void L0(int i2);

    SupportSQLiteStatement N0(String str);

    int N1(ContentValues contentValues, Object[] objArr);

    long P();

    void S();

    void U();

    boolean Y0();

    boolean d0();

    void e0();

    void f1(Object[] objArr);

    int getVersion();

    long h1();

    String j();

    Cursor m0(SupportSQLiteQuery supportSQLiteQuery);

    boolean n1();

    void w();

    List z();

    boolean z1();
}
