package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzat;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzi extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final zzat f21351a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21352b;

    public zzi(Context context, String str, String str2, String str3) {
        super(context);
        zzat zzatVar = new zzat(context);
        zzatVar.f21488c = str;
        this.f21351a = zzatVar;
        zzatVar.f21490e = str2;
        zzatVar.f21489d = str3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f21352b) {
            return false;
        }
        this.f21351a.a(motionEvent);
        return false;
    }
}
