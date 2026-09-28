package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzacv;
import com.google.android.gms.internal.pal.zzacz;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class zzacz<MessageType extends zzacz<MessageType, BuilderType>, BuilderType extends zzacv<MessageType, BuilderType>> extends zzabi<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzafj zzc = zzafj.f37488f;
    protected int zzd = -1;

    public static zzadf d(zzadf zzadfVar) {
        int size = zzadfVar.size();
        return zzadfVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object f(Method method, zzaef zzaefVar, Object... objArr) {
        try {
            return method.invoke(zzaefVar, objArr);
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

    public static void h(Class cls, zzacz zzaczVar) {
        zzb.put(cls, zzaczVar);
    }

    public static zzacz l(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzacz zzaczVar = (zzacz) map.get(cls);
        if (zzaczVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaczVar = (zzacz) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzaczVar != null) {
            return zzaczVar;
        }
        zzacz zzaczVar2 = (zzacz) ((zzacz) zzafs.d(cls)).o(6);
        if (zzaczVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzaczVar2);
        return zzaczVar2;
    }

    public static zzacz m(zzacz zzaczVar, zzaby zzabyVar, zzacm zzacmVar) throws zzadi {
        zzacc zzaccVarK = zzabyVar.k();
        zzacz zzaczVar2 = (zzacz) zzaczVar.o(4);
        try {
            zzaer zzaerVarA = zzaen.f37457c.a(zzaczVar2.getClass());
            zzacd zzacdVar = zzaccVarK.f37372b;
            if (zzacdVar == null) {
                zzacdVar = new zzacd(zzaccVarK);
            }
            zzaerVarA.e(zzaczVar2, zzacdVar, zzacmVar);
            zzaerVarA.zzf(zzaczVar2);
            zzaccVarK.g(0);
            if (zzaczVar2.j()) {
                return zzaczVar2;
            }
            throw new zzadi(new zzafh().getMessage());
        } catch (zzadi e2) {
            throw e2;
        } catch (zzafh e3) {
            throw new zzadi(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzadi) {
                throw ((zzadi) e4.getCause());
            }
            throw new zzadi(e4.getMessage(), e4);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzadi) {
                throw ((zzadi) e5.getCause());
            }
            throw e5;
        }
    }

    public static zzacz n(zzacz zzaczVar, byte[] bArr, zzacm zzacmVar) throws zzadi {
        int length = bArr.length;
        zzacz zzaczVar2 = (zzacz) zzaczVar.o(4);
        try {
            zzaer zzaerVarA = zzaen.f37457c.a(zzaczVar2.getClass());
            zzaerVarA.a(zzaczVar2, bArr, 0, length, new zzabl(zzacmVar));
            zzaerVarA.zzf(zzaczVar2);
            if (zzaczVar2.zza != 0) {
                throw new RuntimeException();
            }
            if (zzaczVar2.j()) {
                return zzaczVar2;
            }
            throw new zzadi(new zzafh().getMessage());
        } catch (zzadi e2) {
            throw e2;
        } catch (zzafh e3) {
            throw new zzadi(e3.getMessage());
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzadi) {
                throw ((zzadi) e4.getCause());
            }
            throw new zzadi(e4.getMessage(), e4);
        } catch (IndexOutOfBoundsException unused) {
            throw zzadi.e();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaef
    public final /* synthetic */ zzacv B() {
        return (zzacv) o(5);
    }

    @Override // com.google.android.gms.internal.pal.zzabi
    public final int b() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzabi
    public final void c(int i2) {
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzaef
    public final /* synthetic */ zzacv e() {
        zzacv zzacvVar = (zzacv) o(5);
        zzacvVar.d(this);
        return zzacvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaen.f37457c.a(getClass()).d(this, (zzacz) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zzaeg
    public final /* synthetic */ zzaef g() {
        return (zzacz) o(6);
    }

    public final int hashCode() {
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iF = zzaen.f37457c.a(getClass()).f(this);
        this.zza = iF;
        return iF;
    }

    @Override // com.google.android.gms.internal.pal.zzaef
    public final int i() {
        int i2 = this.zzd;
        if (i2 != -1) {
            return i2;
        }
        int iZza = zzaen.f37457c.a(getClass()).zza(this);
        this.zzd = iZza;
        return iZza;
    }

    public final boolean j() {
        byte bByteValue = ((Byte) o(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzaen.f37457c.a(getClass()).zzl(this);
        o(2);
        return zZzl;
    }

    public final zzacv k() {
        return (zzacv) o(5);
    }

    public abstract Object o(int i2);

    public final String toString() {
        StringBuilder sbX = android.support.v4.media.b.x("# ", super.toString());
        zzaeh.c(this, sbX, 0);
        return sbX.toString();
    }
}
