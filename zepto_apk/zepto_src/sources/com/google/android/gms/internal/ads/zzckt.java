package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* loaded from: classes4.dex */
public final class zzckt extends MutableContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public Activity f26469a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26470b;

    /* renamed from: c, reason: collision with root package name */
    public Context f26471c;

    public final void a(Intent intent) {
        if (this.f26469a == null) {
            intent.setFlags(268435456);
            this.f26470b.startActivity(intent);
            return;
        }
        String strValueOf = String.valueOf(intent.getData());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 63);
        sb.append("Starting activity for result with intent: ");
        sb.append(strValueOf);
        sb.append(" and requestCode: 236");
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        this.f26469a.startActivityForResult(intent, 236);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.f26471c.getSystemService(str);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f26470b = applicationContext;
        this.f26469a = context instanceof Activity ? (Activity) context : null;
        this.f26471c = context;
        super.setBaseContext(applicationContext);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        Activity activity = this.f26469a;
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            this.f26470b.startActivity(intent);
        }
    }
}
