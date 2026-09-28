package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
final class zzgom {

    /* renamed from: c, reason: collision with root package name */
    public static final zzgpe f33025c = new zzgpe("OverlayDisplayService");

    /* renamed from: d, reason: collision with root package name */
    public static final Intent f33026d = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");

    /* renamed from: a, reason: collision with root package name */
    public final zzgpd f33027a;

    /* renamed from: b, reason: collision with root package name */
    public final String f33028b;

    public zzgom(Context context) {
        if (zzgpg.a(context)) {
            this.f33027a = new zzgpd(context.getApplicationContext(), f33025c, f33026d);
        } else {
            this.f33027a = null;
        }
        this.f33028b = context.getPackageName();
    }

    public static void b(String str, zzgol zzgolVar) {
        if ((str == null ? "" : str).trim().isEmpty()) {
            return;
        }
        str.getClass();
        zzgolVar.a(str.trim());
    }

    public static boolean c(zzgor zzgorVar, String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2 == null) {
                str2 = "";
            }
            if (!str2.trim().isEmpty()) {
                return true;
            }
        }
        f33025c.c(str, new Object[0]);
        zzgno zzgnoVar = new zzgno();
        byte b2 = (byte) (zzgnoVar.f32993d | 1);
        zzgnoVar.f32992c = 0;
        zzgnoVar.f32990a = 8160;
        zzgnoVar.f32993d = (byte) (((byte) (b2 | 2)) | 1);
        zzgorVar.a(zzgnoVar.a());
        return false;
    }

    public final void a(final zzgot zzgotVar, final zzgor zzgorVar, final int i2) {
        zzgpd zzgpdVar = this.f33027a;
        if (zzgpdVar == null) {
            f33025c.c("error: %s", "Play Store not found.");
        } else if (c(zzgorVar, "Failed to apply OverlayDisplayUpdateRequest: missing appId and sessionToken.", Arrays.asList(zzgotVar.a(), zzgotVar.b()))) {
            zzgpdVar.a(new zzgoz(zzgpdVar, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgoa
                @Override // java.lang.Runnable
                public final void run() {
                    zzgot zzgotVar2 = zzgotVar;
                    int i3 = i2;
                    zzgor zzgorVar2 = zzgorVar;
                    zzgom zzgomVar = this.f33008a;
                    String str = zzgomVar.f33028b;
                    try {
                        zzgpd zzgpdVar2 = zzgomVar.f33027a;
                        if (zzgpdVar2 == null) {
                            throw null;
                        }
                        zzgnh zzgnhVar = zzgpdVar2.f33048j;
                        if (zzgnhVar == null) {
                            return;
                        }
                        final Bundle bundle = new Bundle();
                        bundle.putString("callerPackage", str);
                        bundle.putInt("displayMode", i3);
                        zzgom.b(zzgotVar2.a(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgoi
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("sessionToken", str2);
                            }
                        });
                        zzgom.b(zzgotVar2.b(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgnz
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString(CLConstants.SALT_FIELD_APP_ID, str2);
                            }
                        });
                        zzgnhVar.Sa(bundle, new zzgok(zzgomVar, zzgorVar2));
                    } catch (RemoteException e2) {
                        zzgom.f33025c.d(e2, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i3), str);
                    }
                }
            }));
        }
    }
}
