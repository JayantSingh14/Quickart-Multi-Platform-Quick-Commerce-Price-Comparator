package in.org.npci.commonlibrary;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes4.dex */
public class e {
    public static Certificate a(String str) throws IOException, CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = e.class.getClassLoader().getResourceAsStream(str);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
        try {
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            try {
                resourceAsStream.close();
            } catch (IOException unused2) {
            }
            return certificateGenerateCertificate;
        } finally {
        }
    }
}
