package com.zeptoconsumerapp.PDFPasswordChecker;

import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import java.io.File;

/* loaded from: classes.dex */
public class PDFPasswordCheckModule extends ReactContextBaseJavaModule {
    public PDFPasswordCheckModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "PdfPasswordChecker";
    }

    @ReactMethod
    public void isPdfPasswordProtected(String str, Promise promise) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpen;
        PdfRenderer pdfRenderer;
        WritableMap writableMapCreateMap = Arguments.createMap();
        PdfRenderer pdfRenderer2 = null;
        try {
            parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
            try {
                try {
                    pdfRenderer = new PdfRenderer(parcelFileDescriptorOpen);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableMapCreateMap.putInt("pageCount", pdfRenderer.getPageCount());
                writableMapCreateMap.putBoolean("isEncrypted", false);
                promise.resolve(writableMapCreateMap);
                pdfRenderer.close();
                if (parcelFileDescriptorOpen != null) {
                    parcelFileDescriptorOpen.close();
                }
            } catch (Exception unused2) {
                pdfRenderer2 = pdfRenderer;
                writableMapCreateMap.putBoolean("isEncrypted", true);
                writableMapCreateMap.putInt("pageCount", 1);
                promise.resolve(writableMapCreateMap);
                if (pdfRenderer2 != null) {
                    pdfRenderer2.close();
                }
                if (parcelFileDescriptorOpen != null) {
                    parcelFileDescriptorOpen.close();
                }
            } catch (Throwable th2) {
                th = th2;
                pdfRenderer2 = pdfRenderer;
                if (pdfRenderer2 != null) {
                    pdfRenderer2.close();
                }
                if (parcelFileDescriptorOpen != null) {
                    parcelFileDescriptorOpen.close();
                }
                throw th;
            }
        } catch (Exception unused3) {
            parcelFileDescriptorOpen = null;
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptorOpen = null;
        }
    }
}
