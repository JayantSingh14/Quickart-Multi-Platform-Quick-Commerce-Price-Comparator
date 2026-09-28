package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbkf;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxx;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaw extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NativeAdView f21128b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f21129c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f21130d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzaz f21131e;

    public zzaw(zzaz zzazVar, NativeAdView nativeAdView, FrameLayout frameLayout, Context context) {
        this.f21128b = nativeAdView;
        this.f21129c = frameLayout;
        this.f21130d = context;
        Objects.requireNonNull(zzazVar);
        this.f21131e = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21130d, "native_ad_view_delegate");
        return new zzfn();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        Context context = this.f21130d;
        zzbgk.a(context);
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue();
        FrameLayout frameLayout = this.f21129c;
        NativeAdView nativeAdView = this.f21128b;
        zzaz zzazVar = this.f21131e;
        if (zBooleanValue) {
            try {
                IBinder iBinderB5 = ((zzbkf) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzav.f21127a)).B5(new ObjectWrapper(context), new ObjectWrapper(nativeAdView), new ObjectWrapper(frameLayout));
                int i2 = zzbkb.f25281a;
                if (iBinderB5 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinderB5.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                return iInterfaceQueryLocalInterface instanceof zzbkc ? (zzbkc) iInterfaceQueryLocalInterface : new zzbka(iBinderB5);
            } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e2) {
                zzbxx zzbxxVarC = zzbxv.c(context);
                zzazVar.f21137f = zzbxxVarC;
                zzbxxVarC.a("ClientApiBroker.createNativeAdViewDelegate", e2);
                return null;
            }
        }
        try {
            IBinder iBinderB52 = ((zzbkf) zzazVar.f21135d.getRemoteCreatorInstance(context)).B5(new ObjectWrapper(context), new ObjectWrapper(nativeAdView), new ObjectWrapper(frameLayout));
            if (iBinderB52 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = iBinderB52.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return iInterfaceQueryLocalInterface2 instanceof zzbkc ? (zzbkc) iInterfaceQueryLocalInterface2 : new zzbka(iBinderB52);
        } catch (RemoteException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.Q6(new ObjectWrapper(this.f21128b), new ObjectWrapper(this.f21129c));
    }
}
