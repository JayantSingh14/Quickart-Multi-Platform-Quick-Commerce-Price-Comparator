package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzfq extends zzfk implements zzfr {
    public zzfq() {
        super("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.android.gms.internal.pal.zzfk
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        int i3 = 0;
        switch (i2) {
            case 1:
                parcel2.writeNoException();
                parcel2.writeString("ms");
                return true;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzfl.a(parcel);
                zzcv zzcvVar = ((zzfn) this).f37737c;
                zzcvVar.f37596a = string;
                zzcvVar.f37597b = string2;
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                Uri uri = (Uri) ObjectWrapper.z0(iObjectWrapperG);
                zzcv zzcvVar2 = ((zzfn) this).f37737c;
                zzcvVar2.getClass();
                uri.getClass();
                try {
                    if (uri.getHost().equals(zzcvVar2.f37596a)) {
                        if (uri.getPath().equals(zzcvVar2.f37597b)) {
                            i3 = 1;
                        }
                    }
                } catch (NullPointerException unused) {
                }
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 4:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                Uri uri2 = (Uri) ObjectWrapper.z0(iObjectWrapperG2);
                zzcv zzcvVar3 = ((zzfn) this).f37737c;
                zzcvVar3.getClass();
                uri2.getClass();
                try {
                    String host = uri2.getHost();
                    String[] strArr = zzcvVar3.f37598c;
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            if (host.endsWith(strArr[i4])) {
                                i3 = 1;
                            } else {
                                i4++;
                            }
                        }
                    }
                } catch (NullPointerException unused2) {
                }
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 5:
                String string3 = parcel.readString();
                zzfl.a(parcel);
                zzcv zzcvVar4 = ((zzfn) this).f37737c;
                zzcvVar4.getClass();
                zzcvVar4.f37598c = string3.split(",");
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                ObjectWrapper objectWrapperZ0 = ((zzfn) this).z0(iObjectWrapperG3, iObjectWrapperG4, true);
                parcel2.writeNoException();
                zzfl.b(parcel2, objectWrapperZ0);
                return true;
            case 7:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                String strZzg = ((zzfn) this).zzg(iObjectWrapperG5, null);
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string4 = parcel.readString();
                zzfl.a(parcel);
                String strZze = ((zzfn) this).zze(iObjectWrapperG6, string4);
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                ((zzfn) this).zzl(iObjectWrapperG7);
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                ObjectWrapper objectWrapperZ02 = ((zzfn) this).z0(iObjectWrapperG8, iObjectWrapperG9, false);
                parcel2.writeNoException();
                zzfl.b(parcel2, objectWrapperZ02);
                return true;
            case 11:
                String string5 = parcel.readString();
                int i5 = zzfl.f37734a;
                boolean z = parcel.readInt() != 0;
                zzfl.a(parcel);
                zzfn zzfnVar = (zzfn) this;
                zzcs zzcsVar = zzfnVar.f37736b;
                if (zzcsVar != null) {
                    zzcsVar.C = new AdvertisingIdClient.Info(string5, z);
                    zzfnVar.f37738d = true;
                    i3 = 1;
                }
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                byte[] bArrCreateByteArray = parcel.createByteArray();
                zzfl.a(parcel);
                String strZzg2 = ((zzfn) this).zzg(iObjectWrapperG10, bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeString(strZzg2);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                String strA = ((zzfn) this).f37735a.a((Context) ObjectWrapper.z0(iObjectWrapperG11));
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG13 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG14 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                String strZzk = ((zzfn) this).zzk(iObjectWrapperG12, iObjectWrapperG13, iObjectWrapperG14);
                parcel2.writeNoException();
                parcel2.writeString(strZzk);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperG15 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                zzcu zzcuVar = ((zzfn) this).f37735a;
                View view = (View) ObjectWrapper.z0(iObjectWrapperG15);
                zzcuVar.getClass();
                if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.f37773j)).booleanValue()) {
                    if (zzcuVar.v == null) {
                        zzdu zzduVar = zzcr.t;
                        zzcuVar.v = new zzeb(zzduVar.f37634a, zzduVar.q);
                    }
                    zzcuVar.v.a(view);
                }
                parcel2.writeNoException();
                return true;
            case 16:
            default:
                return false;
            case 17:
                IObjectWrapper iObjectWrapperG16 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG17 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG18 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG19 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzfl.a(parcel);
                String strE = ((zzfn) this).f37735a.e((Context) ObjectWrapper.z0(iObjectWrapperG16), (String) ObjectWrapper.z0(iObjectWrapperG17), 3, (View) ObjectWrapper.z0(iObjectWrapperG18), (Activity) ObjectWrapper.z0(iObjectWrapperG19), null);
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 18:
                parcel2.writeNoException();
                int i6 = zzfl.f37734a;
                parcel2.writeInt(1);
                return true;
            case 19:
                parcel2.writeNoException();
                int i7 = zzfl.f37734a;
                parcel2.writeInt(1);
                return true;
            case 20:
                int i8 = ((zzfn) this).f37735a != null ? 1 : -1;
                parcel2.writeNoException();
                parcel2.writeInt(i8);
                return true;
        }
    }
}
