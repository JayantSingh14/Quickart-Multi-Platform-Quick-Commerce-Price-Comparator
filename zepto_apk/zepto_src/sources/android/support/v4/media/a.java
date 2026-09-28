package android.support.v4.media;

import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import androidx.media3.common.Format;
import androidx.media3.common.util.Log;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.session.PlayerInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.ads.interactivemedia.v3.internal.zzabw;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.atv_ads_framework.zzcv;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static int A(int i2, int i3, int i4, int i5) {
        return ((i2 + i3) - i4) + i5;
    }

    public static int B(int i2, int i3, int i4) {
        return (zzcv.s(i2) * i3) + i4;
    }

    public static int C(int i2, int i3, int i4, int i5) {
        return zzcv.s(i2) + i3 + i4 + i5;
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static int b(int i2, int i3, int i4) {
        return (Integer.hashCode(i2) + i3) * i4;
    }

    public static int c(int i2, int i3, int i4, int i5) {
        return ((i2 - i3) * i4) + i5;
    }

    public static int d(int i2, int i3, long j2) {
        return (Long.hashCode(j2) + i2) * i3;
    }

    public static PlayerInfo.Builder e(PlayerInfo playerInfo, PlayerInfo playerInfo2) {
        playerInfo.getClass();
        return new PlayerInfo.Builder(playerInfo2);
    }

    public static IObjectWrapper f(Parcel parcel) {
        IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapperG;
    }

    public static IObjectWrapper g(Parcel parcel, Parcel parcel2) {
        IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
        zzbcd.f(parcel2);
        return iObjectWrapperG;
    }

    public static FieldDescriptor h(AtProtobuf atProtobuf, FieldDescriptor.Builder builder) {
        Protobuf protobufA = atProtobuf.a();
        if (builder.f44497b == null) {
            builder.f44497b = new HashMap();
        }
        builder.f44497b.put(protobufA.annotationType(), protobufA);
        return new FieldDescriptor(builder.f44496a, builder.f44497b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(builder.f44497b)));
    }

    public static /* synthetic */ Object i(DataSource.Factory factory, DataSource.Factory factory2) {
        return factory != null ? factory : factory2;
    }

    public static /* synthetic */ Object j(AdsMediaSource adsMediaSource, MediaSource mediaSource) {
        if (adsMediaSource != null) {
            return adsMediaSource;
        }
        Objects.requireNonNull(mediaSource, "defaultObj");
        return mediaSource;
    }

    public static String k(int i2, int i3, String str) {
        return str.substring(i3, str.length() - i2);
    }

    public static String l(Uri uri, String str) {
        return str + uri;
    }

    public static String m(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.D());
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static /* synthetic */ Map o(String str, String str2, String str3) {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry(APayConstants.Error.MESSAGE, str), new AbstractMap.SimpleEntry("code", str2), new AbstractMap.SimpleEntry("type", str3)};
        HashMap map = new HashMap(3);
        for (int i2 = 0; i2 < 3; i2++) {
            Map.Entry entry = entryArr[i2];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(b.j(key, "duplicate key: "));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static void p(int i2, int i3, int i4, HashMap map, String str) {
        map.put(str, Integer.valueOf(Color.rgb(i2, i3, i4)));
    }

    public static void q(int i2, int i3, String str, String str2, StringBuilder sb) {
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        sb.append(str2);
    }

    public static void r(int i2, String str, String str2) {
        Log.h(str2, str + i2);
    }

    public static void s(Format.Builder builder, TrackOutput trackOutput) {
        trackOutput.b(new Format(builder));
    }

    public static void t(String str, String str2, String str3) {
        android.util.Log.d(str3, str + str2);
    }

    public static void u(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static /* synthetic */ boolean v(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }

    public static int w(int i2, int i3, int i4) {
        return zzabw.zzw(i2) + i3 + i4;
    }

    public static int x(int i2, int i3, int i4, int i5) {
        return ((i2 * i3) / i4) + i5;
    }

    public static void y(String str, String str2, String str3) {
        Log.h(str3, str + str2);
    }

    public static int z(int i2, int i3, int i4) {
        return zzcv.s(i2) + i3 + i4;
    }
}
