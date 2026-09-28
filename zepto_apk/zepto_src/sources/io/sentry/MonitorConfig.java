package io.sentry;

import io.sentry.MonitorSchedule;
import io.sentry.SentryOptions;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class MonitorConfig implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public MonitorSchedule f51693a;

    /* renamed from: b, reason: collision with root package name */
    public Long f51694b;

    /* renamed from: c, reason: collision with root package name */
    public Long f51695c;

    /* renamed from: d, reason: collision with root package name */
    public String f51696d;

    /* renamed from: e, reason: collision with root package name */
    public Long f51697e;

    /* renamed from: f, reason: collision with root package name */
    public Long f51698f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f51699g;

    public static final class Deserializer implements JsonDeserializer<MonitorConfig> {
        public static MonitorConfig b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            MonitorSchedule monitorScheduleB = null;
            Long lR0 = null;
            Long lR02 = null;
            String strA1 = null;
            Long lR03 = null;
            Long lR04 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "timezone":
                        strA1 = objectReader.a1();
                        break;
                    case "checkin_margin":
                        lR0 = objectReader.R0();
                        break;
                    case "schedule":
                        new MonitorSchedule.Deserializer();
                        monitorScheduleB = MonitorSchedule.Deserializer.b(objectReader, iLogger);
                        break;
                    case "recovery_threshold":
                        lR04 = objectReader.R0();
                        break;
                    case "max_runtime":
                        lR02 = objectReader.R0();
                        break;
                    case "failure_issue_threshold":
                        lR03 = objectReader.R0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            if (monitorScheduleB == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"schedule\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"schedule\"", illegalStateException);
                throw illegalStateException;
            }
            MonitorConfig monitorConfig = new MonitorConfig();
            monitorConfig.f51693a = monitorScheduleB;
            SentryOptions.Cron cron = HubAdapter.f51658a.y().getCron();
            if (cron != null) {
                monitorConfig.f51694b = cron.f51848a;
                monitorConfig.f51695c = cron.f51849b;
                monitorConfig.f51696d = cron.f51850c;
                monitorConfig.f51697e = cron.f51851d;
                monitorConfig.f51698f = cron.f51852e;
            }
            monitorConfig.f51694b = lR0;
            monitorConfig.f51695c = lR02;
            monitorConfig.f51696d = strA1;
            monitorConfig.f51697e = lR03;
            monitorConfig.f51698f = lR04;
            monitorConfig.f51699g = map;
            return monitorConfig;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("schedule");
        this.f51693a.serialize(objectWriter, iLogger);
        if (this.f51694b != null) {
            objectWriter.d("checkin_margin").f(this.f51694b);
        }
        if (this.f51695c != null) {
            objectWriter.d("max_runtime").f(this.f51695c);
        }
        if (this.f51696d != null) {
            objectWriter.d("timezone").e(this.f51696d);
        }
        if (this.f51697e != null) {
            objectWriter.d("failure_issue_threshold").f(this.f51697e);
        }
        if (this.f51698f != null) {
            objectWriter.d("recovery_threshold").f(this.f51698f);
        }
        HashMap map = this.f51699g;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f51699g.get(str));
            }
        }
        objectWriter.t();
    }
}
