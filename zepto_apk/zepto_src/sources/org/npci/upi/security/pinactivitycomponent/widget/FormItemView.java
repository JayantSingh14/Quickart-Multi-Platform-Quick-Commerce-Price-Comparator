package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.fragment.app.e;
import java.lang.ref.WeakReference;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.pinactivitycomponent.GetCredential;
import org.npci.upi.security.pinactivitycomponent.R;

/* loaded from: classes5.dex */
public class FormItemView extends LinearLayout implements org.npci.upi.security.pinactivitycomponent.widget.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f57653a;

    /* renamed from: b, reason: collision with root package name */
    private String f57654b;

    /* renamed from: c, reason: collision with root package name */
    private String f57655c;

    /* renamed from: d, reason: collision with root package name */
    private int f57656d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f57657e;

    /* renamed from: f, reason: collision with root package name */
    private FormItemEditText f57658f;

    /* renamed from: g, reason: collision with root package name */
    private a f57659g;

    /* renamed from: h, reason: collision with root package name */
    private int f57660h;

    /* renamed from: i, reason: collision with root package name */
    private Object f57661i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f57662j;

    /* renamed from: k, reason: collision with root package name */
    private Button f57663k;

    /* renamed from: l, reason: collision with root package name */
    private ProgressBar f57664l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f57665m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private RelativeLayout t;
    private TextView u;
    private TextView v;
    private Context w;
    private int x;
    private boolean y;
    private String z;

    public interface a {
        void a(int i2, String str);

        void b(int i2);

        void b(View view, String str);
    }

    public FormItemView(Context context, Context context2) {
        super(context);
        this.f57653a = false;
        this.n = "";
        this.o = false;
        this.p = false;
        this.q = false;
        this.x = 0;
        this.y = true;
        a(context, (AttributeSet) null);
        this.w = context2;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public int e() {
        return this.x;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public Object getFormDataTag() {
        return this.f57661i;
    }

    public FormItemEditText getFormInputView() {
        return this.f57658f;
    }

    public a getFormItemListener() {
        return this.f57659g;
    }

    public int getInputLength() {
        return this.f57656d;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public String getInputValue() {
        return (this.f57653a || this.o) ? this.f57658f.getText().toString() : this.n;
    }

    public String getSubType() {
        return this.z;
    }

    public String getSubtype() {
        return this.z;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean getTextEntered() {
        return this.q;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean getToggleCheckBox() {
        return this.p;
    }

    public boolean getToggleCheckbox() {
        return this.p;
    }

    public void setActionBarPositionTop(boolean z) {
        this.s = z;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57662j.getLayoutParams();
        if (this.s) {
            layoutParams.addRule(10);
            layoutParams.addRule(8, 0);
        } else {
            layoutParams.addRule(10, 0);
            layoutParams.addRule(8, R.id.form_item_input);
        }
        this.f57662j.setLayoutParams(layoutParams);
    }

    public void setEducationalText(String str) {
        if (!this.z.equals(CLConstants.CREDTYPE_MPIN)) {
            this.u.setText(str);
            return;
        }
        this.u.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_info, 0, 0, 0);
        this.u.setText(str);
        this.u.setTextSize(15.0f);
        this.u.setTextColor(getResources().getColor(R.color.npci_text_primary_dark));
        this.u.setBackgroundResource(R.drawable.rounded_corner);
    }

    public void setForgotUpi(Boolean bool) {
        TextView textView;
        int i2;
        if (bool.booleanValue()) {
            textView = this.v;
            i2 = 0;
        } else {
            textView = this.v;
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public void setFormDataTag(Object obj) {
        this.f57661i = obj;
    }

    public void setFormItemListener(a aVar) {
        this.f57659g = aVar;
    }

    public void setFormItemTag(int i2) {
        this.f57660h = i2;
    }

    public void setInputLength(int i2) {
        this.f57658f.setMaxLength(i2);
        this.f57656d = i2;
    }

    public void setIsStateUnmasked(boolean z) {
        this.o = z;
    }

    public void setNonMaskedField() {
        this.f57653a = true;
    }

    public void setSubtype(String str) {
        this.z = str;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void setText(String str) {
        this.f57658f.setText(str);
        this.f57658f.setSelection(str.length());
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void setTextEntered(boolean z) {
        this.q = z;
    }

    public void setTitle(String str) {
        this.f57657e.setText(str);
        this.f57654b = str;
    }

    public void setToggleCheckBox(boolean z) {
        this.p = z;
    }

    public void setToggleCheckbox(Boolean bool) {
        this.p = bool.booleanValue();
    }

    public FormItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57653a = false;
        this.n = "";
        this.o = false;
        this.p = false;
        this.q = false;
        this.x = 0;
        this.y = true;
        a(context, attributeSet);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void b() {
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean c() {
        if (this.o) {
            this.o = false;
            this.f57658f.setText(this.n.replaceAll(CLConstants.DOT_SALT_DELIMETER, "●"));
        } else {
            this.o = true;
            setText(this.n);
        }
        return this.o;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean d() {
        this.p = !this.p;
        return this.p;
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItemView);
        if (typedArrayObtainStyledAttributes != null) {
            this.f57654b = typedArrayObtainStyledAttributes.getString(R.styleable.FormItemView_formTitle);
            this.f57655c = typedArrayObtainStyledAttributes.getString(R.styleable.FormItemView_formValidationError);
            this.f57656d = typedArrayObtainStyledAttributes.getInteger(R.styleable.FormItemView_formInputLength, 6);
            this.r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FormItemView_formActionOnTop, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        View.inflate(context, R.layout.layout_form_item, this);
        this.t = (RelativeLayout) findViewById(R.id.form_item_root);
        this.f57662j = (LinearLayout) findViewById(R.id.form_item_action_bar);
        this.f57657e = (TextView) findViewById(R.id.form_item_title);
        this.f57658f = (FormItemEditText) findViewById(R.id.form_item_input);
        this.f57663k = (Button) findViewById(R.id.form_item_button);
        this.f57664l = (ProgressBar) findViewById(R.id.form_item_progress);
        this.f57665m = (ImageView) findViewById(R.id.form_item_image);
        this.f57658f.setInputType(0);
        this.u = (TextView) findViewById(R.id.educational_info);
        this.v = (TextView) findViewById(R.id.forgot_upi);
        this.f57663k.setTextColor(getResources().getColor(R.color.npci_key_digit_color_alpha));
        setTitle(this.f57654b);
        setInputLength(this.f57656d);
        this.f57658f.addTextChangedListener(new TextWatcher() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FormItemView.this.x = editable.length();
                if (FormItemView.this.f57653a) {
                    if (editable.length() != 0) {
                        FormItemView.this.f57663k.setEnabled(true);
                        FormItemView.this.f57663k.setTextColor(FormItemView.this.getResources().getColor(R.color.npci_key_digit_color));
                    }
                    FormItemView.this.n = editable.toString();
                    return;
                }
                if (FormItemView.this.o) {
                    if (editable.length() == 0) {
                        if (FormItemView.this.y) {
                            FormItemView.this.f57663k.setCompoundDrawablesWithIntrinsicBounds(FormItemView.this.getResources().getDrawable(R.drawable.ic_visibility_off_blue_24px), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        FormItemView.this.f57663k.setEnabled(false);
                        FormItemView.this.f57663k.setTextColor(FormItemView.this.getResources().getColor(R.color.npci_key_digit_color_alpha));
                    } else {
                        if (FormItemView.this.y) {
                            FormItemView.this.f57663k.setCompoundDrawablesWithIntrinsicBounds(FormItemView.this.getResources().getDrawable(R.drawable.ic_visibility_off), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        FormItemView.this.f57663k.setTextColor(FormItemView.this.getResources().getColor(R.color.npci_key_digit_color));
                        FormItemView.this.f57663k.setEnabled(true);
                    }
                    FormItemView.this.n = editable.toString();
                    return;
                }
                if (editable.length() == 0) {
                    if (FormItemView.this.y) {
                        FormItemView.this.f57663k.setCompoundDrawablesWithIntrinsicBounds(FormItemView.this.getResources().getDrawable(R.drawable.ic_visibility_blue_24px), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                    FormItemView.this.f57663k.setEnabled(false);
                    FormItemView.this.f57663k.setTextColor(FormItemView.this.getResources().getColor(R.color.npci_key_digit_color_alpha));
                    FormItemView.this.n = "";
                    return;
                }
                if (FormItemView.this.y) {
                    FormItemView.this.f57663k.setCompoundDrawablesWithIntrinsicBounds(FormItemView.this.getResources().getDrawable(R.drawable.ic_visibility_on), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                FormItemView.this.f57663k.setTextColor(FormItemView.this.getResources().getColor(R.color.npci_key_digit_color));
                FormItemView.this.f57663k.setEnabled(true);
                if (FormItemView.this.n.length() > editable.length()) {
                    FormItemView formItemView = FormItemView.this;
                    formItemView.n = formItemView.n.substring(0, FormItemView.this.n.length() - 1);
                    return;
                }
                char cCharAt = editable.toString().charAt(editable.length() - 1);
                if (cCharAt == 9679) {
                    FormItemView.this.f57658f.setSelection(editable.length());
                    return;
                }
                FormItemView formItemView2 = FormItemView.this;
                formItemView2.n = formItemView2.n.concat("" + cCharAt);
                FormItemView.this.f57658f.setText(FormItemView.this.n.replaceAll(CLConstants.DOT_SALT_DELIMETER, "●"));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() > 0 && !FormItemView.this.getSubtype().equals(CLConstants.CREDTYPE_DEBIT)) {
                    FormItemView.this.f57663k.setVisibility(8);
                }
                if (FormItemView.this.f57659g == null || FormItemView.this.f57658f.getText() == null || FormItemView.this.f57658f.getText().length() < FormItemView.this.f57656d) {
                    return;
                }
                FormItemView.this.f57659g.a(FormItemView.this.f57660h, FormItemView.this.f57658f.getText().toString());
            }
        });
        this.f57658f.setOnTouchListener(new View.OnTouchListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FormItemView.this.f57659g == null || motionEvent.getAction() != 1) {
                    return false;
                }
                FormItemView.this.f57659g.b(FormItemView.this.f57660h);
                return false;
            }
        });
        setActionBarPositionTop(this.r);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((GetCredential) FormItemView.this.w).getCredBlockBuilder().g().c().send(3, e.i("action", "FORGOT_UPI_PIN"));
                ((GetCredential) FormItemView.this.w).finish();
            }
        });
    }

    public void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            this.f57665m.setImageDrawable(drawable);
        }
        a(this.f57665m, z);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void a(String str) {
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.f57663k.setText(str);
        }
        if (str.equals(getResources().getString(R.string.action_resend_bank_otp)) || str.equals(getContext().getString(R.string.maestro_card)) || str.equals(getResources().getString(R.string.edit_card_number))) {
            this.f57663k.setTextColor(getResources().getColor(R.color.npci_key_digit_color));
            this.y = false;
        }
        Button button = this.f57663k;
        Drawable drawable2 = i2 == 0 ? drawable : null;
        Drawable drawable3 = i2 == 1 ? drawable : null;
        Drawable drawable4 = i2 == 2 ? drawable : null;
        if (i2 != 3) {
            drawable = null;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        this.f57663k.setOnClickListener(onClickListener);
        this.f57663k.setEnabled(z2);
        a(this.f57663k, z);
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z, boolean z2) {
        this.f57663k.setTextColor(getResources().getColor(R.color.npci_key_digit_color));
        if (!TextUtils.isEmpty(str)) {
            this.f57663k.setText(str);
        }
        a(this.f57663k, z);
        this.f57663k.setEnabled(z2);
        this.f57663k.setOnClickListener(onClickListener);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean a() {
        this.f57658f.requestFocus();
        return true;
    }

    public void a(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = a(this.f57664l, z);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        View view = (View) viewPropertyAnimatorCompatA.f3117a.get();
        if (view != null) {
            view.animate().setInterpolator(accelerateDecelerateInterpolator);
        }
        View view2 = (View) viewPropertyAnimatorCompatA.f3117a.get();
        if (view2 != null) {
            view2.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat a(View view, final boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = ViewCompat.a(view);
        float f2 = z ? 1.0f : 0.0f;
        WeakReference weakReference = viewPropertyAnimatorCompatA.f3117a;
        View view2 = (View) weakReference.get();
        if (view2 != null) {
            view2.animate().scaleY(f2);
        }
        float f3 = z ? 1.0f : 0.0f;
        View view3 = (View) weakReference.get();
        if (view3 != null) {
            view3.animate().scaleX(f3);
        }
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        View view4 = (View) weakReference.get();
        if (view4 != null) {
            view4.animate().setInterpolator(accelerateInterpolator);
        }
        viewPropertyAnimatorCompatA.d(new ViewPropertyAnimatorListenerAdapter() { // from class: org.npci.upi.security.pinactivitycomponent.widget.FormItemView.4
            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view5) {
                view5.setVisibility(z ? 0 : 8);
            }
        });
        viewPropertyAnimatorCompatA.a(z ? 1.0f : 0.5f);
        return viewPropertyAnimatorCompatA;
    }
}
