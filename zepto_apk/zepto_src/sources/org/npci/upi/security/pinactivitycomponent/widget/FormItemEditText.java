package org.npci.upi.security.pinactivitycomponent.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class FormItemEditText extends EditText {
    private int[][] A;
    private int[] B;
    private ColorStateList C;

    /* renamed from: a, reason: collision with root package name */
    private String f57627a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f57628b;

    /* renamed from: c, reason: collision with root package name */
    private String f57629c;

    /* renamed from: d, reason: collision with root package name */
    private int f57630d;

    /* renamed from: e, reason: collision with root package name */
    private float f57631e;

    /* renamed from: f, reason: collision with root package name */
    private float f57632f;

    /* renamed from: g, reason: collision with root package name */
    private float f57633g;

    /* renamed from: h, reason: collision with root package name */
    private float f57634h;

    /* renamed from: i, reason: collision with root package name */
    private int f57635i;

    /* renamed from: j, reason: collision with root package name */
    private RectF[] f57636j;

    /* renamed from: k, reason: collision with root package name */
    private float[] f57637k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f57638l;

    /* renamed from: m, reason: collision with root package name */
    private Paint f57639m;
    private Paint n;
    private Drawable o;
    private Rect p;
    private boolean q;
    private View.OnClickListener r;
    private a s;
    private boolean t;
    private float u;
    private float v;
    private Paint w;
    private boolean x;
    private boolean y;
    private ColorStateList z;

    public interface a {
        void a(CharSequence charSequence);
    }

    public FormItemEditText(Context context) {
        super(context);
        this.f57627a = null;
        this.f57628b = null;
        this.f57629c = null;
        this.f57630d = 0;
        this.f57631e = 24.0f;
        this.f57633g = 4.0f;
        this.f57634h = 8.0f;
        this.f57635i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = null;
        this.u = 1.0f;
        this.v = 2.0f;
        this.x = false;
        this.y = false;
        this.A = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.C = new ColorStateList(this.A, this.B);
    }

    private CharSequence getFullText() {
        return this.f57627a == null ? getText() : getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.f57628b == null) {
            this.f57628b = new StringBuilder();
        }
        int length = getText().length();
        while (this.f57628b.length() != length) {
            if (this.f57628b.length() < length) {
                this.f57628b.append(this.f57627a);
            } else {
                this.f57628b.deleteCharAt(r1.length() - 1);
            }
        }
        return this.f57628b;
    }

    public int a(float f2) {
        return (int) (f2 * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence charSequence;
        int i2;
        int i3;
        float f2;
        float f3;
        Paint paint;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(fullText, 0, length, fArr);
        String str = this.f57629c;
        float f4 = 0.0f;
        if (str != null) {
            int length2 = str.length();
            float[] fArr2 = new float[length2];
            getPaint().getTextWidths(this.f57629c, fArr2);
            for (int i4 = 0; i4 < length2; i4++) {
                f4 += fArr2[i4];
            }
        }
        float f5 = f4;
        int i5 = 0;
        while (i5 < this.f57633g) {
            if (this.o != null) {
                b(i5 < length, i5 == length);
                Drawable drawable = this.o;
                RectF rectF = this.f57636j[i5];
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.o.draw(canvas);
            }
            float f6 = (this.f57632f / 2.0f) + this.f57636j[i5].left;
            if (length > i5) {
                if (this.x && i5 == length - 1) {
                    i3 = i5 + 1;
                    f2 = f6 - (fArr[i5] / 2.0f);
                    f3 = this.f57637k[i5];
                    paint = this.f57639m;
                } else {
                    i3 = i5 + 1;
                    f2 = f6 - (fArr[i5] / 2.0f);
                    f3 = this.f57637k[i5];
                    paint = this.f57638l;
                }
                canvas.drawText(fullText, i5, i3, f2, f3, paint);
                charSequence = fullText;
                i2 = i5;
            } else {
                charSequence = fullText;
                i2 = i5;
                String str2 = this.f57629c;
                if (str2 != null) {
                    canvas.drawText(str2, f6 - (f5 / 2.0f), this.f57637k[i2], this.n);
                }
            }
            if (this.o == null) {
                a(i2 < length, i2 == length);
                RectF rectF2 = this.f57636j[i2];
                canvas.drawLine(rectF2.left, rectF2.top + 20.0f, rectF2.right, 20.0f + rectF2.bottom, this.w);
            }
            i5 = i2 + 1;
            fullText = charSequence;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSizeChanged(int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.onSizeChanged(int, int, int, int):void");
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        setError(false);
        if (this.f57636j == null || !this.x) {
            if (this.s == null || charSequence.length() != this.f57635i) {
                return;
            }
            this.s.a(charSequence);
            return;
        }
        int i5 = this.f57630d;
        if (i5 == -1) {
            invalidate();
        } else if (i4 > i3) {
            if (i5 == 0) {
                a(charSequence);
            } else {
                a(charSequence, i2);
            }
        }
    }

    public void setAnimateText(boolean z) {
        this.x = z;
    }

    public void setCharSize(float f2) {
        this.f57632f = f2;
        invalidate();
    }

    public void setColorStates(ColorStateList colorStateList) {
        this.C = colorStateList;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setError(boolean z) {
        this.y = z;
    }

    public void setFontSize(float f2) {
        this.f57638l.setTextSize(f2);
        this.f57639m.setTextSize(f2);
        this.n.setTextSize(f2);
    }

    public void setLineStroke(float f2) {
        this.u = f2;
        invalidate();
    }

    public void setLineStrokeCentered(boolean z) {
        this.t = z;
        invalidate();
    }

    public void setLineStrokeSelected(float f2) {
        this.v = f2;
        invalidate();
    }

    public void setMargin(int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        setLayoutParams(marginLayoutParams);
    }

    public void setMaxLength(int i2) {
        this.f57635i = i2;
        this.f57633g = i2;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setOnPinEnteredListener(a aVar) {
        this.s = aVar;
    }

    public void setSpace(float f2) {
        this.f57631e = f2;
        invalidate();
    }

    public FormItemEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57627a = null;
        this.f57628b = null;
        this.f57629c = null;
        this.f57630d = 0;
        this.f57631e = 24.0f;
        this.f57633g = 4.0f;
        this.f57634h = 8.0f;
        this.f57635i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = null;
        this.u = 1.0f;
        this.v = 2.0f;
        this.x = false;
        this.y = false;
        this.A = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.C = new ColorStateList(this.A, this.B);
        a(context, attributeSet);
    }

    private int a(int... iArr) {
        return this.C.getColorForState(iArr, -7829368);
    }

    private void b(boolean z, boolean z2) {
        if (this.y) {
            this.o.setState(new int[]{R.attr.state_active});
            return;
        }
        if (!isFocused()) {
            this.o.setState(new int[]{-16842908});
            return;
        }
        this.o.setState(new int[]{R.attr.state_focused});
        if (z2) {
            this.o.setState(new int[]{R.attr.state_focused, R.attr.state_selected});
        } else if (z) {
            this.o.setState(new int[]{R.attr.state_focused, R.attr.state_checked});
        }
    }

    public FormItemEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f57627a = null;
        this.f57628b = null;
        this.f57629c = null;
        this.f57630d = 0;
        this.f57631e = 24.0f;
        this.f57633g = 4.0f;
        this.f57634h = 8.0f;
        this.f57635i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = null;
        this.u = 1.0f;
        this.v = 2.0f;
        this.x = false;
        this.y = false;
        this.A = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.C = new ColorStateList(this.A, this.B);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public FormItemEditText(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f57627a = null;
        this.f57628b = null;
        this.f57629c = null;
        this.f57630d = 0;
        this.f57631e = 24.0f;
        this.f57633g = 4.0f;
        this.f57634h = 8.0f;
        this.f57635i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = null;
        this.u = 1.0f;
        this.v = 2.0f;
        this.x = false;
        this.y = false;
        this.A = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.C = new ColorStateList(this.A, this.B);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.u = a(this.u);
        this.v = a(this.v);
        this.f57631e = a(this.f57631e);
        this.f57634h = a(this.f57634h);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainStyledAttributes.getValue(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinAnimationType, typedValue);
            this.f57630d = typedValue.data;
            this.f57627a = typedArrayObtainStyledAttributes.getString(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinCharacterMask);
            this.f57629c = typedArrayObtainStyledAttributes.getString(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinRepeatedHint);
            this.u = typedArrayObtainStyledAttributes.getDimension(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinLineStroke, this.u);
            this.v = typedArrayObtainStyledAttributes.getDimension(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinLineStrokeSelected, this.v);
            this.t = typedArrayObtainStyledAttributes.getBoolean(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinLineStrokeCentered, false);
            this.f57632f = typedArrayObtainStyledAttributes.getDimension(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinCharacterSize, 0.0f);
            this.f57631e = typedArrayObtainStyledAttributes.getDimension(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinCharacterSpacing, this.f57631e);
            this.f57634h = typedArrayObtainStyledAttributes.getDimension(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinTextBottomPadding, this.f57634h);
            this.q = typedArrayObtainStyledAttributes.getBoolean(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinBackgroundIsSquare, this.q);
            this.o = typedArrayObtainStyledAttributes.getDrawable(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinBackgroundDrawable);
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(org.npci.upi.security.pinactivitycomponent.R.styleable.FormItemEditText_pinLineColors);
            if (colorStateList != null) {
                this.C = colorStateList;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f57638l = new Paint(getPaint());
            this.f57639m = new Paint(getPaint());
            this.n = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.w = paint;
            paint.setStrokeWidth(this.u);
            setFontSize(this.f57632f);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(org.npci.upi.security.pinactivitycomponent.R.attr.colorControlActivated, typedValue2, true);
            int i2 = typedValue2.data;
            int[] iArr = this.B;
            iArr[0] = i2;
            iArr[1] = -7829368;
            iArr[2] = -7829368;
            setBackgroundResource(0);
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 4);
            this.f57635i = attributeIntValue;
            this.f57633g = attributeIntValue;
            super.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormItemEditText formItemEditText = FormItemEditText.this;
                    formItemEditText.setSelection(formItemEditText.getText().length());
                    if (FormItemEditText.this.r != null) {
                        FormItemEditText.this.r.onClick(view);
                    }
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    FormItemEditText formItemEditText = FormItemEditText.this;
                    formItemEditText.setSelection(formItemEditText.getText().length());
                    return true;
                }
            });
            if (((getInputType() & 128) == 128 && TextUtils.isEmpty(this.f57627a)) || ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.f57627a))) {
                this.f57627a = "●";
            }
            if (!TextUtils.isEmpty(this.f57627a)) {
                this.f57628b = getMaskChars();
            }
            getPaint().getTextBounds(CLConstants.SALT_DELIMETER, 0, 1, this.p);
            this.x = this.f57630d > -1;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @TargetApi(11)
    private void a(CharSequence charSequence) {
        this.f57639m.setAlpha(WKSRecord.Service.LOCUS_MAP);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(WKSRecord.Service.LOCUS_MAP, 255);
        valueAnimatorOfInt.setDuration(150L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FormItemEditText.this.f57639m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                FormItemEditText.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f57635i && this.s != null) {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FormItemEditText.this.s.a(FormItemEditText.this.getText());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
        animatorSet.playTogether(valueAnimatorOfInt);
        animatorSet.start();
    }

    @TargetApi(11)
    private void a(CharSequence charSequence, final int i2) {
        float[] fArr = this.f57637k;
        float f2 = this.f57636j[i2].bottom - this.f57634h;
        fArr[i2] = f2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getPaint().getTextSize() + f2, this.f57637k[i2]);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FormItemEditText.this.f57637k[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FormItemEditText.this.invalidate();
            }
        });
        this.f57639m.setAlpha(255);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FormItemEditText.this.f57639m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f57635i && this.s != null) {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemEditText.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FormItemEditText.this.s.a(FormItemEditText.this.getText());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        animatorSet.start();
    }

    private void a(boolean z, boolean z2) {
        if (this.y) {
            this.w.setColor(a(R.attr.state_active));
            return;
        }
        this.w.setStrokeWidth(isFocused() ? this.v : this.u);
        if (z) {
            this.w.setColor(a(R.attr.state_selected));
            return;
        }
        boolean zIsFocused = isFocused();
        if (z2) {
            this.w.setColor(zIsFocused ? a(R.attr.state_last) : a(-16842918));
        } else {
            this.w.setColor(zIsFocused ? a(R.attr.state_focused) : a(-16842908));
        }
    }
}
