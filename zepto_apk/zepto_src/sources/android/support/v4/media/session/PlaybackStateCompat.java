package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f98a;

    /* renamed from: b, reason: collision with root package name */
    public final long f99b;

    /* renamed from: c, reason: collision with root package name */
    public final long f100c;

    /* renamed from: d, reason: collision with root package name */
    public final float f101d;

    /* renamed from: e, reason: collision with root package name */
    public final long f102e;

    /* renamed from: f, reason: collision with root package name */
    public final int f103f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f104g;

    /* renamed from: h, reason: collision with root package name */
    public final long f105h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f106i;

    /* renamed from: j, reason: collision with root package name */
    public final long f107j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f108k;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Actions {
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        @DoNotInline
        public static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        @DoNotInline
        public static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i2) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i2);
        }

        @DoNotInline
        public static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        @DoNotInline
        public static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        @DoNotInline
        public static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        @DoNotInline
        public static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        @DoNotInline
        public static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        @DoNotInline
        public static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @DoNotInline
        public static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        @DoNotInline
        public static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        @DoNotInline
        public static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        @DoNotInline
        public static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        @DoNotInline
        public static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        @DoNotInline
        public static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        @DoNotInline
        public static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        @DoNotInline
        public static void s(PlaybackState.Builder builder, long j2) {
            builder.setActions(j2);
        }

        @DoNotInline
        public static void t(PlaybackState.Builder builder, long j2) {
            builder.setActiveQueueItemId(j2);
        }

        @DoNotInline
        public static void u(PlaybackState.Builder builder, long j2) {
            builder.setBufferedPosition(j2);
        }

        @DoNotInline
        public static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        public static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        public static void x(PlaybackState.Builder builder, int i2, long j2, float f2, long j3) {
            builder.setState(i2, j2, f2, j3);
        }
    }

    @RequiresApi
    public static class Api22Impl {
        @DoNotInline
        public static Bundle a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        @DoNotInline
        public static void b(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface State {
    }

    public PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, ArrayList arrayList, long j6, Bundle bundle) {
        this.f98a = i2;
        this.f99b = j2;
        this.f100c = j3;
        this.f101d = f2;
        this.f102e = j4;
        this.f103f = i3;
        this.f104g = charSequence;
        this.f105h = j5;
        this.f106i = new ArrayList(arrayList);
        this.f107j = j6;
        this.f108k = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f98a);
        sb.append(", position=");
        sb.append(this.f99b);
        sb.append(", buffered position=");
        sb.append(this.f100c);
        sb.append(", speed=");
        sb.append(this.f101d);
        sb.append(", updated=");
        sb.append(this.f105h);
        sb.append(", actions=");
        sb.append(this.f102e);
        sb.append(", error code=");
        sb.append(this.f103f);
        sb.append(", error message=");
        sb.append(this.f104g);
        sb.append(", custom actions=");
        sb.append(this.f106i);
        sb.append(", active item id=");
        return b.p(sb, this.f107j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f98a);
        parcel.writeLong(this.f99b);
        parcel.writeFloat(this.f101d);
        parcel.writeLong(this.f105h);
        parcel.writeLong(this.f100c);
        parcel.writeLong(this.f102e);
        TextUtils.writeToParcel(this.f104g, parcel, i2);
        parcel.writeTypedList(this.f106i);
        parcel.writeLong(this.f107j);
        parcel.writeBundle(this.f108k);
        parcel.writeInt(this.f103f);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final String f109a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f110b;

        /* renamed from: c, reason: collision with root package name */
        public final int f111c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f112d;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            public final CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        public static final class Builder {
        }

        public CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f109a = str;
            this.f110b = charSequence;
            this.f111c = i2;
            this.f112d = bundle;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f110b) + ", mIcon=" + this.f111c + ", mExtras=" + this.f112d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f109a);
            TextUtils.writeToParcel(this.f110b, parcel, i2);
            parcel.writeInt(this.f111c);
            parcel.writeBundle(this.f112d);
        }

        public CustomAction(Parcel parcel) {
            this.f109a = parcel.readString();
            this.f110b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f111c = parcel.readInt();
            this.f112d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f98a = parcel.readInt();
        this.f99b = parcel.readLong();
        this.f101d = parcel.readFloat();
        this.f105h = parcel.readLong();
        this.f100c = parcel.readLong();
        this.f102e = parcel.readLong();
        this.f104g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f106i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f107j = parcel.readLong();
        this.f108k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f103f = parcel.readInt();
    }
}
