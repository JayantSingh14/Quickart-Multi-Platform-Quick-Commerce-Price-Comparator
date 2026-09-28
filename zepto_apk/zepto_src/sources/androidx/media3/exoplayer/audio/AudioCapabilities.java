package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@UnstableApi
/* loaded from: classes3.dex */
public final class AudioCapabilities {

    /* renamed from: c, reason: collision with root package name */
    public static final AudioCapabilities f6491c = new AudioCapabilities(ImmutableList.t(AudioProfile.f6496d));

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableList f6492d;

    /* renamed from: e, reason: collision with root package name */
    public static final ImmutableMap f6493e;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f6494a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final int f6495b;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        private static ImmutableSet<Integer> a() {
            ImmutableSet.Builder builder = new ImmutableSet.Builder();
            builder.i(8, 7);
            int i2 = Util.f5744a;
            if (i2 >= 31) {
                builder.i(26, 27);
            }
            if (i2 >= 33) {
                builder.c(30);
            }
            return builder.k();
        }

        @DoNotInline
        public static boolean b(AudioManager audioManager, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo[] devices;
            if (audioDeviceInfoApi23 == null) {
                audioManager.getClass();
                devices = audioManager.getDevices(2);
            } else {
                devices = new AudioDeviceInfo[]{audioDeviceInfoApi23.f6515a};
            }
            ImmutableSet<Integer> immutableSetA = a();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (immutableSetA.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    @RequiresApi
    public static final class Api29 {
        /* JADX WARN: Multi-variable type inference failed */
        @DoNotInline
        public static ImmutableList<Integer> a(AudioAttributes audioAttributes) {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            UnmodifiableIterator it = AudioCapabilities.f6493e.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int iIntValue = num.intValue();
                if (Util.f5744a >= Util.q(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), audioAttributes.b().f5155a)) {
                    builder.h(num);
                }
            }
            builder.h(2);
            return builder.j();
        }

        @DoNotInline
        public static int b(int i2, int i3, AudioAttributes audioAttributes) {
            for (int i4 = 10; i4 > 0; i4--) {
                int iS = Util.s(i4);
                if (iS != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(iS).build(), audioAttributes.b().f5155a)) {
                    return i4;
                }
            }
            return 0;
        }
    }

    @RequiresApi
    public static final class Api33 {
        /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
        @androidx.annotation.DoNotInline
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static androidx.media3.exoplayer.audio.AudioCapabilities a(android.media.AudioManager r7, androidx.media3.common.AudioAttributes r8) {
            /*
                r0 = 1
                androidx.media3.common.AudioAttributes$AudioAttributesV21 r8 = r8.b()
                android.media.AudioAttributes r8 = r8.f5155a
                java.util.List r7 = androidx.activity.i.w(r7, r8)
                androidx.media3.exoplayer.audio.AudioCapabilities r8 = new androidx.media3.exoplayer.audio.AudioCapabilities
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                r2 = 2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.util.HashSet r3 = new java.util.HashSet
                r4 = 12
                int[] r4 = new int[]{r4}
                java.util.List r4 = com.google.common.primitives.Ints.a(r4)
                r3.<init>(r4)
                r1.put(r2, r3)
                r2 = 0
            L2a:
                int r3 = r7.size()
                if (r2 >= r3) goto L8f
                java.lang.Object r3 = r7.get(r2)
                android.media.AudioProfile r3 = androidx.media3.exoplayer.analytics.s.c(r3)
                int r4 = androidx.media3.exoplayer.analytics.s.b(r3)
                if (r4 != r0) goto L3f
                goto L8d
            L3f:
                int r4 = androidx.media3.exoplayer.analytics.s.C(r3)
                boolean r5 = androidx.media3.common.util.Util.O(r4)
                if (r5 != 0) goto L56
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                com.google.common.collect.ImmutableMap r6 = androidx.media3.exoplayer.audio.AudioCapabilities.f6493e
                boolean r5 = r6.containsKey(r5)
                if (r5 != 0) goto L56
                goto L8d
            L56:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                boolean r5 = r1.containsKey(r5)
                if (r5 == 0) goto L79
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                java.lang.Object r4 = r1.get(r4)
                java.util.Set r4 = (java.util.Set) r4
                r4.getClass()
                int[] r3 = androidx.media3.exoplayer.analytics.s.B(r3)
                java.util.List r3 = com.google.common.primitives.Ints.a(r3)
                r4.addAll(r3)
                goto L8d
            L79:
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                java.util.HashSet r5 = new java.util.HashSet
                int[] r3 = androidx.media3.exoplayer.analytics.s.B(r3)
                java.util.List r3 = com.google.common.primitives.Ints.a(r3)
                r5.<init>(r3)
                r1.put(r4, r5)
            L8d:
                int r2 = r2 + r0
                goto L2a
            L8f:
                com.google.common.collect.UnmodifiableListIterator r7 = com.google.common.collect.ImmutableList.f42665b
                com.google.common.collect.ImmutableList$Builder r7 = new com.google.common.collect.ImmutableList$Builder
                r7.<init>()
                java.util.Set r0 = r1.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L9e:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto Lc3
                java.lang.Object r1 = r0.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                androidx.media3.exoplayer.audio.AudioCapabilities$AudioProfile r2 = new androidx.media3.exoplayer.audio.AudioCapabilities$AudioProfile
                java.lang.Object r3 = r1.getKey()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                java.lang.Object r1 = r1.getValue()
                java.util.Set r1 = (java.util.Set) r1
                r2.<init>(r3, r1)
                r7.h(r2)
                goto L9e
            Lc3:
                com.google.common.collect.ImmutableList r7 = r7.j()
                r8.<init>(r7)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioCapabilities.Api33.a(android.media.AudioManager, androidx.media3.common.AudioAttributes):androidx.media3.exoplayer.audio.AudioCapabilities");
        }

        @Nullable
        @DoNotInline
        public static AudioDeviceInfoApi23 b(AudioManager audioManager, AudioAttributes audioAttributes) {
            try {
                audioManager.getClass();
                List audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(audioAttributes.b().f5155a);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new AudioDeviceInfoApi23((AudioDeviceInfo) audioDevicesForAttributes.get(0));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    static {
        Object[] objArr = {2, 5, 6};
        ObjectArrays.a(3, objArr);
        f6492d = ImmutableList.m(3, objArr);
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        builder.c(5, 6);
        builder.c(17, 6);
        builder.c(7, 6);
        builder.c(30, 10);
        builder.c(18, 6);
        builder.c(6, 8);
        builder.c(8, 8);
        builder.c(14, 8);
        f6493e = builder.a(true);
    }

    public AudioCapabilities(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            AudioProfile audioProfile = (AudioProfile) list.get(i2);
            this.f6494a.put(audioProfile.f6497a, audioProfile);
        }
        int iMax = 0;
        for (int i3 = 0; i3 < this.f6494a.size(); i3++) {
            iMax = Math.max(iMax, ((AudioProfile) this.f6494a.valueAt(i3)).f6498b);
        }
        this.f6495b = iMax;
    }

    public static ImmutableList a(int i2, int[] iArr) {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i3 : iArr) {
            builder.h(new AudioProfile(i3, i2));
        }
        return builder.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.audio.AudioCapabilities b(android.content.Context r5, android.content.Intent r6, androidx.media3.common.AudioAttributes r7, androidx.media3.exoplayer.audio.AudioDeviceInfoApi23 r8) {
        /*
            java.lang.String r0 = "audio"
            java.lang.Object r0 = r5.getSystemService(r0)
            r0.getClass()
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            r1 = 33
            if (r8 == 0) goto L10
            goto L1a
        L10:
            int r8 = androidx.media3.common.util.Util.f5744a
            if (r8 < r1) goto L19
            androidx.media3.exoplayer.audio.AudioDeviceInfoApi23 r8 = androidx.media3.exoplayer.audio.AudioCapabilities.Api33.b(r0, r7)
            goto L1a
        L19:
            r8 = 0
        L1a:
            int r2 = androidx.media3.common.util.Util.f5744a
            java.lang.String r3 = "android.hardware.type.automotive"
            r4 = 23
            if (r2 < r1) goto L39
            boolean r1 = androidx.media3.common.util.Util.R(r5)
            if (r1 != 0) goto L34
            if (r2 < r4) goto L39
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            boolean r1 = r1.hasSystemFeature(r3)
            if (r1 == 0) goto L39
        L34:
            androidx.media3.exoplayer.audio.AudioCapabilities r5 = androidx.media3.exoplayer.audio.AudioCapabilities.Api33.a(r0, r7)
            return r5
        L39:
            if (r2 < r4) goto L44
            boolean r8 = androidx.media3.exoplayer.audio.AudioCapabilities.Api23.b(r0, r8)
            if (r8 == 0) goto L44
            androidx.media3.exoplayer.audio.AudioCapabilities r5 = androidx.media3.exoplayer.audio.AudioCapabilities.f6491c
            return r5
        L44:
            com.google.common.collect.ImmutableSet$Builder r8 = new com.google.common.collect.ImmutableSet$Builder
            r8.<init>()
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.c(r0)
            r0 = 29
            r1 = 10
            if (r2 < r0) goto L82
            boolean r0 = androidx.media3.common.util.Util.R(r5)
            if (r0 != 0) goto L69
            if (r2 < r4) goto L82
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 == 0) goto L82
        L69:
            com.google.common.collect.ImmutableList r5 = androidx.media3.exoplayer.audio.AudioCapabilities.Api29.a(r7)
            r8.j(r5)
            androidx.media3.exoplayer.audio.AudioCapabilities r5 = new androidx.media3.exoplayer.audio.AudioCapabilities
            com.google.common.collect.ImmutableSet r6 = r8.k()
            int[] r6 = com.google.common.primitives.Ints.g(r6)
            com.google.common.collect.ImmutableList r6 = a(r1, r6)
            r5.<init>(r6)
            return r5
        L82:
            android.content.ContentResolver r5 = r5.getContentResolver()
            java.lang.String r7 = "use_external_surround_sound_flag"
            r0 = 0
            int r7 = android.provider.Settings.Global.getInt(r5, r7, r0)
            r2 = 1
            if (r7 != r2) goto L92
            r7 = r2
            goto L93
        L92:
            r7 = r0
        L93:
            if (r7 != 0) goto La7
            java.lang.String r3 = androidx.media3.common.util.Util.f5746c
            java.lang.String r4 = "Amazon"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto La7
            java.lang.String r4 = "Xiaomi"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto Lb4
        La7:
            java.lang.String r3 = "external_surround_sound_enabled"
            int r5 = android.provider.Settings.Global.getInt(r5, r3, r0)
            if (r5 != r2) goto Lb4
            com.google.common.collect.ImmutableList r5 = androidx.media3.exoplayer.audio.AudioCapabilities.f6492d
            r8.j(r5)
        Lb4:
            if (r6 == 0) goto Le7
            if (r7 != 0) goto Le7
            java.lang.String r5 = "android.media.extra.AUDIO_PLUG_STATE"
            int r5 = r6.getIntExtra(r5, r0)
            if (r5 != r2) goto Le7
            java.lang.String r5 = "android.media.extra.ENCODINGS"
            int[] r5 = r6.getIntArrayExtra(r5)
            if (r5 == 0) goto Lcf
            java.util.List r5 = com.google.common.primitives.Ints.a(r5)
            r8.j(r5)
        Lcf:
            androidx.media3.exoplayer.audio.AudioCapabilities r5 = new androidx.media3.exoplayer.audio.AudioCapabilities
            com.google.common.collect.ImmutableSet r7 = r8.k()
            int[] r7 = com.google.common.primitives.Ints.g(r7)
            java.lang.String r8 = "android.media.extra.MAX_CHANNEL_COUNT"
            int r6 = r6.getIntExtra(r8, r1)
            com.google.common.collect.ImmutableList r6 = a(r6, r7)
            r5.<init>(r6)
            return r5
        Le7:
            androidx.media3.exoplayer.audio.AudioCapabilities r5 = new androidx.media3.exoplayer.audio.AudioCapabilities
            com.google.common.collect.ImmutableSet r6 = r8.k()
            int[] r6 = com.google.common.primitives.Ints.g(r6)
            com.google.common.collect.ImmutableList r6 = a(r1, r6)
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioCapabilities.b(android.content.Context, android.content.Intent, androidx.media3.common.AudioAttributes, androidx.media3.exoplayer.audio.AudioDeviceInfoApi23):androidx.media3.exoplayer.audio.AudioCapabilities");
    }

    public static AudioCapabilities c(Context context, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfoApi23);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair d(androidx.media3.common.AudioAttributes r14, androidx.media3.common.Format r15) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioCapabilities.d(androidx.media3.common.AudioAttributes, androidx.media3.common.Format):android.util.Pair");
    }

    public final boolean e(int i2) {
        SparseArray sparseArray = this.f6494a;
        int i3 = Util.f5744a;
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public final boolean equals(Object obj) {
        boolean zContentEquals;
        if (this != obj) {
            if (obj instanceof AudioCapabilities) {
                AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
                SparseArray sparseArray = this.f6494a;
                SparseArray sparseArray2 = audioCapabilities.f6494a;
                int i2 = Util.f5744a;
                if (sparseArray != null) {
                    if (sparseArray2 != null) {
                        if (Util.f5744a >= 31) {
                            zContentEquals = sparseArray.contentEquals(sparseArray2);
                        } else {
                            int size = sparseArray.size();
                            if (size == sparseArray2.size()) {
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (Objects.equals(sparseArray.valueAt(i3), sparseArray2.get(sparseArray.keyAt(i3)))) {
                                    }
                                }
                                zContentEquals = true;
                            }
                        }
                    }
                    zContentEquals = false;
                    break;
                } else {
                    if (sparseArray2 != null) {
                        zContentEquals = false;
                        break;
                    }
                    zContentEquals = true;
                }
                if (!zContentEquals || this.f6495b != audioCapabilities.f6495b) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iContentHashCode;
        SparseArray sparseArray = this.f6494a;
        if (Util.f5744a >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i2)) + ((sparseArray.keyAt(i2) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return (iContentHashCode * 31) + this.f6495b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f6495b + ", audioProfiles=" + this.f6494a + "]";
    }

    public static final class AudioProfile {

        /* renamed from: d, reason: collision with root package name */
        public static final AudioProfile f6496d;

        /* renamed from: a, reason: collision with root package name */
        public final int f6497a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6498b;

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableSet f6499c;

        static {
            AudioProfile audioProfile;
            if (Util.f5744a >= 33) {
                ImmutableSet.Builder builder = new ImmutableSet.Builder();
                for (int i2 = 1; i2 <= 10; i2++) {
                    builder.c(Integer.valueOf(Util.s(i2)));
                }
                audioProfile = new AudioProfile(2, builder.k());
            } else {
                audioProfile = new AudioProfile(2, 10);
            }
            f6496d = audioProfile;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioProfile(int i2, Set set) {
            this.f6497a = i2;
            ImmutableSet immutableSetO = ImmutableSet.o(set);
            this.f6499c = immutableSetO;
            UnmodifiableIterator it = immutableSetO.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
            }
            this.f6498b = iMax;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            return this.f6497a == audioProfile.f6497a && this.f6498b == audioProfile.f6498b && Util.a(this.f6499c, audioProfile.f6499c);
        }

        public final int hashCode() {
            int i2 = ((this.f6497a * 31) + this.f6498b) * 31;
            ImmutableSet immutableSet = this.f6499c;
            return i2 + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public final String toString() {
            return "AudioProfile[format=" + this.f6497a + ", maxChannelCount=" + this.f6498b + ", channelMasks=" + this.f6499c + "]";
        }

        public AudioProfile(int i2, int i3) {
            this.f6497a = i2;
            this.f6498b = i3;
            this.f6499c = null;
        }
    }
}
