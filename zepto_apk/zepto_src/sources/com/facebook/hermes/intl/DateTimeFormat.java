package com.facebook.hermes.intl;

import android.icu.text.DateFormat;
import android.icu.text.NumberingSystem;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.ULocale;
import com.facebook.hermes.intl.IPlatformDateTimeFormatter;
import com.facebook.hermes.intl.JSObjects;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.proguard.annotations.DoNotStrip;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@DoNotStrip
/* loaded from: classes3.dex */
public class DateTimeFormat {

    /* renamed from: a, reason: collision with root package name */
    public final PlatformDateTimeFormatterICU f17505a;

    /* renamed from: b, reason: collision with root package name */
    public final ILocaleObject f17506b;

    /* renamed from: c, reason: collision with root package name */
    public final ILocaleObject f17507c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17508d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17509e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f17510f;

    /* renamed from: g, reason: collision with root package name */
    public final String f17511g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f17512h;

    /* renamed from: i, reason: collision with root package name */
    public final IPlatformDateTimeFormatter.HourCycle f17513i;

    /* renamed from: j, reason: collision with root package name */
    public final IPlatformDateTimeFormatter.WeekDay f17514j;

    /* renamed from: k, reason: collision with root package name */
    public final IPlatformDateTimeFormatter.Era f17515k;

    /* renamed from: l, reason: collision with root package name */
    public final IPlatformDateTimeFormatter.Year f17516l;

