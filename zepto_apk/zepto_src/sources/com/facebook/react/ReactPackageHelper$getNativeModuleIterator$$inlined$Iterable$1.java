package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1 implements Iterable<ModuleHolder>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f18491a;

    public ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1(List list) {
        this.f18491a = list;
    }

    @Override // java.lang.Iterable
    public final Iterator<ModuleHolder> iterator() {
        return new ReactPackageHelper$getNativeModuleIterator$1$1(this.f18491a);
    }
}
