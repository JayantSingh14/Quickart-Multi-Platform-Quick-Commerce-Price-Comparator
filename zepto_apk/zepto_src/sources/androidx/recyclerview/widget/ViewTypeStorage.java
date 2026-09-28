package androidx.recyclerview.widget;

import android.util.SparseArray;

/* loaded from: classes3.dex */
interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {

        public class WrapperViewTypeLookup implements ViewTypeLookup {
        }

        public IsolatedViewTypeStorage() {
            new SparseArray();
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {

        public class WrapperViewTypeLookup implements ViewTypeLookup {
        }

        public SharedIdRangeViewTypeStorage() {
            new SparseArray();
        }
    }

    public interface ViewTypeLookup {
    }
}
