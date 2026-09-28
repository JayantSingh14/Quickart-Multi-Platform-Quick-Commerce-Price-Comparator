package io.sentry;

import com.amazon.apay.hardened.external.model.APayConstants;
import io.sentry.SentryLevel;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Breadcrumb implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Long f51555a;

    /* renamed from: b, reason: collision with root package name */
    public Date f51556b;

    /* renamed from: c, reason: collision with root package name */
    public String f51557c;

    /* renamed from: d, reason: collision with root package name */
    public String f51558d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap f51559e;

    /* renamed from: f, reason: collision with root package name */
    public String f51560f;

    /* renamed from: g, reason: collision with root package name */
    public String f51561g;

    /* renamed from: h, reason: collision with root package name */
    public SentryLevel f51562h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f51563i;

    public static final class Deserializer implements JsonDeserializer<Breadcrumb> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Date dateA = DateUtils.a();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            String strA1 = null;
            String strA12 = null;
            String strA13 = null;
            String strA14 = null;
            SentryLevel sentryLevelValueOf = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "origin":
                        strA14 = objectReader.a1();
                        break;
                    case "data":
                        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c((Map) objectReader.B1());
                        if (concurrentHashMapC == null) {
                            break;
                        } else {
                            concurrentHashMap = concurrentHashMapC;
                            break;
                        }
                    case "type":
                        strA12 = objectReader.a1();
                        break;
                    case "category":
                        strA13 = objectReader.a1();
                        break;
                    case "timestamp":
                        Date dateC0 = objectReader.c0(iLogger);
                        if (dateC0 == null) {
                            break;
                        } else {
                            dateA = dateC0;
                            break;
                        }
                    case "level":
                        try {
                            new SentryLevel.Deserializer();
                            sentryLevelValueOf = SentryLevel.valueOf(objectReader.K0().toUpperCase(Locale.ROOT));
                            break;
                        } catch (Exception e2) {
                            iLogger.a(SentryLevel.ERROR, e2, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                    case "message":
                        strA1 = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap2, strX);
                        break;
                }
            }
            Breadcrumb breadcrumb = new Breadcrumb(dateA);
            breadcrumb.f51557c = strA1;
            breadcrumb.f51558d = strA12;
            breadcrumb.f51559e = concurrentHashMap;
            breadcrumb.f51560f = strA13;
            breadcrumb.f51561g = strA14;
            breadcrumb.f51562h = sentryLevelValueOf;
            breadcrumb.f51563i = concurrentHashMap2;
            objectReader.t();
            return breadcrumb;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public Breadcrumb(Date date) {
        this.f51559e = new ConcurrentHashMap();
        this.f51556b = date;
        this.f51555a = null;
    }

    public final Date a() {
        Date date = this.f51556b;
        if (date != null) {
            return (Date) date.clone();
        }
        Long l2 = this.f51555a;
        if (l2 == null) {
            throw new IllegalStateException("No timestamp set for breadcrumb");
        }
        Date dateB = DateUtils.b(l2.longValue());
        this.f51556b = dateB;
        return dateB;
    }

    public final void b(Object obj, String str) {
        this.f51559e.put(str, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Breadcrumb.class == obj.getClass()) {
            Breadcrumb breadcrumb = (Breadcrumb) obj;
            if (a().getTime() == breadcrumb.a().getTime() && Objects.a(this.f51557c, breadcrumb.f51557c) && Objects.a(this.f51558d, breadcrumb.f51558d) && Objects.a(this.f51560f, breadcrumb.f51560f) && Objects.a(this.f51561g, breadcrumb.f51561g) && this.f51562h == breadcrumb.f51562h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f51556b, this.f51557c, this.f51558d, this.f51560f, this.f51561g, this.f51562h});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("timestamp").h(iLogger, a());
        if (this.f51557c != null) {
            objectWriter.d(APayConstants.Error.MESSAGE).e(this.f51557c);
        }
        if (this.f51558d != null) {
            objectWriter.d("type").e(this.f51558d);
        }
        objectWriter.d("data").h(iLogger, this.f51559e);
        if (this.f51560f != null) {
            objectWriter.d("category").e(this.f51560f);
        }
        if (this.f51561g != null) {
            objectWriter.d("origin").e(this.f51561g);
        }
        if (this.f51562h != null) {
            objectWriter.d("level").h(iLogger, this.f51562h);
        }
        ConcurrentHashMap concurrentHashMap = this.f51563i;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f51563i, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public Breadcrumb(long j2) {
        this.f51559e = new ConcurrentHashMap();
        this.f51555a = Long.valueOf(j2);
        this.f51556b = null;
    }

    public Breadcrumb(Breadcrumb breadcrumb) {
        this.f51559e = new ConcurrentHashMap();
        this.f51556b = breadcrumb.f51556b;
        this.f51555a = breadcrumb.f51555a;
        this.f51557c = breadcrumb.f51557c;
        this.f51558d = breadcrumb.f51558d;
        this.f51560f = breadcrumb.f51560f;
        this.f51561g = breadcrumb.f51561g;
        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c(breadcrumb.f51559e);
        if (concurrentHashMapC != null) {
            this.f51559e = concurrentHashMapC;
        }
        this.f51563i = CollectionUtils.c(breadcrumb.f51563i);
        this.f51562h = breadcrumb.f51562h;
    }

    public Breadcrumb() {
        this(System.currentTimeMillis());
    }
}
