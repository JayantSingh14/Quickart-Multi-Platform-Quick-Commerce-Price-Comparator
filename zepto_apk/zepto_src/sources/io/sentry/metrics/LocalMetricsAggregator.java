package io.sentry.metrics;

import io.sentry.protocol.MetricSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class LocalMetricsAggregator {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f52781a = new HashMap();

    public final HashMap a() {
        HashMap map = new HashMap();
        synchronized (this.f52781a) {
            try {
                for (Map.Entry entry : this.f52781a.entrySet()) {
                    String str = (String) entry.getKey();
                    Objects.requireNonNull(str);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((Map) entry.getValue()).values().iterator();
                    while (it.hasNext()) {
                        ((GaugeMetric) it.next()).getClass();
                        MetricSummary metricSummary = new MetricSummary();
                        metricSummary.f52864e = null;
                        metricSummary.f52860a = 0.0d;
                        metricSummary.f52861b = 0.0d;
                        metricSummary.f52863d = 0;
                        metricSummary.f52862c = 0.0d;
                        arrayList.add(metricSummary);
                    }
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }
}
