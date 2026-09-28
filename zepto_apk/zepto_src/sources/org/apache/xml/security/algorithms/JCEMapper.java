package org.apache.xml.security.algorithms;

import com.google.android.gms.internal.pal.a;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class JCEMapper {

    /* renamed from: a, reason: collision with root package name */
    static Log f57085a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57086b;

    /* renamed from: c, reason: collision with root package name */
    private static Map f57087c;

    /* renamed from: d, reason: collision with root package name */
    private static Map f57088d;

    /* renamed from: e, reason: collision with root package name */
    private static String f57089e;

    public static class Algorithm {

        /* renamed from: a, reason: collision with root package name */
        String f57090a;

        /* renamed from: b, reason: collision with root package name */
        String f57091b;

        /* renamed from: c, reason: collision with root package name */
        String f57092c;

        public Algorithm(Element element) {
            this.f57090a = element.getAttribute("AlgorithmClass");
            this.f57091b = element.getAttribute("KeyLength");
            this.f57092c = element.getAttribute("RequiredKey");
        }
    }

    static {
        Class clsB = f57086b;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.algorithms.JCEMapper");
            f57086b = clsB;
        }
        f57085a = LogFactory.getLog(clsB.getName());
        f57089e = null;
    }

    public static String a() {
        return f57089e;
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public static String a(String str) {
        if (f57085a.isDebugEnabled()) {
            Log log = f57085a;
            StringBuffer stringBuffer = new StringBuffer("Request for URI ");
            stringBuffer.append(str);
            log.debug(stringBuffer.toString());
        }
        return (String) f57087c.get(str);
    }

    public static void a(Element element) {
        b((Element) element.getElementsByTagName("Algorithms").item(0));
    }

    public static void b(Element element) {
        Element[] elementArrA = XMLUtils.a(element.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Algorithm");
        f57087c = new HashMap(elementArrA.length * 2);
        f57088d = new HashMap(elementArrA.length * 2);
        for (Element element2 : elementArrA) {
            String attribute = element2.getAttribute("URI");
            f57087c.put(attribute, element2.getAttribute("JCEName"));
            f57088d.put(attribute, new Algorithm(element2));
        }
    }
}
