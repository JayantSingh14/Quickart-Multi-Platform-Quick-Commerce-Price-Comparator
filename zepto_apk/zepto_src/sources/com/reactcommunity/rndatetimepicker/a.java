package com.reactcommunity.rndatetimepicker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertDialog f46161a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f46162b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f46163c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f46164d;

    public /* synthetic */ a(AlertDialog alertDialog, FragmentActivity fragmentActivity, Bundle bundle, boolean z) {
        this.f46161a = alertDialog;
        this.f46162b = fragmentActivity;
        this.f46163c = bundle;
        this.f46164d = z;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        AlertDialog alertDialog = this.f46161a;
        Button button = alertDialog.getButton(-1);
        Button button2 = alertDialog.getButton(-2);
        Button button3 = alertDialog.getButton(-3);
        TypedValue typedValue = new TypedValue();
        FragmentActivity fragmentActivity = this.f46162b;
        fragmentActivity.getTheme().resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        int i2 = typedValue.resourceId;
        int color = i2 != 0 ? fragmentActivity.getColor(i2) : typedValue.data;
        Bundle bundle = this.f46163c;
        boolean z = this.f46164d;
        Common.e(button, "positive", bundle, z, color);
        Common.e(button2, "negative", bundle, z, color);
        Common.e(button3, "neutral", bundle, z, color);
    }
}
