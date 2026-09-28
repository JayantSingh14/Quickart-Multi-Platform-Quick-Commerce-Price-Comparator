package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcuw extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27184a;

    /* renamed from: b, reason: collision with root package name */
    public View f27185b;

    public zzcuw(Context context) {
        super(context);
        this.f27184a = context;
    }

    public static zzcuw a(Context context, View view, zzfhr zzfhrVar) {
        ViewTreeObserver viewTreeObserver;
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcuw zzcuwVar = new zzcuw(context);
        List list = zzfhrVar.u;
        boolean zIsEmpty = list.isEmpty();
        Context context2 = zzcuwVar.f27184a;
        if (!zIsEmpty && (resources = context2.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            float f2 = ((zzfhs) list.get(0)).f31162a;
            float f3 = displayMetrics.density;
            zzcuwVar.setLayoutParams(new FrameLayout.LayoutParams((int) (f2 * f3), (int) (r5.f31163b * f3)));
        }
        zzcuwVar.f27185b = view;
        zzcuwVar.addView(view);
        zzceb zzcebVar = com.google.android.gms.ads.internal.zzt.C.B;
        zzced zzcedVar = new zzced(zzcuwVar, zzcuwVar);
        View view2 = (View) zzcedVar.f26001a.get();
        ViewTreeObserver viewTreeObserver2 = null;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver2 = viewTreeObserver;
        }
        if (viewTreeObserver2 != null) {
            zzcedVar.a(viewTreeObserver2);
        }
        zzceb.a(zzcuwVar, zzcuwVar);
        RelativeLayout relativeLayout = new RelativeLayout(context2);
        JSONObject jSONObject = zzfhrVar.h0;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzcuwVar.b(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcuwVar.b(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcuwVar.addView(relativeLayout);
        return zzcuwVar;
    }

    public final void b(JSONObject jSONObject, RelativeLayout relativeLayout, int i2) {
        Context context = this.f27184a;
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        double dOptDouble = jSONObject.optDouble("padding", 0.0d);
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbbVar.f21142a;
        int iB = com.google.android.gms.ads.internal.util.client.zzf.b((int) dOptDouble, context);
        textView.setPadding(0, iB, 0, iB);
        double dOptDouble2 = jSONObject.optDouble(Snapshot.HEIGHT, 15.0d);
        com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbbVar.f21142a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.google.android.gms.ads.internal.util.client.zzf.b((int) dOptDouble2, context));
        layoutParams.addRule(i2);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.f27185b.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.f27185b.setY(-r0[1]);
    }
}
