package androidx.databinding.library.baseAdapters;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.databinding.DataBinderMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    public static class InnerBrLookup {
        static {
            new SparseArray(1).put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {
        static {
            new HashMap(0);
        }
    }

    static {
        new SparseIntArray(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final List a() {
        return new ArrayList(0);
    }
}
