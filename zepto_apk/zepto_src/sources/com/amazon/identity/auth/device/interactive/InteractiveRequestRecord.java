package com.amazon.identity.auth.device.interactive;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class InteractiveRequestRecord implements Parcelable {
    public static final Parcelable.Creator<InteractiveRequestRecord> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f15239a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f15240b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f15241c;

    public class a implements Parcelable.Creator<InteractiveRequestRecord> {
        @Override // android.os.Parcelable.Creator
        public final InteractiveRequestRecord createFromParcel(Parcel parcel) {
            return new InteractiveRequestRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final InteractiveRequestRecord[] newArray(int i2) {
            return new InteractiveRequestRecord[i2];
        }
    }

    public InteractiveRequestRecord(String str, Bundle bundle) {
        this.f15239a = str;
        this.f15240b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InteractiveRequestRecord.class != obj.getClass()) {
            return false;
        }
        InteractiveRequestRecord interactiveRequestRecord = (InteractiveRequestRecord) obj;
        Bundle bundle = this.f15241c;
        if (bundle == null) {
            if (interactiveRequestRecord.f15241c != null) {
                return false;
            }
        } else if (!bundle.equals(interactiveRequestRecord.f15241c)) {
            return false;
        }
        Bundle bundle2 = this.f15240b;
        if (bundle2 == null) {
            if (interactiveRequestRecord.f15240b != null) {
                return false;
            }
        } else if (!bundle2.equals(interactiveRequestRecord.f15240b)) {
            return false;
        }
        String str = this.f15239a;
        if (str == null) {
            if (interactiveRequestRecord.f15239a != null) {
                return false;
            }
        } else if (!str.equals(interactiveRequestRecord.f15239a)) {
            return false;
        }
        return true;
    }

    public Bundle getRequestExtras() {
        return this.f15240b;
    }

    public String getRequestId() {
        return this.f15239a;
    }

    public int hashCode() {
        Bundle bundle = this.f15241c;
        int iHashCode = ((bundle == null ? 0 : bundle.hashCode()) + 31) * 31;
        Bundle bundle2 = this.f15240b;
        int iHashCode2 = (iHashCode + (bundle2 == null ? 0 : bundle2.hashCode())) * 31;
        String str = this.f15239a;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" id=");
        sb.append(this.f15239a);
        sb.append(" hasFragment=");
        sb.append(this.f15241c != null);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15239a);
        parcel.writeBundle(this.f15240b);
        parcel.writeBundle(this.f15241c);
    }

    public InteractiveRequestRecord(Parcel parcel) {
        this.f15239a = parcel.readString();
        this.f15240b = parcel.readBundle();
        this.f15241c = parcel.readBundle();
    }
}
