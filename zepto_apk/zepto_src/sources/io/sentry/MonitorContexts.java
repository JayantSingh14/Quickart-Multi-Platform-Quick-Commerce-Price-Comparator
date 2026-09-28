package io.sentry;

import io.sentry.SpanContext;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class MonitorContexts extends ConcurrentHashMap<String, Object> implements JsonSerializable {

    public static final class Deserializer implements JsonDeserializer<MonitorContexts> {
        public static MonitorContexts b(ObjectReader objectReader, ILogger iLogger) {
            MonitorContexts monitorContexts = new MonitorContexts();
            objectReader.k();
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("trace")) {
                    new SpanContext.Deserializer();
                    monitorContexts.put("trace", SpanContext.Deserializer.b(objectReader, iLogger));
                } else {
                    Object objB1 = objectReader.B1();
                    if (objB1 != null) {
                        monitorContexts.put(strX, objB1);
                    }
                }
            }
            objectReader.t();
            return monitorContexts;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                objectWriter.d(str).h(iLogger, obj);
            }
        }
        objectWriter.t();
    }
}
