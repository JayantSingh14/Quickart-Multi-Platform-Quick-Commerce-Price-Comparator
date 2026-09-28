package f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class k extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final long f48363a = TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f48364b = 0;

    public k(Context context) {
        super(context, "MAPDataStore.db", (SQLiteDatabase.CursorFactory) null, 9);
    }

    public static Date a(String str) {
        if (!str.endsWith("Z")) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str);
    }

    public static Date b(Date date) {
        if (date == null) {
            return null;
        }
        long time = date.getTime();
        long j2 = f48363a;
        date.setTime((time / j2) * j2);
        return date;
    }

    public static void c(Context context) {
        d dVar;
        n nVar;
        f fVar;
        synchronized (d.class) {
            try {
                if (d.f48356b == null) {
                    d.f48356b = new d(k.b.a(context));
                }
                dVar = d.f48356b;
            } catch (Throwable th) {
                throw th;
            }
        }
        dVar.f();
        e.k(context).f();
        synchronized (n.class) {
            try {
                if (n.f48367b == null) {
                    n.f48367b = new n(k.b.b(context));
                }
                nVar = n.f48367b;
            } finally {
            }
        }
        nVar.f();
        m.k(context).f();
        synchronized (f.class) {
            try {
                if (f.f48359b == null) {
                    f.f48359b = new f(k.b.b(context));
                    f.f48360c = new a(context, "CodePairDataSource");
                }
                f.f48360c.a(f.f48359b);
                fVar = f.f48359b;
            } finally {
            }
        }
        fVar.f();
    }
}
