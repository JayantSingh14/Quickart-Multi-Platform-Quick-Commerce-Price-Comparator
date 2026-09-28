package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.RequiresOptIn;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements LifecycleEventObserver {
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            throw null;
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$2, reason: invalid class name */
    class AnonymousClass2 extends FragmentManager.FragmentLifecycleCallbacks {
        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            throw null;
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$4, reason: invalid class name */
    class AnonymousClass4 implements LifecycleEventObserver {
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                throw null;
            }
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void b() {
            a();
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void c(int i2, int i3, Object obj) {
            a();
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void d(int i2, int i3) {
            a();
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void e(int i2, int i3) {
            a();
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void f(int i2, int i3) {
            a();
            throw null;
        }
    }

    @RequiresOptIn
    public @interface ExperimentalFragmentStateAdapterApi {
    }

    public static class FragmentEventDispatcher {
    }

    public class FragmentMaxLifecycleEnforcer {

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1, reason: invalid class name */
        class AnonymousClass1 extends ViewPager2.OnPageChangeCallback {
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void a(int i2) {
                throw null;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void c(int i2) {
                throw null;
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2, reason: invalid class name */
        class AnonymousClass2 extends DataSetChangeObserver {
            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void a() {
                throw null;
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3, reason: invalid class name */
        class AnonymousClass3 implements LifecycleEventObserver {
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                throw null;
            }
        }
    }

    public static abstract class FragmentTransactionCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final OnPostEventListener f12373a = null;

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentTransactionCallback$1, reason: invalid class name */
        public class AnonymousClass1 implements OnPostEventListener {
        }

        public interface OnPostEventListener {
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable a() {
        throw null;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void b() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long e(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void n(RecyclerView recyclerView) {
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        ((FrameLayout) ((FragmentViewHolder) viewHolder).f11653a).getId();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
        int i3 = FragmentViewHolder.u;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void q(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            ((ViewPager2) parent).f(null);
            throw null;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ boolean r(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void s(RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void u(RecyclerView.ViewHolder viewHolder) {
        ((FrameLayout) ((FragmentViewHolder) viewHolder).f11653a).getId();
        throw null;
    }
}
