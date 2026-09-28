package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class MetricSummary implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public double f52860a;

    /* renamed from: b, reason: collision with root package name */
    public double f52861b;

    /* renamed from: c, reason: collision with root package name */
    public double f52862c;

    /* renamed from: d, reason: collision with root package name */
    public int f52863d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap f52864e;

    public static final class Deserializer implements JsonDeserializer<MetricSummary> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            MetricSummary metricSummary = new MetricSummary();
            objectReader.k();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "max":
                        metricSummary.f52861b = objectReader.nextDouble();
                        break;
                    case "min":
                        metricSummary.f52860a = objectReader.nextDouble();
                        break;
                    case "sum":
                        metricSummary.f52862c = objectReader.nextDouble();
                        break;
                    case "tags":
                        metricSummary.f52864e = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "count":
                        metricSummary.f52863d = objectReader.nextInt();
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
            return metricSummary;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("min").b(this.f52860a);
        objectWriter.d("max").b(this.f52861b);
        objectWriter.d("sum").b(this.f52862c);
        objectWriter.d("count").a(this.f52863d);
        if (this.f52864e != null) {
            objectWriter.d("tags");
            objectWriter.h(iLogger, this.f52864e);
        }
        objectWriter.t();
    }
}
