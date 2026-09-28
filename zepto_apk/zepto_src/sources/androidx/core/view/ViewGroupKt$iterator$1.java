package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
/* loaded from: classes3.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3103a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewGroup f3104b;

    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f3104b = viewGroup;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3103a < this.f3104b.getChildCount();
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup viewGroup = this.f3104b;
        int i2 = this.f3103a;
        this.f3103a = i2 + 1;
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ViewGroup viewGroup = this.f3104b;
        int i2 = this.f3103a - 1;
        this.f3103a = i2;
        viewGroup.removeViewAt(i2);
    }
}
