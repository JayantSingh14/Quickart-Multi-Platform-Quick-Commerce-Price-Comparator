package ch.qos.logback.core.joran.event;

import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public class SaxEvent {

    /* renamed from: a, reason: collision with root package name */
    public final String f13540a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13541b;

    /* renamed from: c, reason: collision with root package name */
    public final LocatorImpl f13542c;

    public SaxEvent(String str, String str2, String str3, Locator locator) {
        this.f13540a = str2;
        this.f13541b = str3;
        this.f13542c = new LocatorImpl(locator);
    }
}
