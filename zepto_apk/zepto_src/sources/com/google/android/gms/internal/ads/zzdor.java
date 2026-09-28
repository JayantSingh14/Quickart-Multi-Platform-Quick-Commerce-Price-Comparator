package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdor implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzdsp f28124a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f28125b;

    /* renamed from: c, reason: collision with root package name */
    public zzblp f28126c;

    /* renamed from: d, reason: collision with root package name */
    public zzbnn f28127d;

    /* renamed from: e, reason: collision with root package name */
    public String f28128e;

    /* renamed from: f, reason: collision with root package name */
    public Long f28129f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f28130g;

    public zzdor(zzdsp zzdspVar, Clock clock) {
        this.f28124a = zzdspVar;
        this.f28125b = clock;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        WeakReference weakReference = this.f28130g;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.f28128e != null && this.f28129f != null) {
            HashMap map = new HashMap();
            map.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, this.f28128e);
            map.put("time_interval", String.valueOf(this.f28125b.currentTimeMillis() - this.f28129f.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.f28124a.d(map);
        }
        this.f28128e = null;
        this.f28129f = null;
        WeakReference weakReference2 = this.f28130g;
        if (weakReference2 == null || (view2 = (View) weakReference2.get()) == null) {
            return;
        }
        view2.setClickable(false);
        view2.setOnClickListener(null);
        this.f28130g = null;
    }
}
