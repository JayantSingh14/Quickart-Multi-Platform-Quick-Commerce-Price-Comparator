package io.sentry;

import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class Session implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Date f51894a;

    /* renamed from: b, reason: collision with root package name */
    public Date f51895b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f51896c;

    /* renamed from: d, reason: collision with root package name */
    public final String f51897d;

    /* renamed from: e, reason: collision with root package name */
    public final UUID f51898e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f51899f;

    /* renamed from: g, reason: collision with root package name */
    public State f51900g;

    /* renamed from: h, reason: collision with root package name */
    public Long f51901h;

    /* renamed from: i, reason: collision with root package name */
    public Double f51902i;

    /* renamed from: j, reason: collision with root package name */
    public final String f51903j;

    /* renamed from: k, reason: collision with root package name */
    public String f51904k;

    /* renamed from: l, reason: collision with root package name */
    public final String f51905l;

    /* renamed from: m, reason: collision with root package name */
    public final String f51906m;
    public String n;
    public final Object o = new Object();
    public ConcurrentHashMap p;

    public static final class Deserializer implements JsonDeserializer<Session> {
        public static IllegalStateException b(String str, ILogger iLogger) {
            String strD = android.support.v4.media.b.D("Missing required field \"", str, "\"");
            IllegalStateException illegalStateException = new IllegalStateException(strD);
            iLogger.b(SentryLevel.ERROR, strD, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
        @Override // io.sentry.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(io.sentry.ObjectReader r27, io.sentry.ILogger r28) {
            /*
                Method dump skipped, instructions count: 570
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.Deserializer.a(io.sentry.ObjectReader, io.sentry.ILogger):java.lang.Object");
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public Session(State state, Date date, Date date2, int i2, String str, UUID uuid, Boolean bool, Long l2, Double d2, String str2, String str3, String str4, String str5, String str6) {
        this.f51900g = state;
        this.f51894a = date;
        this.f51895b = date2;
        this.f51896c = new AtomicInteger(i2);
        this.f51897d = str;
        this.f51898e = uuid;
        this.f51899f = bool;
        this.f51901h = l2;
        this.f51902i = d2;
        this.f51903j = str2;
        this.f51904k = str3;
        this.f51905l = str4;
        this.f51906m = str5;
        this.n = str6;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Session clone() {
        return new Session(this.f51900g, this.f51894a, this.f51895b, this.f51896c.get(), this.f51897d, this.f51898e, this.f51899f, this.f51901h, this.f51902i, this.f51903j, this.f51904k, this.f51905l, this.f51906m, this.n);
    }

    public final void b(Date date) {
        synchronized (this.o) {
            try {
                this.f51899f = null;
                if (this.f51900g == State.Ok) {
                    this.f51900g = State.Exited;
                }
                if (date != null) {
                    this.f51895b = date;
                } else {
                    this.f51895b = DateUtils.a();
                }
                if (this.f51895b != null) {
                    this.f51902i = Double.valueOf(Math.abs(r6.getTime() - this.f51894a.getTime()) / 1000.0d);
                    long time = this.f51895b.getTime();
                    if (time < 0) {
                        time = Math.abs(time);
                    }
                    this.f51901h = Long.valueOf(time);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(State state, String str, boolean z, String str2) {
        boolean z2;
        boolean z3;
        synchronized (this.o) {
            z2 = true;
            if (state != null) {
                try {
                    this.f51900g = state;
                    z3 = true;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z3 = false;
            }
            if (str != null) {
                this.f51904k = str;
                z3 = true;
            }
            if (z) {
                this.f51896c.addAndGet(1);
                z3 = true;
            }
            if (str2 != null) {
                this.n = str2;
            } else {
                z2 = z3;
            }
            if (z2) {
                this.f51899f = null;
                Date dateA = DateUtils.a();
                this.f51895b = dateA;
                if (dateA != null) {
                    long time = dateA.getTime();
                    if (time < 0) {
                        time = Math.abs(time);
                    }
                    this.f51901h = Long.valueOf(time);
                }
            }
        }
        return z2;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        UUID uuid = this.f51898e;
        if (uuid != null) {
            objectWriter.d("sid").e(uuid.toString());
        }
        String str = this.f51897d;
        if (str != null) {
            objectWriter.d("did").e(str);
        }
        if (this.f51899f != null) {
            objectWriter.d("init").i(this.f51899f);
        }
        objectWriter.d("started").h(iLogger, this.f51894a);
        objectWriter.d(CLConstants.OTP_STATUS).h(iLogger, this.f51900g.name().toLowerCase(Locale.ROOT));
        if (this.f51901h != null) {
            objectWriter.d("seq").f(this.f51901h);
        }
        objectWriter.d("errors").a(this.f51896c.intValue());
        if (this.f51902i != null) {
            objectWriter.d("duration").f(this.f51902i);
        }
        if (this.f51895b != null) {
            objectWriter.d("timestamp").h(iLogger, this.f51895b);
        }
        if (this.n != null) {
            objectWriter.d("abnormal_mechanism").h(iLogger, this.n);
        }
        objectWriter.d("attrs");
        objectWriter.k();
        objectWriter.d("release").h(iLogger, this.f51906m);
        String str2 = this.f51905l;
        if (str2 != null) {
            objectWriter.d(PaymentConstants.ENV).h(iLogger, str2);
        }
        String str3 = this.f51903j;
        if (str3 != null) {
            objectWriter.d("ip_address").h(iLogger, str3);
        }
        if (this.f51904k != null) {
            objectWriter.d("user_agent").h(iLogger, this.f51904k);
        }
        objectWriter.t();
        ConcurrentHashMap concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            for (String str4 : concurrentHashMap.keySet()) {
                a.b(this.p, str4, objectWriter, str4, iLogger);
            }
        }
        objectWriter.t();
    }
}
