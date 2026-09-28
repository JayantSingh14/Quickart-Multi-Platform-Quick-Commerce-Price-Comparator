package f;

import android.database.Cursor;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class d extends c<AppInfo> {

    /* renamed from: b, reason: collision with root package name */
    public static d f48356b;

    @Override // f.c
    public final AbstractDataObject d(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }
        try {
            AppInfo appInfo = new AppInfo();
            appInfo.f15203a = cursor.getLong(a(cursor, 0));
            appInfo.f15205b = cursor.getString(a(cursor, 1));
            appInfo.f15206c = cursor.getString(a(cursor, 6));
            appInfo.f15207d = cursor.getString(a(cursor, 2));
            String string = cursor.getString(a(cursor, 3));
            appInfo.f15211h = (string == null || string.trim().length() <= 0) ? null : string.trim().split("[,]");
            String string2 = cursor.getString(a(cursor, 4));
            appInfo.f15212i = (string2 == null || string2.trim().length() <= 0) ? null : string2.trim().split("[,]");
            appInfo.f15208e = cursor.getString(a(cursor, 5));
            appInfo.f15209f = cursor.getString(a(cursor, 7));
            appInfo.f15210g = cursor.getString(a(cursor, 8));
            try {
                appInfo.f15213j = new JSONObject(cursor.getString(a(cursor, 9)));
            } catch (JSONException unused) {
            }
            return appInfo;
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // f.c
    public final String[] h() {
        return AppInfo.f15204k;
    }

    @Override // f.c
    public final String j() {
        return "AppInfo";
    }
}
