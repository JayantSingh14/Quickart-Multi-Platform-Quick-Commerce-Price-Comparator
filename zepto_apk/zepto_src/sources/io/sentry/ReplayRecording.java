package io.sentry;

import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEventType;
import io.sentry.rrweb.RRWebIncrementalSnapshotEvent;
import io.sentry.rrweb.RRWebInteractionEvent;
import io.sentry.rrweb.RRWebInteractionMoveEvent;
import io.sentry.rrweb.RRWebMetaEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import io.sentry.util.MapObjectReader;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReplayRecording implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public Integer f51751a;

    /* renamed from: b, reason: collision with root package name */
    public List f51752b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f51753c;

    /* renamed from: io.sentry.ReplayRecording$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51754a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f51755b;

        static {
            int[] iArr = new int[RRWebEventType.values().length];
            f51755b = iArr;
            try {
                iArr[RRWebEventType.IncrementalSnapshot.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51755b[RRWebEventType.Meta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51755b[RRWebEventType.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[RRWebIncrementalSnapshotEvent.IncrementalSource.values().length];
            f51754a = iArr2;
            try {
                iArr2[RRWebIncrementalSnapshotEvent.IncrementalSource.MouseInteraction.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f51754a[RRWebIncrementalSnapshotEvent.IncrementalSource.TouchMove.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final class Deserializer implements JsonDeserializer<ReplayRecording> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            ReplayRecording replayRecording = new ReplayRecording();
            objectReader.k();
            ArrayList arrayList = null;
            HashMap map = null;
            Integer numM0 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("segment_id")) {
                    numM0 = objectReader.M0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            objectReader.t();
            objectReader.p(true);
            List list = (List) objectReader.B1();
            objectReader.p(false);
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        MapObjectReader mapObjectReader = new MapObjectReader(map2);
                        for (Map.Entry entry : map2.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (str.equals("type")) {
                                RRWebEventType rRWebEventType = RRWebEventType.values()[((Integer) value).intValue()];
                                int i2 = AnonymousClass1.f51755b[rRWebEventType.ordinal()];
                                if (i2 == 1) {
                                    Map map3 = (Map) map2.get("data");
                                    if (map3 == null) {
                                        map3 = Collections.EMPTY_MAP;
                                    }
                                    Integer num = (Integer) map3.get("source");
                                    if (num != null) {
                                        RRWebIncrementalSnapshotEvent.IncrementalSource incrementalSource = RRWebIncrementalSnapshotEvent.IncrementalSource.values()[num.intValue()];
                                        int i3 = AnonymousClass1.f51754a[incrementalSource.ordinal()];
                                        if (i3 == 1) {
                                            new RRWebInteractionEvent.Deserializer();
                                            arrayList.add(RRWebInteractionEvent.Deserializer.b(mapObjectReader, iLogger));
                                        } else if (i3 != 2) {
                                            iLogger.c(SentryLevel.DEBUG, "Unsupported rrweb incremental snapshot type %s", incrementalSource);
                                        } else {
                                            new RRWebInteractionMoveEvent.Deserializer();
                                            arrayList.add(RRWebInteractionMoveEvent.Deserializer.b(mapObjectReader, iLogger));
                                        }
                                    }
                                } else if (i2 == 2) {
                                    new RRWebMetaEvent.Deserializer();
                                    arrayList.add(RRWebMetaEvent.Deserializer.b(mapObjectReader, iLogger));
                                } else if (i2 != 3) {
                                    iLogger.c(SentryLevel.DEBUG, "Unsupported rrweb event type %s", rRWebEventType);
                                } else {
                                    Map map4 = (Map) map2.get("data");
                                    if (map4 == null) {
                                        map4 = Collections.EMPTY_MAP;
                                    }
                                    String str2 = (String) map4.get("tag");
                                    if (str2 != null) {
                                        switch (str2) {
                                            case "performanceSpan":
                                                new RRWebSpanEvent.Deserializer();
                                                arrayList.add(RRWebSpanEvent.Deserializer.b(mapObjectReader, iLogger));
                                                break;
                                            case "video":
                                                new RRWebVideoEvent.Deserializer();
                                                arrayList.add(RRWebVideoEvent.Deserializer.b(mapObjectReader, iLogger));
                                                break;
                                            case "breadcrumb":
                                                new RRWebBreadcrumbEvent.Deserializer();
                                                arrayList.add(RRWebBreadcrumbEvent.Deserializer.b(mapObjectReader, iLogger));
                                                break;
                                            default:
                                                iLogger.c(SentryLevel.DEBUG, "Unsupported rrweb event type %s", rRWebEventType);
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            replayRecording.f51751a = numM0;
            replayRecording.f51752b = arrayList;
            replayRecording.f51753c = map;
            return replayRecording;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ReplayRecording.class == obj.getClass()) {
            ReplayRecording replayRecording = (ReplayRecording) obj;
            if (Objects.a(this.f51751a, replayRecording.f51751a) && Objects.a(this.f51752b, replayRecording.f51752b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f51751a, this.f51752b});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f51751a != null) {
            objectWriter.d("segment_id").f(this.f51751a);
        }
        HashMap map = this.f51753c;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f51753c.get(str));
            }
        }
        objectWriter.t();
        objectWriter.p(true);
        if (this.f51751a != null) {
            objectWriter.g();
        }
        List list = this.f51752b;
        if (list != null) {
            objectWriter.h(iLogger, list);
        }
        objectWriter.p(false);
    }
}
