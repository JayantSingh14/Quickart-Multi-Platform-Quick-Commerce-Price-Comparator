package androidx.media3.exoplayer.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaParser;
import android.media.MediaParser$InputReader;
import android.media.MediaParser$OutputConsumer;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.hls.d;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.NoOpExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

@RequiresApi
@SuppressLint({"Override"})
@UnstableApi
/* loaded from: classes3.dex */
public final class OutputConsumerAdapterV30 implements MediaParser$OutputConsumer {
    public static final Pair t = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    public static final Pattern u = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");

    /* renamed from: j, reason: collision with root package name */
    public MediaParser.SeekMap f7934j;

    /* renamed from: k, reason: collision with root package name */
    public MediaParser.SeekMap f7935k;

    /* renamed from: l, reason: collision with root package name */
    public String f7936l;

    /* renamed from: m, reason: collision with root package name */
    public ChunkIndex f7937m;
    public int o;
    public boolean q;
    public boolean r;
    public boolean s;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7930f = false;

    /* renamed from: h, reason: collision with root package name */
    public final Format f7932h = null;

    /* renamed from: g, reason: collision with root package name */
    public final int f7931g = -2;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7925a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7926b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7927c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7928d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final DataReaderAdapter f7929e = new DataReaderAdapter();

    /* renamed from: i, reason: collision with root package name */
    public ExtractorOutput f7933i = new NoOpExtractorOutput();
    public long p = -9223372036854775807L;
    public final List n = ImmutableList.r();

    public static final class DataReaderAdapter implements DataReader {

        /* renamed from: a, reason: collision with root package name */
        public MediaParser$InputReader f7938a;

        @Override // androidx.media3.common.DataReader
        public final int read(byte[] bArr, int i2, int i3) {
            MediaParser$InputReader mediaParser$InputReader = this.f7938a;
            int i4 = Util.f5744a;
            return d.i(mediaParser$InputReader).read(bArr, i2, i3);
        }
    }

    public static final class SeekMapAdapter implements SeekMap {

        /* renamed from: a, reason: collision with root package name */
        public final MediaParser.SeekMap f7939a;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.f7939a = seekMap;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints d(long j2) {
            Pair seekPoints = this.f7939a.getSeekPoints(j2);
            Object obj = seekPoints.first;
            if (obj == seekPoints.second) {
                MediaParser.SeekPoint seekPointK = d.k(obj);
                SeekPoint seekPoint = new SeekPoint(seekPointK.timeMicros, seekPointK.position);
                return new SeekMap.SeekPoints(seekPoint, seekPoint);
            }
            MediaParser.SeekPoint seekPointK2 = d.k(obj);
            SeekPoint seekPoint2 = new SeekPoint(seekPointK2.timeMicros, seekPointK2.position);
            MediaParser.SeekPoint seekPointK3 = d.k(seekPoints.second);
            return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPointK3.timeMicros, seekPointK3.position));
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean g() {
            return this.f7939a.isSeekable();
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long l() {
            long durationMicros = this.f7939a.getDurationMicros();
            if (durationMicros != -2147483648L) {
                return durationMicros;
            }
            return -9223372036854775807L;
        }
    }

    public final void a(int i2) {
        for (int size = this.f7925a.size(); size <= i2; size++) {
            this.f7925a.add(null);
            this.f7926b.add(null);
            this.f7927c.add(null);
            this.f7928d.add(null);
        }
    }

