package com.chuckerteam.chucker.internal.data.har.log;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.har.log.page.PageTimings;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class Page {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName(CLConstants.SHARED_PREFERENCE_ITEM_ID)
    @NotNull
    private final String id;

    @SerializedName("pageTimings")
    @NotNull
    private final PageTimings pageTimings;

    @SerializedName("startedDateTime")
    @NotNull
    private final String startedDateTime;

    @SerializedName("title")
    @NotNull
    private final String title;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Page)) {
            return false;
        }
        Page page = (Page) obj;
        return Intrinsics.b(this.startedDateTime, page.startedDateTime) && Intrinsics.b(this.id, page.id) && Intrinsics.b(this.title, page.title) && Intrinsics.b(this.pageTimings, page.pageTimings) && Intrinsics.b(this.comment, page.comment);
    }

    public final int hashCode() {
        int iHashCode = (this.pageTimings.hashCode() + e.e(e.e(this.startedDateTime.hashCode() * 31, 31, this.id), 31, this.title)) * 31;
        String str = this.comment;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.startedDateTime;
        String str2 = this.id;
        String str3 = this.title;
        PageTimings pageTimings = this.pageTimings;
        String str4 = this.comment;
        StringBuilder sbV = e.v("Page(startedDateTime=", str, ", id=", str2, ", title=");
        sbV.append(str3);
        sbV.append(", pageTimings=");
        sbV.append(pageTimings);
        sbV.append(", comment=");
        return b.r(sbV, str4, ")");
    }
}
