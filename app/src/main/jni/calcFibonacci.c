#include <jni.h>
#include <stdio.h>
#include <android/log.h>

#define TAG "calcFibonacci.c"

unsigned long calcFibonacci(jint n)
{
  unsigned long f;
  switch (n) {
    case 1:
    case 2:
      f = 1L;
      break;
    default:
      f = calcFibonacci(n - 1) + calcFibonacci(n - 2);
      break;
  }
  return (f);
}

jint fibonacciTarget;

JNIEXPORT jint JNICALL Java_com_tsho_fibonaccisequence_MainActivity_calcFibonacciFromNDK
 (JNIEnv * env, jobject jobject, jint fibonacciTarget) {
  jint a, b;

// OUTPUT LOG
//  __android_log_print(ANDROID_LOG_VERBOSE, TAG, "The value of 1 + 1 is %d", 1+1);
  return calcFibonacci(fibonacciTarget);
};


