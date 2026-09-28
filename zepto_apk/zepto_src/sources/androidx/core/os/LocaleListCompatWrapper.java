package androidx.core.os;

import androidx.annotation.RequiresApi;
import java.util.Locale;

/* loaded from: classes3.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {

    @RequiresApi
    public static class Api21Impl {
    }

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        LocaleListCompat localeListCompat = LocaleListCompat.f2881b;
        String[] strArrSplit = "en-Latn".split("-", -1);
        if (strArrSplit.length > 2) {
            new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        } else if (strArrSplit.length > 1) {
            new Locale(strArrSplit[0], strArrSplit[1]);
        } else {
            if (strArrSplit.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
            }
            new Locale(strArrSplit[0]);
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public final Object a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        ((LocaleListCompatWrapper) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
