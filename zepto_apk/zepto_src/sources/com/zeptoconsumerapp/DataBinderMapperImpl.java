package com.zeptoconsumerapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.databinding.DataBinderMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
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
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}
