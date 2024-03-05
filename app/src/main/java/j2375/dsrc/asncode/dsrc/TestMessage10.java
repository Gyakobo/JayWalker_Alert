/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/TestMessage10.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the TestMessage10 type of the dsrc module.
 */
public class TestMessage10 extends fr.marben.asnsdk.japi.spe.ExtSequenceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 213;

  /**
   * optional field header.
   */
  public j2375.dsrc.asncode.dsrc.Header header;

  /**
   * optional field regional.
   */
  public Regional regional;

  /**
   * class definition of the regional field.
   */
  public static class Regional extends fr.marben.asnsdk.japi.spe.SequenceValue
  {
    /**
     * mandatory field regionId.
     */
    public j2375.dsrc.asncode.dsrc.RegionId regionId;

    /**
     * mandatory field regExtValue.
     */
    public fr.marben.asnsdk.japi.spe.OpenTypeValue regExtValue;

    /**
     *  Constructs a newly allocated Regional.
     */
    public Regional ()
    {
      super();
    };

    /**
     *  Gets the value of a component from this Regional.
     *  This method is only for ASNSDK internal use.
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type identifier of the component.
     *  @return the value identified by the named type.
     */
     public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqValue(
                             fr.marben.asnsdk.japi.Context context,
                             fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
     {
       switch (field.getFieldNumber(context))
       {
       case 0 :
         return this.regionId;
       case 1 :
         return this.regExtValue;
       default :
         throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
       }
     }

    /**
     *  Creates a newly allocated component value from this Regional.
     *  this value is created for temporary use to solve atNotations
     *  This method is only for ASNSDK internal use.
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type of this Regional.
     *  @return a value from a class implementing the IValue interface.
     */
     public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                             fr.marben.asnsdk.japi.Context context,
                             fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
     {
       switch (field.getFieldNumber(context))
       {
       case 0 :
         return new j2375.dsrc.asncode.dsrc.RegionId();
       case 1 :
         return new fr.marben.asnsdk.japi.spe.OpenTypeValue();
       default :
         throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
       }
     }

    /**
     *  Creates and sets a newly allocated component value from this Regional.
     *  This method is only for ASNSDK internal use.
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type of this Regional.
     *  @return a value from a class implementing the IValue interface.
     */
     public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                             fr.marben.asnsdk.japi.Context context,
                             fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
     {
       switch (field.getFieldNumber(context))
       {
       case 0 :
         this.regionId = new j2375.dsrc.asncode.dsrc.RegionId();
         return this.regionId;
       case 1 :
         this.regExtValue = new fr.marben.asnsdk.japi.spe.OpenTypeValue();
         return this.regExtValue;
       default :
         throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
       }
     }

  }

  /**
   *  Constructs a newly allocated TestMessage10.
   */
  public TestMessage10 ()
  {
    super();
  };

  /**
   *  Gets the value of a component from this TestMessage10.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type identifier of the component.
   *  @return the value identified by the named type.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return this.header;
     case 1 :
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated component value from this TestMessage10.
   *  this value is created for temporary use to solve atNotations
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this TestMessage10.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return new j2375.dsrc.asncode.dsrc.Header();
     case 1 :
       return new Regional();
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this TestMessage10.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this TestMessage10.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       this.header = new j2375.dsrc.asncode.dsrc.Header();
       return this.header;
     case 1 :
       this.regional = new Regional();
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Gets a group value from the TestMessage10.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Returns whether or not this group is present among the extensions.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @return <code>true</code>: when the group is present.
   *          <code>false</code>: when the group is not present.
   */
   public boolean asnIsSetSeqGroupPresent(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated group value of the TestMessage10.
   *  This group is created for temporary use, in order to solve atNotations.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated group value of the TestMessage10.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Gets the typeIndex value for this class.
   *  This method is only for ASNSDK internal use. 
   *  @return the type index.
   */
  public int asnGetTypeIndex()
  {
    return 213;
  }

}