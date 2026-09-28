package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;

@Metadata
/* loaded from: classes.dex */
public class AndroidSocketAdapter implements SocketAdapter {

    /* renamed from: f, reason: collision with root package name */
    public static final AndroidSocketAdapter$Companion$factory$1 f56798f;

    /* renamed from: a, reason: collision with root package name */
    public final Class f56799a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f56800b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f56801c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f56802d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f56803e;

    @Metadata
    public static final class Companion {
    }

    static {
        Intrinsics.checkNotNullParameter("com.google.android.gms.org.conscrypt", "packageName");
        f56798f = new AndroidSocketAdapter$Companion$factory$1();
    }

    public AndroidSocketAdapter(Class sslSocketClass) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.f56799a = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f56800b = declaredMethod;
        this.f56801c = sslSocketClass.getMethod("setHostname", String.class);
        this.f56802d = sslSocketClass.getMethod("getAlpnSelectedProtocol", null);
        this.f56803e = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean a() {
        boolean z = AndroidPlatform.f56770e;
        return AndroidPlatform.Companion.b();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.f56799a.isInstance(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String c(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (b(sslSocket)) {
            try {
                byte[] bArr = (byte[]) this.f56802d.invoke(sslSocket, null);
                if (bArr != null) {
                    return new String(bArr, Charsets.UTF_8);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                if (!(cause instanceof NullPointerException) || !Intrinsics.b(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e3);
                }
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void d(SSLSocket sslSocket, String str, List protocols) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (b(sslSocket)) {
            try {
                this.f56800b.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f56801c.invoke(sslSocket, str);
                }
                Method method = this.f56803e;
                Platform platform = Platform.f56791a;
                method.invoke(sslSocket, Platform.Companion.b(protocols));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
