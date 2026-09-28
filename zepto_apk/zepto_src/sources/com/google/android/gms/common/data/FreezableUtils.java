package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import io.sentry.android.replay.RootViewsSpy$delegatingViewList$1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        RootViewsSpy$delegatingViewList$1 rootViewsSpy$delegatingViewList$1 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            rootViewsSpy$delegatingViewList$1.add(arrayList.get(i2).freeze());
        }
        return rootViewsSpy$delegatingViewList$1;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        RootViewsSpy$delegatingViewList$1 rootViewsSpy$delegatingViewList$1 = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            rootViewsSpy$delegatingViewList$1.add(it.next().freeze());
        }
        return rootViewsSpy$delegatingViewList$1;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        RootViewsSpy$delegatingViewList$1 rootViewsSpy$delegatingViewList$1 = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e2 : eArr) {
            rootViewsSpy$delegatingViewList$1.add(e2.freeze());
        }
        return rootViewsSpy$delegatingViewList$1;
    }
}
