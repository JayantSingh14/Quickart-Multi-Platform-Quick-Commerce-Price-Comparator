package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;

/* loaded from: classes3.dex */
public class RootCauseFirstThrowableProxyConverter extends ExtendedThrowableProxyConverter {
    @Override // ch.qos.logback.classic.pattern.ThrowableProxyConverter
    public final String k(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        l(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }

    public final void l(StringBuilder sb, String str, int i2, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy.a() != null) {
            l(sb, str, i2, iThrowableProxy.a());
            str = null;
        }
        ThrowableProxyUtil.b(i2 - 1, sb);
        if (str != null) {
            sb.append(str);
        }
        if (iThrowableProxy.a() != null) {
            sb.append("Wrapped by: ");
        }
        sb.append(iThrowableProxy.d());
        sb.append(": ");
        sb.append(iThrowableProxy.getMessage());
        sb.append(CoreConstants.f13442a);
        j(sb, i2, iThrowableProxy);
        IThrowableProxy[] iThrowableProxyArrC = iThrowableProxy.c();
        if (iThrowableProxyArrC != null) {
            for (IThrowableProxy iThrowableProxy2 : iThrowableProxyArrC) {
                l(sb, "Suppressed: ", i2 + 1, iThrowableProxy2);
            }
        }
    }
}
