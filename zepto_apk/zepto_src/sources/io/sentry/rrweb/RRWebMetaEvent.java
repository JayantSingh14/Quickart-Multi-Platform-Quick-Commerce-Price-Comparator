package io.sentry.rrweb;

import com.swmansion.reanimated.layoutReanimation.Snapshot;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class RRWebMetaEvent extends RRWebEvent implements JsonUnknown, JsonSerializable {

    /* renamed from: c, reason: collision with root package name */
    public String f53050c;

    /* renamed from: d, reason: collision with root package name */
    public int f53051d;

    /* renamed from: e, reason: collision with root package name */
    public int f53052e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f53053f;

    public static final class Deserializer implements JsonDeserializer<RRWebMetaEvent> {
        public static RRWebMetaEvent b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            RRWebMetaEvent rRWebMetaEvent = new RRWebMetaEvent();
            new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX2 = objectReader.X();
                strX2.getClass();
                if (strX2.equals("data")) {
                    objectReader.k();
                    AbstractMap concurrentHashMap = null;
                    while (objectReader.peek() == JsonToken.NAME) {
                        strX = objectReader.X();
                        strX.getClass();
                        switch (strX) {
                            case "height":
                                Integer numM0 = objectReader.M0();
                                rRWebMetaEvent.f53051d = numM0 == null ? 0 : numM0.intValue();
                                break;
                            case "href":
                                String strA1 = objectReader.a1();
                                if (strA1 == null) {
                                    strA1 = "";
                                }
                                rRWebMetaEvent.f53050c = strA1;
                                break;
                            case "width":
                                Integer numM02 = objectReader.M0();
                                rRWebMetaEvent.f53052e = numM02 == null ? 0 : numM02.intValue();
                                break;
                            default:
                                if (concurrentHashMap == null) {
                                    concurrentHashMap = new ConcurrentHashMap();
                                }
                                objectReader.I(iLogger, concurrentHashMap, strX);
                                break;
                        }
                    }
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebMetaEvent, strX2, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX2);
                }
            }
            rRWebMetaEvent.f53053f = map;
            objectReader.t();
            return rRWebMetaEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public RRWebMetaEvent() {
        super(RRWebEventType.Meta);
        this.f53050c = "";
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RRWebMetaEvent.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        RRWebMetaEvent rRWebMetaEvent = (RRWebMetaEvent) obj;
        return this.f53051d == rRWebMetaEvent.f53051d && this.f53052e == rRWebMetaEvent.f53052e && Objects.a(this.f53050c, rRWebMetaEvent.f53050c);
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.f53050c, Integer.valueOf(this.f53051d), Integer.valueOf(this.f53052e)});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        objectWriter.d("href").e(this.f53050c);
        objectWriter.d(Snapshot.HEIGHT).a(this.f53051d);
        objectWriter.d(Snapshot.WIDTH).a(this.f53052e);
        HashMap map = this.f53053f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f53053f.get(str);
                objectWriter.d(str);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
        objectWriter.t();
    }
}
