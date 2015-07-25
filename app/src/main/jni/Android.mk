LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := calcFibonacci
LOCAL_SRC_FILES := calcFibonacci.c
LOCAL_LDLIBS := -llog
include $(BUILD_SHARED_LIBRARY)
