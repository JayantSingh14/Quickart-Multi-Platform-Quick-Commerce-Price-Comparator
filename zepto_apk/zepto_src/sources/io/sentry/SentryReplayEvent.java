package io.sentry;

import io.sentry.SentryBaseEvent;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class SentryReplayEvent extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    public File p;
    public int t;
    public Date v;
    public HashMap z;
    public SentryId s = new SentryId();
    public String q = "replay_event";
    public ReplayType r = ReplayType.SESSION;
    public List x = new ArrayList();
    public List y = new ArrayList();
    public List w = new ArrayList();
    public Date u = DateUtils.a();

    public static final class Deserializer implements JsonDeserializer<SentryReplayEvent> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            new SentryBaseEvent.Deserializer();
            SentryReplayEvent sentryReplayEvent = new SentryReplayEvent();
            objectReader.k();
            String strA1 = null;
            ReplayType replayType = null;
            Integer numM0 = null;
            Date dateC0 = null;
            HashMap map = null;
            SentryId sentryId = null;
            Date dateC02 = null;
            List list = null;
            List list2 = null;
            List list3 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "replay_id":
                        sentryId = (SentryId) objectReader.o0(iLogger, new SentryId.Deserializer());
                        break;
                    case "replay_start_timestamp":
                        dateC02 = objectReader.c0(iLogger);
                        break;
                    case "type":
                        strA1 = objectReader.a1();
                        break;
                    case "urls":
                        list = (List) objectReader.B1();
                        break;
                    case "timestamp":
                        dateC0 = objectReader.c0(iLogger);
                        break;
                    case "error_ids":
                        list2 = (List) objectReader.B1();
                        break;
                    case "trace_ids":
                        list3 = (List) objectReader.B1();
                        break;
                    case "replay_type":
                        replayType = (ReplayType) objectReader.o0(iLogger, new ReplayType.Deserializer());
                        break;
                    case "segment_id":
                        numM0 = objectReader.M0();
                        break;
                    default:
                        if (!SentryBaseEvent.Deserializer.a(sentryReplayEvent, strX, objectReader, iLogger)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            objectReader.I(iLogger, map, strX);
                            break;
                        } else {
                            break;
                        }
                }
            }
            objectReader.t();
            if (strA1 != null) {
                sentryReplayEvent.q = strA1;
            }
            if (replayType != null) {
                sentryReplayEvent.r = replayType;
            }
            if (numM0 != null) {
                sentryReplayEvent.t = numM0.intValue();
            }
            if (dateC0 != null) {
                sentryReplayEvent.u = dateC0;
            }
            sentryReplayEvent.s = sentryId;
            sentryReplayEvent.v = dateC02;
            sentryReplayEvent.w = list;
            sentryReplayEvent.x = list2;
            sentryReplayEvent.y = list3;
            sentryReplayEvent.z = map;
            return sentryReplayEvent;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    /* loaded from: classes3.dex */
    public enum ReplayType implements JsonSerializable {
        SESSION,
        BUFFER;

        public static final class Deserializer implements JsonDeserializer<ReplayType> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                return ReplayType.valueOf(objectReader.K0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.JsonSerializable
        public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.e(name().toLowerCase(Locale.ROOT));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SentryReplayEvent.class == obj.getClass()) {
            SentryReplayEvent sentryReplayEvent = (SentryReplayEvent) obj;
            if (this.t == sentryReplayEvent.t && Objects.a(this.q, sentryReplayEvent.q) && this.r == sentryReplayEvent.r && Objects.a(this.s, sentryReplayEvent.s) && Objects.a(this.w, sentryReplayEvent.w) && Objects.a(this.x, sentryReplayEvent.x) && Objects.a(this.y, sentryReplayEvent.y)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.q, this.r, this.s, Integer.valueOf(this.t), this.w, this.x, this.y});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("type").e(this.q);
        objectWriter.d("replay_type").h(iLogger, this.r);
        objectWriter.d("segment_id").a(this.t);
        objectWriter.d("timestamp").h(iLogger, this.u);
        if (this.s != null) {
            objectWriter.d("replay_id").h(iLogger, this.s);
        }
        if (this.v != null) {
            objectWriter.d("replay_start_timestamp").h(iLogger, this.v);
        }
        if (this.w != null) {
            objectWriter.d("urls").h(iLogger, this.w);
        }
        if (this.x != null) {
            objectWriter.d("error_ids").h(iLogger, this.x);
        }
        if (this.y != null) {
            objectWriter.d("trace_ids").h(iLogger, this.y);
        }
        new SentryBaseEvent.Serializer();
        SentryBaseEvent.Serializer.a(this, objectWriter, iLogger);
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.z.get(str));
            }
        }
        objectWriter.t();
    }
}
