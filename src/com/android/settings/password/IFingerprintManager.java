/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.password;

import android.hardware.fingerprint.FingerprintManager.EnrollmentCallback;
import android.os.CancellationSignal;

/**
 * This is the workaround to allow us test {@link SetNewPasswordController} which uses a new hidden
 * API {@link android.hardware.fingerprint.FingerprintManager#hasEnrolledFingerprints(int)} that
 * roboelectric does not support yet. Having roboelectic to support latest platform API is tracked
 * in b/30995831.
 */
public interface IFingerprintManager {
    boolean isHardwareDetected();

    boolean hasEnrolledFingerprints(int userId);

    long preEnroll();

    void setActiveUser(int userId);

    void enroll(byte [] token, CancellationSignal cancel, int flags,
            int userId, EnrollmentCallback callback);
}
