package com.google.android.material.textfield;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41375a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f41376b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i2) {
        this.f41375a = i2;
        this.f41376b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f41375a) {
            case 0:
                ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.f41376b;
                EditText editText = clearTextEndIconDelegate.f41267i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    clearTextEndIconDelegate.q();
                    break;
                }
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f41376b).u();
                break;
            default:
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = (PasswordToggleEndIconDelegate) this.f41376b;
                EditText editText2 = passwordToggleEndIconDelegate.f41340f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = passwordToggleEndIconDelegate.f41340f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        passwordToggleEndIconDelegate.f41340f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        passwordToggleEndIconDelegate.f41340f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        passwordToggleEndIconDelegate.f41340f.setSelection(selectionEnd);
                    }
                    passwordToggleEndIconDelegate.q();
                    break;
                }
                break;
        }
    }
}
