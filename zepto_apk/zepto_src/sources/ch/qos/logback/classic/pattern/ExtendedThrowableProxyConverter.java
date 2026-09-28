package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ClassPackagingData;
import ch.qos.logback.classic.spi.StackTraceElementProxy;

/* loaded from: classes3.dex */
public class ExtendedThrowableProxyConverter extends ThrowableProxyConverter {
    @Override // ch.qos.logback.classic.pattern.ThrowableProxyConverter
    public final void h(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
        ClassPackagingData classPackagingData = stackTraceElementProxy.f13377c;
        if (classPackagingData != null) {
            if (classPackagingData.f13343c) {
                sb.append(" [");
            } else {
                sb.append(" ~[");
            }
            sb.append(classPackagingData.f13341a);
            sb.append(':');
            sb.append(classPackagingData.f13342b);
            sb.append(']');
        }
    }
}
