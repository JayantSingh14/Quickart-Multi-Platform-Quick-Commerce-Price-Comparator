package ch.qos.logback.core.joran.event;

import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public class EndEvent extends SaxEvent {
    public final String toString() {
        StringBuilder sb = new StringBuilder("  EndEvent(");
        sb.append(this.f13541b);
        sb.append(")  [");
        LocatorImpl locatorImpl = this.f13542c;
        sb.append(locatorImpl.getLineNumber());
        sb.append(",");
        sb.append(locatorImpl.getColumnNumber());
        sb.append("]");
        return sb.toString();
    }
}
