package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.atv_ads_framework.zzdf;
import com.google.android.gms.internal.atv_ads_framework.zzdh;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class zzdh<MessageType extends zzdh<MessageType, BuilderType>, BuilderType extends zzdf<MessageType, BuilderType>> extends zzca<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzfq zzc = zzfq.f36201e;

    public static zzdh f(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzdh zzdhVar = (zzdh) map.get(cls);
        if (zzdhVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzdhVar = (zzdh) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzdhVar != null) {
            return zzdhVar;
        }
        zzdh zzdhVar2 = (zzdh) ((zzdh) zzfz.f(cls)).d(6);
        if (zzdhVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzdhVar2);
        return zzdhVar2;
    }

    public static Object g(Method method, zzeo zzeoVar, Object... objArr) {
        try {
            return method.invoke(zzeoVar, objArr);
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

    public static void i(Class cls, zzdh zzdhVar) {
        zzdhVar.h();
        zzb.put(cls, zzdhVar);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzca
    public final int a(zzey zzeyVar) {
        if (b()) {
            int iD = zzeyVar.d(this);
            if (iD >= 0) {
                return iD;
            }
            throw new IllegalStateException(b.f(iD, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iD2 = zzeyVar.d(this);
        if (iD2 < 0) {
            throw new IllegalStateException(b.f(iD2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iD2;
        return iD2;
    }

    public final boolean b() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final int c(zzey zzeyVar) {
        if (zzeyVar != null) {
            return zzeyVar.d(this);
        }
        return zzew.f36171c.a(getClass()).d(this);
    }

    public abstract Object d(int i2);

    public final zzdf e() {
        return (zzdf) d(5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzew.f36171c.a(getClass()).f(this, (zzdh) obj);
    }

    public final void h() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (b()) {
            return zzew.f36171c.a(getClass()).c(this);
        }
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iC = zzew.f36171c.a(getClass()).c(this);
        this.zza = iC;
        return iC;
    }

    public final void j() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = zzeq.f36153a;
        StringBuilder sbX = b.x("# ", string);
        zzeq.c(this, sbX, 0);
        return sbX.toString();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzep
    public final /* synthetic */ zzdh zzl() {
        return (zzdh) d(6);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzeo
    public final int zzn() {
        if (b()) {
            int iC = c(null);
            if (iC >= 0) {
                return iC;
            }
            throw new IllegalStateException(b.f(iC, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iC2 = c(null);
        if (iC2 < 0) {
            throw new IllegalStateException(b.f(iC2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iC2;
        return iC2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzeo
    public final /* synthetic */ zzdf zzs() {
        return (zzdf) d(5);
    }
}
