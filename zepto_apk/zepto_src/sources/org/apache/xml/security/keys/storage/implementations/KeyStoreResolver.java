package org.apache.xml.security.keys.storage.implementations;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

/* loaded from: classes5.dex */
public class KeyStoreResolver extends StorageResolverSpi {

    /* renamed from: a, reason: collision with root package name */
    KeyStore f57233a;

    public static class KeyStoreIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        KeyStore f57235a;

        /* renamed from: b, reason: collision with root package name */
        Enumeration f57236b;

        /* renamed from: c, reason: collision with root package name */
        Certificate f57237c = null;

        public KeyStoreIterator(KeyStore keyStore) {
            this.f57236b = null;
            try {
                this.f57235a = keyStore;
                this.f57236b = keyStore.aliases();
            } catch (KeyStoreException unused) {
                this.f57236b = new Enumeration(this) { // from class: org.apache.xml.security.keys.storage.implementations.KeyStoreResolver.1

                    /* renamed from: a, reason: collision with root package name */
                    private final KeyStoreIterator f57234a;

                    {
                        this.f57234a = this;
                    }

                    @Override // java.util.Enumeration
                    public boolean hasMoreElements() {
                        return false;
                    }

                    @Override // java.util.Enumeration
                    public Object nextElement() {
                        return null;
                    }
                };
            }
        }

        private Certificate a() throws KeyStoreException {
            while (this.f57236b.hasMoreElements()) {
                try {
                    Certificate certificate = this.f57235a.getCertificate((String) this.f57236b.nextElement());
                    if (certificate != null) {
                        return certificate;
                    }
                } catch (KeyStoreException unused) {
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f57237c == null) {
                this.f57237c = a();
            }
            return this.f57237c != null;
        }

        @Override // java.util.Iterator
        public Object next() throws KeyStoreException {
            if (this.f57237c == null) {
                Certificate certificateA = a();
                this.f57237c = certificateA;
                if (certificateA == null) {
                    throw new NoSuchElementException();
                }
            }
            Certificate certificate = this.f57237c;
            this.f57237c = null;
            return certificate;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    @Override // org.apache.xml.security.keys.storage.StorageResolverSpi
    public Iterator a() {
        return new KeyStoreIterator(this.f57233a);
    }
}
