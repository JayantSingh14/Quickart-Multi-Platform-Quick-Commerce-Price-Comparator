package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ChannelIdValueCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class ChannelIdValue extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final ChannelIdValueType f22478a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22479b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22480c;

    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        /* JADX INFO: Fake field, exist only in values array */
        OBJECT(2);


        @NonNull
        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = new zza();

        /* renamed from: a, reason: collision with root package name */
        public final int f22484a;

        ChannelIdValueType(int i2) {
            this.f22484a = i2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f22484a);
        }
    }

    public static class UnsupportedChannelIdValueTypeException extends Exception {
    }

    static {
        new ChannelIdValue();
        new ChannelIdValue("unavailable");
        new ChannelIdValue("unused");
    }

    public ChannelIdValue() {
        this.f22478a = ChannelIdValueType.ABSENT;
        this.f22480c = null;
        this.f22479b = null;
    }

    public static ChannelIdValueType b(int i2) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (i2 == channelIdValueType.f22484a) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(b.g(i2, "ChannelIdValueType ", " not supported"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) obj;
        ChannelIdValueType channelIdValueType = channelIdValue.f22478a;
        ChannelIdValueType channelIdValueType2 = this.f22478a;
        if (!channelIdValueType2.equals(channelIdValueType)) {
            return false;
        }
        int iOrdinal = channelIdValueType2.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return this.f22479b.equals(channelIdValue.f22479b);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.f22480c.equals(channelIdValue.f22480c);
    }

    public final int hashCode() {
        int i2;
        int iHashCode;
        ChannelIdValueType channelIdValueType = this.f22478a;
        int iHashCode2 = channelIdValueType.hashCode() + 31;
        int iOrdinal = channelIdValueType.ordinal();
        if (iOrdinal == 1) {
            i2 = iHashCode2 * 31;
            iHashCode = this.f22479b.hashCode();
        } else {
            if (iOrdinal != 2) {
                return iHashCode2;
            }
            i2 = iHashCode2 * 31;
            iHashCode = this.f22480c.hashCode();
        }
        return iHashCode + i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f22478a.f22484a);
        SafeParcelWriter.writeString(parcel, 3, this.f22479b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22480c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public ChannelIdValue(int i2, String str, String str2) {
        try {
            this.f22478a = b(i2);
            this.f22479b = str;
            this.f22480c = str2;
        } catch (UnsupportedChannelIdValueTypeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public ChannelIdValue(String str) {
        this.f22479b = (String) Preconditions.checkNotNull(str);
        this.f22478a = ChannelIdValueType.STRING;
        this.f22480c = null;
    }
}
