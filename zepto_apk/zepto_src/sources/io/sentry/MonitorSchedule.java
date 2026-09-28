package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class MonitorSchedule implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f51700a;

    /* renamed from: b, reason: collision with root package name */
    public String f51701b;

    /* renamed from: c, reason: collision with root package name */
    public String f51702c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f51703d;

    public static final class Deserializer implements JsonDeserializer<MonitorSchedule> {
        public static MonitorSchedule b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            String strA1 = null;
            String strA12 = null;
            String strA13 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "type":
                        strA1 = objectReader.a1();
                        break;
                    case "unit":
                        strA13 = objectReader.a1();
                        break;
                    case "value":
                        strA12 = objectReader.a1();
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
            if (strA1 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException);
                throw illegalStateException;
            }
            if (strA12 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"value\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException2);
                throw illegalStateException2;
            }
            MonitorSchedule monitorSchedule = new MonitorSchedule();
            monitorSchedule.f51700a = strA1;
            monitorSchedule.f51701b = strA12;
            monitorSchedule.f51702c = strA13;
            monitorSchedule.f51703d = map;
            return monitorSchedule;
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
        ObjectWriter objectWriterD = objectWriter.d("type");
        String str = this.f51700a;
        objectWriterD.e(str);
        boolean zEqualsIgnoreCase = MonitorScheduleType.INTERVAL.apiName().equalsIgnoreCase(str);
        String str2 = this.f51701b;
        if (zEqualsIgnoreCase) {
            try {
                objectWriter.d(CLConstants.FIELD_PAY_INFO_VALUE).f(Integer.valueOf(str2));
            } catch (Throwable unused) {
                iLogger.c(SentryLevel.ERROR, "Unable to serialize monitor schedule value: %s", str2);
            }
        } else {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_VALUE).e(str2);
        }
        String str3 = this.f51702c;
        if (str3 != null) {
            objectWriter.d("unit").e(str3);
        }
        HashMap map = this.f51703d;
        if (map != null) {
            for (String str4 : map.keySet()) {
                objectWriter.d(str4).h(iLogger, this.f51703d.get(str4));
            }
        }
        objectWriter.t();
    }
}
