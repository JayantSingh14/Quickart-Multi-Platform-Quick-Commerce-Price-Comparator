package ch.qos.logback.core.joran.event;

import android.support.v4.media.b;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.ContextAwareImpl;
import ch.qos.logback.core.status.WarnStatus;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes3.dex */
public class SaxEventRecorder extends DefaultHandler implements ContextAware {

    /* renamed from: a, reason: collision with root package name */
    public final ContextAwareImpl f13543a;

    /* renamed from: c, reason: collision with root package name */
    public Locator f13545c;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13544b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ElementPath f13546d = new ElementPath();

    public SaxEventRecorder(Context context) {
        this.f13543a = new ContextAwareImpl(context, this);
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public final void V(Context context) {
        this.f13543a.V(context);
    }

    public final void b(String str) {
        this.f13543a.b(str);
    }

    public final void c(String str, Throwable th) {
        this.f13543a.c(str, th);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i2, int i3) {
        String str = new String(cArr, i2, i3);
        ArrayList arrayList = this.f13544b;
        SaxEvent saxEvent = arrayList.isEmpty() ? null : (SaxEvent) b.c(1, arrayList);
        if (saxEvent instanceof BodyEvent) {
            BodyEvent bodyEvent = (BodyEvent) saxEvent;
            bodyEvent.f13539d = b.r(new StringBuilder(), bodyEvent.f13539d, str);
        } else {
            if (str.trim().length() == 0) {
                return;
            }
            BodyEvent bodyEvent2 = new BodyEvent(null, null, null, this.f13545c);
            bodyEvent2.f13539d = str;
            arrayList.add(bodyEvent2);
        }
    }

    public final void d(InputSource inputSource) throws ParserConfigurationException, SAXException, JoranException, IOException {
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setValidating(false);
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            sAXParserFactoryNewInstance.setNamespaceAware(true);
            try {
                sAXParserFactoryNewInstance.newSAXParser().parse(inputSource, this);
            } catch (IOException e2) {
                c("I/O error occurred while parsing xml file", e2);
                throw new JoranException("I/O error occurred while parsing xml file", e2);
            } catch (SAXException e3) {
                throw new JoranException("Problem parsing XML document. See previously reported errors.", e3);
            } catch (Exception e4) {
                c("Unexpected exception while parsing XML document.", e4);
                throw new JoranException("Unexpected exception while parsing XML document.", e4);
            }
        } catch (Exception e5) {
            c("Parser configuration error occurred", e5);
            throw new JoranException("Parser configuration error occurred", e5);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.f13544b.add(new EndEvent(str, str2, str3, this.f13545c));
        ArrayList arrayList = this.f13546d.f13556a;
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public final void error(SAXParseException sAXParseException) {
        b("XML_PARSING - Parsing error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber());
        b(sAXParseException.toString());
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public final void fatalError(SAXParseException sAXParseException) {
        b("XML_PARSING - Parsing fatal error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber());
        b(sAXParseException.toString());
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void setDocumentLocator(Locator locator) {
        this.f13545c = locator;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startDocument() {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        String str4 = (str2 == null || str2.length() < 1) ? str3 : str2;
        ElementPath elementPath = this.f13546d;
        elementPath.f13556a.add(str4);
        new ElementPath().f13556a.addAll(elementPath.f13556a);
        this.f13544b.add(new StartEvent(str, str2, str3, attributes, this.f13545c));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public final void warning(SAXParseException sAXParseException) {
        String str = "XML_PARSING - Parsing warning on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber();
        ContextAwareImpl contextAwareImpl = this.f13543a;
        contextAwareImpl.getClass();
        contextAwareImpl.d(new WarnStatus(1, str, contextAwareImpl.e(), sAXParseException));
    }
}
