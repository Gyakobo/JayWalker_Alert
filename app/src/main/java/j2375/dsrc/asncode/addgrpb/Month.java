/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpb/Month.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpb;

/**
 * <BR> Unsigned units of minutes of an angle, in 1 octet 
 * <BR> values above 59 shall not be sent
 * <BR> except that value 255 (0xFF) shall indicate an invalid value
 * Class definition of the Month type of the addgrpb module.
 */
public class Month extends fr.marben.asnsdk.japi.spe.IntIntegerValue
{
  /**
   *  Constructs a newly allocated Month.
   */
  public Month ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated Month that represents the primitive int argument.
   *  @param value the value to be represented by this Month.
   */
  public Month (int value)
  {
    super(value);
  };
}