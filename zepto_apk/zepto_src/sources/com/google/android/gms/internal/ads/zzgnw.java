package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Arrays;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzgnw implements zzgnu {

    /* renamed from: a, reason: collision with root package name */
    public final zzgom f33001a;

    public zzgnw(zzgom zzgomVar) {
        this.f33001a = zzgomVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgnu
    public final void a(final zzgoo zzgooVar, final zzgor zzgorVar) {
        final zzgom zzgomVar = this.f33001a;
        zzgpd zzgpdVar = zzgomVar.f33027a;
        if (zzgpdVar == null) {
            zzgom.f33025c.c("error: %s", "Play Store not found.");
        } else if (zzgom.c(zzgorVar, "Failed to apply OverlayDisplayShowRequest: missing appId and sessionToken.", Arrays.asList(null, zzgooVar.b()))) {
            zzgpdVar.a(new zzgoz(zzgpdVar, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgoj
                @Override // java.lang.Runnable
                public final void run() {
                    zzgoo zzgooVar2 = zzgooVar;
                    zzgor zzgorVar2 = zzgorVar;
                    zzgom zzgomVar2 = zzgomVar;
                    String str = zzgomVar2.f33028b;
                    try {
                        zzgpd zzgpdVar2 = zzgomVar2.f33027a;
                        if (zzgpdVar2 == null) {
                            throw null;
                        }
                        zzgnh zzgnhVar = zzgpdVar2.f33048j;
                        if (zzgnhVar == null) {
                            return;
                        }
                        final Bundle bundle = new Bundle();
                        bundle.putString("callerPackage", str);
                        bundle.putBinder("windowToken", zzgooVar2.a());
                        zzgom.b(zzgooVar2.f(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgob
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("adFieldEnifd", str2);
                            }
                        });
                        bundle.putInt("layoutGravity", zzgooVar2.c());
                        bundle.putFloat("layoutVerticalMargin", zzgooVar2.d());
                        bundle.putInt("displayMode", 0);
                        bundle.putInt("triggerMode", 0);
                        bundle.putInt("windowWidthPx", zzgooVar2.e());
                        zzgom.b(null, new zzgol() { // from class: com.google.android.gms.internal.ads.zzgoc
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("deeplinkUrl", str2);
                            }
                        });
                        zzgom.b(null, new zzgol() { // from class: com.google.android.gms.internal.ads.zzgod
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("sessionToken", str2);
                            }
                        });
                        zzgom.b(zzgooVar2.b(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgoe
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString(CLConstants.SALT_FIELD_APP_ID, str2);
                            }
                        });
                        zzgom.b(null, new zzgol() { // from class: com.google.android.gms.internal.ads.zzgof
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str2) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("thirdPartyAuthCallerId", str2);
                            }
                        });
                        bundle.putBoolean("stableSessionToken", true);
                        zzgnhVar.T4(str, bundle, new zzgok(zzgomVar2, zzgorVar2));
                    } catch (RemoteException e2) {
                        zzgom.f33025c.d(e2, "show overlay display from: %s", str);
                    }
                }
            }));
        }
    }
}
