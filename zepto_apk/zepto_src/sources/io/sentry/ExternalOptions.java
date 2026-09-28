package io.sentry;

import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.SentryOptions;
import io.sentry.config.PropertiesProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class ExternalOptions {
    public Boolean A;
    public Boolean B;
    public SentryOptions.Cron C;

    /* renamed from: a, reason: collision with root package name */
    public String f51620a;

    /* renamed from: b, reason: collision with root package name */
    public String f51621b;

    /* renamed from: c, reason: collision with root package name */
    public String f51622c;

    /* renamed from: d, reason: collision with root package name */
    public String f51623d;

    /* renamed from: e, reason: collision with root package name */
    public String f51624e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f51625f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f51626g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f51627h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f51628i;

    /* renamed from: j, reason: collision with root package name */
    public Double f51629j;

    /* renamed from: k, reason: collision with root package name */
    public Double f51630k;

    /* renamed from: m, reason: collision with root package name */
    public SentryOptions.Proxy f51632m;
    public String r;
    public Long s;
    public Boolean u;
    public Boolean v;
    public Boolean x;
    public Boolean y;
    public List z;

    /* renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap f51631l = new ConcurrentHashMap();
    public final CopyOnWriteArrayList n = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList o = new CopyOnWriteArrayList();
    public CopyOnWriteArrayList p = null;
    public final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    public final CopyOnWriteArraySet t = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet w = new CopyOnWriteArraySet();

    public static ExternalOptions a(PropertiesProvider propertiesProvider, ILogger iLogger) throws ClassNotFoundException {
        ExternalOptions externalOptions = new ExternalOptions();
        externalOptions.f51620a = propertiesProvider.b("dsn");
        externalOptions.f51621b = propertiesProvider.b(PaymentConstants.ENV);
        externalOptions.f51622c = propertiesProvider.b("release");
        externalOptions.f51623d = propertiesProvider.b("dist");
        externalOptions.f51624e = propertiesProvider.b("servername");
        externalOptions.f51625f = propertiesProvider.f("uncaught.handler.enabled");
        externalOptions.u = propertiesProvider.f("uncaught.handler.print-stacktrace");
        externalOptions.f51628i = propertiesProvider.f("enable-tracing");
        externalOptions.f51629j = propertiesProvider.d("traces-sample-rate");
        externalOptions.f51630k = propertiesProvider.d("profiles-sample-rate");
        externalOptions.f51626g = propertiesProvider.f("debug");
        externalOptions.f51627h = propertiesProvider.f("enable-deduplication");
        externalOptions.v = propertiesProvider.f("send-client-reports");
        String strB = propertiesProvider.b("max-request-body-size");
        if (strB != null) {
            SentryOptions.RequestSize.valueOf(strB.toUpperCase(Locale.ROOT));
        }
        for (Map.Entry entry : ((ConcurrentHashMap) propertiesProvider.c()).entrySet()) {
            externalOptions.f51631l.put((String) entry.getKey(), (String) entry.getValue());
        }
        String strB2 = propertiesProvider.b("proxy.host");
        String strB3 = propertiesProvider.b("proxy.user");
        String strB4 = propertiesProvider.b("proxy.pass");
        String strB5 = propertiesProvider.b("proxy.port");
        if (strB5 == null) {
            strB5 = "80";
        }
        if (strB2 != null) {
            externalOptions.f51632m = new SentryOptions.Proxy(strB2, strB5, strB3, strB4);
        }
        Iterator it = propertiesProvider.e("in-app-includes").iterator();
        while (it.hasNext()) {
            externalOptions.o.add((String) it.next());
        }
        Iterator it2 = propertiesProvider.e("in-app-excludes").iterator();
        while (it2.hasNext()) {
            externalOptions.n.add((String) it2.next());
        }
        List<String> listE = propertiesProvider.b("trace-propagation-targets") != null ? propertiesProvider.e("trace-propagation-targets") : null;
        if (listE == null && propertiesProvider.b("tracing-origins") != null) {
            listE = propertiesProvider.e("tracing-origins");
        }
        if (listE != null) {
            for (String str : listE) {
                if (externalOptions.p == null) {
                    externalOptions.p = new CopyOnWriteArrayList();
                }
                if (!str.isEmpty()) {
                    externalOptions.p.add(str);
                }
            }
        }
        Iterator it3 = propertiesProvider.e("context-tags").iterator();
        while (it3.hasNext()) {
            externalOptions.q.add((String) it3.next());
        }
        externalOptions.r = propertiesProvider.b("proguard-uuid");
        Iterator it4 = propertiesProvider.e("bundle-ids").iterator();
        while (it4.hasNext()) {
            externalOptions.w.add((String) it4.next());
        }
        externalOptions.s = propertiesProvider.a("idle-timeout");
        externalOptions.x = propertiesProvider.f("enabled");
        externalOptions.y = propertiesProvider.f("enable-pretty-serialization-output");
        externalOptions.A = propertiesProvider.f("send-modules");
        externalOptions.z = propertiesProvider.e("ignored-checkins");
        externalOptions.B = propertiesProvider.f("enable-backpressure-handling");
        for (String str2 : propertiesProvider.e("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str2);
                if (Throwable.class.isAssignableFrom(cls)) {
                    externalOptions.t.add(cls);
                } else {
                    iLogger.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str2, str2);
                }
            } catch (ClassNotFoundException unused) {
                iLogger.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str2, str2);
            }
        }
        Long lA = propertiesProvider.a("cron.default-checkin-margin");
        Long lA2 = propertiesProvider.a("cron.default-max-runtime");
        String strB6 = propertiesProvider.b("cron.default-timezone");
        Long lA3 = propertiesProvider.a("cron.default-failure-issue-threshold");
        Long lA4 = propertiesProvider.a("cron.default-recovery-threshold");
        if (lA != null || lA2 != null || strB6 != null || lA3 != null || lA4 != null) {
            SentryOptions.Cron cron = new SentryOptions.Cron();
            cron.f51848a = lA;
            cron.f51849b = lA2;
            cron.f51850c = strB6;
            cron.f51851d = lA3;
            cron.f51852e = lA4;
            externalOptions.C = cron;
        }
        return externalOptions;
    }

    public final Boolean A() {
        return this.B;
    }

    public final Boolean B() {
        return this.y;
    }

    public final Boolean C() {
        return this.x;
    }

    public final Boolean D() {
        return this.A;
    }

    public final CopyOnWriteArraySet b() {
        return this.w;
    }

    public final CopyOnWriteArrayList c() {
        return this.q;
    }

    public final SentryOptions.Cron d() {
        return this.C;
    }

    public final Boolean e() {
        return this.f51626g;
    }

    public final String f() {
        return this.f51623d;
    }

    public final String g() {
        return this.f51620a;
    }

    public final Boolean h() {
        return this.f51627h;
    }

    public final Boolean i() {
        return this.f51628i;
    }

    public final Boolean j() {
        return this.f51625f;
    }

    public final String k() {
        return this.f51621b;
    }

    public final Long l() {
        return this.s;
    }

    public final List m() {
        return this.z;
    }

    public final CopyOnWriteArraySet n() {
        return this.t;
    }

    public final CopyOnWriteArrayList o() {
        return this.n;
    }

    public final CopyOnWriteArrayList p() {
        return this.o;
    }

    public final Boolean q() {
        return this.u;
    }

    public final Double r() {
        return this.f51630k;
    }

    public final String s() {
        return this.r;
    }

    public final SentryOptions.Proxy t() {
        return this.f51632m;
    }

    public final String u() {
        return this.f51622c;
    }

    public final Boolean v() {
        return this.v;
    }

    public final String w() {
        return this.f51624e;
    }

    public final ConcurrentHashMap x() {
        return this.f51631l;
    }

    public final List y() {
        return this.p;
    }

    public final Double z() {
        return this.f51629j;
    }
}
