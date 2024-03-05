/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/DirectionOfUse.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> units of hours
 * Class definition of the DirectionOfUse type of the dsrc module.
 */
public class DirectionOfUse extends fr.marben.asnsdk.japi.spe.EnumeratedValue
{
  /**
   * value of the named enumerated unavailable.
   */
  public static final int ASN_unavailable = 0;

  /**
   * value of the named enumerated forward.
   */
  public static final int ASN_forward = 1;

  /**
   * value of the named enumerated reverse.
   */
  public static final int ASN_reverse = 2;

  /**
   * value of the named enumerated both.
   */
  public static final int ASN_both = 3;

  /**
   *  Constructs a newly allocated DirectionOfUse.
   */
  public DirectionOfUse ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated DirectionOfUse that represents the primitive int argument.
   *  @param value the value to be represented by this DirectionOfUse.
   */
  public DirectionOfUse (int value)
  {
    super(value);
  };
}
