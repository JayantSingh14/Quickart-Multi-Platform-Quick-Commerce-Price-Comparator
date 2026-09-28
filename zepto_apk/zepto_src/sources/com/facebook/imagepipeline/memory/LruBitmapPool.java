package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.memory.BucketMap;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPoolBackend f18020a = new BitmapPoolBackend();

    /* renamed from: b, reason: collision with root package name */
    public final int f18021b;

    /* renamed from: c, reason: collision with root package name */
    public final NoOpPoolStatsTracker f18022c;

    /* renamed from: d, reason: collision with root package name */
    public int f18023d;

    public LruBitmapPool(int i2, NoOpPoolStatsTracker noOpPoolStatsTracker) {
        this.f18021b = i2;
        this.f18022c = noOpPoolStatsTracker;
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public final void a(Object obj) {
        boolean zAdd;
        Bitmap bitmap = (Bitmap) obj;
        this.f18020a.getClass();
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int iD = BitmapUtil.d(bitmap);
        if (iD <= this.f18021b) {
            this.f18022c.getClass();
            BitmapPoolBackend bitmapPoolBackend = this.f18020a;
            bitmapPoolBackend.getClass();
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if (BitmapPoolBackend.c(bitmap)) {
                synchronized (bitmapPoolBackend) {
                    zAdd = bitmapPoolBackend.f18024a.add(bitmap);
                }
                if (zAdd) {
                    BucketMap bucketMap = bitmapPoolBackend.f18025b;
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    int iD2 = BitmapUtil.d(bitmap);
                    synchronized (bucketMap) {
                        try {
                            BucketMap.LinkedEntry linkedEntry = (BucketMap.LinkedEntry) bucketMap.f18006a.get(iD2);
                            if (linkedEntry == null) {
                                LinkedList linkedList = new LinkedList();
                                linkedEntry = new BucketMap.LinkedEntry();
                                linkedEntry.f18009a = null;
                                linkedEntry.f18010b = iD2;
                                linkedEntry.f18011c = linkedList;
                                linkedEntry.f18012d = null;
                                bucketMap.f18006a.put(iD2, linkedEntry);
                            }
                            linkedEntry.f18011c.addLast(bitmap);
                            if (bucketMap.f18007b != linkedEntry) {
                                bucketMap.a(linkedEntry);
                                BucketMap.LinkedEntry linkedEntry2 = bucketMap.f18007b;
                                if (linkedEntry2 == null) {
                                    bucketMap.f18007b = linkedEntry;
                                    bucketMap.f18008c = linkedEntry;
                                } else {
                                    linkedEntry.f18012d = linkedEntry2;
                                    linkedEntry2.f18009a = linkedEntry;
                                    bucketMap.f18007b = linkedEntry;
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
            synchronized (this) {
                this.f18023d += iD;
            }
        }
    }

    public final synchronized void e() {
        Bitmap bitmap;
        while (this.f18023d > 0 && (bitmap = (Bitmap) this.f18020a.a()) != null) {
            this.f18020a.getClass();
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.f18023d -= BitmapUtil.d(bitmap);
            this.f18022c.getClass();
        }
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int i2) {
        synchronized (this) {
            try {
                if (this.f18023d > 0) {
                    e();
                }
                Bitmap bitmap = (Bitmap) this.f18020a.b(i2);
                if (bitmap == null) {
                    this.f18022c.getClass();
                    return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
                }
                this.f18020a.getClass();
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.f18023d -= BitmapUtil.d(bitmap);
                this.f18022c.getClass();
                return bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
