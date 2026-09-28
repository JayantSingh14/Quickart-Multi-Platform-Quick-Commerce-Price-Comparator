package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f10658a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10659b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10660c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10661d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10662e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10663f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f10664g;

    /* renamed from: h, reason: collision with root package name */
    public final long f10665h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractCollection f10666i;

    /* renamed from: j, reason: collision with root package name */
    public final long f10667j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f10668k;

    /* renamed from: l, reason: collision with root package name */
    public PlaybackState f10669l;

    /* renamed from: androidx.media3.session.legacy.PlaybackStateCompat$1, reason: invalid class name */
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

        @Nullable
        @DoNotInline
        public static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @Nullable
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
        public static void v(PlaybackState.Builder builder, @Nullable CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        public static void w(PlaybackState.CustomAction.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        public static void x(PlaybackState.Builder builder, int i2, long j2, float f2, long j3) {
            builder.setState(i2, j2, f2, j3);
        }
    }

    @RequiresApi
    public static class Api22Impl {
        @Nullable
        @DoNotInline
        public static Bundle a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        @DoNotInline
        public static void b(PlaybackState.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, ArrayList arrayList, long j6, Bundle bundle) {
        this.f10658a = i2;
        this.f10659b = j2;
        this.f10660c = j3;
        this.f10661d = f2;
        this.f10662e = j4;
        this.f10663f = i3;
        this.f10664g = charSequence;
        this.f10665h = j5;
        this.f10666i = arrayList == null ? ImmutableList.r() : new ArrayList(arrayList);
        this.f10667j = j6;
        this.f10668k = bundle;
    }

    public static PlaybackStateCompat a(PlaybackState playbackState) {
        ArrayList arrayList = null;
        if (playbackState == null) {
            return null;
        }
        List<PlaybackState.CustomAction> listJ = Api21Impl.j(playbackState);
        if (listJ != null) {
            arrayList = new ArrayList(listJ.size());
            for (PlaybackState.CustomAction customAction : listJ) {
                if (customAction != null) {
                    PlaybackState.CustomAction customAction2 = customAction;
                    Bundle bundleL = Api21Impl.l(customAction2);
                    MediaSessionCompat.a(bundleL);
                    CustomAction customAction3 = new CustomAction(Api21Impl.f(customAction2), Api21Impl.o(customAction2), Api21Impl.m(customAction2), bundleL);
                    customAction3.f10685e = customAction2;
                    arrayList.add(customAction3);
                }
            }
        }
        Bundle bundleA = Api22Impl.a(playbackState);
        MediaSessionCompat.a(bundleA);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(Api21Impl.r(playbackState), Api21Impl.q(playbackState), Api21Impl.i(playbackState), Api21Impl.p(playbackState), Api21Impl.g(playbackState), 0, Api21Impl.k(playbackState), Api21Impl.n(playbackState), arrayList, Api21Impl.h(playbackState), bundleA);
        playbackStateCompat.f10669l = playbackState;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f10658a);
        sb.append(", position=");
        sb.append(this.f10659b);
        sb.append(", buffered position=");
        sb.append(this.f10660c);
        sb.append(", speed=");
        sb.append(this.f10661d);
        sb.append(", updated=");
        sb.append(this.f10665h);
        sb.append(", actions=");
        sb.append(this.f10662e);
        sb.append(", error code=");
        sb.append(this.f10663f);
        sb.append(", error message=");
        sb.append(this.f10664g);
        sb.append(", custom actions=");
        sb.append(this.f10666i);
        sb.append(", active item id=");
        return b.p(sb, this.f10667j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10658a);
        parcel.writeLong(this.f10659b);
        parcel.writeFloat(this.f10661d);
        parcel.writeLong(this.f10665h);
        parcel.writeLong(this.f10660c);
        parcel.writeLong(this.f10662e);
        TextUtils.writeToParcel(this.f10664g, parcel, i2);
        parcel.writeTypedList(this.f10666i);
        parcel.writeLong(this.f10667j);
        parcel.writeBundle(this.f10668k);
        parcel.writeInt(this.f10663f);
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10670a;

        /* renamed from: b, reason: collision with root package name */
        public int f10671b;

        /* renamed from: c, reason: collision with root package name */
        public long f10672c;

        /* renamed from: d, reason: collision with root package name */
        public long f10673d;

        /* renamed from: e, reason: collision with root package name */
        public float f10674e;

        /* renamed from: f, reason: collision with root package name */
        public long f10675f;

        /* renamed from: g, reason: collision with root package name */
        public int f10676g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f10677h;

        /* renamed from: i, reason: collision with root package name */
        public long f10678i;

        /* renamed from: j, reason: collision with root package name */
        public long f10679j;

        /* renamed from: k, reason: collision with root package name */
        public Bundle f10680k;

        public Builder() {
            this.f10670a = new ArrayList();
            this.f10679j = -1L;
        }

        public final PlaybackStateCompat a() {
            return new PlaybackStateCompat(this.f10671b, this.f10672c, this.f10673d, this.f10674e, this.f10675f, this.f10676g, this.f10677h, this.f10678i, this.f10670a, this.f10679j, this.f10680k);
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f10670a = arrayList;
            this.f10679j = -1L;
            this.f10671b = playbackStateCompat.f10658a;
            this.f10672c = playbackStateCompat.f10659b;
            this.f10674e = playbackStateCompat.f10661d;
            this.f10678i = playbackStateCompat.f10665h;
            this.f10673d = playbackStateCompat.f10660c;
            this.f10675f = playbackStateCompat.f10662e;
            this.f10676g = playbackStateCompat.f10663f;
            this.f10677h = playbackStateCompat.f10664g;
            AbstractCollection abstractCollection = playbackStateCompat.f10666i;
            if (abstractCollection != null) {
                arrayList.addAll(abstractCollection);
            }
            this.f10679j = playbackStateCompat.f10667j;
            this.f10680k = playbackStateCompat.f10668k;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final String f10681a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f10682b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10683c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f10684d;

        /* renamed from: e, reason: collision with root package name */
        public PlaybackState.CustomAction f10685e;

        /* renamed from: androidx.media3.session.legacy.PlaybackStateCompat$CustomAction$1, reason: invalid class name */
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

            /* renamed from: a, reason: collision with root package name */
            public final String f10686a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f10687b;

            /* renamed from: c, reason: collision with root package name */
            public final int f10688c;

            public Builder(String str, CharSequence charSequence, int i2) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                if (i2 == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                }
                this.f10686a = str;
                this.f10687b = charSequence;
                this.f10688c = i2;
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f10681a = str;
            this.f10682b = charSequence;
            this.f10683c = i2;
            this.f10684d = bundle;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f10682b) + ", mIcon=" + this.f10683c + ", mExtras=" + this.f10684d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f10681a);
            TextUtils.writeToParcel(this.f10682b, parcel, i2);
            parcel.writeInt(this.f10683c);
            parcel.writeBundle(this.f10684d);
        }

        public CustomAction(Parcel parcel) {
            String string = parcel.readString();
            string.getClass();
            this.f10681a = string;
            CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            charSequence.getClass();
            this.f10682b = charSequence;
            this.f10683c = parcel.readInt();
            this.f10684d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f10658a = parcel.readInt();
        this.f10659b = parcel.readLong();
        this.f10661d = parcel.readFloat();
        this.f10665h = parcel.readLong();
        this.f10660c = parcel.readLong();
        this.f10662e = parcel.readLong();
        this.f10664g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        AbstractCollection abstractCollectionCreateTypedArrayList = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f10666i = abstractCollectionCreateTypedArrayList == null ? ImmutableList.r() : abstractCollectionCreateTypedArrayList;
        this.f10667j = parcel.readLong();
        this.f10668k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f10663f = parcel.readInt();
    }
}
