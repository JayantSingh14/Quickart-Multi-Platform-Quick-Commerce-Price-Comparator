package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.status.ErrorStatus;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ThrowableProxyConverter extends ThrowableHandlingConverter {

    /* renamed from: f, reason: collision with root package name */
    public int f13330f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f13331g = null;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f13332h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f13333i = 0;

    @Override // ch.qos.logback.core.pattern.Converter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String b(ILoggingEvent iLoggingEvent) {
        IThrowableProxy iThrowableProxyL = iLoggingEvent.l();
        if (iThrowableProxyL == null) {
            return "";
        }
        if (this.f13331g != null) {
            for (int i2 = 0; i2 < this.f13331g.size(); i2++) {
                EventEvaluator eventEvaluator = (EventEvaluator) this.f13331g.get(i2);
                try {
                } catch (EvaluationException e2) {
                    this.f13333i++;
                    if (this.f13333i < 4) {
                        e("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", e2);
                    } else if (this.f13333i == 4) {
                        ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, e2);
                        errorStatus.f(new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        this.f13649c.w1(errorStatus);
                    }
                }
                if (eventEvaluator.k0(iLoggingEvent)) {
                    return "";
                }
            }
        }
        return k(iThrowableProxyL);
    }

    public void h(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
    }

    public final void i(StringBuilder sb, String str, int i2, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return;
        }
        ThrowableProxyUtil.b(i2 - 1, sb);
        if (str != null) {
            sb.append(str);
        }
        sb.append(iThrowableProxy.d());
        sb.append(": ");
        sb.append(iThrowableProxy.getMessage());
        sb.append(CoreConstants.f13442a);
        j(sb, i2, iThrowableProxy);
        IThrowableProxy[] iThrowableProxyArrC = iThrowableProxy.c();
        if (iThrowableProxyArrC != null) {
            for (IThrowableProxy iThrowableProxy2 : iThrowableProxyArrC) {
                i(sb, "Suppressed: ", i2 + 1, iThrowableProxy2);
            }
        }
        i(sb, "Caused by: ", i2, iThrowableProxy.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.StringBuilder r17, int r18, ch.qos.logback.classic.spi.IThrowableProxy r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            ch.qos.logback.classic.spi.StackTraceElementProxy[] r3 = r19.e()
            int r4 = r19.b()
            int r5 = r0.f13330f
            int r6 = r3.length
            r7 = 0
            if (r5 <= r6) goto L16
            r6 = 1
            goto L17
        L16:
            r6 = r7
        L17:
            if (r6 == 0) goto L1a
            int r5 = r3.length
        L1a:
            if (r4 <= 0) goto L1f
            if (r6 == 0) goto L1f
            int r5 = r5 - r4
        L1f:
            r8 = r7
            r9 = r8
        L21:
            java.lang.String r10 = " skipped]"
            java.lang.String r11 = " ["
            if (r8 >= r5) goto L6c
            r12 = r3[r8]
            java.lang.String r13 = r12.toString()
            java.util.ArrayList r14 = r0.f13332h
            if (r14 == 0) goto L4f
            java.util.Iterator r14 = r14.iterator()
        L35:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L4f
            java.lang.Object r15 = r14.next()
            java.lang.String r15 = (java.lang.String) r15
            boolean r15 = r13.contains(r15)
            if (r15 == 0) goto L35
            int r9 = r9 + 1
            int r10 = r3.length
            if (r5 >= r10) goto L69
            int r5 = r5 + 1
            goto L69
        L4f:
            ch.qos.logback.classic.spi.ThrowableProxyUtil.b(r2, r1)
            r1.append(r12)
            r0.h(r1, r12)
            if (r9 <= 0) goto L63
            r1.append(r11)
            r1.append(r9)
            r1.append(r10)
        L63:
            java.lang.String r9 = ch.qos.logback.core.CoreConstants.f13442a
            r1.append(r9)
            r9 = r7
        L69:
            int r8 = r8 + 1
            goto L21
        L6c:
            if (r9 <= 0) goto L7c
            r1.append(r11)
            r1.append(r9)
            r1.append(r10)
            java.lang.String r3 = ch.qos.logback.core.CoreConstants.f13442a
            r1.append(r3)
        L7c:
            if (r4 <= 0) goto L99
            if (r6 == 0) goto L99
            ch.qos.logback.classic.spi.ThrowableProxyUtil.b(r2, r1)
            java.lang.String r2 = "... "
            r1.append(r2)
            int r2 = r19.b()
            r1.append(r2)
            java.lang.String r2 = " common frames omitted"
            r1.append(r2)
            java.lang.String r2 = ch.qos.logback.core.CoreConstants.f13442a
            r1.append(r2)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.pattern.ThrowableProxyConverter.j(java.lang.StringBuilder, int, ch.qos.logback.classic.spi.IThrowableProxy):void");
    }

    public String k(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        i(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        String strF = f();
        if (strF == null) {
            this.f13330f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            String lowerCase = strF.toLowerCase();
            if ("full".equals(lowerCase)) {
                this.f13330f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else if ("short".equals(lowerCase)) {
                this.f13330f = 1;
            } else {
                try {
                    this.f13330f = Integer.parseInt(lowerCase);
                } catch (NumberFormatException unused) {
                    d("Could not parse [" + lowerCase + "] as an integer");
                    this.f13330f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
        }
        List list = this.f13650d;
        if (list != null && list.size() > 1) {
            int size = list.size();
            for (int i2 = 1; i2 < size; i2++) {
                String str = (String) list.get(i2);
                EventEvaluator eventEvaluator = (EventEvaluator) ((Map) this.f13649c.f13733b.n0("EVALUATOR_MAP")).get(str);
                if (eventEvaluator != null) {
                    if (this.f13331g == null) {
                        this.f13331g = new ArrayList();
                    }
                    this.f13331g.add(eventEvaluator);
                } else {
                    if (this.f13332h == null) {
                        this.f13332h = new ArrayList();
                    }
                    this.f13332h.add(str);
                }
            }
        }
        this.f13651e = true;
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13331g = null;
        this.f13651e = false;
    }
}
