package com.facebook.react.interfaces.exceptionmanager;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
@UnstableReactNativeAPI
/* loaded from: classes3.dex */
public interface ReactJsExceptionHandler {

    @DoNotStripAny
    @Metadata
    public interface ProcessedError {

        @DoNotStripAny
        @Metadata
        public interface StackFrame {
            @Nullable
            Integer getColumn();

            @Nullable
            String getFile();

            @Nullable
            Integer getLineNumber();

            @NotNull
            String getMethodName();
        }

        @Nullable
        String getComponentStack();

        @NotNull
        ReadableMap getExtraData();

        int getId();

        @NotNull
        String getMessage();

        @Nullable
        String getName();

        @Nullable
        String getOriginalMessage();

        @NotNull
        List<StackFrame> getStack();

        boolean isFatal();
    }

    @DoNotStripAny
    @Metadata
    public static final class ProcessedErrorImpl implements ProcessedError {

        @Nullable
        private final String componentStack;

        @NotNull
        private final ReadableNativeMap extraData;
        private final int id;
        private final boolean isFatal;

        @NotNull
        private final String message;

        @Nullable
        private final String name;

        @Nullable
        private final String originalMessage;

        @NotNull
        private final ArrayList<ProcessedErrorStackFrameImpl> stack;

        public ProcessedErrorImpl(@NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ArrayList<ProcessedErrorStackFrameImpl> stack, int i2, boolean z, @NotNull ReadableNativeMap extraData) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            this.message = message;
            this.originalMessage = str;
            this.name = str2;
            this.componentStack = str3;
            this.stack = stack;
            this.id = i2;
            this.isFatal = z;
            this.extraData = extraData;
        }

        public static /* synthetic */ ProcessedErrorImpl copy$default(ProcessedErrorImpl processedErrorImpl, String str, String str2, String str3, String str4, ArrayList arrayList, int i2, boolean z, ReadableNativeMap readableNativeMap, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = processedErrorImpl.message;
            }
            if ((i3 & 2) != 0) {
                str2 = processedErrorImpl.originalMessage;
            }
            if ((i3 & 4) != 0) {
                str3 = processedErrorImpl.name;
            }
            if ((i3 & 8) != 0) {
                str4 = processedErrorImpl.componentStack;
            }
            if ((i3 & 16) != 0) {
                arrayList = processedErrorImpl.stack;
            }
            if ((i3 & 32) != 0) {
                i2 = processedErrorImpl.id;
            }
            if ((i3 & 64) != 0) {
                z = processedErrorImpl.isFatal;
            }
            if ((i3 & 128) != 0) {
                readableNativeMap = processedErrorImpl.extraData;
            }
            boolean z2 = z;
            ReadableNativeMap readableNativeMap2 = readableNativeMap;
            ArrayList arrayList2 = arrayList;
            int i4 = i2;
            return processedErrorImpl.copy(str, str2, str3, str4, arrayList2, i4, z2, readableNativeMap2);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @Nullable
        public final String component2() {
            return this.originalMessage;
        }

        @Nullable
        public final String component3() {
            return this.name;
        }

        @Nullable
        public final String component4() {
            return this.componentStack;
        }

        @NotNull
        public final ArrayList<ProcessedErrorStackFrameImpl> component5() {
            return this.stack;
        }

        public final int component6() {
            return this.id;
        }

        public final boolean component7() {
            return this.isFatal;
        }

        @NotNull
        public final ReadableNativeMap component8() {
            return this.extraData;
        }

