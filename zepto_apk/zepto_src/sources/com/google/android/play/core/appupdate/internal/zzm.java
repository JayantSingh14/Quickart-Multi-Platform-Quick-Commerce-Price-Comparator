package com.google.android.play.core.appupdate.internal;

import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzm {

    /* renamed from: a, reason: collision with root package name */
    public final String f41687a;

    public zzm(String str) {
        this.f41687a = b.e(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
    }

    public static String d(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e2) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e2);
                str2 = e.D(str2, " [", TextUtils.join(", ", objArr), "]");
            }
        }
        return b.l(str, " : ", str2);
    }

    public final void a(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            Log.d("PlayCore", d(this.f41687a, str, objArr));
        }
    }

    public final void b(RemoteException remoteException, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", d(this.f41687a, str, objArr), remoteException);
        }
    }

    public final void c(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            Log.i("PlayCore", d(this.f41687a, str, objArr));
        }
    }
}
