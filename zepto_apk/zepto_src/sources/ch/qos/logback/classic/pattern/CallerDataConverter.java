package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.status.ErrorStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class CallerDataConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public int f13310f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f13311g = 5;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f13312h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f13313i = 0;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        StringBuilder sb = new StringBuilder();
        if (this.f13312h != null) {
            for (int i2 = 0; i2 < this.f13312h.size(); i2++) {
                EventEvaluator eventEvaluator = (EventEvaluator) this.f13312h.get(i2);
                try {
                } catch (EvaluationException e2) {
                    this.f13313i++;
                    if (this.f13313i < 4) {
                        e("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", e2);
                    } else if (this.f13313i == 4) {
                        ErrorStatus errorStatus = new ErrorStatus(2, "Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, e2);
                        errorStatus.f(new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        this.f13649c.w1(errorStatus);
                    }
                }
                if (!eventEvaluator.k0(iLoggingEvent)) {
                }
            }
            return "";
        }
        StackTraceElement[] stackTraceElementArrI = iLoggingEvent.i();
        if (stackTraceElementArrI != null) {
            int length = stackTraceElementArrI.length;
            int i3 = this.f13310f;
            if (length > i3) {
                int length2 = this.f13311g;
                if (length2 >= stackTraceElementArrI.length) {
                    length2 = stackTraceElementArrI.length;
                }
                while (i3 < length2) {
                    sb.append("Caller+");
                    sb.append(i3);
                    sb.append("\t at ");
                    sb.append(stackTraceElementArrI[i3]);
                    sb.append(CoreConstants.f13442a);
                    i3++;
                }
                return sb.toString();
            }
        }
        return CallerData.f13339a;
    }

    public final void g() {
        int i2;
        int i3 = this.f13310f;
        if (i3 < 0 || (i2 = this.f13311g) < 0) {
            d("Invalid depthStart/depthEnd range [" + this.f13310f + ", " + this.f13311g + "] (negative values are not allowed)");
            return;
        }
        if (i3 >= i2) {
            d("Invalid depthEnd range [" + this.f13310f + ", " + this.f13311g + "] (start greater or equal to end)");
        }
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        EventEvaluator eventEvaluator;
        String strF = f();
        if (strF == null) {
            return;
        }
        try {
            if (strF.contains("..")) {
                String[] strArrSplit = strF.split(Pattern.quote(".."), 2);
                if (strArrSplit.length == 2) {
                    this.f13310f = Integer.parseInt(strArrSplit[0]);
                    this.f13311g = Integer.parseInt(strArrSplit[1]);
                    g();
                } else {
                    d("Failed to parse depth option as range [" + strF + "]");
                }
            } else {
                this.f13311g = Integer.parseInt(strF);
            }
        } catch (NumberFormatException e2) {
            e("Failed to parse depth option [" + strF + "]", e2);
        }
        List list = this.f13650d;
        if (list == null || list.size() <= 1) {
            return;
        }
        int size = list.size();
        for (int i2 = 1; i2 < size; i2++) {
            String str = (String) list.get(i2);
            Context context = this.f13649c.f13733b;
            if (context != null && (eventEvaluator = (EventEvaluator) ((Map) context.n0("EVALUATOR_MAP")).get(str)) != null) {
                if (this.f13312h == null) {
                    this.f13312h = new ArrayList();
                }
                this.f13312h.add(eventEvaluator);
            }
        }
    }
}
