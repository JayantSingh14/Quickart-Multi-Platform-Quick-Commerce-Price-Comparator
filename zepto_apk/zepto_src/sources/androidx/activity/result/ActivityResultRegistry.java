package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.b;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f200a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f201b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f202c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f203d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f204e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f205f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f206g = new Bundle();

    @Metadata
    public static final class CallbackAndContract<O> {

        /* renamed from: a, reason: collision with root package name */
        public final ActivityResultCallback f207a;

        /* renamed from: b, reason: collision with root package name */
        public final ActivityResultContract f208b;

        public CallbackAndContract(ActivityResultContract contract, ActivityResultCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.f207a = callback;
            this.f208b = contract;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public static final class LifecycleContainer {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f209a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f210b;

        public LifecycleContainer(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.f209a = lifecycle;
            this.f210b = new ArrayList();
        }
    }

    public final void a(int i2, Object obj) {
        String str = (String) this.f200a.get(Integer.valueOf(i2));
        if (str == null) {
            return;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.f204e.get(str);
        if ((callbackAndContract != null ? callbackAndContract.f207a : null) == null) {
            this.f206g.remove(str);
            this.f205f.put(str, obj);
            return;
        }
        ActivityResultCallback activityResultCallback = callbackAndContract.f207a;
        Intrinsics.d(activityResultCallback, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (this.f203d.remove(str)) {
            activityResultCallback.b(obj);
        }
    }

    public final boolean b(int i2, int i3, Intent intent) {
        String str = (String) this.f200a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.f204e.get(str);
        if ((callbackAndContract != null ? callbackAndContract.f207a : null) != null) {
            ArrayList arrayList = this.f203d;
            if (arrayList.contains(str)) {
                callbackAndContract.f207a.b(callbackAndContract.f208b.c(intent, i3));
                arrayList.remove(str);
                return true;
            }
        }
        this.f205f.remove(str);
        this.f206g.putParcelable(str, new ActivityResult(intent, i3));
        return true;
    }

    public abstract void c(int i2, ActivityResultContract activityResultContract, Object obj);

    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.activity.result.ActivityResultRegistry$register$2] */
    public final ActivityResultRegistry$register$2 d(final String key, LifecycleOwner lifecycleOwner, final ActivityResultContract contract, final ActivityResultCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b().a(Lifecycle.State.f4808d)) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        f(key);
        LinkedHashMap linkedHashMap = this.f202c;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        LifecycleEventObserver observer = new LifecycleEventObserver() { // from class: androidx.activity.result.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void a(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ActivityResultRegistry this$0 = this.f226a;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                String key2 = key;
                Intrinsics.checkNotNullParameter(key2, "$key");
                ActivityResultCallback callback2 = callback;
                Intrinsics.checkNotNullParameter(callback2, "$callback");
                ActivityResultContract contract2 = contract;
                Intrinsics.checkNotNullParameter(contract2, "$contract");
                Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                if (Lifecycle.Event.ON_START != event) {
                    if (Lifecycle.Event.ON_STOP == event) {
                        this$0.f204e.remove(key2);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY == event) {
                            this$0.g(key2);
                            return;
                        }
                        return;
                    }
                }
                this$0.f204e.put(key2, new ActivityResultRegistry.CallbackAndContract(contract2, callback2));
                LinkedHashMap linkedHashMap2 = this$0.f205f;
                if (linkedHashMap2.containsKey(key2)) {
                    Object obj = linkedHashMap2.get(key2);
                    linkedHashMap2.remove(key2);
                    callback2.b(obj);
                }
                Bundle bundle = this$0.f206g;
                ActivityResult activityResult = (ActivityResult) BundleCompat.a(bundle, key2);
                if (activityResult != null) {
                    bundle.remove(key2);
                    callback2.b(contract2.c(activityResult.f199b, activityResult.f198a));
                }
            }
        };
        Intrinsics.checkNotNullParameter(observer, "observer");
        lifecycleContainer.f209a.a(observer);
        lifecycleContainer.f210b.add(observer);
        linkedHashMap.put(key, lifecycleContainer);
        return new ActivityResultLauncher<Object>() { // from class: androidx.activity.result.ActivityResultRegistry$register$2
            @Override // androidx.activity.result.ActivityResultLauncher
            public final void a(Object obj) throws Exception {
                ActivityResultRegistry activityResultRegistry = this.f212a;
                LinkedHashMap linkedHashMap2 = activityResultRegistry.f201b;
                String str = key;
                Object obj2 = linkedHashMap2.get(str);
                ActivityResultContract activityResultContract = contract;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                ArrayList arrayList = activityResultRegistry.f203d;
                arrayList.add(str);
                try {
                    activityResultRegistry.c(iIntValue, activityResultContract, obj);
                } catch (Exception e2) {
                    arrayList.remove(str);
                    throw e2;
                }
            }
        };
    }

    public final ActivityResultRegistry$register$3 e(String key, ActivityResultContract contract, ActivityResultCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f(key);
        this.f204e.put(key, new CallbackAndContract(contract, callback));
        LinkedHashMap linkedHashMap = this.f205f;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            callback.b(obj);
        }
        Bundle bundle = this.f206g;
        ActivityResult activityResult = (ActivityResult) BundleCompat.a(bundle, key);
        if (activityResult != null) {
            bundle.remove(key);
            callback.b(contract.c(activityResult.f199b, activityResult.f198a));
        }
        return new ActivityResultRegistry$register$3(this, key, contract);
    }

    public final void f(String str) {
        LinkedHashMap linkedHashMap = this.f201b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        Iterator it = SequencesKt.i(ActivityResultRegistry$generateRandomNumber$1.f211c).iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            int iIntValue = number.intValue();
            LinkedHashMap linkedHashMap2 = this.f200a;
            if (!linkedHashMap2.containsKey(Integer.valueOf(iIntValue))) {
                int iIntValue2 = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue2), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue2));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void g(String key) {
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f203d.contains(key) && (num = (Integer) this.f201b.remove(key)) != null) {
            this.f200a.remove(num);
        }
        this.f204e.remove(key);
        LinkedHashMap linkedHashMap = this.f205f;
        if (linkedHashMap.containsKey(key)) {
            StringBuilder sbY = b.y("Dropping pending result for request ", key, ": ");
            sbY.append(linkedHashMap.get(key));
            Log.w("ActivityResultRegistry", sbY.toString());
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.f206g;
        if (bundle.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) BundleCompat.a(bundle, key)));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.f202c;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap2.get(key);
        if (lifecycleContainer != null) {
            ArrayList arrayList = lifecycleContainer.f210b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                lifecycleContainer.f209a.c((LifecycleEventObserver) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }
}
