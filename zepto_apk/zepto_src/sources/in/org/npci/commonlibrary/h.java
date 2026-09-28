package in.org.npci.commonlibrary;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes4.dex */
public class h extends DefaultHandler {

    /* renamed from: a, reason: collision with root package name */
    private List<g> f49208a;

    /* renamed from: b, reason: collision with root package name */
    private List<j> f49209b;

    /* renamed from: c, reason: collision with root package name */
    private g f49210c;

    /* renamed from: d, reason: collision with root package name */
    private j f49211d;

    /* renamed from: e, reason: collision with root package name */
    private String f49212e;

    public h() {
        this.f49208a = new ArrayList();
        this.f49209b = new ArrayList();
        this.f49210c = null;
        this.f49211d = null;
        this.f49212e = null;
    }

    public List<g> a() {
        return this.f49208a;
    }

    public List<j> b() {
        return this.f49209b;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) {
        this.f49212e += String.copyValueOf(cArr, i2, i3).trim();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        List list;
        Object obj;
        str3.getClass();
        switch (str3) {
            case "key":
                list = this.f49208a;
                obj = this.f49210c;
                list.add(obj);
                break;
            case "param":
                list = this.f49209b;
                obj = this.f49211d;
                list.add(obj);
                break;
            case "paramValue":
                this.f49211d.b(this.f49212e);
                break;
            case "keyValue":
                this.f49210c.c(this.f49212e);
                break;
        }
        this.f49212e = "";
    }

    public void finalize() {
        System.out.println("KeyParser Destroyed");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        str3.getClass();
        if (str3.equals("key")) {
            g gVar = new g();
            this.f49210c = gVar;
            gVar.a(attributes.getValue(CLConstants.FIELD_KI));
            this.f49210c.b(attributes.getValue("code"));
        } else if (str3.equals("param")) {
            j jVar = new j();
            this.f49211d = jVar;
            jVar.a(attributes.getValue("code"));
            this.f49211d.c(attributes.getValue("owner"));
        }
        this.f49212e = "";
    }

    public h(String str) throws SAXException, IOException, c {
        this.f49208a = new ArrayList();
        this.f49209b = new ArrayList();
        this.f49210c = null;
        this.f49211d = null;
        this.f49212e = null;
        this.f49208a = new ArrayList();
        this.f49209b = new ArrayList();
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(str)), this);
        } catch (IOException | ParserConfigurationException | SAXException unused) {
            throw new c(d.PARSER_MISCONFIG);
        }
    }
}
