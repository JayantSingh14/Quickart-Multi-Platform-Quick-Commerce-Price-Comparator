package com.facebook.common.callercontext;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ContextChain implements Parcelable {
    public static final Parcelable.Creator<ContextChain> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f17062a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17063b;

    /* renamed from: c, reason: collision with root package name */
    public final ContextChain f17064c;

    /* renamed from: d, reason: collision with root package name */
    public String f17065d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17066e;

    /* renamed from: com.facebook.common.callercontext.ContextChain$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ContextChain> {
        @Override // android.os.Parcelable.Creator
        public final ContextChain createFromParcel(Parcel parcel) {
            return new ContextChain(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ContextChain[] newArray(int i2) {
            return new ContextChain[i2];
        }
    }

    public ContextChain(Parcel parcel) {
        this.f17062a = parcel.readString();
        this.f17063b = parcel.readString();
        this.f17066e = parcel.readString();
        this.f17064c = (ContextChain) parcel.readParcelable(ContextChain.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ContextChain contextChain = (ContextChain) obj;
            if (Objects.equals(this.f17066e, contextChain.f17066e) && Objects.equals(this.f17064c, contextChain.f17064c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f17064c, this.f17066e);
    }

    public final String toString() {
        if (this.f17065d == null) {
            this.f17065d = this.f17066e;
            ContextChain contextChain = this.f17064c;
            if (contextChain != null) {
                this.f17065d = contextChain.toString() + '/' + this.f17065d;
            }
        }
        return this.f17065d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17062a);
        parcel.writeString(this.f17063b);
        parcel.writeString(this.f17066e);
        parcel.writeParcelable(this.f17064c, i2);
    }
}
