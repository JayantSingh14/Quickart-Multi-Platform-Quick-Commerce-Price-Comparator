package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.reflect.InvocationTargetException;

@RestrictTo
/* loaded from: classes3.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        VersionedParcelable versionedParcelableO = remoteActionCompat.f2708a;
        if (versionedParcel.j(1)) {
            versionedParcelableO = versionedParcel.o();
        }
        remoteActionCompat.f2708a = (IconCompat) versionedParcelableO;
        CharSequence charSequenceI = remoteActionCompat.f2709b;
        if (versionedParcel.j(2)) {
            charSequenceI = versionedParcel.i();
        }
        remoteActionCompat.f2709b = charSequenceI;
        CharSequence charSequenceI2 = remoteActionCompat.f2710c;
        if (versionedParcel.j(3)) {
            charSequenceI2 = versionedParcel.i();
        }
        remoteActionCompat.f2710c = charSequenceI2;
        Parcelable parcelableM = remoteActionCompat.f2711d;
        if (versionedParcel.j(4)) {
            parcelableM = versionedParcel.m();
        }
        remoteActionCompat.f2711d = (PendingIntent) parcelableM;
        boolean zG = remoteActionCompat.f2712e;
        if (versionedParcel.j(5)) {
            zG = versionedParcel.g();
        }
        remoteActionCompat.f2712e = zG;
        boolean zG2 = remoteActionCompat.f2713f;
        if (versionedParcel.j(6)) {
            zG2 = versionedParcel.g();
        }
        remoteActionCompat.f2713f = zG2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        versionedParcel.q(false, false);
        IconCompat iconCompat = remoteActionCompat.f2708a;
        versionedParcel.p(1);
        versionedParcel.y(iconCompat);
        CharSequence charSequence = remoteActionCompat.f2709b;
        versionedParcel.p(2);
        versionedParcel.t(charSequence);
        CharSequence charSequence2 = remoteActionCompat.f2710c;
        versionedParcel.p(3);
        versionedParcel.t(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f2711d;
        versionedParcel.p(4);
        versionedParcel.w(pendingIntent);
        boolean z = remoteActionCompat.f2712e;
        versionedParcel.p(5);
        versionedParcel.r(z);
        boolean z2 = remoteActionCompat.f2713f;
        versionedParcel.p(6);
        versionedParcel.r(z2);
    }
}
