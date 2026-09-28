package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import coil3.network.internal.UtilsKt;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeak;
import com.google.android.gms.internal.ads.zzfxl;
import com.google.android.gms.internal.ads.zzgyw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzat {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21486a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeak f21487b;

    /* renamed from: c, reason: collision with root package name */
    public String f21488c;

    /* renamed from: d, reason: collision with root package name */
    public String f21489d;

    /* renamed from: e, reason: collision with root package name */
    public String f21490e;

    /* renamed from: f, reason: collision with root package name */
    public String f21491f;

    /* renamed from: h, reason: collision with root package name */
    public final int f21493h;

    /* renamed from: i, reason: collision with root package name */
    public PointF f21494i;

    /* renamed from: j, reason: collision with root package name */
    public PointF f21495j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfxl f21496k;

    /* renamed from: g, reason: collision with root package name */
    public int f21492g = 0;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f21497l = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzas
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            zzat zzatVar = this.f21485a;
            zzatVar.f21492g = 4;
            zzatVar.b();
        }
    };

    public zzat(Context context) {
        this.f21486a = context;
        this.f21493h = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zztVar.t.a();
        this.f21496k = zztVar.t.f21537b;
        this.f21487b = zztVar.o.f21511g;
    }

    public static final int e(String str, ArrayList arrayList, boolean z) {
        if (!z) {
            return -1;
        }
        arrayList.add(str);
        return arrayList.size() - 1;
    }

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f21492g = 0;
            this.f21494i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i2 = this.f21492g;
        if (i2 == -1) {
            return;
        }
        Runnable runnable = this.f21497l;
        zzfxl zzfxlVar = this.f21496k;
        if (i2 == 0) {
            if (actionMasked == 5) {
                this.f21492g = 5;
                this.f21495j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                zzfxlVar.postDelayed(runnable, ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C5)).longValue());
                return;
            }
            return;
        }
        if (i2 == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z = false;
                for (int i3 = 0; i3 < historySize; i3++) {
                    z |= !c(motionEvent.getHistoricalX(0, i3), motionEvent.getHistoricalY(0, i3), motionEvent.getHistoricalX(1, i3), motionEvent.getHistoricalY(1, i3));
                }
                if (c(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                    return;
                }
            }
            this.f21492g = -1;
            zzfxlVar.removeCallbacks(runnable);
        }
    }

    public final void b() {
        String str;
        try {
            Context context = this.f21486a;
            if (!(context instanceof Activity)) {
                int i2 = zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
                return;
            }
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            zzax zzaxVar = zztVar.o;
            synchronized (zzaxVar.f21505a) {
                str = zzaxVar.f21507c;
            }
            String str2 = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(str)) {
                str2 = "Creative preview";
            }
            String str3 = true != zztVar.o.h() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iE = e("Ad information", arrayList, true);
            final int iE2 = e(str2, arrayList, true);
            final int iE3 = e(str3, arrayList, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pa)).booleanValue();
            final int iE4 = e("Open ad inspector", arrayList, zBooleanValue);
            final int iE5 = e("Ad inspector settings", arrayList, zBooleanValue);
            AlertDialog.Builder builderK = zzs.k(context);
            builderK.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzad
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    final zzat zzatVar = this.f21458a;
                    zzatVar.getClass();
                    if (i3 != iE) {
                        if (i3 == iE2) {
                            int i4 = zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.a("Debug mode [Creative Preview] selected.");
                            zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzat zzatVar2 = zzatVar;
                                    zzatVar2.getClass();
                                    com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
                                    zzax zzaxVar2 = zztVar2.o;
                                    Context context2 = zzatVar2.f21486a;
                                    String str4 = zzatVar2.f21489d;
                                    String str5 = zzatVar2.f21490e;
                                    zzaxVar2.getClass();
                                    zzbgb zzbgbVar = zzbgk.E5;
                                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                    String strJ = zzax.j(context2, zzaxVar2.k(context2, (String) zzbdVar.f21153c.a(zzbgbVar), str4, str5).toString(), str5);
                                    if (TextUtils.isEmpty(strJ)) {
                                        int i5 = zze.f21576b;
                                        com.google.android.gms.ads.internal.util.client.zzo.a("Not linked for in app preview.");
                                    } else {
                                        try {
                                            JSONObject jSONObject = new JSONObject(strJ.trim());
                                            String strOptString = jSONObject.optString("gct");
                                            zzaxVar2.f21510f = jSONObject.optString(CLConstants.OTP_STATUS);
                                            if (((Boolean) zzbdVar.f21153c.a(zzbgk.pa)).booleanValue()) {
                                                String str6 = zzaxVar2.f21510f;
                                                boolean z = "0".equals(str6) || "2".equals(str6);
                                                zzaxVar2.f(z);
                                                zztVar2.f21684h.g().b(!z ? "" : str4);
                                            }
                                            synchronized (zzaxVar2.f21505a) {
                                                zzaxVar2.f21507c = strOptString;
                                            }
                                            String str7 = zzaxVar2.f21510f;
                                            if ("2".equals(str7)) {
                                                int i6 = zze.f21576b;
                                                com.google.android.gms.ads.internal.util.client.zzo.a("Creative is not pushed for this device.");
                                                zzaxVar2.i("There was no creative pushed from DFP to the device.", context2, false, false);
                                                return;
                                            } else if ("1".equals(str7)) {
                                                int i7 = zze.f21576b;
                                                com.google.android.gms.ads.internal.util.client.zzo.a("The app is not linked for creative preview.");
                                                zzaxVar2.c(context2, str4, str5);
                                                return;
                                            } else {
                                                if ("0".equals(str7)) {
                                                    int i8 = zze.f21576b;
                                                    com.google.android.gms.ads.internal.util.client.zzo.a("Device is linked for in app preview.");
                                                    zzaxVar2.i("The device is successfully linked for creative preview.", context2, false, true);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (JSONException e2) {
                                            int i9 = zze.f21576b;
                                            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to get in app preview response json.", e2);
                                        }
                                    }
                                    zzaxVar2.i("In-app preview failed to load because of a system error. Please try again later.", context2, true, true);
                                }
                            });
                            return;
                        }
                        if (i3 == iE3) {
                            int i5 = zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.a("Debug mode [Troubleshooting] selected.");
                            zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzat zzatVar2 = zzatVar;
                                    zzatVar2.getClass();
                                    zzax zzaxVar2 = com.google.android.gms.ads.internal.zzt.C.o;
                                    String str4 = zzatVar2.f21489d;
                                    String str5 = zzatVar2.f21490e;
                                    String str6 = zzatVar2.f21491f;
                                    boolean zH = zzaxVar2.h();
                                    Context context2 = zzatVar2.f21486a;
                                    boolean zB = zzaxVar2.b(context2, str4, str5);
                                    synchronized (zzaxVar2.f21505a) {
                                        zzaxVar2.f21508d = zB;
                                    }
                                    if (!zzaxVar2.h()) {
                                        zzaxVar2.c(context2, str4, str5);
                                        return;
                                    }
                                    if (!zH && !TextUtils.isEmpty(str6)) {
                                        zzaxVar2.e(context2, str5, str6, str4);
                                    }
                                    int i6 = zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.a("Device is linked for debug signals.");
                                    zzaxVar2.i("The device is successfully linked for troubleshooting.", context2, false, true);
                                }
                            });
                            return;
                        }
                        int i6 = iE4;
                        zzeak zzeakVar = zzatVar.f21487b;
                        if (i3 == i6) {
                            final zzgyw zzgywVar = zzcdo.f25987f;
                            zzgyw zzgywVar2 = zzcdo.f25982a;
                            if (zzeakVar.f()) {
                                zzgywVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaq
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzat zzatVar2 = zzatVar;
                                        zzatVar2.getClass();
                                        com.google.android.gms.ads.internal.zzt.C.o.a(zzatVar2.f21486a);
                                    }
                                });
                                return;
                            } else {
                                zzgywVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzap
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        final zzat zzatVar2 = zzatVar;
                                        zzatVar2.getClass();
                                        com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
                                        zzax zzaxVar2 = zztVar2.o;
                                        String str4 = zzatVar2.f21489d;
                                        String str5 = zzatVar2.f21490e;
                                        Context context2 = zzatVar2.f21486a;
                                        if (zzaxVar2.b(context2, str4, str5)) {
                                            zzgywVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzai
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    zzat zzatVar3 = zzatVar2;
                                                    zzatVar3.getClass();
                                                    com.google.android.gms.ads.internal.zzt.C.o.a(zzatVar3.f21486a);
                                                }
                                            });
                                        } else {
                                            zztVar2.o.c(context2, zzatVar2.f21489d, zzatVar2.f21490e);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        if (i3 == iE5) {
                            final zzgyw zzgywVar3 = zzcdo.f25987f;
                            zzgyw zzgywVar4 = zzcdo.f25982a;
                            if (zzeakVar.f()) {
                                zzgywVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzat zzatVar2 = zzatVar;
                                        zzatVar2.d(zzatVar2.f21486a);
                                    }
                                });
                                return;
                            } else {
                                zzgywVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzar
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        final zzat zzatVar2 = zzatVar;
                                        zzatVar2.getClass();
                                        com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
                                        zzax zzaxVar2 = zztVar2.o;
                                        String str4 = zzatVar2.f21489d;
                                        String str5 = zzatVar2.f21490e;
                                        Context context2 = zzatVar2.f21486a;
                                        if (zzaxVar2.b(context2, str4, str5)) {
                                            zzgywVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzah
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    zzat zzatVar3 = zzatVar2;
                                                    zzatVar3.d(zzatVar3.f21486a);
                                                }
                                            });
                                        } else {
                                            zztVar2.o.c(context2, zzatVar2.f21489d, zzatVar2.f21490e);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        return;
                    }
                    Context context2 = zzatVar.f21486a;
                    if (!(context2 instanceof Activity)) {
                        int i7 = zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
                        return;
                    }
                    String str4 = zzatVar.f21488c;
                    final String str5 = "No debug information";
                    if (!TextUtils.isEmpty(str4)) {
                        Uri uriBuild = new Uri.Builder().encodedQuery(str4.replaceAll("\\+", "%20")).build();
                        StringBuilder sb = new StringBuilder();
                        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                        HashMap mapO = zzs.o(uriBuild);
                        for (String str6 : mapO.keySet()) {
                            sb.append(str6);
                            sb.append(" = ");
                            sb.append((String) mapO.get(str6));
                            sb.append("\n\n");
                        }
                        String strTrim = sb.toString().trim();
                        if (!TextUtils.isEmpty(strTrim)) {
                            str5 = strTrim;
                        }
                    }
                    zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                    AlertDialog.Builder builderK2 = zzs.k(context2);
                    builderK2.setMessage(str5);
                    builderK2.setTitle("Ad Information");
                    builderK2.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzan
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface2, int i8) {
                            zzat zzatVar2 = zzatVar;
                            zzatVar2.getClass();
                            zzs zzsVar3 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                            zzs.t(zzatVar2.f21486a, Intent.createChooser(new Intent("android.intent.action.SEND").setType(UtilsKt.MIME_TYPE_TEXT_PLAIN).putExtra("android.intent.extra.TEXT", str5), "Share via"));
                        }
                    });
                    builderK2.setNegativeButton("Close", zzao.f21479a);
                    builderK2.create().show();
                }
            });
            builderK.create().show();
        } catch (WindowManager.BadTokenException e2) {
            zze.l("", e2);
        }
    }

    public final boolean c(float f2, float f3, float f4, float f5) {
        float fAbs = Math.abs(this.f21494i.x - f2);
        int i2 = this.f21493h;
        return fAbs < ((float) i2) && Math.abs(this.f21494i.y - f3) < ((float) i2) && Math.abs(this.f21495j.x - f4) < ((float) i2) && Math.abs(this.f21495j.y - f5) < ((float) i2);
    }

    public final void d(Context context) {
        ArrayList arrayList = new ArrayList();
        int iE = e("None", arrayList, true);
        final int iE2 = e("Shake", arrayList, true);
        final int iE3 = e("Flick", arrayList, true);
        int iOrdinal = this.f21487b.r.ordinal();
        final int i2 = iOrdinal != 1 ? iOrdinal != 2 ? iE : iE3 : iE2;
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        AlertDialog.Builder builderK = zzs.k(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i2);
        builderK.setTitle("Setup gesture");
        builderK.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i2, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaj
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                atomicInteger.set(i3);
            }
        });
        builderK.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzak
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                this.f21470a.b();
            }
        });
        builderK.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzal
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                zzat zzatVar = this.f21471a;
                zzatVar.getClass();
                AtomicInteger atomicInteger2 = atomicInteger;
                if (atomicInteger2.get() != i2) {
                    int i4 = atomicInteger2.get();
                    int i5 = iE2;
                    zzeak zzeakVar = zzatVar.f21487b;
                    if (i4 == i5) {
                        zzeakVar.h(zzeag.f28926b, true);
                    } else if (atomicInteger2.get() == iE3) {
                        zzeakVar.h(zzeag.f28927c, true);
                    } else {
                        zzeakVar.h(zzeag.f28925a, true);
                    }
                }
                zzatVar.b();
            }
        });
        builderK.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzam
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                this.f21476a.b();
            }
        });
        builderK.create().show();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.f21488c);
        sb.append(",DebugSignal: ");
        sb.append(this.f21491f);
        sb.append(",AFMA Version: ");
        sb.append(this.f21490e);
        sb.append(",Ad Unit ID: ");
        return b.r(sb, this.f21489d, "}");
    }
}
