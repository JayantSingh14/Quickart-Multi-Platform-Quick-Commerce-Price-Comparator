package androidx.media3.exoplayer.analytics;

import android.graphics.Bitmap;
import android.media.UnsupportedSchemeException;
import android.text.Editable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.datasource.BitmapUtil;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DummyExoMediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;
import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.CuesWithTimingSubtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.net.MediaType;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.UUID;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class p implements ListenerSet.Event, DrmSessionManager.DrmSessionReference, ExoMediaDrm.Provider, HlsPlaylistTracker.Factory, BitmapFactoryImageDecoder.BitmapDecoder, Function, SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction, DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier, ExtractorsFactory, Id3Decoder.FramePredicate, UIManagerProvider, TransportScheduleCallback, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6486a;

    public /* synthetic */ p(int i2) {
        this.f6486a = i2;
    }

    @Override // androidx.media3.extractor.DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier
    public Constructor a() {
        switch (this.f6486a) {
            case 9:
                int[] iArr = DefaultExtractorsFactory.f8523e;
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                int[] iArr2 = DefaultExtractorsFactory.f8523e;
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(null);
        }
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        switch (this.f6486a) {
            case 7:
                return ImmutableList.t(Integer.valueOf(((ChunkSampleStream) obj).f7866a));
            case 15:
                Track track = (Track) obj;
                int i2 = Mp4Extractor.B;
                return track;
            case 18:
                Ordering ordering = CuesWithTimingSubtitle.f9159c;
                long j2 = ((CuesWithTiming) obj).f9156b;
                if (j2 == -9223372036854775807L) {
                    j2 = 0;
                }
                return Long.valueOf(j2);
            default:
                String str = (String) obj;
                if (MediaType.f43272g.n(str) && !str.isEmpty()) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(str.length() + 16);
                sb.append('\"');
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char cCharAt = str.charAt(i3);
                    if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                        sb.append('\\');
                    }
                    sb.append(cCharAt);
                }
                sb.append('\"');
                return sb.toString();
        }
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize b(CornerSize cornerSize) {
        int i2 = MaskableFrameLayout.f40188g;
        return cornerSize instanceof AbsoluteCornerSize ? new ClampedCornerSize(((AbsoluteCornerSize) cornerSize).f40968a) : cornerSize;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int c(Editable editable) {
        int i2 = TextInputLayout.l1;
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    @Override // com.facebook.react.bridge.UIManagerProvider
    public UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate
    public boolean e(int i2, int i3, int i4, int i5, int i6) {
        switch (this.f6486a) {
            case 13:
                break;
            default:
                if (i3 != 67 || i4 != 79 || i5 != 77 || (i6 != 77 && i2 != 2)) {
                    if (i3 == 77 && i4 == 76 && i5 == 76) {
                        if (i6 == 84 || i2 == 2) {
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override // com.google.android.datatransport.TransportScheduleCallback
    public void f(Exception exc) {
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public Extractor[] g() {
        switch (this.f6486a) {
            case 11:
                return new Extractor[]{new FlacExtractor()};
            case 12:
                return new Extractor[]{new FlvExtractor()};
            case 13:
            case 14:
            case 15:
            case 18:
            default:
                return new Extractor[]{new WavExtractor()};
            case 16:
                return new Extractor[]{new Mp4Extractor(16, SubtitleParser.Factory.f9179a)};
            case 17:
                return new Extractor[]{new OggExtractor()};
            case 19:
                return new Extractor[]{new Ac3Extractor()};
            case 20:
                return new Extractor[]{new Ac4Extractor()};
            case 21:
                return new Extractor[]{new AdtsExtractor()};
            case 22:
                return new Extractor[]{new PsExtractor()};
            case 23:
                return new Extractor[]{new TsExtractor(1, 1, SubtitleParser.Factory.f9179a, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(0))};
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
    public ExoMediaDrm h(UUID uuid) throws UnsupportedDrmException {
        try {
            try {
                return new FrameworkMediaDrm(uuid);
            } catch (UnsupportedDrmException unused) {
                Log.d("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + CLConstants.DOT_SALT_DELIMETER);
                return new DummyExoMediaDrm();
            }
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
    }

    public Bitmap i(int i2, byte[] bArr) throws ImageDecoderException {
        try {
            return BitmapUtil.a(i2, bArr);
        } catch (ParserException e2) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i2 + ")", e2);
        } catch (IOException e3) {
            throw new ImageDecoderException(e3);
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6486a) {
            case 0:
                analyticsListener.getClass();
                break;
            case 1:
                analyticsListener.getClass();
                break;
            default:
                analyticsListener.getClass();
                break;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
    public void release() {
    }
}
