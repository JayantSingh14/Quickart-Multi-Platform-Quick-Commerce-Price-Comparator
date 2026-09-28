package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class ThumbnailStreamOpener {

    /* renamed from: e, reason: collision with root package name */
    public static final FileService f15855e = new FileService();

    /* renamed from: a, reason: collision with root package name */
    public final ThumbnailQuery f15856a;

    /* renamed from: b, reason: collision with root package name */
    public final LruArrayPool f15857b;

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f15858c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f15859d;

    public ThumbnailStreamOpener(ArrayList arrayList, ThumbnailQuery thumbnailQuery, LruArrayPool lruArrayPool, ContentResolver contentResolver) {
        this.f15856a = thumbnailQuery;
        this.f15857b = lruArrayPool;
        this.f15858c = contentResolver;
        this.f15859d = arrayList;
    }
}
