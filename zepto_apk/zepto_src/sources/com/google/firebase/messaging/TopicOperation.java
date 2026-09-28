package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
final class TopicOperation {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f44773d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f44774a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44775b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44776c;

    public TopicOperation(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + CLConstants.DOT_SALT_DELIMETER);
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f44773d.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
        }
        this.f44774a = strSubstring;
        this.f44775b = str;
        this.f44776c = android.support.v4.media.b.l(str, "!", str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        return this.f44774a.equals(topicOperation.f44774a) && this.f44775b.equals(topicOperation.f44775b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f44775b, this.f44774a);
    }
}
