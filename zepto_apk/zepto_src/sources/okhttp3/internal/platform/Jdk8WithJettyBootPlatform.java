package okhttp3.internal.platform;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;

@Metadata
/* loaded from: classes3.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {

    /* renamed from: c, reason: collision with root package name */
    public final Method f56780c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f56781d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f56782e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f56783f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f56784g;

    @Metadata
    public static final class AlpnProvider implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f56785a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56786b;

        /* renamed from: c, reason: collision with root package name */
        public String f56787c;

        public AlpnProvider(ArrayList protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            this.f56785a = protocols;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.b(name, "supports") && Intrinsics.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics.b(name, "unsupported") && Intrinsics.b(Void.TYPE, returnType)) {
                this.f56786b = true;
                return null;
            }
            boolean zB = Intrinsics.b(name, "protocols");
            ArrayList arrayList = this.f56785a;
            if (zB && objArr.length == 0) {
                return arrayList;
            }
            if ((Intrinsics.b(name, "selectProtocol") || Intrinsics.b(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i2 = 0;
                        while (true) {
                            Object obj2 = list.get(i2);
                            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (!arrayList.contains(str)) {
                                if (i2 == size) {
                                    break;
                                }
                                i2++;
                            } else {
                                this.f56787c = str;
                                return str;
                            }
                        }
                    }
                    String str2 = (String) arrayList.get(0);
                    this.f56787c = str2;
                    return str2;
                }
            }
            if ((!Intrinsics.b(name, "protocolSelected") && !Intrinsics.b(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            Intrinsics.d(obj3, "null cannot be cast to non-null type kotlin.String");
            this.f56787c = (String) obj3;
            return null;
        }
    }

    @Metadata
    public static final class Companion {
        public static Jdk8WithJettyBootPlatform a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            String jvmVersion = System.getProperty("java.specification.version", zzck.UNKNOWN_CONTENT_TYPE);
            try {
                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
            } catch (NumberFormatException unused) {
            }
            if (Integer.parseInt(jvmVersion) < 9) {
                try {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                    Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                    Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                    Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                    Method getMethod = cls.getMethod("get", SSLSocket.class);
                    Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                    Intrinsics.checkNotNullExpressionValue(putMethod, "putMethod");
                    Intrinsics.checkNotNullExpressionValue(getMethod, "getMethod");
                    Intrinsics.checkNotNullExpressionValue(removeMethod, "removeMethod");
                    Intrinsics.checkNotNullExpressionValue(clientProviderClass, "clientProviderClass");
                    Intrinsics.checkNotNullExpressionValue(serverProviderClass, "serverProviderClass");
                    return new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                }
            }
            return null;
        }
    }

    public Jdk8WithJettyBootPlatform(Method putMethod, Method getMethod, Method removeMethod, Class clientProviderClass, Class serverProviderClass) {
        Intrinsics.checkNotNullParameter(putMethod, "putMethod");
        Intrinsics.checkNotNullParameter(getMethod, "getMethod");
        Intrinsics.checkNotNullParameter(removeMethod, "removeMethod");
        Intrinsics.checkNotNullParameter(clientProviderClass, "clientProviderClass");
        Intrinsics.checkNotNullParameter(serverProviderClass, "serverProviderClass");
        this.f56780c = putMethod;
        this.f56781d = getMethod;
        this.f56782e = removeMethod;
        this.f56783f = clientProviderClass;
        this.f56784g = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void a(SSLSocket sslSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            this.f56782e.invoke(null, sslSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void d(SSLSocket sslSocket, String str, List protocols) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        try {
            this.f56780c.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f56783f, this.f56784g}, new AlpnProvider(Platform.Companion.a(protocols))));
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String f(SSLSocket sslSocket) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f56781d.invoke(null, sslSocket));
            Intrinsics.d(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            boolean z = alpnProvider.f56786b;
            if (!z && alpnProvider.f56787c == null) {
                Platform.j(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 6);
                return null;
            }
            if (z) {
                return null;
            }
            return alpnProvider.f56787c;
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }
}
