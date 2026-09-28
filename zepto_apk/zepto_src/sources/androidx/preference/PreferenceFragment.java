package androidx.preference;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
/* loaded from: classes3.dex */
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    /* renamed from: b, reason: collision with root package name */
    public PreferenceManager f11104b;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f11105c;

    /* renamed from: d, reason: collision with root package name */
    public ContextThemeWrapper f11106d;

    /* renamed from: a, reason: collision with root package name */
    public final DividerDecoration f11103a = new DividerDecoration();

    /* renamed from: e, reason: collision with root package name */
    public int f11107e = R.layout.preference_list_fragment;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f11108f = new Handler() { // from class: androidx.preference.PreferenceFragment.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragment.this.f11104b.getClass();
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f11109g = new Runnable() { // from class: androidx.preference.PreferenceFragment.2
        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = PreferenceFragment.this.f11105c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };

    /* renamed from: androidx.preference.PreferenceFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public class DividerDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f11112a;

        /* renamed from: b, reason: collision with root package name */
        public int f11113b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11114c = true;

        public DividerDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void f(Rect rect, View view, RecyclerView recyclerView) {
            if (i(view, recyclerView)) {
                rect.bottom = this.f11113b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void h(Canvas canvas, RecyclerView recyclerView) {
            if (this.f11112a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (i(childAt, recyclerView)) {
                    int height = childAt.getHeight() + ((int) childAt.getY());
                    this.f11112a.setBounds(0, height, width, this.f11113b + height);
                    this.f11112a.draw(canvas);
                }
            }
        }

        public final boolean i(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder viewHolderM = recyclerView.M(view);
            if (!(viewHolderM instanceof PreferenceViewHolder) || !((PreferenceViewHolder) viewHolderM).w) {
                return false;
            }
            boolean z = this.f11114c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.ViewHolder viewHolderM2 = recyclerView.M(recyclerView.getChildAt(iIndexOfChild + 1));
            return (viewHolderM2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) viewHolderM2).v;
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
    }

    public interface OnPreferenceStartFragmentCallback {
    }

    public interface OnPreferenceStartScreenCallback {
    }

    public static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void a() {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void b() {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void c(int i2, int i3, Object obj) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void d(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void e(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void f(int i2, int i3) {
            throw null;
        }
    }

    public abstract void a();

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i2);
        this.f11106d = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
        this.f11104b = preferenceManager;
        preferenceManager.f11129c = this;
        if (getArguments() != null) {
            getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        }
        a();
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        ContextThemeWrapper contextThemeWrapper = this.f11106d;
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(null, R.styleable.PreferenceFragment, TypedArrayUtils.a(contextThemeWrapper, R.attr.preferenceFragmentStyle, android.R.attr.preferenceFragmentStyle), 0);
        this.f11107e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PreferenceFragment_android_layout, this.f11107e);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.PreferenceFragment_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragment_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PreferenceFragment_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.f11106d);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f11107e, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        if (!this.f11106d.getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup2.findViewById(R.id.recycler_view)) == null) {
            recyclerView = (RecyclerView) layoutInflaterCloneInContext.inflate(R.layout.preference_recyclerview, viewGroup2, false);
            getActivity();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView));
        }
        this.f11105c = recyclerView;
        DividerDecoration dividerDecoration = this.f11103a;
        recyclerView.i(dividerDecoration);
        if (drawable != null) {
            dividerDecoration.getClass();
            dividerDecoration.f11113b = drawable.getIntrinsicHeight();
        } else {
            dividerDecoration.f11113b = 0;
        }
        dividerDecoration.f11112a = drawable;
        PreferenceFragment preferenceFragment = PreferenceFragment.this;
        preferenceFragment.f11105c.R();
        if (dimensionPixelSize != -1) {
            dividerDecoration.f11113b = dimensionPixelSize;
            preferenceFragment.f11105c.R();
        }
        dividerDecoration.f11114c = z;
        if (this.f11105c.getParent() == null) {
            viewGroup2.addView(this.f11105c);
        }
        this.f11108f.post(this.f11109g);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        Handler handler = this.f11108f;
        handler.removeCallbacks(this.f11109g);
        handler.removeMessages(1);
        this.f11105c = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f11104b.getClass();
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        PreferenceManager preferenceManager = this.f11104b;
        preferenceManager.f11127a = this;
        preferenceManager.f11128b = this;
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        PreferenceManager preferenceManager = this.f11104b;
        preferenceManager.f11127a = null;
        preferenceManager.f11128b = null;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null || bundle.getBundle("android:preferences") == null) {
            return;
        }
        this.f11104b.getClass();
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    public final void s() {
    }
}
