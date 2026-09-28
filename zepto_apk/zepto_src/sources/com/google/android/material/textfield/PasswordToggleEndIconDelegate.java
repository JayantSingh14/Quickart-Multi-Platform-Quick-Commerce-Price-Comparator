package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;

/* loaded from: classes4.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* renamed from: e, reason: collision with root package name */
    public final int f41339e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f41340f;

    /* renamed from: g, reason: collision with root package name */
    public final a f41341g;

    public PasswordToggleEndIconDelegate(EndCompoundLayout endCompoundLayout, int i2) {
        super(endCompoundLayout);
        this.f41339e = R.drawable.design_password_eye;
        this.f41341g = new a(this, 2);
        if (i2 != 0) {
            this.f41339e = i2;
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int d() {
        return this.f41339e;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnClickListener f() {
        return this.f41341g;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean l() {
        EditText editText = this.f41340f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void m(EditText editText) {
        this.f41340f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void r() {
        EditText editText = this.f41340f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f41340f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void s() {
        EditText editText = this.f41340f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
