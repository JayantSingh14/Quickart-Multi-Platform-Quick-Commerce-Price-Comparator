package io.sentry.android.replay;

import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RootViewsSpy$listeners$1 extends CopyOnWriteArrayList<OnRootViewsChangedListener> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RootViewsSpy f52464a;

    public RootViewsSpy$listeners$1(RootViewsSpy rootViewsSpy) {
        this.f52464a = rootViewsSpy;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        OnRootViewsChangedListener onRootViewsChangedListener = (OnRootViewsChangedListener) obj;
        RootViewsSpy rootViewsSpy = this.f52464a;
        synchronized (rootViewsSpy.f52459b) {
            try {
                Iterator<View> it = rootViewsSpy.f52461d.iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    if (onRootViewsChangedListener != null) {
                        onRootViewsChangedListener.a(next, true);
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.add(onRootViewsChangedListener);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
            return super.contains((OnRootViewsChangedListener) obj);
        }
        return false;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
            return super.indexOf((OnRootViewsChangedListener) obj);
        }
        return -1;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
            return super.lastIndexOf((OnRootViewsChangedListener) obj);
        }
        return -1;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
            return super.remove((OnRootViewsChangedListener) obj);
        }
        return false;
    }
}
