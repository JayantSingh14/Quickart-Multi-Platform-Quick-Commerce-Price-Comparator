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
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class RRWebOptionsEvent extends RRWebEvent implements JsonSerializable, JsonUnknown {

    /* renamed from: c, reason: collision with root package name */
    public String f53054c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f53055d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f53056e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f53057f;

    public static final class Deserializer implements JsonDeserializer<RRWebOptionsEvent> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            RRWebOptionsEvent rRWebOptionsEvent = new RRWebOptionsEvent();
            new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("data")) {
                    objectReader.k();
                    ConcurrentHashMap concurrentHashMap = null;
                    while (objectReader.peek() == JsonToken.NAME) {
                        String strX2 = objectReader.X();
                        strX2.getClass();
                        if (strX2.equals(PaymentConstants.PAYLOAD)) {
                            objectReader.k();
                            HashMap map2 = null;
                            while (objectReader.peek() == JsonToken.NAME) {
                                String strX3 = objectReader.X();
                                if (map2 == null) {
                                    map2 = new HashMap();
                                }
                                objectReader.I(iLogger, map2, strX3);
                            }
                            if (map2 != null) {
                                rRWebOptionsEvent.f53055d = map2;
                            }
                            objectReader.t();
                        } else if (strX2.equals("tag")) {
                            String strA1 = objectReader.a1();
                            if (strA1 == null) {
                                strA1 = "";
                            }
                            rRWebOptionsEvent.f53054c = strA1;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX2);
                        }
                    }
                    rRWebOptionsEvent.f53057f = concurrentHashMap;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebOptionsEvent, strX, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            rRWebOptionsEvent.f53056e = map;
            objectReader.t();
            return rRWebOptionsEvent;
        }
    }

    public static final class JsonKeys {
    }

    public RRWebOptionsEvent() {
        super(RRWebEventType.Custom);
        this.f53055d = new HashMap();
        this.f53054c = "options";
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        objectWriter.d("tag").e(this.f53054c);
        objectWriter.d(PaymentConstants.PAYLOAD);
        objectWriter.k();
        HashMap map = this.f53055d;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f53055d.get(str);
                objectWriter.d(str);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
        ConcurrentHashMap concurrentHashMap = this.f53057f;
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                a.b(this.f53057f, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
        HashMap map2 = this.f53056e;
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                Object obj2 = this.f53056e.get(str3);
                objectWriter.d(str3);
                objectWriter.h(iLogger, obj2);
            }
        }
        objectWriter.t();
    }
}
