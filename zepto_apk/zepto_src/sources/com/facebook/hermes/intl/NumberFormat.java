package com.facebook.hermes.intl;

import android.icu.text.MeasureFormat;
import android.icu.text.NumberFormat;
import android.icu.text.UFormat;
import android.icu.util.Measure;
import android.icu.util.ULocale;
import com.facebook.hermes.intl.IPlatformNumberFormatter;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.proguard.annotations.DoNotStrip;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@DoNotStrip
/* loaded from: classes3.dex */
public class NumberFormat {
    public static final String[] v = {"acre", "bit", "byte", "celsius", "centimeter", "day", "degree", "fahrenheit", "fluid-ounce", "foot", "gallon", "gigabit", "gigabyte", "gram", "hectare", "hour", "inch", "kilobit", "kilobyte", "kilogram", "kilometer", "liter", "megabit", "megabyte", "meter", "mile", "mile-scandinavian", "milliliter", "millimeter", "millisecond", "minute", "month", "ounce", "percent", "petabyte", "pound", "second", "stone", "terabit", "terabyte", "week", "yard", "year"};

    /* renamed from: a, reason: collision with root package name */
    public final IPlatformNumberFormatter.Style f17620a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17621b;

    /* renamed from: c, reason: collision with root package name */
    public final IPlatformNumberFormatter.CurrencyDisplay f17622c;

    /* renamed from: d, reason: collision with root package name */
    public final IPlatformNumberFormatter.CurrencySign f17623d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17624e;

    /* renamed from: f, reason: collision with root package name */
    public final IPlatformNumberFormatter.UnitDisplay f17625f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f17626g;

    /* renamed from: h, reason: collision with root package name */
    public final int f17627h;

    /* renamed from: i, reason: collision with root package name */
    public final int f17628i;

    /* renamed from: j, reason: collision with root package name */
    public final int f17629j;

    /* renamed from: k, reason: collision with root package name */
    public final int f17630k;

    /* renamed from: l, reason: collision with root package name */
    public final int f17631l;

    /* renamed from: m, reason: collision with root package name */
    public final IPlatformNumberFormatter.RoundingType f17632m;
    public final IPlatformNumberFormatter.SignDisplay n;
    public final PlatformNumberFormatterICU o;
    public final boolean p;
    public final String q;
    public final IPlatformNumberFormatter.Notation r;
    public final IPlatformNumberFormatter.CompactDisplay s;
    public final ILocaleObject t;
    public final ILocaleObject u;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0176, code lost:
    
        if (java.util.Arrays.binarySearch(r2, r15.substring(r6 + 5)) >= 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x061f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03d0  */
    @com.facebook.proguard.annotations.DoNotStrip
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NumberFormat(java.util.List<java.lang.String> r34, java.util.Map<java.lang.String, java.lang.Object> r35) throws com.facebook.hermes.intl.JSRangeErrorException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.NumberFormat.<init>(java.util.List, java.util.Map):void");
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 'a' || cCharAt > 'z') {
                sb.append(cCharAt);
            } else {
                sb.append((char) (cCharAt - ' '));
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
        PlatformNumberFormatterICU platformNumberFormatterICU = this.o;
        try {
            try {
                UFormat uFormat = platformNumberFormatterICU.f17655a;
                return (!(uFormat instanceof MeasureFormat) || platformNumberFormatterICU.f17659e == null) ? uFormat.format(Double.valueOf(d2)) : uFormat.format(new Measure(Double.valueOf(d2), platformNumberFormatterICU.f17659e));
            } catch (NumberFormatException unused) {
                return android.icu.text.NumberFormat.getInstance(ULocale.getDefault()).format(d2);
            }
        } catch (RuntimeException unused2) {
            return android.icu.text.NumberFormat.getInstance(ULocale.forLanguageTag("en")).format(d2);
        }
    }

