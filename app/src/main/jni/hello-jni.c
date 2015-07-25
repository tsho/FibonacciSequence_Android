#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_tsho_fibonaccisequence_MainActivity_stringFromNative
  (JNIEnv * env, jobject jobject)
  {
  return (*env)->NewStringUTF(env, "Hello From JNI");
  }
