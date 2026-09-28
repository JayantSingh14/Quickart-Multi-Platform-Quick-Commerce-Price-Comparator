package io.sentry.rrweb;

import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class RRWebSpanEvent extends RRWebEvent implements JsonSerializable, JsonUnknown {

    /* renamed from: c, reason: collision with root package name */
    public String f53058c;

    /* renamed from: d, reason: collision with root package name */
    public String f53059d;

    /* renamed from: e, reason: collision with root package name */
    public String f53060e;

    /* renamed from: f, reason: collision with root package name */
    public double f53061f;

    /* renamed from: g, reason: collision with root package name */
    public double f53062g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap f53063h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap f53064i;

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap f53065j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f53066k;

    public static final class Deserializer implements JsonDeserializer<RRWebSpanEvent> {
        public static RRWebSpanEvent b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
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
                                    case "description":
                                        rRWebSpanEvent.f53060e = objectReader.a1();
                                        break;
                                    case "endTimestamp":
                                        rRWebSpanEvent.f53062g = objectReader.nextDouble();
                                        break;
                                    case "startTimestamp":
                                        rRWebSpanEvent.f53061f = objectReader.nextDouble();
                                        break;
                                    case "op":
                                        rRWebSpanEvent.f53059d = objectReader.a1();
                                        break;
                                    case "data":
                                        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c((Map) objectReader.B1());
                                        if (concurrentHashMapC == null) {
                                            break;
                                        } else {
                                            rRWebSpanEvent.f53063h = concurrentHashMapC;
                                            break;
                                        }
                                    default:
                                        if (concurrentHashMap2 == null) {
                                            concurrentHashMap2 = new ConcurrentHashMap();
                                        }
                                        objectReader.I(iLogger, concurrentHashMap2, strX);
                                        break;
                                }
                            }
                            rRWebSpanEvent.f53065j = concurrentHashMap2;
                            objectReader.t();
                        } else if (strX3.equals("tag")) {
                            String strA1 = objectReader.a1();
                            if (strA1 == null) {
                                strA1 = "";
                            }
                            rRWebSpanEvent.f53058c = strA1;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX3);
                        }
                    }
                    rRWebSpanEvent.f53066k = concurrentHashMap;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebSpanEvent, strX2, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX2);
                }
            }
            rRWebSpanEvent.f53064i = map;
            objectReader.t();
            return rRWebSpanEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public RRWebSpanEvent() {
        super(RRWebEventType.Custom);
        this.f53058c = "performanceSpan";
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        objectWriter.d("tag").e(this.f53058c);
        objectWriter.d(PaymentConstants.PAYLOAD);
        objectWriter.k();
        if (this.f53059d != null) {
            objectWriter.d("op").e(this.f53059d);
        }
        if (this.f53060e != null) {
            objectWriter.d("description").e(this.f53060e);
        }
        objectWriter.d("startTimestamp").h(iLogger, BigDecimal.valueOf(this.f53061f));
        objectWriter.d("endTimestamp").h(iLogger, BigDecimal.valueOf(this.f53062g));
        if (this.f53063h != null) {
            objectWriter.d("data").h(iLogger, this.f53063h);
        }
        ConcurrentHashMap concurrentHashMap = this.f53065j;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f53065j, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
        ConcurrentHashMap concurrentHashMap2 = this.f53066k;
        if (concurrentHashMap2 != null) {
            for (String str2 : concurrentHashMap2.keySet()) {
                a.b(this.f53066k, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
        HashMap map = this.f53064i;
        if (map != null) {
            for (String str3 : map.keySet()) {
                Object obj = this.f53064i.get(str3);
                objectWriter.d(str3);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
    }
}
