package io.sentry.protocol;

import android.support.v4.media.b;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.Span;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.a;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.util.CollectionUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentrySpan implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Double f52916a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f52917b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryId f52918c;

    /* renamed from: d, reason: collision with root package name */
    public final SpanId f52919d;

    /* renamed from: e, reason: collision with root package name */
    public final SpanId f52920e;

    /* renamed from: f, reason: collision with root package name */
    public final String f52921f;

    /* renamed from: g, reason: collision with root package name */
    public final String f52922g;

    /* renamed from: h, reason: collision with root package name */
    public final SpanStatus f52923h;

    /* renamed from: i, reason: collision with root package name */
    public final String f52924i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f52925j;

    /* renamed from: k, reason: collision with root package name */
    public Map f52926k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f52927l;

    /* renamed from: m, reason: collision with root package name */
    public final Map f52928m;
    public ConcurrentHashMap n;

    public static final class Deserializer implements JsonDeserializer<SentrySpan> {
        public static IllegalStateException b(String str, ILogger iLogger) {
            String strD = b.D("Missing required field \"", str, "\"");
            IllegalStateException illegalStateException = new IllegalStateException(strD);
            iLogger.b(SentryLevel.ERROR, strD, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
        @Override // io.sentry.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(io.sentry.ObjectReader r26, io.sentry.ILogger r27) {
            /*
                Method dump skipped, instructions count: 542
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.protocol.SentrySpan.Deserializer.a(io.sentry.ObjectReader, io.sentry.ILogger):java.lang.Object");
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentrySpan(Span span) {
        Map mapS = span.s();
        this.f52922g = span.getDescription();
        this.f52921f = span.v();
        this.f52919d = span.x();
        this.f52920e = span.w();
        this.f52918c = span.z();
        this.f52923h = span.getStatus();
        this.f52924i = span.o().f51929i;
        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c(span.y());
        this.f52925j = concurrentHashMapC == null ? new ConcurrentHashMap() : concurrentHashMapC;
        ConcurrentHashMap concurrentHashMapC2 = CollectionUtils.c(span.u());
        this.f52927l = concurrentHashMapC2 == null ? new ConcurrentHashMap() : concurrentHashMapC2;
        this.f52917b = span.p() == null ? null : Double.valueOf(span.r().c(span.p()) / 1.0E9d);
        this.f52916a = Double.valueOf(span.r().d() / 1.0E9d);
        this.f52926k = mapS;
        LocalMetricsAggregator localMetricsAggregatorT = span.t();
        if (localMetricsAggregatorT != null) {
            this.f52928m = localMetricsAggregatorT.a();
        } else {
            this.f52928m = null;
        }
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        ObjectWriter objectWriterD = objectWriter.d("start_timestamp");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(this.f52916a.doubleValue());
        RoundingMode roundingMode = RoundingMode.DOWN;
        objectWriterD.h(iLogger, bigDecimalValueOf.setScale(6, roundingMode));
        Double d2 = this.f52917b;
        if (d2 != null) {
            objectWriter.d("timestamp").h(iLogger, BigDecimal.valueOf(d2.doubleValue()).setScale(6, roundingMode));
        }
        objectWriter.d("trace_id").h(iLogger, this.f52918c);
        objectWriter.d("span_id").h(iLogger, this.f52919d);
        SpanId spanId = this.f52920e;
        if (spanId != null) {
            objectWriter.d("parent_span_id").h(iLogger, spanId);
        }
        objectWriter.d("op").e(this.f52921f);
        String str = this.f52922g;
        if (str != null) {
            objectWriter.d("description").e(str);
        }
        SpanStatus spanStatus = this.f52923h;
        if (spanStatus != null) {
            objectWriter.d(CLConstants.OTP_STATUS).h(iLogger, spanStatus);
        }
        String str2 = this.f52924i;
        if (str2 != null) {
            objectWriter.d("origin").h(iLogger, str2);
        }
        Map map = this.f52925j;
        if (!map.isEmpty()) {
            objectWriter.d("tags").h(iLogger, map);
        }
        if (this.f52926k != null) {
            objectWriter.d("data").h(iLogger, this.f52926k);
        }
        Map map2 = this.f52927l;
        if (!map2.isEmpty()) {
            objectWriter.d("measurements").h(iLogger, map2);
        }
        Map map3 = this.f52928m;
        if (map3 != null && !map3.isEmpty()) {
            objectWriter.d("_metrics_summary").h(iLogger, map3);
        }
        ConcurrentHashMap concurrentHashMap = this.n;
        if (concurrentHashMap != null) {
            for (String str3 : concurrentHashMap.keySet()) {
                a.b(this.n, str3, objectWriter, str3, iLogger);
            }
        }
        objectWriter.t();
    }

    public SentrySpan(Double d2, Double d3, SentryId sentryId, SpanId spanId, SpanId spanId2, String str, String str2, SpanStatus spanStatus, String str3, Map map, Map map2, Map map3, Map map4) {
        this.f52916a = d2;
        this.f52917b = d3;
        this.f52918c = sentryId;
        this.f52919d = spanId;
        this.f52920e = spanId2;
        this.f52921f = str;
        this.f52922g = str2;
        this.f52923h = spanStatus;
        this.f52924i = str3;
        this.f52925j = map;
        this.f52927l = map2;
        this.f52928m = map3;
        this.f52926k = map4;
    }
}
