package org.shadow.apache.commons.lang3.time;

import android.support.v4.media.a;
import android.support.v4.media.b;
import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class FastDateParser implements DateParser, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f57809a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f57810b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f57811c;

    /* renamed from: d, reason: collision with root package name */
    public final int f57812d;

    /* renamed from: e, reason: collision with root package name */
    public final int f57813e;

    /* renamed from: f, reason: collision with root package name */
    public final transient Pattern f57814f;

    /* renamed from: g, reason: collision with root package name */
    public final transient Strategy[] f57815g;

    /* renamed from: h, reason: collision with root package name */
    public final transient String f57816h;

    /* renamed from: i, reason: collision with root package name */
    public final transient Strategy f57817i;

    /* renamed from: j, reason: collision with root package name */
    public static final Locale f57805j = new Locale("ja", "JP", "JP");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f57806k = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|X+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");

    /* renamed from: l, reason: collision with root package name */
    public static final ConcurrentMap[] f57807l = new ConcurrentMap[17];

    /* renamed from: m, reason: collision with root package name */
    public static final AnonymousClass1 f57808m = new AnonymousClass1(1);
    public static final AnonymousClass2 n = new AnonymousClass2(2);
    public static final NumberStrategy o = new NumberStrategy(1);
    public static final NumberStrategy p = new NumberStrategy(3);
    public static final NumberStrategy q = new NumberStrategy(4);
    public static final NumberStrategy r = new NumberStrategy(6);
    public static final NumberStrategy s = new NumberStrategy(5);
    public static final NumberStrategy t = new NumberStrategy(8);
    public static final NumberStrategy u = new NumberStrategy(11);
    public static final AnonymousClass3 v = new AnonymousClass3(11);
    public static final AnonymousClass4 w = new AnonymousClass4(10);
    public static final NumberStrategy x = new NumberStrategy(10);
    public static final NumberStrategy y = new NumberStrategy(12);
    public static final NumberStrategy z = new NumberStrategy(13);
    public static final NumberStrategy A = new NumberStrategy(14);
    public static final ISO8601TimeZoneStrategy B = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::?\\d{2})?))");

    /* renamed from: org.shadow.apache.commons.lang3.time.FastDateParser$1, reason: invalid class name */
    public static class AnonymousClass1 extends NumberStrategy {
        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.NumberStrategy, org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final void c(FastDateParser fastDateParser, Calendar calendar, String str) throws NumberFormatException {
            int i2 = Integer.parseInt(str);
            if (i2 < 100) {
                int i3 = fastDateParser.f57812d + i2;
                if (i2 < fastDateParser.f57813e) {
                    i3 += 100;
                }
                i2 = i3;
            }
            calendar.set(1, i2);
        }
    }

    /* renamed from: org.shadow.apache.commons.lang3.time.FastDateParser$2, reason: invalid class name */
    public static class AnonymousClass2 extends NumberStrategy {
        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public final int d(int i2) {
            return i2 - 1;
        }
    }

    /* renamed from: org.shadow.apache.commons.lang3.time.FastDateParser$3, reason: invalid class name */
    public static class AnonymousClass3 extends NumberStrategy {
        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public final int d(int i2) {
            if (i2 == 24) {
                return 0;
            }
            return i2;
        }
    }

    /* renamed from: org.shadow.apache.commons.lang3.time.FastDateParser$4, reason: invalid class name */
    public static class AnonymousClass4 extends NumberStrategy {
        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public final int d(int i2) {
            if (i2 == 12) {
                return 0;
            }
            return i2;
        }
    }

    public static class CaseInsensitiveTextStrategy extends Strategy {

        /* renamed from: a, reason: collision with root package name */
        public final int f57818a;

        /* renamed from: b, reason: collision with root package name */
        public final Locale f57819b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f57820c;

        public CaseInsensitiveTextStrategy(int i2, Calendar calendar, Locale locale) {
            this.f57818a = i2;
            this.f57819b = locale;
            Locale locale2 = FastDateParser.f57805j;
            Map<String, Integer> displayNames = calendar.getDisplayNames(i2, 0, locale);
            this.f57820c = new HashMap();
            for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
                this.f57820c.put(entry.getKey().toLowerCase(locale), entry.getValue());
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean a(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append("((?iu)");
            Iterator it = this.f57820c.keySet().iterator();
            while (it.hasNext()) {
                FastDateParser.a(sb, (String) it.next(), false);
                sb.append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            return true;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final void c(FastDateParser fastDateParser, Calendar calendar, String str) {
            HashMap map = this.f57820c;
            Integer num = (Integer) map.get(str.toLowerCase(this.f57819b));
            if (num != null) {
                calendar.set(this.f57818a, num.intValue());
                return;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append(" not in (");
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(' ');
            }
            sb.setCharAt(sb.length() - 1, ')');
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static class CopyQuotedStrategy extends Strategy {

        /* renamed from: a, reason: collision with root package name */
        public final String f57821a;

        public CopyQuotedStrategy(String str) {
            this.f57821a = str;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean a(FastDateParser fastDateParser, StringBuilder sb) {
            FastDateParser.a(sb, this.f57821a, true);
            return false;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean b() {
            String str = this.f57821a;
            char cCharAt = str.charAt(0);
            if (cCharAt == '\'') {
                cCharAt = str.charAt(1);
            }
            return Character.isDigit(cCharAt);
        }
    }

    public static class ISO8601TimeZoneStrategy extends Strategy {

        /* renamed from: b, reason: collision with root package name */
        public static final ISO8601TimeZoneStrategy f57822b = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");

        /* renamed from: c, reason: collision with root package name */
        public static final ISO8601TimeZoneStrategy f57823c = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");

        /* renamed from: d, reason: collision with root package name */
        public static final ISO8601TimeZoneStrategy f57824d = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        /* renamed from: a, reason: collision with root package name */
        public final String f57825a;

        public ISO8601TimeZoneStrategy(String str) {
            this.f57825a = str;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean a(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.f57825a);
            return true;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final void c(FastDateParser fastDateParser, Calendar calendar, String str) {
            if (str.equals("Z")) {
                calendar.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            } else {
                calendar.setTimeZone(DesugarTimeZone.getTimeZone(TimeZones.GMT_ID.concat(str)));
            }
        }
    }

    public static class NumberStrategy extends Strategy {

        /* renamed from: a, reason: collision with root package name */
        public final int f57826a;

        public NumberStrategy(int i2) {
            this.f57826a = i2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean a(FastDateParser fastDateParser, StringBuilder sb) {
            Strategy strategy = fastDateParser.f57817i;
            if (strategy == null || !strategy.b()) {
                sb.append("(\\p{Nd}++)");
                return true;
            }
            sb.append("(\\p{Nd}{");
            sb.append(fastDateParser.f57816h.length());
            sb.append("}+)");
            return true;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean b() {
            return true;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public void c(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.f57826a, d(Integer.parseInt(str)));
        }

        public int d(int i2) {
            return i2;
        }
    }

    public static abstract class Strategy {
        public abstract boolean a(FastDateParser fastDateParser, StringBuilder sb);

        public boolean b() {
            return false;
        }

        public void c(FastDateParser fastDateParser, Calendar calendar, String str) {
        }
    }

    public static class TimeZoneStrategy extends Strategy {

        /* renamed from: a, reason: collision with root package name */
        public final String f57827a;

        /* renamed from: b, reason: collision with root package name */
        public final TreeMap f57828b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

        public TimeZoneStrategy(Locale locale) {
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith(TimeZones.GMT_ID)) {
                    TimeZone timeZone = DesugarTimeZone.getTimeZone(strArr[0]);
                    if (!this.f57828b.containsKey(strArr[1])) {
                        this.f57828b.put(strArr[1], timeZone);
                    }
                    if (!this.f57828b.containsKey(strArr[2])) {
                        this.f57828b.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.f57828b.containsKey(strArr[3])) {
                            this.f57828b.put(strArr[3], timeZone);
                        }
                        if (!this.f57828b.containsKey(strArr[4])) {
                            this.f57828b.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder sbW = b.w("(GMT[+-]\\d{1,2}:\\d{2}|[+-]\\d{4}|");
            Iterator it = this.f57828b.keySet().iterator();
            while (it.hasNext()) {
                FastDateParser.a(sbW, (String) it.next(), false);
                sbW.append('|');
            }
            sbW.setCharAt(sbW.length() - 1, ')');
            this.f57827a = sbW.toString();
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final boolean a(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.f57827a);
            return true;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDateParser.Strategy
        public final void c(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone timeZone;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                timeZone = DesugarTimeZone.getTimeZone(TimeZones.GMT_ID.concat(str));
            } else if (str.startsWith(TimeZones.GMT_ID)) {
                timeZone = DesugarTimeZone.getTimeZone(str);
            } else {
                timeZone = (TimeZone) this.f57828b.get(str);
                if (timeZone == null) {
                    throw new IllegalArgumentException(str.concat(" is not a supported timezone name"));
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
        int i2;
        this.f57809a = str;
        this.f57810b = timeZone;
        this.f57811c = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (locale.equals(f57805j)) {
            i2 = 0;
        } else {
            calendar.setTime(new Date());
            i2 = calendar.get(1) - 80;
        }
        int i3 = (i2 / 100) * 100;
        this.f57812d = i3;
        this.f57813e = i2 - i3;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f57806k.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("Illegal pattern character '" + str.charAt(matcher.regionStart()) + "'");
        }
        String strGroup = matcher.group();
        this.f57816h = strGroup;
        Strategy strategyC = c(calendar, strGroup);
        while (true) {
            matcher.region(matcher.end(), matcher.regionEnd());
            if (!matcher.lookingAt()) {
                break;
            }
            String strGroup2 = matcher.group();
            this.f57817i = c(calendar, strGroup2);
            if (strategyC.a(this, sb)) {
                arrayList.add(strategyC);
            }
            this.f57816h = strGroup2;
            strategyC = this.f57817i;
        }
        this.f57817i = null;
        if (matcher.regionStart() != matcher.regionEnd()) {
            StringBuilder sbY = b.y("Failed to parse \"", str, "\" ; gave up at index ");
            sbY.append(matcher.regionStart());
            throw new IllegalArgumentException(sbY.toString());
        }
        if (strategyC.a(this, sb)) {
            arrayList.add(strategyC);
        }
        this.f57816h = null;
        this.f57815g = (Strategy[]) arrayList.toArray(new Strategy[arrayList.size()]);
        this.f57814f = Pattern.compile(sb.toString());
    }

    public static void a(StringBuilder sb, String str, boolean z2) {
        sb.append("\\Q");
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\'') {
                if (cCharAt == '\\' && (i2 = i2 + 1) != str.length()) {
                    sb.append(cCharAt);
                    cCharAt = str.charAt(i2);
                    if (cCharAt == 'E') {
                        sb.append("E\\\\E\\");
                        cCharAt = 'Q';
                    }
                }
            } else if (z2) {
                i2++;
                if (i2 == str.length()) {
                    return;
                } else {
                    cCharAt = str.charAt(i2);
                }
            } else {
                continue;
            }
            sb.append(cCharAt);
            i2++;
        }
        sb.append("\\E");
    }

    public final Strategy b(int i2, Calendar calendar) {
        ConcurrentMap concurrentMap;
        ConcurrentMap[] concurrentMapArr = f57807l;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i2] == null) {
                    concurrentMapArr[i2] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i2];
            } catch (Throwable th) {
                throw th;
            }
        }
        Strategy strategy = (Strategy) concurrentMap.get(this.f57811c);
        if (strategy != null) {
            return strategy;
        }
        Strategy timeZoneStrategy = i2 == 15 ? new TimeZoneStrategy(this.f57811c) : new CaseInsensitiveTextStrategy(i2, calendar, this.f57811c);
        Strategy strategy2 = (Strategy) concurrentMap.putIfAbsent(this.f57811c, timeZoneStrategy);
        return strategy2 != null ? strategy2 : timeZoneStrategy;
    }

    public final Strategy c(Calendar calendar, String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'W') {
            return q;
        }
        if (cCharAt == 'X') {
            int length = str.length();
            if (length == 1) {
                return ISO8601TimeZoneStrategy.f57822b;
            }
            if (length == 2) {
                return ISO8601TimeZoneStrategy.f57823c;
            }
            if (length == 3) {
                return ISO8601TimeZoneStrategy.f57824d;
            }
            throw new IllegalArgumentException("invalid number of X");
        }
        if (cCharAt == 'y') {
            return str.length() > 2 ? o : f57808m;
        }
        if (cCharAt != 'z') {
            switch (cCharAt) {
                case '\'':
                    if (str.length() > 2) {
                        return new CopyQuotedStrategy(a.k(1, 1, str));
                    }
                    return new CopyQuotedStrategy(str);
                case 'K':
                    return x;
                case 'M':
                    return str.length() >= 3 ? b(2, calendar) : n;
                case 'S':
                    return A;
                case 'Z':
                    if (str.equals("ZZ")) {
                        return B;
                    }
                    break;
                case WKSRecord.Service.SWIFT_RVF /* 97 */:
                    return b(9, calendar);
                case 'd':
                    return s;
                case 'h':
                    return w;
                case 'k':
                    return v;
                case 'm':
                    return y;
                case WKSRecord.Service.SFTP /* 115 */:
                    return z;
                case WKSRecord.Service.NNTP /* 119 */:
                    return p;
                default:
                    switch (cCharAt) {
                        case WKSRecord.Service.BOOTPC /* 68 */:
                            return r;
                        case 'E':
                            return b(7, calendar);
                        case 'F':
                            return t;
                        case 'G':
                            return b(0, calendar);
                        case WKSRecord.Service.NETRJS_2 /* 72 */:
                            return u;
                        default:
                            return new CopyQuotedStrategy(str);
                    }
            }
        }
        return b(15, calendar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.f57809a.equals(fastDateParser.f57809a) && this.f57810b.equals(fastDateParser.f57810b) && this.f57811c.equals(fastDateParser.f57811c);
    }

    public final int hashCode() {
        return (((this.f57811c.hashCode() * 13) + this.f57810b.hashCode()) * 13) + this.f57809a.hashCode();
    }

    public final String toString() {
        return "FastDateParser[" + this.f57809a + "," + this.f57811c + "," + this.f57810b.getID() + "]";
    }
}
