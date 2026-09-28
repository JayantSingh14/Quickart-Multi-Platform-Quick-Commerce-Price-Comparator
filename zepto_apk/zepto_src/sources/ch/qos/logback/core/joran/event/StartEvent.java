package ch.qos.logback.core.joran.event;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public class StartEvent extends SaxEvent {

    /* renamed from: d, reason: collision with root package name */
    public final AttributesImpl f13547d;

    public StartEvent(String str, String str2, String str3, Attributes attributes, Locator locator) {
        super(str, str2, str3, locator);
        this.f13547d = new AttributesImpl(attributes);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartEvent(");
        sb.append(this.f13541b);
        AttributesImpl attributesImpl = this.f13547d;
        if (attributesImpl != null) {
            for (int i2 = 0; i2 < attributesImpl.getLength(); i2++) {
                if (i2 > 0) {
                    sb.append(' ');
                }
                sb.append(attributesImpl.getLocalName(i2));
                sb.append("=\"");
                sb.append(attributesImpl.getValue(i2));
                sb.append("\"");
            }
        }
        sb.append(")  [");
        LocatorImpl locatorImpl = this.f13542c;
        sb.append(locatorImpl.getLineNumber());
        sb.append(",");
        sb.append(locatorImpl.getColumnNumber());
        sb.append("]");
        return sb.toString();
    }
}
