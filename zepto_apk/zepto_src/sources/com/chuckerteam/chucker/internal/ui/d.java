package com.chuckerteam.chucker.internal.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import in.juspay.airborne.ota.Constants;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16896a;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = MainActivity.p;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        MainActivity mainActivity = this.f16896a;
        intent.setData(Uri.fromParts(Constants.PACKAGE_DIR_NAME, mainActivity.getPackageName(), null));
        mainActivity.startActivity(intent);
    }
}
