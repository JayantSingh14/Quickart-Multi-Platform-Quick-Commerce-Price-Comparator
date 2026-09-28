package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzkq<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznk {
    public static void f(int i2, List list) {
        int size = list.size() - i2;
        String strU = e.u(new StringBuilder(String.valueOf(size).length() + 26), "Element at index ", size, " is null.");
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i2) {
                throw new NullPointerException(strU);
            }
            list.remove(size2);
        }
    }

    @Override // 
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public abstract zzma clone();
}
