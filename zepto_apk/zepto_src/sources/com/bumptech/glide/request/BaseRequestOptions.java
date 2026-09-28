package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f16441a;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f16444d;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16449i;
    public boolean n;
    public boolean o;
    public boolean q;

    /* renamed from: b, reason: collision with root package name */
    public DiskCacheStrategy f16442b = DiskCacheStrategy.f15938c;

    /* renamed from: c, reason: collision with root package name */
    public Priority f16443c = Priority.f15685a;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16445e = true;

    /* renamed from: f, reason: collision with root package name */
    public int f16446f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f16447g = -1;

    /* renamed from: h, reason: collision with root package name */
    public Key f16448h = EmptySignature.f16502b;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16450j = true;

    /* renamed from: k, reason: collision with root package name */
    public Options f16451k = new Options();

    /* renamed from: l, reason: collision with root package name */
    public CachedHashCodeArrayMap f16452l = new CachedHashCodeArrayMap();

    /* renamed from: m, reason: collision with root package name */
    public Class f16453m = Object.class;
    public boolean p = true;

    public static boolean e(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public BaseRequestOptions a(BaseRequestOptions baseRequestOptions) {
        if (this.o) {
            return clone().a(baseRequestOptions);
        }
        int i2 = baseRequestOptions.f16441a;
        if (e(baseRequestOptions.f16441a, 1048576)) {
            this.q = baseRequestOptions.q;
        }
        if (e(baseRequestOptions.f16441a, 4)) {
            this.f16442b = baseRequestOptions.f16442b;
        }
        if (e(baseRequestOptions.f16441a, 8)) {
            this.f16443c = baseRequestOptions.f16443c;
        }
        if (e(baseRequestOptions.f16441a, 16)) {
            this.f16441a &= -33;
        }
        if (e(baseRequestOptions.f16441a, 32)) {
            this.f16441a &= -17;
        }
        if (e(baseRequestOptions.f16441a, 64)) {
            this.f16444d = baseRequestOptions.f16444d;
            this.f16441a &= -129;
        }
        if (e(baseRequestOptions.f16441a, 128)) {
            this.f16444d = null;
            this.f16441a &= -65;
        }
        if (e(baseRequestOptions.f16441a, 256)) {
            this.f16445e = baseRequestOptions.f16445e;
        }
        if (e(baseRequestOptions.f16441a, 512)) {
            this.f16447g = baseRequestOptions.f16447g;
            this.f16446f = baseRequestOptions.f16446f;
        }
        if (e(baseRequestOptions.f16441a, 1024)) {
            this.f16448h = baseRequestOptions.f16448h;
        }
        if (e(baseRequestOptions.f16441a, 4096)) {
            this.f16453m = baseRequestOptions.f16453m;
        }
        if (e(baseRequestOptions.f16441a, KEYRecord.Flags.FLAG2)) {
            this.f16441a &= -16385;
        }
        if (e(baseRequestOptions.f16441a, 16384)) {
            this.f16441a &= -8193;
        }
        if (e(baseRequestOptions.f16441a, 65536)) {
            this.f16450j = baseRequestOptions.f16450j;
        }
        if (e(baseRequestOptions.f16441a, 131072)) {
            this.f16449i = baseRequestOptions.f16449i;
        }
        if (e(baseRequestOptions.f16441a, 2048)) {
            this.f16452l.putAll(baseRequestOptions.f16452l);
            this.p = baseRequestOptions.p;
        }
        if (!this.f16450j) {
            this.f16452l.clear();
            int i3 = this.f16441a;
            this.f16449i = false;
            this.f16441a = i3 & (-133121);
            this.p = true;
        }
        this.f16441a |= baseRequestOptions.f16441a;
        this.f16451k.f15817b.g(baseRequestOptions.f16451k.f15817b);
        i();
        return this;
    }

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BaseRequestOptions clone() {
        try {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) super.clone();
            Options options = new Options();
            baseRequestOptions.f16451k = options;
            options.f15817b.g(this.f16451k.f15817b);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            baseRequestOptions.f16452l = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f16452l);
            baseRequestOptions.n = false;
            baseRequestOptions.o = false;
            return baseRequestOptions;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final BaseRequestOptions c(Class cls) {
        if (this.o) {
            return clone().c(cls);
        }
        this.f16453m = cls;
        this.f16441a |= 4096;
        i();
        return this;
    }

    public final BaseRequestOptions d(DiskCacheStrategy diskCacheStrategy) {
        if (this.o) {
            return clone().d(diskCacheStrategy);
        }
        Preconditions.c(diskCacheStrategy, "Argument must not be null");
        this.f16442b = diskCacheStrategy;
        this.f16441a |= 4;
        i();
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        baseRequestOptions.getClass();
        if (Float.compare(1.0f, 1.0f) != 0) {
            return false;
        }
        char[] cArr = Util.f16528a;
        return Util.a(this.f16444d, baseRequestOptions.f16444d) && this.f16445e == baseRequestOptions.f16445e && this.f16446f == baseRequestOptions.f16446f && this.f16447g == baseRequestOptions.f16447g && this.f16449i == baseRequestOptions.f16449i && this.f16450j == baseRequestOptions.f16450j && this.f16442b.equals(baseRequestOptions.f16442b) && this.f16443c == baseRequestOptions.f16443c && this.f16451k.equals(baseRequestOptions.f16451k) && this.f16452l.equals(baseRequestOptions.f16452l) && this.f16453m.equals(baseRequestOptions.f16453m) && Util.a(this.f16448h, baseRequestOptions.f16448h);
    }

    public final BaseRequestOptions f(int i2, int i3) {
        if (this.o) {
            return clone().f(i2, i3);
        }
        this.f16447g = i2;
        this.f16446f = i3;
        this.f16441a |= 512;
        i();
        return this;
    }

    public final BaseRequestOptions g(Drawable drawable) {
        if (this.o) {
            return clone().g(drawable);
        }
        this.f16444d = drawable;
        this.f16441a = (this.f16441a | 64) & (-129);
        i();
        return this;
    }

    public final BaseRequestOptions h() {
        Priority priority = Priority.f15686b;
        if (this.o) {
            return clone().h();
        }
        this.f16443c = priority;
        this.f16441a |= 8;
        i();
        return this;
    }

    public final int hashCode() {
        return Util.g(Util.g(Util.g(Util.g(Util.g(Util.g(Util.g(Util.f(0, Util.f(0, Util.f(this.f16450j ? 1 : 0, Util.f(this.f16449i ? 1 : 0, Util.f(this.f16447g, Util.f(this.f16446f, Util.f(this.f16445e ? 1 : 0, Util.g(Util.f(0, Util.g(Util.f(0, Util.g(Util.f(0, Util.e(1.0f, 17)), null)), this.f16444d)), null)))))))), this.f16442b), this.f16443c), this.f16451k), this.f16452l), this.f16453m), this.f16448h), null);
    }

    public final void i() {
        if (this.n) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final BaseRequestOptions j(Option option, DownsampleStrategy downsampleStrategy) {
        if (this.o) {
            return clone().j(option, downsampleStrategy);
        }
        Preconditions.b(option);
        Preconditions.b(downsampleStrategy);
        this.f16451k.f15817b.put(option, downsampleStrategy);
        i();
        return this;
    }

    public final BaseRequestOptions k(ObjectKey objectKey) {
        if (this.o) {
            return clone().k(objectKey);
        }
        this.f16448h = objectKey;
        this.f16441a |= 1024;
        i();
        return this;
    }

    public final BaseRequestOptions l() {
        if (this.o) {
            return clone().l();
        }
        this.f16445e = false;
        this.f16441a |= 256;
        i();
        return this;
    }

    public final BaseRequestOptions m(Transformation transformation, boolean z) {
        if (this.o) {
            return clone().m(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        o(Bitmap.class, transformation, z);
        o(Drawable.class, drawableTransformation, z);
        o(BitmapDrawable.class, drawableTransformation, z);
        o(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        i();
        return this;
    }

    public final BaseRequestOptions n(DownsampleStrategy downsampleStrategy, FitCenter fitCenter) {
        if (this.o) {
            return clone().n(downsampleStrategy, fitCenter);
        }
        Option option = DownsampleStrategy.f16270d;
        Preconditions.c(downsampleStrategy, "Argument must not be null");
        j(option, downsampleStrategy);
        return m(fitCenter, true);
    }

    public final BaseRequestOptions o(Class cls, Transformation transformation, boolean z) {
        if (this.o) {
            return clone().o(cls, transformation, z);
        }
        Preconditions.b(transformation);
        this.f16452l.put(cls, transformation);
        int i2 = this.f16441a;
        this.f16450j = true;
        this.f16441a = 67584 | i2;
        this.p = false;
        if (z) {
            this.f16441a = i2 | 198656;
            this.f16449i = true;
        }
        i();
        return this;
    }

    public final BaseRequestOptions p() {
        if (this.o) {
            return clone().p();
        }
        this.q = true;
        this.f16441a |= 1048576;
        i();
        return this;
    }
}
