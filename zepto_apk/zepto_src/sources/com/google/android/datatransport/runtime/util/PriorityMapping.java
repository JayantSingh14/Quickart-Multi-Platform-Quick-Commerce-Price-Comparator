package com.google.android.datatransport.runtime.util;

import android.support.v4.media.b;
import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class PriorityMapping {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f20976a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f20977b;

    static {
        HashMap map = new HashMap();
        f20977b = map;
        map.put(Priority.f20514a, 0);
        map.put(Priority.f20515b, 1);
        map.put(Priority.f20516c, 2);
        for (Priority priority : map.keySet()) {
            f20976a.append(((Integer) f20977b.get(priority)).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = (Integer) f20977b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i2) {
        Priority priority = (Priority) f20976a.get(i2);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown Priority for value "));
    }
}
