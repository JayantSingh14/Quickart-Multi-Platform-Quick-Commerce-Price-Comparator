package androidx.media3.extractor.text.webvtt;

import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import java.util.Comparator;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9483a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9483a) {
            case 0:
                return Integer.compare(((WebvttCueParser.Element) obj).f9458a.f9461b, ((WebvttCueParser.Element) obj2).f9458a.f9461b);
            default:
                return Long.compare(((WebvttCueInfo) obj).f9451b, ((WebvttCueInfo) obj2).f9451b);
        }
    }
}
