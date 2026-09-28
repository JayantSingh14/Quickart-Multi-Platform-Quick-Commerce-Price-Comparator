package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzbpl implements zzard {

    /* renamed from: a, reason: collision with root package name */
    public volatile zzboy f25409a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f25410b;

    public zzbpl(Context context) {
        this.f25410b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzard
    public final zzarg a(zzark zzarkVar) {
        SafeParcelable safeParcelable;
        Parcelable.Creator<zzboz> creator = zzboz.CREATOR;
        Map mapE = zzarkVar.e();
        int size = mapE.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry entry : mapE.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzboz zzbozVar = new zzboz(zzarkVar.f24215c, strArr, strArr2);
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        long jElapsedRealtime = zztVar.f21687k.elapsedRealtime();
        try {
            zzcdt zzcdtVar = new zzcdt();
            this.f25409a = new zzboy(zzbzk.a(this.f25410b), zztVar.t.a(), 166, new zzbpj(this, zzcdtVar), new zzbpk(this, zzcdtVar), null);
            this.f25409a.checkAvailabilityAndConnect();
            zzbph zzbphVar = new zzbph(this, zzbozVar);
            zzgyw zzgywVar = zzcdo.f25982a;
            ListenableFuture listenableFutureG = zzgym.g(zzgym.h(zzcdtVar, zzbphVar, zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g5)).intValue(), TimeUnit.MILLISECONDS, zzcdo.f25985d);
            listenableFutureG.q(new zzbpi(this), zzgywVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) listenableFutureG.get();
            long jElapsedRealtime2 = zztVar.f21687k.elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 32);
            sb.append("Http assets remote cache took ");
            sb.append(jElapsedRealtime2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            zzbyy zzbyyVar = new zzbyy(parcelFileDescriptor);
            Parcelable.Creator<zzbpb> creator2 = zzbpb.CREATOR;
            if (zzbyyVar.f25719c) {
                if (zzbyyVar.f25717a == null) {
                    com.google.android.gms.ads.internal.util.client.zzo.c("File descriptor is empty, returning null.");
                } else {
                    DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(zzbyyVar.f25717a));
                    try {
                        try {
                            int i3 = dataInputStream.readInt();
                            byte[] bArr = new byte[i3];
                            dataInputStream.readFully(bArr, 0, i3);
                            IOUtils.closeQuietly(dataInputStream);
                            Parcel parcelObtain = Parcel.obtain();
                            try {
                                parcelObtain.unmarshall(bArr, 0, i3);
                                parcelObtain.setDataPosition(0);
                                zzbyyVar.f25718b = creator2.createFromParcel(parcelObtain);
                                parcelObtain.recycle();
                                zzbyyVar.f25719c = false;
                                safeParcelable = (SafeParcelable) zzbyyVar.f25718b;
                            } catch (Throwable th) {
                                parcelObtain.recycle();
                                throw th;
                            }
                        } catch (IOException e2) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("Could not read from parcel file descriptor", e2);
                            IOUtils.closeQuietly(dataInputStream);
                        }
                    } catch (Throwable th2) {
                        IOUtils.closeQuietly(dataInputStream);
                        throw th2;
                    }
                }
                safeParcelable = null;
            } else {
                safeParcelable = (SafeParcelable) zzbyyVar.f25718b;
            }
            zzbpb zzbpbVar = (zzbpb) safeParcelable;
            if (zzbpbVar == null) {
                return null;
            }
            if (zzbpbVar.f25395a) {
                throw new zzart(zzbpbVar.f25396b);
            }
            String[] strArr3 = zzbpbVar.f25399e;
            String[] strArr4 = zzbpbVar.f25400f;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i5 = 0; i5 < strArr3.length; i5++) {
                map.put(strArr3[i5], strArr4[i5]);
            }
            return new zzarg(zzbpbVar.f25397c, zzbpbVar.f25398d, map, zzarg.a(map), zzbpbVar.f25401g);
        } catch (InterruptedException | ExecutionException unused) {
            long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb2 = new StringBuilder(String.valueOf(jElapsedRealtime3).length() + 32);
            sb2.append("Http assets remote cache took ");
            sb2.append(jElapsedRealtime3);
            sb2.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
            return null;
        } catch (Throwable th3) {
            long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb3 = new StringBuilder(String.valueOf(jElapsedRealtime4).length() + 32);
            sb3.append("Http assets remote cache took ");
            sb3.append(jElapsedRealtime4);
            sb3.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
            throw th3;
        }
    }
}
