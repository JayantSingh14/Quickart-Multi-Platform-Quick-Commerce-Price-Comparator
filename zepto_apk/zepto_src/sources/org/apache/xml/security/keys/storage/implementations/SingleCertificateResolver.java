package org.apache.xml.security.keys.storage.implementations;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

/* loaded from: classes5.dex */
public class SingleCertificateResolver extends StorageResolverSpi {

    /* renamed from: a, reason: collision with root package name */
    X509Certificate f57238a;

    public static class InternalIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        boolean f57239a = false;

        /* renamed from: b, reason: collision with root package name */
        X509Certificate f57240b;

        public InternalIterator(X509Certificate x509Certificate) {
            this.f57240b = x509Certificate;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f57239a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f57239a) {
                throw new NoSuchElementException();
            }
            this.f57239a = true;
            return this.f57240b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    @Override // org.apache.xml.security.keys.storage.StorageResolverSpi
    public Iterator a() {
        return new InternalIterator(this.f57238a);
    }
}
