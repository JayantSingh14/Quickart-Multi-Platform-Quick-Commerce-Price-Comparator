package io.sentry.rrweb;

import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class RRWebVideoEvent extends RRWebEvent implements JsonUnknown, JsonSerializable {

    /* renamed from: c, reason: collision with root package name */
    public String f53067c;

    /* renamed from: d, reason: collision with root package name */
    public int f53068d;

    /* renamed from: e, reason: collision with root package name */
    public long f53069e;

    /* renamed from: f, reason: collision with root package name */
    public long f53070f;

    /* renamed from: g, reason: collision with root package name */
    public String f53071g;

    /* renamed from: h, reason: collision with root package name */
    public String f53072h;

    /* renamed from: i, reason: collision with root package name */
    public int f53073i;

    /* renamed from: j, reason: collision with root package name */
    public int f53074j;

    /* renamed from: k, reason: collision with root package name */
    public int f53075k;

    /* renamed from: l, reason: collision with root package name */
    public String f53076l;

    /* renamed from: m, reason: collision with root package name */
    public int f53077m;
    public int n;
    public int o;
    public HashMap p;
    public ConcurrentHashMap q;
    public ConcurrentHashMap r;

    public static final class Deserializer implements JsonDeserializer<RRWebVideoEvent> {
        public static RRWebVideoEvent b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            RRWebVideoEvent rRWebVideoEvent = new RRWebVideoEvent();
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
                                    case "duration":
                                        rRWebVideoEvent.f53070f = objectReader.nextLong();
                                        break;
                                    case "segmentId":
                                        rRWebVideoEvent.f53068d = objectReader.nextInt();
                                        break;
                                    case "height":
                                        Integer numM0 = objectReader.M0();
                                        rRWebVideoEvent.f53073i = numM0 == null ? 0 : numM0.intValue();
                                        break;
                                    case "container":
                                        String strA1 = objectReader.a1();
                                        if (strA1 == null) {
                                            strA1 = "";
                                        }
                                        rRWebVideoEvent.f53072h = strA1;
                                        break;
                                    case "frameCount":
                                        Integer numM02 = objectReader.M0();
                                        rRWebVideoEvent.f53075k = numM02 == null ? 0 : numM02.intValue();
                                        break;
                                    case "top":
                                        Integer numM03 = objectReader.M0();
                                        rRWebVideoEvent.o = numM03 == null ? 0 : numM03.intValue();
                                        break;
                                    case "left":
                                        Integer numM04 = objectReader.M0();
                                        rRWebVideoEvent.n = numM04 == null ? 0 : numM04.intValue();
                                        break;
                                    case "size":
                                        Long lR0 = objectReader.R0();
                                        rRWebVideoEvent.f53069e = lR0 == null ? 0L : lR0.longValue();
                                        break;
                                    case "width":
                                        Integer numM05 = objectReader.M0();
                                        rRWebVideoEvent.f53074j = numM05 == null ? 0 : numM05.intValue();
                                        break;
                                    case "frameRate":
                                        Integer numM06 = objectReader.M0();
                                        rRWebVideoEvent.f53077m = numM06 == null ? 0 : numM06.intValue();
                                        break;
                                    case "encoding":
                                        String strA12 = objectReader.a1();
                                        if (strA12 == null) {
                                            strA12 = "";
                                        }
                                        rRWebVideoEvent.f53071g = strA12;
                                        break;
                                    case "frameRateType":
                                        String strA13 = objectReader.a1();
                                        if (strA13 == null) {
                                            strA13 = "";
                                        }
                                        rRWebVideoEvent.f53076l = strA13;
                                        break;
                                    default:
                                        if (concurrentHashMap2 == null) {
                                            concurrentHashMap2 = new ConcurrentHashMap();
                                        }
                                        objectReader.I(iLogger, concurrentHashMap2, strX);
                                        break;
                                }
                            }
                            rRWebVideoEvent.q = concurrentHashMap2;
                            objectReader.t();
                        } else if (strX3.equals("tag")) {
                            String strA14 = objectReader.a1();
                            rRWebVideoEvent.f53067c = strA14 != null ? strA14 : "";
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX3);
                        }
                    }
                    rRWebVideoEvent.r = concurrentHashMap;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebVideoEvent, strX2, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX2);
                }
            }
            rRWebVideoEvent.p = map;
            objectReader.t();
            return rRWebVideoEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public RRWebVideoEvent() {
        super(RRWebEventType.Custom);
        this.f53071g = "h264";
        this.f53072h = "mp4";
        this.f53076l = "constant";
        this.f53067c = "video";
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RRWebVideoEvent.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        RRWebVideoEvent rRWebVideoEvent = (RRWebVideoEvent) obj;
        return this.f53068d == rRWebVideoEvent.f53068d && this.f53069e == rRWebVideoEvent.f53069e && this.f53070f == rRWebVideoEvent.f53070f && this.f53073i == rRWebVideoEvent.f53073i && this.f53074j == rRWebVideoEvent.f53074j && this.f53075k == rRWebVideoEvent.f53075k && this.f53077m == rRWebVideoEvent.f53077m && this.n == rRWebVideoEvent.n && this.o == rRWebVideoEvent.o && Objects.a(this.f53067c, rRWebVideoEvent.f53067c) && Objects.a(this.f53071g, rRWebVideoEvent.f53071g) && Objects.a(this.f53072h, rRWebVideoEvent.f53072h) && Objects.a(this.f53076l, rRWebVideoEvent.f53076l);
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.f53067c, Integer.valueOf(this.f53068d), Long.valueOf(this.f53069e), Long.valueOf(this.f53070f), this.f53071g, this.f53072h, Integer.valueOf(this.f53073i), Integer.valueOf(this.f53074j), Integer.valueOf(this.f53075k), this.f53076l, Integer.valueOf(this.f53077m), Integer.valueOf(this.n), Integer.valueOf(this.o)});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        objectWriter.d("tag").e(this.f53067c);
        objectWriter.d(PaymentConstants.PAYLOAD);
        objectWriter.k();
        objectWriter.d("segmentId").a(this.f53068d);
        objectWriter.d("size").a(this.f53069e);
        objectWriter.d("duration").a(this.f53070f);
        objectWriter.d("encoding").e(this.f53071g);
        objectWriter.d("container").e(this.f53072h);
        objectWriter.d(Snapshot.HEIGHT).a(this.f53073i);
        objectWriter.d(Snapshot.WIDTH).a(this.f53074j);
        objectWriter.d("frameCount").a(this.f53075k);
        objectWriter.d("frameRate").a(this.f53077m);
        objectWriter.d("frameRateType").e(this.f53076l);
        objectWriter.d("left").a(this.n);
        objectWriter.d("top").a(this.o);
        ConcurrentHashMap concurrentHashMap = this.q;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.q, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
        ConcurrentHashMap concurrentHashMap2 = this.r;
        if (concurrentHashMap2 != null) {
            for (String str2 : concurrentHashMap2.keySet()) {
                a.b(this.r, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
        HashMap map = this.p;
        if (map != null) {
            for (String str3 : map.keySet()) {
                Object obj = this.p.get(str3);
                objectWriter.d(str3);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
    }
}
