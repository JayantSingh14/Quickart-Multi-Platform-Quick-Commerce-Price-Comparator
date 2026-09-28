package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes3.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    public final ListView r;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.r = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public final boolean a(int i2) {
        ListView listView = this.r;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i3 = firstVisiblePosition + childCount;
        if (i2 > 0) {
            if (i3 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i2 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public final void f(int i2) {
        this.r.scrollListBy(i2);
    }
}
