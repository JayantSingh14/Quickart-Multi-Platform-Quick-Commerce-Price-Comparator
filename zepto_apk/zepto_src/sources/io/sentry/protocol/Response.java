package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class Response implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52884a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f52885b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f52886c;

    /* renamed from: d, reason: collision with root package name */
    public Long f52887d;

    /* renamed from: e, reason: collision with root package name */
    public Object f52888e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f52889f;

    public static final class Deserializer implements JsonDeserializer<Response> {
        public static Response b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Response response = new Response();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "status_code":
                        response.f52886c = objectReader.M0();
                        break;
                    case "data":
                        response.f52888e = objectReader.B1();
                        break;
                    case "headers":
                        Map map = (Map) objectReader.B1();
                        if (map == null) {
                            break;
                        } else {
                            response.f52885b = CollectionUtils.c(map);
                            break;
                        }
                    case "cookies":
                        response.f52884a = objectReader.a1();
                        break;
                    case "body_size":
                        response.f52887d = objectReader.R0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            response.f52889f = concurrentHashMap;
            objectReader.t();
            return response;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    public static final class JsonKeys {
    }

    public Response() {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52884a != null) {
            objectWriter.d("cookies").e(this.f52884a);
        }
        if (this.f52885b != null) {
            objectWriter.d("headers").h(iLogger, this.f52885b);
        }
        if (this.f52886c != null) {
            objectWriter.d("status_code").h(iLogger, this.f52886c);
        }
        if (this.f52887d != null) {
            objectWriter.d("body_size").h(iLogger, this.f52887d);
        }
        if (this.f52888e != null) {
            objectWriter.d("data").h(iLogger, this.f52888e);
        }
        ConcurrentHashMap concurrentHashMap = this.f52889f;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52889f, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public Response(Response response) {
        this.f52884a = response.f52884a;
        this.f52885b = CollectionUtils.c(response.f52885b);
        this.f52889f = CollectionUtils.c(response.f52889f);
        this.f52886c = response.f52886c;
        this.f52887d = response.f52887d;
        this.f52888e = response.f52888e;
    }
}
