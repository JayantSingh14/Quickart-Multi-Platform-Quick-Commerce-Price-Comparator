package ch.qos.logback.classic.spi;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ThrowableProxyVO implements IThrowableProxy, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f13389a;

    /* renamed from: b, reason: collision with root package name */
    public String f13390b;

    /* renamed from: c, reason: collision with root package name */
    public int f13391c;

    /* renamed from: d, reason: collision with root package name */
    public StackTraceElementProxy[] f13392d;

    /* renamed from: e, reason: collision with root package name */
    public ThrowableProxyVO f13393e;

    /* renamed from: f, reason: collision with root package name */
    public IThrowableProxy[] f13394f;

    public static ThrowableProxyVO f(IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return null;
        }
        ThrowableProxyVO throwableProxyVO = new ThrowableProxyVO();
        throwableProxyVO.f13389a = iThrowableProxy.d();
        throwableProxyVO.f13390b = iThrowableProxy.getMessage();
        throwableProxyVO.f13391c = iThrowableProxy.b();
        throwableProxyVO.f13392d = iThrowableProxy.e();
        IThrowableProxy iThrowableProxyA = iThrowableProxy.a();
        if (iThrowableProxyA != null) {
            throwableProxyVO.f13393e = f(iThrowableProxyA);
        }
        IThrowableProxy[] iThrowableProxyArrC = iThrowableProxy.c();
        if (iThrowableProxyArrC != null) {
            throwableProxyVO.f13394f = new IThrowableProxy[iThrowableProxyArrC.length];
            for (int i2 = 0; i2 < iThrowableProxyArrC.length; i2++) {
                throwableProxyVO.f13394f[i2] = f(iThrowableProxyArrC[i2]);
            }
        }
        return throwableProxyVO;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final IThrowableProxy a() {
        return this.f13393e;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final int b() {
        return this.f13391c;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final IThrowableProxy[] c() {
        return this.f13394f;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final String d() {
        return this.f13389a;
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final StackTraceElementProxy[] e() {
        return this.f13392d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThrowableProxyVO throwableProxyVO = (ThrowableProxyVO) obj;
        String str = this.f13389a;
        if (str == null) {
            if (throwableProxyVO.f13389a != null) {
                return false;
            }
        } else if (!str.equals(throwableProxyVO.f13389a)) {
            return false;
        }
        if (!Arrays.equals(this.f13392d, throwableProxyVO.f13392d) || !Arrays.equals(this.f13394f, throwableProxyVO.f13394f)) {
            return false;
        }
        ThrowableProxyVO throwableProxyVO2 = this.f13393e;
        return throwableProxyVO2 == null ? throwableProxyVO.f13393e == null : throwableProxyVO2.equals(throwableProxyVO.f13393e);
    }

    @Override // ch.qos.logback.classic.spi.IThrowableProxy
    public final String getMessage() {
        return this.f13390b;
    }

    public final int hashCode() {
        String str = this.f13389a;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
