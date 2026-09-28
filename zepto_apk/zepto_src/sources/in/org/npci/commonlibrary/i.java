package in.org.npci.commonlibrary;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import org.npci.upi.security.pinactivitycomponent.q;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Certificate f49213a;

    static {
        try {
            f49213a = e.a("signer.crt");
        } catch (CertificateException e2) {
            q.a("commonLibrary", e2);
        }
    }

    public static PublicKey a() {
        Certificate certificate = f49213a;
        if (certificate != null) {
            return certificate.getPublicKey();
        }
        return null;
    }
}
