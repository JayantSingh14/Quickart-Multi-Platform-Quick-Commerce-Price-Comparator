package org.apache.xml.security.keys.keyresolver;

import com.google.android.gms.internal.pal.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolver;

/* loaded from: classes5.dex */
public class KeyResolver {

    /* renamed from: a, reason: collision with root package name */
    static Log f57198a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f57199b;

    /* renamed from: c, reason: collision with root package name */
    static List f57200c;

    /* renamed from: f, reason: collision with root package name */
    static Class f57201f;

    /* renamed from: d, reason: collision with root package name */
    protected KeyResolverSpi f57202d;

    /* renamed from: e, reason: collision with root package name */
    protected StorageResolver f57203e = null;

    public static class ResolverIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        Iterator f57204a;

        /* renamed from: b, reason: collision with root package name */
        int f57205b;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57204a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f57205b++;
            KeyResolver keyResolver = (KeyResolver) this.f57204a.next();
            if (keyResolver != null) {
                return keyResolver.f57202d;
            }
            throw new RuntimeException("utils.resolver.noClass");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove resolvers using the iterator");
        }
    }

    static {
        Class clsB = f57201f;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.keys.keyresolver.KeyResolver");
            f57201f = clsB;
        }
        f57198a = LogFactory.getLog(clsB.getName());
        f57199b = false;
        f57200c = null;
    }

    private KeyResolver(String str) {
        this.f57202d = null;
        KeyResolverSpi keyResolverSpi = (KeyResolverSpi) Class.forName(str).newInstance();
        this.f57202d = keyResolverSpi;
        keyResolverSpi.a(true);
    }

    public static void a() {
        if (f57199b) {
            return;
        }
        f57200c = new ArrayList(10);
        f57199b = true;
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public static void a(String str) {
        f57200c.add(new KeyResolver(str));
    }
}
