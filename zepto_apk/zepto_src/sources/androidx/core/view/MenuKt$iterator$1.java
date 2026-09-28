package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3052a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Menu f3053b;

    public MenuKt$iterator$1(Menu menu) {
        this.f3053b = menu;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3052a < this.f3053b.size();
    }

    @Override // java.util.Iterator
    public final MenuItem next() {
        Menu menu = this.f3053b;
        int i2 = this.f3052a;
        this.f3052a = i2 + 1;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Unit unit;
        Menu menu = this.f3053b;
        int i2 = this.f3052a - 1;
        this.f3052a = i2;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.f53572a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
