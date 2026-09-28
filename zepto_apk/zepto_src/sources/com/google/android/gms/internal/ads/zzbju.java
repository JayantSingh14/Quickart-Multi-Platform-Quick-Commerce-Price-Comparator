package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbju extends zzbcc implements zzbjv {
    public zzbju() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        float f2;
        zzclb zzclbVarZzN;
        int i3;
        int i4;
        int i5;
        zzblg zzblgVar;
        zzcir zzcirVar;
        switch (i2) {
            case 2:
                zzdmu zzdmuVar = (zzdmu) this;
                zzdnm zzdnmVar = zzdmuVar.f27982a;
                synchronized (zzdnmVar) {
                    f2 = zzdnmVar.x;
                }
                if (f2 != 0.0f) {
                    synchronized (zzdnmVar) {
                        fZzm = zzdnmVar.x;
                    }
                } else if (zzdnmVar.r() != null) {
                    try {
                        fZzm = zzdnmVar.r().zzm();
                    } catch (RemoteException e2) {
                        int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Remote exception getting video controller aspect ratio.", e2);
                    }
                } else {
                    IObjectWrapper iObjectWrapper = zzdmuVar.f27983b;
                    if (iObjectWrapper != null) {
                        fZzm = zzdmu.Xb(iObjectWrapper);
                    } else if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.xd)).booleanValue() || zzdnmVar.i() == null || (zzclbVarZzN = zzdnmVar.i().zzN()) == null || (i3 = zzclbVarZzN.f26493c) < 0 || (i4 = zzclbVarZzN.f26492b) <= 0) {
                        zzbjy zzbjyVarB = zzdnmVar.b();
                        if (zzbjyVarB != null) {
                            float fZze = (zzbjyVarB.zze() == -1 || zzbjyVarB.zzf() == -1) ? 0.0f : zzbjyVarB.zze() / zzbjyVarB.zzf();
                            fZzm = fZze == 0.0f ? zzdmu.Xb(zzbjyVarB.zzb()) : fZze;
                        }
                    } else {
                        fZzm = i3 / i4;
                    }
                }
                parcel2.writeNoException();
                parcel2.writeFloat(fZzm);
                return true;
            case 3:
                ((zzdmu) this).f27983b = android.support.v4.media.a.g(parcel, parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzg = ((zzdmu) this).zzg();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzg);
                return true;
            case 5:
                zzdnm zzdnmVar2 = ((zzdmu) this).f27982a;
                fZzm = zzdnmVar2.r() != null ? zzdnmVar2.r().zzj() : 0.0f;
                parcel2.writeNoException();
                parcel2.writeFloat(fZzm);
                return true;
            case 6:
                zzdnm zzdnmVar3 = ((zzdmu) this).f27982a;
                fZzm = zzdnmVar3.r() != null ? zzdnmVar3.r().zzk() : 0.0f;
                parcel2.writeNoException();
                parcel2.writeFloat(fZzm);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzedVarR = ((zzdmu) this).f27982a.r();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarR);
                return true;
            case 8:
                i5 = ((zzdmu) this).f27982a.r() != null ? 1 : 0;
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(i5);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzblgVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzblgVar = iInterfaceQueryLocalInterface instanceof zzblg ? (zzblg) iInterfaceQueryLocalInterface : new zzblg(strongBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                }
                zzbcd.f(parcel);
                zzdnm zzdnmVar4 = ((zzdmu) this).f27982a;
                if (zzdnmVar4.r() instanceof zzcjx) {
                    zzcjx zzcjxVar = (zzcjx) zzdnmVar4.r();
                    synchronized (zzcjxVar.f26444b) {
                        zzcjxVar.n = zzblgVar;
                    }
                }
                parcel2.writeNoException();
                return true;
            case 10:
                zzdnm zzdnmVar5 = ((zzdmu) this).f27982a;
                synchronized (zzdnmVar5) {
                    zzcirVar = zzdnmVar5.f28035j;
                }
                i5 = zzcirVar != null ? 1 : 0;
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(i5);
                return true;
            default:
                return false;
        }
    }
}
