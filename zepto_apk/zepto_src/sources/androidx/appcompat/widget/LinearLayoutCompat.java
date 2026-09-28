package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.activity.k;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

/* loaded from: classes3.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1049a;

    /* renamed from: b, reason: collision with root package name */
    public int f1050b;

    /* renamed from: c, reason: collision with root package name */
    public int f1051c;

    /* renamed from: d, reason: collision with root package name */
    public int f1052d;

    /* renamed from: e, reason: collision with root package name */
    public int f1053e;

    /* renamed from: f, reason: collision with root package name */
    public int f1054f;

    /* renamed from: g, reason: collision with root package name */
    public float f1055g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1056h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f1057i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f1058j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f1059k;

    /* renamed from: l, reason: collision with root package name */
    public int f1060l;

    /* renamed from: m, reason: collision with root package name */
    public int f1061m;
    public int n;
    public int o;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface DividerMode {
    }

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1062a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1063b;

        /* renamed from: c, reason: collision with root package name */
        public int f1064c;

        /* renamed from: d, reason: collision with root package name */
        public int f1065d;

        /* renamed from: e, reason: collision with root package name */
        public int f1066e;

        /* renamed from: f, reason: collision with root package name */
        public int f1067f;

        /* renamed from: g, reason: collision with root package name */
        public int f1068g;

        /* renamed from: h, reason: collision with root package name */
        public int f1069h;

        /* renamed from: i, reason: collision with root package name */
        public int f1070i;

        /* renamed from: j, reason: collision with root package name */
        public int f1071j;

        /* renamed from: androidx.appcompat.widget.LinearLayoutCompat$InspectionCompanion$1, reason: invalid class name */
        class AnonymousClass1 implements IntFunction<String> {
            @Override // java.util.function.IntFunction
            public final String apply(int i2) {
                return i2 != 0 ? i2 != 1 ? String.valueOf(i2) : "vertical" : "horizontal";
            }
        }

        /* renamed from: androidx.appcompat.widget.LinearLayoutCompat$InspectionCompanion$2, reason: invalid class name */
        class AnonymousClass2 implements IntFunction<Set<String>> {
            @Override // java.util.function.IntFunction
            public final Set<String> apply(int i2) {
                HashSet hashSet = new HashSet();
                if (i2 == 0) {
                    hashSet.add("none");
                }
                if (i2 == 1) {
                    hashSet.add("beginning");
                }
                if (i2 == 2) {
                    hashSet.add("middle");
                }
                if (i2 == 4) {
                    hashSet.add("end");
                }
                return hashSet;
            }
        }

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f1063b = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.f1064c = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.f1065d = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.f1066e = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new AnonymousClass1());
            this.f1067f = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.f1068g = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.divider);
            this.f1069h = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.dividerPadding);
            this.f1070i = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.measureWithLargestChild);
            this.f1071j = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.showDividers, new AnonymousClass2());
            this.f1062a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) obj;
            if (!this.f1062a) {
                throw k.e();
            }
            propertyReader.readBoolean(this.f1063b, linearLayoutCompat.f1049a);
            propertyReader.readInt(this.f1064c, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.f1065d, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.f1066e, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.f1067f, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.f1068g, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.f1069h, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.f1070i, linearLayoutCompat.f1056h);
            propertyReader.readIntFlag(this.f1071j, linearLayoutCompat.getShowDividers());
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void f(Canvas canvas, int i2) {
        this.f1059k.setBounds(getPaddingLeft() + this.o, i2, (getWidth() - getPaddingRight()) - this.o, this.f1061m + i2);
        this.f1059k.draw(canvas);
    }

    public final void g(Canvas canvas, int i2) {
        this.f1059k.setBounds(i2, getPaddingTop() + this.o, this.f1060l + i2, (getHeight() - getPaddingBottom()) - this.o);
        this.f1059k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f1050b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f1050b;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1050b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1051c;
        if (this.f1052d == 1 && (i2 = this.f1053e & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1054f) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1054f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1050b;
    }

    public Drawable getDividerDrawable() {
        return this.f1059k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    @RestrictTo
    public int getDividerWidth() {
        return this.f1060l;
    }

    @GravityInt
    public int getGravity() {
        return this.f1053e;
    }

    public int getOrientation() {
        return this.f1052d;
    }

    public int getShowDividers() {
        return this.n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1055g;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.f1052d;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public final boolean k(int i2) {
        if (i2 == 0) {
            return (this.n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) != 0) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i2;
        if (this.f1059k == null) {
            return;
        }
        int i3 = 0;
        if (this.f1052d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i3 < virtualChildCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && k(i3)) {
                    f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.f1061m);
                }
                i3++;
            }
            if (k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                f(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f1061m : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = ViewUtils.f1266a;
        boolean z2 = getLayoutDirection() == 1;
        while (i3 < virtualChildCount2) {
            View childAt3 = getChildAt(i3);
            if (childAt3 != null && childAt3.getVisibility() != 8 && k(i3)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                g(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f1060l);
            }
            i3++;
        }
        if (k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i2 = this.f1060l;
                    right = left - i2;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.f1060l;
                right = left - i2;
            }
            g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a8  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f1049a = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f1050b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1059k) {
            return;
        }
        this.f1059k = drawable;
        if (drawable != null) {
            this.f1060l = drawable.getIntrinsicWidth();
            this.f1061m = drawable.getIntrinsicHeight();
        } else {
            this.f1060l = 0;
            this.f1061m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.o = i2;
    }

    public void setGravity(@GravityInt int i2) {
        if (this.f1053e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1053e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f1053e;
        if ((8388615 & i4) != i3) {
            this.f1053e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1056h = z;
    }

    public void setOrientation(int i2) {
        if (this.f1052d != i2) {
            this.f1052d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.n) {
            requestLayout();
        }
        this.n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f1053e;
        if ((i4 & 112) != i3) {
            this.f1053e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f1055g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1049a = true;
        this.f1050b = -1;
        this.f1051c = 0;
        this.f1053e = 8388659;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(context, attributeSet, androidx.appcompat.R.styleable.LinearLayoutCompat, i2);
        ViewCompat.y(this, context, androidx.appcompat.R.styleable.LinearLayoutCompat, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        int i3 = androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        int i4 = typedArray.getInt(i3, -1);
        if (i4 >= 0) {
            setOrientation(i4);
        }
        int i5 = typedArray.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        boolean z = typedArray.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f1055g = typedArray.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1050b = typedArray.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1056h = typedArray.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.n = typedArray.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.o = typedArray.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayF.g();
    }
}
