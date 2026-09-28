package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CompoundButton;
import androidx.activity.k;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
    public static final Property D0 = new Property<SwitchCompat, Float>() { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        public final Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.z);
        }

        @Override // android.util.Property
        public final void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };
    public static final int[] E0 = {R.attr.state_checked};
    public int A;
    public AppCompatEmojiTextHelper A0;
    public int B;
    public EmojiCompatInitCallback B0;
    public int C;
    public final Rect C0;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public final TextPaint I;
    public final ColorStateList J;
    public StaticLayout K;
    public StaticLayout L;
    public final AllCapsTransformationMethod M;
    public ObjectAnimator Q;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f1145a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f1146b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1147c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1148d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1149e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1150f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1151g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1152h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1153i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1154j;

    /* renamed from: k, reason: collision with root package name */
    public int f1155k;

    /* renamed from: l, reason: collision with root package name */
    public int f1156l;

    /* renamed from: m, reason: collision with root package name */
    public int f1157m;
    public boolean n;
    public CharSequence o;
    public CharSequence p;
    public CharSequence q;
    public CharSequence r;
    public boolean s;
    public int t;
    public final int u;
    public float v;
    public float w;
    public final VelocityTracker x;
    public final int y;
    public float z;

    /* loaded from: classes3.dex */
    public static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f1158a;

        public EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.f1158a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void a() {
            SwitchCompat switchCompat = (SwitchCompat) this.f1158a.get();
            if (switchCompat != null) {
                switchCompat.c();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f1158a.get();
            if (switchCompat != null) {
                switchCompat.c();
            }
        }
    }

    @RequiresApi
    @RestrictTo
    /* loaded from: classes3.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1159a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1160b;

        /* renamed from: c, reason: collision with root package name */
        public int f1161c;

        /* renamed from: d, reason: collision with root package name */
        public int f1162d;

        /* renamed from: e, reason: collision with root package name */
        public int f1163e;

        /* renamed from: f, reason: collision with root package name */
        public int f1164f;

        /* renamed from: g, reason: collision with root package name */
        public int f1165g;

        /* renamed from: h, reason: collision with root package name */
        public int f1166h;

        /* renamed from: i, reason: collision with root package name */
        public int f1167i;

        /* renamed from: j, reason: collision with root package name */
        public int f1168j;

        /* renamed from: k, reason: collision with root package name */
        public int f1169k;

        /* renamed from: l, reason: collision with root package name */
        public int f1170l;

        /* renamed from: m, reason: collision with root package name */
        public int f1171m;
        public int n;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f1160b = propertyMapper.mapObject("textOff", R.attr.textOff);
            this.f1161c = propertyMapper.mapObject("textOn", R.attr.textOn);
            this.f1162d = propertyMapper.mapObject("thumb", R.attr.thumb);
            this.f1163e = propertyMapper.mapBoolean("showText", androidx.appcompat.R.attr.showText);
            this.f1164f = propertyMapper.mapBoolean("splitTrack", androidx.appcompat.R.attr.splitTrack);
            this.f1165g = propertyMapper.mapInt("switchMinWidth", androidx.appcompat.R.attr.switchMinWidth);
            this.f1166h = propertyMapper.mapInt("switchPadding", androidx.appcompat.R.attr.switchPadding);
            this.f1167i = propertyMapper.mapInt("thumbTextPadding", androidx.appcompat.R.attr.thumbTextPadding);
            this.f1168j = propertyMapper.mapObject("thumbTint", androidx.appcompat.R.attr.thumbTint);
            this.f1169k = propertyMapper.mapObject("thumbTintMode", androidx.appcompat.R.attr.thumbTintMode);
            this.f1170l = propertyMapper.mapObject("track", androidx.appcompat.R.attr.track);
            this.f1171m = propertyMapper.mapObject("trackTint", androidx.appcompat.R.attr.trackTint);
            this.n = propertyMapper.mapObject("trackTintMode", androidx.appcompat.R.attr.trackTintMode);
            this.f1159a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            SwitchCompat switchCompat = (SwitchCompat) obj;
            if (!this.f1159a) {
                throw k.e();
            }
            propertyReader.readObject(this.f1160b, switchCompat.getTextOff());
            propertyReader.readObject(this.f1161c, switchCompat.getTextOn());
            propertyReader.readObject(this.f1162d, switchCompat.getThumbDrawable());
            propertyReader.readBoolean(this.f1163e, switchCompat.getShowText());
            propertyReader.readBoolean(this.f1164f, switchCompat.getSplitTrack());
            propertyReader.readInt(this.f1165g, switchCompat.getSwitchMinWidth());
            propertyReader.readInt(this.f1166h, switchCompat.getSwitchPadding());
            propertyReader.readInt(this.f1167i, switchCompat.getThumbTextPadding());
            propertyReader.readObject(this.f1168j, switchCompat.getThumbTintList());
            propertyReader.readObject(this.f1169k, switchCompat.getThumbTintMode());
            propertyReader.readObject(this.f1170l, switchCompat.getTrackDrawable());
            propertyReader.readObject(this.f1171m, switchCompat.getTrackTintList());
            propertyReader.readObject(this.n, switchCompat.getTrackTintMode());
        }
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.A0 == null) {
            this.A0 = new AppCompatEmojiTextHelper(this);
        }
        return this.A0;
    }

    private boolean getTargetCheckedState() {
        return this.z > 0.5f;
    }

    private int getThumbOffset() {
        boolean z = ViewUtils.f1266a;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.z : this.z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1150f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.C0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1145a;
        Rect rectB = drawable2 != null ? DrawableUtils.b(drawable2) : DrawableUtils.f1010c;
        return ((((this.A - this.C) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.q = charSequence;
        AppCompatEmojiTextHelper emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodE = emojiTextViewHelper.f858b.e(this.M);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.r = charSequence;
        this.L = null;
        if (this.s) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.o = charSequence;
        AppCompatEmojiTextHelper emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodE = emojiTextViewHelper.f858b.e(this.M);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.p = charSequence;
        this.K = null;
        if (this.s) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f1145a;
        if (drawable != null) {
            if (this.f1148d || this.f1149e) {
                Drawable drawableMutate = drawable.mutate();
                this.f1145a = drawableMutate;
                if (this.f1148d) {
                    DrawableCompat.m(drawableMutate, this.f1146b);
                }
                if (this.f1149e) {
                    DrawableCompat.n(this.f1145a, this.f1147c);
                }
                if (this.f1145a.isStateful()) {
                    this.f1145a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f1150f;
        if (drawable != null) {
            if (this.f1153i || this.f1154j) {
                Drawable drawableMutate = drawable.mutate();
                this.f1150f = drawableMutate;
                if (this.f1153i) {
                    DrawableCompat.m(drawableMutate, this.f1151g);
                }
                if (this.f1154j) {
                    DrawableCompat.n(this.f1150f, this.f1152h);
                }
                if (this.f1150f.isStateful()) {
                    this.f1150f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.o);
        setTextOffInternal(this.q);
        requestLayout();
    }

    public final void d() {
        if (this.B0 == null && this.A0.f858b.b() && EmojiCompat.f4294k != null) {
            EmojiCompat emojiCompatA = EmojiCompat.a();
            int iB = emojiCompatA.b();
            if (iB == 3 || iB == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.B0 = emojiCompatInitCallback;
                emojiCompatA.h(emojiCompatInitCallback);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i2;
        int i3;
        int i4 = this.D;
        int i5 = this.E;
        int i6 = this.F;
        int i7 = this.G;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f1145a;
        Rect rectB = drawable != null ? DrawableUtils.b(drawable) : DrawableUtils.f1010c;
        Drawable drawable2 = this.f1150f;
        Rect rect = this.C0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (rectB != null) {
                int i9 = rectB.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rectB.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rectB.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rectB.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                }
                this.f1150f.setBounds(i4, i2, i6, i3);
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f1150f.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f1145a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.C + rect.right;
            this.f1145a.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.k(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f1145a;
        if (drawable != null) {
            DrawableCompat.j(drawable, f2, f3);
        }
        Drawable drawable2 = this.f1150f;
        if (drawable2 != null) {
            DrawableCompat.j(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1145a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f1150f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z = ViewUtils.f1266a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1157m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z = ViewUtils.f1266a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1157m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.j(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.s;
    }

    public boolean getSplitTrack() {
        return this.n;
    }

    public int getSwitchMinWidth() {
        return this.f1156l;
    }

    public int getSwitchPadding() {
        return this.f1157m;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.o;
    }

    public Drawable getThumbDrawable() {
        return this.f1145a;
    }

    @FloatRange
    public final float getThumbPosition() {
        return this.z;
    }

    public int getThumbTextPadding() {
        return this.f1155k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1146b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1147c;
    }

    public Drawable getTrackDrawable() {
        return this.f1150f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1151g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1152h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1145a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1150f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.Q.end();
        this.Q = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f1150f;
        Rect rect = this.C0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.E;
        int i3 = this.G;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f1145a;
        if (drawable != null) {
            if (!this.n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = DrawableUtils.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.K : this.L;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            TextPaint textPaint = this.I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i4 + i5) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.o : this.q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i2, i3, i4, i5);
        int iMax2 = 0;
        if (this.f1145a != null) {
            Drawable drawable = this.f1150f;
            Rect rect = this.C0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = DrawableUtils.b(this.f1145a);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        boolean z2 = ViewUtils.f1266a;
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i6 = this.B;
            int i7 = height2 - (i6 / 2);
            height = i6 + i7;
            paddingTop = i7;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.B + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.B;
        }
        this.D = paddingLeft;
        this.E = paddingTop;
        this.G = height;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.s) {
            StaticLayout staticLayout = this.K;
            TextPaint textPaint = this.I;
            if (staticLayout == null) {
                CharSequence charSequence = this.p;
                this.K = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.L == null) {
                CharSequence charSequence2 = this.r;
                this.L = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f1145a;
        Rect rect = this.C0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f1145a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1145a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.C = Math.max(this.s ? (this.f1155k * 2) + Math.max(this.K.getWidth(), this.L.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.f1150f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f1150f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f1145a;
        if (drawable3 != null) {
            Rect rectB = DrawableUtils.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        int iMax3 = this.H ? Math.max(this.f1156l, (this.C * 2) + iMax + iMax2) : this.f1156l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.A = iMax3;
        this.B = iMax4;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.o : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) throws Resources.NotFoundException {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                CharSequence string = this.o;
                if (string == null) {
                    string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
                }
                ViewCompat.L(this, string);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string2 = this.q;
            if (string2 == null) {
                string2 = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            ViewCompat.L(this, string2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.Q;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) D0, zIsChecked ? 1.0f : 0.0f);
        this.Q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.Q.setAutoCancel(true);
        this.Q.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.k(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().c(z);
        setTextOnInternal(this.o);
        setTextOffInternal(this.q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.H = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f858b.a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.s != z) {
            this.s = z;
            requestLayout();
            if (z) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.n = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.f1156l = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.f1157m = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.q;
        if (string == null) {
            string = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
        }
        ViewCompat.L(this, string);
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.o;
        if (string == null) {
            string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
        }
        ViewCompat.L(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1145a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1145a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.z = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setThumbTextPadding(int i2) {
        this.f1155k = i2;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1146b = colorStateList;
        this.f1148d = true;
        a();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1147c = mode;
        this.f1149e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1150f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1150f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(AppCompatResources.b(i2, getContext()));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1151g = colorStateList;
        this.f1153i = true;
        b();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1152h = mode;
        this.f1154j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1145a || drawable == this.f1150f;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i2);
        this.f1146b = null;
        this.f1147c = null;
        this.f1148d = false;
        this.f1149e = false;
        this.f1151g = null;
        this.f1152h = null;
        this.f1153i = false;
        this.f1154j = false;
        this.x = VelocityTracker.obtain();
        this.H = true;
        this.C0 = new Rect();
        ThemeUtils.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(context, attributeSet, androidx.appcompat.R.styleable.SwitchCompat, i2);
        ViewCompat.y(this, context, androidx.appcompat.R.styleable.SwitchCompat, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        Drawable drawableB = tintTypedArrayF.b(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f1145a = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(this);
        }
        Drawable drawableB2 = tintTypedArrayF.b(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f1150f = drawableB2;
        if (drawableB2 != null) {
            drawableB2.setCallback(this);
        }
        int i3 = androidx.appcompat.R.styleable.SwitchCompat_android_textOn;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        setTextOnInternal(typedArray.getText(i3));
        setTextOffInternal(typedArray.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.s = typedArray.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f1155k = typedArray.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1156l = typedArray.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1157m = typedArray.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.n = typedArray.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListA = tintTypedArrayF.a(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateListA != null) {
            this.f1146b = colorStateListA;
            this.f1148d = true;
        }
        PorterDuff.Mode modeC = DrawableUtils.c(typedArray.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1147c != modeC) {
            this.f1147c = modeC;
            this.f1149e = true;
        }
        if (this.f1148d || this.f1149e) {
            a();
        }
        ColorStateList colorStateListA2 = tintTypedArrayF.a(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateListA2 != null) {
            this.f1151g = colorStateListA2;
            this.f1153i = true;
        }
        PorterDuff.Mode modeC2 = DrawableUtils.c(typedArray.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1152h != modeC2) {
            this.f1152h = modeC2;
            this.f1154j = true;
        }
        if (this.f1153i || this.f1154j) {
            b();
        }
        int resourceId = typedArray.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
            TintTypedArray tintTypedArray = new TintTypedArray(context, typedArrayObtainStyledAttributes);
            ColorStateList colorStateListA3 = tintTypedArray.a(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            if (colorStateListA3 != null) {
                this.J = colorStateListA3;
            } else {
                this.J = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f2 = dimensionPixelSize;
                if (f2 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f2);
                    requestLayout();
                }
            }
            int i4 = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1);
            int i5 = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1);
            Typeface typeface = i4 != 1 ? i4 != 2 ? i4 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i5 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typeface, i5);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i6 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i5;
                textPaint.setFakeBoldText((i6 & 1) != 0);
                textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
                this.M = new AllCapsTransformationMethod(getContext());
            } else {
                this.M = null;
            }
            setTextOnInternal(this.o);
            setTextOffInternal(this.q);
            tintTypedArray.g();
        }
        new AppCompatTextHelper(this).f(attributeSet, i2);
        tintTypedArrayF.g();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.u = viewConfiguration.getScaledTouchSlop();
        this.y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().a(attributeSet, i2);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
