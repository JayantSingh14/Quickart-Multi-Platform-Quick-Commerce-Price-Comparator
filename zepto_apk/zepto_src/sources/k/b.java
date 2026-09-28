package k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import f.h;
import f.i;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static SQLiteDatabase f53507a;

    /* renamed from: b, reason: collision with root package name */
    public static SQLiteDatabase f53508b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f53509c;

    public static synchronized SQLiteDatabase a(Context context) {
        synchronized (b.class) {
            try {
                if (f53509c == null) {
                    boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("com.amazon.software.fireos");
                    String.valueOf(zHasSystemFeature);
                    f53509c = Boolean.valueOf(zHasSystemFeature && Build.VERSION.SDK_INT >= 30);
                }
            } finally {
            }
        }
        if (!f53509c.booleanValue()) {
            return b(context);
        }
        if (f53508b == null) {
            try {
                f53508b = new i(context.createDeviceProtectedStorageContext()).getWritableDatabase();
            } catch (SQLiteException unused) {
                throw null;
            }
        }
        return f53508b;
    }

    public static synchronized SQLiteDatabase b(Context context) {
        try {
            if (f53507a == null) {
                try {
                    f53507a = new h(context).getWritableDatabase();
                } catch (SQLiteException unused) {
                    throw null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f53507a;
    }
}
