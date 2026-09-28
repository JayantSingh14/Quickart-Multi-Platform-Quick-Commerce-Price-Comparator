package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Handshake {

    /* renamed from: a, reason: collision with root package name */
    public final TlsVersion f56249a;

    /* renamed from: b, reason: collision with root package name */
    public final CipherSuite f56250b;

    /* renamed from: c, reason: collision with root package name */
    public final List f56251c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f56252d;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static Handshake a(SSLSession sSLSession) throws IOException {
            final List listL;
            Intrinsics.checkNotNullParameter(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite cipherSuiteB = CipherSuite.f56197b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionA = TlsVersion.Companion.a(protocol);
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                listL = peerCertificates != null ? Util.l(Arrays.copyOf(peerCertificates, peerCertificates.length)) : EmptyList.f53609a;
            } catch (SSLPeerUnverifiedException unused) {
                listL = EmptyList.f53609a;
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new Handshake(tlsVersionA, cipherSuiteB, localCertificates != null ? Util.l(Arrays.copyOf(localCertificates, localCertificates.length)) : EmptyList.f53609a, new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return listL;
                }
            });
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List localCertificates, final Function0 peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f56249a = tlsVersion;
        this.f56250b = cipherSuite;
        this.f56251c = localCertificates;
        this.f56252d = LazyKt.b(new Function0<List<? extends Certificate>>(peerCertificatesFn) { // from class: okhttp3.Handshake$peerCertificates$2

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Lambda f56255c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.f56255c = (Lambda) peerCertificatesFn;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                try {
                    return (List) this.f56255c.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.f53609a;
                }
            }
        });
    }

    public final List a() {
        return (List) this.f56252d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.f56249a == this.f56249a && Intrinsics.b(handshake.f56250b, this.f56250b) && Intrinsics.b(handshake.a(), a()) && Intrinsics.b(handshake.f56251c, this.f56251c);
    }

    public final int hashCode() {
        return this.f56251c.hashCode() + ((a().hashCode() + ((this.f56250b.hashCode() + ((this.f56249a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.r(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f56249a);
        sb.append(" cipherSuite=");
        sb.append(this.f56250b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f56251c;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
