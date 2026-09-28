package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* loaded from: classes4.dex */
public class zzui extends zzif {

    /* renamed from: a, reason: collision with root package name */
    public final int f35644a;

    public zzui(IllegalStateException illegalStateException, zzuj zzujVar) {
        int errorCode;
        super("Decoder failed: ".concat(String.valueOf(zzujVar == null ? null : zzujVar.f35645a)), illegalStateException);
        if (illegalStateException instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) illegalStateException;
            codecException.getDiagnosticInfo();
            errorCode = codecException.getErrorCode();
        } else {
            errorCode = 0;
        }
        this.f35644a = errorCode;
    }
}
