package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.boolex.JaninoEventEvaluatorBase;
import ch.qos.logback.core.boolex.Matcher;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Map;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class JaninoEventEvaluator extends JaninoEventEvaluatorBase<ILoggingEvent> {

    /* renamed from: h, reason: collision with root package name */
    public static final ArrayList f13257h;

    static {
        ArrayList arrayList = new ArrayList();
        f13257h = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("DEBUG");
        arrayList.add("INFO");
        arrayList.add("WARN");
        arrayList.add(MerchantConstants.ERROR);
        arrayList.add("event");
        arrayList.add(APayConstants.Error.MESSAGE);
        arrayList.add("formattedMessage");
        arrayList.add("logger");
        arrayList.add("loggerContext");
        arrayList.add("level");
        arrayList.add("timeStamp");
        arrayList.add("marker");
        arrayList.add("mdc");
        arrayList.add("throwableProxy");
        arrayList.add("throwable");
        Class cls = Integer.TYPE;
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(ILoggingEvent.class);
        arrayList2.add(String.class);
        arrayList2.add(String.class);
        arrayList2.add(String.class);
        arrayList2.add(LoggerContextVO.class);
        arrayList2.add(cls);
        arrayList2.add(Long.TYPE);
        arrayList2.add(Marker.class);
        arrayList2.add(Map.class);
        arrayList2.add(IThrowableProxy.class);
        arrayList2.add(Throwable.class);
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public final String T1() {
        throw null;
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public final Object[] U1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        ArrayList arrayList = this.f13460g;
        int size = arrayList.size();
        Object[] objArr = new Object[f13257h.size() + size];
        int iValueOf = 10000;
        objArr[0] = iValueOf;
        objArr[1] = 20000;
        objArr[2] = 30000;
        objArr[3] = 40000;
        objArr[4] = iLoggingEvent;
        objArr[5] = iLoggingEvent.getMessage();
        objArr[6] = iLoggingEvent.b();
        objArr[7] = iLoggingEvent.k();
        objArr[8] = iLoggingEvent.d();
        Level levelA = iLoggingEvent.a();
        int i2 = levelA.f13240a;
        if (i2 == Integer.MIN_VALUE) {
            iValueOf = Integer.MIN_VALUE;
        } else if (i2 == 5000) {
            iValueOf = 5000;
        } else if (i2 != 10000) {
            if (i2 == 20000) {
                iValueOf = 20000;
            } else if (i2 == 30000) {
                iValueOf = 30000;
            } else if (i2 == 40000) {
                iValueOf = 40000;
            } else {
                if (i2 != Integer.MAX_VALUE) {
                    throw new IllegalStateException("Level " + levelA.f13241b + ", " + i2 + " is unknown.");
                }
                iValueOf = Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }
        }
        objArr[9] = iValueOf;
        objArr[10] = Long.valueOf(iLoggingEvent.j());
        objArr[11] = iLoggingEvent.e();
        objArr[12] = iLoggingEvent.m();
        IThrowableProxy iThrowableProxyL = iLoggingEvent.l();
        if (iThrowableProxyL != null) {
            objArr[13] = iThrowableProxyL;
            if (iThrowableProxyL instanceof ThrowableProxy) {
                objArr[14] = ((ThrowableProxy) iThrowableProxyL).f13380a;
            } else {
                objArr[14] = null;
            }
        } else {
            objArr[13] = null;
            objArr[14] = null;
        }
        int i3 = 15;
        int i4 = 0;
        while (i4 < size) {
            objArr[i3] = (Matcher) arrayList.get(i4);
            i4++;
            i3++;
        }
        return objArr;
    }
}
