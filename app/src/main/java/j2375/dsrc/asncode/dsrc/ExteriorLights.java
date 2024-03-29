/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/ExteriorLights.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> Encoded as a 4 bit value
 * Class definition of the ExteriorLights type of the dsrc module.
 */
public class ExteriorLights extends fr.marben.asnsdk.japi.spe.BitStringValue
{
  /**
   * value of the named bit lowBeamHeadlightsOn.
   */
  public static final int ASN_lowBeamHeadlightsOn = 0;

  /**
   * value of the named bit highBeamHeadlightsOn.
   */
  public static final int ASN_highBeamHeadlightsOn = 1;

  /**
   * value of the named bit leftTurnSignalOn.
   */
  public static final int ASN_leftTurnSignalOn = 2;

  /**
   * value of the named bit rightTurnSignalOn.
   */
  public static final int ASN_rightTurnSignalOn = 3;

  /**
   * value of the named bit hazardSignalOn.
   */
  public static final int ASN_hazardSignalOn = 4;

  /**
   * value of the named bit automaticLightControlOn.
   */
  public static final int ASN_automaticLightControlOn = 5;

  /**
   * value of the named bit daytimeRunningLightsOn.
   */
  public static final int ASN_daytimeRunningLightsOn = 6;

  /**
   * value of the named bit fogLightOn.
   */
  public static final int ASN_fogLightOn = 7;

  /**
   * value of the named bit parkingLightsOn.
   */
  public static final int ASN_parkingLightsOn = 8;

  /**
   *  Constructs a newly allocated ExteriorLights.
   */
  public ExteriorLights ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated ExteriorLights.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the bytes array parameter.
   *  @param value the value to be represented by this ExteriorLights.
   *  @param bitCount the number of used bits to be represented by this ExteriorLights.
   *  @throws IllegalArgumentException if the bitCount is not consistent with the length of the value.
   */
  public ExteriorLights (byte[] value, int bitCount)
  {
    super(value, bitCount);
  }

  /**
   *  Constructs a newly allocated ExteriorLights.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the subarray of bytes.
   *  @param value the array containing the value to be represented by this ExteriorLights.
   *  @param bitOffset  the index of the first bit to be represented by this ExteriorLights.
   *  @param bitCount the number of used bits to be represented by this ExteriorLights.
   *  @throws IllegalArgumentException if the bitCount and bitOffset are not consistent with the length of the value.
   */
  public ExteriorLights (byte[] value, int bitOffset, int bitCount)
  {
    super(value, bitOffset, bitCount);
  }
}
