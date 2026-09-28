package org.apache.xml.security.keys.keyresolver.implementations;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

/* loaded from: classes5.dex */
public class RetrievalMethodResolver extends KeyResolverSpi {

    /* renamed from: c, reason: collision with root package name */
    static Log f57212c;

    /* renamed from: d, reason: collision with root package name */
    static Class f57213d;

    static {
        Class clsA = f57213d;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.keyresolver.implementations.RetrievalMethodResolver");
            f57213d = clsA;
        }
        f57212c = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
