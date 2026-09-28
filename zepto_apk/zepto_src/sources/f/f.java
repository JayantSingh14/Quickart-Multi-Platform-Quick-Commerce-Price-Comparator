package f;

import android.content.Context;
import android.database.Cursor;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import java.net.URI;

/* loaded from: classes4.dex */
public final class f extends c<e.b> {

    /* renamed from: b, reason: collision with root package name */
    public static f f48359b;

    /* renamed from: c, reason: collision with root package name */
    public static a f48360c;

    @Override // f.c
    public final AbstractDataObject d(Cursor cursor) {
        String str;
        b bVar;
        if (cursor.getCount() == 0) {
            return null;
        }
        try {
            String string = cursor.getString(a(cursor, 1));
            String string2 = cursor.getString(a(cursor, 2));
            a aVar = f48360c;
            String string3 = cursor.getString(a(cursor, 3));
            aVar.getClass();
            if (string3.startsWith("AES_00|")) {
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
                    string3 = bVar.a(string3);
                    str = string3;
                } catch (Exception unused) {
                    str = null;
                }
            } else {
                str = string3;
            }
            e.b bVar2 = new e.b(string, string2, str, new URI(cursor.getString(a(cursor, 4))), cursor.getInt(a(cursor, 5)), k.a(cursor.getString(a(cursor, 6))), k.a(cursor.getString(a(cursor, 7))), cursor.getString(a(cursor, 8)).split(","));
            bVar2.f15203a = cursor.getLong(a(cursor, 0));
            return bVar2;
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // f.c
    public final String[] h() {
        return e.b.f48314j;
    }

    @Override // f.c
    public final String j() {
        return "CodePair";
    }
}
