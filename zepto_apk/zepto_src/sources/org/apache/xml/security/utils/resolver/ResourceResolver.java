package org.apache.xml.security.utils.resolver;

import com.google.android.gms.internal.pal.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

/* loaded from: classes5.dex */
public class ResourceResolver {

    /* renamed from: a, reason: collision with root package name */
    static Log f57372a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f57373b;

    /* renamed from: c, reason: collision with root package name */
    static List f57374c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f57375d;

    /* renamed from: f, reason: collision with root package name */
    static Class f57376f;

    /* renamed from: e, reason: collision with root package name */
    protected ResourceResolverSpi f57377e;

    static {
        Class clsB = f57376f;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.utils.resolver.ResourceResolver");
            f57376f = clsB;
        }
        f57372a = LogFactory.getLog(clsB.getName());
        f57373b = false;
        f57374c = null;
        f57375d = true;
    }

    private ResourceResolver(String str) {
        this.f57377e = null;
        this.f57377e = (ResourceResolverSpi) Class.forName(str).newInstance();
    }

    public static final ResourceResolver a(Attr attr, String str) throws ResourceResolverException {
        int size = f57374c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ResourceResolver resourceResolver = (ResourceResolver) f57374c.get(i2);
            try {
                ResourceResolver resourceResolver2 = (f57375d || resourceResolver.f57377e.a()) ? resourceResolver : new ResourceResolver((ResourceResolverSpi) resourceResolver.f57377e.getClass().newInstance());
                if (f57372a.isDebugEnabled()) {
                    f57372a.debug("check resolvability by class ".concat(resourceResolver.f57377e.getClass().getName()));
                }
                if (resourceResolver != null && resourceResolver2.c(attr, str)) {
                    if (i2 != 0) {
                        List list = (List) ((ArrayList) f57374c).clone();
                        list.remove(i2);
                        list.add(0, resourceResolver);
                        f57374c = list;
                    }
                    return resourceResolver2;
                }
            } catch (IllegalAccessException e2) {
                throw new ResourceResolverException("", e2, attr, str);
            } catch (InstantiationException e3) {
                throw new ResourceResolverException("", e3, attr, str);
            }
        }
        throw new ResourceResolverException("utils.resolver.noClass", new Object[]{attr != null ? attr.getNodeValue() : "null", str}, attr, str);
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private boolean c(Attr attr, String str) {
        return this.f57377e.b(attr, str);
    }

    public ResourceResolver(ResourceResolverSpi resourceResolverSpi) {
        this.f57377e = resourceResolverSpi;
    }

    public static final ResourceResolver a(Attr attr, String str, List list) {
        int size;
        if (f57372a.isDebugEnabled()) {
            Log log = f57372a;
            StringBuffer stringBuffer = new StringBuffer("I was asked to create a ResourceResolver and got ");
            stringBuffer.append(list == null ? 0 : list.size());
            log.debug(stringBuffer.toString());
            Log log2 = f57372a;
            StringBuffer stringBuffer2 = new StringBuffer(" extra resolvers to my existing ");
            stringBuffer2.append(f57374c.size());
            stringBuffer2.append(" system-wide resolvers");
            log2.debug(stringBuffer2.toString());
        }
        if (list != null && (size = list.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ResourceResolver resourceResolver = (ResourceResolver) list.get(i2);
                if (resourceResolver != null) {
                    String name = resourceResolver.f57377e.getClass().getName();
                    if (f57372a.isDebugEnabled()) {
                        f57372a.debug("check resolvability by class ".concat(name));
                    }
                    if (resourceResolver.c(attr, str)) {
                        return resourceResolver;
                    }
                }
            }
        }
        return a(attr, str);
    }

    public static void a() {
        if (f57373b) {
            return;
        }
        f57374c = new ArrayList(10);
        f57373b = true;
    }

    public static void a(String str) {
        a(str, false);
    }

    private static void a(String str, boolean z) {
        Log log;
        StringBuffer stringBuffer;
        try {
            ResourceResolver resourceResolver = new ResourceResolver(str);
            if (z) {
                f57374c.add(0, resourceResolver);
                f57372a.debug("registered resolver");
            } else {
                f57374c.add(resourceResolver);
            }
            if (resourceResolver.f57377e.a()) {
                return;
            }
            f57375d = false;
        } catch (Exception unused) {
            log = f57372a;
            stringBuffer = new StringBuffer("Error loading resolver ");
            stringBuffer.append(str);
            stringBuffer.append(" disabling it");
            log.warn(stringBuffer.toString());
        } catch (NoClassDefFoundError unused2) {
            log = f57372a;
            stringBuffer = new StringBuffer("Error loading resolver ");
            stringBuffer.append(str);
            stringBuffer.append(" disabling it");
            log.warn(stringBuffer.toString());
        }
    }

    public void a(Map map) {
        this.f57377e.a(map);
    }

    public XMLSignatureInput b(Attr attr, String str) {
        return this.f57377e.a(attr, str);
    }
}
