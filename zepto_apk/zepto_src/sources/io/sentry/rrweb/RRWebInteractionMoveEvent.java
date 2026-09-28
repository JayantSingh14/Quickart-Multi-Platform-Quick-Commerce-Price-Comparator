package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebIncrementalSnapshotEvent;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class RRWebInteractionMoveEvent extends RRWebIncrementalSnapshotEvent implements JsonSerializable, JsonUnknown {

    /* renamed from: d, reason: collision with root package name */
    public int f53041d;

    /* renamed from: e, reason: collision with root package name */
    public List f53042e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f53043f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f53044g;

    public static final class Deserializer implements JsonDeserializer<RRWebInteractionMoveEvent> {
        public static RRWebInteractionMoveEvent b(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            RRWebInteractionMoveEvent rRWebInteractionMoveEvent = new RRWebInteractionMoveEvent();
            new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("data")) {
                    new RRWebIncrementalSnapshotEvent.Deserializer();
                    objectReader.k();
                    HashMap map2 = null;
                    while (objectReader.peek() == JsonToken.NAME) {
                        String strX2 = objectReader.X();
                        strX2.getClass();
                        if (strX2.equals("pointerId")) {
                            rRWebInteractionMoveEvent.f53041d = objectReader.nextInt();
                        } else if (strX2.equals("positions")) {
                            rRWebInteractionMoveEvent.f53042e = objectReader.I1(iLogger, new Position.Deserializer());
                        } else if (!RRWebIncrementalSnapshotEvent.Deserializer.a(rRWebInteractionMoveEvent, strX2, objectReader, iLogger)) {
                            if (map2 == null) {
                                map2 = new HashMap();
                            }
                            objectReader.I(iLogger, map2, strX2);
                        }
                    }
                    rRWebInteractionMoveEvent.f53044g = map2;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebInteractionMoveEvent, strX, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            rRWebInteractionMoveEvent.f53043f = map;
            objectReader.t();
            return rRWebInteractionMoveEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    /* loaded from: classes3.dex */
    public static final class Position implements JsonSerializable, JsonUnknown {

        /* renamed from: a, reason: collision with root package name */
        public int f53045a;

        /* renamed from: b, reason: collision with root package name */
        public float f53046b;

        /* renamed from: c, reason: collision with root package name */
        public float f53047c;

        /* renamed from: d, reason: collision with root package name */
        public long f53048d;

        /* renamed from: e, reason: collision with root package name */
        public HashMap f53049e;

        public static final class Deserializer implements JsonDeserializer<Position> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                String strX;
                objectReader.k();
                Position position = new Position();
                HashMap map = null;
                while (objectReader.peek() == JsonToken.NAME) {
                    strX = objectReader.X();
                    strX.getClass();
                    switch (strX) {
                        case "x":
                            position.f53046b = objectReader.nextFloat();
                            break;
                        case "y":
                            position.f53047c = objectReader.nextFloat();
                            break;
                        case "id":
                            position.f53045a = objectReader.nextInt();
                            break;
                        case "timeOffset":
                            position.f53048d = objectReader.nextLong();
                            break;
                        default:
                            if (map == null) {
                                map = new HashMap();
                            }
                            objectReader.I(iLogger, map, strX);
                            break;
                    }
                }
                position.f53049e = map;
                objectReader.t();
                return position;
            }
        }

        public static final class JsonKeys {
        }

        @Override // io.sentry.JsonSerializable
        public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.k();
            objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).a(this.f53045a);
            objectWriter.d("x").b(this.f53046b);
            objectWriter.d("y").b(this.f53047c);
            objectWriter.d("timeOffset").a(this.f53048d);
            HashMap map = this.f53049e;
            if (map != null) {
                for (String str : map.keySet()) {
                    Object obj = this.f53049e.get(str);
                    objectWriter.d(str);
                    objectWriter.h(iLogger, obj);
                }
            }
            objectWriter.t();
        }
    }

    public RRWebInteractionMoveEvent() {
        super(RRWebIncrementalSnapshotEvent.IncrementalSource.TouchMove);
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        new RRWebEvent.Serializer();
        RRWebEvent.Serializer.a(this, objectWriter, iLogger);
        objectWriter.d("data");
        objectWriter.k();
        new RRWebIncrementalSnapshotEvent.Serializer();
        RRWebIncrementalSnapshotEvent.Serializer.a(this, objectWriter, iLogger);
        List list = this.f53042e;
        if (list != null && !list.isEmpty()) {
            objectWriter.d("positions").h(iLogger, this.f53042e);
        }
        objectWriter.d("pointerId").a(this.f53041d);
        HashMap map = this.f53044g;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f53044g.get(str);
                objectWriter.d(str);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
        HashMap map2 = this.f53043f;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                Object obj2 = this.f53043f.get(str2);
                objectWriter.d(str2);
                objectWriter.h(iLogger, obj2);
            }
        }
        objectWriter.t();
    }
}
