package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes3.dex */
public final class InputConnectionCompat {

    @RequiresApi
    public static class Api25Impl {
    }

    public interface OnCommitContentListener {
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[PHI: r3
      0x001b: PHI (r3v9 java.lang.String[]) = (r3v4 java.lang.String[]), (r3v10 java.lang.String[]) binds: [B:17:0x0032, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.inputmethod.InputConnection a(androidx.appcompat.widget.AppCompatEditText r3, android.view.inputmethod.InputConnection r4, android.view.inputmethod.EditorInfo r5) {
        /*
            androidx.core.view.inputmethod.b r0 = new androidx.core.view.inputmethod.b
            r0.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r1 = 25
            if (r3 < r1) goto L11
            androidx.core.view.inputmethod.InputConnectionCompat$1 r3 = new androidx.core.view.inputmethod.InputConnectionCompat$1
            r3.<init>(r4)
            return r3
        L11:
            java.lang.String[] r2 = androidx.core.view.inputmethod.EditorInfoCompat.f3217a
            if (r3 < r1) goto L1d
            java.lang.String[] r3 = androidx.core.view.inputmethod.a.q(r5)
            if (r3 == 0) goto L35
        L1b:
            r2 = r3
            goto L35
        L1d:
            android.os.Bundle r3 = r5.extras
            if (r3 != 0) goto L22
            goto L35
        L22:
            java.lang.String r1 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r3 = r3.getStringArray(r1)
            if (r3 != 0) goto L32
            android.os.Bundle r3 = r5.extras
            java.lang.String r5 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r3 = r3.getStringArray(r5)
        L32:
            if (r3 == 0) goto L35
            goto L1b
        L35:
            int r3 = r2.length
            if (r3 != 0) goto L39
            return r4
        L39:
            androidx.core.view.inputmethod.InputConnectionCompat$2 r3 = new androidx.core.view.inputmethod.InputConnectionCompat$2
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat.a(androidx.appcompat.widget.AppCompatEditText, android.view.inputmethod.InputConnection, android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }
}
