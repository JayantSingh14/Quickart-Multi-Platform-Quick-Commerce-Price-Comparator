package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.ads.zzial;
import com.google.android.gms.internal.ads.zziar;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class zziar<MessageType extends zziar<MessageType, BuilderType>, BuilderType extends zzial<MessageType, BuilderType>> extends zzhyu<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zziar<?, ?>> zzd = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzc = -1;
    protected zzidg zzt = zzidg.f34760f;

    public static zziar A(zziar zziarVar, byte[] bArr, int i2, zziab zziabVar) {
        if (i2 == 0) {
            return zziarVar;
        }
        zziar zziarVarT = zziarVar.t();
        try {
            zzicu zzicuVarA = zzicm.f34722c.a(zziarVarT.getClass());
            zzicuVarA.c(zziarVarT, bArr, 0, i2, new zzhyz(zziabVar));
            zzicuVarA.b(zziarVarT);
            return zziarVarT;
        } catch (zzibg e2) {
            if (e2.f34663a) {
                throw new zzibg(e2.getMessage(), e2);
            }
            throw e2;
        } catch (zzide e3) {
            throw new zzibg(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzibg) {
                throw ((zzibg) e4.getCause());
            }
            throw new zzibg(e4.getMessage(), e4);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static void B(zziar zziarVar) {
        if (zziarVar != null && !z(zziarVar, true)) {
            throw new zzibg(new zzide().getMessage());
        }
    }

    public static Object o(Method method, zzicc zziccVar, Object... objArr) {
        try {
            return method.invoke(zziccVar, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static zziar p(zziar zziarVar, zzhzq zzhzqVar, zziab zziabVar) throws zzibg {
        zziar zziarVarT = zziarVar.t();
        try {
            zzicu zzicuVarA = zzicm.f34722c.a(zziarVarT.getClass());
            zzicuVarA.d(zziarVarT, zzhzr.x(zzhzqVar), zziabVar);
            zzicuVarA.b(zziarVarT);
            return zziarVarT;
        } catch (zzibg e2) {
            if (e2.f34663a) {
                throw new zzibg(e2.getMessage(), e2);
            }
            throw e2;
        } catch (zzide e3) {
            throw new zzibg(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzibg) {
                throw ((zzibg) e4.getCause());
            }
            throw new zzibg(e4.getMessage(), e4);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzibg) {
                throw ((zzibg) e5.getCause());
            }
            throw e5;
        }
    }

    public static zziar q(zziar zziarVar, zzhzl zzhzlVar, zziab zziabVar) {
        zzhzq zzhzqVarT = zzhzlVar.t();
        zziar zziarVarP = p(zziarVar, zzhzqVarT, zziabVar);
        zzhzqVarT.i(0);
        B(zziarVarP);
        return zziarVarP;
    }

    public static zziar r(zziar zziarVar, byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = A(zziarVar, bArr, bArr.length, zziabVar);
        B(zziarVarA);
        return zziarVarA;
    }

    public static zziar w(Class cls) throws ClassNotFoundException {
        zziar<?, ?> zziarVar = zzd.get(cls);
        if (zziarVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zziarVar = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zziarVar != null) {
            return zziarVar;
        }
        zziar<?, ?> zziarVar2 = (zziar) ((zziar) zzidm.e(cls)).y(zziaq.f34645f, null);
        if (zziarVar2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, zziarVar2);
        return zziarVar2;
    }

    public static void x(Class cls, zziar zziarVar) {
        zziarVar.n();
        zzd.put(cls, zziarVar);
    }

    public static final boolean z(zziar zziarVar, boolean z) {
        byte bByteValue = ((Byte) zziarVar.y(zziaq.f34640a, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzicm.f34722c.a(zziarVar.getClass()).zzl(zziarVar);
        if (z) {
            zziarVar.y(zziaq.f34641b, true == zZzl ? zziarVar : null);
        }
        return zZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzicc
    public final void c(zzhzw zzhzwVar) {
        zzicu zzicuVarA = zzicm.f34722c.a(getClass());
        Object obj = zzhzwVar.f34605a;
        zzicuVarA.h(this, obj != null ? (zzhzx) obj : new zzhzx(zzhzwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzicc
    public final int d() {
        return i(null);
    }

    @Override // com.google.android.gms.internal.ads.zzicd
    public final zziar e() {
        return (zziar) y(zziaq.f34645f, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzicm.f34722c.a(getClass()).g(this, (zziar) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzicc
    public final zzicb f() {
        return (zzial) y(zziaq.f34644e, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhyu
    public final int h() {
        return this.zzc & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (m()) {
            return zzicm.f34722c.a(getClass()).f(this);
        }
        if (this.zzq == 0) {
            this.zzq = zzicm.f34722c.a(getClass()).f(this);
        }
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzhyu
    public final int i(zzicu zzicuVar) {
        int iE;
        int iE2;
        if (m()) {
            if (zzicuVar == null) {
                iE2 = zzicm.f34722c.a(getClass()).e(this);
            } else {
                iE2 = zzicuVar.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            throw new IllegalStateException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iE2).length() + 42), iE2, "serialized size must be non-negative, was "));
        }
        if (h() != Integer.MAX_VALUE) {
            return h();
        }
        if (zzicuVar == null) {
            iE = zzicm.f34722c.a(getClass()).e(this);
        } else {
            iE = zzicuVar.e(this);
        }
        l(iE);
        return iE;
    }

    public final void l(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 42), i2, "serialized size must be non-negative, was "));
        }
        this.zzc = i2 | (this.zzc & zza);
    }

    public final boolean m() {
        return (this.zzc & zza) != 0;
    }

    public final void n() {
        this.zzc &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final zzick s() {
        return (zzick) y(zziaq.f34646g, null);
    }

    public final zziar t() {
        return (zziar) y(zziaq.f34643d, null);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = zzice.f34704a;
        StringBuilder sbX = android.support.v4.media.b.x("# ", string);
        zzice.b(this, sbX, 0);
        return sbX.toString();
    }

    public final zzial u() {
        return (zzial) y(zziaq.f34644e, null);
    }

    public final zzial v() {
        zzial zzialVar = (zzial) y(zziaq.f34644e, null);
        zzialVar.m(this);
        return zzialVar;
    }

    public abstract Object y(zziaq zziaqVar, zziar zziarVar);
}
