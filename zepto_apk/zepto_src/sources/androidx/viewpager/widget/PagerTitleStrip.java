package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes3.dex */
public class PagerTitleStrip extends ViewGroup {
    public static final int[] o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    public static final int[] p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f12326a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12327b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12328c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12329d;

    /* renamed from: e, reason: collision with root package name */
    public int f12330e;

    /* renamed from: f, reason: collision with root package name */
    public float f12331f;

    /* renamed from: g, reason: collision with root package name */
    public int f12332g;

    /* renamed from: h, reason: collision with root package name */
    public int f12333h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12334i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12335j;

    /* renamed from: k, reason: collision with root package name */
    public final PageListener f12336k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f12337l;

    /* renamed from: m, reason: collision with root package name */
    public int f12338m;
    public int n;

    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public int f12339a;

        public PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void a(float f2, int i2) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.c(f2, i2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void b(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void c(int i2) {
            this.f12339a = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void d(int i2) {
            if (this.f12339a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f12326a.getCurrentItem(), pagerTitleStrip.f12326a.getAdapter());
                float f2 = pagerTitleStrip.f12331f;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                pagerTitleStrip.c(f2, pagerTitleStrip.f12326a.getCurrentItem(), true);
            }
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f12326a.getCurrentItem(), pagerTitleStrip.f12326a.getAdapter());
            float f2 = pagerTitleStrip.f12331f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            pagerTitleStrip.c(f2, pagerTitleStrip.f12326a.getCurrentItem(), true);
        }
    }

    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        public Locale f12341a;

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f12341a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f12330e = -1;
        this.f12331f = -1.0f;
        this.f12336k = new PageListener();
        TextView textView = new TextView(context);
        this.f12327b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f12328c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f12329d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o);
        boolean z = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            textView.setTextAppearance(resourceId);
            textView2.setTextAppearance(resourceId);
            textView3.setTextAppearance(resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f2 = dimensionPixelSize;
            textView.setTextSize(0, f2);
            textView2.setTextSize(0, f2);
            textView3.setTextSize(0, f2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.f12333h = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.n = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView2.setEllipsize(truncateAt);
        textView3.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, p);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(textView);
            setSingleLineAllCaps(textView2);
            setSingleLineAllCaps(textView3);
        } else {
            textView.setSingleLine();
            textView2.setSingleLine();
            textView3.setSingleLine();
        }
        this.f12332g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        SingleLineAllCapsTransform singleLineAllCapsTransform = new SingleLineAllCapsTransform();
        singleLineAllCapsTransform.f12341a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(singleLineAllCapsTransform);
    }

    public final void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        PageListener pageListener = this.f12336k;
        if (pagerAdapter != null) {
            pagerAdapter.f12323a.unregisterObserver(pageListener);
            this.f12337l = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.f12323a.registerObserver(pageListener);
            this.f12337l = new WeakReference(pagerAdapter2);
        }
        ViewPager viewPager = this.f12326a;
        if (viewPager != null) {
            this.f12330e = -1;
            this.f12331f = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public final void b(int i2, PagerAdapter pagerAdapter) {
        int iC = pagerAdapter != null ? pagerAdapter.c() : 0;
        this.f12334i = true;
        CharSequence charSequenceD = null;
        CharSequence charSequenceD2 = (i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.d(i2 - 1);
        TextView textView = this.f12327b;
        textView.setText(charSequenceD2);
        TextView textView2 = this.f12328c;
        textView2.setText((pagerAdapter == null || i2 >= iC) ? null : pagerAdapter.d(i2));
        int i3 = i2 + 1;
        if (i3 < iC && pagerAdapter != null) {
            charSequenceD = pagerAdapter.d(i3);
        }
        TextView textView3 = this.f12329d;
        textView3.setText(charSequenceD);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        textView2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        textView3.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f12330e = i2;
        if (!this.f12335j) {
            c(this.f12331f, i2, false);
        }
        this.f12334i = false;
    }

    public void c(float f2, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.f12330e) {
            b(i2, this.f12326a.getAdapter());
        } else if (!z && f2 == this.f12331f) {
            return;
        }
        this.f12335j = true;
        TextView textView = this.f12327b;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f12328c;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f12329d;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = f2 + 0.5f;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (i9 * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int baseline3 = textView3.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = iMax - baseline;
        int i13 = iMax - baseline2;
        int i14 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(textView.getMeasuredHeight() + i12, textView2.getMeasuredHeight() + i13), textView3.getMeasuredHeight() + i14);
        int i15 = this.f12333h & 112;
        if (i15 == 16) {
            i3 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = paddingTop + i13;
                i6 = paddingTop + i14;
                textView2.layout(i10, i5, i11, textView2.getMeasuredHeight() + i5);
                int iMin = Math.min(paddingLeft, (i10 - this.f12332g) - measuredWidth);
                textView.layout(iMin, i4, iMin + measuredWidth, textView.getMeasuredHeight() + i4);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f12332g);
                textView3.layout(iMax3, i6, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.f12331f = f2;
                this.f12335j = false;
            }
            i3 = (height - paddingBottom) - iMax2;
        }
        i4 = i12 + i3;
        i5 = i3 + i13;
        i6 = i3 + i14;
        textView2.layout(i10, i5, i11, textView2.getMeasuredHeight() + i5);
        int iMin2 = Math.min(paddingLeft, (i10 - this.f12332g) - measuredWidth);
        textView.layout(iMin2, i4, iMin2 + measuredWidth, textView.getMeasuredHeight() + i4);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f12332g);
        textView3.layout(iMax32, i6, iMax32 + measuredWidth3, textView3.getMeasuredHeight() + i6);
        this.f12331f = f2;
        this.f12335j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f12332g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        PageListener pageListener = this.f12336k;
        viewPager.F0 = pageListener;
        if (viewPager.G0 == null) {
            viewPager.G0 = new ArrayList();
        }
        viewPager.G0.add(pageListener);
        this.f12326a = viewPager;
        WeakReference weakReference = this.f12337l;
        a(weakReference != null ? (PagerAdapter) weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f12326a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            ViewPager viewPager2 = this.f12326a;
            ViewPager.OnPageChangeListener onPageChangeListener = viewPager2.F0;
            viewPager2.F0 = null;
            ArrayList arrayList = viewPager2.G0;
            if (arrayList != null) {
                arrayList.remove(this.f12336k);
            }
            this.f12326a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f12326a != null) {
            float f2 = this.f12331f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            c(f2, this.f12330e, true);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int iMax;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
        this.f12327b.measure(childMeasureSpec2, childMeasureSpec);
        TextView textView = this.f12328c;
        textView.measure(childMeasureSpec2, childMeasureSpec);
        this.f12329d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i3);
        } else {
            iMax = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i3, textView.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f12334i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.f12333h = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.f12338m = i2;
        int i3 = (i2 << 24) | (this.n & 16777215);
        this.f12327b.setTextColor(i3);
        this.f12329d.setTextColor(i3);
    }

    public void setTextColor(@ColorInt int i2) {
        this.n = i2;
        this.f12328c.setTextColor(i2);
        int i3 = (this.f12338m << 24) | (this.n & 16777215);
        this.f12327b.setTextColor(i3);
        this.f12329d.setTextColor(i3);
    }

    public void setTextSpacing(int i2) {
        this.f12332g = i2;
        requestLayout();
    }
}
