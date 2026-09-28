package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Request implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52872a;

    /* renamed from: b, reason: collision with root package name */
    public String f52873b;

    /* renamed from: c, reason: collision with root package name */
    public String f52874c;

    /* renamed from: d, reason: collision with root package name */
    public Object f52875d;

    /* renamed from: e, reason: collision with root package name */
    public String f52876e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f52877f;

    /* renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap f52878g;

    /* renamed from: h, reason: collision with root package name */
    public Long f52879h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f52880i;

    /* renamed from: j, reason: collision with root package name */
    public String f52881j;

    /* renamed from: k, reason: collision with root package name */
    public String f52882k;

    /* renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap f52883l;

    public static final class Deserializer implements JsonDeserializer<Request> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Request request = new Request();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "fragment":
                        request.f52881j = objectReader.a1();
                        break;
                    case "method":
                        request.f52873b = objectReader.a1();
                        break;
                    case "env":
                        Map map = (Map) objectReader.B1();
                        if (map == null) {
                            break;
                        } else {
                            request.f52878g = CollectionUtils.c(map);
                            break;
                        }
                    case "url":
                        request.f52872a = objectReader.a1();
                        break;
                    case "data":
                        request.f52875d = objectReader.B1();
                        break;
                    case "other":
                        Map map2 = (Map) objectReader.B1();
                        if (map2 == null) {
                            break;
                        } else {
                            request.f52880i = CollectionUtils.c(map2);
                            break;
                        }
                    case "headers":
                        Map map3 = (Map) objectReader.B1();
                        if (map3 == null) {
                            break;
                        } else {
                            request.f52877f = CollectionUtils.c(map3);
                            break;
                        }
                    case "cookies":
                        request.f52876e = objectReader.a1();
                        break;
                    case "body_size":
                        request.f52879h = objectReader.R0();
                        break;
                    case "query_string":
                        request.f52874c = objectReader.a1();
                        break;
                    case "api_target":
                        request.f52882k = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            request.f52883l = concurrentHashMap;
            objectReader.t();
            return request;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Request.class != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        return Objects.a(this.f52872a, request.f52872a) && Objects.a(this.f52873b, request.f52873b) && Objects.a(this.f52874c, request.f52874c) && Objects.a(this.f52876e, request.f52876e) && Objects.a(this.f52877f, request.f52877f) && Objects.a(this.f52878g, request.f52878g) && Objects.a(this.f52879h, request.f52879h) && Objects.a(this.f52881j, request.f52881j) && Objects.a(this.f52882k, request.f52882k);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52872a, this.f52873b, this.f52874c, this.f52876e, this.f52877f, this.f52878g, this.f52879h, this.f52881j, this.f52882k});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52872a != null) {
            objectWriter.d("url").e(this.f52872a);
        }
        if (this.f52873b != null) {
            objectWriter.d("method").e(this.f52873b);
        }
        if (this.f52874c != null) {
            objectWriter.d("query_string").e(this.f52874c);
        }
        if (this.f52875d != null) {
            objectWriter.d("data").h(iLogger, this.f52875d);
        }
        if (this.f52876e != null) {
            objectWriter.d("cookies").e(this.f52876e);
        }
        if (this.f52877f != null) {
            objectWriter.d("headers").h(iLogger, this.f52877f);
        }
        if (this.f52878g != null) {
            objectWriter.d("env").h(iLogger, this.f52878g);
        }
        if (this.f52880i != null) {
            objectWriter.d("other").h(iLogger, this.f52880i);
        }
        if (this.f52881j != null) {
            objectWriter.d("fragment").h(iLogger, this.f52881j);
        }
        if (this.f52879h != null) {
            objectWriter.d("body_size").h(iLogger, this.f52879h);
        }
        if (this.f52882k != null) {
            objectWriter.d("api_target").h(iLogger, this.f52882k);
        }
        ConcurrentHashMap concurrentHashMap = this.f52883l;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52883l, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
