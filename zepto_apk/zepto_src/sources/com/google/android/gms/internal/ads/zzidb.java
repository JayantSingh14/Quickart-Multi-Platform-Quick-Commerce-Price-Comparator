package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes4.dex */
class zzidb extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f34754a;

    /* renamed from: b, reason: collision with root package name */
    public int f34755b;

    /* renamed from: c, reason: collision with root package name */
    public Map f34756c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34757d;

    /* renamed from: e, reason: collision with root package name */
    public volatile zzida f34758e;

    /* renamed from: f, reason: collision with root package name */
    public Map f34759f;

    public /* synthetic */ zzidb() {
        Map map = Collections.EMPTY_MAP;
        this.f34756c = map;
        this.f34759f = map;
    }

    public void a() {
        if (this.f34757d) {
            return;
        }
        this.f34756c = this.f34756c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f34756c);
        this.f34759f = this.f34759f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f34759f);
        this.f34757d = true;
    }

    public final Map.Entry b(int i2) {
        if (i2 < this.f34755b) {
            return (zzicy) this.f34754a[i2];
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }

    public final Set c() {
        return this.f34756c.isEmpty() ? Collections.EMPTY_SET : this.f34756c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.f34755b != 0) {
            this.f34754a = null;
            this.f34755b = 0;
        }
        if (this.f34756c.isEmpty()) {
            return;
        }
        this.f34756c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f34756c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((zzicy) this.f34754a[iF]).setValue(obj);
        }
        g();
        if (this.f34754a == null) {
            this.f34754a = new Object[16];
        }
        int i2 = -(iF + 1);
        if (i2 >= 16) {
            return h().put(comparable, obj);
        }
        if (this.f34755b == 16) {
            zzicy zzicyVar = (zzicy) this.f34754a[15];
            this.f34755b = 15;
            h().put(zzicyVar.f34744a, zzicyVar.f34745b);
        }
        Object[] objArr = this.f34754a;
        int length = objArr.length;
        System.arraycopy(objArr, i2, objArr, i2 + 1, 15 - i2);
        this.f34754a[i2] = new zzicy(this, comparable, obj);
        this.f34755b++;
        return null;
    }

    public final Object e(int i2) {
        g();
        Object[] objArr = this.f34754a;
        Object obj = ((zzicy) objArr[i2]).f34745b;
        System.arraycopy(objArr, i2 + 1, objArr, i2, (this.f34755b - i2) - 1);
        this.f34755b--;
        if (!this.f34756c.isEmpty()) {
            Iterator it = h().entrySet().iterator();
            Object[] objArr2 = this.f34754a;
            int i3 = this.f34755b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i3] = new zzicy(this, (Comparable) entry.getKey(), entry.getValue());
            this.f34755b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f34758e == null) {
            this.f34758e = new zzida(this);
        }
        return this.f34758e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzidb)) {
            return super.equals(obj);
        }
        zzidb zzidbVar = (zzidb) obj;
        int size = size();
        if (size != zzidbVar.size()) {
            return false;
        }
        int i2 = this.f34755b;
        if (i2 != zzidbVar.f34755b) {
            return entrySet().equals(zzidbVar.entrySet());
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!b(i3).equals(zzidbVar.b(i3))) {
                return false;
            }
        }
        if (i2 != size) {
            return this.f34756c.equals(zzidbVar.f34756c);
        }
        return true;
    }

    public final int f(Comparable comparable) {
        int i2 = this.f34755b;
        int i3 = i2 - 1;
        int i4 = 0;
        if (i3 >= 0) {
            int iCompareTo = comparable.compareTo(((zzicy) this.f34754a[i3]).f34744a);
            if (iCompareTo > 0) {
                return -(i2 + 1);
            }
            if (iCompareTo == 0) {
                return i3;
            }
        }
        while (i4 <= i3) {
            int i5 = (i4 + i3) / 2;
            int iCompareTo2 = comparable.compareTo(((zzicy) this.f34754a[i5]).f34744a);
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
        if (this.f34757d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((zzicy) this.f34754a[iF]).f34745b : this.f34756c.get(comparable);
    }

    public final SortedMap h() {
        g();
        if (this.f34756c.isEmpty() && !(this.f34756c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f34756c = treeMap;
            this.f34759f = treeMap.descendingMap();
        }
        return (SortedMap) this.f34756c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = this.f34755b;
        int iHashCode = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iHashCode += this.f34754a[i3].hashCode();
        }
        return this.f34756c.size() > 0 ? this.f34756c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return e(iF);
        }
        if (this.f34756c.isEmpty()) {
            return null;
        }
        return this.f34756c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f34756c.size() + this.f34755b;
    }
}
