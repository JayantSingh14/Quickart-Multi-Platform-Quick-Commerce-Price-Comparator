package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class zzhzl implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhzl f34557b = new zzhzj(zzibe.f34661b);

    /* renamed from: a, reason: collision with root package name */
    public int f34558a = 0;

    static {
        int i2 = zzhyy.f34536a;
    }

    public static void b(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 11), i2, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(androidx.fragment.app.e.n(i2, i3, "Index > length: ", ", ", new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(i3).length())));
        }
    }

    public static int d(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 21), "Beginning index: ", i2, " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i2, i3, "Beginning index larger than ending index: ", ", ", new StringBuilder(String.valueOf(i2).length() + 44 + String.valueOf(i3).length())));
        }
        throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i3, i4, "End index: ", " >= ", new StringBuilder(String.valueOf(i3).length() + 15 + String.valueOf(i4).length())));
    }

    public static zzhzl j(Iterator it, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "length (", ") must be >= 1"));
        }
        if (i2 == 1) {
            return (zzhzl) it.next();
        }
        int i3 = i2 >>> 1;
        zzhzl zzhzlVarJ = j(it, i3);
        zzhzl zzhzlVarJ2 = j(it, i2 - i3);
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - zzhzlVarJ.i() < zzhzlVarJ2.i()) {
            int i4 = zzhzlVarJ.i();
            int i5 = zzhzlVarJ2.i();
            throw new IllegalArgumentException(androidx.fragment.app.e.n(i4, i5, "ByteString would be too long: ", "+", new StringBuilder(String.valueOf(i4).length() + 31 + String.valueOf(i5).length())));
        }
        if (zzhzlVarJ2.i() == 0) {
            return zzhzlVarJ;
        }
        if (zzhzlVarJ.i() == 0) {
            return zzhzlVarJ2;
        }
        int i6 = zzhzlVarJ2.i() + zzhzlVarJ.i();
        if (i6 < 128) {
            int i7 = zzhzlVarJ.i();
            int i8 = zzhzlVarJ2.i();
            int i9 = i7 + i8;
            byte[] bArr = new byte[i9];
            d(0, i7, zzhzlVarJ.i());
            d(0, i7, i9);
            if (i7 > 0) {
                zzhzlVarJ.k(bArr, 0, 0, i7);
            }
            d(0, i8, zzhzlVarJ2.i());
            d(i7, i9, i9);
            if (i8 > 0) {
                zzhzlVarJ2.k(bArr, 0, i7, i8);
            }
            try {
                return new zzhzj(bArr);
            } catch (zzibg e2) {
                throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e2);
            }
        }
        if (zzhzlVarJ instanceof zzict) {
            zzict zzictVar = (zzict) zzhzlVarJ;
            zzhzl zzhzlVar = zzictVar.f34740e;
            int i10 = zzhzlVarJ2.i() + zzhzlVar.i();
            zzhzl zzhzlVar2 = zzictVar.f34739d;
            if (i10 < 128) {
                int i11 = zzhzlVar.i();
                int i12 = zzhzlVarJ2.i();
                int i13 = i11 + i12;
                byte[] bArr2 = new byte[i13];
                d(0, i11, zzhzlVar.i());
                d(0, i11, i13);
                if (i11 > 0) {
                    zzhzlVar.k(bArr2, 0, 0, i11);
                }
                d(0, i12, zzhzlVarJ2.i());
                d(i11, i13, i13);
                if (i12 > 0) {
                    zzhzlVarJ2.k(bArr2, 0, i11, i12);
                }
                try {
                    return new zzict(zzhzlVar2, new zzhzj(bArr2));
                } catch (zzibg e3) {
                    throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
                }
            }
            if (zzhzlVar2.m() > zzhzlVar.m() && zzictVar.f34742g > zzhzlVarJ2.m()) {
                return new zzict(zzhzlVar2, new zzict(zzhzlVar, zzhzlVarJ2));
            }
        }
        if (i6 >= zzict.A(Math.max(zzhzlVarJ.m(), zzhzlVarJ2.m()) + 1)) {
            return new zzict(zzhzlVarJ, zzhzlVarJ2);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        zzicr.a(zzhzlVarJ, arrayDeque);
        zzicr.a(zzhzlVarJ2, arrayDeque);
        zzhzl zzictVar2 = (zzhzl) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzictVar2 = new zzict((zzhzl) arrayDeque.pop(), zzictVar2);
        }
        return zzictVar2;
    }

    public static zzhzl v(int i2, byte[] bArr, int i3) {
        try {
            return w(i2, bArr, i3);
        } catch (zzibg e2) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e2);
        }
    }

    public static zzhzl w(int i2, byte[] bArr, int i3) {
        d(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzhzj(bArr2);
    }

    public static zzhzl y(ArrayList arrayList) {
        int size;
        if (arrayList == null) {
            Iterator it = arrayList.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = arrayList.size();
        }
        return size == 0 ? f34557b : j(arrayList.iterator(), size);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhzl)) {
            return false;
        }
        zzhzl zzhzlVar = (zzhzl) obj;
        int i2 = i();
        if (i2 != zzhzlVar.i()) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int i3 = this.f34558a;
        int i4 = zzhzlVar.f34558a;
        if (i3 == 0 || i4 == 0 || i3 == i4) {
            return r(zzhzlVar);
        }
        return false;
    }

    public abstract byte f(int i2);

    public abstract byte g(int i2);

    public final int hashCode() {
        int iS = this.f34558a;
        if (iS == 0) {
            int i2 = i();
            iS = s(i2, 0, i2);
            if (iS == 0) {
                iS = 1;
            }
            this.f34558a = iS;
        }
        return iS;
    }

    public abstract int i();

    public abstract void k(byte[] bArr, int i2, int i3, int i4);

    public abstract int m();

    public abstract boolean n();

    public abstract zzhzl o(int i2, int i3);

    public abstract ByteBuffer p();

    public abstract void q(zzhzw zzhzwVar);

    public abstract boolean r(zzhzl zzhzlVar);

    public abstract int s(int i2, int i3, int i4);

    public abstract zzhzq t();

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int i2 = i();
        String strA = i() <= 50 ? zzidd.a(this) : zzidd.a(o(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(i2);
        sb.append(" contents=\"");
        return android.support.v4.media.b.r(sb, strA, "\">");
    }

    @Override // java.lang.Iterable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public zzhzg iterator() {
        return new zzhzd(this);
    }

    public final byte[] z() {
        int i2 = i();
        if (i2 == 0) {
            return zzibe.f34661b;
        }
        byte[] bArr = new byte[i2];
        k(bArr, 0, 0, i2);
        return bArr;
    }
}
