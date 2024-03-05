/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/Attachment.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> zero to be used when valid value is unknown
 * Class definition of the Attachment type of the dsrc module.
 */
public class Attachment extends fr.marben.asnsdk.japi.spe.ExtEnumeratedValue
{
  /**
   * value of the named enumerated unavailable.
   */
  public static final int ASN_unavailable = 0;

  /**
   * value of the named enumerated stroller.
   */
  public static final int ASN_stroller = 1;

  /**
   * value of the named enumerated bicycleTrailer.
   */
  public static final int ASN_bicycleTrailer = 2;

  /**
   * value of the named enumerated cart.
   */
  public static final int ASN_cart = 3;

  /**
   * value of the named enumerated wheelchair.
   */
  public static final int ASN_wheelchair = 4;

  /**
   * value of the named enumerated otherWalkAssistAttachments.
   */
  public static final int ASN_otherWalkAssistAttachments = 5;

  /**
   * value of the named enumerated pet.
   */
  public static final int ASN_pet = 6;

  /**
   *  Constructs a newly allocated Attachment.
   */
  public Attachment ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated Attachment that represents the primitive int argument.
   *  @param value the value to be represented by this Attachment.
   */
  public Attachment (int value)
  {
    super(value);
  };

  /**
   *  Constructs a newly allocated Attachment that represents the unknownExt argument.
   *  @param unknownExt the unknown extension value to be represented by this Attachment.
   */
  public Attachment (fr.marben.asnsdk.japi.UnknownExtensionValue unknownExt)
  {
    super(unknownExt);
  };
}