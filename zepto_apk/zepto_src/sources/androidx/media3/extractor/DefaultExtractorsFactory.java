package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.common.FileTypes;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.extractor.amr.AmrExtractor;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.avif.AvifExtractor;
import androidx.media3.extractor.bmp.BmpExtractor;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.heif.HeifExtractor;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.png.PngExtractor;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleTranscodingExtractor;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import androidx.media3.extractor.webp.WebpExtractor;
import coil3.network.internal.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8523e = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* renamed from: f, reason: collision with root package name */
    public static final ExtensionLoader f8524f = new ExtensionLoader(new p(9));

    /* renamed from: g, reason: collision with root package name */
    public static final ExtensionLoader f8525g = new ExtensionLoader(new p(10));

    /* renamed from: a, reason: collision with root package name */
    public ImmutableList f8526a;

    /* renamed from: d, reason: collision with root package name */
    public int f8529d;

    /* renamed from: c, reason: collision with root package name */
    public DefaultSubtitleParserFactory f8528c = new DefaultSubtitleParserFactory();

    /* renamed from: b, reason: collision with root package name */
    public boolean f8527b = true;

    public static final class ExtensionLoader {

        /* renamed from: a, reason: collision with root package name */
        public final ConstructorSupplier f8530a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f8531b = new AtomicBoolean(false);

        public interface ConstructorSupplier {
            Constructor a();
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f8530a = constructorSupplier;
        }

        public final Extractor a(Object... objArr) {
            Constructor constructorA;
            synchronized (this.f8531b) {
                if (!this.f8531b.get()) {
                    try {
                        constructorA = this.f8530a.a();
                    } catch (ClassNotFoundException unused) {
                        this.f8531b.set(true);
                    } catch (Exception e2) {
                        throw new RuntimeException("Error instantiating extension", e2);
                    }
                }
                constructorA = null;
            }
            if (constructorA == null) {
                return null;
            }
            try {
                return (Extractor) constructorA.newInstance(objArr);
            } catch (Exception e3) {
                throw new IllegalStateException("Unexpected error creating extractor", e3);
            }
        }
    }

    public final void a(int i2, ArrayList arrayList) {
        switch (i2) {
            case 0:
                arrayList.add(new Ac3Extractor());
                break;
            case 1:
                arrayList.add(new Ac4Extractor());
                break;
            case 2:
                arrayList.add(new AdtsExtractor(0));
                break;
            case 3:
                arrayList.add(new AmrExtractor(0));
                break;
            case 4:
                Extractor extractorA = f8524f.a(0);
                if (extractorA == null) {
                    arrayList.add(new FlacExtractor(0));
                    break;
                } else {
                    arrayList.add(extractorA);
                    break;
                }
            case 5:
                arrayList.add(new FlvExtractor());
                break;
            case 6:
                arrayList.add(new MatroskaExtractor(this.f8527b ? 0 : 2, this.f8528c));
                break;
            case 7:
                arrayList.add(new Mp3Extractor(0));
                break;
            case 8:
                arrayList.add(new FragmentedMp4Extractor(this.f8527b ? 0 : 32, this.f8528c));
                arrayList.add(new Mp4Extractor(this.f8527b ? 0 : 16, this.f8528c));
                break;
            case 9:
                arrayList.add(new OggExtractor());
                break;
            case 10:
                arrayList.add(new PsExtractor());
                break;
            case 11:
                if (this.f8526a == null) {
                    this.f8526a = ImmutableList.r();
                }
                arrayList.add(new TsExtractor(1, !this.f8527b ? 1 : 0, this.f8528c, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(0, this.f8526a)));
                break;
            case 12:
                arrayList.add(new WavExtractor());
                break;
            case 14:
                arrayList.add(new JpegExtractor(this.f8529d));
                break;
            case 15:
                Extractor extractorA2 = f8525g.a(new Object[0]);
                if (extractorA2 != null) {
                    arrayList.add(extractorA2);
                    break;
                }
                break;
            case 16:
                arrayList.add(new AviExtractor(!this.f8527b ? 1 : 0, this.f8528c));
                break;
            case 17:
                arrayList.add(new PngExtractor());
                break;
            case 18:
                arrayList.add(new WebpExtractor());
                break;
            case 19:
                arrayList.add(new BmpExtractor());
                break;
            case 20:
                arrayList.add(new HeifExtractor());
                break;
            case 21:
                arrayList.add(new AvifExtractor());
                break;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final synchronized Extractor[] d(Uri uri, Map map) {
        Extractor[] extractorArr;
        try {
            int[] iArr = f8523e;
            ArrayList arrayList = new ArrayList(21);
            List list = (List) map.get(UtilsKt.CONTENT_TYPE);
            int iA = FileTypes.a((list == null || list.isEmpty()) ? null : (String) list.get(0));
            if (iA != -1) {
                a(iA, arrayList);
            }
            int iB = FileTypes.b(uri);
            if (iB != -1 && iB != iA) {
                a(iB, arrayList);
            }
            for (int i2 = 0; i2 < 21; i2++) {
                int i3 = iArr[i2];
                if (i3 != iA && i3 != iB) {
                    a(i3, arrayList);
                }
            }
            extractorArr = new Extractor[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Extractor subtitleTranscodingExtractor = (Extractor) arrayList.get(i4);
                if (this.f8527b && !(subtitleTranscodingExtractor.e() instanceof FragmentedMp4Extractor) && !(subtitleTranscodingExtractor.e() instanceof Mp4Extractor) && !(subtitleTranscodingExtractor.e() instanceof TsExtractor) && !(subtitleTranscodingExtractor.e() instanceof AviExtractor) && !(subtitleTranscodingExtractor.e() instanceof MatroskaExtractor)) {
                    subtitleTranscodingExtractor = new SubtitleTranscodingExtractor(subtitleTranscodingExtractor, this.f8528c);
                }
                extractorArr[i4] = subtitleTranscodingExtractor;
            }
        } catch (Throwable th) {
            throw th;
        }
        return extractorArr;
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final synchronized Extractor[] g() {
        return d(Uri.EMPTY, new HashMap());
    }
}
