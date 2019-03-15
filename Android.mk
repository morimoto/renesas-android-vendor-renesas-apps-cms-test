# Include only for Renesas ones.
ifneq (,$(filter $(TARGET_PRODUCT), salvator ulcb kingfisher))

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_PACKAGE_NAME := CmsTest

LOCAL_SRC_FILES := $(call all-java-files-under, java)

LOCAL_RESOURCE_DIR += \
    $(LOCAL_PATH)/res

LOCAL_SDK_VERSION := system_current
LOCAL_MODULE_TAGS := optional

LOCAL_PROPRIETARY_MODULE := true

LOCAL_STATIC_ANDROID_LIBRARIES += \
    android-support-constraint-layout

LOCAL_STATIC_JAVA_LIBRARIES := \
    android-support-constraint-layout-solver \
    vendor.renesas.graphics.cms-V1.0-java

LOCAL_CERTIFICATE := platform
LOCAL_USE_AAPT2 := true

include $(BUILD_PACKAGE)

endif # Include only for Renesas ones.
