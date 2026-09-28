package com.chuckerteam.chucker.internal.data.har.log;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.har.log.entry.Cache;
import com.chuckerteam.chucker.internal.data.har.log.entry.Request;
import com.chuckerteam.chucker.internal.data.har.log.entry.Response;
import com.chuckerteam.chucker.internal.data.har.log.entry.Timings;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class Entry {

    @SerializedName("cache")
    @NotNull
    private final Cache cache;

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("connection")
    @Nullable
    private final String connection;

    @SerializedName("pageref")
    @Nullable
    private final String pageref;

    @SerializedName("request")
    @NotNull
    private final Request request;

    @SerializedName("response")
    @NotNull
    private final Response response;

    @SerializedName("serverIPAddress")
    @Nullable
    private final String serverIPAddress;

    @SerializedName("startedDateTime")
    @NotNull
    private final String startedDateTime;

    @SerializedName("time")
    private long time;

    @SerializedName("timings")
    @NotNull
    private final Timings timings;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @VisibleForTesting
    public static final class DateFormat extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        public static final DateFormat f16711a = new DateFormat();

        @Override // java.lang.ThreadLocal
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        }
    }

    public Entry(HttpTransaction transaction) {
        String startedDateTime;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Long requestDate = transaction.getRequestDate();
        if (requestDate != null) {
            long jLongValue = requestDate.longValue();
            SimpleDateFormat simpleDateFormat = DateFormat.f16711a.get();
            Intrinsics.c(simpleDateFormat);
            startedDateTime = simpleDateFormat.format(new Date(jLongValue));
            Intrinsics.checkNotNullExpressionValue(startedDateTime, "format(...)");
        } else {
            startedDateTime = null;
        }
        startedDateTime = startedDateTime == null ? "" : startedDateTime;
        long jA = new Timings(transaction).a();
        Request request = new Request(transaction);
        Response response = new Response(transaction);
        Cache cache = new Cache(0);
        Timings timings = new Timings(transaction);
        Intrinsics.checkNotNullParameter(startedDateTime, "startedDateTime");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(timings, "timings");
        this.pageref = null;
        this.startedDateTime = startedDateTime;
        this.time = jA;
        this.request = request;
        this.response = response;
        this.cache = cache;
        this.timings = timings;
        this.serverIPAddress = null;
        this.connection = null;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return Intrinsics.b(this.pageref, entry.pageref) && Intrinsics.b(this.startedDateTime, entry.startedDateTime) && this.time == entry.time && Intrinsics.b(this.request, entry.request) && Intrinsics.b(this.response, entry.response) && Intrinsics.b(this.cache, entry.cache) && Intrinsics.b(this.timings, entry.timings) && Intrinsics.b(this.serverIPAddress, entry.serverIPAddress) && Intrinsics.b(this.connection, entry.connection) && Intrinsics.b(this.comment, entry.comment);
    }

    public final int hashCode() {
        String str = this.pageref;
        int iHashCode = (this.timings.hashCode() + ((this.cache.hashCode() + ((this.response.hashCode() + ((this.request.hashCode() + a.d(e.e((str == null ? 0 : str.hashCode()) * 31, 31, this.startedDateTime), 31, this.time)) * 31)) * 31)) * 31)) * 31;
        String str2 = this.serverIPAddress;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.connection;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comment;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String str = this.pageref;
        String str2 = this.startedDateTime;
        long j2 = this.time;
        Request request = this.request;
        Response response = this.response;
        Cache cache = this.cache;
        Timings timings = this.timings;
        String str3 = this.serverIPAddress;
        String str4 = this.connection;
        String str5 = this.comment;
        StringBuilder sbV = e.v("Entry(pageref=", str, ", startedDateTime=", str2, ", time=");
        sbV.append(j2);
        sbV.append(", request=");
        sbV.append(request);
        sbV.append(", response=");
        sbV.append(response);
        sbV.append(", cache=");
        sbV.append(cache);
        sbV.append(", timings=");
        sbV.append(timings);
        sbV.append(", serverIPAddress=");
        sbV.append(str3);
        b.B(sbV, ", connection=", str4, ", comment=", str5);
        sbV.append(")");
        return sbV.toString();
    }
}
