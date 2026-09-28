package okhttp3.internal.platform;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

@SuppressSignatureCheck
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AndroidPlatform extends Platform {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f56770e;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f56771c;

    /* renamed from: d, reason: collision with root package name */
    public final CloseGuard f56772d;

    @Metadata
    public static final class Companion {
        public static AndroidPlatform a() {
            if (AndroidPlatform.f56770e) {
                return new AndroidPlatform();
            }
            return null;
        }

        public static boolean b() {
            return AndroidPlatform.f56770e;
        }
    }

    @Metadata
    public static final class CustomTrustRootIndex implements TrustRootIndex {

        /* renamed from: a, reason: collision with root package name */
        public final X509TrustManager f56773a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f56774b;

        public CustomTrustRootIndex(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f56773a = trustManager;
            this.f56774b = findByIssuerAndSignatureMethod;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public final X509Certificate a(X509Certificate cert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object objInvoke = this.f56774b.invoke(this.f56773a, cert);
                Intrinsics.d(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.b(this.f56773a, customTrustRootIndex.f56773a) && Intrinsics.b(this.f56774b, customTrustRootIndex.f56774b);
        }

        public final int hashCode() {
            return this.f56774b.hashCode() + (this.f56773a.hashCode() * 31);
        }

        public final String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f56773a + ", findByIssuerAndSignatureMethod=" + this.f56774b + ')';
        }
    }

    static {
        boolean z = false;
        if ("Dalvik".equals(System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        f56770e = z;
    }

    public AndroidPlatform() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        Method method;
        Method method2;
        int i2 = StandardAndroidSocketAdapter.f56811g;
        Intrinsics.checkNotNullParameter("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> sslSocketClass = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> sslSocketFactoryClass = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class<?> paramClass = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Intrinsics.checkNotNullExpressionValue(paramClass, "paramsClass");
            Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
            Intrinsics.checkNotNullParameter(sslSocketFactoryClass, "sslSocketFactoryClass");
            Intrinsics.checkNotNullParameter(paramClass, "paramClass");
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(sslSocketClass);
        } catch (Exception e2) {
            Platform.f56791a.getClass();
            Platform.i(5, "unable to load android socket classes", e2);
            standardAndroidSocketAdapter = null;
        }
        SocketAdapter[] elements = {standardAndroidSocketAdapter, new DeferredSocketAdapter(AndroidSocketAdapter.f56798f), new DeferredSocketAdapter(ConscryptSocketAdapter.f56808a), new DeferredSocketAdapter(BouncyCastleSocketAdapter.f56804a)};
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayListT = ArraysKt.t(elements);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListT.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((SocketAdapter) next).a()) {
                arrayList.add(next);
            }
        }
        this.f56771c = arrayList;
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls.getMethod("get", null);
            method2 = cls.getMethod(AbstractCircuitBreaker.PROPERTY_NAME, String.class);
            method = cls.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f56772d = new CloseGuard(method3, method2, method);
    }

    @Override // okhttp3.internal.platform.Platform
    public final CertificateChainCleaner b(X509TrustManager trustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(trustManager, x509TrustManagerExtensions) : null;
        return androidCertificateChainCleaner != null ? androidCertificateChainCleaner : super.b(trustManager);
    }

    @Override // okhttp3.internal.platform.Platform
    public final TrustRootIndex c(X509TrustManager trustManager) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            return new CustomTrustRootIndex(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.c(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void d(SSLSocket sslSocket, String str, List protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator it = this.f56771c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SocketAdapter) next).b(sslSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            socketAdapter.d(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void e(Socket socket, InetSocketAddress address, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        try {
            socket.connect(address, i2);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String f(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator it = this.f56771c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).b(sslSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final Object g() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        CloseGuard closeGuard = this.f56772d;
        closeGuard.getClass();
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        Method method = closeGuard.f56805a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                Method method2 = closeGuard.f56806b;
                Intrinsics.c(method2);
                method2.invoke(objInvoke, "response.body().close()");
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final boolean h(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void k(Object obj, String message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(message, "message");
        CloseGuard closeGuard = this.f56772d;
        closeGuard.getClass();
        if (obj != null) {
            try {
                Method method = closeGuard.f56807c;
                Intrinsics.c(method);
                method.invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        Platform.j(this, message, 4);
    }
}
