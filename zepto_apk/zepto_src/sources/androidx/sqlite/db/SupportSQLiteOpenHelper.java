package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.media.b;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable, AutoCloseable {

    @Metadata
    @SourceDebugExtension
    public static abstract class Callback {

        /* renamed from: a, reason: collision with root package name */
        public final int f11895a;

        @Metadata
        public static final class Companion {
        }

        public Callback(int i2) {
            this.f11895a = i2;
        }

        public static void a(String str) {
            if (StringsKt.t(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.e(str.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i2, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: ".concat(str));
            try {
                File file = new File(str);
                Intrinsics.checkNotNullParameter(file, "file");
                SQLiteDatabase.deleteDatabase(file);
            } catch (Exception e2) {
                Log.w("SupportSQLite", "delete failed: ", e2);
            }
        }

        public void b(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public abstract void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public void d(FrameworkSQLiteDatabase db, int i2, int i3) {
            Intrinsics.checkNotNullParameter(db, "db");
            throw new SQLiteException(b.d(i2, i3, "Can't downgrade database from version ", " to "));
        }

        public void e(FrameworkSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public abstract void f(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i2, int i3);
    }

    @Metadata
    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final Context f11896a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11897b;

        /* renamed from: c, reason: collision with root package name */
        public final Callback f11898c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11899d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f11900e;

        @Metadata
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final Context f11901a;

            /* renamed from: b, reason: collision with root package name */
            public String f11902b;

            /* renamed from: c, reason: collision with root package name */
            public Callback f11903c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f11904d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f11905e;

            public Builder(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.f11901a = context;
            }

            public final Configuration a() {
                String str;
                Callback callback = this.f11903c;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f11904d && ((str = this.f11902b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new Configuration(this.f11901a, this.f11902b, callback, this.f11904d, this.f11905e);
            }
        }

        @Metadata
        public static final class Companion {
            public static Builder a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new Builder(context);
            }
        }

        public Configuration(Context context, String str, Callback callback, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f11896a = context;
            this.f11897b = str;
            this.f11898c = callback;
            this.f11899d = z;
            this.f11900e = z2;
        }
    }

    @Metadata
    public interface Factory {
        SupportSQLiteOpenHelper g(Configuration configuration);
    }

    SupportSQLiteDatabase m1();

    void setWriteAheadLoggingEnabled(boolean z);
}
