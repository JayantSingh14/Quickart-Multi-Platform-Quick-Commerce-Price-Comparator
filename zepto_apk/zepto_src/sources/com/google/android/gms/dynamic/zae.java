package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* loaded from: classes4.dex */
final class zae implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f22314a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f22315b;

    public zae(Context context, Intent intent) {
        this.f22314a = context;
        this.f22315b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f22314a.startActivity(this.f22315b);
        } catch (ActivityNotFoundException e2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e2);
        }
    }
}
