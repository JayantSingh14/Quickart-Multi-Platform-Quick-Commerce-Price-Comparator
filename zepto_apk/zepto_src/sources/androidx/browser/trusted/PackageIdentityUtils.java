package androidx.browser.trusted;

import android.content.pm.PackageManager;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
class PackageIdentityUtils {

    @RequiresApi
    public static class Api28Implementation implements SignaturesCompat {
        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public final boolean a(PackageManager packageManager, String str) {
            throw null;
        }
    }

    public static class Pre28Implementation implements SignaturesCompat {
        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public final boolean a(PackageManager packageManager, String str) {
            throw null;
        }
    }

    public interface SignaturesCompat {
        boolean a(PackageManager packageManager, String str);
    }
}
