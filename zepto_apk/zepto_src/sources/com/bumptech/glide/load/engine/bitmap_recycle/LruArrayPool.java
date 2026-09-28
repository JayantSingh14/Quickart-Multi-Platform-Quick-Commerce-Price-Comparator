package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a, reason: collision with root package name */
    public final GroupedLinkedMap f16055a;

    /* renamed from: b, reason: collision with root package name */
    public final KeyPool f16056b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f16057c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f16058d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16059e;

    /* renamed from: f, reason: collision with root package name */
    public int f16060f;

    public static final class Key implements Poolable {

        /* renamed from: a, reason: collision with root package name */
        public final KeyPool f16061a;

        /* renamed from: b, reason: collision with root package name */
        public int f16062b;

        /* renamed from: c, reason: collision with root package name */
        public Class f16063c;

        public Key(KeyPool keyPool) {
            this.f16061a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void a() {
            this.f16061a.c(this);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f16062b == key.f16062b && this.f16063c == key.f16063c) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i2 = this.f16062b * 31;
            Class cls = this.f16063c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public final String toString() {
            return "Key{size=" + this.f16062b + "array=" + this.f16063c + '}';
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final Poolable a() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.f16055a = new GroupedLinkedMap();
        this.f16056b = new KeyPool();
        this.f16057c = new HashMap();
        this.f16058d = new HashMap();
        this.f16059e = 4194304;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(Class cls, int i2) {
        NavigableMap navigableMapH = h(cls);
        Integer num = (Integer) navigableMapH.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapH.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapH.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    public final void c(int i2) {
        while (this.f16060f > i2) {
            Object objC = this.f16055a.c();
            Preconditions.b(objC);
            ArrayAdapterInterface arrayAdapterInterfaceE = e(objC.getClass());
            this.f16060f -= arrayAdapterInterfaceE.b(objC) * arrayAdapterInterfaceE.a();
            b(objC.getClass(), arrayAdapterInterfaceE.b(objC));
            if (Log.isLoggable(arrayAdapterInterfaceE.z(), 2)) {
                Log.v(arrayAdapterInterfaceE.z(), "evicted: " + arrayAdapterInterfaceE.b(objC));
            }
        }
    }

    public final synchronized Object d(Class cls, int i2) {
        Key key;
        int i3;
        try {
            Integer num = (Integer) h(cls).ceilingKey(Integer.valueOf(i2));
            if (num == null || ((i3 = this.f16060f) != 0 && this.f16059e / i3 < 2 && num.intValue() > i2 * 8)) {
                Key key2 = (Key) this.f16056b.b();
                key2.f16062b = i2;
                key2.f16063c = cls;
                key = key2;
            } else {
                KeyPool keyPool = this.f16056b;
                int iIntValue = num.intValue();
                key = (Key) keyPool.b();
                key.f16062b = iIntValue;
                key.f16063c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return g(key, cls);
    }

    public final ArrayAdapterInterface e(Class cls) {
        ArrayAdapterInterface byteArrayAdapter;
        HashMap map = this.f16058d;
        ArrayAdapterInterface arrayAdapterInterface = (ArrayAdapterInterface) map.get(cls);
        if (arrayAdapterInterface != null) {
            return arrayAdapterInterface;
        }
        if (cls.equals(int[].class)) {
            byteArrayAdapter = new IntegerArrayAdapter();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            byteArrayAdapter = new ByteArrayAdapter();
        }
        map.put(cls, byteArrayAdapter);
        return byteArrayAdapter;
    }

    public final synchronized Object f() {
        Key key;
        key = (Key) this.f16056b.b();
        key.f16062b = 8;
        key.f16063c = byte[].class;
        return g(key, byte[].class);
    }

    public final Object g(Key key, Class cls) {
        ArrayAdapterInterface arrayAdapterInterfaceE = e(cls);
        Object objA = this.f16055a.a(key);
        if (objA != null) {
            this.f16060f -= arrayAdapterInterfaceE.b(objA) * arrayAdapterInterfaceE.a();
            b(cls, arrayAdapterInterfaceE.b(objA));
        }
        if (objA != null) {
            return objA;
        }
        if (Log.isLoggable(arrayAdapterInterfaceE.z(), 2)) {
            Log.v(arrayAdapterInterfaceE.z(), "Allocated " + key.f16062b + " bytes");
        }
        return arrayAdapterInterfaceE.newArray(key.f16062b);
    }

    public final NavigableMap h(Class cls) {
        HashMap map = this.f16057c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void i(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayAdapterInterface arrayAdapterInterfaceE = e(cls);
        int iB = arrayAdapterInterfaceE.b(obj);
        int iA = arrayAdapterInterfaceE.a() * iB;
        if (iA <= this.f16059e / 2) {
            Key key = (Key) this.f16056b.b();
            key.f16062b = iB;
            key.f16063c = cls;
            this.f16055a.b(key, obj);
            NavigableMap navigableMapH = h(cls);
            Integer num = (Integer) navigableMapH.get(Integer.valueOf(key.f16062b));
            Integer numValueOf = Integer.valueOf(key.f16062b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapH.put(numValueOf, Integer.valueOf(iIntValue));
            this.f16060f += iA;
            c(this.f16059e);
        }
    }

    public LruArrayPool(int i2) {
        this.f16055a = new GroupedLinkedMap();
        this.f16056b = new KeyPool();
        this.f16057c = new HashMap();
        this.f16058d = new HashMap();
        this.f16059e = i2;
    }
}
