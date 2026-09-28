package in.org.npci.commonlibrary.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.Init;
import org.npci.upi.security.pinactivitycomponent.q;
import org.xml.sax.SAXException;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Certificate f49173a;

    public b() {
        try {
            Init.b();
            this.f49173a = b(new String(in.org.npci.commonlibrary.a.a("c2lnbmVyLmNydA==", 2)));
        } catch (CertificateException e2) {
            q.a("commonLibrary", e2);
        }
    }

    private Certificate b(String str) throws IOException, CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(str);
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

    public boolean a(String str) {
        if (this.f49173a == null) {
            try {
                this.f49173a = b(new String(in.org.npci.commonlibrary.a.a("c2lnbmVyLmNydA==", 2)));
            } catch (CertificateException e2) {
                System.out.println("Error in loading certificate.");
                q.a("commonLibrary", e2);
                return false;
            }
        }
        try {
            return a.a(a.a(str), this.f49173a.getPublicKey());
        } catch (ParserConfigurationException | SAXException | Exception e3) {
            q.a("commonLibrary", e3);
            return false;
        }
    }
}
