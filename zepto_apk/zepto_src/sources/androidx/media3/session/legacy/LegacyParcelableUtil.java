package androidx.media3.session.legacy;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.List;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class LegacyParcelableUtil {
    public static Parcelable a(Parcelable parcelable, Parcelable.Creator creator) {
        if (parcelable == null) {
            return null;
        }
        Parcelable parcelable2 = (Parcelable) c(parcelable);
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable2.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return (Parcelable) c((Parcelable) creator.createFromParcel(parcelObtain));
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList b(List list, Parcelable.Creator creator) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(a((Parcelable) list.get(i2), creator));
        }
        return arrayList;
    }

    public static Object c(Parcelable parcelable) {
        int i2 = Util.f5744a;
        if (i2 < 21 || i2 >= 23) {
            return parcelable;
        }
        if (!(parcelable instanceof MediaBrowserCompat.MediaItem)) {
            return parcelable instanceof android.support.v4.media.MediaDescriptionCompat ? d((android.support.v4.media.MediaDescriptionCompat) parcelable) : parcelable;
        }
        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) parcelable;
        return new MediaBrowserCompat.MediaItem(d(mediaItem.f44b), mediaItem.f43a);
    }

    public static android.support.v4.media.MediaDescriptionCompat d(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        String str = mediaDescriptionCompat.f51a;
        builder.f60a = str;
        CharSequence charSequence = mediaDescriptionCompat.f52b;
        builder.f61b = charSequence;
        CharSequence charSequence2 = mediaDescriptionCompat.f53c;
        builder.f62c = charSequence2;
        CharSequence charSequence3 = mediaDescriptionCompat.f54d;
        builder.f63d = charSequence3;
        Bitmap bitmap = mediaDescriptionCompat.f55e;
        builder.f64e = bitmap;
        Uri uri = mediaDescriptionCompat.f56f;
        builder.f65f = uri;
        Bundle bundle = mediaDescriptionCompat.f57g;
        builder.f66g = bundle;
        Uri uri2 = mediaDescriptionCompat.f58h;
        builder.f67h = uri2;
        return new android.support.v4.media.MediaDescriptionCompat(str, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2);
    }
}
