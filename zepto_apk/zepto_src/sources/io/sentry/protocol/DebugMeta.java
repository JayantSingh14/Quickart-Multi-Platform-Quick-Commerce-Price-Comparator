package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.SdkInfo;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class DebugMeta implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public SdkInfo f52815a;

    /* renamed from: b, reason: collision with root package name */
    public List f52816b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f52817c;

    public static final class Deserializer implements JsonDeserializer<DebugMeta> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            DebugMeta debugMeta = new DebugMeta();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("images")) {
                    debugMeta.f52816b = objectReader.I1(iLogger, new DebugImage.Deserializer());
                } else if (strX.equals("sdk_info")) {
                    debugMeta.f52815a = (SdkInfo) objectReader.o0(iLogger, new SdkInfo.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            objectReader.t();
            debugMeta.f52817c = map;
            return debugMeta;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52815a != null) {
            objectWriter.d("sdk_info").h(iLogger, this.f52815a);
        }
        if (this.f52816b != null) {
            objectWriter.d("images").h(iLogger, this.f52816b);
        }
        HashMap map = this.f52817c;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52817c.get(str));
            }
        }
        objectWriter.t();
    }
}
