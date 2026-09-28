package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhyt;
import com.google.android.gms.internal.ads.zzhyu;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzhyu<MessageType extends zzhyu<MessageType, BuilderType>, BuilderType extends zzhyt<MessageType, BuilderType>> implements zzicc {
    protected int zzq = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(AbstractCollection abstractCollection, List list) {
        Charset charset = zzibe.f34660a;
        abstractCollection.getClass();
        if (abstractCollection instanceof zzibn) {
            List listZza = ((zzibn) abstractCollection).zza();
            zzibn zzibnVar = (zzibn) list;
            int size = list.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    int size2 = zzibnVar.size() - size;
                    String strU = androidx.fragment.app.e.u(new StringBuilder(String.valueOf(size2).length() + 26), "Element at index ", size2, " is null.");
                    int size3 = zzibnVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(strU);
                        }
                        zzibnVar.remove(size3);
                    }
                } else if (obj instanceof zzhzl) {
                    zzibnVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    zzhzl.v(0, bArr, bArr.length);
                    zzibnVar.zzb();
                } else {
                    zzibnVar.add((String) obj);
                }
            }
            return;
        }
        if (abstractCollection instanceof zzicl) {
            list.addAll(abstractCollection);
            return;
        }
        int size4 = abstractCollection.size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size4);
        } else if (list instanceof zzicn) {
            zzicn zzicnVar = (zzicn) list;
            int i2 = ((zzicn) list).f34728c + size4;
            int length = zzicnVar.f34727b.length;
            if (i2 > length) {
                if (length != 0) {
                    while (length < i2) {
                        length = androidx.fragment.app.e.d(length, 3, 2, 1, 10);
                    }
                    zzicnVar.f34727b = Arrays.copyOf(zzicnVar.f34727b, length);
                } else {
                    zzicnVar.f34727b = new Object[Math.max(i2, 10)];
                }
            }
        }
        int size5 = list.size();
        if (!(abstractCollection instanceof List) || !(abstractCollection instanceof RandomAccess)) {
            for (Object obj2 : abstractCollection) {
                if (obj2 == null) {
                    zzhyt.h(size5, list);
                    throw null;
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) abstractCollection;
        int size6 = list2.size();
        for (int i3 = 0; i3 < size6; i3++) {
            Object obj3 = list2.get(i3);
            if (obj3 == null) {
                zzhyt.h(size5, list);
                throw null;
            }
            list.add(obj3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicc
    public final void a(OutputStream outputStream) {
        zziar zziarVar = (zziar) this;
        int i2 = zziarVar.i(null);
        Logger logger = zzhzw.f34603b;
        if (i2 > 4096) {
            i2 = 4096;
        }
        zzhzv zzhzvVar = new zzhzv(outputStream, i2);
        zziarVar.c(zzhzvVar);
        if (zzhzvVar.f34598f > 0) {
            zzhzvVar.H();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicc
    public final zzhzl b() {
        try {
            int i2 = ((zziar) this).i(null);
            zzhzl zzhzlVar = zzhzl.f34557b;
            byte[] bArr = new byte[i2];
            Logger logger = zzhzw.f34603b;
            zzhzt zzhztVar = new zzhzt(bArr, i2);
            ((zziar) this).c(zzhztVar);
            zzhztVar.e();
            return new zzhzj(bArr);
        } catch (IOException e2) {
            throw new RuntimeException(k("ByteString"), e2);
        }
    }

    public final byte[] g() {
        try {
            int i2 = ((zziar) this).i(null);
            byte[] bArr = new byte[i2];
            Logger logger = zzhzw.f34603b;
            zzhzt zzhztVar = new zzhzt(bArr, i2);
            ((zziar) this).c(zzhztVar);
            zzhztVar.e();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(k("byte array"), e2);
        }
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public int i(zzicu zzicuVar) {
        return h();
    }

    public final String k(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 18 + str.length() + 44);
        android.support.v4.media.b.B(sb, "Serializing ", name, " to a ", str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }
}
