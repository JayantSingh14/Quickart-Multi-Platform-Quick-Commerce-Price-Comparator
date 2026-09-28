package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11910a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11911b;

    /* renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Callback f11912c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11913d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11914e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f11915f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11916g;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class DBRefHolder {

        /* renamed from: a, reason: collision with root package name */
        public FrameworkSQLiteDatabase f11917a = null;
    }

    @Metadata
    public static final class OpenHelper extends SQLiteOpenHelper implements AutoCloseable {

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f11918h = 0;

        /* renamed from: a, reason: collision with root package name */
        public final Context f11919a;

        /* renamed from: b, reason: collision with root package name */
        public final DBRefHolder f11920b;

        /* renamed from: c, reason: collision with root package name */
        public final SupportSQLiteOpenHelper.Callback f11921c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11922d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11923e;

        /* renamed from: f, reason: collision with root package name */
        public final ProcessLock f11924f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11925g;

        @Metadata
        public static final class CallbackException extends RuntimeException {

            /* renamed from: a, reason: collision with root package name */
            public final CallbackName f11926a;

            /* renamed from: b, reason: collision with root package name */
            public final Throwable f11927b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable cause) {
                super(cause);
                Intrinsics.checkNotNullParameter(callbackName, "callbackName");
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.f11926a = callbackName;
                this.f11927b = cause;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.f11927b;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata
        /* loaded from: classes3.dex */
        public static final class CallbackName {

            /* renamed from: a, reason: collision with root package name */
            public static final CallbackName f11928a;

            /* renamed from: b, reason: collision with root package name */
            public static final CallbackName f11929b;

            /* renamed from: c, reason: collision with root package name */
            public static final CallbackName f11930c;

            /* renamed from: d, reason: collision with root package name */
            public static final CallbackName f11931d;

            /* renamed from: e, reason: collision with root package name */
            public static final CallbackName f11932e;

            /* renamed from: f, reason: collision with root package name */
            public static final /* synthetic */ CallbackName[] f11933f;

            static {
                CallbackName callbackName = new CallbackName("ON_CONFIGURE", 0);
                f11928a = callbackName;
                CallbackName callbackName2 = new CallbackName("ON_CREATE", 1);
                f11929b = callbackName2;
                CallbackName callbackName3 = new CallbackName("ON_UPGRADE", 2);
                f11930c = callbackName3;
                CallbackName callbackName4 = new CallbackName("ON_DOWNGRADE", 3);
                f11931d = callbackName4;
                CallbackName callbackName5 = new CallbackName("ON_OPEN", 4);
                f11932e = callbackName5;
                f11933f = new CallbackName[]{callbackName, callbackName2, callbackName3, callbackName4, callbackName5};
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) f11933f.clone();
            }
        }

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
            public static FrameworkSQLiteDatabase a(DBRefHolder refHolder, SQLiteDatabase sqLiteDatabase) {
                Intrinsics.checkNotNullParameter(refHolder, "refHolder");
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = refHolder.f11917a;
                if (frameworkSQLiteDatabase != null) {
                    Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                    if (Intrinsics.b(frameworkSQLiteDatabase.f11908a, sqLiteDatabase)) {
                        return frameworkSQLiteDatabase;
                    }
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.f11917a = frameworkSQLiteDatabase2;
                return frameworkSQLiteDatabase2;
            }
        }

        @Metadata
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final DBRefHolder dbRef, final SupportSQLiteOpenHelper.Callback callback, boolean z) {
            String string;
            super(context, str, null, callback.f11895a, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.b
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase dbObj) {
                    int i2 = FrameworkSQLiteOpenHelper.OpenHelper.f11918h;
                    SupportSQLiteOpenHelper.Callback callback2 = callback;
                    Intrinsics.checkNotNullParameter(callback2, "$callback");
                    FrameworkSQLiteOpenHelper.DBRefHolder dbRef2 = dbRef;
                    Intrinsics.checkNotNullParameter(dbRef2, "$dbRef");
                    Intrinsics.checkNotNullExpressionValue(dbObj, "dbObj");
                    FrameworkSQLiteDatabase db = FrameworkSQLiteOpenHelper.OpenHelper.Companion.a(dbRef2, dbObj);
                    callback2.getClass();
                    Intrinsics.checkNotNullParameter(db, "db");
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db + ".path");
                    SQLiteDatabase sQLiteDatabase = db.f11908a;
                    if (!sQLiteDatabase.isOpen()) {
                        String path = sQLiteDatabase.getPath();
                        if (path != null) {
                            SupportSQLiteOpenHelper.Callback.a(path);
                            return;
                        }
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase.getAttachedDbs();
                        } finally {
                            if (attachedDbs != null) {
                                Iterator<T> it = attachedDbs.iterator();
                                while (it.hasNext()) {
                                    Object obj = ((Pair) it.next()).second;
                                    Intrinsics.checkNotNullExpressionValue(obj, "p.second");
                                    SupportSQLiteOpenHelper.Callback.a((String) obj);
                                }
                            } else {
                                String path2 = sQLiteDatabase.getPath();
                                if (path2 != null) {
                                    SupportSQLiteOpenHelper.Callback.a(path2);
                                }
                            }
                        }
                    } catch (SQLiteException unused) {
                    }
                    try {
                        db.close();
                    } catch (IOException unused2) {
                    }
                    if (attachedDbs != null) {
                        return;
                    }
                }
            });
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dbRef, "dbRef");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f11919a = context;
            this.f11920b = dbRef;
            this.f11921c = callback;
            this.f11922d = z;
            if (str == null) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            } else {
                string = str;
            }
            this.f11924f = new ProcessLock(string, context.getCacheDir(), false);
        }

        public final SupportSQLiteDatabase a(boolean z) throws IOException {
            ProcessLock processLock = this.f11924f;
            try {
                processLock.a((this.f11925g || getDatabaseName() == null) ? false : true);
                this.f11923e = false;
                SQLiteDatabase sQLiteDatabaseE = e(z);
                if (!this.f11923e) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabaseB = b(sQLiteDatabaseE);
                    processLock.b();
                    return frameworkSQLiteDatabaseB;
                }
                close();
                SupportSQLiteDatabase supportSQLiteDatabaseA = a(z);
                processLock.b();
                return supportSQLiteDatabaseA;
            } catch (Throwable th) {
                processLock.b();
                throw th;
            }
        }

        public final FrameworkSQLiteDatabase b(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            return Companion.a(this.f11920b, sqLiteDatabase);
        }

        public final SQLiteDatabase c(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() throws IOException {
            ProcessLock processLock = this.f11924f;
            try {
                processLock.a(processLock.f11941a);
                super.close();
                this.f11920b.f11917a = null;
                this.f11925g = false;
            } finally {
                processLock.b();
            }
        }

        public final SQLiteDatabase e(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.f11925g;
            Context context = this.f11919a;
            if (databaseName != null && !z2 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return c(z);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return c(z);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        int iOrdinal = callbackException.f11926a.ordinal();
                        Throwable th2 = callbackException.f11927b;
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(th2 instanceof SQLiteException)) {
                            throw th2;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f11922d) {
                        throw th;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return c(z);
                    } catch (CallbackException e2) {
                        throw e2.f11927b;
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            boolean z = this.f11923e;
            SupportSQLiteOpenHelper.Callback callback = this.f11921c;
            if (!z && callback.f11895a != db.getVersion()) {
                db.setMaxSqlCacheSize(1);
            }
            try {
                callback.b(b(db));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f11928a, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.f11921c.c(b(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f11929b, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase db, int i2, int i3) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.f11923e = true;
            try {
                this.f11921c.d(b(db), i2, i3);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f11931d, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!this.f11923e) {
                try {
                    this.f11921c.e(b(db));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.f11932e, th);
                }
            }
            this.f11925g = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sqLiteDatabase, int i2, int i3) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            this.f11923e = true;
            try {
                this.f11921c.f(b(sqLiteDatabase), i2, i3);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f11930c, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f11910a = context;
        this.f11911b = str;
        this.f11912c = callback;
        this.f11913d = z;
        this.f11914e = z2;
        this.f11915f = LazyKt.b(new Function0<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper sQLiteOpenHelper;
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = this.f11934c;
                if (frameworkSQLiteOpenHelper.f11911b == null || !frameworkSQLiteOpenHelper.f11913d) {
                    sQLiteOpenHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f11910a, frameworkSQLiteOpenHelper.f11911b, new FrameworkSQLiteOpenHelper.DBRefHolder(), frameworkSQLiteOpenHelper.f11912c, frameworkSQLiteOpenHelper.f11914e);
                } else {
                    Context context2 = frameworkSQLiteOpenHelper.f11910a;
                    Intrinsics.checkNotNullParameter(context2, "context");
                    File noBackupFilesDir = context2.getNoBackupFilesDir();
                    Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
                    sQLiteOpenHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f11910a, new File(noBackupFilesDir, frameworkSQLiteOpenHelper.f11911b).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder(), frameworkSQLiteOpenHelper.f11912c, frameworkSQLiteOpenHelper.f11914e);
                }
                boolean z3 = frameworkSQLiteOpenHelper.f11916g;
                Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
                sQLiteOpenHelper.setWriteAheadLoggingEnabled(z3);
                return sQLiteOpenHelper;
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Lazy lazy = this.f11915f;
        if (lazy.d()) {
            ((OpenHelper) lazy.getValue()).close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase m1() {
        return ((OpenHelper) this.f11915f.getValue()).a(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        Lazy lazy = this.f11915f;
        if (lazy.d()) {
            OpenHelper sQLiteOpenHelper = (OpenHelper) lazy.getValue();
            Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
        this.f11916g = z;
    }
}
