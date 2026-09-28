package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final /* synthetic */ class zzama implements zzdr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzamb f23528a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f23529b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f23530c;

    public /* synthetic */ zzama(zzamb zzambVar, long j2, int i2) {
        this.f23528a = zzambVar;
        this.f23529b = j2;
        this.f23530c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    public final void zza(Object obj) {
        zzalq zzalqVar = (zzalq) obj;
        zzamb zzambVar = this.f23528a;
        zzambVar.f23538h.getClass();
        zzgtd<zzcx> zzgtdVar = zzalqVar.f23507a;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgtdVar.size());
        for (zzcx zzcxVar : zzgtdVar) {
            zzcxVar.getClass();
            Bundle bundle = new Bundle();
            CharSequence charSequence = zzcxVar.f27322a;
            if (charSequence != null) {
                bundle.putCharSequence(zzcx.q, charSequence);
                if (charSequence instanceof Spanned) {
                    Spanned spanned = (Spanned) charSequence;
                    String str = zzda.f27535a;
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    for (zzdc zzdcVar : (zzdc[]) spanned.getSpans(0, spanned.length(), zzdc.class)) {
                        zzdcVar.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(zzdc.f27598c, zzdcVar.f27600a);
                        bundle2.putInt(zzdc.f27599d, zzdcVar.f27601b);
                        arrayList2.add(zzda.a(spanned, zzdcVar, 1, bundle2));
                    }
                    for (zzde zzdeVar : (zzde[]) spanned.getSpans(0, spanned.length(), zzde.class)) {
                        zzdeVar.getClass();
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt(zzde.f27659d, zzdeVar.f27662a);
                        bundle3.putInt(zzde.f27660e, zzdeVar.f27663b);
                        bundle3.putInt(zzde.f27661f, zzdeVar.f27664c);
                        arrayList2.add(zzda.a(spanned, zzdeVar, 2, bundle3));
                    }
                    for (zzdb zzdbVar : (zzdb[]) spanned.getSpans(0, spanned.length(), zzdb.class)) {
                        arrayList2.add(zzda.a(spanned, zzdbVar, 3, null));
                    }
                    for (zzdf zzdfVar : (zzdf[]) spanned.getSpans(0, spanned.length(), zzdf.class)) {
                        zzdfVar.getClass();
                        Bundle bundle4 = new Bundle();
                        bundle4.putString(zzdf.f27691b, zzdfVar.f27692a);
                        arrayList2.add(zzda.a(spanned, zzdfVar, 4, bundle4));
                    }
                    if (!arrayList2.isEmpty()) {
                        bundle.putParcelableArrayList(zzcx.r, arrayList2);
                    }
                }
            }
            bundle.putSerializable(zzcx.s, zzcxVar.f27323b);
            bundle.putSerializable(zzcx.t, zzcxVar.f27324c);
            bundle.putFloat(zzcx.v, zzcxVar.f27326e);
            bundle.putInt(zzcx.w, zzcxVar.f27327f);
            bundle.putInt(zzcx.x, zzcxVar.f27328g);
            bundle.putFloat(zzcx.y, zzcxVar.f27329h);
            bundle.putInt(zzcx.z, zzcxVar.f27330i);
            bundle.putInt(zzcx.A, zzcxVar.f27333l);
            bundle.putFloat(zzcx.B, zzcxVar.f27334m);
            bundle.putFloat(zzcx.C, zzcxVar.f27331j);
            bundle.putFloat(zzcx.D, zzcxVar.f27332k);
            bundle.putBoolean(zzcx.F, false);
            bundle.putInt(zzcx.E, -16777216);
            bundle.putInt(zzcx.G, zzcxVar.n);
            bundle.putFloat(zzcx.H, zzcxVar.o);
            bundle.putInt(zzcx.I, zzcxVar.p);
            Bitmap bitmap = zzcxVar.f27325d;
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzgqa.f(bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
                bundle.putByteArray(zzcx.u, byteArrayOutputStream.toByteArray());
            }
            arrayList.add(bundle);
        }
        Bundle bundle5 = new Bundle();
        bundle5.putParcelableArrayList("c", arrayList);
        bundle5.putLong("d", zzalqVar.f23509c);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle5);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        int length = bArrMarshall.length;
        zzer zzerVar = zzambVar.f23533c;
        zzerVar.z(length, bArrMarshall);
        zzaga zzagaVar = zzambVar.f23531a;
        zzagaVar.b(length, zzerVar);
        long j2 = zzalqVar.f23508b;
        long j3 = this.f23529b;
        if (j2 == -9223372036854775807L) {
            zzgqa.f(zzambVar.f23538h.r == Long.MAX_VALUE);
        } else {
            long j4 = zzambVar.f23538h.r;
            j3 = j4 == Long.MAX_VALUE ? j3 + j2 : j2 + j4;
        }
        zzagaVar.e(j3, this.f23530c | 1, length, 0, null);
    }
}
