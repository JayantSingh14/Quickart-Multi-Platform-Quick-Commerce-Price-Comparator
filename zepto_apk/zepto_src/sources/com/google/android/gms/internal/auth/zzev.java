package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class zzev<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzha zzc = zzha.f36415e;

    public static zzev a(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzev zzevVar = (zzev) map.get(cls);
        if (zzevVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzevVar = (zzev) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzevVar != null) {
            return zzevVar;
        }
        zzev zzevVar2 = (zzev) ((zzev) zzhj.c(cls)).g(6);
        if (zzevVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzevVar2);
        return zzevVar2;
    }

    public static Object b(Method method, zzfx zzfxVar, Object... objArr) {
        try {
            return method.invoke(zzfxVar, objArr);
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

    public static void d(zzhs zzhsVar) {
        zzhsVar.c();
        zzb.put(zzhs.class, zzhsVar);
    }

    public final void c() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void e() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgf.f36386c.a(getClass()).b(this, (zzev) obj);
    }

    public final boolean f() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object g(int i2);

    public final int hashCode() {
        if (f()) {
            return zzgf.f36386c.a(getClass()).c(this);
        }
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iC = zzgf.f36386c.a(getClass()).c(this);
        this.zza = iC;
        return iC;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = zzfz.f36369a;
        StringBuilder sbX = b.x("# ", string);
        zzfz.c(this, sbX, 0);
        return sbX.toString();
    }

    @Override // com.google.android.gms.internal.auth.zzfy
    public final /* synthetic */ zzev zze() {
        return (zzev) g(6);
    }
}
