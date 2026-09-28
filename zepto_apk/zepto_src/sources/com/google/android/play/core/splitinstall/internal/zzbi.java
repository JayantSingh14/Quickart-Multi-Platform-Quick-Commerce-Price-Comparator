package com.google.android.play.core.splitinstall.internal;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbi extends zzbj {
    public final void c(List list) throws IllegalAccessException, IllegalArgumentException {
        Object[] objArr = (Object[]) a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(this.f41966b.getType().getComponentType(), list.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            objArr2[length] = it.next();
            length++;
        }
        b(objArr2);
    }

    public final void d(Collection collection) throws IllegalAccessException, IllegalArgumentException {
        Object[] objArr = (Object[]) a();
        int i2 = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(this.f41966b.getType().getComponentType(), collection.size() + (objArr == null ? 0 : objArr.length));
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArr2[i2] = it.next();
            i2++;
        }
        b(objArr2);
    }
}
