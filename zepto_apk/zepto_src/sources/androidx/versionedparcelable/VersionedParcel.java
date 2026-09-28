package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.fragment.app.e;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@RestrictTo
/* loaded from: classes3.dex */
public abstract class VersionedParcel {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f12297a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f12298b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f12299c;

    /* renamed from: androidx.versionedparcelable.VersionedParcel$1, reason: invalid class name */
    class AnonymousClass1 extends ObjectInputStream {
        @Override // java.io.ObjectInputStream
        public final Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        this.f12297a = arrayMap;
        this.f12298b = arrayMap2;
        this.f12299c = arrayMap3;
    }

    public abstract void a();

    public abstract VersionedParcel b();

    public final Class c(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ArrayMap arrayMap = this.f12299c;
        Class cls2 = (Class) arrayMap.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(e.D(cls.getPackage().getName(), CLConstants.DOT_SALT_DELIMETER, cls.getSimpleName(), "Parcelizer"), false, cls.getClassLoader());
        arrayMap.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException, SecurityException {
        ArrayMap arrayMap = this.f12297a;
        Method method = (Method) arrayMap.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        arrayMap.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        String name = cls.getName();
        ArrayMap arrayMap = this.f12298b;
        Method method = (Method) arrayMap.get(name);
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, VersionedParcel.class);
        arrayMap.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return this instanceof VersionedParcelStream;
    }

    public abstract boolean g();

    public abstract byte[] h();

    public abstract CharSequence i();

    public abstract boolean j(int i2);

    public abstract int k();

    public final int l(int i2, int i3) {
        return !j(i3) ? i2 : k();
    }

    public abstract Parcelable m();

    public abstract String n();

    public final VersionedParcelable o() {
        String strN = n();
        if (strN == null) {
            return null;
        }
        try {
            return (VersionedParcelable) d(strN).invoke(null, b());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public abstract void p(int i2);

    public void q(boolean z, boolean z2) {
    }

    public abstract void r(boolean z);

    public abstract void s(byte[] bArr);

    public abstract void t(CharSequence charSequence);

    public abstract void u(int i2);

    public final void v(int i2, int i3) {
        p(i3);
        u(i2);
    }

    public abstract void w(Parcelable parcelable);

    public abstract void x(String str);

    public final void y(VersionedParcelable versionedParcelable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (versionedParcelable == null) {
            x(null);
            return;
        }
        try {
            x(c(versionedParcelable.getClass()).getName());
            VersionedParcel versionedParcelB = b();
            try {
                e(versionedParcelable.getClass()).invoke(null, versionedParcelable, versionedParcelB);
                versionedParcelB.a();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (InvocationTargetException e5) {
                if (!(e5.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
                }
                throw ((RuntimeException) e5.getCause());
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e6);
        }
    }
}
