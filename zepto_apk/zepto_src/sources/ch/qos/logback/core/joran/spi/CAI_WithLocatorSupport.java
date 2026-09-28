package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.spi.ContextAwareImpl;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
class CAI_WithLocatorSupport extends ContextAwareImpl {
    @Override // ch.qos.logback.core.spi.ContextAwareImpl
    public final Object e() {
        LocatorImpl locatorImpl = ((Interpreter) this.f13737c).f13574f;
        if (locatorImpl == null) {
            return Interpreter.class.getName().concat("@NA:NA");
        }
        return Interpreter.class.getName() + "@" + locatorImpl.getLineNumber() + ":" + locatorImpl.getColumnNumber();
    }
}
