package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistry$register$3;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    public Fragment A;
    public ActivityResultRegistry$register$3 D;
    public ActivityResultRegistry$register$3 E;
    public ActivityResultRegistry$register$3 F;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public FragmentManagerViewModel P;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4565b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f4568e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f4570g;
    public final i r;
    public final i s;
    public final i t;
    public final i u;
    public FragmentHostCallback x;
    public FragmentContainer y;
    public Fragment z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4564a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final FragmentStore f4566c = new FragmentStore();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f4567d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final FragmentLayoutInflaterFactory f4569f = new FragmentLayoutInflaterFactory(this);

    /* renamed from: h, reason: collision with root package name */
    public BackStackRecord f4571h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4572i = false;

    /* renamed from: j, reason: collision with root package name */
    public final OnBackPressedCallback f4573j = new OnBackPressedCallback() { // from class: androidx.fragment.app.FragmentManager.1
        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackCancelled() {
            boolean zO = FragmentManager.O(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (zO) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            if (FragmentManager.O(3)) {
                Log.d("FragmentManager", "cancelBackStackTransition for transition " + fragmentManager.f4571h);
            }
            BackStackRecord backStackRecord = fragmentManager.f4571h;
            if (backStackRecord != null) {
                backStackRecord.u = false;
                backStackRecord.n();
                BackStackRecord backStackRecord2 = fragmentManager.f4571h;
                c cVar = new c(fragmentManager, 3);
                if (backStackRecord2.s == null) {
                    backStackRecord2.s = new ArrayList();
                }
                backStackRecord2.s.add(cVar);
                fragmentManager.f4571h.c();
                fragmentManager.f4572i = true;
                fragmentManager.A(true);
                fragmentManager.G();
                fragmentManager.f4572i = false;
                fragmentManager.f4571h = null;
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            boolean zO = FragmentManager.O(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (zO) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            fragmentManager.f4572i = true;
            fragmentManager.A(true);
            fragmentManager.f4572i = false;
            BackStackRecord backStackRecord = fragmentManager.f4571h;
            OnBackPressedCallback onBackPressedCallback = fragmentManager.f4573j;
            if (backStackRecord == null) {
                if (onBackPressedCallback.isEnabled()) {
                    if (FragmentManager.O(3)) {
                        Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                    }
                    fragmentManager.V();
                    return;
                } else {
                    if (FragmentManager.O(3)) {
                        Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                    }
                    fragmentManager.f4570g.d();
                    return;
                }
            }
            ArrayList arrayList = fragmentManager.o;
            if (!arrayList.isEmpty()) {
                LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet(FragmentManager.H(fragmentManager.f4571h));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it.next();
                    for (Fragment fragment : linkedHashSet) {
                        onBackStackChangedListener.getClass();
                    }
                }
            }
            Iterator it2 = fragmentManager.f4571h.f4643c.iterator();
            while (it2.hasNext()) {
                Fragment fragment2 = ((FragmentTransaction.Op) it2.next()).f4655b;
                if (fragment2 != null) {
                    fragment2.mTransitioning = false;
                }
            }
            Iterator it3 = fragmentManager.g(new ArrayList(Collections.singletonList(fragmentManager.f4571h)), 0, 1).iterator();
            while (it3.hasNext()) {
                SpecialEffectsController specialEffectsController = (SpecialEffectsController) it3.next();
                specialEffectsController.getClass();
                if (FragmentManager.O(3)) {
                    Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
                }
                ArrayList arrayList2 = specialEffectsController.f4692c;
                specialEffectsController.p(arrayList2);
                specialEffectsController.c(arrayList2);
            }
            Iterator it4 = fragmentManager.f4571h.f4643c.iterator();
            while (it4.hasNext()) {
                Fragment fragment3 = ((FragmentTransaction.Op) it4.next()).f4655b;
                if (fragment3 != null && fragment3.mContainer == null) {
                    fragmentManager.h(fragment3).k();
                }
            }
            fragmentManager.f4571h = null;
            fragmentManager.l0();
            if (FragmentManager.O(3)) {
                Log.d("FragmentManager", "Op is being set to null");
                Log.d("FragmentManager", "OnBackPressedCallback enabled=" + onBackPressedCallback.isEnabled() + " for  FragmentManager " + fragmentManager);
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackProgressed(BackEventCompat backEvent) {
            boolean zO = FragmentManager.O(2);
            FragmentManager fragmentManager = FragmentManager.this;
            if (zO) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            if (fragmentManager.f4571h != null) {
                Iterator it = fragmentManager.g(new ArrayList(Collections.singletonList(fragmentManager.f4571h)), 0, 1).iterator();
                while (it.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
                    specialEffectsController.getClass();
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
                    }
                    ArrayList arrayList = specialEffectsController.f4692c;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.i(arrayList2, ((SpecialEffectsController.Operation) it2.next()).f4709k);
                    }
                    List listE0 = CollectionsKt.e0(CollectionsKt.h0(arrayList2));
                    int size = listE0.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((SpecialEffectsController.Effect) listE0.get(i2)).e(backEvent, specialEffectsController.f4690a);
                    }
                }
                Iterator it3 = fragmentManager.o.iterator();
                while (it3.hasNext()) {
                    ((OnBackStackChangedListener) it3.next()).getClass();
                }
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackStarted(BackEventCompat backEventCompat) {
            boolean zO = FragmentManager.O(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (zO) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            fragmentManager.x();
            fragmentManager.y(fragmentManager.new PrepareBackStackTransitionState(), false);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4574k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public final Map f4575l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final Map f4576m = Collections.synchronizedMap(new HashMap());
    public final Map n = Collections.synchronizedMap(new HashMap());
    public final ArrayList o = new ArrayList();
    public final FragmentLifecycleCallbacksDispatcher p = new FragmentLifecycleCallbacksDispatcher(this);
    public final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    public final MenuProvider v = new MenuProvider() { // from class: androidx.fragment.app.FragmentManager.2
        @Override // androidx.core.view.MenuProvider
        public final void a(Menu menu) {
            FragmentManager.this.r(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public final void b(Menu menu) {
            FragmentManager.this.u(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public final boolean c(MenuItem menuItem) {
            return FragmentManager.this.q(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public final void d(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.l(menu, menuInflater);
        }
    };
    public int w = -1;
    public final FragmentFactory B = new FragmentFactory() { // from class: androidx.fragment.app.FragmentManager.3
        @Override // androidx.fragment.app.FragmentFactory
        public final Fragment a(ClassLoader classLoader, String str) {
            return Fragment.instantiate(FragmentManager.this.x.f4555b, str, null);
        }
    };
    public final AnonymousClass4 C = new AnonymousClass4();
    public ArrayDeque G = new ArrayDeque();
    public final Runnable Q = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public final void run() {
            FragmentManager.this.A(true);
        }
    };

    /* renamed from: androidx.fragment.app.FragmentManager$4, reason: invalid class name */
    public class AnonymousClass4 implements SpecialEffectsControllerFactory {
        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        public final DefaultSpecialEffectsController a(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            return new DefaultSpecialEffectsController(container);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass6 implements LifecycleEventObserver {
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_DESTROY) {
                throw null;
            }
        }
    }

    public interface BackStackEntry {
    }

    /* loaded from: classes3.dex */
    public class ClearBackStackState implements OpGenerator {
        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            throw null;
        }
    }

    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequestA = (IntentSenderRequest) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = intentSenderRequestA.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(intentSenderRequestA.d());
                    builder.b(null);
                    builder.c(intentSenderRequestA.c(), intentSenderRequestA.b());
                    intentSenderRequestA = builder.a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequestA);
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            return new ActivityResult(intent, i2);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes3.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public String f4585a;

        /* renamed from: b, reason: collision with root package name */
        public int f4586b;

        /* renamed from: androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                LaunchedFragmentInfo launchedFragmentInfo = new LaunchedFragmentInfo();
                launchedFragmentInfo.f4585a = parcel.readString();
                launchedFragmentInfo.f4586b = parcel.readInt();
                return launchedFragmentInfo;
            }

            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        }

        public LaunchedFragmentInfo(String str, int i2) {
            this.f4585a = str;
            this.f4586b = i2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f4585a);
            parcel.writeInt(this.f4586b);
        }
    }

    /* loaded from: classes3.dex */
    public static class LifecycleAwareResultListener implements FragmentResultListener {
    }

    /* loaded from: classes3.dex */
    public interface OnBackStackChangedListener {
        void a();
    }

    public interface OpGenerator {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* loaded from: classes3.dex */
    public class PopBackStackState implements OpGenerator {

        /* renamed from: a, reason: collision with root package name */
        public final int f4587a;

        public PopBackStackState(int i2) {
            this.f4587a = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            FragmentManager fragmentManager = FragmentManager.this;
            Fragment fragment = fragmentManager.A;
            int i2 = this.f4587a;
            if (fragment == null || i2 >= 0 || !fragment.getChildFragmentManager().W(-1, 0)) {
                return fragmentManager.X(arrayList, arrayList2, i2, 1);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class PrepareBackStackTransitionState implements OpGenerator {
        public PrepareBackStackTransitionState() {
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            FragmentManager fragmentManager = FragmentManager.this;
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + fragmentManager.f4564a);
            }
            boolean zX = false;
            if (fragmentManager.f4567d.isEmpty()) {
                Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
            } else {
                BackStackRecord backStackRecord = (BackStackRecord) android.support.v4.media.b.c(1, fragmentManager.f4567d);
                fragmentManager.f4571h = backStackRecord;
                Iterator it = backStackRecord.f4643c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((FragmentTransaction.Op) it.next()).f4655b;
                    if (fragment != null) {
                        fragment.mTransitioning = true;
                    }
                }
                zX = fragmentManager.X(arrayList, arrayList2, -1, 0);
            }
            if (!fragmentManager.o.isEmpty() && arrayList.size() > 0) {
                ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
                LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.H((BackStackRecord) it2.next()));
                }
                Iterator it3 = fragmentManager.o.iterator();
                while (it3.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it3.next();
                    for (Fragment fragment2 : linkedHashSet) {
                        onBackStackChangedListener.getClass();
                    }
                }
            }
            return zX;
        }
    }

    /* loaded from: classes3.dex */
    public class RestoreBackStackState implements OpGenerator {
        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class SaveBackStackState implements OpGenerator {
        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            throw null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.fragment.app.i] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.i] */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.fragment.app.i] */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.fragment.app.i] */
    public FragmentManager() {
        final int i2 = 0;
        this.r = new Consumer(this) { // from class: androidx.fragment.app.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f4736b;

            {
                this.f4736b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f4736b;
                        if (fragmentManager.Q()) {
                            fragmentManager.j(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f4736b;
                        if (fragmentManager2.Q() && num.intValue() == 80) {
                            fragmentManager2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f4736b;
                        if (fragmentManager3.Q()) {
                            fragmentManager3.o(multiWindowModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f4736b;
                        if (fragmentManager4.Q()) {
                            fragmentManager4.t(pictureInPictureModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i3 = 1;
        this.s = new Consumer(this) { // from class: androidx.fragment.app.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f4736b;

            {
                this.f4736b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f4736b;
                        if (fragmentManager.Q()) {
                            fragmentManager.j(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f4736b;
                        if (fragmentManager2.Q() && num.intValue() == 80) {
                            fragmentManager2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f4736b;
                        if (fragmentManager3.Q()) {
                            fragmentManager3.o(multiWindowModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f4736b;
                        if (fragmentManager4.Q()) {
                            fragmentManager4.t(pictureInPictureModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i4 = 2;
        this.t = new Consumer(this) { // from class: androidx.fragment.app.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f4736b;

            {
                this.f4736b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f4736b;
                        if (fragmentManager.Q()) {
                            fragmentManager.j(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f4736b;
                        if (fragmentManager2.Q() && num.intValue() == 80) {
                            fragmentManager2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f4736b;
                        if (fragmentManager3.Q()) {
                            fragmentManager3.o(multiWindowModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f4736b;
                        if (fragmentManager4.Q()) {
                            fragmentManager4.t(pictureInPictureModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i5 = 3;
        this.u = new Consumer(this) { // from class: androidx.fragment.app.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f4736b;

            {
                this.f4736b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f4736b;
                        if (fragmentManager.Q()) {
                            fragmentManager.j(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f4736b;
                        if (fragmentManager2.Q() && num.intValue() == 80) {
                            fragmentManager2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f4736b;
                        if (fragmentManager3.Q()) {
                            fragmentManager3.o(multiWindowModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f4736b;
                        if (fragmentManager4.Q()) {
                            fragmentManager4.t(pictureInPictureModeChangedInfo.a(), false);
                            break;
                        }
                        break;
                }
            }
        };
    }

    public static Fragment F(View view) {
        while (view != null) {
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            Fragment fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                return fragment;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static HashSet H(BackStackRecord backStackRecord) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < backStackRecord.f4643c.size(); i2++) {
            Fragment fragment = ((FragmentTransaction.Op) backStackRecord.f4643c.get(i2)).f4655b;
            if (fragment != null && backStackRecord.f4649i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public static boolean O(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public static boolean P(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        Iterator it = fragment.mChildFragmentManager.f4566c.e().iterator();
        boolean zP = false;
        while (it.hasNext()) {
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                zP = P(fragment2);
            }
            if (zP) {
                return true;
            }
        }
        return false;
    }

    public static boolean R(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.A) && R(fragmentManager.z);
    }

    public static void j0(Fragment fragment) {
        if (O(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final boolean A(boolean z) {
        boolean zA;
        BackStackRecord backStackRecord;
        z(z);
        if (!this.f4572i && (backStackRecord = this.f4571h) != null) {
            backStackRecord.u = false;
            backStackRecord.n();
            if (O(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.f4571h + " as part of execPendingActions for actions " + this.f4564a);
            }
            this.f4571h.o(false, false);
            this.f4564a.add(0, this.f4571h);
            Iterator it = this.f4571h.f4643c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it.next()).f4655b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.f4571h = null;
        }
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.M;
            ArrayList arrayList2 = this.N;
            synchronized (this.f4564a) {
                if (this.f4564a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.f4564a.size();
                        zA = false;
                        for (int i2 = 0; i2 < size; i2++) {
                            zA |= ((OpGenerator) this.f4564a.get(i2)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.f4565b = true;
            try {
                b0(this.M, this.N);
                e();
                z2 = true;
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
        l0();
        if (this.L) {
            this.L = false;
            Iterator it2 = this.f4566c.d().iterator();
            while (it2.hasNext()) {
                FragmentStateManager fragmentStateManager = (FragmentStateManager) it2.next();
                Fragment fragment2 = fragmentStateManager.f4621c;
                if (fragment2.mDeferStart) {
                    if (this.f4565b) {
                        this.L = true;
                    } else {
                        fragment2.mDeferStart = false;
                        fragmentStateManager.k();
                    }
                }
            }
        }
        this.f4566c.f4634b.values().removeAll(Collections.singleton(null));
        return z2;
    }

    public final void B(BackStackRecord backStackRecord, boolean z) {
        if (z && (this.x == null || this.K)) {
            return;
        }
        z(z);
        BackStackRecord backStackRecord2 = this.f4571h;
        if (backStackRecord2 != null) {
            backStackRecord2.u = false;
            backStackRecord2.n();
            if (O(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.f4571h + " as part of execSingleAction for action " + backStackRecord);
            }
            this.f4571h.o(false, false);
            this.f4571h.a(this.M, this.N);
            Iterator it = this.f4571h.f4643c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it.next()).f4655b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.f4571h = null;
        }
        backStackRecord.a(this.M, this.N);
        this.f4565b = true;
        try {
            b0(this.M, this.N);
            e();
            l0();
            boolean z2 = this.L;
            FragmentStore fragmentStore = this.f4566c;
            if (z2) {
                this.L = false;
                Iterator it2 = fragmentStore.d().iterator();
                while (it2.hasNext()) {
                    FragmentStateManager fragmentStateManager = (FragmentStateManager) it2.next();
                    Fragment fragment2 = fragmentStateManager.f4621c;
                    if (fragment2.mDeferStart) {
                        if (this.f4565b) {
                            this.L = true;
                        } else {
                            fragment2.mDeferStart = false;
                            fragmentStateManager.k();
                        }
                    }
                }
            }
            fragmentStore.f4634b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            e();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x021a A[PHI: r14
      0x021a: PHI (r14v9 int) = (r14v8 int), (r14v10 int) binds: [B:103:0x020a, B:108:0x0216] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(java.util.ArrayList r26, java.util.ArrayList r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.C(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final Fragment D(int i2) {
        FragmentStore fragmentStore = this.f4566c;
        ArrayList arrayList = fragmentStore.f4633a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : fragmentStore.f4634b.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.f4621c;
                if (fragment2.mFragmentId == i2) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment E(String str) {
        FragmentStore fragmentStore = this.f4566c;
        if (str != null) {
            ArrayList arrayList = fragmentStore.f4633a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            fragmentStore.getClass();
            return null;
        }
        for (FragmentStateManager fragmentStateManager : fragmentStore.f4634b.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.f4621c;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final void G() {
        Iterator it = f().iterator();
        while (it.hasNext()) {
            SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
            if (specialEffectsController.f4695f) {
                if (O(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                specialEffectsController.f4695f = false;
                specialEffectsController.i();
            }
        }
    }

    public final Fragment I(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentB = this.f4566c.b(string);
        if (fragmentB != null) {
            return fragmentB;
        }
        k0(new IllegalStateException(e.p("Fragment no longer exists for key ", str, ": unique id ", string)));
        throw null;
    }

    public final ViewGroup J(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.y.c()) {
            return null;
        }
        View viewB = this.y.b(fragment.mContainerId);
        if (viewB instanceof ViewGroup) {
            return (ViewGroup) viewB;
        }
        return null;
    }

    public final FragmentFactory K() {
        Fragment fragment = this.z;
        return fragment != null ? fragment.mFragmentManager.K() : this.B;
    }

    public final List L() {
        return this.f4566c.f();
    }

    public final SpecialEffectsControllerFactory M() {
        Fragment fragment = this.z;
        return fragment != null ? fragment.mFragmentManager.M() : this.C;
    }

    public final void N(Fragment fragment) {
        if (O(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        i0(fragment);
    }

    public final boolean Q() {
        Fragment fragment = this.z;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.z.getParentFragmentManager().Q();
    }

    public final boolean S() {
        return this.I || this.J;
    }

    public final void T(int i2, boolean z) {
        HashMap map;
        FragmentHostCallback fragmentHostCallback;
        if (this.x == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.w) {
            this.w = i2;
            FragmentStore fragmentStore = this.f4566c;
            Iterator it = fragmentStore.f4633a.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = fragmentStore.f4634b;
                if (!zHasNext) {
                    break;
                }
                FragmentStateManager fragmentStateManager = (FragmentStateManager) map.get(((Fragment) it.next()).mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.k();
                }
            }
            for (FragmentStateManager fragmentStateManager2 : map.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.k();
                    Fragment fragment = fragmentStateManager2.f4621c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        if (fragment.mBeingSaved && !fragmentStore.f4635c.containsKey(fragment.mWho)) {
                            fragmentStore.i(fragmentStateManager2.n(), fragment.mWho);
                        }
                        fragmentStore.h(fragmentStateManager2);
                    }
                }
            }
            Iterator it2 = fragmentStore.d().iterator();
            while (it2.hasNext()) {
                FragmentStateManager fragmentStateManager3 = (FragmentStateManager) it2.next();
                Fragment fragment2 = fragmentStateManager3.f4621c;
                if (fragment2.mDeferStart) {
                    if (this.f4565b) {
                        this.L = true;
                    } else {
                        fragment2.mDeferStart = false;
                        fragmentStateManager3.k();
                    }
                }
            }
            if (this.H && (fragmentHostCallback = this.x) != null && this.w == 7) {
                fragmentHostCallback.h();
                this.H = false;
            }
        }
    }

    public final void U() {
        if (this.x == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.f4604g = false;
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean V() {
        return W(-1, 0);
    }

    public final boolean W(int i2, int i3) {
        A(false);
        z(true);
        Fragment fragment = this.A;
        if (fragment != null && i2 < 0 && fragment.getChildFragmentManager().V()) {
            return true;
        }
        boolean zX = X(this.M, this.N, i2, i3);
        if (zX) {
            this.f4565b = true;
            try {
                b0(this.M, this.N);
            } finally {
                e();
            }
        }
        l0();
        boolean z = this.L;
        FragmentStore fragmentStore = this.f4566c;
        if (z) {
            this.L = false;
            Iterator it = fragmentStore.d().iterator();
            while (it.hasNext()) {
                FragmentStateManager fragmentStateManager = (FragmentStateManager) it.next();
                Fragment fragment2 = fragmentStateManager.f4621c;
                if (fragment2.mDeferStart) {
                    if (this.f4565b) {
                        this.L = true;
                    } else {
                        fragment2.mDeferStart = false;
                        fragmentStateManager.k();
                    }
                }
            }
        }
        fragmentStore.f4634b.values().removeAll(Collections.singleton(null));
        return zX;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X(java.util.ArrayList r5, java.util.ArrayList r6, int r7, int r8) {
        /*
            r4 = this;
            r0 = 1
            r8 = r8 & r0
            r1 = 0
            if (r8 == 0) goto L7
            r8 = r0
            goto L8
        L7:
            r8 = r1
        L8:
            java.util.ArrayList r2 = r4.f4567d
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L11
            goto L5e
        L11:
            if (r7 >= 0) goto L1f
            if (r8 == 0) goto L17
            r7 = r1
            goto L62
        L17:
            java.util.ArrayList r7 = r4.f4567d
            int r7 = r7.size()
            int r7 = r7 - r0
            goto L62
        L1f:
            java.util.ArrayList r2 = r4.f4567d
            int r2 = r2.size()
            int r2 = r2 - r0
        L26:
            if (r2 < 0) goto L3a
            java.util.ArrayList r3 = r4.f4567d
            java.lang.Object r3 = r3.get(r2)
            androidx.fragment.app.BackStackRecord r3 = (androidx.fragment.app.BackStackRecord) r3
            if (r7 < 0) goto L37
            int r3 = r3.v
            if (r7 != r3) goto L37
            goto L3a
        L37:
            int r2 = r2 + (-1)
            goto L26
        L3a:
            if (r2 >= 0) goto L3e
        L3c:
            r7 = r2
            goto L62
        L3e:
            if (r8 == 0) goto L55
        L40:
            if (r2 <= 0) goto L3c
            java.util.ArrayList r8 = r4.f4567d
            int r3 = r2 + (-1)
            java.lang.Object r8 = r8.get(r3)
            androidx.fragment.app.BackStackRecord r8 = (androidx.fragment.app.BackStackRecord) r8
            if (r7 < 0) goto L3c
            int r8 = r8.v
            if (r7 != r8) goto L3c
            int r2 = r2 + (-1)
            goto L40
        L55:
            java.util.ArrayList r7 = r4.f4567d
            int r7 = r7.size()
            int r7 = r7 - r0
            if (r2 != r7) goto L60
        L5e:
            r7 = -1
            goto L62
        L60:
            int r7 = r2 + 1
        L62:
            if (r7 >= 0) goto L65
            return r1
        L65:
            java.util.ArrayList r8 = r4.f4567d
            int r8 = r8.size()
            int r8 = r8 - r0
        L6c:
            if (r8 < r7) goto L81
            java.util.ArrayList r1 = r4.f4567d
            java.lang.Object r1 = r1.remove(r8)
            androidx.fragment.app.BackStackRecord r1 = (androidx.fragment.app.BackStackRecord) r1
            r5.add(r1)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.add(r1)
            int r8 = r8 + (-1)
            goto L6c
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.X(java.util.ArrayList, java.util.ArrayList, int, int):boolean");
    }

    public final void Y(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            k0(new IllegalStateException(e.o("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void Z(FragmentLifecycleCallbacks cb) {
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.p;
        fragmentLifecycleCallbacksDispatcher.getClass();
        Intrinsics.checkNotNullParameter(cb, "cb");
        fragmentLifecycleCallbacksDispatcher.f4562b.add(new FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder(cb));
    }

    public final FragmentStateManager a(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.c(fragment, str);
        }
        if (O(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager fragmentStateManagerH = h(fragment);
        fragment.mFragmentManager = this;
        FragmentStore fragmentStore = this.f4566c;
        fragmentStore.g(fragmentStateManagerH);
        if (!fragment.mDetached) {
            fragmentStore.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (P(fragment)) {
                this.H = true;
            }
        }
        return fragmentStateManagerH;
    }

    public final void a0(Fragment fragment) {
        if (O(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        FragmentStore fragmentStore = this.f4566c;
        synchronized (fragmentStore.f4633a) {
            fragmentStore.f4633a.remove(fragment);
        }
        fragment.mAdded = false;
        if (P(fragment)) {
            this.H = true;
        }
        fragment.mRemoving = true;
        i0(fragment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        if (this.x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.x = fragmentHostCallback;
        this.y = fragmentContainer;
        this.z = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.q;
        if (fragment != null) {
            copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                @Override // androidx.fragment.app.FragmentOnAttachListener
                public final void a(Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
            copyOnWriteArrayList.add((FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.z != null) {
            l0();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.f4570g = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.a(lifecycleOwner, this.f4573j);
        }
        if (fragment != null) {
            FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.P;
            HashMap map = fragmentManagerViewModel.f4600c;
            FragmentManagerViewModel fragmentManagerViewModel2 = (FragmentManagerViewModel) map.get(fragment.mWho);
            if (fragmentManagerViewModel2 == null) {
                fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.f4602e);
                map.put(fragment.mWho, fragmentManagerViewModel2);
            }
            this.P = fragmentManagerViewModel2;
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore(), FragmentManagerViewModel.f4598h);
            Intrinsics.checkNotNullParameter(FragmentManagerViewModel.class, "modelClass");
            Intrinsics.checkNotNullParameter(FragmentManagerViewModel.class, "<this>");
            this.P = (FragmentManagerViewModel) viewModelProvider.a(Reflection.a(FragmentManagerViewModel.class));
        } else {
            this.P = new FragmentManagerViewModel(false);
        }
        this.P.f4604g = S();
        this.f4566c.f4636d = this.P;
        Object obj = this.x;
        if ((obj instanceof SavedStateRegistryOwner) && fragment == null) {
            SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new f(this, 1));
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                c0(bundleA);
            }
        }
        Object obj2 = this.x;
        if (obj2 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) obj2).getActivityResultRegistry();
            String strC = android.support.v4.media.b.C("FragmentManager:", fragment != null ? android.support.v4.media.b.r(new StringBuilder(), fragment.mWho, ":") : "");
            this.D = activityResultRegistry.e(android.support.v4.media.b.k(strC, "StartActivityForResult"), new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.8
                @Override // androidx.activity.result.ActivityResultCallback
                public final void b(Object obj3) {
                    ActivityResult activityResult = (ActivityResult) obj3;
                    FragmentManager fragmentManager = FragmentManager.this;
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.G.pollLast();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No Activities were started for result for " + this);
                        return;
                    }
                    FragmentStore fragmentStore = fragmentManager.f4566c;
                    String str = launchedFragmentInfo.f4585a;
                    Fragment fragmentC = fragmentStore.c(str);
                    if (fragmentC == null) {
                        android.support.v4.media.b.A("Activity result delivered for unknown Fragment ", str, "FragmentManager");
                    } else {
                        fragmentC.onActivityResult(launchedFragmentInfo.f4586b, activityResult.f198a, activityResult.f199b);
                    }
                }
            });
            this.E = activityResultRegistry.e(android.support.v4.media.b.k(strC, "StartIntentSenderForResult"), new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.9
                @Override // androidx.activity.result.ActivityResultCallback
                public final void b(Object obj3) {
                    ActivityResult activityResult = (ActivityResult) obj3;
                    FragmentManager fragmentManager = FragmentManager.this;
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.G.pollFirst();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No IntentSenders were started for " + this);
                        return;
                    }
                    FragmentStore fragmentStore = fragmentManager.f4566c;
                    String str = launchedFragmentInfo.f4585a;
                    Fragment fragmentC = fragmentStore.c(str);
                    if (fragmentC == null) {
                        android.support.v4.media.b.A("Intent Sender result delivered for unknown Fragment ", str, "FragmentManager");
                    } else {
                        fragmentC.onActivityResult(launchedFragmentInfo.f4586b, activityResult.f198a, activityResult.f199b);
                    }
                }
            });
            this.F = activityResultRegistry.e(android.support.v4.media.b.k(strC, "RequestPermissions"), new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.10
                @Override // androidx.activity.result.ActivityResultCallback
                public final void b(Object obj3) {
                    Map map2 = (Map) obj3;
                    String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map2.values());
                    int[] iArr = new int[arrayList.size()];
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                    }
                    FragmentManager fragmentManager = FragmentManager.this;
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.G.pollFirst();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No permissions were requested for " + this);
                        return;
                    }
                    FragmentStore fragmentStore = fragmentManager.f4566c;
                    String str = launchedFragmentInfo.f4585a;
                    Fragment fragmentC = fragmentStore.c(str);
                    if (fragmentC == null) {
                        android.support.v4.media.b.A("Permission request result delivered for unknown Fragment ", str, "FragmentManager");
                    } else {
                        fragmentC.onRequestPermissionsResult(launchedFragmentInfo.f4586b, strArr, iArr);
                    }
                }
            });
        }
        Object obj3 = this.x;
        if (obj3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj3).addOnConfigurationChangedListener(this.r);
        }
        Object obj4 = this.x;
        if (obj4 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj4).addOnTrimMemoryListener(this.s);
        }
        Object obj5 = this.x;
        if (obj5 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj5).addOnMultiWindowModeChangedListener(this.t);
        }
        Object obj6 = this.x;
        if (obj6 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj6).addOnPictureInPictureModeChangedListener(this.u);
        }
        Object obj7 = this.x;
        if ((obj7 instanceof MenuHost) && fragment == null) {
            ((MenuHost) obj7).addMenuProvider(this.v);
        }
    }

    public final void b0(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((BackStackRecord) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    C(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((BackStackRecord) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                C(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            C(arrayList, arrayList2, i3, size);
        }
    }

    public final void c(Fragment fragment) {
        if (O(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f4566c.a(fragment);
            if (O(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (P(fragment)) {
                this.H = true;
            }
        }
    }

    public final void c0(Bundle bundle) {
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher;
        FragmentStateManager fragmentStateManager;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.x.f4555b.getClassLoader());
                this.f4576m.put(str.substring(7), bundle3);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.x.f4555b.getClassLoader());
                map.put(str2.substring(9), bundle2);
            }
        }
        FragmentStore fragmentStore = this.f4566c;
        HashMap map2 = fragmentStore.f4635c;
        map2.clear();
        map2.putAll(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        HashMap map3 = fragmentStore.f4634b;
        map3.clear();
        Iterator it = fragmentManagerState.f4590a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            fragmentLifecycleCallbacksDispatcher = this.p;
            if (!zHasNext) {
                break;
            }
            Bundle bundleI = fragmentStore.i(null, (String) it.next());
            if (bundleI != null) {
                Fragment fragment = (Fragment) this.P.f4599b.get(((FragmentState) bundleI.getParcelable("state")).f4607b);
                if (fragment != null) {
                    if (O(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    fragmentStateManager = new FragmentStateManager(fragmentLifecycleCallbacksDispatcher, fragmentStore, fragment, bundleI);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.p, this.f4566c, this.x.f4555b.getClassLoader(), K(), bundleI);
                }
                Fragment fragment2 = fragmentStateManager.f4621c;
                fragment2.mSavedFragmentState = bundleI;
                fragment2.mFragmentManager = this;
                if (O(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                fragmentStateManager.l(this.x.f4555b.getClassLoader());
                fragmentStore.g(fragmentStateManager);
                fragmentStateManager.f4623e = this.w;
            }
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.P;
        fragmentManagerViewModel.getClass();
        Iterator it2 = new ArrayList(fragmentManagerViewModel.f4599b.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (map3.get(fragment3.mWho) == null) {
                if (O(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.f4590a);
                }
                this.P.i(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(fragmentLifecycleCallbacksDispatcher, fragmentStore, fragment3);
                fragmentStateManager2.f4623e = 1;
                fragmentStateManager2.k();
                fragment3.mRemoving = true;
                fragmentStateManager2.k();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.f4591b;
        fragmentStore.f4633a.clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                Fragment fragmentB = fragmentStore.b(str3);
                if (fragmentB == null) {
                    throw new IllegalStateException(android.support.v4.media.b.D("No instantiated fragment for (", str3, ")"));
                }
                if (O(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + fragmentB);
                }
                fragmentStore.a(fragmentB);
            }
        }
        if (fragmentManagerState.f4592c != null) {
            this.f4567d = new ArrayList(fragmentManagerState.f4592c.length);
            int i2 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f4592c;
                if (i2 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecord backStackRecordA = backStackRecordStateArr[i2].a(this);
                if (O(2)) {
                    StringBuilder sbU = android.support.v4.media.b.u(i2, "restoreAllState: back stack #", " (index ");
                    sbU.append(backStackRecordA.v);
                    sbU.append("): ");
                    sbU.append(backStackRecordA);
                    Log.v("FragmentManager", sbU.toString());
                    PrintWriter printWriter = new PrintWriter(new LogWriter());
                    backStackRecordA.p("  ", printWriter, false);
                    printWriter.close();
                }
                this.f4567d.add(backStackRecordA);
                i2++;
            }
        } else {
            this.f4567d = new ArrayList();
        }
        this.f4574k.set(fragmentManagerState.f4593d);
        String str4 = fragmentManagerState.f4594e;
        if (str4 != null) {
            Fragment fragmentB2 = fragmentStore.b(str4);
            this.A = fragmentB2;
            s(fragmentB2);
        }
        ArrayList arrayList2 = fragmentManagerState.f4595f;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.f4575l.put((String) arrayList2.get(i3), (BackStackState) fragmentManagerState.f4596g.get(i3));
            }
        }
        this.G = new ArrayDeque(fragmentManagerState.f4597h);
    }

    public final FragmentTransaction d() {
        return new BackStackRecord(this);
    }

    public final Bundle d0() {
        BackStackRecordState[] backStackRecordStateArr;
        ArrayList arrayList;
        Bundle bundle = new Bundle();
        G();
        x();
        A(true);
        this.I = true;
        this.P.f4604g = true;
        FragmentStore fragmentStore = this.f4566c;
        fragmentStore.getClass();
        HashMap map = fragmentStore.f4634b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (FragmentStateManager fragmentStateManager : map.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.f4621c;
                fragmentStore.i(fragmentStateManager.n(), fragment.mWho);
                arrayList2.add(fragment.mWho);
                if (O(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.mSavedFragmentState);
                }
            }
        }
        HashMap map2 = this.f4566c.f4635c;
        if (!map2.isEmpty()) {
            FragmentStore fragmentStore2 = this.f4566c;
            synchronized (fragmentStore2.f4633a) {
                try {
                    backStackRecordStateArr = null;
                    if (fragmentStore2.f4633a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(fragmentStore2.f4633a.size());
                        Iterator it = fragmentStore2.f4633a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment2 = (Fragment) it.next();
                            arrayList.add(fragment2.mWho);
                            if (O(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                            }
                        }
                    }
                } finally {
                }
            }
            int size = this.f4567d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackRecordStateArr[i2] = new BackStackRecordState((BackStackRecord) this.f4567d.get(i2));
                    if (O(2)) {
                        StringBuilder sbU = android.support.v4.media.b.u(i2, "saveAllState: adding back stack #", ": ");
                        sbU.append(this.f4567d.get(i2));
                        Log.v("FragmentManager", sbU.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f4590a = arrayList2;
            fragmentManagerState.f4591b = arrayList;
            fragmentManagerState.f4592c = backStackRecordStateArr;
            fragmentManagerState.f4593d = this.f4574k.get();
            Fragment fragment3 = this.A;
            if (fragment3 != null) {
                fragmentManagerState.f4594e = fragment3.mWho;
            }
            fragmentManagerState.f4595f.addAll(this.f4575l.keySet());
            fragmentManagerState.f4596g.addAll(this.f4575l.values());
            fragmentManagerState.f4597h = new ArrayList(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f4576m.keySet()) {
                bundle.putBundle(android.support.v4.media.b.C("result_", str), (Bundle) this.f4576m.get(str));
            }
            for (String str2 : map2.keySet()) {
                bundle.putBundle(android.support.v4.media.b.C("fragment_", str2), (Bundle) map2.get(str2));
            }
        } else if (O(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void e() {
        this.f4565b = false;
        this.N.clear();
        this.M.clear();
    }

    public final void e0() {
        synchronized (this.f4564a) {
            try {
                if (this.f4564a.size() == 1) {
                    this.x.f4556c.removeCallbacks(this.Q);
                    this.x.f4556c.post(this.Q);
                    l0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f4566c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((FragmentStateManager) it.next()).f4621c.mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.Companion.a(viewGroup, M()));
            }
        }
        return hashSet;
    }

    public final void f0(Fragment fragment, boolean z) {
        ViewGroup viewGroupJ = J(fragment);
        if (viewGroupJ == null || !(viewGroupJ instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupJ).setDrawDisappearingViewsLast(!z);
    }

    public final HashSet g(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((BackStackRecord) arrayList.get(i2)).f4643c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it.next()).f4655b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.m(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public final void g0(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.f4566c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final FragmentStateManager h(Fragment fragment) {
        String str = fragment.mWho;
        FragmentStore fragmentStore = this.f4566c;
        FragmentStateManager fragmentStateManager = (FragmentStateManager) fragmentStore.f4634b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.p, fragmentStore, fragment);
        fragmentStateManager2.l(this.x.f4555b.getClassLoader());
        fragmentStateManager2.f4623e = this.w;
        return fragmentStateManager2;
    }

    public final void h0(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f4566c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.A;
        this.A = fragment;
        s(fragment2);
        s(this.A);
    }

    public final void i(Fragment fragment) {
        if (O(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (O(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            FragmentStore fragmentStore = this.f4566c;
            synchronized (fragmentStore.f4633a) {
                fragmentStore.f4633a.remove(fragment);
            }
            fragment.mAdded = false;
            if (P(fragment)) {
                this.H = true;
            }
            i0(fragment);
        }
    }

    public final void i0(Fragment fragment) {
        ViewGroup viewGroupJ = J(fragment);
        if (viewGroupJ != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (viewGroupJ.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupJ.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) viewGroupJ.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void j(boolean z, Configuration configuration) {
        if (z && (this.x instanceof OnConfigurationChangedProvider)) {
            k0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.j(true, configuration);
                }
            }
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void k0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentHostCallback fragmentHostCallback = this.x;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.d(printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            w("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    public final boolean l(Menu menu, MenuInflater menuInflater) {
        if (this.w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f4568e != null) {
            for (int i2 = 0; i2 < this.f4568e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.f4568e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f4568e = arrayList;
        return z;
    }

    public final void l0() {
        synchronized (this.f4564a) {
            try {
                if (!this.f4564a.isEmpty()) {
                    this.f4573j.setEnabled(true);
                    if (O(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z = this.f4567d.size() + (this.f4571h != null ? 1 : 0) > 0 && R(this.z);
                if (O(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.f4573j.setEnabled(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m() {
        boolean zIsChangingConfigurations = true;
        this.K = true;
        A(true);
        x();
        FragmentHostCallback fragmentHostCallback = this.x;
        boolean z = fragmentHostCallback instanceof ViewModelStoreOwner;
        FragmentStore fragmentStore = this.f4566c;
        if (z) {
            zIsChangingConfigurations = fragmentStore.f4636d.f4603f;
        } else {
            FragmentActivity fragmentActivity = fragmentHostCallback.f4555b;
            if (fragmentActivity != null) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it = this.f4575l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f4461a.iterator();
                while (it2.hasNext()) {
                    fragmentStore.f4636d.g((String) it2.next(), false);
                }
            }
        }
        v(-1);
        Object obj = this.x;
        if (obj instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj).removeOnTrimMemoryListener(this.s);
        }
        Object obj2 = this.x;
        if (obj2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj2).removeOnConfigurationChangedListener(this.r);
        }
        Object obj3 = this.x;
        if (obj3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj3).removeOnMultiWindowModeChangedListener(this.t);
        }
        Object obj4 = this.x;
        if (obj4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj4).removeOnPictureInPictureModeChangedListener(this.u);
        }
        Object obj5 = this.x;
        if ((obj5 instanceof MenuHost) && this.z == null) {
            ((MenuHost) obj5).removeMenuProvider(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if (this.f4570g != null) {
            this.f4573j.remove();
            this.f4570g = null;
        }
        ActivityResultRegistry$register$3 activityResultRegistry$register$3 = this.D;
        if (activityResultRegistry$register$3 != null) {
            activityResultRegistry$register$3.b();
            this.E.b();
            this.F.b();
        }
    }

    public final void n(boolean z) {
        if (z && (this.x instanceof OnTrimMemoryProvider)) {
            k0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.n(true);
                }
            }
        }
    }

    public final void o(boolean z, boolean z2) {
        if (z2 && (this.x instanceof OnMultiWindowModeChangedProvider)) {
            k0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.o(z, true);
                }
            }
        }
    }

    public final void p() {
        Iterator it = this.f4566c.e().iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.p();
            }
        }
    }

    public final boolean q(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void r(Menu menu) {
        if (this.w < 1) {
            return;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void s(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f4566c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void t(boolean z, boolean z2) {
        if (z2 && (this.x instanceof OnPictureInPictureModeChangedProvider)) {
            k0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.t(z, true);
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.z;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.z)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.x;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final boolean u(Menu menu) {
        boolean z = false;
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.f4566c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void v(int i2) {
        try {
            this.f4565b = true;
            for (FragmentStateManager fragmentStateManager : this.f4566c.f4634b.values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.f4623e = i2;
                }
            }
            T(i2, false);
            Iterator it = f().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).l();
            }
            this.f4565b = false;
            A(true);
        } catch (Throwable th) {
            this.f4565b = false;
            throw th;
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String strK = android.support.v4.media.b.k(str, "    ");
        FragmentStore fragmentStore = this.f4566c;
        fragmentStore.getClass();
        String str2 = str + "    ";
        HashMap map = fragmentStore.f4634b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : map.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.f4621c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = fragmentStore.f4633a;
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment2 = (Fragment) arrayList.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.f4568e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment3 = (Fragment) this.f4568e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        int size3 = this.f4567d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.f4567d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.p(strK, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f4574k.get());
        synchronized (this.f4564a) {
            try {
                int size4 = this.f4564a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        Object obj = (OpGenerator) this.f4564a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.y);
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public final void x() {
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).l();
        }
    }

    public final void y(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.x == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (S()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f4564a) {
            try {
                if (this.x == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f4564a.add(opGenerator);
                    e0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(boolean z) {
        if (this.f4565b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.x == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.x.f4556c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && S()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }
}
