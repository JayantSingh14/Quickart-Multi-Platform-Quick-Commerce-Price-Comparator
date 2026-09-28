package f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class c<K extends AbstractDataObject> {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f48355a;

    public c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            throw new IllegalArgumentException("database can't be null!");
        }
        this.f48355a = sQLiteDatabase;
    }

    public static String i(String[] strArr, String[] strArr2) {
        if (strArr == null && strArr2 == null) {
            return null;
        }
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException("Both arguments have to be either null or not null!");
        }
        if (strArr.length != strArr2.length) {
            throw new IllegalArgumentException("selectionFields and selectionValues differ in length!");
        }
        int i2 = 0;
        String string = "";
        while (i2 < strArr.length) {
            StringBuilder sbW = android.support.v4.media.b.w(string);
            sbW.append(strArr[i2]);
            sbW.append(strArr2[i2] == null ? " IS NULL" : android.support.v4.media.b.r(new StringBuilder(" = '"), strArr2[i2], "'"));
            StringBuilder sbW2 = android.support.v4.media.b.w(sbW.toString());
            sbW2.append(i2 != strArr.length + (-1) ? " AND " : "");
            string = sbW2.toString();
            i2++;
        }
        return string;
    }

    public final int a(Cursor cursor, int i2) {
        if (i2 < 0 || i2 >= h().length) {
            throw new IllegalArgumentException("colIndex is out of bound!");
        }
        return cursor.getColumnIndexOrThrow(h()[i2]);
    }

    public final long b(AbstractDataObject abstractDataObject, Context context) {
        try {
            Objects.toString(abstractDataObject.d(context));
            long jInsert = this.f48355a.insert(j(), null, abstractDataObject.d(context));
            abstractDataObject.f15203a = jInsert;
            return jInsert;
        } catch (l unused) {
            return -1L;
        }
    }

    public final AbstractDataObject c(long j2) {
        return g(new String[]{"rowid"}, new String[]{android.support.v4.media.b.i(j2, "")});
    }

    public abstract AbstractDataObject d(Cursor cursor);

    public final ArrayList e(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f48355a.query(j(), h(), i(strArr, strArr2), null, null, null, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    while (!cursorQuery.isAfterLast()) {
                        AbstractDataObject abstractDataObjectD = d(cursorQuery);
                        if (abstractDataObjectD == null) {
                            throw new IllegalArgumentException("cursor contains invalid object!");
                        }
                        arrayList.add(abstractDataObjectD);
                        cursorQuery.moveToNext();
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                arrayList.clear();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    public final void f() {
        try {
            this.f48355a.delete(j(), i(null, null), null);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.amazon.identity.auth.device.dataobject.AbstractDataObject g(java.lang.String[] r11, java.lang.String[] r12) throws java.lang.Throwable {
        /*
            r10 = this;
            r1 = 0
            java.lang.String r5 = i(r11, r12)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            android.database.sqlite.SQLiteDatabase r2 = r10.f48355a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.String r3 = r10.j()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.String[] r4 = r10.h()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r11 == 0) goto L28
            r11.moveToFirst()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            com.amazon.identity.auth.device.dataobject.AbstractDataObject r1 = r10.d(r11)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            goto L28
        L21:
            r0 = move-exception
            r12 = r0
            r1 = r11
            goto L3b
        L25:
            r0 = move-exception
            r12 = r0
            goto L32
        L28:
            if (r11 == 0) goto L2b
            goto L37
        L2b:
            return r1
        L2c:
            r0 = move-exception
            r12 = r0
            goto L3b
        L2f:
            r0 = move-exception
            r12 = r0
            r11 = r1
        L32:
            r12.getMessage()     // Catch: java.lang.Throwable -> L21
            if (r11 == 0) goto L3a
        L37:
            r11.close()
        L3a:
            return r1
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f.c.g(java.lang.String[], java.lang.String[]):com.amazon.identity.auth.device.dataobject.AbstractDataObject");
    }

    public abstract String[] h();

    public abstract String j();
}
