package com.google.android.play.core.review.internal;

import android.os.Process;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzi {

    /* renamed from: a, reason: collision with root package name */
    public final String f41857a;

    public zzi(String str) {
        this.f41857a = b.e(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
    }

    public static String b(String str, String str2, Object... objArr) {
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
        if (Log.isLoggable("PlayCore", 4)) {
            Log.i("PlayCore", b(this.f41857a, str, objArr));
        }
    }
}
