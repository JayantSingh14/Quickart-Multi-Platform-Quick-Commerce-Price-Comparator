package com.brentvatne.exoplayer;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
@SuppressLint({"InlinedApi"})
/* loaded from: classes3.dex */
public final class AudioOutput {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f15513c;

    /* renamed from: d, reason: collision with root package name */
    public static final AudioOutput f15514d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AudioOutput[] f15515e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f15516f;

    /* renamed from: a, reason: collision with root package name */
    public final String f15517a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15518b;

    @Metadata
    public static final class Companion {
        public static AudioOutput a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (AudioOutput audioOutput : AudioOutput.values()) {
                if (audioOutput.f15517a.equalsIgnoreCase(name)) {
                    return audioOutput;
                }
            }
            return AudioOutput.f15514d;
        }
    }

    static {
        AudioOutput audioOutput = new AudioOutput(0, 3, "SPEAKER", "speaker");
        f15514d = audioOutput;
        AudioOutput[] audioOutputArr = {audioOutput, new AudioOutput(1, 0, "EARPIECE", "earpiece")};
        f15515e = audioOutputArr;
        f15516f = EnumEntriesKt.a(audioOutputArr);
        f15513c = new Companion();
    }

    public AudioOutput(int i2, int i3, String str, String str2) {
        this.f15517a = str2;
        this.f15518b = i3;
    }

    public static AudioOutput valueOf(String str) {
        return (AudioOutput) Enum.valueOf(AudioOutput.class, str);
    }

    public static AudioOutput[] values() {
        return (AudioOutput[]) f15515e.clone();
    }

    public final int a() {
        return this.f15518b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioOutput(");
        sb.append(this.f15517a);
        sb.append(", ");
        return android.support.v4.media.b.o(sb, this.f15518b, ")");
    }
}
