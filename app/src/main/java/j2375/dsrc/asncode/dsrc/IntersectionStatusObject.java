/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/IntersectionStatusObject.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> The values zero through 255 are allocated for testing purposes
 * <BR> Note that the value assigned to an intersection will be
 * <BR> unique within a given regional ID only
 * Class definition of the IntersectionStatusObject type of the dsrc module.
 */
public class IntersectionStatusObject extends fr.marben.asnsdk.japi.spe.BitStringValue
{
  /**
   * value of the named bit manualControlIsEnabled.
   */
  public static final int ASN_manualControlIsEnabled = 0;

  /**
   * value of the named bit stopTimeIsActivated.
   */
  public static final int ASN_stopTimeIsActivated = 1;

  /**
   * value of the named bit failureFlash.
   */
  public static final int ASN_failureFlash = 2;

  /**
   * value of the named bit preemptIsActive.
   */
  public static final int ASN_preemptIsActive = 3;

  /**
   * value of the named bit signalPriorityIsActive.
   */
  public static final int ASN_signalPriorityIsActive = 4;

  /**
   * value of the named bit fixedTimeOperation.
   */
  public static final int ASN_fixedTimeOperation = 5;

  /**
   * value of the named bit trafficDependentOperation.
   */
  public static final int ASN_trafficDependentOperation = 6;

  /**
   * value of the named bit standbyOperation.
   */
  public static final int ASN_standbyOperation = 7;

  /**
   * value of the named bit failureMode.
   */
  public static final int ASN_failureMode = 8;

  /**
   * value of the named bit off.
   */
  public static final int ASN_off = 9;

  /**
   * value of the named bit recentMAPmessageUpdate.
   */
  public static final int ASN_recentMAPmessageUpdate = 10;

  /**
   * value of the named bit recentChangeInMAPassignedLanesIDsUsed.
   */
  public static final int ASN_recentChangeInMAPassignedLanesIDsUsed = 11;

  /**
   * value of the named bit noValidMAPisAvailableAtThisTime.
   */
  public static final int ASN_noValidMAPisAvailableAtThisTime = 12;

  /**
   * value of the named bit noValidSPATisAvailableAtThisTime.
   */
  public static final int ASN_noValidSPATisAvailableAtThisTime = 13;

  /**
   *  Constructs a newly allocated IntersectionStatusObject.
   */
  public IntersectionStatusObject ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated IntersectionStatusObject.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the bytes array parameter.
   *  @param value the value to be represented by this IntersectionStatusObject.
   *  @param bitCount the number of used bits to be represented by this IntersectionStatusObject.
   *  @throws IllegalArgumentException if the bitCount is not consistent with the length of the value.
   */
  public IntersectionStatusObject (byte[] value, int bitCount)
  {
    super(value, bitCount);
  }

  /**
   *  Constructs a newly allocated IntersectionStatusObject.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the subarray of bytes.
   *  @param value the array containing the value to be represented by this IntersectionStatusObject.
   *  @param bitOffset  the index of the first bit to be represented by this IntersectionStatusObject.
   *  @param bitCount the number of used bits to be represented by this IntersectionStatusObject.
   *  @throws IllegalArgumentException if the bitCount and bitOffset are not consistent with the length of the value.
   */
  public IntersectionStatusObject (byte[] value, int bitOffset, int bitCount)
  {
    super(value, bitOffset, bitCount);
  }
}