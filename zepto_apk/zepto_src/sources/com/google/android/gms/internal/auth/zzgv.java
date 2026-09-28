package com.google.android.gms.internal.auth;

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
class zzgv extends AbstractMap {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f36408g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f36409a;

    /* renamed from: b, reason: collision with root package name */
    public List f36410b = Collections.EMPTY_LIST;

    /* renamed from: c, reason: collision with root package name */
    public Map f36411c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36412d;

    /* renamed from: e, reason: collision with root package name */
    public volatile zzgt f36413e;

    /* renamed from: f, reason: collision with root package name */
    public Map f36414f;

    public /* synthetic */ zzgv(int i2) {
        this.f36409a = i2;
        Map map = Collections.EMPTY_MAP;
        this.f36411c = map;
        this.f36414f = map;
    }

    public void a() {
        if (this.f36412d) {
            return;
        }
        this.f36411c = this.f36411c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36411c);
        this.f36414f = this.f36414f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36414f);
        this.f36412d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int iC = c(comparable);
        if (iC >= 0) {
            return ((zzgp) this.f36410b.get(iC)).setValue(obj);
        }
        f();
        boolean zIsEmpty = this.f36410b.isEmpty();
        int i2 = this.f36409a;
        if (zIsEmpty && !(this.f36410b instanceof ArrayList)) {
            this.f36410b = new ArrayList(i2);
        }
        int i3 = -(iC + 1);
        if (i3 >= i2) {
            return e().put(comparable, obj);
        }
        if (this.f36410b.size() == i2) {
            zzgp zzgpVar = (zzgp) this.f36410b.remove(i2 - 1);
            e().put(zzgpVar.f36400a, zzgpVar.f36401b);
        }
        this.f36410b.add(i3, new zzgp(this, comparable, obj));
        return null;
    }

    public final int c(Comparable comparable) {
        int size = this.f36410b.size();
        int i2 = size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((zzgp) this.f36410b.get(i2)).f36400a);
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((zzgp) this.f36410b.get(i4)).f36400a);
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
        if (!this.f36410b.isEmpty()) {
            this.f36410b.clear();
        }
        if (this.f36411c.isEmpty()) {
            return;
        }
        this.f36411c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return c(comparable) >= 0 || this.f36411c.containsKey(comparable);
    }

    public final Object d(int i2) {
        f();
        Object obj = ((zzgp) this.f36410b.remove(i2)).f36401b;
        if (!this.f36411c.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f36410b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzgp(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    public final SortedMap e() {
        f();
        if (this.f36411c.isEmpty() && !(this.f36411c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f36411c = treeMap;
            this.f36414f = treeMap.descendingMap();
        }
        return (SortedMap) this.f36411c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f36413e == null) {
            this.f36413e = new zzgt(this);
        }
        return this.f36413e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgv)) {
            return super.equals(obj);
        }
        zzgv zzgvVar = (zzgv) obj;
        int size = size();
        if (size == zzgvVar.size()) {
            int size2 = this.f36410b.size();
            if (size2 != zzgvVar.f36410b.size()) {
                return entrySet().equals(zzgvVar.entrySet());
            }
            for (int i2 = 0; i2 < size2; i2++) {
                if (((Map.Entry) this.f36410b.get(i2)).equals((Map.Entry) zzgvVar.f36410b.get(i2))) {
                }
            }
            if (size2 != size) {
                return this.f36411c.equals(zzgvVar.f36411c);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f36412d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        return iC >= 0 ? ((zzgp) this.f36410b.get(iC)).f36401b : this.f36411c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f36410b.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode += ((zzgp) this.f36410b.get(i2)).hashCode();
        }
        return this.f36411c.size() > 0 ? this.f36411c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        if (iC >= 0) {
            return d(iC);
        }
        if (this.f36411c.isEmpty()) {
            return null;
        }
        return this.f36411c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f36411c.size() + this.f36410b.size();
    }
}
