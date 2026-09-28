package org.apache.xml.security.keys.storage.implementations;

import com.google.android.gms.internal.pal.a;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

/* loaded from: classes5.dex */
public class CertsInFilesystemDirectoryResolver extends StorageResolverSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57228a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57229b;

    /* renamed from: c, reason: collision with root package name */
    private List f57230c;

    public static class FilesystemIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        List f57231a;

        /* renamed from: b, reason: collision with root package name */
        int f57232b = 0;

        public FilesystemIterator(List list) {
            this.f57231a = list;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57232b < this.f57231a.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            List list = this.f57231a;
            int i2 = this.f57232b;
            this.f57232b = i2 + 1;
            return list.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class clsA = f57229b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.storage.implementations.CertsInFilesystemDirectoryResolver");
            f57229b = clsA;
        }
        f57228a = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.keys.storage.StorageResolverSpi
    public Iterator a() {
        return new FilesystemIterator(this.f57230c);
    }
}
