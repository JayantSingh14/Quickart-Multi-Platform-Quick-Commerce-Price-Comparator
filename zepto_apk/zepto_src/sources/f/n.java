package f;

import android.database.Cursor;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import com.amazon.identity.auth.device.dataobject.RequestedScope;

/* loaded from: classes4.dex */
public final class n extends c<RequestedScope> {

    /* renamed from: b, reason: collision with root package name */
    public static n f48367b;

    @Override // f.c
    public final AbstractDataObject d(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }
        try {
            RequestedScope requestedScope = new RequestedScope();
            requestedScope.f15203a = cursor.getLong(a(cursor, 0));
            requestedScope.f15227b = cursor.getString(a(cursor, 1));
            requestedScope.f15228c = cursor.getString(a(cursor, 2));
            requestedScope.f15229d = cursor.getString(a(cursor, 3));
            requestedScope.f15230e = cursor.getLong(a(cursor, 4));
            requestedScope.f15231f = cursor.getLong(a(cursor, 5));
            return requestedScope;
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // f.c
    public final String[] h() {
        return RequestedScope.f15226g;
    }

    @Override // f.c
    public final String j() {
        return "RequestedScope";
    }
}
