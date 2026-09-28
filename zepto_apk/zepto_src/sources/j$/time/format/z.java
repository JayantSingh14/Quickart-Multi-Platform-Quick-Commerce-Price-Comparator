package j$.time.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f53375a = new ConcurrentHashMap(16, 0.75f, 2);

    /* renamed from: b, reason: collision with root package name */
    public static final x f53376b = new x();

    /* renamed from: c, reason: collision with root package name */
    public static final z f53377c = new z();

    public String c(j$.time.temporal.n nVar, long j2, E e2, Locale locale) {
        Object objA = a(nVar, locale);
        if (objA instanceof y) {
            return ((y) objA).a(j2, e2);
        }
        return null;
    }

    public String b(j$.time.chrono.k kVar, j$.time.temporal.n nVar, long j2, E e2, Locale locale) {
        if (kVar == j$.time.chrono.r.f53253c || !(nVar instanceof j$.time.temporal.a)) {
            return c(nVar, j2, e2, locale);
        }
        return null;
    }

    public Iterator e(j$.time.temporal.n nVar, E e2, Locale locale) {
        List list;
        Object objA = a(nVar, locale);
        if (!(objA instanceof y) || (list = (List) ((y) objA).f53374b.get(e2)) == null) {
            return null;
        }
        return list.iterator();
    }

    public Iterator d(j$.time.chrono.k kVar, j$.time.temporal.n nVar, E e2, Locale locale) {
        if (kVar == j$.time.chrono.r.f53253c || !(nVar instanceof j$.time.temporal.a)) {
            return e(nVar, e2, locale);
        }
        return null;
    }

    public static Object a(j$.time.temporal.n nVar, Locale locale) {
        Object yVar;
        long j2;
        String strSubstring;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(nVar, locale);
        ConcurrentHashMap concurrentHashMap = f53375a;
        Object obj = concurrentHashMap.get(simpleImmutableEntry);
        if (obj != null) {
            return obj;
        }
        HashMap map = new HashMap();
        if (nVar == j$.time.temporal.a.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            for (int i2 = 0; i2 < eras.length; i2++) {
                if (!eras[i2].isEmpty()) {
                    long j3 = i2;
                    map2.put(Long.valueOf(j3), eras[i2]);
                    Long lValueOf = Long.valueOf(j3);
                    String str = eras[i2];
                    map3.put(lValueOf, str.substring(0, Character.charCount(str.codePointAt(0))));
                }
            }
            if (!map2.isEmpty()) {
                map.put(E.FULL, map2);
                map.put(E.SHORT, map2);
                map.put(E.NARROW, map3);
            }
            yVar = new y(map);
        } else {
            long j4 = 1;
            if (nVar == j$.time.temporal.a.MONTH_OF_YEAR) {
                int length = DateFormatSymbols.getInstance(locale).getMonths().length;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (long j5 = 1; j5 <= length; j5++) {
                    String strB = j$.time.d.b(j5, "LLLL", locale);
                    linkedHashMap.put(Long.valueOf(j5), strB);
                    linkedHashMap2.put(Long.valueOf(j5), strB.substring(0, Character.charCount(strB.codePointAt(0))));
                    linkedHashMap3.put(Long.valueOf(j5), j$.time.d.b(j5, "LLL", locale));
                }
                if (length > 0) {
                    map.put(E.FULL_STANDALONE, linkedHashMap);
                    map.put(E.NARROW_STANDALONE, linkedHashMap2);
                    map.put(E.SHORT_STANDALONE, linkedHashMap3);
                    map.put(E.FULL, linkedHashMap);
                    map.put(E.NARROW, linkedHashMap2);
                    map.put(E.SHORT, linkedHashMap3);
                }
                yVar = new y(map);
            } else if (nVar == j$.time.temporal.a.DAY_OF_WEEK) {
                int length2 = DateFormatSymbols.getInstance(locale).getWeekdays().length;
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                boolean z = locale == Locale.SIMPLIFIED_CHINESE || locale == Locale.TRADITIONAL_CHINESE;
                long j6 = 1;
                while (j6 <= length2) {
                    String strA = j$.time.d.a(j6, "cccc", locale);
                    linkedHashMap4.put(Long.valueOf(j6), strA);
                    Long lValueOf2 = Long.valueOf(j6);
                    if (!z) {
                        j2 = j4;
                        strSubstring = strA.substring(0, Character.charCount(strA.codePointAt(0)));
                    } else {
                        j2 = j4;
                        strSubstring = new StringBuilder().appendCodePoint(strA.codePointBefore(strA.length())).toString();
                    }
                    linkedHashMap5.put(lValueOf2, strSubstring);
                    linkedHashMap6.put(Long.valueOf(j6), j$.time.d.a(j6, "ccc", locale));
                    j6 += j2;
                    j4 = j2;
                }
                if (length2 > 0) {
                    map.put(E.FULL_STANDALONE, linkedHashMap4);
                    map.put(E.NARROW_STANDALONE, linkedHashMap5);
                    map.put(E.SHORT_STANDALONE, linkedHashMap6);
                    map.put(E.FULL, linkedHashMap4);
                    map.put(E.NARROW, linkedHashMap5);
                    map.put(E.SHORT, linkedHashMap6);
                }
                yVar = new y(map);
            } else if (nVar == j$.time.temporal.a.AMPM_OF_DAY) {
                DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
                HashMap map4 = new HashMap();
                HashMap map5 = new HashMap();
                String[] amPmStrings = dateFormatSymbols2.getAmPmStrings();
                for (int i3 = 0; i3 < amPmStrings.length; i3++) {
                    if (!amPmStrings[i3].isEmpty()) {
                        long j7 = i3;
                        map4.put(Long.valueOf(j7), amPmStrings[i3]);
                        Long lValueOf3 = Long.valueOf(j7);
                        String str2 = amPmStrings[i3];
                        map5.put(lValueOf3, str2.substring(0, Character.charCount(str2.codePointAt(0))));
                    }
                }
                if (!map4.isEmpty()) {
                    map.put(E.FULL, map4);
                    map.put(E.SHORT, map4);
                    map.put(E.NARROW, map5);
                }
                yVar = new y(map);
            } else {
                yVar = "";
            }
        }
        concurrentHashMap.putIfAbsent(simpleImmutableEntry, yVar);
        return concurrentHashMap.get(simpleImmutableEntry);
    }
}
