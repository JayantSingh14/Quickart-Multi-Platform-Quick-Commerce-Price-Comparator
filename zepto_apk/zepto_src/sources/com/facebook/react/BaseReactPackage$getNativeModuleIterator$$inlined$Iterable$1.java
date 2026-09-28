package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1 implements Iterable<ModuleHolder>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f18399a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseReactPackage f18400b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f18401c;

    public BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1(Iterator it, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.f18399a = it;
        this.f18400b = baseReactPackage;
        this.f18401c = reactApplicationContext;
    }

    @Override // java.lang.Iterable
    public final Iterator<ModuleHolder> iterator() {
        return new BaseReactPackage$getNativeModuleIterator$1$1(this.f18399a, this.f18400b, this.f18401c);
    }
}
