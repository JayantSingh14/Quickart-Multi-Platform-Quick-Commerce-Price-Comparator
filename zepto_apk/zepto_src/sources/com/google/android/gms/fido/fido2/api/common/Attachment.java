package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public enum Attachment implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    PLATFORM("platform"),
    /* JADX INFO: Fake field, exist only in values array */
    CROSS_PLATFORM("cross-platform");


    @NonNull
    public static final Parcelable.Creator<Attachment> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final String f22342a;

    public static class UnsupportedAttachmentException extends Exception {
    }

    Attachment(String str) {
        this.f22342a = str;
    }

    public static Attachment a(String str) throws UnsupportedAttachmentException {
        for (Attachment attachment : values()) {
            if (str.equals(attachment.f22342a)) {
                return attachment;
            }
        }
        throw new UnsupportedAttachmentException(b.D("Attachment ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f22342a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f22342a);
    }
}
