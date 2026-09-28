package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes4.dex */
final class zzcio implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsPromptResult f26339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f26340b;

    public zzcio(JsPromptResult jsPromptResult, EditText editText) {
        this.f26339a = jsPromptResult;
        this.f26340b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f26339a.confirm(this.f26340b.getText().toString());
    }
}
