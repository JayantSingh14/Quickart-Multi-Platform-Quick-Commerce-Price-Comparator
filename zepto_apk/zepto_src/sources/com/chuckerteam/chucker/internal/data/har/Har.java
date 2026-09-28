package com.chuckerteam.chucker.internal.data.har;

import com.chuckerteam.chucker.internal.data.har.log.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class Har {

    @SerializedName("log")
    @NotNull
    private final Log log;

    public Har(List transactions, Creator creator) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Log log = new Log(transactions, creator);
        Intrinsics.checkNotNullParameter(log, "log");
        this.log = log;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Har) && Intrinsics.b(this.log, ((Har) obj).log);
    }

    public final int hashCode() {
        return this.log.hashCode();
    }

    public final String toString() {
        return "Har(log=" + this.log + ")";
    }
}
