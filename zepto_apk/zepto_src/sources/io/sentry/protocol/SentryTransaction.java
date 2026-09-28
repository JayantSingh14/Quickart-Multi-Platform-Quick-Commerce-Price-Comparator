package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryTracer;
import io.sentry.Span;
import io.sentry.SpanContext;
import io.sentry.a;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.MetricSummary;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.TransactionInfo;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryTransaction extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    public String p;
    public Double q;
    public Double r;
    public final ArrayList s;
    public final HashMap t;
    public Map u;
    public TransactionInfo v;
    public ConcurrentHashMap w;

    public static final class Deserializer implements JsonDeserializer<SentryTransaction> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryTransaction sentryTransaction = new SentryTransaction(new ArrayList(), new HashMap(), new TransactionInfo(TransactionNameSource.CUSTOM.apiName()));
            new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "start_timestamp":
                        try {
                            Double dW = objectReader.W();
                            if (dW == null) {
                                break;
                            } else {
                                sentryTransaction.q = dW;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            if (objectReader.c0(iLogger) == null) {
                                break;
                            } else {
                                sentryTransaction.q = Double.valueOf(r2.getTime() / 1000.0d);
                                break;
                            }
                        }
                    case "_metrics_summary":
                        sentryTransaction.u = objectReader.W0(iLogger, new MetricSummary.Deserializer());
                        break;
                    case "measurements":
                        HashMap mapD1 = objectReader.d1(iLogger, new MeasurementValue.Deserializer());
                        if (mapD1 == null) {
                            break;
                        } else {
                            sentryTransaction.t.putAll(mapD1);
                            break;
                        }
                    case "type":
                        objectReader.K0();
                        break;
                    case "timestamp":
                        try {
                            Double dW2 = objectReader.W();
                            if (dW2 == null) {
                                break;
                            } else {
                                sentryTransaction.r = dW2;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            if (objectReader.c0(iLogger) == null) {
                                break;
                            } else {
                                sentryTransaction.r = Double.valueOf(r2.getTime() / 1000.0d);
                                break;
                            }
                        }
                    case "spans":
                        ArrayList arrayListI1 = objectReader.I1(iLogger, new SentrySpan.Deserializer());
                        if (arrayListI1 == null) {
                            break;
                        } else {
                            sentryTransaction.s.addAll(arrayListI1);
                            break;
                        }
                    case "transaction_info":
                        new TransactionInfo.Deserializer();
                        sentryTransaction.v = TransactionInfo.Deserializer.b(objectReader, iLogger);
                        break;
                    case "transaction":
                        sentryTransaction.p = objectReader.a1();
                        break;
                    default:
                        if (!SentryBaseEvent.Deserializer.a(sentryTransaction, strX, objectReader, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX);
                            break;
                        } else {
                            break;
                        }
                }
            }
            sentryTransaction.w = concurrentHashMap;
            objectReader.t();
            return sentryTransaction;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryTransaction(SentryTracer sentryTracer) {
        super(sentryTracer.e());
        this.s = new ArrayList();
        this.t = new HashMap();
        this.q = Double.valueOf(sentryTracer.r().d() / 1.0E9d);
        this.r = Double.valueOf(sentryTracer.r().c(sentryTracer.p()) / 1.0E9d);
        this.p = sentryTracer.getName();
        Iterator it = ((CopyOnWriteArrayList) sentryTracer.v()).iterator();
        while (it.hasNext()) {
            Span span = (Span) it.next();
            if (Boolean.TRUE.equals(span.A())) {
                this.s.add(new SentrySpan(span));
            }
        }
        Contexts contexts = this.f51792b;
        contexts.putAll(sentryTracer.w());
        SpanContext spanContextO = sentryTracer.o();
        contexts.c(new SpanContext(spanContextO.f51921a, spanContextO.f51922b, spanContextO.f51923c, spanContextO.f51925e, spanContextO.f51926f, spanContextO.f51924d, spanContextO.f51927g, spanContextO.f51929i));
        for (Map.Entry entry : spanContextO.f51928h.entrySet()) {
            b((String) entry.getKey(), (String) entry.getValue());
        }
        Map mapX = sentryTracer.x();
        if (mapX != null) {
            for (Map.Entry entry2 : ((ConcurrentHashMap) mapX).entrySet()) {
                String str = (String) entry2.getKey();
                Object value = entry2.getValue();
                if (this.o == null) {
                    this.o = new HashMap();
                }
                this.o.put(str, value);
            }
        }
        this.v = new TransactionInfo(sentryTracer.z().apiName());
        LocalMetricsAggregator localMetricsAggregatorY = sentryTracer.y();
        if (localMetricsAggregatorY != null) {
            this.u = localMetricsAggregatorY.a();
        } else {
            this.u = null;
        }
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.p != null) {
            objectWriter.d("transaction").e(this.p);
        }
        ObjectWriter objectWriterD = objectWriter.d("start_timestamp");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(this.q.doubleValue());
        RoundingMode roundingMode = RoundingMode.DOWN;
        objectWriterD.h(iLogger, bigDecimalValueOf.setScale(6, roundingMode));
        if (this.r != null) {
            objectWriter.d("timestamp").h(iLogger, BigDecimal.valueOf(this.r.doubleValue()).setScale(6, roundingMode));
        }
        ArrayList arrayList = this.s;
        if (!arrayList.isEmpty()) {
            objectWriter.d("spans").h(iLogger, arrayList);
        }
        objectWriter.d("type").e("transaction");
        HashMap map = this.t;
        if (!map.isEmpty()) {
            objectWriter.d("measurements").h(iLogger, map);
        }
        Map map2 = this.u;
        if (map2 != null && !map2.isEmpty()) {
            objectWriter.d("_metrics_summary").h(iLogger, this.u);
        }
        objectWriter.d("transaction_info").h(iLogger, this.v);
        new SentryBaseEvent.Serializer();
        SentryBaseEvent.Serializer.a(this, objectWriter, iLogger);
        ConcurrentHashMap concurrentHashMap = this.w;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.w, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public SentryTransaction(ArrayList arrayList, HashMap map, TransactionInfo transactionInfo) {
        Double dValueOf = Double.valueOf(0.0d);
        ArrayList arrayList2 = new ArrayList();
        this.s = arrayList2;
        HashMap map2 = new HashMap();
        this.t = map2;
        this.p = "";
        this.q = dValueOf;
        this.r = null;
        arrayList2.addAll(arrayList);
        map2.putAll(map);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.t.putAll(((SentrySpan) it.next()).f52927l);
        }
        this.v = transactionInfo;
        this.u = null;
    }
}
