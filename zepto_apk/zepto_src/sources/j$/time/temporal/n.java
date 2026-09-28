package j$.time.temporal;

import j$.time.format.B;
import j$.time.format.C;
import java.util.HashMap;

/* loaded from: classes2.dex */
public interface n {
    q A();

    q K(TemporalAccessor temporalAccessor);

    boolean X();

    boolean Z(TemporalAccessor temporalAccessor);

    Temporal q(Temporal temporal, long j2);

    long s(TemporalAccessor temporalAccessor);

    default TemporalAccessor J(HashMap map, B b2, C c2) {
        return null;
    }
}
