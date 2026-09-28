package com.facebook.react;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.model.ReactModuleInfo;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public final class BaseReactPackage$getNativeModuleIterator$1$1 implements Iterator<ModuleHolder>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public Map.Entry f18405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f18406b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseReactPackage f18407c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f18408d;

    public BaseReactPackage$getNativeModuleIterator$1$1(Iterator it, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.f18406b = it;
        this.f18407c = baseReactPackage;
        this.f18408d = reactApplicationContext;
    }

    public final void a() {
        Map.Entry entry;
        ReactModuleInfo reactModuleInfo;
        do {
            Iterator it = this.f18406b;
            if (!it.hasNext()) {
                this.f18405a = null;
                return;
            }
            entry = (Map.Entry) it.next();
            reactModuleInfo = (ReactModuleInfo) entry.getValue();
            if (!ReactNativeFeatureFlags.f18968a.useTurboModules()) {
                break;
            }
        } while (reactModuleInfo.f19025f);
        this.f18405a = entry;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f18405a == null) {
            a();
        }
        return this.f18405a != null;
    }

    @Override // java.util.Iterator
    public final ModuleHolder next() {
        if (this.f18405a == null) {
            a();
        }
        Map.Entry entry = this.f18405a;
        if (entry == null) {
            throw new NoSuchElementException("ModuleHolder not found");
        }
        a();
        return new ModuleHolder((ReactModuleInfo) entry.getValue(), new BaseReactPackage.ModuleHolderProvider(this.f18407c, (String) entry.getKey(), this.f18408d));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
