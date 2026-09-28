package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
class zzod extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f37181a;

    /* renamed from: b, reason: collision with root package name */
    public int f37182b;

    /* renamed from: c, reason: collision with root package name */
    public Map f37183c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f37184d;

    /* renamed from: e, reason: collision with root package name */
    public volatile zzoc f37185e;

    /* renamed from: f, reason: collision with root package name */
    public Map f37186f;

    public /* synthetic */ zzod() {
        Map map = Collections.EMPTY_MAP;
        this.f37183c = map;
        this.f37186f = map;
    }

    public void a() {
        if (this.f37184d) {
            return;
        }
        this.f37183c = this.f37183c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f37183c);
        this.f37186f = this.f37186f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f37186f);
        this.f37184d = true;
    }

    public final Map.Entry b(int i2) {
        if (i2 < this.f37182b) {
            return (zzoa) this.f37181a[i2];
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }

    public final Set c() {
        return this.f37183c.isEmpty() ? Collections.EMPTY_SET : this.f37183c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.f37182b != 0) {
            this.f37181a = null;
            this.f37182b = 0;
        }
        if (this.f37183c.isEmpty()) {
            return;
        }
        this.f37183c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f37183c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((zzoa) this.f37181a[iF]).setValue(obj);
        }
        g();
        if (this.f37181a == null) {
            this.f37181a = new Object[16];
        }
        int i2 = -(iF + 1);
        if (i2 >= 16) {
            return h().put(comparable, obj);
        }
        if (this.f37182b == 16) {
            zzoa zzoaVar = (zzoa) this.f37181a[15];
            this.f37182b = 15;
            h().put(zzoaVar.f37173a, zzoaVar.f37174b);
        }
        Object[] objArr = this.f37181a;
        int length = objArr.length;
        System.arraycopy(objArr, i2, objArr, i2 + 1, 15 - i2);
        this.f37181a[i2] = new zzoa(this, comparable, obj);
        this.f37182b++;
        return null;
    }

    public final Object e(int i2) {
        g();
        Object[] objArr = this.f37181a;
        Object obj = ((zzoa) objArr[i2]).f37174b;
        System.arraycopy(objArr, i2 + 1, objArr, i2, (this.f37182b - i2) - 1);
        this.f37182b--;
        if (!this.f37183c.isEmpty()) {
            Iterator it = h().entrySet().iterator();
            Object[] objArr2 = this.f37181a;
            int i3 = this.f37182b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i3] = new zzoa(this, (Comparable) entry.getKey(), entry.getValue());
            this.f37182b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f37185e == null) {
            this.f37185e = new zzoc(this);
        }
        return this.f37185e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return super.equals(obj);
        }
        zzod zzodVar = (zzod) obj;
        int size = size();
        if (size != zzodVar.size()) {
            return false;
        }
        int i2 = this.f37182b;
        if (i2 != zzodVar.f37182b) {
            return entrySet().equals(zzodVar.entrySet());
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!b(i3).equals(zzodVar.b(i3))) {
                return false;
            }
        }
        if (i2 != size) {
            return this.f37183c.equals(zzodVar.f37183c);
        }
        return true;
    }

    public final int f(Comparable comparable) {
        int i2 = this.f37182b;
        int i3 = i2 - 1;
        int i4 = 0;
        if (i3 >= 0) {
            int iCompareTo = comparable.compareTo(((zzoa) this.f37181a[i3]).f37173a);
            if (iCompareTo > 0) {
                return -(i2 + 1);
            }
            if (iCompareTo == 0) {
                return i3;
            }
        }
        while (i4 <= i3) {
            int i5 = (i4 + i3) / 2;
            int iCompareTo2 = comparable.compareTo(((zzoa) this.f37181a[i5]).f37173a);
            if (iCompareTo2 < 0) {
                i3 = i5 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i5;
                }
                i4 = i5 + 1;
            }
        }
        return -(i4 + 1);
    }

    public final void g() {
        if (this.f37184d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((zzoa) this.f37181a[iF]).f37174b : this.f37183c.get(comparable);
    }

    public final SortedMap h() {
        g();
        if (this.f37183c.isEmpty() && !(this.f37183c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f37183c = treeMap;
            this.f37186f = treeMap.descendingMap();
        }
        return (SortedMap) this.f37183c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = this.f37182b;
        int iHashCode = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iHashCode += this.f37181a[i3].hashCode();
        }
        return this.f37183c.size() > 0 ? this.f37183c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return e(iF);
        }
        if (this.f37183c.isEmpty()) {
            return null;
        }
        return this.f37183c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f37183c.size() + this.f37182b;
    }
}
