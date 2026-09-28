package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes4.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void r() {
        EndCompoundLayout endCompoundLayout = this.f41305b;
        endCompoundLayout.o = null;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        checkableImageButton.setOnLongClickListener(null);
        IconHelper.d(checkableImageButton, null);
    }
}
