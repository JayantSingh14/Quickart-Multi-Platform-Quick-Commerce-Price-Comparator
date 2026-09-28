package com.google.android.play.core.splitinstall.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzbp extends zzl implements zzbq {
    public zzbp() {
        attachInterface(this, "com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzl
    public final boolean g(int i2, Parcel parcel) {
        switch (i2) {
            case 2:
                int i3 = parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                L4(i3, bundle);
                return true;
            case 3:
                int i4 = parcel.readInt();
                Parcelable.Creator creator2 = Bundle.CREATOR;
                zzm.b(parcel);
                A(i4);
                return true;
            case 4:
                int i5 = parcel.readInt();
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle2 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                zzb(i5, bundle2);
                return true;
            case 5:
                int i6 = parcel.readInt();
                Parcelable.Creator creator4 = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                Q5(i6, bundle3);
                return true;
            case 6:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                E4(bundle4);
                return true;
            case 7:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Bundle.CREATOR);
                zzm.b(parcel);
                Fb(arrayListCreateTypedArrayList);
                return true;
            case 8:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                Bundle bundle5 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                E7(bundle5);
                return true;
            case 9:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                zzc(bundle6);
                return true;
            case 10:
                Parcelable.Creator creator8 = Bundle.CREATOR;
                zzm.b(parcel);
                zzm();
                return true;
            case 11:
                Parcelable.Creator creator9 = Bundle.CREATOR;
                zzm.b(parcel);
                zzk();
                return true;
            case 12:
                Parcelable.Creator creator10 = Bundle.CREATOR;
                Bundle bundle7 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                M8(bundle7);
                return true;
            case 13:
                Parcelable.Creator creator11 = Bundle.CREATOR;
                Bundle bundle8 = (Bundle) zzm.a(parcel);
                zzm.b(parcel);
                W(bundle8);
                return true;
            default:
                return false;
        }
    }
}
