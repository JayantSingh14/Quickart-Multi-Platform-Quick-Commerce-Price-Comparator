package f;

import android.content.Context;
import android.database.Cursor;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import com.amazon.identity.auth.device.dataobject.AuthorizationToken;
import com.amazon.identity.auth.device.token.AccessAtzToken;
import com.amazon.identity.auth.device.token.RefreshAtzToken;

/* loaded from: classes4.dex */
public final class e extends c<AuthorizationToken> {

    /* renamed from: b, reason: collision with root package name */
    public static e f48357b;

    /* renamed from: c, reason: collision with root package name */
    public static a f48358c;

    public static synchronized e k(Context context) {
        try {
            if (f48357b == null) {
                f48357b = new e(k.b.b(context));
                f48358c = new a(context, "AuthTokenDataSource");
            }
            f48358c.a(f48357b);
        } catch (Throwable th) {
            throw th;
        }
        return f48357b;
    }

    @Override // f.c
    public final AbstractDataObject d(Cursor cursor) {
        AuthorizationToken accessAtzToken;
        b bVar;
        if (cursor.getCount() == 0) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            System.arraycopy(c.c.f13231a, 0, iArr, 0, 2);
            int i2 = iArr[cursor.getInt(a(cursor, 6))];
            if (i2 == 0) {
                throw null;
            }
            int i3 = i2 - 1;
            if (i3 == 0) {
                accessAtzToken = new AccessAtzToken();
            } else {
                if (i3 != 1) {
                    throw new IllegalArgumentException("Unknown token type for factory ".concat(i2 != 1 ? i2 == 2 ? "REFRESH" : "null" : "ACCESS"));
                }
                accessAtzToken = new RefreshAtzToken();
            }
            accessAtzToken.f15203a = cursor.getLong(a(cursor, 0));
            accessAtzToken.f15215b = cursor.getString(a(cursor, 1));
            a aVar = f48358c;
            String string = cursor.getString(a(cursor, 2));
            aVar.getClass();
            if (string.startsWith("AES_00|")) {
                int i4 = a.f48351d;
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
            accessAtzToken.f15216c = string;
            accessAtzToken.f15217d = k.b(k.a(cursor.getString(a(cursor, 3))));
            accessAtzToken.f15218e = k.b(k.a(cursor.getString(a(cursor, 4))));
            accessAtzToken.f15219f = cursor.getBlob(a(cursor, 5));
            accessAtzToken.f15221h = cursor.getString(a(cursor, 7));
            return accessAtzToken;
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // f.c
    public final String[] h() {
        return AuthorizationToken.f15214i;
    }

    @Override // f.c
    public final String j() {
        return "AuthorizationToken";
    }
}
