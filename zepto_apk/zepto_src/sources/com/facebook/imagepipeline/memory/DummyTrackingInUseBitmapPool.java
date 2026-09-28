package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DummyTrackingInUseBitmapPool implements BitmapPool {

    /* renamed from: a, reason: collision with root package name */
    public final Set f18018a;

    public DummyTrackingInUseBitmapPool() {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newIdentityHashSet(...)");
        this.f18018a = setNewSetFromMap;
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public final void a(Object obj) {
        Bitmap value = (Bitmap) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        this.f18018a.remove(value);
        value.recycle();
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        this.f18018a.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
