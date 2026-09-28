package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Geo implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52831a;

    /* renamed from: b, reason: collision with root package name */
    public String f52832b;

    /* renamed from: c, reason: collision with root package name */
    public String f52833c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f52834d;

    public static final class Deserializer implements JsonDeserializer<Geo> {
        public static Geo b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Geo geo = new Geo();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "region":
                        geo.f52833c = objectReader.a1();
                        break;
                    case "city":
                        geo.f52831a = objectReader.a1();
                        break;
                    case "country_code":
                        geo.f52832b = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            geo.f52834d = concurrentHashMap;
            objectReader.t();
            return geo;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52831a != null) {
            objectWriter.d("city").e(this.f52831a);
        }
        if (this.f52832b != null) {
            objectWriter.d("country_code").e(this.f52832b);
        }
        if (this.f52833c != null) {
            objectWriter.d("region").e(this.f52833c);
        }
        ConcurrentHashMap concurrentHashMap = this.f52834d;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52834d, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
