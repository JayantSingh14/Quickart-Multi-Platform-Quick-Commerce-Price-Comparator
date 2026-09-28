package io.sentry.android.replay;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RootViewsSpy$delegatingViewList$1 extends ArrayList<View> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RootViewsSpy f52463a;

    public RootViewsSpy$delegatingViewList$1(RootViewsSpy rootViewsSpy) {
        this.f52463a = rootViewsSpy;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        View element = (View) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        Iterator<OnRootViewsChangedListener> it = this.f52463a.f52460c.iterator();
        while (it.hasNext()) {
            it.next().a(element, true);
        }
        return super.add(element);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<OnRootViewsChangedListener> it = this.f52463a.f52460c.iterator();
        while (it.hasNext()) {
            OnRootViewsChangedListener next = it.next();
            Iterator it2 = elements.iterator();
            while (it2.hasNext()) {
                next.a((View) it2.next(), true);
            }
        }
        return super.addAll(elements);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof View) {
            return super.contains((View) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof View) {
            return super.indexOf((View) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof View) {
            return super.lastIndexOf((View) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof View) {
            return super.remove((View) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        Object objRemove = super.remove(i2);
        Intrinsics.checkNotNullExpressionValue(objRemove, "super.removeAt(index)");
        View view = (View) objRemove;
        Iterator<OnRootViewsChangedListener> it = this.f52463a.f52460c.iterator();
        while (it.hasNext()) {
            it.next().a(view, false);
        }
        return view;
    }
}
