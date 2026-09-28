package com.chuckerteam.chucker.internal.data.har;

import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.har.log.Browser;
import com.chuckerteam.chucker.internal.data.har.log.Creator;
import com.chuckerteam.chucker.internal.data.har.log.Entry;
import com.chuckerteam.chucker.internal.data.har.log.Page;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Log {

    @SerializedName("browser")
    @Nullable
    private final Browser browser;

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("creator")
    @NotNull
    private final Creator creator;

    @SerializedName("entries")
    @NotNull
    private final List<Entry> entries;

    @SerializedName("pages")
    @Nullable
    private final List<Page> pages;

    @SerializedName("version")
    @NotNull
    private final String version;

    public Log(List transactions, Creator creator) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(creator, "creator");
        List list = transactions;
        ArrayList entries = new ArrayList(CollectionsKt.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            entries.add(new Entry((HttpTransaction) it.next()));
        }
        Intrinsics.checkNotNullParameter("1.2", "version");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.version = "1.2";
        this.creator = creator;
        this.browser = null;
        this.pages = null;
        this.entries = entries;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Log)) {
            return false;
        }
        Log log = (Log) obj;
        return Intrinsics.b(this.version, log.version) && Intrinsics.b(this.creator, log.creator) && Intrinsics.b(this.browser, log.browser) && Intrinsics.b(this.pages, log.pages) && Intrinsics.b(this.entries, log.entries) && Intrinsics.b(this.comment, log.comment);
    }

    public final int hashCode() {
        int iHashCode = (this.creator.hashCode() + (this.version.hashCode() * 31)) * 31;
        Browser browser = this.browser;
        int iHashCode2 = (iHashCode + (browser == null ? 0 : browser.hashCode())) * 31;
        List<Page> list = this.pages;
        int iF = e.f((iHashCode2 + (list == null ? 0 : list.hashCode())) * 31, 31, this.entries);
        String str = this.comment;
        return iF + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "Log(version=" + this.version + ", creator=" + this.creator + ", browser=" + this.browser + ", pages=" + this.pages + ", entries=" + this.entries + ", comment=" + this.comment + ")";
    }
}
