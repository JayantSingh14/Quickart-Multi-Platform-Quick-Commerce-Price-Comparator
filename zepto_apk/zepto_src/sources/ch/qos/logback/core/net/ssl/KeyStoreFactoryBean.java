package ch.qos.logback.core.net.ssl;

import ch.qos.logback.core.util.LocationUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* loaded from: classes3.dex */
public class KeyStoreFactoryBean {

    /* renamed from: a, reason: collision with root package name */
    public String f13636a;

    /* renamed from: b, reason: collision with root package name */
    public String f13637b;

    /* renamed from: c, reason: collision with root package name */
    public String f13638c;

    /* renamed from: d, reason: collision with root package name */
    public String f13639d;

    public final KeyStore a() throws IOException {
        String str = this.f13636a;
        if (str == null) {
            throw new IllegalArgumentException("location is required");
        }
        InputStream inputStreamOpenStream = null;
        try {
            try {
                try {
                    inputStreamOpenStream = LocationUtil.a(str).openStream();
                    KeyStore keyStoreB = b();
                    String str2 = this.f13639d;
                    if (str2 == null) {
                        str2 = "changeit";
                    }
                    keyStoreB.load(inputStreamOpenStream, str2.toCharArray());
                    if (inputStreamOpenStream != null) {
                        try {
                            return keyStoreB;
                        } catch (IOException e2) {
                        }
                    }
                    return keyStoreB;
                } catch (FileNotFoundException unused) {
                    throw new KeyStoreException(this.f13636a + ": file not found");
                } catch (NoSuchAlgorithmException unused2) {
                    String str3 = this.f13638c;
                    if (str3 == null) {
                        str3 = "JKS";
                    }
                    throw new NoSuchAlgorithmException("no such keystore type: ".concat(str3));
                }
            } catch (NoSuchProviderException unused3) {
                throw new NoSuchProviderException("no such keystore provider: " + this.f13637b);
            } catch (Exception e3) {
                throw new KeyStoreException(this.f13636a + ": " + e3.getMessage(), e3);
            }
        } finally {
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (IOException e22) {
                    e22.printStackTrace(System.err);
                }
            }
        }
    }

    public final KeyStore b() {
        String str = this.f13637b;
        if (str != null) {
            String str2 = this.f13638c;
            return KeyStore.getInstance(str2 != null ? str2 : "JKS", str);
        }
        String str3 = this.f13638c;
        return KeyStore.getInstance(str3 != null ? str3 : "JKS");
    }
}
