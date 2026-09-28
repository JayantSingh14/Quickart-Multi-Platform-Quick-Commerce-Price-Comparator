package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.util.CachingDateFormatter;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DateTokenConverter<E> extends DynamicConverter<E> implements MonoTypedConverter {

    /* renamed from: f, reason: collision with root package name */
    public String f13724f;

    /* renamed from: g, reason: collision with root package name */
    public TimeZone f13725g;

    /* renamed from: h, reason: collision with root package name */
    public CachingDateFormatter f13726h;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (obj instanceof Date) {
            return this.f13726h.a(((Date) obj).getTime());
        }
        throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        String strF = f();
        this.f13724f = strF;
        if (strF == null) {
            this.f13724f = "yyyy-MM-dd";
        }
        List list = this.f13650d;
        if (list != null) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                String str = (String) list.get(i2);
                if (!"AUX".equalsIgnoreCase(str)) {
                    this.f13725g = DesugarTimeZone.getTimeZone(str);
                }
            }
        }
        CachingDateFormatter cachingDateFormatter = new CachingDateFormatter(this.f13724f);
        this.f13726h = cachingDateFormatter;
        TimeZone timeZone = this.f13725g;
        if (timeZone != null) {
            cachingDateFormatter.f13802c.setTimeZone(timeZone);
        }
    }
}
