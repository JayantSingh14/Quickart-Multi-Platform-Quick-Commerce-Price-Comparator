package io.sentry.protocol;

import com.amazon.apay.hardened.external.model.APayConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Message implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52856a;

    /* renamed from: b, reason: collision with root package name */
    public String f52857b;

    /* renamed from: c, reason: collision with root package name */
    public List f52858c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f52859d;

    public static final class Deserializer implements JsonDeserializer<Message> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Message message = new Message();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "params":
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            message.f52858c = list;
                            break;
                        }
                    case "message":
                        message.f52857b = objectReader.a1();
                        break;
                    case "formatted":
                        message.f52856a = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            message.f52859d = concurrentHashMap;
            objectReader.t();
            return message;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52856a != null) {
            objectWriter.d("formatted").e(this.f52856a);
        }
        if (this.f52857b != null) {
            objectWriter.d(APayConstants.Error.MESSAGE).e(this.f52857b);
        }
        List list = this.f52858c;
        if (list != null && !list.isEmpty()) {
            objectWriter.d("params").h(iLogger, this.f52858c);
        }
        ConcurrentHashMap concurrentHashMap = this.f52859d;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52859d, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
