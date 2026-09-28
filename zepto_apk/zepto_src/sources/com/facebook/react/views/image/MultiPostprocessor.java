package com.facebook.react.views.image;

import android.graphics.Bitmap;
import android.support.v4.media.b;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MultiPostprocessor implements Postprocessor {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f19951a;

    @Metadata
    public static final class Companion {
        public static Postprocessor a(ArrayList postprocessors) {
            Intrinsics.checkNotNullParameter(postprocessors, "postprocessors");
            int size = postprocessors.size();
            if (size != 0) {
                return size != 1 ? new MultiPostprocessor(postprocessors) : (Postprocessor) postprocessors.get(0);
            }
            return null;
        }
    }

    public MultiPostprocessor(ArrayList arrayList) {
        this.f19951a = new LinkedList(arrayList);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        LinkedList linkedList = this.f19951a;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(linkedList, 10));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Postprocessor) it.next()).a());
        }
        return new MultiCacheKey(arrayList);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference c(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        LinkedList linkedList = this.f19951a;
        CloseableReference closeableReferenceC = null;
        try {
            Iterator it = linkedList.iterator();
            CloseableReference closeableReferenceClone = null;
            while (it.hasNext()) {
                closeableReferenceC = ((Postprocessor) it.next()).c(closeableReferenceClone != null ? (Bitmap) closeableReferenceClone.l() : sourceBitmap, bitmapFactory);
                CloseableReference.e(closeableReferenceClone);
                closeableReferenceClone = closeableReferenceC.clone();
            }
            if (closeableReferenceC != null) {
                CloseableReference closeableReferenceClone2 = closeableReferenceC.clone();
                Intrinsics.checkNotNullExpressionValue(closeableReferenceClone2, "clone(...)");
                closeableReferenceC.close();
                return closeableReferenceClone2;
            }
            throw new IllegalStateException(("MultiPostprocessor returned null bitmap - Number of Postprocessors: " + linkedList.size()).toString());
        } catch (Throwable th) {
            CloseableReference.e(null);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return b.D("MultiPostProcessor (", CollectionsKt.E(this.f19951a, ",", null, null, null, 62), ")");
    }
}
