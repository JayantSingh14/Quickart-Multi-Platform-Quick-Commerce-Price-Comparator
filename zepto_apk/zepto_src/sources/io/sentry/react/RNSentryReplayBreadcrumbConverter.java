package io.sentry.react;

import coil3.util.UtilsKt;
import in.juspay.hypersdk.analytics.LogConstants;
import io.sentry.Breadcrumb;
import io.sentry.android.replay.DefaultReplayBreadcrumbConverter;
import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class RNSentryReplayBreadcrumbConverter extends DefaultReplayBreadcrumbConverter {
    public static void b(RRWebBreadcrumbEvent rRWebBreadcrumbEvent, Breadcrumb breadcrumb) {
        rRWebBreadcrumbEvent.f53025h = breadcrumb.f51562h;
        ConcurrentHashMap concurrentHashMap = breadcrumb.f51559e;
        rRWebBreadcrumbEvent.f53026i = concurrentHashMap == null ? null : new ConcurrentHashMap(concurrentHashMap);
        rRWebBreadcrumbEvent.f53031b = breadcrumb.a().getTime();
        rRWebBreadcrumbEvent.f53021d = breadcrumb.a().getTime() / 1000.0d;
        rRWebBreadcrumbEvent.f53022e = LogConstants.DEFAULT_CHANNEL;
    }

    @Override // io.sentry.android.replay.DefaultReplayBreadcrumbConverter, io.sentry.ReplayBreadcrumbConverter
    public final RRWebEvent a(Breadcrumb breadcrumb) {
        String str = breadcrumb.f51560f;
        String string = null;
        if (str != null && !"sentry.event".equals(str) && !"sentry.transaction".equals(breadcrumb.f51560f) && !"http".equals(breadcrumb.f51560f)) {
            if ("touch".equals(breadcrumb.f51560f)) {
                RRWebBreadcrumbEvent rRWebBreadcrumbEvent = new RRWebBreadcrumbEvent();
                rRWebBreadcrumbEvent.f53023f = "ui.tap";
                Object obj = breadcrumb.f51559e.get("path");
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (!list.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int iMin = Math.min(3, list.size() - 1);
                        while (true) {
                            if (iMin < 0) {
                                string = sb.toString();
                                break;
                            }
                            Object obj2 = list.get(iMin);
                            if (!(obj2 instanceof Map)) {
                                break;
                            }
                            Map map = (Map) obj2;
                            Object obj3 = map.get(CLConstants.FIELD_PAY_INFO_NAME);
                            Object obj4 = map.get("label");
                            boolean z = obj4 instanceof String;
                            if (!(obj3 instanceof String) && !z) {
                                break;
                            }
                            if (z) {
                                sb.append(obj4);
                            } else {
                                sb.append(obj3);
                            }
                            Object obj5 = map.get("element");
                            Object obj6 = map.get(UtilsKt.SCHEME_FILE);
                            boolean z2 = obj5 instanceof String;
                            boolean z3 = obj6 instanceof String;
                            if (z2 && z3) {
                                sb.append('(');
                                sb.append(obj5);
                                sb.append(", ");
                                sb.append(obj6);
                                sb.append(')');
                            } else if (z2) {
                                sb.append('(');
                                sb.append(obj5);
                                sb.append(')');
                            } else if (z3) {
                                sb.append('(');
                                sb.append(obj6);
                                sb.append(')');
                            }
                            if (iMin > 0) {
                                sb.append(" > ");
                            }
                            iMin--;
                        }
                    }
                }
                rRWebBreadcrumbEvent.f53024g = string;
                b(rRWebBreadcrumbEvent, breadcrumb);
                return rRWebBreadcrumbEvent;
            }
            if ("navigation".equals(breadcrumb.f51560f)) {
                RRWebBreadcrumbEvent rRWebBreadcrumbEvent2 = new RRWebBreadcrumbEvent();
                rRWebBreadcrumbEvent2.f53023f = breadcrumb.f51560f;
                b(rRWebBreadcrumbEvent2, breadcrumb);
                return rRWebBreadcrumbEvent2;
            }
            if ("xhr".equals(breadcrumb.f51560f)) {
                Double d2 = breadcrumb.f51559e.get("start_timestamp") instanceof Number ? (Double) breadcrumb.f51559e.get("start_timestamp") : null;
                Double d3 = breadcrumb.f51559e.get("end_timestamp") instanceof Number ? (Double) breadcrumb.f51559e.get("end_timestamp") : null;
                String str2 = breadcrumb.f51559e.get("url") instanceof String ? (String) breadcrumb.f51559e.get("url") : null;
                if (d2 != null && d3 != null && str2 != null) {
                    HashMap map2 = new HashMap();
                    if (breadcrumb.f51559e.get("method") instanceof String) {
                        map2.put("method", breadcrumb.f51559e.get("method"));
                    }
                    if (breadcrumb.f51559e.get("status_code") instanceof Double) {
                        Double d4 = (Double) breadcrumb.f51559e.get("status_code");
                        if (d4.doubleValue() > 0.0d) {
                            map2.put("statusCode", Integer.valueOf(d4.intValue()));
                        }
                    }
                    if (breadcrumb.f51559e.get("request_body_size") instanceof Double) {
                        map2.put("requestBodySize", breadcrumb.f51559e.get("request_body_size"));
                    }
                    if (breadcrumb.f51559e.get("response_body_size") instanceof Double) {
                        map2.put("responseBodySize", breadcrumb.f51559e.get("response_body_size"));
                    }
                    RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
                    rRWebSpanEvent.f53059d = "resource.http";
                    rRWebSpanEvent.f53061f = d2.doubleValue() / 1000.0d;
                    rRWebSpanEvent.f53062g = d3.doubleValue() / 1000.0d;
                    rRWebSpanEvent.f53060e = str2;
                    rRWebSpanEvent.f53063h = new ConcurrentHashMap(map2);
                    return rRWebSpanEvent;
                }
            } else {
                RRWebEvent rRWebEventA = super.a(breadcrumb);
                if (!(rRWebEventA instanceof RRWebBreadcrumbEvent) || !"navigation".equals(((RRWebBreadcrumbEvent) rRWebEventA).f53023f)) {
                    return rRWebEventA;
                }
            }
        }
        return null;
    }
}
