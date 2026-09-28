package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.dtm.DTMManager;
import org.apache.xml.security.transforms.implementations.FuncHereContext;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.apache.xpath.CachedXPathAPI;
import org.apache.xpath.XPath;
import org.apache.xpath.XPathContext;
import org.apache.xpath.compiler.FunctionTable;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class CachedXPathFuncHereAPI {

    /* renamed from: a, reason: collision with root package name */
    static Log f57315a;

    /* renamed from: g, reason: collision with root package name */
    static FunctionTable f57316g;

    /* renamed from: h, reason: collision with root package name */
    static Class f57317h;

    /* renamed from: i, reason: collision with root package name */
    static Class f57318i;

    /* renamed from: j, reason: collision with root package name */
    static Class f57319j;

    /* renamed from: k, reason: collision with root package name */
    static Class f57320k;

    /* renamed from: l, reason: collision with root package name */
    static Class f57321l;

    /* renamed from: m, reason: collision with root package name */
    static Class f57322m;
    static Class n;
    static Class o;
    static Class p;
    static Class q;

    /* renamed from: b, reason: collision with root package name */
    FuncHereContext f57323b;

    /* renamed from: c, reason: collision with root package name */
    DTMManager f57324c;

    /* renamed from: d, reason: collision with root package name */
    XPathContext f57325d;

    /* renamed from: e, reason: collision with root package name */
    String f57326e;

    /* renamed from: f, reason: collision with root package name */
    XPath f57327f;

    static {
        Class clsA = f57317h;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.CachedXPathFuncHereAPI");
            f57317h = clsA;
        }
        f57315a = LogFactory.getLog(clsA.getName());
        f57316g = null;
        a();
    }

    private CachedXPathFuncHereAPI() {
        this.f57323b = null;
        this.f57324c = null;
        this.f57325d = null;
        this.f57326e = null;
        this.f57327f = null;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public XObject b(Node node, Node node2, String str, Node node3) {
        if (this.f57323b == null) {
            this.f57323b = new FuncHereContext(node2, this.f57324c);
        }
        if (node3.getNodeType() == 9) {
            node3 = ((Document) node3).getDocumentElement();
        }
        PrefixResolverDefault prefixResolverDefault = new PrefixResolverDefault(node3);
        if (str != this.f57326e) {
            if (str.indexOf("here()") > 0) {
                this.f57325d.reset();
                this.f57324c = this.f57325d.getDTMManager();
            }
            this.f57327f = a(str, prefixResolverDefault);
            this.f57326e = str;
        }
        return this.f57327f.execute(this.f57323b, this.f57323b.getDTMHandleFromNode(node), prefixResolverDefault);
    }

    public CachedXPathFuncHereAPI(CachedXPathAPI cachedXPathAPI) {
        this.f57323b = null;
        this.f57324c = null;
        this.f57325d = null;
        this.f57326e = null;
        this.f57327f = null;
        this.f57324c = cachedXPathAPI.getXPathContext().getDTMManager();
        this.f57325d = cachedXPathAPI.getXPathContext();
    }

    public static String a(Node node) {
        Node node2;
        if (node.getNodeType() != 3) {
            if (node.getNodeType() == 2) {
                node2 = (Attr) node;
            } else {
                if (node.getNodeType() != 7) {
                    return null;
                }
                node2 = (ProcessingInstruction) node;
            }
            return node2.getNodeValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Node firstChild = node.getParentNode().getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
        return stringBuffer.toString();
    }

    private XPath a(String str, PrefixResolver prefixResolver) throws Throwable {
        XPath xPath;
        Class clsA = f57318i;
        if (clsA == null) {
            clsA = a("java.lang.String");
            f57318i = clsA;
        }
        Class cls = clsA;
        Class clsA2 = f57319j;
        if (clsA2 == null) {
            clsA2 = a("javax.xml.transform.SourceLocator");
            f57319j = clsA2;
        }
        Class cls2 = clsA2;
        Class clsA3 = f57320k;
        if (clsA3 == null) {
            clsA3 = a("org.apache.xml.utils.PrefixResolver");
            f57320k = clsA3;
        }
        Class cls3 = clsA3;
        Class clsA4 = f57321l;
        if (clsA4 == null) {
            clsA4 = a("javax.xml.transform.ErrorListener");
            f57321l = clsA4;
        }
        Class cls4 = clsA4;
        Class clsA5 = f57322m;
        if (clsA5 == null) {
            clsA5 = a("org.apache.xpath.compiler.FunctionTable");
            f57322m = clsA5;
        }
        Class<?>[] clsArr = {cls, cls2, cls3, Integer.TYPE, cls4, clsA5};
        Object[] objArr = {str, null, prefixResolver, new Integer(0), null, f57316g};
        try {
            Class clsA6 = n;
            if (clsA6 == null) {
                clsA6 = a("org.apache.xpath.XPath");
                n = clsA6;
            }
            xPath = (XPath) clsA6.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            xPath = null;
        }
        return xPath == null ? new XPath(str, (SourceLocator) null, prefixResolver, 0, (ErrorListener) null) : xPath;
    }

    public XObject a(Node node, Node node2, String str, PrefixResolver prefixResolver) throws TransformerException {
        if (str != this.f57326e) {
            if (str.indexOf("here()") > 0) {
                this.f57325d.reset();
                this.f57324c = this.f57325d.getDTMManager();
            }
            try {
                this.f57327f = a(str, prefixResolver);
                this.f57326e = str;
            } catch (TransformerException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof ClassNotFoundException) || cause.getMessage().indexOf("FuncHere") <= 0) {
                    throw e2;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
                stringBuffer.append(e2);
                throw new RuntimeException(stringBuffer.toString());
            }
        }
        if (this.f57323b == null) {
            this.f57323b = new FuncHereContext(node2, this.f57324c);
        }
        return this.f57327f.execute(this.f57323b, this.f57323b.getDTMHandleFromNode(node), prefixResolver);
    }

    public NodeList a(Node node, Node node2, String str, Node node3) {
        return b(node, node2, str, node3).nodelist();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error installing function using the static installFunction method"
            java.lang.String r1 = "here"
            java.lang.String r2 = "installFunction"
            java.lang.String r3 = "org.apache.xpath.compiler.FunctionTable"
            java.lang.String r4 = "java.lang.String"
            org.apache.commons.logging.Log r5 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57315a
            java.lang.String r6 = "Registering Here function"
            r5.info(r6)
            r5 = 1
            r6 = 0
            java.lang.Class r7 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57318i     // Catch: java.lang.Throwable -> L1e
            if (r7 != 0) goto L20
            java.lang.Class r7 = a(r4)     // Catch: java.lang.Throwable -> L1e
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57318i = r7     // Catch: java.lang.Throwable -> L1e
            goto L20
        L1e:
            r7 = move-exception
            goto L55
        L20:
            java.lang.Class r8 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.o     // Catch: java.lang.Throwable -> L1e
            if (r8 != 0) goto L2c
            java.lang.String r8 = "org.apache.xpath.Expression"
            java.lang.Class r8 = a(r8)     // Catch: java.lang.Throwable -> L1e
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.o = r8     // Catch: java.lang.Throwable -> L1e
        L2c:
            java.lang.Class[] r7 = new java.lang.Class[]{r7, r8}     // Catch: java.lang.Throwable -> L1e
            java.lang.Class r8 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57322m     // Catch: java.lang.Throwable -> L1e
            if (r8 != 0) goto L3a
            java.lang.Class r8 = a(r3)     // Catch: java.lang.Throwable -> L1e
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57322m = r8     // Catch: java.lang.Throwable -> L1e
        L3a:
            java.lang.reflect.Method r7 = r8.getMethod(r2, r7)     // Catch: java.lang.Throwable -> L1e
            int r8 = r7.getModifiers()     // Catch: java.lang.Throwable -> L1e
            r8 = r8 & 8
            if (r8 == 0) goto L5a
            org.apache.xml.security.transforms.implementations.FuncHere r8 = new org.apache.xml.security.transforms.implementations.FuncHere     // Catch: java.lang.Throwable -> L1e
            r8.<init>()     // Catch: java.lang.Throwable -> L1e
            java.lang.Object[] r8 = new java.lang.Object[]{r1, r8}     // Catch: java.lang.Throwable -> L1e
            r9 = 0
            r7.invoke(r9, r8)     // Catch: java.lang.Throwable -> L1e
            r6 = r5
            goto L5a
        L55:
            org.apache.commons.logging.Log r8 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57315a
            r8.debug(r0, r7)
        L5a:
            java.lang.String r7 = "org.apache.xml.security.transforms.implementations.FuncHere"
            if (r6 != 0) goto La9
            org.apache.xpath.compiler.FunctionTable r8 = new org.apache.xpath.compiler.FunctionTable     // Catch: java.lang.Throwable -> L70
            r8.<init>()     // Catch: java.lang.Throwable -> L70
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57316g = r8     // Catch: java.lang.Throwable -> L70
            java.lang.Class r8 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57318i     // Catch: java.lang.Throwable -> L70
            if (r8 != 0) goto L72
            java.lang.Class r8 = a(r4)     // Catch: java.lang.Throwable -> L70
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57318i = r8     // Catch: java.lang.Throwable -> L70
            goto L72
        L70:
            r1 = move-exception
            goto La4
        L72:
            java.lang.Class r4 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.p     // Catch: java.lang.Throwable -> L70
            if (r4 != 0) goto L7e
            java.lang.String r4 = "java.lang.Class"
            java.lang.Class r4 = a(r4)     // Catch: java.lang.Throwable -> L70
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.p = r4     // Catch: java.lang.Throwable -> L70
        L7e:
            java.lang.Class[] r4 = new java.lang.Class[]{r8, r4}     // Catch: java.lang.Throwable -> L70
            java.lang.Class r8 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57322m     // Catch: java.lang.Throwable -> L70
            if (r8 != 0) goto L8c
            java.lang.Class r8 = a(r3)     // Catch: java.lang.Throwable -> L70
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57322m = r8     // Catch: java.lang.Throwable -> L70
        L8c:
            java.lang.reflect.Method r2 = r8.getMethod(r2, r4)     // Catch: java.lang.Throwable -> L70
            java.lang.Class r3 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.q     // Catch: java.lang.Throwable -> L70
            if (r3 != 0) goto L9a
            java.lang.Class r3 = a(r7)     // Catch: java.lang.Throwable -> L70
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.q = r3     // Catch: java.lang.Throwable -> L70
        L9a:
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r3}     // Catch: java.lang.Throwable -> L70
            org.apache.xpath.compiler.FunctionTable r3 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57316g     // Catch: java.lang.Throwable -> L70
            r2.invoke(r3, r1)     // Catch: java.lang.Throwable -> L70
            goto Laa
        La4:
            org.apache.commons.logging.Log r2 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57315a
            r2.debug(r0, r1)
        La9:
            r5 = r6
        Laa:
            org.apache.commons.logging.Log r0 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57315a
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto Le5
            java.lang.String r0 = " for XPath function 'here()' function in internal table"
            org.apache.commons.logging.Log r1 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.f57315a
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            if (r5 == 0) goto Ldb
            java.lang.String r3 = "Registered class "
            r2.<init>(r3)
            java.lang.Class r3 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.q
            if (r3 != 0) goto Lc9
        Lc3:
            java.lang.Class r3 = a(r7)
            org.apache.xml.security.utils.CachedXPathFuncHereAPI.q = r3
        Lc9:
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.debug(r0)
            goto Le5
        Ldb:
            java.lang.String r3 = "Unable to register class "
            r2.<init>(r3)
            java.lang.Class r3 = org.apache.xml.security.utils.CachedXPathFuncHereAPI.q
            if (r3 != 0) goto Lc9
            goto Lc3
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.CachedXPathFuncHereAPI.a():void");
    }
}
