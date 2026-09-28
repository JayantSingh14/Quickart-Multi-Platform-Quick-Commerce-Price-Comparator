package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.ContextAwareBase;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public abstract class Action extends ContextAwareBase {
    public static String W1(InterpretationContext interpretationContext) {
        StringBuilder sb = new StringBuilder("line: ");
        sb.append(X1(interpretationContext));
        sb.append(", column: ");
        LocatorImpl locatorImpl = interpretationContext.f13565g.f13574f;
        sb.append(locatorImpl != null ? locatorImpl.getColumnNumber() : -1);
        return sb.toString();
    }

    public static int X1(InterpretationContext interpretationContext) {
        LocatorImpl locatorImpl = interpretationContext.f13565g.f13574f;
        if (locatorImpl != null) {
            return locatorImpl.getLineNumber();
        }
        return -1;
    }

    public abstract void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl);

    public void U1(InterpretationContext interpretationContext, String str) {
    }

    public abstract void V1(InterpretationContext interpretationContext, String str);

    public final String toString() {
        return getClass().getName();
    }
}
