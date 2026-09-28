package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public abstract class zzbwq extends zzbcc implements zzbwr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25657a = 0;

    public zzbwq() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws IllegalAccessException, Resources.NotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        switch (i2) {
            case 1:
                Intent intent = (Intent) zzbcd.b(parcel, Intent.CREATOR);
                zzbcd.f(parcel);
                ((zzeif) this).q1(intent);
                break;
            case 2:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                ((zzeif) this).Bb(iObjectWrapperG, new com.google.android.gms.ads.internal.offline.buffering.zza(string, string2, ""));
                break;
            case 3:
                ((zzeif) this).zzg();
                break;
            case 4:
                ((zzeif) this).X0(android.support.v4.media.a.g(parcel, parcel));
                break;
            case 5:
                ((zzeif) this).q6(parcel.createStringArray(), parcel.createIntArray(), android.support.v4.media.a.g(parcel, parcel));
                break;
            case 6:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzbcd.b(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
                zzbcd.f(parcel);
                ((zzeif) this).Bb(iObjectWrapperG2, zzaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
