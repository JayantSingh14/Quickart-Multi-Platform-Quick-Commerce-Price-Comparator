package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public final class IntentSenderRequest implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f218a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f219b;

    /* renamed from: c, reason: collision with root package name */
    public final int f220c;

    /* renamed from: d, reason: collision with root package name */
    public final int f221d;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final IntentSender f222a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f223b;

        /* renamed from: c, reason: collision with root package name */
        public int f224c;

        /* renamed from: d, reason: collision with root package name */
        public int f225d;

        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface Flag {
        }

        public Builder(IntentSender intentSender) {
            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
            this.f222a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f222a, this.f223b, this.f224c, this.f225d);
        }

        public final void b(Intent intent) {
            this.f223b = intent;
        }

        public final void c(int i2, int i3) {
            this.f225d = i2;
            this.f224c = i3;
        }
    }

    @Metadata
    public static final class Companion {
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        this.f218a = intentSender;
        this.f219b = intent;
        this.f220c = i2;
        this.f221d = i3;
    }

    public final Intent a() {
        return this.f219b;
    }

    public final int b() {
        return this.f220c;
    }

    public final int c() {
        return this.f221d;
    }

    public final IntentSender d() {
        return this.f218a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.f218a, i2);
        dest.writeParcelable(this.f219b, i2);
        dest.writeInt(this.f220c);
        dest.writeInt(this.f221d);
    }
}
