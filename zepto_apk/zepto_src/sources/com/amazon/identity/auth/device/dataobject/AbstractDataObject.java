package com.amazon.identity.auth.device.dataobject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.media.b;
import f.c;
import f.e;
import f.l;
import java.io.Serializable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public abstract class AbstractDataObject {

    /* renamed from: a, reason: collision with root package name */
    public long f15203a = -1;

    public static boolean b(Serializable serializable, Serializable serializable2) {
        if (serializable == null || serializable2 == null) {
            return false;
        }
        return serializable.equals(serializable2);
    }

    public final void a(Context context) {
        if (e.k(context).f48355a.delete("AuthorizationToken", b.i(this.f15203a, "rowid = "), null) == 1) {
            this.f15203a = -1L;
        }
    }

    public abstract c c(Context context);

    public abstract ContentValues d(Context context);

    public final boolean e(Context context) {
        try {
            c cVarC = c(context);
            long j2 = this.f15203a;
            ContentValues contentValuesD = d(context);
            SQLiteDatabase sQLiteDatabase = cVarC.f48355a;
            String strJ = cVarC.j();
            StringBuilder sb = new StringBuilder("rowid = ");
            sb.append(j2);
            return sQLiteDatabase.update(strJ, contentValuesD, sb.toString(), null) == 1;
        } catch (l unused) {
            return false;
        }
    }

    public String toString() {
        try {
            return "rowid = " + this.f15203a + CLConstants.SALT_DELIMETER + d(null).toString();
        } catch (l unused) {
            return b.p(new StringBuilder("rowid = "), this.f15203a, " | toString failed");
        }
    }
}
