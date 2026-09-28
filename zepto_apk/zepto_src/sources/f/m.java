package f;

import android.content.Context;
import android.database.Cursor;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import com.amazon.identity.auth.device.dataobject.Profile;

/* loaded from: classes4.dex */
public final class m extends c<Profile> {

    /* renamed from: b, reason: collision with root package name */
    public static m f48365b;

    /* renamed from: c, reason: collision with root package name */
    public static a f48366c;

    public static synchronized m k(Context context) {
        try {
            if (f48365b == null) {
                f48365b = new m(k.b.b(context));
                f48366c = new a(context, "ProfileDataSource");
            }
            f48366c.a(f48365b);
        } catch (Throwable th) {
            throw th;
        }
        return f48365b;
    }

    @Override // f.c
    public final AbstractDataObject d(Cursor cursor) {
        b bVar;
        if (cursor.getCount() == 0) {
            return null;
        }
        try {
            Profile profile = new Profile();
            profile.f15203a = cursor.getLong(a(cursor, 0));
            profile.f15223b = cursor.getString(a(cursor, 2));
            profile.f15225d = k.b(k.a(cursor.getString(a(cursor, 1))));
            a aVar = f48366c;
            String string = cursor.getString(a(cursor, 3));
            aVar.getClass();
            if (string.startsWith("AES_00|")) {
                int i2 = a.f48351d;
                try {
                    Context context = aVar.f48362a;
                    synchronized (b.class) {
                        try {
                            if (b.f48353b == null) {
                                b.f48353b = new b(context);
                            }
                            bVar = b.f48353b;
                        } finally {
                        }
                    }
                    string = bVar.a(string);
                } catch (Exception unused) {
                    string = null;
                }
            }
            profile.f15224c = string;
            return profile;
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // f.c
    public final String[] h() {
        return Profile.f15222e;
    }

    @Override // f.c
    public final String j() {
        return "Profile";
    }
}
