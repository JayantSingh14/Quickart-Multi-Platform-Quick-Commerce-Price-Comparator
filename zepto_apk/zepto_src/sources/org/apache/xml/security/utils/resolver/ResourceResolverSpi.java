package org.apache.xml.security.utils.resolver;

import com.google.android.gms.internal.pal.a;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

/* loaded from: classes5.dex */
public abstract class ResourceResolverSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57380a;

    /* renamed from: c, reason: collision with root package name */
    static Class f57381c;

    /* renamed from: b, reason: collision with root package name */
    protected Map f57382b = null;

    static {
        Class clsB = f57381c;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.utils.resolver.ResourceResolverSpi");
            f57381c = clsB;
        }
        f57380a = LogFactory.getLog(clsB.getName());
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public String a(String str) {
        Map map = this.f57382b;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    public abstract XMLSignatureInput a(Attr attr, String str);

    public abstract boolean b(Attr attr, String str);

    public void a(Map map) {
        if (map != null) {
            if (this.f57382b == null) {
                this.f57382b = new HashMap();
            }
            this.f57382b.putAll(map);
        }
    }

    public boolean a() {
        return false;
    }
}
