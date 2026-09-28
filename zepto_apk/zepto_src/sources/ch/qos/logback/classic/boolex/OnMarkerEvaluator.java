package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EventEvaluatorBase;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class OnMarkerEvaluator extends EventEvaluatorBase<ILoggingEvent> {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f13258f = new ArrayList();

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final boolean k0(Object obj) {
        Marker markerE = ((ILoggingEvent) obj).e();
        if (markerE == null) {
            return false;
        }
        Iterator it = this.f13258f.iterator();
        while (it.hasNext()) {
            if (markerE.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
