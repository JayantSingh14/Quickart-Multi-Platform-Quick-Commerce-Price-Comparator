package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class LocaleMatcher {

    public static class LocaleMatchResult {

        /* renamed from: a, reason: collision with root package name */
        public LocaleObjectICU f17612a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f17613b = new HashMap();
    }

    public static String a(String str, String[] strArr) {
        while (Arrays.asList(strArr).indexOf(str) <= -1) {
            int iLastIndexOf = str.lastIndexOf("-");
            if (iLastIndexOf < 0) {
                return "";
            }
            if (iLastIndexOf >= 2 && str.charAt(iLastIndexOf - 2) == '-') {
                iLastIndexOf -= 2;
            }
            str = str.substring(0, iLastIndexOf);
        }
        return str;
    }

    public static LocaleMatchResult b(String[] strArr) throws JSRangeErrorException {
        LocaleMatchResult localeMatchResult = new LocaleMatchResult();
        for (String str : strArr) {
            LocaleObjectICU localeObjectICUA = LocaleObject.a(str);
            ULocale[] availableLocales = ULocale.getAvailableLocales();
            localeObjectICUA.e();
            ULocale.Builder builder = new ULocale.Builder();
            builder.setLocale(localeObjectICUA.f17617a);
            builder.clearExtensions();
            boolean[] zArr = new boolean[1];
            ULocale uLocaleAcceptLanguage = ULocale.acceptLanguage(new ULocale[]{builder.build()}, availableLocales, zArr);
            if (zArr[0] || uLocaleAcceptLanguage == null) {
                uLocaleAcceptLanguage = null;
            }
            if (uLocaleAcceptLanguage != null) {
                localeMatchResult.f17612a = new LocaleObjectICU(uLocaleAcceptLanguage);
                localeMatchResult.f17613b = localeObjectICUA.mo57a();
                return localeMatchResult;
            }
        }
        localeMatchResult.f17612a = new LocaleObjectICU(ULocale.getDefault(ULocale.Category.FORMAT));
        return localeMatchResult;
    }

    public static String[] c(String[] strArr) throws JSRangeErrorException {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            LocaleObjectICU localeObjectICUA = LocaleObject.a(str);
            ULocale[] availableLocales = ULocale.getAvailableLocales();
            localeObjectICUA.e();
            ULocale.Builder builder = new ULocale.Builder();
            builder.setLocale(localeObjectICUA.f17617a);
            builder.clearExtensions();
            ULocale[] uLocaleArr = {builder.build()};
            boolean[] zArr = new boolean[1];
            ULocale uLocaleAcceptLanguage = ULocale.acceptLanguage(uLocaleArr, availableLocales, zArr);
            if (zArr[0] || uLocaleAcceptLanguage == null) {
                uLocaleAcceptLanguage = null;
            }
            if (uLocaleAcceptLanguage != null) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] d() {
        ArrayList arrayList = new ArrayList();
        for (Locale locale : Locale.getAvailableLocales()) {
            arrayList.add(locale.toLanguageTag());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] e(String[] strArr) throws JSRangeErrorException {
        ArrayList arrayList = new ArrayList();
        String[] strArrD = d();
        for (String str : strArr) {
            LocaleObjectICU localeObjectICUA = LocaleObject.a(str);
            localeObjectICUA.e();
            ULocale.Builder builder = new ULocale.Builder();
            builder.setLocale(localeObjectICUA.f17617a);
            builder.clearExtensions();
            String strA = a(builder.build().toLanguageTag(), strArrD);
            if (strA != null && !strA.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
