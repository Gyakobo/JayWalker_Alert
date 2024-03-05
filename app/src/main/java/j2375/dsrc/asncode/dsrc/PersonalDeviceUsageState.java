/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/PersonalDeviceUsageState.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> Use:
 * <BR> True  = On  (request crossing)
 * <BR> False = Off (no request)
 * Class definition of the PersonalDeviceUsageState type of the dsrc module.
 */
public class PersonalDeviceUsageState extends fr.marben.asnsdk.japi.spe.BitStringValue
{
  /**
   * value of the named bit unavailable.
   */
  public static final int ASN_unavailable = 0;

  /**
   * value of the named bit other.
   */
  public static final int ASN_other = 1;

  /**
   * value of the named bit idle.
   */
  public static final int ASN_idle = 2;

  /**
   * value of the named bit listeningToAudio.
   */
  public static final int ASN_listeningToAudio = 3;

  /**
   * value of the named bit typing.
   */
  public static final int ASN_typing = 4;

  /**
   * value of the named bit calling.
   */
  public static final int ASN_calling = 5;

  /**
   * value of the named bit playingGames.
   */
  public static final int ASN_playingGames = 6;

  /**
   * value of the named bit reading.
   */
  public static final int ASN_reading = 7;

  /**
   * value of the named bit viewing.
   */
  public static final int ASN_viewing = 8;

  /**
   *  Constructs a newly allocated PersonalDeviceUsageState.
   */
  public PersonalDeviceUsageState ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated PersonalDeviceUsageState.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the bytes array parameter.
   *  @param value the value to be represented by this PersonalDeviceUsageState.
   *  @param bitCount the number of used bits to be represented by this PersonalDeviceUsageState.
   *  @throws IllegalArgumentException if the bitCount is not consistent with the length of the value.
   */
  public PersonalDeviceUsageState (byte[] value, int bitCount)
  {
    super(value, bitCount);
  }

  /**
   *  Constructs a newly allocated PersonalDeviceUsageState.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the subarray of bytes.
   *  @param value the array containing the value to be represented by this PersonalDeviceUsageState.
   *  @param bitOffset  the index of the first bit to be represented by this PersonalDeviceUsageState.
   *  @param bitCount the number of used bits to be represented by this PersonalDeviceUsageState.
   *  @throws IllegalArgumentException if the bitCount and bitOffset are not consistent with the length of the value.
   */
  public PersonalDeviceUsageState (byte[] value, int bitOffset, int bitCount)
  {
    super(value, bitOffset, bitCount);
  }
}