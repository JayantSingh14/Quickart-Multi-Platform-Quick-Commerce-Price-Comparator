package com.facebook.react.devsupport;

import com.facebook.react.devsupport.interfaces.StackFrame;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class StackTraceHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18896a = 0;

    public static class StackFrameImpl implements StackFrame {

        /* renamed from: a, reason: collision with root package name */
        public final String f18897a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18898b;

        /* renamed from: c, reason: collision with root package name */
        public final int f18899c;

        /* renamed from: d, reason: collision with root package name */
        public final String f18900d;

        public StackFrameImpl(String str, String str2, String str3, int i2) {
            this.f18897a = str;
            this.f18900d = str2;
            this.f18898b = str3;
            this.f18899c = i2;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public final int getColumn() {
            return -1;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public final String getFile() {
            return this.f18897a;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public final String l() {
            return this.f18898b;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public final int m() {
            return this.f18899c;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public final String n() {
            return this.f18900d;
        }
    }

    static {
        Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
        Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");
    }
}
