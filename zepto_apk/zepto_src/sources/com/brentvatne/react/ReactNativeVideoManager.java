package com.brentvatne.react;

import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.exoplayer.RNVExoplayerPlugin;
import com.brentvatne.exoplayer.ReactExoplayerViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReactNativeVideoManager implements RNVPlugin {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f15630c = new Companion();

    /* renamed from: d, reason: collision with root package name */
    public static volatile ReactNativeVideoManager f15631d;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15632a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f15633b = new ArrayList();

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public final ReactNativeVideoManager a() {
            ReactNativeVideoManager reactNativeVideoManager;
            ReactNativeVideoManager reactNativeVideoManager2 = ReactNativeVideoManager.f15631d;
            if (reactNativeVideoManager2 != null) {
                return reactNativeVideoManager2;
            }
            synchronized (this) {
                reactNativeVideoManager = ReactNativeVideoManager.f15631d;
                if (reactNativeVideoManager == null) {
                    reactNativeVideoManager = new ReactNativeVideoManager();
                    ReactNativeVideoManager.f15631d = reactNativeVideoManager;
                }
            }
            return reactNativeVideoManager;
        }
    }

    public final DataSource.Factory a(Source source, DataSource.Factory mediaDataSourceFactory) {
        DataSource.Factory factoryA;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaDataSourceFactory, "mediaDataSourceFactory");
        Iterator it = this.f15632a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = (RNVPlugin) next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (factoryA = ((RNVExoplayerPlugin) rNVPlugin).a(source, mediaDataSourceFactory)) != null) {
                return factoryA;
            }
        }
        return null;
    }

    @Override // com.brentvatne.react.RNVPlugin
    public final void b(Object player, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator it = this.f15632a.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).b(player, id);
        }
    }

    public final DrmSessionManager c(Source source, DrmSessionManager drmSessionManager) {
        DrmSessionManager drmSessionManagerC;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(drmSessionManager, "drmSessionManager");
        Iterator it = this.f15632a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = (RNVPlugin) next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (drmSessionManagerC = ((RNVExoplayerPlugin) rNVPlugin).c(source, drmSessionManager)) != null) {
                return drmSessionManagerC;
            }
        }
        return null;
    }

    @Override // com.brentvatne.react.RNVPlugin
    public final void d(Object player, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator it = this.f15632a.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).d(player, id);
        }
    }

    public final MediaItem.Builder e(Source source, MediaItem.Builder mediaItemBuilder) {
        MediaItem.Builder builderE;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaItemBuilder, "mediaItemBuilder");
        Iterator it = this.f15632a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = (RNVPlugin) next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (builderE = ((RNVExoplayerPlugin) rNVPlugin).e(source, mediaItemBuilder)) != null) {
                return builderE;
            }
        }
        return null;
    }

    public final boolean f(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Iterator it = this.f15632a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = (RNVPlugin) next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && ((RNVExoplayerPlugin) rNVPlugin).f(source)) {
                return true;
            }
        }
        return false;
    }

    public final void g(ReactExoplayerViewManager newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        ArrayList arrayList = this.f15633b;
        if (arrayList.size() > 2) {
            DebugLog.a("ReactNativeVideoManager", "multiple Video displayed ?");
        }
        arrayList.add(newInstance);
    }

    public final void h(ReactExoplayerViewManager newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        this.f15633b.remove(newInstance);
    }
}
