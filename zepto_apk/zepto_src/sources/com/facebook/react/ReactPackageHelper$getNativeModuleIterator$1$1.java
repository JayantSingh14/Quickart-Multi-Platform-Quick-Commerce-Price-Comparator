package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public final class ReactPackageHelper$getNativeModuleIterator$1$1 implements Iterator<ModuleHolder>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f18492a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f18493b;

    public ReactPackageHelper$getNativeModuleIterator$1$1(List list) {
        this.f18493b = list;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18492a < this.f18493b.size();
    }

    @Override // java.util.Iterator
    public final ModuleHolder next() {
        int i2 = this.f18492a;
        this.f18492a = i2 + 1;
        return new ModuleHolder((NativeModule) this.f18493b.get(i2));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
