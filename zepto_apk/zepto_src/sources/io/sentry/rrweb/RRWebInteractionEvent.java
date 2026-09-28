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
import java.io.IOException;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class RRWebInteractionEvent extends RRWebIncrementalSnapshotEvent implements JsonSerializable, JsonUnknown {

    /* renamed from: d, reason: collision with root package name */
    public InteractionType f53033d;

    /* renamed from: e, reason: collision with root package name */
    public int f53034e;

    /* renamed from: f, reason: collision with root package name */
    public float f53035f;

    /* renamed from: g, reason: collision with root package name */
    public float f53036g;

    /* renamed from: h, reason: collision with root package name */
    public int f53037h;

    /* renamed from: i, reason: collision with root package name */
    public int f53038i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f53039j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f53040k;

    public static final class Deserializer implements JsonDeserializer<RRWebInteractionEvent> {
        public static RRWebInteractionEvent b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            RRWebInteractionEvent rRWebInteractionEvent = new RRWebInteractionEvent();
            new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX2 = objectReader.X();
                strX2.getClass();
                if (strX2.equals("data")) {
                    new RRWebIncrementalSnapshotEvent.Deserializer();
                    objectReader.k();
                    HashMap map2 = null;
                    while (objectReader.peek() == JsonToken.NAME) {
                        strX = objectReader.X();
                        strX.getClass();
                        switch (strX) {
                            case "x":
                                rRWebInteractionEvent.f53035f = objectReader.nextFloat();
                                break;
                            case "y":
                                rRWebInteractionEvent.f53036g = objectReader.nextFloat();
                                break;
                            case "id":
                                rRWebInteractionEvent.f53034e = objectReader.nextInt();
                                break;
                            case "type":
                                rRWebInteractionEvent.f53033d = (InteractionType) objectReader.o0(iLogger, new InteractionType.Deserializer());
                                break;
                            case "pointerType":
                                rRWebInteractionEvent.f53037h = objectReader.nextInt();
                                break;
                            case "pointerId":
                                rRWebInteractionEvent.f53038i = objectReader.nextInt();
                                break;
                            default:
                                if (!RRWebIncrementalSnapshotEvent.Deserializer.a(rRWebInteractionEvent, strX, objectReader, iLogger)) {
                                    if (map2 == null) {
                                        map2 = new HashMap();
                                    }
                                    objectReader.I(iLogger, map2, strX);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    rRWebInteractionEvent.f53040k = map2;
                    objectReader.t();
                } else if (!RRWebEvent.Deserializer.a(rRWebInteractionEvent, strX2, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX2);
                }
            }
            rRWebInteractionEvent.f53039j = map;
            objectReader.t();
            return rRWebInteractionEvent;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public enum InteractionType implements JsonSerializable {
        MouseUp,
        MouseDown,
        Click,
        ContextMenu,
        DblClick,
        Focus,
        Blur,
        TouchStart,
        TouchMove_Departed,
        TouchEnd,
        TouchCancel;

        public static final class Deserializer implements JsonDeserializer<InteractionType> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                return InteractionType.values()[objectReader.nextInt()];
            }
        }

        @Override // io.sentry.JsonSerializable
        public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.a(ordinal());
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public RRWebInteractionEvent() {
        super(RRWebIncrementalSnapshotEvent.IncrementalSource.MouseInteraction);
        this.f53037h = 2;
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
        objectWriter.d("type").h(iLogger, this.f53033d);
        objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).a(this.f53034e);
        objectWriter.d("x").b(this.f53035f);
        objectWriter.d("y").b(this.f53036g);
        objectWriter.d("pointerType").a(this.f53037h);
        objectWriter.d("pointerId").a(this.f53038i);
        HashMap map = this.f53040k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f53040k.get(str);
                objectWriter.d(str);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
        HashMap map2 = this.f53039j;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                Object obj2 = this.f53039j.get(str2);
                objectWriter.d(str2);
                objectWriter.h(iLogger, obj2);
            }
        }
        objectWriter.t();
    }
}