    /* renamed from: m, reason: collision with root package name */
    public final IPlatformDateTimeFormatter.Month f17517m;
    public final IPlatformDateTimeFormatter.Day n;
    public final IPlatformDateTimeFormatter.Hour o;
    public final IPlatformDateTimeFormatter.Minute p;
    public final IPlatformDateTimeFormatter.Second q;
    public final IPlatformDateTimeFormatter.TimeZoneName r;
    public final IPlatformDateTimeFormatter.DateStyle s;
    public final IPlatformDateTimeFormatter.TimeStyle t;
    public final String u;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.hermes.intl.DateTimeFormat, java.lang.Object] */
    @DoNotStrip
    public DateTimeFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String id;
        DateTimeFormat dateTimeFormat;
        String string;
        Calendar calendar;
        ILocaleObject iLocaleObject;
        PlatformDateTimeFormatterICU platformDateTimeFormatterICU;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        ?? obj = new Object();
        obj.f17506b = null;
        obj.f17507c = null;
        obj.u = null;
        PlatformDateTimeFormatterICU platformDateTimeFormatterICU2 = new PlatformDateTimeFormatterICU();
        platformDateTimeFormatterICU2.f17651a = null;
        obj.f17505a = platformDateTimeFormatterICU2;
        String str17 = "ca";
        String str18 = "nu";
        List listAsList = Arrays.asList("ca", "nu", "hc");
        if (!(map instanceof HashMap)) {
            throw new JSRangeErrorException("Invalid options object !");
        }
        String[] strArr = {"weekday", "year", "month", "day"};
        boolean z = true;
        for (int i2 = 0; i2 < 4; i2++) {
            if (!(JSObjects.a(strArr[i2], map) instanceof JSObjects.UndefinedObject)) {
                z = false;
            }
        }
        String[] strArr2 = {"hour", "minute", "second"};
        for (int i3 = 0; i3 < 3; i3++) {
            if (!(JSObjects.a(strArr2[i3], map) instanceof JSObjects.UndefinedObject)) {
                z = false;
            }
        }
        if (((JSObjects.a("dateStyle", map) instanceof JSObjects.UndefinedObject) && (JSObjects.a("timeStyle", map) instanceof JSObjects.UndefinedObject)) ? z : false) {
            String[] strArr3 = {"year", "month", "day"};
            str = "timeStyle";
            str2 = "dateStyle";
            for (int i4 = 0; i4 < 3; i4++) {
                ((HashMap) map).put(strArr3[i4], "numeric");
            }
        } else {
            str = "timeStyle";
            str2 = "dateStyle";
        }
        HashMap map2 = new HashMap();
        OptionHelpers.OptionType optionType = OptionHelpers.OptionType.f17634b;
        map2.put("localeMatcher", OptionHelpers.b(map, "localeMatcher", optionType, Constants.f17501a, "best fit"));
        Object obj2 = JSObjects.f17604a;
        Object objB = OptionHelpers.b(map, "calendar", optionType, obj2, obj2);
        if (objB instanceof JSObjects.UndefinedObject) {
            str3 = "weekday";
            str4 = "year";
            str5 = "month";
            str6 = "numeric";
        } else {
            str5 = "month";
            str3 = "weekday";
            str4 = "year";
            str6 = "numeric";
            if (!IntlTextUtils.c(0, r12.length() - 1, (String) objB, 3, 8)) {
                throw new JSRangeErrorException("Invalid calendar option !");
            }
        }
        map2.put("ca", objB);
        Object objB2 = OptionHelpers.b(map, "numberingSystem", optionType, obj2, obj2);
        if (!(objB2 instanceof JSObjects.UndefinedObject)) {
            if (!IntlTextUtils.c(0, r10.length() - 1, (String) objB2, 3, 8)) {
                throw new JSRangeErrorException("Invalid numbering system !");
            }
        }
        map2.put("nu", objB2);
        Object objB3 = OptionHelpers.b(map, "hour12", OptionHelpers.OptionType.f17633a, obj2, obj2);
        String str19 = "h23";
        boolean z2 = objB3 instanceof JSObjects.UndefinedObject;
        map2.put("hc", z2 ? OptionHelpers.b(map, "hourCycle", optionType, new String[]{"h11", "h12", "h23", "h24"}, obj2) : JSObjects.f17605b);
        HashMap mapA = LocaleResolver.a(list, map2, listAsList);
        ILocaleObject iLocaleObject2 = (ILocaleObject) mapA.get("locale");
        obj.f17506b = iLocaleObject2;
        obj.f17507c = iLocaleObject2.b();
        Object objA = JSObjects.a("ca", mapA);
        if (objA instanceof JSObjects.NullObject) {
            obj.f17508d = true;
            String type = DateFormat.getDateInstance(3, (ULocale) obj.f17506b.getLocale()).getCalendar().getType();
            HashMap map3 = (HashMap) UnicodeExtensionKeys.f17664d;
            obj.f17509e = map3.containsKey(type) ? (String) map3.get(type) : type;
        } else {
            obj.f17508d = false;
            obj.f17509e = (String) objA;
        }
        Object objA2 = JSObjects.a("nu", mapA);
        if (objA2 instanceof JSObjects.NullObject) {
            obj.f17510f = true;
            obj.f17511g = NumberingSystem.getInstance((ULocale) obj.f17506b.getLocale()).getName();
        } else {
            obj.f17510f = false;
            obj.f17511g = (String) objA2;
        }
        Object objA3 = JSObjects.a("hc", mapA);
        Object objA4 = JSObjects.a("timeZone", map);
        if (!(objA4 instanceof JSObjects.UndefinedObject)) {
            String string2 = objA4.toString();
            String[] availableIDs = TimeZone.getAvailableIDs();
            int length = availableIDs.length;
            int i5 = 0;
            DateTimeFormat dateTimeFormat2 = obj;
            while (i5 < length) {
                String str20 = availableIDs[i5];
                int i6 = length;
                int i7 = i5;
                if (a(str20).equals(a(string2))) {
                    id = str20;
                    dateTimeFormat = dateTimeFormat2;
                } else {
                    dateTimeFormat2 = this;
                    i5 = i7 + 1;
                    str19 = str19;
                    length = i6;
                    str3 = str3;
                    str18 = str18;
                    str17 = str17;
                    str6 = str6;
                    z2 = z2;
                }
            }
            throw new JSRangeErrorException("Invalid timezone name!");
        }
        id = Calendar.getInstance((ULocale) obj.f17506b.getLocale()).getTimeZone().getID();
        dateTimeFormat = obj;
        dateTimeFormat.u = id;
        boolean z3 = z2;
        String str21 = str18;
        dateTimeFormat.f17514j = (IPlatformDateTimeFormatter.WeekDay) OptionHelpers.c(IPlatformDateTimeFormatter.WeekDay.class, OptionHelpers.b(map, str3, optionType, new String[]{"long", "short", "narrow"}, obj2));
        dateTimeFormat.f17515k = (IPlatformDateTimeFormatter.Era) OptionHelpers.c(IPlatformDateTimeFormatter.Era.class, OptionHelpers.b(map, "era", optionType, new String[]{"long", "short", "narrow"}, obj2));
        String str22 = str6;
        String str23 = str17;
        String str24 = str19;
        dateTimeFormat.f17516l = (IPlatformDateTimeFormatter.Year) OptionHelpers.c(IPlatformDateTimeFormatter.Year.class, OptionHelpers.b(map, str4, optionType, new String[]{str22, "2-digit"}, obj2));
        dateTimeFormat.f17517m = (IPlatformDateTimeFormatter.Month) OptionHelpers.c(IPlatformDateTimeFormatter.Month.class, OptionHelpers.b(map, str5, optionType, new String[]{str22, "2-digit", "long", "short", "narrow"}, obj2));
        dateTimeFormat.n = (IPlatformDateTimeFormatter.Day) OptionHelpers.c(IPlatformDateTimeFormatter.Day.class, OptionHelpers.b(map, "day", optionType, new String[]{str22, "2-digit"}, obj2));
        Object objB4 = OptionHelpers.b(map, "hour", optionType, new String[]{str22, "2-digit"}, obj2);
        dateTimeFormat.o = (IPlatformDateTimeFormatter.Hour) OptionHelpers.c(IPlatformDateTimeFormatter.Hour.class, objB4);
        dateTimeFormat.p = (IPlatformDateTimeFormatter.Minute) OptionHelpers.c(IPlatformDateTimeFormatter.Minute.class, OptionHelpers.b(map, "minute", optionType, new String[]{str22, "2-digit"}, obj2));
        dateTimeFormat.q = (IPlatformDateTimeFormatter.Second) OptionHelpers.c(IPlatformDateTimeFormatter.Second.class, OptionHelpers.b(map, "second", optionType, new String[]{str22, "2-digit"}, obj2));
        dateTimeFormat.r = (IPlatformDateTimeFormatter.TimeZoneName) OptionHelpers.c(IPlatformDateTimeFormatter.TimeZoneName.class, OptionHelpers.b(map, "timeZoneName", optionType, new String[]{"long", "longOffset", "longGeneric", "short", "shortOffset", "shortGeneric"}, obj2));
        dateTimeFormat.s = (IPlatformDateTimeFormatter.DateStyle) OptionHelpers.c(IPlatformDateTimeFormatter.DateStyle.class, OptionHelpers.b(map, str2, optionType, new String[]{"full", "long", "medium", "short"}, obj2));
        Object objB5 = OptionHelpers.b(map, str, optionType, new String[]{"full", "long", "medium", "short"}, obj2);
        dateTimeFormat.t = (IPlatformDateTimeFormatter.TimeStyle) OptionHelpers.c(IPlatformDateTimeFormatter.TimeStyle.class, objB5);
        boolean z4 = objB4 instanceof JSObjects.UndefinedObject;
        IPlatformDateTimeFormatter.HourCycle hourCycle = IPlatformDateTimeFormatter.HourCycle.f17555c;
        IPlatformDateTimeFormatter.HourCycle hourCycle2 = IPlatformDateTimeFormatter.HourCycle.f17553a;
        IPlatformDateTimeFormatter.HourCycle hourCycle3 = IPlatformDateTimeFormatter.HourCycle.f17554b;
        IPlatformDateTimeFormatter.HourCycle hourCycle4 = IPlatformDateTimeFormatter.HourCycle.f17556d;
        if (z4 && (objB5 instanceof JSObjects.UndefinedObject)) {
            dateTimeFormat.f17513i = IPlatformDateTimeFormatter.HourCycle.f17557e;
        } else {
            try {
                String pattern = ((SimpleDateFormat) DateFormat.getTimeInstance(0, (ULocale) dateTimeFormat.f17506b.getLocale())).toPattern();
                StringBuilder sb = new StringBuilder();
                boolean z5 = false;
                for (int i8 = 0; i8 < pattern.length(); i8++) {
                    char cCharAt = pattern.charAt(i8);
                    if (cCharAt == '\'') {
                        z5 = !z5;
                    } else if (!z5 && ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z'))) {
                        sb.append(pattern.charAt(i8));
                    }
                }
                string = sb.toString();
            } catch (ClassCastException unused) {
            }
            IPlatformDateTimeFormatter.HourCycle hourCycle5 = string.contains(String.valueOf('h')) ? hourCycle3 : string.contains(String.valueOf('K')) ? hourCycle2 : string.contains(String.valueOf('H')) ? hourCycle : hourCycle4;
            dateTimeFormat.f17513i = z3 ? objA3 instanceof JSObjects.NullObject ? hourCycle5 : (IPlatformDateTimeFormatter.HourCycle) OptionHelpers.c(IPlatformDateTimeFormatter.HourCycle.class, objA3) : ((Boolean) objB3).booleanValue() ? (hourCycle5 == hourCycle2 || hourCycle5 == hourCycle) ? hourCycle2 : hourCycle3 : (hourCycle5 == hourCycle2 || hourCycle5 == hourCycle) ? hourCycle : hourCycle4;
        }
        dateTimeFormat.f17512h = objB3;
        PlatformDateTimeFormatterICU platformDateTimeFormatterICU3 = dateTimeFormat.f17505a;
        ILocaleObject iLocaleObject3 = dateTimeFormat.f17506b;
        String str25 = dateTimeFormat.f17508d ? "" : dateTimeFormat.f17509e;
        String str26 = dateTimeFormat.f17510f ? "" : dateTimeFormat.f17511g;
        IPlatformDateTimeFormatter.WeekDay weekDay = dateTimeFormat.f17514j;
        IPlatformDateTimeFormatter.Era era = dateTimeFormat.f17515k;
        IPlatformDateTimeFormatter.Year year = dateTimeFormat.f17516l;
        IPlatformDateTimeFormatter.Month month = dateTimeFormat.f17517m;
        IPlatformDateTimeFormatter.Day day = dateTimeFormat.n;
        IPlatformDateTimeFormatter.Hour hour = dateTimeFormat.o;
        IPlatformDateTimeFormatter.Minute minute = dateTimeFormat.p;
        IPlatformDateTimeFormatter.Second second = dateTimeFormat.q;
        IPlatformDateTimeFormatter.TimeZoneName timeZoneName = dateTimeFormat.r;
        IPlatformDateTimeFormatter.HourCycle hourCycle6 = dateTimeFormat.f17513i;
        String str27 = dateTimeFormat.u;
        IPlatformDateTimeFormatter.DateStyle dateStyle = dateTimeFormat.s;
        IPlatformDateTimeFormatter.TimeStyle timeStyle = dateTimeFormat.t;
        StringBuilder sb2 = new StringBuilder();
        IPlatformDateTimeFormatter.DateStyle dateStyle2 = IPlatformDateTimeFormatter.DateStyle.f17544a;
        IPlatformDateTimeFormatter.TimeStyle timeStyle2 = IPlatformDateTimeFormatter.TimeStyle.f17565a;
        if (dateStyle == dateStyle2 && timeStyle == timeStyle2) {
            int iOrdinal = weekDay.ordinal();
            if (iOrdinal == 0) {
                str7 = "EEEE";
            } else if (iOrdinal == 1) {
                str7 = "EEE";
            } else if (iOrdinal == 2) {
                str7 = "EEEEE";
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalArgumentException();
                }
                str7 = "";
            }
            sb2.append(str7);
            int iOrdinal2 = era.ordinal();
            if (iOrdinal2 == 0) {
                str8 = "GGGG";
            } else if (iOrdinal2 == 1) {
                str8 = "GGG";
            } else if (iOrdinal2 == 2) {
                str8 = "G5";
            } else {
                if (iOrdinal2 != 3) {
                    throw new IllegalArgumentException();
                }
                str8 = "";
            }
            sb2.append(str8);
            int iOrdinal3 = year.ordinal();
            if (iOrdinal3 == 0) {
                str9 = "yyyy";
            } else if (iOrdinal3 == 1) {
                str9 = "yy";
            } else {
                if (iOrdinal3 != 2) {
                    throw new IllegalArgumentException();
                }
                str9 = "";
            }
            sb2.append(str9);
            int iOrdinal4 = month.ordinal();
            if (iOrdinal4 == 0) {
                str10 = "M";
            } else if (iOrdinal4 == 1) {
                str10 = "MM";
            } else if (iOrdinal4 == 2) {
                str10 = "MMMM";
            } else if (iOrdinal4 == 3) {
                str10 = "MMM";
            } else if (iOrdinal4 == 4) {
                str10 = "MMMMM";
            } else {
                if (iOrdinal4 != 5) {
                    throw new IllegalArgumentException();
                }
                str10 = "";
            }
            sb2.append(str10);
            int iOrdinal5 = day.ordinal();
            if (iOrdinal5 == 0) {
                str11 = "d";
            } else if (iOrdinal5 == 1) {
                str11 = "dd";
            } else {
                if (iOrdinal5 != 2) {
                    throw new IllegalArgumentException();
                }
                str11 = "";
            }
            sb2.append(str11);
            if (hourCycle6 == hourCycle2 || hourCycle6 == hourCycle3) {
                int iOrdinal6 = hour.ordinal();
                if (iOrdinal6 == 0) {
                    str12 = "h";
                } else if (iOrdinal6 == 1) {
                    str12 = "hh";
                } else {
                    if (iOrdinal6 != 2) {
                        throw new IllegalArgumentException();
                    }
                    str12 = "";
                }
                sb2.append(str12);
            } else {
                int iOrdinal7 = hour.ordinal();
                if (iOrdinal7 == 0) {
                    str16 = "k";
                } else if (iOrdinal7 == 1) {
                    str16 = "kk";
                } else {
                    if (iOrdinal7 != 2) {
                        throw new IllegalArgumentException();
                    }
                    str16 = "";
                }
                sb2.append(str16);
            }
            int iOrdinal8 = minute.ordinal();
            if (iOrdinal8 == 0) {
                str13 = "m";
            } else if (iOrdinal8 == 1) {
                str13 = "mm";
            } else {
                if (iOrdinal8 != 2) {
                    throw new IllegalArgumentException();
                }
                str13 = "";
            }
            sb2.append(str13);
            int iOrdinal9 = second.ordinal();
            if (iOrdinal9 == 0) {
                str14 = "s";
            } else if (iOrdinal9 == 1) {
                str14 = "ss";
            } else {
                if (iOrdinal9 != 2) {
                    throw new IllegalArgumentException();
                }
                str14 = "";
            }
            sb2.append(str14);
            switch (timeZoneName.ordinal()) {
                case 0:
                    str15 = "zzzz";
                    break;
                case 1:
                    str15 = "OOOO";
                    break;
                case 2:
                    str15 = "vvvv";
                    break;
                case 3:
                    str15 = "z";
                    break;
                case 4:
                    str15 = "O";
                    break;
                case 5:
                    str15 = "v";
                    break;
                case 6:
                    str15 = "";
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            sb2.append(str15);
        } else {
            sb2.append(dateStyle == dateStyle2 ? ((SimpleDateFormat) DateFormat.getTimeInstance(PlatformDateTimeFormatterICU.c(timeStyle), (ULocale) iLocaleObject3.getLocale())).toLocalizedPattern() : timeStyle == timeStyle2 ? ((SimpleDateFormat) DateFormat.getDateInstance(PlatformDateTimeFormatterICU.b(dateStyle), (ULocale) iLocaleObject3.getLocale())).toLocalizedPattern() : ((SimpleDateFormat) DateFormat.getDateTimeInstance(PlatformDateTimeFormatterICU.b(dateStyle), PlatformDateTimeFormatterICU.c(timeStyle), (ULocale) iLocaleObject3.getLocale())).toLocalizedPattern());
            HashMap mapMo57a = iLocaleObject3.mo57a();
            if (mapMo57a.containsKey("hc")) {
                String str28 = (String) mapMo57a.get("hc");
                if (str28 == "h11" || str28 == "h12") {
                    PlatformDateTimeFormatterICU.a(sb2, new char[]{'H', 'K', 'k'}, 'h');
                } else if (str28 == str24 || str28 == "h24") {
                    PlatformDateTimeFormatterICU.a(sb2, new char[]{'h', 'H', 'K'}, 'k');
                }
            }
            if (hourCycle6 == hourCycle2 || hourCycle6 == hourCycle3) {
                PlatformDateTimeFormatterICU.a(sb2, new char[]{'H', 'K', 'k'}, 'h');
            } else if (hourCycle6 == hourCycle || hourCycle6 == hourCycle4) {
                PlatformDateTimeFormatterICU.a(sb2, new char[]{'h', 'H', 'K'}, 'k');
            }
            if (!z3 && !(objB3 instanceof JSObjects.NullObject)) {
                if (((Boolean) objB3).booleanValue()) {
                    PlatformDateTimeFormatterICU.a(sb2, new char[]{'H', 'K', 'k'}, 'h');
                } else {
                    PlatformDateTimeFormatterICU.a(sb2, new char[]{'h', 'H', 'K'}, 'k');
                }
            }
        }
        String string3 = sb2.toString();
        if (str25.isEmpty()) {
            calendar = null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str25);
            ILocaleObject iLocaleObjectB = iLocaleObject3.b();
            iLocaleObjectB.c(str23, arrayList);
            calendar = Calendar.getInstance((ULocale) iLocaleObjectB.getLocale());
        }
        if (str26.isEmpty()) {
            iLocaleObject = iLocaleObject3;
        } else {
            try {
                if (NumberingSystem.getInstanceByName(str26) == null) {
                    throw new JSRangeErrorException("Invalid numbering system: ".concat(str26));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str26);
                iLocaleObject = iLocaleObject3;
                iLocaleObject.c(str21, arrayList2);
            } catch (RuntimeException unused2) {
                throw new JSRangeErrorException("Invalid numbering system: ".concat(str26));
            }
        }
        if (calendar != null) {
            platformDateTimeFormatterICU = platformDateTimeFormatterICU3;
            platformDateTimeFormatterICU.f17651a = DateFormat.getPatternInstance(calendar, string3, (ULocale) iLocaleObject.getLocale());
        } else {
            platformDateTimeFormatterICU = platformDateTimeFormatterICU3;
            platformDateTimeFormatterICU.f17651a = DateFormat.getPatternInstance(string3, (ULocale) iLocaleObject.getLocale());
        }
        platformDateTimeFormatterICU.f17651a.setTimeZone(android.icu.util.TimeZone.getTimeZone(str27));
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 'A' || cCharAt > 'Z') {
                sb.append(cCharAt);
            } else {
                sb.append((char) (cCharAt + ' '));
            }
        }
        return sb.toString();
    }

    @DoNotStrip
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        String str = (String) OptionHelpers.b(map, "localeMatcher", OptionHelpers.OptionType.f17634b, Constants.f17501a, "best fit");
        String[] strArr = new String[list.size()];
        return str.equals("best fit") ? Arrays.asList(LocaleMatcher.c((String[]) list.toArray(strArr))) : Arrays.asList(LocaleMatcher.e((String[]) list.toArray(strArr)));
    }

    @DoNotStrip
    public String format(double d2) throws JSRangeErrorException {
        return this.f17505a.f17651a.format(new Date((long) d2));
    }

    @DoNotStrip
    public List<Map<String, String>> formatToParts(double d2) throws NumberFormatException, JSRangeErrorException {
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator toCharacterIterator = this.f17505a.f17651a.formatToCharacterIterator(Double.valueOf(d2));
        StringBuilder sb = new StringBuilder();
        for (char cFirst = toCharacterIterator.first(); cFirst != 65535; cFirst = toCharacterIterator.next()) {
            sb.append(cFirst);
            if (toCharacterIterator.getIndex() + 1 == toCharacterIterator.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = toCharacterIterator.getAttributes().keySet().iterator();
                String str = "literal";
                if (it.hasNext()) {
                    AttributedCharacterIterator.Attribute next = it.next();
                    String string = sb.toString();
                    if (next == DateFormat.Field.DAY_OF_WEEK) {
                        str = "weekday";
                    } else if (next == DateFormat.Field.ERA) {
                        str = "era";
                    } else if (next == DateFormat.Field.YEAR) {
                        try {
                            Double.parseDouble(string);
                            str = "year";
                        } catch (NumberFormatException unused) {
                            str = "yearName";
                        }
                    } else if (next == DateFormat.Field.MONTH) {
                        str = "month";
                    } else if (next == DateFormat.Field.DAY_OF_MONTH) {
                        str = "day";
                    } else if (next == DateFormat.Field.HOUR0 || next == DateFormat.Field.HOUR1 || next == DateFormat.Field.HOUR_OF_DAY0 || next == DateFormat.Field.HOUR_OF_DAY1) {
                        str = "hour";
                    } else if (next == DateFormat.Field.MINUTE) {
                        str = "minute";
                    } else if (next == DateFormat.Field.SECOND) {
                        str = "second";
                    } else if (next == DateFormat.Field.TIME_ZONE) {
                        str = "timeZoneName";
                    } else if (next == DateFormat.Field.AM_PM) {
                        str = "dayPeriod";
                    } else if (next.toString().equals("android.icu.text.DateFormat$Field(related year)")) {
                        str = "relatedYear";
                    }
                }
                String string2 = sb.toString();
                sb.setLength(0);
                HashMap map = new HashMap();
                map.put("type", str);
                map.put(CLConstants.FIELD_PAY_INFO_VALUE, string2);
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.f17507c.d());
        linkedHashMap.put("numberingSystem", this.f17511g);
        linkedHashMap.put("calendar", this.f17509e);
        linkedHashMap.put("timeZone", this.u);
        IPlatformDateTimeFormatter.HourCycle hourCycle = this.f17513i;
        if (hourCycle != IPlatformDateTimeFormatter.HourCycle.f17557e) {
            linkedHashMap.put("hourCycle", hourCycle.toString());
            IPlatformDateTimeFormatter.HourCycle hourCycle2 = this.f17513i;
            if (hourCycle2 == IPlatformDateTimeFormatter.HourCycle.f17553a || hourCycle2 == IPlatformDateTimeFormatter.HourCycle.f17554b) {
                linkedHashMap.put("hour12", Boolean.TRUE);
            } else {
                linkedHashMap.put("hour12", Boolean.FALSE);
            }
        }
        IPlatformDateTimeFormatter.WeekDay weekDay = this.f17514j;
        if (weekDay != IPlatformDateTimeFormatter.WeekDay.f17569a) {
            linkedHashMap.put("weekday", weekDay.toString());
        }
        IPlatformDateTimeFormatter.Era era = this.f17515k;
        if (era != IPlatformDateTimeFormatter.Era.f17548a) {
            linkedHashMap.put("era", era.toString());
        }
        IPlatformDateTimeFormatter.Year year = this.f17516l;
        if (year != IPlatformDateTimeFormatter.Year.f17571a) {
            linkedHashMap.put("year", year.toString());
        }
        IPlatformDateTimeFormatter.Month month = this.f17517m;
        if (month != IPlatformDateTimeFormatter.Month.f17561a) {
            linkedHashMap.put("month", month.toString());
        }
        IPlatformDateTimeFormatter.Day day = this.n;
        if (day != IPlatformDateTimeFormatter.Day.f17546a) {
            linkedHashMap.put("day", day.toString());
        }
        IPlatformDateTimeFormatter.Hour hour = this.o;
        if (hour != IPlatformDateTimeFormatter.Hour.f17551a) {
            linkedHashMap.put("hour", hour.toString());
        }
        IPlatformDateTimeFormatter.Minute minute = this.p;
        if (minute != IPlatformDateTimeFormatter.Minute.f17559a) {
            linkedHashMap.put("minute", minute.toString());
        }
        IPlatformDateTimeFormatter.Second second = this.q;
        if (second != IPlatformDateTimeFormatter.Second.f17563a) {
            linkedHashMap.put("second", second.toString());
        }
        IPlatformDateTimeFormatter.TimeZoneName timeZoneName = this.r;
        if (timeZoneName != IPlatformDateTimeFormatter.TimeZoneName.f17567a) {
            linkedHashMap.put("timeZoneName", timeZoneName.toString());
        }
        IPlatformDateTimeFormatter.DateStyle dateStyle = this.s;
        if (dateStyle != IPlatformDateTimeFormatter.DateStyle.f17544a) {
            linkedHashMap.put("dateStyle", dateStyle.toString());
        }
        IPlatformDateTimeFormatter.TimeStyle timeStyle = this.t;
        if (timeStyle != IPlatformDateTimeFormatter.TimeStyle.f17565a) {
            linkedHashMap.put("timeStyle", timeStyle.toString());
        }
        return linkedHashMap;
    }
}
