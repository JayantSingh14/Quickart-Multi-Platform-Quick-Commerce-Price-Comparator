package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* loaded from: classes3.dex */
public class CardView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f1367f = {R.attr.colorBackground};

    /* renamed from: g, reason: collision with root package name */
    public static final CardViewApi21Impl f1368g = new CardViewApi21Impl();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1369a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1370b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1371c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f1372d;

    /* renamed from: e, reason: collision with root package name */
    public final AnonymousClass1 f1373e;

    /* renamed from: androidx.cardview.widget.CardView$1, reason: invalid class name */
    public class AnonymousClass1 implements CardViewDelegate {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f1374a;

        public AnonymousClass1() {
        }

        public final void a(int i2, int i3, int i4, int i5) {
            CardView cardView = CardView.this;
            cardView.f1372d.set(i2, i3, i4, i5);
            Rect rect = cardView.f1371c;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public final void f(int i2, int i3, int i4, int i5) {
        this.f1371c.set(i2, i3, i4, i5);
        f1368g.b(this.f1373e);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return ((RoundRectDrawable) this.f1373e.f1374a).f1383h;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    @Px
    public int getContentPaddingBottom() {
        return this.f1371c.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.f1371c.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.f1371c.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.f1371c.top;
    }

    public float getMaxCardElevation() {
        return ((RoundRectDrawable) this.f1373e.f1374a).f1380e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1370b;
    }

    public float getRadius() {
        return ((RoundRectDrawable) this.f1373e.f1374a).f1376a;
    }

    public boolean getUseCompatPadding() {
        return this.f1369a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        AnonymousClass1 anonymousClass1 = this.f1373e;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) anonymousClass1.f1374a;
        if (colorStateListValueOf == null) {
            roundRectDrawable.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        roundRectDrawable.f1383h = colorStateListValueOf;
        roundRectDrawable.f1377b.setColor(colorStateListValueOf.getColorForState(roundRectDrawable.getState(), roundRectDrawable.f1383h.getDefaultColor()));
        roundRectDrawable.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        CardView.this.setElevation(f2);
    }

    public void setMaxCardElevation(float f2) {
        f1368g.a(this.f1373e, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1370b) {
            this.f1370b = z;
            CardViewApi21Impl cardViewApi21Impl = f1368g;
            AnonymousClass1 anonymousClass1 = this.f1373e;
            cardViewApi21Impl.a(anonymousClass1, ((RoundRectDrawable) anonymousClass1.f1374a).f1380e);
        }
    }

    public void setRadius(float f2) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) this.f1373e.f1374a;
        if (f2 == roundRectDrawable.f1376a) {
            return;
        }
        roundRectDrawable.f1376a = f2;
        roundRectDrawable.b(null);
        roundRectDrawable.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1369a != z) {
            this.f1369a = z;
            CardViewApi21Impl cardViewApi21Impl = f1368g;
            AnonymousClass1 anonymousClass1 = this.f1373e;
            cardViewApi21Impl.a(anonymousClass1, ((RoundRectDrawable) anonymousClass1.f1374a).f1380e);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.f1371c = rect;
        this.f1372d = new Rect();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.f1373e = anonymousClass1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i2, androidx.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(androidx.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1367f);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(androidx.cardview.R.color.cardview_light_background) : getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1369a = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f1370b = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        CardViewApi21Impl cardViewApi21Impl = f1368g;
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(colorStateListValueOf, dimension);
        anonymousClass1.f1374a = roundRectDrawable;
        setBackgroundDrawable(roundRectDrawable);
        setClipToOutline(true);
        setElevation(dimension2);
        cardViewApi21Impl.a(anonymousClass1, dimension3);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) this.f1373e.f1374a;
        if (colorStateList == null) {
            roundRectDrawable.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        roundRectDrawable.f1383h = colorStateList;
        roundRectDrawable.f1377b.setColor(colorStateList.getColorForState(roundRectDrawable.getState(), roundRectDrawable.f1383h.getDefaultColor()));
        roundRectDrawable.invalidateSelf();
    }
}
