package com.facebook.hermes.intl;

import android.icu.text.NumberingSystem;
import android.icu.util.Calendar;
import android.icu.util.ULocale;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class UnicodeExtensionKeys {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f17661a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f17662b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f17663c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f17664d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map f17665e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map f17666f = null;

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$1, reason: invalid class name */
    public class AnonymousClass1 extends HashMap<String, String> {
    }

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$2, reason: invalid class name */
    public class AnonymousClass2 extends HashMap<String, String> {
    }

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$3, reason: invalid class name */
    public class AnonymousClass3 extends HashMap<String, String> {
    }

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$4, reason: invalid class name */
    public class AnonymousClass4 extends HashMap<String, String> {
    }

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$5, reason: invalid class name */
    public class AnonymousClass5 extends HashMap<String, String> {
    }

    /* renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$6, reason: invalid class name */
    public class AnonymousClass6 extends HashMap<String, String[]> {
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.put("ca", "calendar");
        anonymousClass1.put("nu", "numbers");
        anonymousClass1.put("hc", "hours");
        anonymousClass1.put("co", "collation");
        anonymousClass1.put("kn", "colnumeric");
        anonymousClass1.put("kf", "colcasefirst");
        f17661a = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        anonymousClass2.put("calendar", "ca");
        anonymousClass2.put("numbers", "nu");
        anonymousClass2.put("hours", "hc");
        anonymousClass2.put("collation", "co");
        anonymousClass2.put("colnumeric", "kn");
        anonymousClass2.put("colcasefirst", "kf");
        f17662b = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        anonymousClass3.put("dictionary", "dict");
        anonymousClass3.put("phonebook", "phonebk");
        anonymousClass3.put("traditional", "trad");
        anonymousClass3.put("gb2312han", "gb2312");
        f17663c = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        anonymousClass4.put("gregorian", "gregory");
        f17664d = anonymousClass4;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        anonymousClass5.put("traditional", "traditio");
        f17665e = anonymousClass5;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6();
        anonymousClass6.put("nu", new String[]{"adlm", "ahom", "arab", "arabext", "bali", "beng", "bhks", "brah", "cakm", "cham", "deva", "diak", "fullwide", "gong", "gonm", "gujr", "guru", "hanidec", "hmng", "hmnp", "java", "kali", "khmr", "knda", "lana", "lanatham", "laoo", "latn", "lepc", "limb", "mathbold", "mathdbl", "mathmono", "mathsanb", "mathsans", "mlym", "modi", "mong", "mroo", "mtei", "mymr", "mymrshan", "mymrtlng", "newa", "nkoo", "olck", "orya", "osma", "rohg", "saur", "segment", "shrd", "sind", "sinh", "sora", "sund", "takr", "talu", "tamldec", "telu", "thai", "tibt", "tirh", "vaii", "wara", "wcho"});
        anonymousClass6.put("co", new String[]{"big5han", "compat", "dict", "direct", "ducet", "emoji", "eor", "gb2312", "phonebk", "phonetic", "pinyin", "reformed", "searchjl", "stroke", "trad", "unihan", "zhuyin"});
        anonymousClass6.put("ca", new String[]{"buddhist", "chinese", "coptic", "dangi", "ethioaa", "ethiopic", "gregory", "hebrew", "indian", "islamic", "islamic-umalqura", "islamic-tbla", "islamic-civil", "islamic-rgsa", "iso8601", "japanese", "persian", "roc"});
    }

    public static boolean a(String str, String str2, LocaleObjectICU localeObjectICU) throws JSRangeErrorException {
        localeObjectICU.e();
        ULocale uLocale = localeObjectICU.f17617a;
        String[] availableNames = new String[0];
        if (str.equals("co")) {
            if (str2.equals("standard") || str2.equals("search")) {
                return false;
            }
            availableNames = android.icu.text.Collator.getKeywordValuesForLocale("co", uLocale, false);
        } else if (str.equals("ca")) {
            availableNames = Calendar.getKeywordValuesForLocale("ca", uLocale, false);
        } else if (str.equals("nu")) {
            availableNames = NumberingSystem.getAvailableNames();
        }
        if (availableNames.length == 0) {
            return true;
        }
        return Arrays.asList(availableNames).contains(str2);
    }

    public static String b(String str) {
        Map map = f17663c;
        return !((HashMap) map).containsKey(str) ? str : (String) ((HashMap) map).get(str);
    }

    public static Object c(Object obj, String str) {
        if (str.equals("ca") && (obj instanceof String)) {
            String str2 = (String) obj;
            HashMap map = (HashMap) f17664d;
            return !map.containsKey(str2) ? str2 : (String) map.get(str2);
        }
        if (!str.equals("nu") || !(obj instanceof String)) {
            return (str.equals("co") && (obj instanceof String)) ? b((String) obj) : (str.equals("kn") && (obj instanceof String) && obj.equals("yes")) ? "true" : ((str.equals("kn") || str.equals("kf")) && (obj instanceof String) && obj.equals("no")) ? "false" : obj;
        }
        String str3 = (String) obj;
        HashMap map2 = (HashMap) f17665e;
        return !map2.containsKey(str3) ? str3 : (String) map2.get(str3);
    }
}
