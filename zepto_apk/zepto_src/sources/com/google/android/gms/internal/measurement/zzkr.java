package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzkr<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznl {
    protected int zza = 0;

    public static void h(Iterable iterable, List list) {
        Charset charset = zzmo.f37112a;
        iterable.getClass();
        if (iterable instanceof zzmw) {
            List listZza = ((zzmw) iterable).zza();
            zzmw zzmwVar = (zzmw) list;
            int size = list.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    int size2 = zzmwVar.size() - size;
                    String strU = e.u(new StringBuilder(String.valueOf(size2).length() + 26), "Element at index ", size2, " is null.");
                    int size3 = zzmwVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(strU);
                        }
                        zzmwVar.remove(size3);
                    }
                } else if (obj instanceof zzlg) {
                    zzmwVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    zzlg.k(0, bArr, bArr.length);
                    zzmwVar.zzb();
                } else {
                    zzmwVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzns) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size4 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size4);
            } else if (list instanceof zznu) {
                zznu zznuVar = (zznu) list;
                int i2 = ((zznu) list).f37167c + size4;
                int length = zznuVar.f37166b.length;
                if (i2 > length) {
                    if (length != 0) {
                        while (length < i2) {
                            length = e.d(length, 3, 2, 1, 10);
                        }
                        zznuVar.f37166b = Arrays.copyOf(zznuVar.f37166b, length);
                    } else {
                        zznuVar.f37166b = new Object[Math.max(i2, 10)];
                    }
                }
            }
        }
        int size5 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    zzkq.f(size5, list);
                    throw null;
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size6 = list2.size();
        for (int i3 = 0; i3 < size6; i3++) {
            Object obj3 = list2.get(i3);
            if (obj3 == null) {
                zzkq.f(size5, list);
                throw null;
            }
            list.add(obj3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final zzlg b() {
        try {
            zzme zzmeVar = (zzme) this;
            int iA = zzmeVar.a();
            zzlg zzlgVar = zzlg.f37073b;
            byte[] bArr = new byte[iA];
            Logger logger = zzll.f37079b;
            zzlj zzljVar = new zzlj(bArr, iA);
            zzmeVar.d(zzljVar);
            return zzld.a(zzljVar, bArr);
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(b.s(new StringBuilder(name.length() + 72), "Serializing ", name, " to a ByteString threw an IOException (should never happen)."), e2);
        }
    }

    public final byte[] f() {
        try {
            zzme zzmeVar = (zzme) this;
            int iA = zzmeVar.a();
            byte[] bArr = new byte[iA];
            Logger logger = zzll.f37079b;
            zzlj zzljVar = new zzlj(bArr, iA);
            zzmeVar.d(zzljVar);
            if (zzljVar.v() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(b.s(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e2);
        }
    }

    public int g(zznw zznwVar) {
        throw null;
    }
}
