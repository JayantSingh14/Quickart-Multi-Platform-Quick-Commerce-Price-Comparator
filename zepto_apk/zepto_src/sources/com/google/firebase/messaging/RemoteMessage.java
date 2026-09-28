package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.json.JSONException;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f44732a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayMap f44733b;

    /* renamed from: c, reason: collision with root package name */
    public Notification f44734c;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f44735a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayMap f44736b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f44735a = bundle;
            this.f44736b = new ArrayMap();
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(android.support.v4.media.b.C("Invalid to: ", str));
            }
            bundle.putString("google.to", str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {

        /* renamed from: a, reason: collision with root package name */
        public final String f44737a;

        /* renamed from: b, reason: collision with root package name */
        public final String f44738b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f44739c;

        /* renamed from: d, reason: collision with root package name */
        public final String f44740d;

        /* renamed from: e, reason: collision with root package name */
        public final String f44741e;

        /* renamed from: f, reason: collision with root package name */
        public final String[] f44742f;

        /* renamed from: g, reason: collision with root package name */
        public final String f44743g;

        /* renamed from: h, reason: collision with root package name */
        public final String f44744h;

        /* renamed from: i, reason: collision with root package name */
        public final String f44745i;

        /* renamed from: j, reason: collision with root package name */
        public final String f44746j;

        /* renamed from: k, reason: collision with root package name */
        public final String f44747k;

        /* renamed from: l, reason: collision with root package name */
        public final String f44748l;

        /* renamed from: m, reason: collision with root package name */
        public final Uri f44749m;
        public final String n;
        public final Integer o;
        public final Integer p;
        public final Integer q;

        public Notification(NotificationParams notificationParams) throws JSONException {
            String[] strArr;
            String[] strArr2;
            this.f44737a = notificationParams.i("gcm.n.title");
            this.f44738b = notificationParams.f("gcm.n.title");
            Object[] objArrE = notificationParams.e("gcm.n.title");
            if (objArrE == null) {
                strArr = null;
            } else {
                strArr = new String[objArrE.length];
                for (int i2 = 0; i2 < objArrE.length; i2++) {
                    strArr[i2] = String.valueOf(objArrE[i2]);
                }
            }
            this.f44739c = strArr;
            this.f44740d = notificationParams.i("gcm.n.body");
            this.f44741e = notificationParams.f("gcm.n.body");
            Object[] objArrE2 = notificationParams.e("gcm.n.body");
            if (objArrE2 == null) {
                strArr2 = null;
            } else {
                strArr2 = new String[objArrE2.length];
                for (int i3 = 0; i3 < objArrE2.length; i3++) {
                    strArr2[i3] = String.valueOf(objArrE2[i3]);
                }
            }
            this.f44742f = strArr2;
            this.f44743g = notificationParams.i("gcm.n.icon");
            String strI = notificationParams.i("gcm.n.sound2");
            this.f44745i = TextUtils.isEmpty(strI) ? notificationParams.i("gcm.n.sound") : strI;
            notificationParams.i("gcm.n.tag");
            this.f44746j = notificationParams.i("gcm.n.color");
            this.f44747k = notificationParams.i("gcm.n.click_action");
            this.f44748l = notificationParams.i("gcm.n.android_channel_id");
            String strI2 = notificationParams.i("gcm.n.link_android");
            strI2 = TextUtils.isEmpty(strI2) ? notificationParams.i("gcm.n.link") : strI2;
            this.f44749m = TextUtils.isEmpty(strI2) ? null : Uri.parse(strI2);
            this.f44744h = notificationParams.i("gcm.n.image");
            this.n = notificationParams.i("gcm.n.ticker");
            this.o = notificationParams.b("gcm.n.notification_priority");
            this.p = notificationParams.b("gcm.n.visibility");
            this.q = notificationParams.b("gcm.n.notification_count");
            notificationParams.a("gcm.n.sticky");
            notificationParams.a("gcm.n.local_only");
            notificationParams.a("gcm.n.default_sound");
            notificationParams.a("gcm.n.default_vibrate_timings");
            notificationParams.a("gcm.n.default_light_settings");
            notificationParams.g();
            notificationParams.d();
            notificationParams.j();
        }
    }

    public RemoteMessage(Bundle bundle) {
        this.f44732a = bundle;
    }

    public final String A() {
        return this.f44732a.getString("google.to");
    }

    public final void N(Intent intent) {
        intent.putExtras(this.f44732a);
    }

    public final Map b() {
        if (this.f44733b == null) {
            ArrayMap arrayMap = new ArrayMap();
            Bundle bundle = this.f44732a;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.f44733b = arrayMap;
        }
        return this.f44733b;
    }

    public final String r() {
        Bundle bundle = this.f44732a;
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString("message_id") : string;
    }

    public final Notification s() {
        if (this.f44734c == null) {
            Bundle bundle = this.f44732a;
            if (NotificationParams.k(bundle)) {
                this.f44734c = new Notification(new NotificationParams(bundle));
            }
        }
        return this.f44734c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.f44732a, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
