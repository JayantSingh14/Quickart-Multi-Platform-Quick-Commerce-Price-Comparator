package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SavedStateHandle {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f4896f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4897a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4898b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f4899c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f4900d;

    /* renamed from: e, reason: collision with root package name */
    public final SavedStateRegistry.SavedStateProvider f4901e;

    @Metadata
    public static final class Companion {
        public static SavedStateHandle a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new SavedStateHandle();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new SavedStateHandle(map);
            }
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            Intrinsics.c(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = parcelableArrayList.get(i2);
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
            }
            return new SavedStateHandle(linkedHashMap);
        }
    }

    @Metadata
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
    }

    public SavedStateHandle(HashMap initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f4897a = linkedHashMap;
        this.f4898b = new LinkedHashMap();
        this.f4899c = new LinkedHashMap();
        this.f4900d = new LinkedHashMap();
        this.f4901e = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.b
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return SavedStateHandle.a(this.f4961a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static Bundle a(SavedStateHandle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = MapsKt.l(this$0.f4898b).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = this$0.f4897a;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                return BundleKt.a(new Pair("keys", arrayList), new Pair("values", arrayList2));
            }
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Bundle bundleA = ((SavedStateRegistry.SavedStateProvider) entry.getValue()).a();
            Intrinsics.checkNotNullParameter(key, "key");
            if (bundleA != null) {
                Class[] clsArr = f4896f;
                for (int i2 = 0; i2 < 29; i2++) {
                    Class cls = clsArr[i2];
                    Intrinsics.c(cls);
                    if (!cls.isInstance(bundleA)) {
                    }
                }
                throw new IllegalArgumentException("Can't put value with type " + bundleA.getClass() + " into saved state");
            }
            Object obj = this$0.f4899c.get(key);
            MutableLiveData mutableLiveData = obj instanceof MutableLiveData ? (MutableLiveData) obj : null;
            if (mutableLiveData != null) {
                mutableLiveData.k(bundleA);
            } else {
                linkedHashMap.put(key, bundleA);
            }
            MutableStateFlow mutableStateFlow = (MutableStateFlow) this$0.f4900d.get(key);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(bundleA);
            }
        }
    }

    public final SavedStateRegistry.SavedStateProvider b() {
        return this.f4901e;
    }

    public SavedStateHandle() {
        this.f4897a = new LinkedHashMap();
        this.f4898b = new LinkedHashMap();
        this.f4899c = new LinkedHashMap();
        this.f4900d = new LinkedHashMap();
        this.f4901e = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.b
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return SavedStateHandle.a(this.f4961a);
            }
        };
    }
}
