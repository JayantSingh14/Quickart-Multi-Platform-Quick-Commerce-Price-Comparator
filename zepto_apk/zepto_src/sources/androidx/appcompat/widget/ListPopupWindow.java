package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final Method A;
    public static final Method B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1072a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f1073b;

    /* renamed from: c, reason: collision with root package name */
    public DropDownListView f1074c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1075d;

    /* renamed from: e, reason: collision with root package name */
    public int f1076e;

    /* renamed from: f, reason: collision with root package name */
    public int f1077f;

    /* renamed from: g, reason: collision with root package name */
    public int f1078g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1079h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1080i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1081j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1082k;

    /* renamed from: l, reason: collision with root package name */
    public int f1083l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1084m;
    public DataSetObserver n;
    public View o;
    public AdapterView.OnItemClickListener p;
    public AdapterView.OnItemSelectedListener q;
    public final ResizePopupRunnable r;
    public final PopupTouchInterceptor s;
    public final PopupScrollListener t;
    public final ListSelectorHider u;
    public final Handler v;
    public final Rect w;
    public Rect x;
    public boolean y;
    public final PopupWindow z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$1, reason: invalid class name */
    class AnonymousClass1 extends ForwardingListener {
        @Override // androidx.appcompat.widget.ForwardingListener
        public final /* bridge */ /* synthetic */ ShowableListMenu b() {
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static int a(PopupWindow popupWindow, View view, int i2, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i2, z);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @DoNotInline
        public static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    public class ListSelectorHider implements Runnable {
        public ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f1074c;
            if (dropDownListView != null) {
                dropDownListView.setListSelectionHidden(true);
                dropDownListView.requestLayout();
            }
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        public PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (listPopupWindow.z.isShowing()) {
                listPopupWindow.a();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class PopupScrollListener implements AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (listPopupWindow.z.getInputMethodMode() == 2 || listPopupWindow.z.getContentView() == null) {
                    return;
                }
                Handler handler = listPopupWindow.v;
                ResizePopupRunnable resizePopupRunnable = listPopupWindow.r;
                handler.removeCallbacks(resizePopupRunnable);
                resizePopupRunnable.run();
            }
        }
    }

    public class PopupTouchInterceptor implements View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (action == 0 && (popupWindow = listPopupWindow.z) != null && popupWindow.isShowing() && x >= 0 && x < listPopupWindow.z.getWidth() && y >= 0 && y < listPopupWindow.z.getHeight()) {
                listPopupWindow.v.postDelayed(listPopupWindow.r, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            listPopupWindow.v.removeCallbacks(listPopupWindow.r);
            return false;
        }
    }

    public class ResizePopupRunnable implements Runnable {
        public ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            DropDownListView dropDownListView = listPopupWindow.f1074c;
            if (dropDownListView == null || !dropDownListView.isAttachedToWindow() || listPopupWindow.f1074c.getCount() <= listPopupWindow.f1074c.getChildCount() || listPopupWindow.f1074c.getChildCount() > listPopupWindow.f1084m) {
                return;
            }
            listPopupWindow.z.setInputMethodMode(2);
            listPopupWindow.a();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                A = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void a() {
        int i2;
        int paddingBottom;
        DropDownListView dropDownListView;
        DropDownListView dropDownListView2 = this.f1074c;
        PopupWindow popupWindow = this.z;
        Context context = this.f1072a;
        if (dropDownListView2 == null) {
            DropDownListView dropDownListViewQ = q(context, !this.y);
            this.f1074c = dropDownListViewQ;
            dropDownListViewQ.setAdapter(this.f1073b);
            this.f1074c.setOnItemClickListener(this.p);
            this.f1074c.setFocusable(true);
            this.f1074c.setFocusableInTouchMode(true);
            this.f1074c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView adapterView, View view, int i3, long j2) {
                    DropDownListView dropDownListView3;
                    if (i3 == -1 || (dropDownListView3 = ListPopupWindow.this.f1074c) == null) {
                        return;
                    }
                    dropDownListView3.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView adapterView) {
                }
            });
            this.f1074c.setOnScrollListener(this.t);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.q;
            if (onItemSelectedListener != null) {
                this.f1074c.setOnItemSelectedListener(onItemSelectedListener);
            }
            popupWindow.setContentView(this.f1074c);
        }
        Drawable background = popupWindow.getBackground();
        Rect rect = this.w;
        if (background != null) {
            background.getPadding(rect);
            int i3 = rect.top;
            i2 = rect.bottom + i3;
            if (!this.f1080i) {
                this.f1078g = -i3;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        int iA = Api24Impl.a(popupWindow, this.o, this.f1078g, popupWindow.getInputMethodMode() == 2);
        int i4 = this.f1075d;
        if (i4 == -1) {
            paddingBottom = iA + i2;
        } else {
            int i5 = this.f1076e;
            int iA2 = this.f1074c.a(i5 != -2 ? i5 != -1 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f1074c.getPaddingBottom() + this.f1074c.getPaddingTop() + i2 : 0);
        }
        boolean z = this.z.getInputMethodMode() == 2;
        popupWindow.setWindowLayoutType(this.f1079h);
        if (popupWindow.isShowing()) {
            if (this.o.isAttachedToWindow()) {
                int width = this.f1076e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.o.getWidth();
                }
                if (i4 == -1) {
                    i4 = z ? paddingBottom : -1;
                    if (z) {
                        popupWindow.setWidth(this.f1076e == -1 ? -1 : 0);
                        popupWindow.setHeight(0);
                    } else {
                        popupWindow.setWidth(this.f1076e == -1 ? -1 : 0);
                        popupWindow.setHeight(-1);
                    }
                } else if (i4 == -2) {
                    i4 = paddingBottom;
                }
                popupWindow.setOutsideTouchable(true);
                View view = this.o;
                int i6 = this.f1077f;
                int i7 = this.f1078g;
                if (width < 0) {
                    width = -1;
                }
                popupWindow.update(view, i6, i7, width, i4 < 0 ? -1 : i4);
                return;
            }
            return;
        }
        int width2 = this.f1076e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.o.getWidth();
        }
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = paddingBottom;
        }
        popupWindow.setWidth(width2);
        popupWindow.setHeight(i4);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = A;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.b(popupWindow, true);
        }
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(this.s);
        if (this.f1082k) {
            popupWindow.setOverlapAnchor(this.f1081j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(popupWindow, this.x);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            Api29Impl.a(popupWindow, this.x);
        }
        popupWindow.showAsDropDown(this.o, this.f1077f, this.f1078g, this.f1083l);
        this.f1074c.setSelection(-1);
        if ((!this.y || this.f1074c.isInTouchMode()) && (dropDownListView = this.f1074c) != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
        if (this.y) {
            return;
        }
        this.v.post(this.u);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean b() {
        return this.z.isShowing();
    }

    public final int c() {
        return this.f1077f;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        PopupWindow popupWindow = this.z;
        popupWindow.dismiss();
        popupWindow.setContentView(null);
        this.f1074c = null;
        this.v.removeCallbacks(this.r);
    }

    public final void e(int i2) {
        this.f1077f = i2;
    }

    public final Drawable g() {
        return this.z.getBackground();
    }

    public final void i(int i2) {
        this.f1078g = i2;
        this.f1080i = true;
    }

    public final int l() {
        if (this.f1080i) {
            return this.f1078g;
        }
        return 0;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.n;
        if (dataSetObserver == null) {
            this.n = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f1073b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1073b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.n);
        }
        DropDownListView dropDownListView = this.f1074c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f1073b);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView o() {
        return this.f1074c;
    }

    public final void p(Drawable drawable) {
        this.z.setBackgroundDrawable(drawable);
    }

    public DropDownListView q(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public final void r(int i2) {
        Drawable background = this.z.getBackground();
        if (background == null) {
            this.f1076e = i2;
            return;
        }
        Rect rect = this.w;
        background.getPadding(rect);
        this.f1076e = rect.left + rect.right + i2;
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1075d = -2;
        this.f1076e = -2;
        this.f1079h = 1002;
        this.f1083l = 0;
        this.f1084m = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.r = new ResizePopupRunnable();
        this.s = new PopupTouchInterceptor();
        this.t = new PopupScrollListener();
        this.u = new ListSelectorHider();
        this.w = new Rect();
        this.f1072a = context;
        this.v = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, 0);
        this.f1077f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1078g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1080i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, 0);
        appCompatPopupWindow.a(context, attributeSet, i2);
        this.z = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
