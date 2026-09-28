package com.chuckerteam.chucker.internal.data.entity;

import android.support.v4.media.b;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpTransactionTuple {

    /* renamed from: a, reason: collision with root package name */
    public final long f16698a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f16699b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f16700c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16701d;

    /* renamed from: e, reason: collision with root package name */
    public final String f16702e;

    /* renamed from: f, reason: collision with root package name */
    public final String f16703f;

    /* renamed from: g, reason: collision with root package name */
    public final String f16704g;

    /* renamed from: h, reason: collision with root package name */
    public final String f16705h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f16706i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f16707j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f16708k;

    /* renamed from: l, reason: collision with root package name */
    public final String f16709l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f16710m;
    public final String n;

    public HttpTransactionTuple(long j2, Long l2, Long l3, String str, String str2, String str3, String str4, String str5, Integer num, Long l4, Long l5, String str6, boolean z, String str7) {
        this.f16698a = j2;
        this.f16699b = l2;
        this.f16700c = l3;
        this.f16701d = str;
        this.f16702e = str2;
        this.f16703f = str3;
        this.f16704g = str4;
        this.f16705h = str5;
        this.f16706i = num;
        this.f16707j = l4;
        this.f16708k = l5;
        this.f16709l = str6;
        this.f16710m = z;
        this.n = str7;
    }

    public final HttpTransaction.Status a() {
        return this.f16709l != null ? HttpTransaction.Status.f16695c : this.f16706i == null ? HttpTransaction.Status.f16693a : HttpTransaction.Status.f16694b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpTransactionTuple)) {
            return false;
        }
        HttpTransactionTuple httpTransactionTuple = (HttpTransactionTuple) obj;
        return this.f16698a == httpTransactionTuple.f16698a && Intrinsics.b(this.f16699b, httpTransactionTuple.f16699b) && Intrinsics.b(this.f16700c, httpTransactionTuple.f16700c) && Intrinsics.b(this.f16701d, httpTransactionTuple.f16701d) && Intrinsics.b(this.f16702e, httpTransactionTuple.f16702e) && Intrinsics.b(this.f16703f, httpTransactionTuple.f16703f) && Intrinsics.b(this.f16704g, httpTransactionTuple.f16704g) && Intrinsics.b(this.f16705h, httpTransactionTuple.f16705h) && Intrinsics.b(this.f16706i, httpTransactionTuple.f16706i) && Intrinsics.b(this.f16707j, httpTransactionTuple.f16707j) && Intrinsics.b(this.f16708k, httpTransactionTuple.f16708k) && Intrinsics.b(this.f16709l, httpTransactionTuple.f16709l) && this.f16710m == httpTransactionTuple.f16710m && Intrinsics.b(this.n, httpTransactionTuple.n);
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f16698a) * 31;
        Long l2 = this.f16699b;
        int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.f16700c;
        int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str = this.f16701d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f16702e;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f16703f;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f16704g;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f16705h;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.f16706i;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Long l4 = this.f16707j;
        int iHashCode10 = (iHashCode9 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.f16708k;
        int iHashCode11 = (iHashCode10 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str6 = this.f16709l;
        int iHashCode12 = (Boolean.hashCode(this.f16710m) + ((iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31)) * 31;
        String str7 = this.n;
        return iHashCode12 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HttpTransactionTuple(id=");
        sb.append(this.f16698a);
        sb.append(", requestDate=");
        sb.append(this.f16699b);
        sb.append(", tookMs=");
        sb.append(this.f16700c);
        sb.append(", protocol=");
        sb.append(this.f16701d);
        sb.append(", method=");
        sb.append(this.f16702e);
        sb.append(", host=");
        sb.append(this.f16703f);
        sb.append(", path=");
        sb.append(this.f16704g);
        sb.append(", scheme=");
        sb.append(this.f16705h);
        sb.append(", responseCode=");
        sb.append(this.f16706i);
        sb.append(", requestPayloadSize=");
        sb.append(this.f16707j);
        sb.append(", responsePayloadSize=");
        sb.append(this.f16708k);
        sb.append(", error=");
        sb.append(this.f16709l);
        sb.append(", graphQlDetected=");
        sb.append(this.f16710m);
        sb.append(", graphQlOperationName=");
        return b.r(sb, this.n, ")");
    }
}
