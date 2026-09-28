package org.shadow.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import org.shadow.apache.commons.lang3.time.FastDateParser;
import org.shadow.apache.commons.lang3.time.FastDatePrinter;

/* loaded from: classes5.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {

    /* renamed from: c, reason: collision with root package name */
    public static final AnonymousClass1 f57802c = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final FastDatePrinter f57803a;

    /* renamed from: b, reason: collision with root package name */
    public final FastDateParser f57804b;

    /* renamed from: org.shadow.apache.commons.lang3.time.FastDateFormat$1, reason: invalid class name */
    public static class AnonymousClass1 extends FormatCache<FastDateFormat> {
        @Override // org.shadow.apache.commons.lang3.time.FormatCache
        public final FastDateFormat a(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this.f57803a = new FastDatePrinter(str, timeZone, locale);
        this.f57804b = new FastDateParser(str, timeZone, locale);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof FastDateFormat) {
            return this.f57803a.equals(((FastDateFormat) obj).f57803a);
        }
        return false;
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FastDatePrinter fastDatePrinter = this.f57803a;
        fastDatePrinter.getClass();
        boolean z = obj instanceof Date;
        int i2 = 0;
        Locale locale = fastDatePrinter.f57832c;
        TimeZone timeZone = fastDatePrinter.f57831b;
        if (z) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, locale);
            gregorianCalendar.setTime((Date) obj);
            FastDatePrinter.Rule[] ruleArr = fastDatePrinter.f57833d;
            int length = ruleArr.length;
            while (i2 < length) {
                ruleArr[i2].a(gregorianCalendar, stringBuffer);
                i2++;
            }
        } else if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            FastDatePrinter.Rule[] ruleArr2 = fastDatePrinter.f57833d;
            int length2 = ruleArr2.length;
            while (i2 < length2) {
                ruleArr2[i2].a(calendar, stringBuffer);
                i2++;
            }
        } else {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException("Unknown class: ".concat(obj == null ? "<null>" : obj.getClass().getName()));
            }
            Date date = new Date(((Long) obj).longValue());
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone, locale);
            gregorianCalendar2.setTime(date);
            FastDatePrinter.Rule[] ruleArr3 = fastDatePrinter.f57833d;
            int length3 = ruleArr3.length;
            while (i2 < length3) {
                ruleArr3[i2].a(gregorianCalendar2, stringBuffer);
                i2++;
            }
        }
        return stringBuffer;
    }

    public final int hashCode() {
        return this.f57803a.hashCode();
    }

    @Override // java.text.Format
    public final Object parseObject(String str, ParsePosition parsePosition) {
        FastDateParser fastDateParser = this.f57804b;
        fastDateParser.getClass();
        int index = parsePosition.getIndex();
        Matcher matcher = fastDateParser.f57814f.matcher(str.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(fastDateParser.f57810b, fastDateParser.f57811c);
        calendar.clear();
        int i2 = 0;
        while (true) {
            FastDateParser.Strategy[] strategyArr = fastDateParser.f57815g;
            if (i2 >= strategyArr.length) {
                parsePosition.setIndex(matcher.end() + index);
                return calendar.getTime();
            }
            int i3 = i2 + 1;
            strategyArr[i2].c(fastDateParser, calendar, matcher.group(i3));
            i2 = i3;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FastDateFormat[");
        FastDatePrinter fastDatePrinter = this.f57803a;
        sb.append(fastDatePrinter.f57830a);
        sb.append(",");
        sb.append(fastDatePrinter.f57832c);
        sb.append(",");
        sb.append(fastDatePrinter.f57831b.getID());
        sb.append("]");
        return sb.toString();
    }
}
