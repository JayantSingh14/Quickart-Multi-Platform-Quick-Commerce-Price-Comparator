package com.google.android.gms.internal.pal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes4.dex */
class zzafe extends AbstractMap {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f37481g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f37482a;

    /* renamed from: b, reason: collision with root package name */
    public List f37483b = Collections.EMPTY_LIST;

    /* renamed from: c, reason: collision with root package name */
    public Map f37484c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f37485d;

    /* renamed from: e, reason: collision with root package name */
    public volatile zzafc f37486e;

    /* renamed from: f, reason: collision with root package name */
    public Map f37487f;

    public /* synthetic */ zzafe(int i2) {
        this.f37482a = i2;
        Map map = Collections.EMPTY_MAP;
        this.f37484c = map;
        this.f37487f = map;
    }

    public void a() {
        if (this.f37485d) {
            return;
        }
        this.f37484c = this.f37484c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f37484c);
        this.f37487f = this.f37487f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f37487f);
        this.f37485d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int iC = c(comparable);
        if (iC >= 0) {
            return ((zzaey) this.f37483b.get(iC)).setValue(obj);
        }
        f();
        boolean zIsEmpty = this.f37483b.isEmpty();
        int i2 = this.f37482a;
        if (zIsEmpty && !(this.f37483b instanceof ArrayList)) {
            this.f37483b = new ArrayList(i2);
        }
        int i3 = -(iC + 1);
        if (i3 >= i2) {
            return e().put(comparable, obj);
        }
        if (this.f37483b.size() == i2) {
            zzaey zzaeyVar = (zzaey) this.f37483b.remove(i2 - 1);
            e().put(zzaeyVar.f37473a, zzaeyVar.f37474b);
        }
        this.f37483b.add(i3, new zzaey(this, comparable, obj));
        return null;
    }

    public final int c(Comparable comparable) {
        int size = this.f37483b.size();
        int i2 = size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((zzaey) this.f37483b.get(i2)).f37473a);
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((zzaey) this.f37483b.get(i4)).f37473a);
            if (iCompareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        if (!this.f37483b.isEmpty()) {
            this.f37483b.clear();
        }
        if (this.f37484c.isEmpty()) {
            return;
        }
        this.f37484c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return c(comparable) >= 0 || this.f37484c.containsKey(comparable);
    }

    public final Object d(int i2) {
        f();
        Object obj = ((zzaey) this.f37483b.remove(i2)).f37474b;
        if (!this.f37484c.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f37483b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzaey(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    public final SortedMap e() {
        f();
        if (this.f37484c.isEmpty() && !(this.f37484c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f37484c = treeMap;
            this.f37487f = treeMap.descendingMap();
        }
        return (SortedMap) this.f37484c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f37486e == null) {
            this.f37486e = new zzafc(this);
        }
        return this.f37486e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzafe)) {
            return super.equals(obj);
        }
        zzafe zzafeVar = (zzafe) obj;
        int size = size();
        if (size == zzafeVar.size()) {
            int size2 = this.f37483b.size();
            if (size2 != zzafeVar.f37483b.size()) {
                return entrySet().equals(zzafeVar.entrySet());
            }
            for (int i2 = 0; i2 < size2; i2++) {
                if (((Map.Entry) this.f37483b.get(i2)).equals((Map.Entry) zzafeVar.f37483b.get(i2))) {
                }
            }
            if (size2 != size) {
                return this.f37484c.equals(zzafeVar.f37484c);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f37485d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        return iC >= 0 ? ((zzaey) this.f37483b.get(iC)).f37474b : this.f37484c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f37483b.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode += ((zzaey) this.f37483b.get(i2)).hashCode();
        }
        return this.f37484c.size() > 0 ? this.f37484c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        if (iC >= 0) {
            return d(iC);
        }
        if (this.f37484c.isEmpty()) {
            return null;
        }
        return this.f37484c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f37484c.size() + this.f37483b.size();
    }
}
