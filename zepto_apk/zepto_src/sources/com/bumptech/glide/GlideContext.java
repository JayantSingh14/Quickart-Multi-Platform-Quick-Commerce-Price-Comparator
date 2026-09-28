package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

/* loaded from: classes3.dex */
public class GlideContext extends ContextWrapper {

    /* renamed from: i, reason: collision with root package name */
    public static final GenericTransitionOptions f15670i = new GenericTransitionOptions();

    /* renamed from: a, reason: collision with root package name */
    public final LruArrayPool f15671a;

    /* renamed from: b, reason: collision with root package name */
    public final Registry f15672b;

    /* renamed from: c, reason: collision with root package name */
    public final Glide.RequestOptionsFactory f15673c;

    /* renamed from: d, reason: collision with root package name */
    public final List f15674d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f15675e;

    /* renamed from: f, reason: collision with root package name */
    public final Engine f15676f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15677g;

    /* renamed from: h, reason: collision with root package name */
    public RequestOptions f15678h;

    public GlideContext(Context context, LruArrayPool lruArrayPool, Registry registry, Glide.RequestOptionsFactory requestOptionsFactory, ArrayMap arrayMap, List list, Engine engine, int i2) {
        super(context.getApplicationContext());
        this.f15671a = lruArrayPool;
        this.f15672b = registry;
        this.f15673c = requestOptionsFactory;
        this.f15674d = list;
        this.f15675e = arrayMap;
        this.f15676f = engine;
        this.f15677g = i2;
    }
}
