package com.google.android.gms.ads.internal.overlay;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* loaded from: classes4.dex */
public final class zzu extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final ImageButton f21388a;

    /* renamed from: b, reason: collision with root package name */
    public final zzm f21389b;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzu(android.content.Context r7, com.google.android.gms.ads.internal.overlay.zzt r8, com.google.android.gms.ads.internal.overlay.zzm r9) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzu.<init>(android.content.Context, com.google.android.gms.ads.internal.overlay.zzt, com.google.android.gms.ads.internal.overlay.zzm):void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzm zzmVar = this.f21389b;
        if (zzmVar != null) {
            zzmVar.w = 2;
            zzmVar.f21360b.finish();
        }
    }
}
