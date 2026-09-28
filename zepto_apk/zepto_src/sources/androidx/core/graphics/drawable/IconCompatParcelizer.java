package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

@RestrictTo
/* loaded from: classes3.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2843a = versionedParcel.l(iconCompat.f2843a, 1);
        byte[] bArrH = iconCompat.f2845c;
        if (versionedParcel.j(2)) {
            bArrH = versionedParcel.h();
        }
        iconCompat.f2845c = bArrH;
        Parcelable parcelableM = iconCompat.f2846d;
        if (versionedParcel.j(3)) {
            parcelableM = versionedParcel.m();
        }
        iconCompat.f2846d = parcelableM;
        iconCompat.f2847e = versionedParcel.l(iconCompat.f2847e, 4);
        iconCompat.f2848f = versionedParcel.l(iconCompat.f2848f, 5);
        Parcelable parcelableM2 = iconCompat.f2849g;
        if (versionedParcel.j(6)) {
            parcelableM2 = versionedParcel.m();
        }
        iconCompat.f2849g = (ColorStateList) parcelableM2;
        String strN = iconCompat.f2851i;
        if (versionedParcel.j(7)) {
            strN = versionedParcel.n();
        }
        iconCompat.f2851i = strN;
        String strN2 = iconCompat.f2852j;
        if (versionedParcel.j(8)) {
            strN2 = versionedParcel.n();
        }
        iconCompat.f2852j = strN2;
        iconCompat.f2850h = PorterDuff.Mode.valueOf(iconCompat.f2851i);
        switch (iconCompat.f2843a) {
            case -1:
                Parcelable parcelable = iconCompat.f2846d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f2844b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f2846d;
                if (parcelable2 != null) {
                    iconCompat.f2844b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr = iconCompat.f2845c;
                iconCompat.f2844b = bArr;
                iconCompat.f2843a = 3;
                iconCompat.f2847e = 0;
                iconCompat.f2848f = bArr.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f2845c, Charset.forName("UTF-16"));
                iconCompat.f2844b = str;
                if (iconCompat.f2843a == 2 && iconCompat.f2852j == null) {
                    iconCompat.f2852j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f2844b = iconCompat.f2845c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.q(true, true);
        boolean zF = versionedParcel.f();
        iconCompat.f2851i = iconCompat.f2850h.name();
        switch (iconCompat.f2843a) {
            case -1:
                if (!zF) {
                    iconCompat.f2846d = (Parcelable) iconCompat.f2844b;
                    break;
                } else {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
            case 1:
            case 5:
                if (!zF) {
                    iconCompat.f2846d = (Parcelable) iconCompat.f2844b;
                    break;
                } else {
                    Bitmap bitmap = (Bitmap) iconCompat.f2844b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    iconCompat.f2845c = byteArrayOutputStream.toByteArray();
                    break;
                }
            case 2:
                iconCompat.f2845c = ((String) iconCompat.f2844b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f2845c = (byte[]) iconCompat.f2844b;
                break;
            case 4:
            case 6:
                iconCompat.f2845c = iconCompat.f2844b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f2843a;
        if (-1 != i2) {
            versionedParcel.v(i2, 1);
        }
        byte[] bArr = iconCompat.f2845c;
        if (bArr != null) {
            versionedParcel.p(2);
            versionedParcel.s(bArr);
        }
        Parcelable parcelable = iconCompat.f2846d;
        if (parcelable != null) {
            versionedParcel.p(3);
            versionedParcel.w(parcelable);
        }
        int i3 = iconCompat.f2847e;
        if (i3 != 0) {
            versionedParcel.v(i3, 4);
        }
        int i4 = iconCompat.f2848f;
        if (i4 != 0) {
            versionedParcel.v(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f2849g;
        if (colorStateList != null) {
            versionedParcel.p(6);
            versionedParcel.w(colorStateList);
        }
        String str = iconCompat.f2851i;
        if (str != null) {
            versionedParcel.p(7);
            versionedParcel.x(str);
        }
        String str2 = iconCompat.f2852j;
        if (str2 != null) {
            versionedParcel.p(8);
            versionedParcel.x(str2);
        }
    }
}
