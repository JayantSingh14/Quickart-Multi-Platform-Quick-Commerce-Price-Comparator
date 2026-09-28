package ch.qos.logback.classic.spi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ThrowableProxy implements IThrowableProxy {

    /* renamed from: j, reason: collision with root package name */
    public static final Method f13378j;

    /* renamed from: k, reason: collision with root package name */
    public static final ThrowableProxy[] f13379k;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f13380a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13381b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13382c;

    /* renamed from: d, reason: collision with root package name */
    public final StackTraceElementProxy[] f13383d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13384e;

    /* renamed from: f, reason: collision with root package name */
    public final ThrowableProxy f13385f;

    /* renamed from: g, reason: collision with root package name */
    public final ThrowableProxy[] f13386g;

    /* renamed from: h, reason: collision with root package name */
    public transient PackagingDataCalculator f13387h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13388i = false;

    static {
        Method method = null;
        try {
            method = Throwable.class.getMethod("getSuppressed", null);
        } catch (NoSuchMethodException unused) {
        }
        f13378j = method;
        f13379k = new ThrowableProxy[0];
    }

    public ThrowableProxy(Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StackTraceElementProxy[] stackTraceElementProxyArr;
        this.f13386g = f13379k;
        this.f13380a = th;
        this.f13381b = th.getClass().getName();
        this.f13382c = th.getMessage();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            stackTraceElementProxyArr = new StackTraceElementProxy[0];
        } else {
            int length = stackTrace.length;
            StackTraceElementProxy[] stackTraceElementProxyArr2 = new StackTraceElementProxy[length];
            for (int i2 = 0; i2 < length; i2++) {
                stackTraceElementProxyArr2[i2] = new StackTraceElementProxy(stackTrace[i2]);
            }
            stackTraceElementProxyArr = stackTraceElementProxyArr2;
        }
        this.f13383d = stackTraceElementProxyArr;
        Throwable cause = th.getCause();
        if (cause != null) {
            ThrowableProxy throwableProxy = new ThrowableProxy(cause);
            this.f13385f = throwableProxy;
            throwableProxy.f13384e = ThrowableProxyUtil.a(cause.getStackTrace(), stackTraceElementProxyArr);
        }
        Method method = f13378j;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(th, null);
                if (objInvoke instanceof Throwable[]) {
                    Throwable[] thArr = (Throwable[]) objInvoke;
                    if (thArr.length > 0) {
                        this.f13386g = new ThrowableProxy[thArr.length];
                        for (int i3 = 0; i3 < thArr.length; i3++) {
                            this.f13386g[i3] = new ThrowableProxy(thArr[i3]);
                            this.f13386g[i3].f13384e = ThrowableProxyUtil.a(thArr[i3].getStackTrace(), this.f13383d);
                        }
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final IThrowableProxy a() {
        return this.f13385f;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final int b() {
        return this.f13384e;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final IThrowableProxy[] c() {
        return this.f13386g;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final String d() {
        return this.f13381b;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final StackTraceElementProxy[] e() {
        return this.f13383d;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final String getMessage() {
        return this.f13382c;
    }
}