    public final void b() {
        if (!this.q || this.r) {
            return;
        }
        int size = this.f7925a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f7925a.get(i2) == null) {
                return;
            }
        }
        this.f7933i.m();
        this.r = true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void c(String str) {
        String str2;
        str.getClass();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    c2 = 2;
                    break;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    c2 = 3;
                    break;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    c2 = 4;
                    break;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    c2 = 5;
                    break;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    c2 = 6;
                    break;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    c2 = 7;
                    break;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 6:
                str2 = "video/mp4";
                break;
            case 1:
                str2 = "audio/ogg";
                break;
            case 2:
                str2 = "video/mp2t";
                break;
            case 3:
                str2 = "audio/mp4a-latm";
                break;
            case 4:
                str2 = "audio/raw";
                break;
            case 5:
                str2 = "video/mp2p";
                break;
            case 7:
                str2 = "audio/ac3";
                break;
            case '\b':
                str2 = "audio/amr";
                break;
            case '\t':
                str2 = "audio/flac";
                break;
            case '\n':
                str2 = "video/webm";
                break;
            case 11:
                str2 = "audio/ac4";
                break;
            case '\f':
                str2 = "audio/mpeg";
                break;
            case '\r':
                str2 = "video/x-flv";
                break;
            default:
                throw new IllegalArgumentException("Illegal parser name: ".concat(str));
        }
        this.f7936l = str2;
    }

    public final void onSampleCompleted(int i2, long j2, int i3, int i4, int i5, MediaCodec.CryptoInfo cryptoInfo) throws NumberFormatException {
        int i6;
        int i7;
        TrackOutput trackOutput;
        TrackOutput.CryptoData cryptoData;
        TrackOutput.CryptoData cryptoData2;
        ArrayList arrayList = this.f7928d;
        ArrayList arrayList2 = this.f7927c;
        long j3 = this.p;
        if (j3 == -9223372036854775807L || j2 < j3) {
            TrackOutput trackOutput2 = (TrackOutput) this.f7925a.get(i2);
            trackOutput2.getClass();
            if (cryptoInfo == null) {
                cryptoData2 = null;
            } else {
                if (((MediaCodec.CryptoInfo) arrayList2.get(i2)) != cryptoInfo) {
                    try {
                        Matcher matcher = u.matcher(cryptoInfo.toString());
                        matcher.find();
                        String strGroup = matcher.group(1);
                        int i8 = Util.f5744a;
                        i6 = Integer.parseInt(strGroup);
                        i7 = Integer.parseInt(matcher.group(2));
                    } catch (RuntimeException e2) {
                        Log.e("OConsumerAdapterV30", "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e2);
                        i6 = 0;
                        i7 = 0;
                    }
                    TrackOutput.CryptoData cryptoData3 = new TrackOutput.CryptoData(cryptoInfo.mode, i6, cryptoInfo.key, i7);
                    arrayList2.set(i2, cryptoInfo);
                    arrayList.set(i2, cryptoData3);
                    trackOutput = trackOutput2;
                    cryptoData = cryptoData3;
                    trackOutput.f(j2, i3, i4, i5, cryptoData);
                }
                cryptoData2 = (TrackOutput.CryptoData) arrayList.get(i2);
                cryptoData2.getClass();
            }
            cryptoData = cryptoData2;
            trackOutput = trackOutput2;
            trackOutput.f(j2, i3, i4, i5, cryptoData);
        }
    }

    public final void onSampleDataFound(int i2, MediaParser$InputReader mediaParser$InputReader) {
        a(i2);
        this.f7929e.f7938a = mediaParser$InputReader;
        TrackOutput trackOutputN = (TrackOutput) this.f7925a.get(i2);
        if (trackOutputN == null) {
            trackOutputN = this.f7933i.n(i2, -1);
            this.f7925a.set(i2, trackOutputN);
        }
        trackOutputN.c(this.f7929e, (int) mediaParser$InputReader.getLength(), true);
    }

    public final void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMapAdapter;
        if (this.f7930f && this.f7934j == null) {
            this.f7934j = seekMap;
            return;
        }
        this.f7935k = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        ExtractorOutput extractorOutput = this.f7933i;
        if (this.s) {
            if (durationMicros == -2147483648L) {
                durationMicros = -9223372036854775807L;
            }
            seekMapAdapter = new SeekMap.Unseekable(durationMicros);
        } else {
            seekMapAdapter = new SeekMapAdapter(seekMap);
        }
        extractorOutput.c(seekMapAdapter);
    }

    public final void onTrackCountFound(int i2) {
        this.q = true;
        b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x028b A[LOOP:0: B:107:0x01b8->B:138:0x028b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onTrackDataFound(int r21, android.media.MediaParser.TrackData r22) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30.onTrackDataFound(int, android.media.MediaParser$TrackData):void");
    }
}
