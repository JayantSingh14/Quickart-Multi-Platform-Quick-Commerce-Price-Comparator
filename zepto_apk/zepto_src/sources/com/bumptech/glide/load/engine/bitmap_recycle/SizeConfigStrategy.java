package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.media.b;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi
/* loaded from: classes3.dex */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f16074d;

    /* renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f16075e;

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f16076f;

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f16077g;

    /* renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f16078h;

    /* renamed from: a, reason: collision with root package name */
    public final KeyPool f16079a = new KeyPool();

    /* renamed from: b, reason: collision with root package name */
    public final GroupedLinkedMap f16080b = new GroupedLinkedMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f16081c = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16082a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f16082a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16082a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16082a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16082a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    public static final class Key implements Poolable {

        /* renamed from: a, reason: collision with root package name */
        public final KeyPool f16083a;

        /* renamed from: b, reason: collision with root package name */
        public int f16084b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap.Config f16085c;

        public Key(KeyPool keyPool) {
            this.f16083a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void a() {
            this.f16083a.c(this);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f16084b == key.f16084b && Util.a(this.f16085c, key.f16085c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i2 = this.f16084b * 31;
            Bitmap.Config config = this.f16085c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public final String toString() {
            return SizeConfigStrategy.c(this.f16084b, this.f16085c);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final Poolable a() {
            return new Key(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f16074d = configArr;
        f16075e = configArr;
        f16076f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f16077g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f16078h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(Util.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iB = Util.b(i2, i3, config);
        KeyPool keyPool = this.f16079a;
        Key key = (Key) keyPool.b();
        key.f16084b = iB;
        key.f16085c = config;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i4 = AnonymousClass1.f16082a[config.ordinal()];
            configArr = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? new Bitmap.Config[]{config} : f16078h : f16077g : f16076f : f16074d;
        } else {
            configArr = f16075e;
        }
        int length = configArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i5];
            Integer num = (Integer) d(config2).ceilingKey(Integer.valueOf(iB));
            if (num == null || num.intValue() > iB * 8) {
                i5++;
            } else if (num.intValue() != iB || (config2 != null ? !config2.equals(config) : config != null)) {
                keyPool.c(key);
                int iIntValue = num.intValue();
                key = (Key) keyPool.b();
                key.f16084b = iIntValue;
                key.f16085c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.f16080b.a(key);
        if (bitmap != null) {
            a(Integer.valueOf(key.f16084b), bitmap);
            bitmap.reconfigure(i2, i3, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap map = this.f16081c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final String e(int i2, int i3, Bitmap.Config config) {
        return c(Util.b(i2, i3, config), config);
    }

    public final void f(Bitmap bitmap) {
        int iC = Util.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        Key key = (Key) this.f16079a.b();
        key.f16084b = iC;
        key.f16085c = config;
        this.f16080b.b(key, bitmap);
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(key.f16084b));
        navigableMapD.put(Integer.valueOf(key.f16084b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbW = b.w("SizeConfigStrategy{groupedMap=");
        sbW.append(this.f16080b);
        sbW.append(", sortedSizes=(");
        HashMap map = this.f16081c;
        for (Map.Entry entry : map.entrySet()) {
            sbW.append(entry.getKey());
            sbW.append('[');
            sbW.append(entry.getValue());
            sbW.append("], ");
        }
        if (!map.isEmpty()) {
            sbW.replace(sbW.length() - 2, sbW.length(), "");
        }
        sbW.append(")}");
        return sbW.toString();
    }
}