        @NotNull
        public final ProcessedErrorImpl copy(@NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ArrayList<ProcessedErrorStackFrameImpl> stack, int i2, boolean z, @NotNull ReadableNativeMap extraData) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            return new ProcessedErrorImpl(message, str, str2, str3, stack, i2, z, extraData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcessedErrorImpl)) {
                return false;
            }
            ProcessedErrorImpl processedErrorImpl = (ProcessedErrorImpl) obj;
            return Intrinsics.b(this.message, processedErrorImpl.message) && Intrinsics.b(this.originalMessage, processedErrorImpl.originalMessage) && Intrinsics.b(this.name, processedErrorImpl.name) && Intrinsics.b(this.componentStack, processedErrorImpl.componentStack) && Intrinsics.b(this.stack, processedErrorImpl.stack) && this.id == processedErrorImpl.id && this.isFatal == processedErrorImpl.isFatal && Intrinsics.b(this.extraData, processedErrorImpl.extraData);
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @Nullable
        public String getComponentStack() {
            return this.componentStack;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public int getId() {
            return this.id;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @Nullable
        public String getName() {
            return this.name;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @Nullable
        public String getOriginalMessage() {
            return this.originalMessage;
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            String str = this.originalMessage;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.componentStack;
            return this.extraData.hashCode() + ((Boolean.hashCode(this.isFatal) + a.b(this.id, (this.stack.hashCode() + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31)) * 31, 31)) * 31);
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        public boolean isFatal() {
            return this.isFatal;
        }

        @NotNull
        public String toString() {
            String str = this.message;
            String str2 = this.originalMessage;
            String str3 = this.name;
            String str4 = this.componentStack;
            ArrayList<ProcessedErrorStackFrameImpl> arrayList = this.stack;
            int i2 = this.id;
            boolean z = this.isFatal;
            ReadableNativeMap readableNativeMap = this.extraData;
            StringBuilder sbV = e.v("ProcessedErrorImpl(message=", str, ", originalMessage=", str2, ", name=");
            b.B(sbV, str3, ", componentStack=", str4, ", stack=");
            sbV.append(arrayList);
            sbV.append(", id=");
            sbV.append(i2);
            sbV.append(", isFatal=");
            sbV.append(z);
            sbV.append(", extraData=");
            sbV.append(readableNativeMap);
            sbV.append(")");
            return sbV.toString();
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @NotNull
        public ReadableNativeMap getExtraData() {
            return this.extraData;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError
        @NotNull
        public ArrayList<ProcessedErrorStackFrameImpl> getStack() {
            return this.stack;
        }
    }

    @DoNotStripAny
    @Metadata
    public static final class ProcessedErrorStackFrameImpl implements ProcessedError.StackFrame {

        @Nullable
        private final Integer column;

        @Nullable
        private final String file;

        @Nullable
        private final Integer lineNumber;

        @NotNull
        private final String methodName;

        public ProcessedErrorStackFrameImpl(@Nullable String str, @NotNull String methodName, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            this.file = str;
            this.methodName = methodName;
            this.lineNumber = num;
            this.column = num2;
        }

        public static /* synthetic */ ProcessedErrorStackFrameImpl copy$default(ProcessedErrorStackFrameImpl processedErrorStackFrameImpl, String str, String str2, Integer num, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = processedErrorStackFrameImpl.file;
            }
            if ((i2 & 2) != 0) {
                str2 = processedErrorStackFrameImpl.methodName;
            }
            if ((i2 & 4) != 0) {
                num = processedErrorStackFrameImpl.lineNumber;
            }
            if ((i2 & 8) != 0) {
                num2 = processedErrorStackFrameImpl.column;
            }
            return processedErrorStackFrameImpl.copy(str, str2, num, num2);
        }

        @Nullable
        public final String component1() {
            return this.file;
        }

        @NotNull
        public final String component2() {
            return this.methodName;
        }

        @Nullable
        public final Integer component3() {
            return this.lineNumber;
        }

        @Nullable
        public final Integer component4() {
            return this.column;
        }

        @NotNull
        public final ProcessedErrorStackFrameImpl copy(@Nullable String str, @NotNull String methodName, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            return new ProcessedErrorStackFrameImpl(str, methodName, num, num2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcessedErrorStackFrameImpl)) {
                return false;
            }
            ProcessedErrorStackFrameImpl processedErrorStackFrameImpl = (ProcessedErrorStackFrameImpl) obj;
            return Intrinsics.b(this.file, processedErrorStackFrameImpl.file) && Intrinsics.b(this.methodName, processedErrorStackFrameImpl.methodName) && Intrinsics.b(this.lineNumber, processedErrorStackFrameImpl.lineNumber) && Intrinsics.b(this.column, processedErrorStackFrameImpl.column);
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        @Nullable
        public Integer getColumn() {
            return this.column;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        @Nullable
        public String getFile() {
            return this.file;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        @Nullable
        public Integer getLineNumber() {
            return this.lineNumber;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler.ProcessedError.StackFrame
        @NotNull
        public String getMethodName() {
            return this.methodName;
        }

        public int hashCode() {
            String str = this.file;
            int iE = e.e((str == null ? 0 : str.hashCode()) * 31, 31, this.methodName);
            Integer num = this.lineNumber;
            int iHashCode = (iE + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.column;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            String str = this.file;
            String str2 = this.methodName;
            Integer num = this.lineNumber;
            Integer num2 = this.column;
            StringBuilder sbV = e.v("ProcessedErrorStackFrameImpl(file=", str, ", methodName=", str2, ", lineNumber=");
            sbV.append(num);
            sbV.append(", column=");
            sbV.append(num2);
            sbV.append(")");
            return sbV.toString();
        }
    }

    void reportJsException(@NotNull ProcessedError processedError);
}
