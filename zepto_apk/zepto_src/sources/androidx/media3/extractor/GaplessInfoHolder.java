package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public final class GaplessInfoHolder {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f8567c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f8568a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f8569b = -1;

    public final boolean a(String str) throws NumberFormatException {
        Matcher matcher = f8567c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i2 = Util.f5744a;
            int i3 = Integer.parseInt(strGroup, 16);
            int i4 = Integer.parseInt(matcher.group(2), 16);
            if (i3 <= 0 && i4 <= 0) {
                return false;
            }
            this.f8568a = i3;
            this.f8569b = i4;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(Metadata metadata) {
        int i2 = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f5405a;
            if (i2 >= entryArr.length) {
                return;
            }
            Metadata.Entry entry = entryArr[i2];
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.f8817c) && a(commentFrame.f8818d)) {
                    return;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.f8830b) && "iTunSMPB".equals(internalFrame.f8831c) && a(internalFrame.f8832d)) {
                    return;
                }
            } else {
                continue;
            }
            i2++;
        }
    }
}
