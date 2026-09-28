package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.pinactivitycomponent.R;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;

/* loaded from: classes5.dex */
public class FormItemPager extends FrameLayout implements a {

    /* renamed from: a, reason: collision with root package name */
    protected long f57648a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<FormItemView> f57649b;

    /* renamed from: c, reason: collision with root package name */
    private int f57650c;

    /* renamed from: d, reason: collision with root package name */
    private int f57651d;

    /* renamed from: e, reason: collision with root package name */
    private Object f57652e;

    public FormItemPager(Context context) {
        super(context);
        this.f57648a = 3000L;
    }

    private void a(View view) {
        view.animate().x(0.0f);
    }

    private void h() {
        for (int i2 = 0; i2 < this.f57649b.size(); i2++) {
            this.f57649b.get(i2).setText("");
        }
        g();
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void b() {
        setToPrevious();
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean c() {
        return this.f57649b.get(this.f57650c).c();
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean d() {
        return this.f57649b.get(this.f57650c).d();
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public int e() {
        return getInputValue().length();
    }

    public boolean f() {
        if (this.f57650c >= this.f57649b.size() - 1) {
            return false;
        }
        Button button = (Button) this.f57649b.get(this.f57650c + 1).findViewById(R.id.form_item_button);
        button.setEnabled(false);
        button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_visibility_blue_24px), (Drawable) null, (Drawable) null, (Drawable) null);
        button.setText(R.string.action_show);
        this.f57649b.get(this.f57650c).setIsStateUnmasked(false);
        a((View) this.f57649b.get(this.f57650c), true);
        a(this.f57649b.get(this.f57650c + 1));
        int i2 = this.f57650c + 1;
        this.f57650c = i2;
        this.f57649b.get(i2).requestFocus();
        return true;
    }

    public boolean g() {
        int i2 = this.f57650c;
        if (i2 == 0) {
            return false;
        }
        Button button = (Button) this.f57649b.get(i2 - 1).findViewById(R.id.form_item_button);
        button.setEnabled(false);
        button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_visibility_blue_24px), (Drawable) null, (Drawable) null, (Drawable) null);
        button.setText(R.string.action_show);
        this.f57649b.get(this.f57650c).setIsStateUnmasked(false);
        a((View) this.f57649b.get(this.f57650c), false);
        a(this.f57649b.get(this.f57650c - 1));
        int i3 = this.f57650c - 1;
        this.f57650c = i3;
        this.f57649b.get(i3).requestFocus();
        return true;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public Object getFormDataTag() {
        Object obj = this.f57652e;
        return obj == null ? this.f57649b.get(0).getFormDataTag() : obj;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public String getInputValue() {
        if (!this.f57649b.get(0).getSubtype().equals(CLConstants.CREDTYPE_DEBIT)) {
            return this.f57649b.get(0).getInputValue();
        }
        String string = "";
        for (int i2 = 0; i2 < this.f57649b.size(); i2++) {
            if (i2 == 1 && this.f57649b.get(0).getToggleCheckbox()) {
                string = b.k(string, CLConstants.MAESTRO_NUMBER);
            } else {
                StringBuilder sbW = b.w(string);
                sbW.append(this.f57649b.get(i2).getInputValue());
                string = sbW.toString();
            }
        }
        return string;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean getTextEntered() {
        return this.f57649b.get(this.f57650c).getTextEntered();
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean getToggleCheckBox() {
        return this.f57649b.get(this.f57650c).getToggleCheckBox();
    }

    public void setFormDataTag(Object obj) {
        this.f57652e = obj;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void setText(String str) {
        for (int i2 = 0; i2 < this.f57649b.size(); i2++) {
            this.f57649b.get(i2).setText(str);
        }
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void setTextEntered(boolean z) {
        this.f57649b.get(this.f57650c).setTextEntered(z);
    }

    public void setToPrevious() {
        int i2 = this.f57650c;
        if (i2 == 0) {
            return;
        }
        a((View) this.f57649b.get(i2), false);
        a(this.f57649b.get(this.f57650c - 1));
        int i3 = this.f57650c - 1;
        this.f57650c = i3;
        this.f57649b.get(i3).requestFocus();
    }

    public void setToggleCheckBox(boolean z) {
        this.f57649b.get(this.f57650c).setToggleCheckBox(z);
    }

    public FormItemPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57648a = 3000L;
    }

    private void a(View view, boolean z) {
        view.animate().x(z ? this.f57651d * (-1) : this.f57651d);
    }

    public FormItemPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f57648a = 3000L;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void a(String str) {
        this.f57649b.get(0).getFormItemListener().b(this, str);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public boolean a() {
        FormItemView.a formItemListener;
        Context context;
        int i2;
        String inputValue = this.f57649b.get(this.f57650c).getInputValue();
        if (this.f57649b.get(this.f57650c).getInputLength() != inputValue.length()) {
            if (!this.f57649b.get(0).getSubtype().equals(CLConstants.CREDTYPE_DEBIT)) {
                this.f57649b.get(0).getFormItemListener().b(this, getContext().getString(R.string.component_message));
                this.f57649b.get(this.f57650c).requestFocus();
                return false;
            }
            if (this.f57650c == 0) {
                formItemListener = this.f57649b.get(0).getFormItemListener();
                context = getContext();
                i2 = R.string.error_message_card_no;
            } else {
                formItemListener = this.f57649b.get(0).getFormItemListener();
                context = getContext();
                i2 = R.string.error_message_card_validity;
            }
            formItemListener.b(this, context.getString(i2));
            return false;
        }
        if (this.f57650c != this.f57649b.size() - 1) {
            if (this.f57649b.get(this.f57650c).getToggleCheckbox()) {
                return true;
            }
            this.f57649b.get(this.f57650c).setTextEntered(true);
            return !f();
        }
        this.f57649b.get(this.f57650c).requestFocus();
        for (int i3 = 0; i3 < this.f57649b.size(); i3++) {
            if (this.f57649b.get(0).getSubtype().equals(CLConstants.CREDTYPE_DEBIT)) {
                this.f57649b.get(this.f57650c).setTextEntered(true);
                return true;
            }
            if (!this.f57649b.get(i3).getInputValue().equals(inputValue)) {
                h();
                this.f57649b.get(i3).getFormItemListener().b(this, getContext().getString(R.string.info_pin_not_match));
                return false;
            }
        }
        return true;
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.a
    public void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2) {
        for (int i3 = 0; i3 < this.f57649b.size(); i3++) {
            if (this.f57649b.get(i3).getSubtype().equals(CLConstants.CREDTYPE_DEBIT)) {
                this.f57649b.get(i3).setNonMaskedField();
                if (i3 == 0) {
                    this.f57649b.get(i3).a(getContext().getString(R.string.maestro_card), drawable, onClickListener, i2, z, z2);
                } else if (i3 == 1) {
                    Drawable drawable2 = getContext().getDrawable(R.drawable.ic_edit_icon);
                    this.f57649b.get(i3).setTitle(getContext().getString(R.string.card_expiry_title, this.f57649b.get(0).getInputValue()));
                    this.f57649b.get(i3).a(getContext().getString(R.string.edit_card_number), drawable2, onClickListener, i2, z, z2);
                }
            } else {
                this.f57649b.get(i3).a(str, drawable, onClickListener, i2, z, z2);
            }
        }
    }

    public void a(ArrayList<FormItemView> arrayList, FormItemView.a aVar) {
        this.f57649b = arrayList;
        addView(arrayList.get(0));
        this.f57649b.get(0).setFormItemListener(aVar);
        this.f57650c = 0;
        this.f57651d = getResources().getDisplayMetrics().widthPixels;
        for (int i2 = 1; i2 < this.f57649b.size(); i2++) {
            FormItemView formItemView = this.f57649b.get(i2);
            formItemView.setFormItemListener(aVar);
            float f2 = this.f57651d;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            formItemView.setX(f2);
            addView(formItemView);
        }
    }
}
