package org.shadow.apache.commons.lang3.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes5.dex */
public class FastDatePrinter implements DatePrinter, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f57829e = new ConcurrentHashMap(7);

    /* renamed from: a, reason: collision with root package name */
    public final String f57830a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f57831b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f57832c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Rule[] f57833d;

    public static class CharacterLiteral implements Rule {

        /* renamed from: a, reason: collision with root package name */
        public final char f57834a;

        public CharacterLiteral(char c2) {
            this.f57834a = c2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            stringBuffer.append(this.f57834a);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 1;
        }
    }

    public static class Iso8601_Rule implements Rule {

        /* renamed from: b, reason: collision with root package name */
        public static final Iso8601_Rule f57835b = new Iso8601_Rule(3);

        /* renamed from: c, reason: collision with root package name */
        public static final Iso8601_Rule f57836c = new Iso8601_Rule(5);

        /* renamed from: d, reason: collision with root package name */
        public static final Iso8601_Rule f57837d = new Iso8601_Rule(6);

        /* renamed from: a, reason: collision with root package name */
        public final int f57838a;

        public Iso8601_Rule(int i2) {
            this.f57838a = i2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            int i2 = calendar.get(15);
            if (i2 == 0) {
                stringBuffer.append("Z");
                return;
            }
            int i3 = calendar.get(16) + i2;
            if (i3 < 0) {
                stringBuffer.append(Soundex.SILENT_MARKER);
                i3 = -i3;
            } else {
                stringBuffer.append('+');
            }
            int i4 = i3 / 3600000;
            FastDatePrinter.a(stringBuffer, i4);
            int i5 = this.f57838a;
            if (i5 < 5) {
                return;
            }
            if (i5 == 6) {
                stringBuffer.append(':');
            }
            FastDatePrinter.a(stringBuffer, (i3 / 60000) - (i4 * 60));
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return this.f57838a;
        }
    }

    public interface NumberRule extends Rule {
        void b(StringBuffer stringBuffer, int i2);
    }

    public static class PaddedNumberField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public final int f57839a;

        /* renamed from: b, reason: collision with root package name */
        public final int f57840b;

        public PaddedNumberField(int i2, int i3) {
            if (i3 < 3) {
                throw new IllegalArgumentException();
            }
            this.f57839a = i2;
            this.f57840b = i3;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            b(stringBuffer, calendar.get(this.f57839a));
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            for (int i3 = 0; i3 < this.f57840b; i3++) {
                stringBuffer.append('0');
            }
            int length = stringBuffer.length();
            while (i2 > 0) {
                length--;
                stringBuffer.setCharAt(length, (char) ((i2 % 10) + 48));
                i2 /= 10;
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return this.f57840b;
        }
    }

    public interface Rule {
        void a(Calendar calendar, StringBuffer stringBuffer);

        int estimateLength();
    }

    public static class StringLiteral implements Rule {

        /* renamed from: a, reason: collision with root package name */
        public final String f57841a;

        public StringLiteral(String str) {
            this.f57841a = str;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            stringBuffer.append(this.f57841a);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return this.f57841a.length();
        }
    }

    public static class TextField implements Rule {

        /* renamed from: a, reason: collision with root package name */
        public final int f57842a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f57843b;

        public TextField(int i2, String[] strArr) {
            this.f57842a = i2;
            this.f57843b = strArr;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            stringBuffer.append(this.f57843b[calendar.get(this.f57842a)]);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            String[] strArr = this.f57843b;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = strArr[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {

        /* renamed from: a, reason: collision with root package name */
        public final TimeZone f57844a;

        /* renamed from: b, reason: collision with root package name */
        public final int f57845b;

        /* renamed from: c, reason: collision with root package name */
        public final Locale f57846c;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i2, Locale locale) {
            this.f57844a = timeZone;
            if (z) {
                this.f57845b = Integer.MIN_VALUE | i2;
            } else {
                this.f57845b = i2;
            }
            this.f57846c = locale;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TimeZoneDisplayKey) {
                TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
                if (this.f57844a.equals(timeZoneDisplayKey.f57844a) && this.f57845b == timeZoneDisplayKey.f57845b && this.f57846c.equals(timeZoneDisplayKey.f57846c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f57844a.hashCode() + ((this.f57846c.hashCode() + (this.f57845b * 31)) * 31);
        }
    }

    public static class TimeZoneNameRule implements Rule {

        /* renamed from: a, reason: collision with root package name */
        public final Locale f57847a;

        /* renamed from: b, reason: collision with root package name */
        public final int f57848b;

        /* renamed from: c, reason: collision with root package name */
        public final String f57849c;

        /* renamed from: d, reason: collision with root package name */
        public final String f57850d;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i2) {
            this.f57847a = locale;
            this.f57848b = i2;
            this.f57849c = FastDatePrinter.b(timeZone, false, i2, locale);
            this.f57850d = FastDatePrinter.b(timeZone, true, i2, locale);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            TimeZone timeZone = calendar.getTimeZone();
            int i2 = calendar.get(16);
            Locale locale = this.f57847a;
            int i3 = this.f57848b;
            if (i2 != 0) {
                stringBuffer.append(FastDatePrinter.b(timeZone, true, i3, locale));
            } else {
                stringBuffer.append(FastDatePrinter.b(timeZone, false, i3, locale));
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return Math.max(this.f57849c.length(), this.f57850d.length());
        }
    }

    public static class TimeZoneNumberRule implements Rule {

        /* renamed from: c, reason: collision with root package name */
        public static final TimeZoneNumberRule f57851c = new TimeZoneNumberRule(true, false);

        /* renamed from: d, reason: collision with root package name */
        public static final TimeZoneNumberRule f57852d = new TimeZoneNumberRule(false, false);

        /* renamed from: e, reason: collision with root package name */
        public static final TimeZoneNumberRule f57853e = new TimeZoneNumberRule(true, true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f57854a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f57855b;

        public TimeZoneNumberRule(boolean z, boolean z2) {
            this.f57854a = z;
            this.f57855b = z2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            if (this.f57855b && calendar.getTimeZone().getID().equals("UTC")) {
                stringBuffer.append("Z");
                return;
            }
            int i2 = calendar.get(16) + calendar.get(15);
            if (i2 < 0) {
                stringBuffer.append(Soundex.SILENT_MARKER);
                i2 = -i2;
            } else {
                stringBuffer.append('+');
            }
            int i3 = i2 / 3600000;
            FastDatePrinter.a(stringBuffer, i3);
            if (this.f57854a) {
                stringBuffer.append(':');
            }
            FastDatePrinter.a(stringBuffer, (i2 / 60000) - (i3 * 60));
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 5;
        }
    }

    public static class TwelveHourField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public final NumberRule f57856a;

        public TwelveHourField(NumberRule numberRule) {
            this.f57856a = numberRule;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.f57856a.b(stringBuffer, leastMaximum);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            this.f57856a.b(stringBuffer, i2);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return this.f57856a.estimateLength();
        }
    }

    public static class TwentyFourHourField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public final NumberRule f57857a;

        public TwentyFourHourField(NumberRule numberRule) {
            this.f57857a = numberRule;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.f57857a.b(stringBuffer, maximum);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            this.f57857a.b(stringBuffer, i2);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return this.f57857a.estimateLength();
        }
    }

    public static class TwoDigitMonthField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public static final TwoDigitMonthField f57858a = new TwoDigitMonthField();

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            FastDatePrinter.a(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            FastDatePrinter.a(stringBuffer, i2);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 2;
        }
    }

    public static class TwoDigitNumberField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public final int f57859a;

        public TwoDigitNumberField(int i2) {
            this.f57859a = i2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            b(stringBuffer, calendar.get(this.f57859a));
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            if (i2 < 100) {
                FastDatePrinter.a(stringBuffer, i2);
            } else {
                stringBuffer.append(i2);
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 2;
        }
    }

    public static class TwoDigitYearField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public static final TwoDigitYearField f57860a = new TwoDigitYearField();

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            FastDatePrinter.a(stringBuffer, calendar.get(1) % 100);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            FastDatePrinter.a(stringBuffer, i2);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 2;
        }
    }

    public static class UnpaddedMonthField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public static final UnpaddedMonthField f57861a = new UnpaddedMonthField();

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            b(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            if (i2 < 10) {
                stringBuffer.append((char) (i2 + 48));
            } else {
                FastDatePrinter.a(stringBuffer, i2);
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 2;
        }
    }

    public static class UnpaddedNumberField implements NumberRule {

        /* renamed from: a, reason: collision with root package name */
        public final int f57862a;

        public UnpaddedNumberField(int i2) {
            this.f57862a = i2;
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final void a(Calendar calendar, StringBuffer stringBuffer) {
            b(stringBuffer, calendar.get(this.f57862a));
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void b(StringBuffer stringBuffer, int i2) {
            if (i2 < 10) {
                stringBuffer.append((char) (i2 + 48));
            } else if (i2 < 100) {
                FastDatePrinter.a(stringBuffer, i2);
            } else {
                stringBuffer.append(i2);
            }
        }

        @Override // org.shadow.apache.commons.lang3.time.FastDatePrinter.Rule
        public final int estimateLength() {
            return 4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x022b A[LOOP:2: B:118:0x0227->B:120:0x022b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FastDatePrinter(java.lang.String r21, java.util.TimeZone r22, java.util.Locale r23) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.shadow.apache.commons.lang3.time.FastDatePrinter.<init>(java.lang.String, java.util.TimeZone, java.util.Locale):void");
    }

    public static void a(StringBuffer stringBuffer, int i2) {
        stringBuffer.append((char) ((i2 / 10) + 48));
        stringBuffer.append((char) ((i2 % 10) + 48));
    }

    public static String b(TimeZone timeZone, boolean z, int i2, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i2, locale);
        ConcurrentHashMap concurrentHashMap = f57829e;
        String str = (String) concurrentHashMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String str2 = (String) concurrentHashMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return str2 != null ? str2 : displayName;
    }

    public static NumberRule c(int i2, int i3) {
        return i3 != 1 ? i3 != 2 ? new PaddedNumberField(i2, i3) : new TwoDigitNumberField(i2) : new UnpaddedNumberField(i2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.f57830a.equals(fastDatePrinter.f57830a) && this.f57831b.equals(fastDatePrinter.f57831b) && this.f57832c.equals(fastDatePrinter.f57832c);
    }

    public final int hashCode() {
        return (((this.f57832c.hashCode() * 13) + this.f57831b.hashCode()) * 13) + this.f57830a.hashCode();
    }

    public final String toString() {
        return "FastDatePrinter[" + this.f57830a + "," + this.f57832c + "," + this.f57831b.getID() + "]";
    }
}
