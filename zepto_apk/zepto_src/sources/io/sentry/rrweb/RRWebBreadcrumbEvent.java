package io.sentry.rrweb;

import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.a;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class RRWebBreadcrumbEvent extends RRWebEvent implements JsonUnknown, JsonSerializable {

    /* renamed from: c, reason: collision with root package name */
    public String f53020c;

    /* renamed from: d, reason: collision with root package name */
    public double f53021d;

    /* renamed from: e, reason: collision with root package name */
    public String f53022e;

    /* renamed from: f, reason: collision with root package name */
    public String f53023f;

    /* renamed from: g, reason: collision with root package name */
    public String f53024g;

    /* renamed from: h, reason: collision with root package name */
    public SentryLevel f53025h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f53026i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f53027j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f53028k;

    /* renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap f53029l;

    public static final class Deserializer implements JsonDeserializer<RRWebBreadcrumbEvent> {
        public static RRWebBreadcrumbEvent b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            RRWebBreadcrumbEvent rRWebBreadcrumbEvent = new RRWebBreadcrumbEvent();
            new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX2 = objectReader.X();
                strX2.getClass();
                if (strX2.equals("data")) {
                    objectReader.k();
                    ConcurrentHashMap concurrentHashMap = null;
                    while (objectReader.peek() == JsonToken.NAME) {
                        String strX3 = objectReader.X();
                        strX3.getClass();
                        if (strX3.equals(PaymentConstants.PAYLOAD)) {
                            objectReader.k();
                            ConcurrentHashMap concurrentHashMap2 = null;
                            while (objectReader.peek() == JsonToken.NAME) {
                                strX = objectReader.X();
                                strX.getClass();
                                switch (strX) {
                                    case "data":
                                        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c((Map) objectReader.B1());
                                        if (concurrentHashMapC == null) {
                                            break;
                                        } else {
                                            rRWebBreadcrumbEvent.f53026i = concurrentHashMapC;
                                            break;
                                        }
                                    case "type":
                                        rRWebBreadcrumbEvent.f53022e = objectReader.a1();
                                        break;
                                    case "category":
                                        rRWebBreadcrumbEvent.f53023f = objectReader.a1();
                                        break;
                                    case "timestamp":
                                        rRWebBreadcrumbEvent.f53021d = objectReader.nextDouble();
                                        break;
                                    case "level":
                                        try {
                                            new SentryLevel.Deserializer();
                                            rRWebBreadcrumbEvent.f53025h = SentryLevel.valueOf(objectReader.K0().toUpperCase(Locale.ROOT));
                                            break;
                                        } catch (Exception e2) {
                                            iLogger.a(SentryLevel.DEBUG, e2, "Error when deserializing SentryLevel", new Object[0]);
                                            break;
                                        }
                                    case "message":
                                        rRWebBreadcrumbEvent.f53024g = objectReader.a1();
                                        break;
                                    default:
                                        if (concurrentHashMap2 == null) {
                                            concurrentHashMap2 = new ConcurrentHashMap();
                                        }
                                        objectReader.I(iLogger, concurrentHashMap2, strX);
                                        break;
                                }
                            }
                            rRWebBreadcrumbEvent.f53028k = concurrentHashMap2;
                            objectReader.t();
                        } else if (strX3.equals("tag")) {
                            String strA1 = objectReader.a1();
                            if (strA1 == null) {
                                strA1 = "";
                            }
                            rRWebBreadcrumbEvent.f53020c = strA1;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX3);
                        }
                    }
                    rRWebBreadcrumbEvent.f53029l = concurrentHashMap;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebBreadcrumbEvent, strX2, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX2);
                }
            }
            rRWebBreadcrumbEvent.f53027j = map;
            objectReader.t();
            return rRWebBreadcrumbEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public RRWebBreadcrumbEvent() {
        super(RRWebEventType.Custom);
        this.f53020c = "breadcrumb";
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        objectWriter.d("tag").e(this.f53020c);
        objectWriter.d(PaymentConstants.PAYLOAD);
        objectWriter.k();
        if (this.f53022e != null) {
            objectWriter.d("type").e(this.f53022e);
        }
        objectWriter.d("timestamp").h(iLogger, BigDecimal.valueOf(this.f53021d));
        if (this.f53023f != null) {
            objectWriter.d("category").e(this.f53023f);
        }
        if (this.f53024g != null) {
            objectWriter.d(APayConstants.Error.MESSAGE).e(this.f53024g);
        }
        if (this.f53025h != null) {
            objectWriter.d("level").h(iLogger, this.f53025h);
        }
        if (this.f53026i != null) {
            objectWriter.d("data").h(iLogger, this.f53026i);
        }
        ConcurrentHashMap concurrentHashMap = this.f53028k;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f53028k, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
        ConcurrentHashMap concurrentHashMap2 = this.f53029l;
        if (concurrentHashMap2 != null) {
            for (String str2 : concurrentHashMap2.keySet()) {
                a.b(this.f53029l, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
        HashMap map = this.f53027j;
        if (map != null) {
            for (String str3 : map.keySet()) {
                Object obj = this.f53027j.get(str3);
                objectWriter.d(str3);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
    }
}
