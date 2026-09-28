package okhttp3.internal.platform;

import android.support.v4.media.b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

@Metadata
/* loaded from: classes.dex */
public class Platform {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Platform f56791a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f56792b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static ArrayList a(List protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).f56330a);
            }
            return arrayList2;
        }

        public static byte[] b(List protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            Buffer buffer = new Buffer();
            Iterator it = a(protocols).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                buffer.O1(str.length());
                buffer.X1(str);
            }
            return buffer.r0(buffer.f56914b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    static {
        /*
            java.lang.String r0 = "java.vm.name"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "Dalvik"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 == 0) goto L76
            java.util.Map r0 = okhttp3.internal.platform.android.AndroidLog.f56796b
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L19:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            java.util.logging.Logger r3 = java.util.logging.Logger.getLogger(r3)
            java.util.concurrent.CopyOnWriteArraySet r4 = okhttp3.internal.platform.android.AndroidLog.f56795a
            boolean r4 = r4.add(r3)
            if (r4 == 0) goto L19
            r3.setUseParentHandlers(r1)
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r2, r4)
            if (r4 == 0) goto L4a
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            goto L56
        L4a:
            r4 = 4
            boolean r2 = android.util.Log.isLoggable(r2, r4)
            if (r2 == 0) goto L54
            java.util.logging.Level r2 = java.util.logging.Level.INFO
            goto L56
        L54:
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
        L56:
            r3.setLevel(r2)
            okhttp3.internal.platform.android.AndroidLogHandler r2 = okhttp3.internal.platform.android.AndroidLogHandler.f56797a
            r3.addHandler(r2)
            goto L19
        L5f:
            boolean r0 = okhttp3.internal.platform.Android10Platform.f56768d
            if (r0 == 0) goto L69
            okhttp3.internal.platform.Android10Platform r0 = new okhttp3.internal.platform.Android10Platform
            r0.<init>()
            goto L6a
        L69:
            r0 = 0
        L6a:
            if (r0 != 0) goto Ldc
            boolean r0 = okhttp3.internal.platform.AndroidPlatform.f56770e
            okhttp3.internal.platform.AndroidPlatform r0 = okhttp3.internal.platform.AndroidPlatform.Companion.a()
            kotlin.jvm.internal.Intrinsics.c(r0)
            goto Ldc
        L76:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r2 = "Conscrypt"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L91
            boolean r0 = okhttp3.internal.platform.ConscryptPlatform.f56777d
            okhttp3.internal.platform.ConscryptPlatform r0 = okhttp3.internal.platform.ConscryptPlatform.Companion.b()
            if (r0 == 0) goto L91
            goto Ldc
        L91:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r2 = "BC"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto Lac
            boolean r0 = okhttp3.internal.platform.BouncyCastlePlatform.f56775d
            okhttp3.internal.platform.BouncyCastlePlatform r0 = okhttp3.internal.platform.BouncyCastlePlatform.Companion.a()
            if (r0 == 0) goto Lac
            goto Ldc
        Lac:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "OpenJSSE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto Lc7
            boolean r0 = okhttp3.internal.platform.OpenJSSEPlatform.f56789d
            okhttp3.internal.platform.OpenJSSEPlatform r0 = okhttp3.internal.platform.OpenJSSEPlatform.Companion.a()
            if (r0 == 0) goto Lc7
            goto Ldc
        Lc7:
            boolean r0 = okhttp3.internal.platform.Jdk9Platform.f56788c
            okhttp3.internal.platform.Jdk9Platform r0 = okhttp3.internal.platform.Jdk9Platform.Companion.a()
            if (r0 == 0) goto Ld0
            goto Ldc
        Ld0:
            okhttp3.internal.platform.Jdk8WithJettyBootPlatform r0 = okhttp3.internal.platform.Jdk8WithJettyBootPlatform.Companion.a()
            if (r0 == 0) goto Ld7
            goto Ldc
        Ld7:
            okhttp3.internal.platform.Platform r0 = new okhttp3.internal.platform.Platform
            r0.<init>()
        Ldc:
            okhttp3.internal.platform.Platform.f56791a = r0
            java.lang.Class<okhttp3.OkHttpClient> r0 = okhttp3.OkHttpClient.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            okhttp3.internal.platform.Platform.f56792b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.<clinit>():void");
    }

    public static void i(int i2, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        f56792b.log(i2 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public static /* synthetic */ void j(Platform platform, String str, int i2) {
        int i3 = (i2 & 2) != 0 ? 4 : 5;
        platform.getClass();
        i(i3, str, null);
    }

    public void a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public CertificateChainCleaner b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(c(trustManager));
    }

    public TrustRootIndex c(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public void e(Socket socket, InetSocketAddress address, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, i2);
    }

    public String f(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public Object g() {
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        if (f56792b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public void k(Object obj, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (obj == null) {
            message = b.k(message, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(5, message, (Throwable) obj);
    }

    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory m(X509TrustManager trustManager) throws KeyManagementException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext sSLContextL = l();
            sSLContextL.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS: " + e2, e2);
        }
    }

    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                Intrinsics.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb = new StringBuilder("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public final String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
