package com.google.android.gms.internal.measurement;

import androidx.collection.ArrayMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzkn implements zzju {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayMap f37039a = new ArrayMap();

    public static synchronized void a() {
        ArrayMap arrayMap = f37039a;
        Iterator it = arrayMap.values().iterator();
        if (it.hasNext()) {
            ((zzkn) it.next()).getClass();
            throw null;
        }
        arrayMap.clear();
    }
}
