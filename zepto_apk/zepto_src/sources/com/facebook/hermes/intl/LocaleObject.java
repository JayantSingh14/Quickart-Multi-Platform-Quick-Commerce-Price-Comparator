package com.facebook.hermes.intl;

import android.icu.util.ULocale;

/* loaded from: classes3.dex */
public class LocaleObject {
    public static LocaleObjectICU a(String str) throws JSRangeErrorException {
        LocaleObjectICU localeObjectICU = new LocaleObjectICU();
        localeObjectICU.f17617a = null;
        localeObjectICU.f17618b = null;
        localeObjectICU.f17619c = false;
        ULocale.Builder builder = new ULocale.Builder();
        localeObjectICU.f17618b = builder;
        try {
            builder.setLanguageTag(str);
            localeObjectICU.f17619c = true;
            return localeObjectICU;
        } catch (RuntimeException e2) {
            throw new JSRangeErrorException(e2.getMessage());
        }
    }
}
