package com.facebook.hermes.intl;

import android.icu.lang.UCharacter;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DoNotStrip
/* loaded from: classes3.dex */
public class Intl {
    @DoNotStrip
    public static List<String> getCanonicalLocales(List<String> list) throws JSRangeErrorException {
        if (list.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str == null) {
                throw new JSRangeErrorException("Incorrect locale information provided");
            }
            if (str.isEmpty()) {
                throw new JSRangeErrorException("Incorrect locale information provided");
            }
            String strD = LocaleObject.a(str).d();
            if (!strD.isEmpty() && !arrayList.contains(strD)) {
                arrayList.add(strD);
            }
        }
        return arrayList;
    }

    @DoNotStrip
    public static String toLocaleLowerCase(List<String> list, String str) throws JSRangeErrorException {
        LocaleObjectICU localeObjectICU = LocaleMatcher.b((String[]) list.toArray(new String[list.size()])).f17612a;
        localeObjectICU.e();
        return UCharacter.toLowerCase(localeObjectICU.f17617a, str);
    }

    @DoNotStrip
    public static String toLocaleUpperCase(List<String> list, String str) throws JSRangeErrorException {
        LocaleObjectICU localeObjectICU = LocaleMatcher.b((String[]) list.toArray(new String[list.size()])).f17612a;
        localeObjectICU.e();
        return UCharacter.toUpperCase(localeObjectICU.f17617a, str);
    }
}
