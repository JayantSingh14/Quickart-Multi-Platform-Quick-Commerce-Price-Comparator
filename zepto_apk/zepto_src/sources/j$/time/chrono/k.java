package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes2.dex */
public interface k extends Comparable {
    List B();

    boolean C(long j2);

    ChronoLocalDate F(int i2, int i3, int i4);

    ChronoLocalDate O();

    l S(int i2);

    ChronoLocalDate U(Map map, j$.time.format.C c2);

    String W();

    j$.time.temporal.q Y(j$.time.temporal.a aVar);

    boolean equals(Object obj);

    String getId();

    int hashCode();

    ChronoLocalDate r(long j2);

    ChronoLocalDate t(TemporalAccessor temporalAccessor);

    String toString();

    int v(l lVar, int i2);

    InterfaceC0116h w(Instant instant, ZoneId zoneId);

    ChronoLocalDate y(int i2, int i3);

    static k E(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        k kVar = (k) temporalAccessor.e(j$.time.temporal.o.f53429b);
        r rVar = r.f53253c;
        if (kVar != null) {
            return kVar;
        }
        Objects.requireNonNull(rVar, "defaultObj");
        return rVar;
    }

    static k P(String str) {
        ConcurrentHashMap concurrentHashMap = AbstractC0109a.f53220a;
        Objects.requireNonNull(str, CLConstants.SHARED_PREFERENCE_ITEM_ID);
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = AbstractC0109a.f53220a;
            k kVar = (k) concurrentHashMap2.get(str);
            if (kVar == null) {
                kVar = (k) AbstractC0109a.f53221b.get(str);
            }
            if (kVar != null) {
                return kVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                Iterator it = ServiceLoader.load(k.class).iterator();
                while (it.hasNext()) {
                    k kVar2 = (k) it.next();
                    if (str.equals(kVar2.getId()) || str.equals(kVar2.W())) {
                        return kVar2;
                    }
                }
                throw new DateTimeException("Unknown chronology: ".concat(str));
            }
            n nVar = n.f53237l;
            AbstractC0109a.s(nVar, nVar.getId());
            u uVar = u.f53256c;
            AbstractC0109a.s(uVar, uVar.getId());
            z zVar = z.f53268c;
            AbstractC0109a.s(zVar, zVar.getId());
            F f2 = F.f53216c;
            AbstractC0109a.s(f2, f2.getId());
            try {
                for (AbstractC0109a abstractC0109a : Arrays.asList(new AbstractC0109a[0])) {
                    if (!abstractC0109a.getId().equals("ISO")) {
                        AbstractC0109a.s(abstractC0109a, abstractC0109a.getId());
                    }
                }
                r rVar = r.f53253c;
                AbstractC0109a.s(rVar, rVar.getId());
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default ChronoLocalDateTime a0(Temporal temporal) {
        try {
            return t(temporal).M(LocalTime.A(temporal));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporal.getClass(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [j$.time.chrono.h] */
    default InterfaceC0116h N(Temporal temporal) {
        try {
            ZoneId zoneIdS = ZoneId.s(temporal);
            try {
                temporal = w(Instant.from(temporal), zoneIdS);
                return temporal;
            } catch (DateTimeException unused) {
                return j.A(zoneIdS, null, C0113e.s(this, a0(temporal)));
            }
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporal.getClass(), e2);
        }
    }
}
