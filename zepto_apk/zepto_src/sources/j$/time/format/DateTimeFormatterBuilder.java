package j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class DateTimeFormatterBuilder {

    /* renamed from: h, reason: collision with root package name */
    public static final j$.time.f f53292h = new j$.time.f(3);

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f53293i;

    /* renamed from: a, reason: collision with root package name */
    public DateTimeFormatterBuilder f53294a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeFormatterBuilder f53295b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f53296c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f53297d;

    /* renamed from: e, reason: collision with root package name */
    public int f53298e;

    /* renamed from: f, reason: collision with root package name */
    public char f53299f;

    /* renamed from: g, reason: collision with root package name */
    public int f53300g;

    static {
        HashMap map = new HashMap();
        f53293i = map;
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.g gVar = j$.time.temporal.i.f53417a;
        map.put('Q', gVar);
        map.put('q', gVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.k.f53425a);
    }

    public DateTimeFormatterBuilder() {
        this.f53294a = this;
        this.f53296c = new ArrayList();
        this.f53300g = -1;
        this.f53295b = null;
        this.f53297d = false;
    }

    public DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder) {
        this.f53294a = this;
        this.f53296c = new ArrayList();
        this.f53300g = -1;
        this.f53295b = dateTimeFormatterBuilder;
        this.f53297d = true;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        c(p.INSENSITIVE);
        return this;
    }

    public final void j(j$.time.temporal.n nVar) {
        i(new i(nVar, 1, 19, D.NORMAL));
    }

    public final void k(j$.time.temporal.n nVar, int i2) {
        Objects.requireNonNull(nVar, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
        }
        i(new i(nVar, i2, i2, D.NOT_NEGATIVE));
    }

    public final void l(j$.time.temporal.n nVar, int i2, int i3, D d2) {
        if (i2 == i3 && d2 == D.NOT_NEGATIVE) {
            k(nVar, i3);
            return;
        }
        Objects.requireNonNull(nVar, "field");
        Objects.requireNonNull(d2, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
        i(new i(nVar, i2, i3, d2));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(j$.time.format.i r6) {
        /*
            r5 = this;
            j$.time.format.DateTimeFormatterBuilder r0 = r5.f53294a
            int r1 = r0.f53300g
            if (r1 < 0) goto L3e
            java.util.ArrayList r0 = r0.f53296c
            java.lang.Object r0 = r0.get(r1)
            j$.time.format.i r0 = (j$.time.format.i) r0
            int r2 = r6.f53320b
            int r3 = r6.f53321c
            if (r2 != r3) goto L2a
            j$.time.format.D r2 = j$.time.format.D.NOT_NEGATIVE
            j$.time.format.D r4 = r6.f53322d
            if (r4 != r2) goto L2a
            j$.time.format.i r0 = r0.e(r3)
            j$.time.format.i r6 = r6.d()
            r5.c(r6)
            j$.time.format.DateTimeFormatterBuilder r6 = r5.f53294a
            r6.f53300g = r1
            goto L36
        L2a:
            j$.time.format.i r0 = r0.d()
            j$.time.format.DateTimeFormatterBuilder r2 = r5.f53294a
            int r6 = r5.c(r6)
            r2.f53300g = r6
        L36:
            j$.time.format.DateTimeFormatterBuilder r6 = r5.f53294a
            java.util.ArrayList r6 = r6.f53296c
            r6.set(r1, r0)
            return
        L3e:
            int r6 = r5.c(r6)
            r0.f53300g = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.i(j$.time.format.i):void");
    }

    public final void b(j$.time.temporal.a aVar, int i2, int i3, boolean z) {
        if (i2 == i3 && !z) {
            i(new C0123f(aVar, i2, i3, z));
        } else {
            c(new C0123f(aVar, i2, i3, z));
        }
    }

    public final void h(j$.time.temporal.n nVar, E e2) {
        Objects.requireNonNull(e2, "textStyle");
        c(new q(nVar, e2, z.f53377c));
    }

    public final void g(j$.time.temporal.a aVar, HashMap map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        E e2 = E.FULL;
        c(new q(aVar, e2, new C0118a(new y(Collections.singletonMap(e2, linkedHashMap)))));
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        c(j.f53325e);
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        c(new j(str, str2));
        return this;
    }

    public final void f(E e2) {
        Objects.requireNonNull(e2, "style");
        if (e2 != E.FULL && e2 != E.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        c(new h(e2, 0));
    }

    public final void d(char c2) {
        c(new C0120c(c2));
    }

    public final void e(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            c(new C0120c(str.charAt(0)));
        } else {
            c(new h(str, 1));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        C0121d c0121d = dateTimeFormatter.f53286a;
        if (c0121d.f53314b) {
            c0121d = new C0121d(c0121d.f53313a, false);
        }
        c(c0121d);
    }

    public final void n() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f53294a;
        dateTimeFormatterBuilder.f53300g = -1;
        this.f53294a = new DateTimeFormatterBuilder(dateTimeFormatterBuilder);
    }

    public final void m() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f53294a;
        if (dateTimeFormatterBuilder.f53295b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.f53296c.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f53294a;
            C0121d c0121d = new C0121d(dateTimeFormatterBuilder2.f53296c, dateTimeFormatterBuilder2.f53297d);
            this.f53294a = this.f53294a.f53295b;
            c(c0121d);
            return;
        }
        this.f53294a = this.f53294a.f53295b;
    }

    public final int c(InterfaceC0122e interfaceC0122e) {
        Objects.requireNonNull(interfaceC0122e, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f53294a;
        int i2 = dateTimeFormatterBuilder.f53298e;
        if (i2 > 0) {
            k kVar = new k(interfaceC0122e, i2, dateTimeFormatterBuilder.f53299f);
            dateTimeFormatterBuilder.f53298e = 0;
            dateTimeFormatterBuilder.f53299f = (char) 0;
            interfaceC0122e = kVar;
        }
        dateTimeFormatterBuilder.f53296c.add(interfaceC0122e);
        this.f53294a.f53300g = -1;
        return r5.f53296c.size() - 1;
    }

    public DateTimeFormatter toFormatter() {
        return p(Locale.getDefault(), C.SMART, null);
    }

    public final DateTimeFormatter o(C c2, j$.time.chrono.r rVar) {
        return p(Locale.getDefault(), c2, rVar);
    }

    public final DateTimeFormatter p(Locale locale, C c2, j$.time.chrono.r rVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f53294a.f53295b != null) {
            m();
        }
        return new DateTimeFormatter(new C0121d(this.f53296c, false), locale, A.f53272a, c2, rVar, null);
    }
}
