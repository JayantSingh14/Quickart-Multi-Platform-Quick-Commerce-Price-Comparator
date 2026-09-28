package com.chuckerteam.chucker.internal.data.har.log.entry;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class Timings {

    @SerializedName("blocked")
    @Nullable
    private final Long blocked;

    @SerializedName("comment")
    @NotNull
    private final String comment;

    @SerializedName("connect")
    private final long connect;

    @SerializedName("dns")
    @Nullable
    private final Long dns;

    @SerializedName("receive")
    private final long receive;

    @SerializedName("send")
    private final long send;

    @SerializedName("ssl")
    @Nullable
    private final Long ssl;

    @SerializedName("wait")
    private final long wait;

    public Timings(HttpTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Long tookMs = transaction.getTookMs();
        long jLongValue = tookMs != null ? tookMs.longValue() : 0L;
        Intrinsics.checkNotNullParameter("The information described by this object is incomplete.", "comment");
        this.blocked = null;
        this.dns = null;
        this.ssl = null;
        this.connect = 0L;
        this.send = 0L;
        this.wait = jLongValue;
        this.receive = 0L;
        this.comment = "The information described by this object is incomplete.";
    }

    public final long a() {
        Long l2 = this.blocked;
        long jLongValue = l2 != null ? l2.longValue() : 0L;
        Long l3 = this.dns;
        long jLongValue2 = jLongValue + (l3 != null ? l3.longValue() : 0L);
        Long l4 = this.ssl;
        return jLongValue2 + (l4 != null ? l4.longValue() : 0L) + this.connect + this.send + this.wait + this.receive;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timings)) {
            return false;
        }
        Timings timings = (Timings) obj;
        return Intrinsics.b(this.blocked, timings.blocked) && Intrinsics.b(this.dns, timings.dns) && Intrinsics.b(this.ssl, timings.ssl) && this.connect == timings.connect && this.send == timings.send && this.wait == timings.wait && this.receive == timings.receive && Intrinsics.b(this.comment, timings.comment);
    }

    public final int hashCode() {
        Long l2 = this.blocked;
        int iHashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        Long l3 = this.dns;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.ssl;
        return this.comment.hashCode() + a.d(a.d(a.d(a.d((iHashCode2 + (l4 != null ? l4.hashCode() : 0)) * 31, 31, this.connect), 31, this.send), 31, this.wait), 31, this.receive);
    }

    public final String toString() {
        Long l2 = this.blocked;
        Long l3 = this.dns;
        Long l4 = this.ssl;
        long j2 = this.connect;
        long j3 = this.send;
        long j4 = this.wait;
        long j5 = this.receive;
        String str = this.comment;
        StringBuilder sb = new StringBuilder("Timings(blocked=");
        sb.append(l2);
        sb.append(", dns=");
        sb.append(l3);
        sb.append(", ssl=");
        sb.append(l4);
        sb.append(", connect=");
        sb.append(j2);
        e.A(sb, ", send=", j3, ", wait=");
        sb.append(j4);
        e.A(sb, ", receive=", j5, ", comment=");
        return b.r(sb, str, ")");
    }
}
