package io.sentry.clientreport;

import android.support.v4.media.b;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.clientreport.DiscardedEvent;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ClientReport implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Date f52712a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f52713b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f52714c;

    public static final class Deserializer implements JsonDeserializer<ClientReport> {
        public static IllegalStateException b(String str, ILogger iLogger) {
            String strD = b.D("Missing required field \"", str, "\"");
            IllegalStateException illegalStateException = new IllegalStateException(strD);
            iLogger.b(SentryLevel.ERROR, strD, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            ArrayList arrayList = new ArrayList();
            objectReader.k();
            Date dateC0 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("discarded_events")) {
                    arrayList.addAll(objectReader.I1(iLogger, new DiscardedEvent.Deserializer()));
                } else if (strX.equals("timestamp")) {
                    dateC0 = objectReader.c0(iLogger);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            objectReader.t();
            if (dateC0 == null) {
                throw b("timestamp", iLogger);
            }
            if (arrayList.isEmpty()) {
                throw b("discarded_events", iLogger);
            }
            ClientReport clientReport = new ClientReport(dateC0, arrayList);
            clientReport.f52714c = map;
            return clientReport;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ClientReport(Date date, ArrayList arrayList) {
        this.f52712a = date;
        this.f52713b = arrayList;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("timestamp").e(DateUtils.e(this.f52712a));
        objectWriter.d("discarded_events").h(iLogger, this.f52713b);
        HashMap map = this.f52714c;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52714c.get(str));
            }
        }
        objectWriter.t();
    }
}
