package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.Base64;
import okio.ByteString;
import okio.SegmentedByteString;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CertificatePinner {

    /* renamed from: c, reason: collision with root package name */
    public static final CertificatePinner f56188c = new CertificatePinner(CollectionsKt.h0(new Builder().f56191a), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f56189a;

    /* renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f56190b;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f56191a = new ArrayList();
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static String a(X509Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            Intrinsics.checkNotNullParameter(certificate, "<this>");
            ByteString byteString = ByteString.f56924d;
            byte[] encoded = certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return "sha256/".concat(Base64.b(ByteString.Companion.d(SegmentedByteString.f56900b, encoded).c(MessageDigestAlgorithms.SHA_256).f56925a));
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Pin {
        public static void a(String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            StringsKt.O(null, "**.", false);
            throw null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            pin.getClass();
            pin.getClass();
            pin.getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public CertificatePinner(Set pins, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.f56189a = pins;
        this.f56190b = certificateChainCleaner;
    }

    public final void a(final String hostname, final List peerCertificates) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        b(hostname, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List listA;
                CertificateChainCleaner certificateChainCleaner = this.f56192c.f56190b;
                List list = peerCertificates;
                if (certificateChainCleaner != null && (listA = certificateChainCleaner.a(hostname, list)) != null) {
                    list = listA;
                }
                List<Certificate> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
                for (Certificate certificate : list2) {
                    Intrinsics.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void b(String hostname, Function0 cleanedPeerCertificatesFn) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        EmptyList emptyList = EmptyList.f53609a;
        Iterator it = this.f56189a.iterator();
        if (!it.hasNext()) {
            emptyList.getClass();
        } else {
            ((Pin) it.next()).getClass();
            Pin.a(hostname);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Intrinsics.b(certificatePinner.f56189a, this.f56189a) && Intrinsics.b(certificatePinner.f56190b, this.f56190b);
    }

    public final int hashCode() {
        int iHashCode = (this.f56189a.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.f56190b;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }
}
