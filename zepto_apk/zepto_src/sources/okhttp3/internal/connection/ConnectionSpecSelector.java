package okhttp3.internal.connection;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Util;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class ConnectionSpecSelector {

    /* renamed from: a, reason: collision with root package name */
    public final List f56485a;

    /* renamed from: b, reason: collision with root package name */
    public int f56486b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56487c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f56488d;

    public ConnectionSpecSelector(List connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.f56485a = connectionSpecs;
    }

    public final ConnectionSpec a(SSLSocket sslSocket) throws UnknownServiceException {
        ConnectionSpec connectionSpec;
        int i2;
        boolean z;
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i3 = this.f56486b;
        List list = this.f56485a;
        int size = list.size();
        while (true) {
            if (i3 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) list.get(i3);
            if (connectionSpec.b(sslSocket)) {
                this.f56486b = i3 + 1;
                break;
            }
            i3++;
        }
        if (connectionSpec == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.f56488d);
            sb.append(", modes=");
            sb.append(list);
            sb.append(", supported protocols=");
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.c(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i4 = this.f56486b;
        int size2 = list.size();
        while (true) {
            i2 = 0;
            if (i4 >= size2) {
                z = false;
                break;
            }
            if (((ConnectionSpec) list.get(i4)).b(sslSocket)) {
                z = true;
                break;
            }
            i4++;
        }
        this.f56487c = z;
        boolean z2 = this.f56488d;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String[] strArr = connectionSpec.f56215c;
        if (strArr != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = Util.p(enabledCipherSuites, strArr, CipherSuite.f56198c);
        } else {
            cipherSuitesIntersection = sslSocket.getEnabledCipherSuites();
        }
        String[] strArr2 = connectionSpec.f56216d;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols2, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = Util.p(enabledProtocols2, strArr2, ComparisonsKt.c());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        CipherSuite$Companion$ORDER_BY_NAME$1 comparator = CipherSuite.f56198c;
        byte[] bArr = Util.f56394a;
        Intrinsics.checkNotNullParameter(supportedCipherSuites, "<this>");
        Intrinsics.checkNotNullParameter("TLS_FALLBACK_SCSV", CLConstants.FIELD_PAY_INFO_VALUE);
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = supportedCipherSuites.length;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (comparator.compare(supportedCipherSuites[i2], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i2++;
        }
        if (z2 && i2 != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String value = supportedCipherSuites[i2];
            Intrinsics.checkNotNullExpressionValue(value, "supportedCipherSuites[indexOfFallbackScsv]");
            Intrinsics.checkNotNullParameter(cipherSuitesIntersection, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length + 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            cipherSuitesIntersection = (String[]) objArrCopyOf;
            Intrinsics.checkNotNullParameter(cipherSuitesIntersection, "<this>");
            cipherSuitesIntersection[cipherSuitesIntersection.length - 1] = value;
        }
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.f56217a = connectionSpec.f56213a;
        builder.f56218b = strArr;
        builder.f56219c = strArr2;
        builder.f56220d = connectionSpec.f56214b;
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        builder.b((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        builder.d((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        ConnectionSpec connectionSpecA = builder.a();
        if (connectionSpecA.c() != null) {
            sslSocket.setEnabledProtocols(connectionSpecA.f56216d);
        }
        if (connectionSpecA.a() != null) {
            sslSocket.setEnabledCipherSuites(connectionSpecA.f56215c);
        }
        return connectionSpec;
    }
}
