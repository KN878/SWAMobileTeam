package com.swa.swamobileteam.utils.cryptoManager;

import android.os.Build;

public class VersionChecker {
    private static final int VERSION = Build.VERSION.SDK_INT;

    public static boolean lowerThanMarshmallow() {
        return VERSION < Build.VERSION_CODES.M;
    }

    public static boolean lowerThanJB() {
        return VERSION < Build.VERSION_CODES.JELLY_BEAN_MR2;
    }
}
