package org.xbill.DNS.config;

import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes5.dex */
public class SunJvmResolverConfigProvider extends BaseResolverConfigProvider {
    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws IllegalAccessException, InitializationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        reset();
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object objInvoke = cls.getDeclaredMethod(AbstractCircuitBreaker.PROPERTY_NAME, null).invoke(null, null);
            Iterator it = ((List) cls.getMethod("nameservers", null).invoke(objInvoke, null)).iterator();
            while (it.hasNext()) {
                addNameserver(new InetSocketAddress((String) it.next(), 53));
            }
            Iterator it2 = ((List) cls.getMethod("searchlist", null).invoke(objInvoke, null)).iterator();
            while (it2.hasNext()) {
                addSearchPath((String) it2.next());
            }
        } catch (Exception e2) {
            throw new InitializationException(e2);
        }
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return Boolean.getBoolean("dnsjava.configprovider.sunjvm.enabled");
    }
}
