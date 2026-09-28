package com.chuckerteam.chucker.internal.data.har.log;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class Creator {

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName(CLConstants.FIELD_PAY_INFO_NAME)
    @NotNull
    private final String name;

    @SerializedName("version")
    @NotNull
    private final String version;

    public Creator(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Creator)) {
            return false;
        }
        Creator creator = (Creator) obj;
        return Intrinsics.b(this.name, creator.name) && Intrinsics.b(this.version, creator.version) && Intrinsics.b(this.comment, creator.comment);
    }

    public final int hashCode() {
        int iE = e.e(this.name.hashCode() * 31, 31, this.version);
        String str = this.comment;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.name;
        String str2 = this.version;
        return b.r(e.v("Creator(name=", str, ", version=", str2, ", comment="), this.comment, ")");
    }
}
