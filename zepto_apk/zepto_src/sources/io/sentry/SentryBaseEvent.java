package io.sentry;

import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.Breadcrumb;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes.dex */
public abstract class SentryBaseEvent {

    /* renamed from: a, reason: collision with root package name */
    public SentryId f51791a;

    /* renamed from: b, reason: collision with root package name */
    public final Contexts f51792b;

    /* renamed from: c, reason: collision with root package name */
    public SdkVersion f51793c;

    /* renamed from: d, reason: collision with root package name */
    public Request f51794d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractMap f51795e;

    /* renamed from: f, reason: collision with root package name */
    public String f51796f;

    /* renamed from: g, reason: collision with root package name */
    public String f51797g;

    /* renamed from: h, reason: collision with root package name */
    public String f51798h;

    /* renamed from: i, reason: collision with root package name */
    public User f51799i;

    /* renamed from: j, reason: collision with root package name */
    public transient Throwable f51800j;

    /* renamed from: k, reason: collision with root package name */
    public String f51801k;

    /* renamed from: l, reason: collision with root package name */
    public String f51802l;

    /* renamed from: m, reason: collision with root package name */
    public List f51803m;
    public DebugMeta n;
    public AbstractMap o;

    /* loaded from: classes3.dex */
    public static final class Deserializer {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static boolean a(SentryBaseEvent sentryBaseEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1840434063:
                    if (str.equals("debug_meta")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -758770169:
                    if (str.equals("server_name")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -567312220:
                    if (str.equals("contexts")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -85904877:
                    if (str.equals(PaymentConstants.ENV)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -51457840:
                    if (str.equals("breadcrumbs")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 113722:
                    if (str.equals("sdk")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3083686:
                    if (str.equals("dist")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3552281:
                    if (str.equals("tags")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (str.equals(LogSubCategory.Action.USER)) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 96965648:
                    if (str.equals("extra")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 278118624:
                    if (str.equals("event_id")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1090594823:
                    if (str.equals("release")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1095692943:
                    if (str.equals("request")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    sentryBaseEvent.n = (DebugMeta) objectReader.o0(iLogger, new DebugMeta.Deserializer());
                    return true;
                case 1:
                    sentryBaseEvent.f51801k = objectReader.a1();
                    return true;
                case 2:
                    new Contexts.Deserializer();
                    sentryBaseEvent.f51792b.putAll(Contexts.Deserializer.b(objectReader, iLogger));
                    return true;
                case 3:
                    sentryBaseEvent.f51797g = objectReader.a1();
                    return true;
                case 4:
                    sentryBaseEvent.f51803m = objectReader.I1(iLogger, new Breadcrumb.Deserializer());
                    return true;
                case 5:
                    sentryBaseEvent.f51793c = (SdkVersion) objectReader.o0(iLogger, new SdkVersion.Deserializer());
                    return true;
                case 6:
                    sentryBaseEvent.f51802l = objectReader.a1();
                    return true;
                case 7:
                    sentryBaseEvent.f51795e = CollectionUtils.c((Map) objectReader.B1());
                    return true;
                case '\b':
                    sentryBaseEvent.f51799i = (User) objectReader.o0(iLogger, new User.Deserializer());
                    return true;
                case '\t':
                    sentryBaseEvent.o = CollectionUtils.c((Map) objectReader.B1());
                    return true;
                case '\n':
                    sentryBaseEvent.f51791a = (SentryId) objectReader.o0(iLogger, new SentryId.Deserializer());
                    return true;
                case 11:
                    sentryBaseEvent.f51796f = objectReader.a1();
                    return true;
                case '\f':
                    sentryBaseEvent.f51794d = (Request) objectReader.o0(iLogger, new Request.Deserializer());
                    return true;
                case '\r':
                    sentryBaseEvent.f51798h = objectReader.a1();
                    return true;
                default:
                    return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    /* loaded from: classes3.dex */
    public static final class Serializer {
        public static void a(SentryBaseEvent sentryBaseEvent, ObjectWriter objectWriter, ILogger iLogger) {
            if (sentryBaseEvent.f51791a != null) {
                objectWriter.d("event_id").h(iLogger, sentryBaseEvent.f51791a);
            }
            objectWriter.d("contexts").h(iLogger, sentryBaseEvent.f51792b);
            if (sentryBaseEvent.f51793c != null) {
                objectWriter.d("sdk").h(iLogger, sentryBaseEvent.f51793c);
            }
            if (sentryBaseEvent.f51794d != null) {
                objectWriter.d("request").h(iLogger, sentryBaseEvent.f51794d);
            }
            AbstractMap abstractMap = sentryBaseEvent.f51795e;
            if (abstractMap != null && !abstractMap.isEmpty()) {
                objectWriter.d("tags").h(iLogger, sentryBaseEvent.f51795e);
            }
            if (sentryBaseEvent.f51796f != null) {
                objectWriter.d("release").e(sentryBaseEvent.f51796f);
            }
            if (sentryBaseEvent.f51797g != null) {
                objectWriter.d(PaymentConstants.ENV).e(sentryBaseEvent.f51797g);
            }
            if (sentryBaseEvent.f51798h != null) {
                objectWriter.d("platform").e(sentryBaseEvent.f51798h);
            }
            if (sentryBaseEvent.f51799i != null) {
                objectWriter.d(LogSubCategory.Action.USER).h(iLogger, sentryBaseEvent.f51799i);
            }
            if (sentryBaseEvent.f51801k != null) {
                objectWriter.d("server_name").e(sentryBaseEvent.f51801k);
            }
            if (sentryBaseEvent.f51802l != null) {
                objectWriter.d("dist").e(sentryBaseEvent.f51802l);
            }
            List list = sentryBaseEvent.f51803m;
            if (list != null && !list.isEmpty()) {
                objectWriter.d("breadcrumbs").h(iLogger, sentryBaseEvent.f51803m);
            }
            if (sentryBaseEvent.n != null) {
                objectWriter.d("debug_meta").h(iLogger, sentryBaseEvent.n);
            }
            AbstractMap abstractMap2 = sentryBaseEvent.o;
            if (abstractMap2 == null || abstractMap2.isEmpty()) {
                return;
            }
            objectWriter.d("extra").h(iLogger, sentryBaseEvent.o);
        }
    }

    public SentryBaseEvent(SentryId sentryId) {
        this.f51792b = new Contexts();
        this.f51791a = sentryId;
    }

    public final Throwable a() {
        Throwable th = this.f51800j;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).c() : th;
    }

    public final void b(String str, String str2) {
        if (this.f51795e == null) {
            this.f51795e = new HashMap();
        }
        this.f51795e.put(str, str2);
    }

    public SentryBaseEvent() {
        this(new SentryId());
    }
}
