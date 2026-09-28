package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a, reason: collision with root package name */
    public final ActivityChooserViewAdapter f748a;

    /* renamed from: b, reason: collision with root package name */
    public final Callbacks f749b;

    /* renamed from: c, reason: collision with root package name */
    public final View f750c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f751d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f752e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f753f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f754g;

    /* renamed from: h, reason: collision with root package name */
    public final int f755h;

    /* renamed from: i, reason: collision with root package name */
    public ActionProvider f756i;

    /* renamed from: j, reason: collision with root package name */
    public final DataSetObserver f757j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f758k;

    /* renamed from: l, reason: collision with root package name */
    public ListPopupWindow f759l;

    /* renamed from: m, reason: collision with root package name */
    public PopupWindow.OnDismissListener f760m;
    public boolean n;
    public int o;
    public boolean p;

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$3, reason: invalid class name */
    public class AnonymousClass3 extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCanOpenPopup(true);
        }
    }

    public class ActivityChooserViewAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public ActivityChooserModel f765a;

        /* renamed from: b, reason: collision with root package name */
        public int f766b = 4;

        /* renamed from: c, reason: collision with root package name */
        public boolean f767c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f768d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f769e;

        public ActivityChooserViewAdapter() {
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            int iC = this.f765a.c();
            if (!this.f767c) {
                this.f765a.d();
            }
            int iMin = Math.min(iC, this.f766b);
            return this.f769e ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f767c) {
                this.f765a.d();
            }
            ActivityChooserModel activityChooserModel = this.f765a;
            synchronized (activityChooserModel.f738a) {
                activityChooserModel.a();
                throw null;
            }
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getItemViewType(int i2) {
            return (this.f769e && i2 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                activityChooserView.getContext().getPackageManager();
                getItem(i2);
                throw null;
            }
            if (itemViewType != 1) {
                throw new IllegalArgumentException();
            }
            if (view != null && view.getId() == 1) {
                return view;
            }
            View viewInflate = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            viewInflate.setId(1);
            ((TextView) viewInflate.findViewById(R.id.title)).setText(activityChooserView.getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return viewInflate;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getViewTypeCount() {
            return 3;
        }
    }

    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public Callbacks() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f754g) {
                if (view != activityChooserView.f752e) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.n = false;
                activityChooserView.c(activityChooserView.o);
                return;
            }
            activityChooserView.a();
            ActivityChooserView.this.f748a.f765a.d();
            ActivityChooserModel activityChooserModel = ActivityChooserView.this.f748a.f765a;
            synchronized (activityChooserModel.f738a) {
                activityChooserModel.a();
                ArrayList arrayList = activityChooserModel.f739b;
                if (arrayList.size() > 0) {
                    throw null;
                }
            }
            synchronized (ActivityChooserView.this.f748a.f765a.f738a) {
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            ActionProvider.SubUiVisibilityListener subUiVisibilityListener;
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            PopupWindow.OnDismissListener onDismissListener = activityChooserView.f760m;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
            ActionProvider actionProvider = activityChooserView.f756i;
            if (actionProvider == null || (subUiVisibilityListener = actionProvider.f3016a) == null) {
                return;
            }
            ((ActionMenuPresenter) subUiVisibilityListener).q(false);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.c(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (!activityChooserView.n) {
                ActivityChooserViewAdapter activityChooserViewAdapter = activityChooserView.f748a;
                boolean z = activityChooserViewAdapter.f767c;
                synchronized (activityChooserViewAdapter.f765a.f738a) {
                }
                return;
            }
            if (i2 > 0) {
                ActivityChooserModel activityChooserModel = activityChooserView.f748a.f765a;
                synchronized (activityChooserModel.f738a) {
                    activityChooserModel.a();
                    ActivityChooserModel.ActivityResolveInfo activityResolveInfo = (ActivityChooserModel.ActivityResolveInfo) activityChooserModel.f739b.get(i2);
                    if (((ActivityChooserModel.ActivityResolveInfo) activityChooserModel.f739b.get(0)) != null) {
                        activityResolveInfo.getClass();
                    }
                    throw null;
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f754g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f748a.getCount() > 0) {
                activityChooserView.n = true;
                activityChooserView.c(activityChooserView.o);
            }
            return true;
        }
    }

    @RestrictTo
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f772a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray tintTypedArrayE = TintTypedArray.e(context, attributeSet, f772a);
            setBackgroundDrawable(tintTypedArrayE.b(0));
            tintTypedArrayE.g();
        }
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f758k);
            }
        }
    }

    public final boolean b() {
        return getListPopupWindow().z.isShowing();
    }

    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    public final void c(int i2) {
        ActionProvider.SubUiVisibilityListener subUiVisibilityListener;
        ActivityChooserViewAdapter activityChooserViewAdapter = this.f748a;
        if (activityChooserViewAdapter.f765a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f758k);
        ?? r1 = this.f754g.getVisibility() == 0 ? 1 : 0;
        int iC = activityChooserViewAdapter.f765a.c();
        if (i2 == Integer.MAX_VALUE || iC <= i2 + r1) {
            if (activityChooserViewAdapter.f769e) {
                activityChooserViewAdapter.f769e = false;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
            if (activityChooserViewAdapter.f766b != i2) {
                activityChooserViewAdapter.f766b = i2;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
        } else {
            if (!activityChooserViewAdapter.f769e) {
                activityChooserViewAdapter.f769e = true;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
            int i3 = i2 - 1;
            if (activityChooserViewAdapter.f766b != i3) {
                activityChooserViewAdapter.f766b = i3;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.z.isShowing()) {
            return;
        }
        if (this.n || r1 == 0) {
            if (!activityChooserViewAdapter.f767c || activityChooserViewAdapter.f768d != r1) {
                activityChooserViewAdapter.f767c = true;
                activityChooserViewAdapter.f768d = r1;
                activityChooserViewAdapter.notifyDataSetChanged();
            }
        } else if (activityChooserViewAdapter.f767c || activityChooserViewAdapter.f768d) {
            activityChooserViewAdapter.f767c = false;
            activityChooserViewAdapter.f768d = false;
            activityChooserViewAdapter.notifyDataSetChanged();
        }
        int i4 = activityChooserViewAdapter.f766b;
        activityChooserViewAdapter.f766b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = activityChooserViewAdapter.getCount();
        int iMax = 0;
        View view = null;
        for (int i5 = 0; i5 < count; i5++) {
            view = activityChooserViewAdapter.getView(i5, view, null);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        activityChooserViewAdapter.f766b = i4;
        listPopupWindow.r(Math.min(iMax, this.f755h));
        listPopupWindow.a();
        ActionProvider actionProvider = this.f756i;
        if (actionProvider != null && (subUiVisibilityListener = actionProvider.f3016a) != null) {
            ((ActionMenuPresenter) subUiVisibilityListener).q(true);
        }
        listPopupWindow.f1074c.setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.f1074c.setSelector(new ColorDrawable(0));
    }

    @RestrictTo
    public ActivityChooserModel getDataModel() {
        return this.f748a.f765a;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f759l == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f759l = listPopupWindow;
            listPopupWindow.n(this.f748a);
            ListPopupWindow listPopupWindow2 = this.f759l;
            listPopupWindow2.o = this;
            listPopupWindow2.y = true;
            listPopupWindow2.z.setFocusable(true);
            ListPopupWindow listPopupWindow3 = this.f759l;
            Callbacks callbacks = this.f749b;
            listPopupWindow3.p = callbacks;
            listPopupWindow3.z.setOnDismissListener(callbacks);
        }
        return this.f759l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.f748a.f765a;
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver(this.f757j);
        }
        this.p = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.f748a.f765a;
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver(this.f757j);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f758k);
        }
        if (b()) {
            a();
        }
        this.p = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f750c.layout(0, 0, i4 - i2, i5 - i3);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        if (this.f754g.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        View view = this.f750c;
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserViewAdapter activityChooserViewAdapter = this.f748a;
        ActivityChooserView activityChooserView = ActivityChooserView.this;
        ActivityChooserModel activityChooserModel2 = activityChooserView.f748a.f765a;
        DataSetObserver dataSetObserver = activityChooserView.f757j;
        if (activityChooserModel2 != null && activityChooserView.isShown()) {
            activityChooserModel2.unregisterObserver(dataSetObserver);
        }
        activityChooserViewAdapter.f765a = activityChooserModel;
        if (activityChooserModel != null && activityChooserView.isShown()) {
            activityChooserModel.registerObserver(dataSetObserver);
        }
        activityChooserViewAdapter.notifyDataSetChanged();
        if (b()) {
            a();
            if (b() || !this.p) {
                return;
            }
            this.n = false;
            c(this.o);
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f753f.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f753f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.o = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f760m = onDismissListener;
    }

    @RestrictTo
    public void setProvider(ActionProvider actionProvider) {
        this.f756i = actionProvider;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f757j = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f748a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f748a.notifyDataSetInvalidated();
            }
        };
        this.f758k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ActionProvider.SubUiVisibilityListener subUiVisibilityListener;
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.b()) {
                    if (!activityChooserView.isShown()) {
                        activityChooserView.getListPopupWindow().dismiss();
                        return;
                    }
                    activityChooserView.getListPopupWindow().a();
                    ActionProvider actionProvider = activityChooserView.f756i;
                    if (actionProvider == null || (subUiVisibilityListener = actionProvider.f3016a) == null) {
                        return;
                    }
                    ((ActionMenuPresenter) subUiVisibilityListener).q(true);
                }
            }
        };
        this.o = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i2, 0);
        ViewCompat.y(this, context, R.styleable.ActivityChooserView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        this.o = typedArrayObtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        Callbacks callbacks = new Callbacks();
        this.f749b = callbacks;
        View viewFindViewById = findViewById(R.id.activity_chooser_view_content);
        this.f750c = viewFindViewById;
        this.f751d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f754g = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new AnonymousClass3());
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            @Override // androidx.appcompat.widget.ForwardingListener
            public final ShowableListMenu b() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public final boolean c() {
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.b() || !activityChooserView.p) {
                    return true;
                }
                activityChooserView.n = false;
                activityChooserView.c(activityChooserView.o);
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public final boolean d() {
                ActivityChooserView.this.a();
                return true;
            }
        });
        this.f752e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.image);
        this.f753f = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.f748a = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public final void onChanged() {
                int size;
                super.onChanged();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.f748a.getCount() > 0) {
                    activityChooserView.f752e.setEnabled(true);
                } else {
                    activityChooserView.f752e.setEnabled(false);
                }
                int iC = activityChooserView.f748a.f765a.c();
                ActivityChooserModel activityChooserModel = activityChooserView.f748a.f765a;
                synchronized (activityChooserModel.f738a) {
                    activityChooserModel.a();
                    size = activityChooserModel.f740c.size();
                }
                if (iC == 1 || (iC > 1 && size > 0)) {
                    activityChooserView.f754g.setVisibility(0);
                    activityChooserView.f748a.f765a.d();
                    activityChooserView.getContext().getPackageManager();
                    throw null;
                }
                activityChooserView.f754g.setVisibility(8);
                if (activityChooserView.f754g.getVisibility() == 0) {
                    activityChooserView.f750c.setBackgroundDrawable(activityChooserView.f751d);
                } else {
                    activityChooserView.f750c.setBackgroundDrawable(null);
                }
            }
        });
        Resources resources = context.getResources();
        this.f755h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}
