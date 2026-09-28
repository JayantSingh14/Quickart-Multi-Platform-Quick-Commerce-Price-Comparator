package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedEntry f16049a = new LinkedEntry(null);

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f16050b = new HashMap();

    public static class LinkedEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f16051a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f16052b;

        /* renamed from: d, reason: collision with root package name */
        public LinkedEntry f16054d = this;

        /* renamed from: c, reason: collision with root package name */
        public LinkedEntry f16053c = this;

        public LinkedEntry(Object obj) {
            this.f16051a = obj;
        }
    }

    public final Object a(Poolable poolable) {
        HashMap map = this.f16050b;
        LinkedEntry linkedEntry = (LinkedEntry) map.get(poolable);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolable);
            map.put(poolable, linkedEntry);
        } else {
            poolable.a();
        }
        LinkedEntry linkedEntry2 = linkedEntry.f16054d;
        linkedEntry2.f16053c = linkedEntry.f16053c;
        linkedEntry.f16053c.f16054d = linkedEntry2;
        LinkedEntry linkedEntry3 = this.f16049a;
        linkedEntry.f16054d = linkedEntry3;
        LinkedEntry linkedEntry4 = linkedEntry3.f16053c;
        linkedEntry.f16053c = linkedEntry4;
        linkedEntry4.f16054d = linkedEntry;
        linkedEntry.f16054d.f16053c = linkedEntry;
        ArrayList arrayList = linkedEntry.f16052b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return linkedEntry.f16052b.remove(size - 1);
        }
        return null;
    }

    public final void b(Poolable poolable, Object obj) {
        HashMap map = this.f16050b;
        LinkedEntry linkedEntry = (LinkedEntry) map.get(poolable);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolable);
            linkedEntry.f16054d = linkedEntry;
            LinkedEntry linkedEntry2 = this.f16049a;
            linkedEntry.f16054d = linkedEntry2.f16054d;
            linkedEntry.f16053c = linkedEntry2;
            linkedEntry2.f16054d = linkedEntry;
            linkedEntry.f16054d.f16053c = linkedEntry;
            map.put(poolable, linkedEntry);
        } else {
            poolable.a();
        }
        if (linkedEntry.f16052b == null) {
            linkedEntry.f16052b = new ArrayList();
        }
        linkedEntry.f16052b.add(obj);
    }

    public final Object c() {
        LinkedEntry linkedEntry = this.f16049a;
        LinkedEntry linkedEntry2 = linkedEntry.f16054d;
        while (true) {
            if (linkedEntry2.equals(linkedEntry)) {
                return null;
            }
            ArrayList arrayList = linkedEntry2.f16052b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? linkedEntry2.f16052b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            LinkedEntry linkedEntry3 = linkedEntry2.f16054d;
            linkedEntry3.f16053c = linkedEntry2.f16053c;
            linkedEntry2.f16053c.f16054d = linkedEntry3;
            HashMap map = this.f16050b;
            Object obj = linkedEntry2.f16051a;
            map.remove(obj);
            ((Poolable) obj).a();
            linkedEntry2 = linkedEntry2.f16054d;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedEntry = this.f16049a;
        LinkedEntry linkedEntry2 = linkedEntry.f16053c;
        boolean z = false;
        while (!linkedEntry2.equals(linkedEntry)) {
            sb.append('{');
            sb.append(linkedEntry2.f16051a);
            sb.append(':');
            ArrayList arrayList = linkedEntry2.f16052b;
            sb.append(arrayList != null ? arrayList.size() : 0);
            sb.append("}, ");
            linkedEntry2 = linkedEntry2.f16053c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
