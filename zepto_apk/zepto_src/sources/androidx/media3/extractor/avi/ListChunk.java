package androidx.media3.extractor.avi;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

/* loaded from: classes3.dex */
final class ListChunk implements AviChunk {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f8689a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8690b;

    public ListChunk(int i2, ImmutableList immutableList) {
        this.f8690b = i2;
        this.f8689a = immutableList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ListChunk b(int i2, ParsableByteArray parsableByteArray) {
        AviChunk streamFormatChunk;
        String str;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i3 = parsableByteArray.f5725c;
        int i4 = -2;
        while (parsableByteArray.a() > 8) {
            int iL = parsableByteArray.l();
            int iL2 = parsableByteArray.f5724b + parsableByteArray.l();
            parsableByteArray.I(iL2);
            if (iL != 1414744396) {
                AviStreamHeaderChunk aviStreamHeaderChunk = null;
                switch (iL) {
                    case 1718776947:
                        if (i4 == 2) {
                            parsableByteArray.K(4);
                            int iL3 = parsableByteArray.l();
                            int iL4 = parsableByteArray.l();
                            parsableByteArray.K(4);
                            int iL5 = parsableByteArray.l();
                            switch (iL5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str != null) {
                                Format.Builder builder2 = new Format.Builder();
                                builder2.r = iL3;
                                builder2.s = iL4;
                                builder2.d(str);
                                streamFormatChunk = new StreamFormatChunk(new Format(builder2));
                                break;
                            } else {
                                a.r(iL5, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                streamFormatChunk = aviStreamHeaderChunk;
                                break;
                            }
                        } else {
                            if (i4 == 1) {
                                int iQ = parsableByteArray.q();
                                String str2 = iQ != 1 ? iQ != 85 ? iQ != 255 ? iQ != 8192 ? iQ != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iQ2 = parsableByteArray.q();
                                    int iL6 = parsableByteArray.l();
                                    parsableByteArray.K(6);
                                    int iB = Util.B(parsableByteArray.q());
                                    int iQ3 = parsableByteArray.a() > 0 ? parsableByteArray.q() : 0;
                                    byte[] bArr = new byte[iQ3];
                                    parsableByteArray.h(0, bArr, iQ3);
                                    Format.Builder builder3 = new Format.Builder();
                                    builder3.f5237l = MimeTypes.p(str2);
                                    builder3.z = iQ2;
                                    builder3.A = iL6;
                                    if ("audio/raw".equals(str2) && iB != 0) {
                                        builder3.B = iB;
                                    }
                                    if ("audio/mp4a-latm".equals(str2) && iQ3 > 0) {
                                        builder3.o = ImmutableList.t(bArr);
                                    }
                                    streamFormatChunk = new StreamFormatChunk(new Format(builder3));
                                    break;
                                } else {
                                    a.r(iQ, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                Log.h("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + Util.H(i4));
                            }
                            streamFormatChunk = aviStreamHeaderChunk;
                        }
                    case 1751742049:
                        int iL7 = parsableByteArray.l();
                        parsableByteArray.K(8);
                        int iL8 = parsableByteArray.l();
                        int iL9 = parsableByteArray.l();
                        parsableByteArray.K(4);
                        parsableByteArray.l();
                        parsableByteArray.K(12);
                        streamFormatChunk = new AviMainHeaderChunk(iL7, iL8, iL9);
                        break;
                    case 1752331379:
                        int iL10 = parsableByteArray.l();
                        parsableByteArray.K(12);
                        parsableByteArray.l();
                        int iL11 = parsableByteArray.l();
                        int iL12 = parsableByteArray.l();
                        parsableByteArray.K(4);
                        int iL13 = parsableByteArray.l();
                        int iL14 = parsableByteArray.l();
                        parsableByteArray.K(8);
                        aviStreamHeaderChunk = new AviStreamHeaderChunk(iL10, iL11, iL12, iL13, iL14);
                        streamFormatChunk = aviStreamHeaderChunk;
                        break;
                    case 1852994675:
                        streamFormatChunk = new StreamNameChunk(parsableByteArray.v(parsableByteArray.a(), Charsets.f42260c));
                        break;
                    default:
                        streamFormatChunk = aviStreamHeaderChunk;
                        break;
                }
            } else {
                streamFormatChunk = b(parsableByteArray.l(), parsableByteArray);
            }
            if (streamFormatChunk != null) {
                if (streamFormatChunk.getType() == 1752331379) {
                    int i5 = ((AviStreamHeaderChunk) streamFormatChunk).f8672a;
                    if (i5 == 1935960438) {
                        i4 = 2;
                    } else if (i5 == 1935963489) {
                        i4 = 1;
                    } else if (i5 != 1937012852) {
                        Log.h("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i5));
                        i4 = -1;
                    } else {
                        i4 = 3;
                    }
                }
                builder.h(streamFormatChunk);
            }
            parsableByteArray.J(iL2);
            parsableByteArray.I(i3);
        }
        return new ListChunk(i2, builder.j());
    }

    public final AviChunk a(Class cls) {
        UnmodifiableListIterator unmodifiableListIteratorListIterator = this.f8689a.listIterator(0);
        while (unmodifiableListIteratorListIterator.hasNext()) {
            AviChunk aviChunk = (AviChunk) unmodifiableListIteratorListIterator.next();
            if (aviChunk.getClass() == cls) {
                return aviChunk;
            }
        }
        return null;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return this.f8690b;
    }
}
