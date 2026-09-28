package org.apache.xml.security.keys.keyresolver.implementations;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

/* loaded from: classes5.dex */
public class X509IssuerSerialResolver extends KeyResolverSpi {

    /* renamed from: c, reason: collision with root package name */
    static Log f57216c;

    /* renamed from: d, reason: collision with root package name */
    static Class f57217d;

    static {
        Class clsA = f57217d;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.keyresolver.implementations.X509IssuerSerialResolver");
            f57217d = clsA;
        }
        f57216c = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
