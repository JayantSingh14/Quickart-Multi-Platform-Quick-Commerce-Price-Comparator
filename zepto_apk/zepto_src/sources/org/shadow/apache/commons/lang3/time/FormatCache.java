package org.shadow.apache.commons.lang3.time;

import java.text.Format;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
abstract class FormatCache<F extends Format> {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f57863a = new ConcurrentHashMap(7);

    public static class MultipartKey {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f57864a;

        /* renamed from: b, reason: collision with root package name */
        public int f57865b;

        public MultipartKey(Object... objArr) {
            this.f57864a = objArr;
        }

        public final boolean equals(Object obj) {
            return Arrays.equals(this.f57864a, ((MultipartKey) obj).f57864a);
        }

        public final int hashCode() {
            if (this.f57865b == 0) {
                int iHashCode = 0;
                for (Object obj : this.f57864a) {
                    if (obj != null) {
                        iHashCode = obj.hashCode() + (iHashCode * 7);
                    }
                }
                this.f57865b = iHashCode;
            }
            return this.f57865b;
        }
    }

    static {
        new ConcurrentHashMap(7);
    }

    public abstract FastDateFormat a(String str, TimeZone timeZone, Locale locale);

    public final Format b(String str, Locale locale) {
        TimeZone timeZone = TimeZone.getDefault();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
        ConcurrentHashMap concurrentHashMap = this.f57863a;
        Format format = (Format) concurrentHashMap.get(multipartKey);
        if (format != null) {
            return format;
        }
        FastDateFormat fastDateFormatA = a(str, timeZone, locale);
        Format format2 = (Format) concurrentHashMap.putIfAbsent(multipartKey, fastDateFormatA);
        return format2 != null ? format2 : fastDateFormatA;
    }
}
