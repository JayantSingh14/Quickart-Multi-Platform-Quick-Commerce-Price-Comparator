package ch.qos.logback.core.joran.event;

import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public class BodyEvent extends SaxEvent {

    /* renamed from: d, reason: collision with root package name */
    public String f13539d;

    public final String toString() {
        StringBuilder sb = new StringBuilder("BodyEvent(");
        String strTrim = this.f13539d;
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        sb.append(strTrim);
        sb.append(")");
        LocatorImpl locatorImpl = this.f13542c;
        sb.append(locatorImpl.getLineNumber());
        sb.append(",");
        sb.append(locatorImpl.getColumnNumber());
        return sb.toString();
    }
}
