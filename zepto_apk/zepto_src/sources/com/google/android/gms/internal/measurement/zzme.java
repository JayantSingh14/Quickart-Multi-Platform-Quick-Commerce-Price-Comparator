package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzme<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkr<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzoi zzc = zzoi.f37187f;

    public static zzme o(Class cls) throws ClassNotFoundException {
        Map map = zzd;
        zzme zzmeVar = (zzme) map.get(cls);
        if (zzmeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzmeVar = (zzme) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzmeVar != null) {
            return zzmeVar;
        }
        zzme zzmeVar2 = (zzme) ((zzme) zzoo.d(cls)).r(6);
        if (zzmeVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzmeVar2);
        return zzmeVar2;
    }

    public static void p(Class cls, zzme zzmeVar) {
        zzmeVar.j();
        zzd.put(cls, zzmeVar);
    }

    public static Object q(Method method, zznl zznlVar, Object... objArr) {
        try {
            return method.invoke(zznlVar, objArr);
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

    @Override // com.google.android.gms.internal.measurement.zznl
    public final int a() {
        if (i()) {
            int iC = zznt.f37161c.a(getClass()).c(this);
            if (iC >= 0) {
                return iC;
            }
            throw new IllegalStateException(e.m(e.a(iC, 42), iC, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iC2 = zznt.f37161c.a(getClass()).c(this);
        if (iC2 < 0) {
            throw new IllegalStateException(e.m(e.a(iC2, 42), iC2, "serialized size must be non-negative, was "));
        }
        this.zzb = (this.zzb & Integer.MIN_VALUE) | iC2;
        return iC2;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final /* synthetic */ zznk c() {
        return (zzma) r(5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void d(zzll zzllVar) {
        zznw zznwVarA = zznt.f37161c.a(getClass());
        zzlm zzlmVar = zzllVar.f37081a;
        if (zzlmVar == null) {
            zzlmVar = new zzlm(zzllVar);
        }
        zznwVarA.e(this, zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final /* synthetic */ zzme e() {
        return (zzme) r(6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zznt.f37161c.a(getClass()).f(this, (zzme) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final int g(zznw zznwVar) {
        if (i()) {
            int iC = zznwVar.c(this);
            if (iC >= 0) {
                return iC;
            }
            throw new IllegalStateException(e.m(e.a(iC, 42), iC, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iC2 = zznwVar.c(this);
        if (iC2 < 0) {
            throw new IllegalStateException(e.m(e.a(iC2, 42), iC2, "serialized size must be non-negative, was "));
        }
        this.zzb = (this.zzb & Integer.MIN_VALUE) | iC2;
        return iC2;
    }

    public final int hashCode() {
        if (i()) {
            return zznt.f37161c.a(getClass()).h(this);
        }
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iH = zznt.f37161c.a(getClass()).h(this);
        this.zza = iH;
        return iH;
    }

    public final boolean i() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void j() {
        this.zzb &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void k() {
        zznt.f37161c.a(getClass()).d(this);
        j();
    }

    public final zzma l() {
        return (zzma) r(5);
    }

    public final zzma m() {
        zzma zzmaVar = (zzma) r(5);
        zzmaVar.m(this);
        return zzmaVar;
    }

    public final void n() {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public abstract Object r(int i2);

    public final String toString() {
        return zznn.a(this, super.toString());
    }
}