    @DoNotStrip
    public List<Map<String, String>> formatToParts(double d2) throws JSRangeErrorException {
        AttributedCharacterIterator toCharacterIterator;
        ArrayList arrayList = new ArrayList();
        PlatformNumberFormatterICU platformNumberFormatterICU = this.o;
        try {
            try {
                UFormat uFormat = platformNumberFormatterICU.f17655a;
                toCharacterIterator = (!(uFormat instanceof MeasureFormat) || platformNumberFormatterICU.f17659e == null) ? uFormat.formatToCharacterIterator(Double.valueOf(d2)) : uFormat.formatToCharacterIterator(new Measure(Double.valueOf(d2), platformNumberFormatterICU.f17659e));
            } catch (RuntimeException unused) {
                toCharacterIterator = android.icu.text.NumberFormat.getInstance(ULocale.forLanguageTag("en")).formatToCharacterIterator(Double.valueOf(d2));
            }
        } catch (NumberFormatException unused2) {
            toCharacterIterator = android.icu.text.NumberFormat.getInstance(ULocale.getDefault()).formatToCharacterIterator(Double.valueOf(d2));
        } catch (Exception unused3) {
            toCharacterIterator = android.icu.text.NumberFormat.getInstance(ULocale.forLanguageTag("en")).formatToCharacterIterator(Double.valueOf(d2));
        }
        StringBuilder sb = new StringBuilder();
        for (char cFirst = toCharacterIterator.first(); cFirst != 65535; cFirst = toCharacterIterator.next()) {
            sb.append(cFirst);
            if (toCharacterIterator.getIndex() + 1 == toCharacterIterator.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = toCharacterIterator.getAttributes().keySet().iterator();
                String str = "literal";
                if (it.hasNext()) {
                    AttributedCharacterIterator.Attribute next = it.next();
                    if (next == NumberFormat.Field.SIGN) {
                        str = Double.compare(d2, 0.0d) >= 0 ? "plusSign" : "minusSign";
                    } else if (next == NumberFormat.Field.INTEGER) {
                        str = Double.isNaN(d2) ? "nan" : Double.isInfinite(d2) ? "infinity" : "integer";
                    } else if (next == NumberFormat.Field.FRACTION) {
                        str = "fraction";
                    } else if (next == NumberFormat.Field.EXPONENT) {
                        str = "exponentInteger";
                    } else if (next == NumberFormat.Field.EXPONENT_SIGN) {
                        str = "exponentMinusSign";
                    } else if (next == NumberFormat.Field.EXPONENT_SYMBOL) {
                        str = "exponentSeparator";
                    } else if (next == NumberFormat.Field.DECIMAL_SEPARATOR) {
                        str = "decimal";
                    } else if (next == NumberFormat.Field.GROUPING_SEPARATOR) {
                        str = "group";
                    } else if (next == NumberFormat.Field.PERCENT) {
                        str = "percentSign";
                    } else if (next == NumberFormat.Field.PERMILLE) {
                        str = "permilleSign";
                    } else if (next == NumberFormat.Field.CURRENCY) {
                        str = "currency";
                    } else if (next.toString().equals("android.icu.text.NumberFormat$Field(compact)")) {
                        str = "compact";
                    }
                }
                String string = sb.toString();
                sb.setLength(0);
                HashMap map = new HashMap();
                map.put("type", str);
                map.put(CLConstants.FIELD_PAY_INFO_VALUE, string);
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.u.d());
        linkedHashMap.put("numberingSystem", this.q);
        linkedHashMap.put("style", this.f17620a.toString());
        IPlatformNumberFormatter.Style style = this.f17620a;
        if (style == IPlatformNumberFormatter.Style.f17600c) {
            linkedHashMap.put("currency", this.f17621b);
            linkedHashMap.put("currencyDisplay", this.f17622c.toString());
            linkedHashMap.put("currencySign", this.f17623d.toString());
        } else if (style == IPlatformNumberFormatter.Style.f17601d) {
            linkedHashMap.put("unit", this.f17624e);
            linkedHashMap.put("unitDisplay", this.f17625f.toString());
        }
        int i2 = this.f17627h;
        if (i2 != -1) {
            linkedHashMap.put("minimumIntegerDigits", Integer.valueOf(i2));
        }
        IPlatformNumberFormatter.RoundingType roundingType = this.f17632m;
        if (roundingType == IPlatformNumberFormatter.RoundingType.f17592a) {
            int i3 = this.f17631l;
            if (i3 != -1) {
                linkedHashMap.put("maximumSignificantDigits", Integer.valueOf(i3));
            }
            int i4 = this.f17630k;
            if (i4 != -1) {
                linkedHashMap.put("minimumSignificantDigits", Integer.valueOf(i4));
            }
        } else if (roundingType == IPlatformNumberFormatter.RoundingType.f17593b) {
            int i5 = this.f17628i;
            if (i5 != -1) {
                linkedHashMap.put("minimumFractionDigits", Integer.valueOf(i5));
            }
            int i6 = this.f17629j;
            if (i6 != -1) {
                linkedHashMap.put("maximumFractionDigits", Integer.valueOf(i6));
            }
        }
        linkedHashMap.put("useGrouping", Boolean.valueOf(this.f17626g));
        linkedHashMap.put("notation", this.r.toString());
        if (this.r == IPlatformNumberFormatter.Notation.f17590c) {
            linkedHashMap.put("compactDisplay", this.s.toString());
        }
        linkedHashMap.put("signDisplay", this.n.toString());
        return linkedHashMap;
    }
}
