package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocaleListCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final LocaleListCompat f2881b = f(new LocaleList(new Locale[0]));

    /* renamed from: a, reason: collision with root package name */
    public final LocaleListPlatformWrapper f2882a;

    @RequiresApi
    public static class Api21Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f2883a = 0;

        static {
            new Locale("en", "XA");
            new Locale("ar", "XB");
        }
    }

    @RequiresApi
    public static class Api24Impl {
    }

    public LocaleListCompat(LocaleListPlatformWrapper localeListPlatformWrapper) {
        this.f2882a = localeListPlatformWrapper;
    }

    public static LocaleListCompat a(String str) {
        if (str == null || str.isEmpty()) {
            return f2881b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = strArrSplit[i2];
            int i3 = Api21Impl.f2883a;
            localeArr[i2] = Locale.forLanguageTag(str2);
        }
        return f(new LocaleList(localeArr));
    }

    public static LocaleListCompat f(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public final Locale b(int i2) {
        return this.f2882a.f2884a.get(i2);
    }

    public final boolean c() {
        return this.f2882a.f2884a.isEmpty();
    }

    public final int d() {
        return this.f2882a.f2884a.size();
    }

    public final String e() {
        return this.f2882a.f2884a.toLanguageTags();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocaleListCompat) {
            return this.f2882a.equals(((LocaleListCompat) obj).f2882a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2882a.f2884a.hashCode();
    }

    public final String toString() {
        return this.f2882a.f2884a.toString();
    }
}
