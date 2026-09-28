package com.amazon.identity.auth.device.dataobject;

import android.content.ContentValues;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import f.c;
import f.n;
import k.b;

/* loaded from: classes3.dex */
public class RequestedScope extends AbstractDataObject implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    public String f15227b;

    /* renamed from: c, reason: collision with root package name */
    public String f15228c;

    /* renamed from: d, reason: collision with root package name */
    public String f15229d;

    /* renamed from: e, reason: collision with root package name */
    public long f15230e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f15231f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f15226g = {"rowid", "Scope", "AppId", "DirectedId", "AtzAccessTokenId", "AtzRefreshTokenId"};
    public static final Parcelable.Creator<RequestedScope> CREATOR = new a();

    public class a implements Parcelable.Creator<RequestedScope> {
        @Override // android.os.Parcelable.Creator
        public final RequestedScope createFromParcel(Parcel parcel) {
            RequestedScope requestedScope = new RequestedScope();
            requestedScope.f15230e = -1L;
            requestedScope.f15231f = -1L;
            requestedScope.f15203a = parcel.readLong();
            requestedScope.f15227b = parcel.readString();
            requestedScope.f15228c = parcel.readString();
            requestedScope.f15229d = parcel.readString();
            requestedScope.f15230e = parcel.readLong();
            requestedScope.f15231f = parcel.readLong();
            return requestedScope;
        }

        @Override // android.os.Parcelable.Creator
        public final RequestedScope[] newArray(int i2) {
            return new RequestedScope[i2];
        }
    }

    public RequestedScope(String str, String str2, String str3) {
        this.f15227b = str;
        this.f15228c = str2;
        this.f15229d = str3;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final c c(Context context) {
        n nVar;
        synchronized (n.class) {
            try {
                if (n.f48367b == null) {
                    n.f48367b = new n(b.b(context));
                }
                nVar = n.f48367b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public final Object clone() {
        long j2 = this.f15203a;
        String str = this.f15227b;
        String str2 = this.f15228c;
        String str3 = this.f15229d;
        long j3 = this.f15230e;
        long j4 = this.f15231f;
        RequestedScope requestedScope = new RequestedScope(str, str2, str3);
        requestedScope.f15230e = j3;
        requestedScope.f15231f = j4;
        requestedScope.f15203a = j2;
        return requestedScope;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final ContentValues d(Context context) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = f15226g;
        contentValues.put(strArr[1], this.f15227b);
        contentValues.put(strArr[2], this.f15228c);
        contentValues.put(strArr[3], this.f15229d);
        contentValues.put(strArr[4], Long.valueOf(this.f15230e));
        contentValues.put(strArr[5], Long.valueOf(this.f15231f));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof RequestedScope) {
            try {
                RequestedScope requestedScope = (RequestedScope) obj;
                if (this.f15227b.equals(requestedScope.f15227b) && this.f15228c.equals(requestedScope.f15228c) && this.f15229d.equals(requestedScope.f15229d) && this.f15230e == requestedScope.f15230e) {
                    if (this.f15231f == requestedScope.f15231f) {
                        return true;
                    }
                }
                return false;
            } catch (NullPointerException e2) {
                e2.toString();
            }
        }
        return false;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final String toString() {
        StringBuilder sb = new StringBuilder("{ rowid=");
        sb.append(this.f15203a);
        sb.append(", scope=");
        sb.append(this.f15227b);
        sb.append(", appFamilyId=");
        sb.append(this.f15228c);
        sb.append(", directedId=<obscured>, atzAccessTokenId=");
        sb.append(this.f15230e);
        sb.append(", atzRefreshTokenId=");
        return android.support.v4.media.b.p(sb, this.f15231f, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f15203a);
        parcel.writeString(this.f15227b);
        parcel.writeString(this.f15228c);
        parcel.writeString(this.f15229d);
        parcel.writeLong(this.f15230e);
        parcel.writeLong(this.f15231f);
    }

    public RequestedScope() {
    }
}
