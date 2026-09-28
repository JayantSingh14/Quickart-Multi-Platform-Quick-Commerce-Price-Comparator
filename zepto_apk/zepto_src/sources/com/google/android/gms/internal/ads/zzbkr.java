package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class zzbkr extends zzbcc implements zzbks {
    public zzbkr() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws SecurityException {
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap simpleArrayMap2;
        List<String> arrayList;
        SimpleArrayMap simpleArrayMap3;
        SimpleArrayMap simpleArrayMap4;
        zzdnh zzdnhVar;
        String str;
        zzbjv zzbjvVar;
        zzdol zzdolVar;
        zzbjv zzbjvVar2 = null;
        int i3 = 0;
        switch (i2) {
            case 1:
                String string = parcel.readString();
                zzbcd.f(parcel);
                zzdnm zzdnmVar = ((zzdry) this).f28389b;
                synchronized (zzdnmVar) {
                    simpleArrayMap = zzdnmVar.w;
                }
                String str2 = (String) simpleArrayMap.get(string);
                parcel2.writeNoException();
                parcel2.writeString(str2);
                return true;
            case 2:
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                zzdnm zzdnmVar2 = ((zzdry) this).f28389b;
                synchronized (zzdnmVar2) {
                    simpleArrayMap2 = zzdnmVar2.v;
                }
                zzbjy zzbjyVar = (zzbjy) simpleArrayMap2.get(string2);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjyVar);
                return true;
            case 3:
                try {
                    zzdnm zzdnmVar3 = ((zzdry) this).f28389b;
                    synchronized (zzdnmVar3) {
                        simpleArrayMap3 = zzdnmVar3.v;
                    }
                    synchronized (zzdnmVar3) {
                        simpleArrayMap4 = zzdnmVar3.w;
                    }
                    String[] strArr = new String[simpleArrayMap3.f1605c + simpleArrayMap4.f1605c];
                    int i4 = 0;
                    for (int i5 = 0; i5 < simpleArrayMap3.f1605c; i5++) {
                        strArr[i4] = (String) simpleArrayMap3.f(i5);
                        i4++;
                    }
                    while (i3 < simpleArrayMap4.f1605c) {
                        strArr[i4] = (String) simpleArrayMap4.f(i3);
                        i4++;
                        i3++;
                    }
                    arrayList = Arrays.asList(strArr);
                } catch (NullPointerException e2) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("InternalNativeCustomTemplateAdShim.getAvailableAssetNames", e2);
                    arrayList = new ArrayList<>();
                }
                parcel2.writeNoException();
                parcel2.writeStringList(arrayList);
                return true;
            case 4:
                String strG = ((zzdry) this).f28389b.g();
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            case 5:
                String string3 = parcel.readString();
                zzbcd.f(parcel);
                zzdnh zzdnhVar2 = ((zzdry) this).f28391d;
                if (zzdnhVar2 != null) {
                    synchronized (zzdnhVar2) {
                        zzdnhVar2.n.Y(string3);
                    }
                }
                parcel2.writeNoException();
                return true;
            case 6:
                zzdnh zzdnhVar3 = ((zzdry) this).f28391d;
                if (zzdnhVar3 != null) {
                    synchronized (zzdnhVar3) {
                        if (!zzdnhVar3.y) {
                            zzdnhVar3.n.Z0();
                        }
                    }
                }
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzedVarR = ((zzdry) this).f28389b.r();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarR);
                return true;
            case 8:
                zzdry zzdryVar = (zzdry) this;
                zzdnh zzdnhVar4 = zzdryVar.f28391d;
                if (zzdnhVar4 != null) {
                    zzdnhVar4.o();
                }
                zzdryVar.f28391d = null;
                zzdryVar.f28390c = null;
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperT9 = ((zzdry) this).T9();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperT9);
                return true;
            case 10:
                boolean zJ = ((zzdry) this).J(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                parcel2.writeInt(zJ ? 1 : 0);
                return true;
            case 11:
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeStrongBinder(null);
                return true;
            case 12:
                zzdry zzdryVar2 = (zzdry) this;
                zzdnh zzdnhVar5 = zzdryVar2.f28391d;
                if (zzdnhVar5 == null || zzdnhVar5.p.c()) {
                    zzdnm zzdnmVar4 = zzdryVar2.f28389b;
                    if (zzdnmVar4.j() != null && zzdnmVar4.h() == null) {
                        i3 = 1;
                    }
                }
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(i3);
                return true;
            case 13:
                zzdnm zzdnmVar5 = ((zzdry) this).f28389b;
                zzejb zzejbVarK = zzdnmVar5.k();
                if (zzejbVarK != null) {
                    com.google.android.gms.ads.internal.zzt.C.x.c(zzejbVarK.f29453a);
                    if (zzdnmVar5.j() != null) {
                        zzdnmVar5.j().g("onSdkLoaded", new ArrayMap());
                    }
                    i3 = 1;
                } else {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Trying to start OMID session before creation.");
                }
                parcel2.writeNoException();
                ClassLoader classLoader3 = zzbcd.f24690a;
                parcel2.writeInt(i3);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperG = android.support.v4.media.a.g(parcel, parcel);
                zzdry zzdryVar3 = (zzdry) this;
                Object objZ0 = ObjectWrapper.z0(iObjectWrapperG);
                if ((objZ0 instanceof View) && zzdryVar3.f28389b.k() != null && (zzdnhVar = zzdryVar3.f28391d) != null) {
                    zzdnhVar.f((View) objZ0);
                }
                parcel2.writeNoException();
                return true;
            case 15:
                zzdry zzdryVar4 = (zzdry) this;
                try {
                    zzdnm zzdnmVar6 = zzdryVar4.f28389b;
                    synchronized (zzdnmVar6) {
                        str = zzdnmVar6.y;
                    }
                    if (Objects.equals(str, "Google")) {
                        int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Illegal argument specified for omid partner name.");
                    } else if (TextUtils.isEmpty(str)) {
                        int i8 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Not starting OMID session. OM partner name has not been configured.");
                    } else {
                        zzdnh zzdnhVar6 = zzdryVar4.f28391d;
                        if (zzdnhVar6 != null) {
                            zzdnhVar6.e(str, false);
                        }
                    }
                } catch (NullPointerException e3) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement", e3);
                }
                parcel2.writeNoException();
                return true;
            case 16:
                try {
                    zzdnj zzdnjVar = ((zzdry) this).f28391d.F;
                    synchronized (zzdnjVar) {
                        zzbjvVar = zzdnjVar.f28021a;
                    }
                    zzbjvVar2 = zzbjvVar;
                } catch (NullPointerException e4) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("InternalNativeCustomTemplateAdShim.getMediaContent", e4);
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjvVar2);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperG2 = android.support.v4.media.a.g(parcel, parcel);
                zzdry zzdryVar5 = (zzdry) this;
                Object objZ02 = ObjectWrapper.z0(iObjectWrapperG2);
                if ((objZ02 instanceof ViewGroup) && (zzdolVar = zzdryVar5.f28390c) != null && zzdolVar.c((ViewGroup) objZ02, false)) {
                    zzdryVar5.f28389b.i().n0(new zzdrx(zzdryVar5));
                    i3 = 1;
                }
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            default:
                return false;
        }
    }
}
