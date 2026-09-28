package f;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a<T extends AbstractDataObject> extends g {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f48351d = 0;

    /* renamed from: c, reason: collision with root package name */
    public final String f48352c;

    public a(Context context, String str) {
        super(context);
        this.f48352c = str;
    }

    public final void a(c cVar) {
        Object obj;
        c cVar2 = cVar;
        String str = this.f48352c;
        String strConcat = str.concat("encryptVersion");
        Context context = this.f48362a;
        Object obj2 = null;
        String string = context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getString(strConcat, null);
        if ("AES_00".equals(string)) {
            return;
        }
        if (string != null && !g.f48361b.contains(string)) {
            context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putString(str.concat("encryptVersion"), "AES_00").commit();
            return;
        }
        try {
            ArrayList arrayListE = cVar2.e(null, null);
            ContentValues[] contentValuesArr = new ContentValues[arrayListE.size()];
            for (int i2 = 0; i2 < arrayListE.size(); i2++) {
                contentValuesArr[i2] = ((AbstractDataObject) arrayListE.get(i2)).d(context);
            }
            int i3 = 0;
            boolean z = true;
            while (i3 < arrayListE.size()) {
                long j2 = ((AbstractDataObject) arrayListE.get(i3)).f15203a;
                ContentValues contentValues = contentValuesArr[i3];
                if (contentValues == null) {
                    obj = obj2;
                } else {
                    SQLiteDatabase sQLiteDatabase = cVar2.f48355a;
                    String strJ = cVar2.j();
                    StringBuilder sb = new StringBuilder("rowid = ");
                    sb.append(j2);
                    obj = null;
                    boolean z2 = sQLiteDatabase.update(strJ, contentValues, sb.toString(), null) == 1;
                    z &= z2;
                    i3++;
                    obj2 = obj;
                    cVar2 = cVar;
                }
                z &= z2;
                i3++;
                obj2 = obj;
                cVar2 = cVar;
            }
            if (z) {
                context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putString(str + "encryptVersion", "AES_00").commit();
            }
        } catch (l unused) {
        }
    }
}
