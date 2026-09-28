package com.google.android.gms.internal.atv_ads_framework;

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
class zzfl extends AbstractMap {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f36194g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f36195a;

    /* renamed from: b, reason: collision with root package name */
    public List f36196b = Collections.EMPTY_LIST;

    /* renamed from: c, reason: collision with root package name */
    public Map f36197c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36198d;

    /* renamed from: e, reason: collision with root package name */
    public volatile zzfj f36199e;

    /* renamed from: f, reason: collision with root package name */
    public Map f36200f;

    public /* synthetic */ zzfl(int i2) {
        this.f36195a = i2;
        Map map = Collections.EMPTY_MAP;
        this.f36197c = map;
        this.f36200f = map;
    }

    public void a() {
        if (this.f36198d) {
            return;
        }
        this.f36197c = this.f36197c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36197c);
        this.f36200f = this.f36200f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36200f);
        this.f36198d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int iC = c(comparable);
        if (iC >= 0) {
            return ((zzff) this.f36196b.get(iC)).setValue(obj);
        }
        f();
        boolean zIsEmpty = this.f36196b.isEmpty();
        int i2 = this.f36195a;
        if (zIsEmpty && !(this.f36196b instanceof ArrayList)) {
            this.f36196b = new ArrayList(i2);
        }
        int i3 = -(iC + 1);
        if (i3 >= i2) {
            return e().put(comparable, obj);
        }
        if (this.f36196b.size() == i2) {
            zzff zzffVar = (zzff) this.f36196b.remove(i2 - 1);
            e().put(zzffVar.f36186a, zzffVar.f36187b);
        }
        this.f36196b.add(i3, new zzff(this, comparable, obj));
        return null;
    }

    public final int c(Comparable comparable) {
        int size = this.f36196b.size();
        int i2 = size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((zzff) this.f36196b.get(i2)).f36186a);
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((zzff) this.f36196b.get(i4)).f36186a);
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
        if (!this.f36196b.isEmpty()) {
            this.f36196b.clear();
        }
        if (this.f36197c.isEmpty()) {
            return;
        }
        this.f36197c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return c(comparable) >= 0 || this.f36197c.containsKey(comparable);
    }

    public final Object d(int i2) {
        f();
        Object obj = ((zzff) this.f36196b.remove(i2)).f36187b;
        if (!this.f36197c.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f36196b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzff(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    public final SortedMap e() {
        f();
        if (this.f36197c.isEmpty() && !(this.f36197c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f36197c = treeMap;
            this.f36200f = treeMap.descendingMap();
        }
        return (SortedMap) this.f36197c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f36199e == null) {
            this.f36199e = new zzfj(this);
        }
        return this.f36199e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return super.equals(obj);
        }
        zzfl zzflVar = (zzfl) obj;
        int size = size();
        if (size == zzflVar.size()) {
            int size2 = this.f36196b.size();
            if (size2 != zzflVar.f36196b.size()) {
                return entrySet().equals(zzflVar.entrySet());
            }
            for (int i2 = 0; i2 < size2; i2++) {
                if (((Map.Entry) this.f36196b.get(i2)).equals((Map.Entry) zzflVar.f36196b.get(i2))) {
                }
            }
            if (size2 != size) {
                return this.f36197c.equals(zzflVar.f36197c);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f36198d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        return iC >= 0 ? ((zzff) this.f36196b.get(iC)).f36187b : this.f36197c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f36196b.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode += ((zzff) this.f36196b.get(i2)).hashCode();
        }
        return this.f36197c.size() > 0 ? this.f36197c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        if (iC >= 0) {
            return d(iC);
        }
        if (this.f36197c.isEmpty()) {
            return null;
        }
        return this.f36197c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f36197c.size() + this.f36196b.size();
    }
}
