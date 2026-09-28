package org.apache.xml.security.keys.storage;

import com.google.android.gms.internal.pal.a;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes5.dex */
public class StorageResolver {

    /* renamed from: a, reason: collision with root package name */
    static Log f57222a;

    /* renamed from: d, reason: collision with root package name */
    static Class f57223d;

    /* renamed from: b, reason: collision with root package name */
    List f57224b = null;

    /* renamed from: c, reason: collision with root package name */
    Iterator f57225c = null;

    public static class StorageResolverIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        Iterator f57226a;

        /* renamed from: b, reason: collision with root package name */
        Iterator f57227b;

        private Iterator a() {
            while (this.f57226a.hasNext()) {
                Iterator itA = ((StorageResolverSpi) this.f57226a.next()).a();
                if (itA.hasNext()) {
                    return itA;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator it = this.f57227b;
            if (it == null) {
                return false;
            }
            if (it.hasNext()) {
                return true;
            }
            Iterator itA = a();
            this.f57227b = itA;
            return itA != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                return this.f57227b.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class clsA = f57223d;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.storage.StorageResolver");
            f57223d = clsA;
        }
        f57222a = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
