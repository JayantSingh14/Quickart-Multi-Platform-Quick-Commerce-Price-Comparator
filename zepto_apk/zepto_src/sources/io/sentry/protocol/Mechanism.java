package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Mechanism implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52848a;

    /* renamed from: b, reason: collision with root package name */
    public String f52849b;

    /* renamed from: c, reason: collision with root package name */
    public String f52850c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f52851d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap f52852e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f52853f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f52854g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f52855h;

    public static final class Deserializer implements JsonDeserializer<Mechanism> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            Mechanism mechanism = new Mechanism();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "description":
                        mechanism.f52849b = objectReader.a1();
                        break;
                    case "data":
                        mechanism.f52853f = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "meta":
                        mechanism.f52852e = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "type":
                        mechanism.f52848a = objectReader.a1();
                        break;
                    case "handled":
                        mechanism.f52851d = objectReader.f0();
                        break;
                    case "synthetic":
                        mechanism.f52854g = objectReader.f0();
                        break;
                    case "help_link":
                        mechanism.f52850c = objectReader.a1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            mechanism.f52855h = map;
            return mechanism;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52848a != null) {
            objectWriter.d("type").e(this.f52848a);
        }
        if (this.f52849b != null) {
            objectWriter.d("description").e(this.f52849b);
        }
        if (this.f52850c != null) {
            objectWriter.d("help_link").e(this.f52850c);
        }
        if (this.f52851d != null) {
            objectWriter.d("handled").i(this.f52851d);
        }
        if (this.f52852e != null) {
            objectWriter.d("meta").h(iLogger, this.f52852e);
        }
        if (this.f52853f != null) {
            objectWriter.d("data").h(iLogger, this.f52853f);
        }
        if (this.f52854g != null) {
            objectWriter.d("synthetic").i(this.f52854g);
        }
        HashMap map = this.f52855h;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52855h.get(str));
            }
        }
        objectWriter.t();
    }
}
