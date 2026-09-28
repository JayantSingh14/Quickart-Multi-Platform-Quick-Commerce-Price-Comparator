package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

@RequiresApi
/* loaded from: classes3.dex */
final class LocaleOverlayHelper {
    public static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.c()) {
            return LocaleListCompat.f2881b;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < localeListCompat2.d() + localeListCompat.d()) {
            Locale localeB = i2 < localeListCompat.d() ? localeListCompat.b(i2) : localeListCompat2.b(i2 - localeListCompat.d());
            if (localeB != null) {
                linkedHashSet.add(localeB);
            }
            i2++;
        }
        return LocaleListCompat.f(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()])));
    }
}
