package com.google.android.play.core.splitinstall.internal;

import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzu {

    /* renamed from: a, reason: collision with root package name */
    public final String f41998a;

    public zzu(String str) {
        this.f41998a = b.e(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
    }

    public static String f(String str, String str2, Object... objArr) {
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
            Log.d("PlayCore", f(this.f41998a, str, objArr));
        }
    }

    public final void b(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", f(this.f41998a, str, objArr));
        }
    }

    public final void c(RemoteException remoteException, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", f(this.f41998a, str, objArr), remoteException);
        }
    }

    public final void d(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            Log.i("PlayCore", f(this.f41998a, str, objArr));
        }
    }

    public final void e(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            Log.w("PlayCore", f(this.f41998a, str, objArr));
        }
    }
}
