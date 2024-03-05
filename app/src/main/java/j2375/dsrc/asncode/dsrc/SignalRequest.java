/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/SignalRequest.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the SignalRequest type of the dsrc module.
 */
public class SignalRequest extends fr.marben.asnsdk.japi.spe.ExtSequenceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 180;

  /**
   * <BR> the unique ID of the target intersection 
   * mandatory field id.
   */
  public j2375.dsrc.asncode.dsrc.IntersectionReferenceID id;

  /**
   * <BR> The unique requestID used by the requestor
   * mandatory field requestID.
   */
  public j2375.dsrc.asncode.dsrc.RequestID requestID;

  /**
   * <BR> The type of request or cancel for priority or preempt use
   * <BR> when a prior request is canceled, only the requestID is needed
   * mandatory field requestType.
   */
  public j2375.dsrc.asncode.dsrc.PriorityRequestType requestType;

  /**
   * <BR> In typical use either an approach or a lane number would
   * <BR> be given, this indicates the requested 
   * <BR> path through the intersection to the degree it is known
   * mandatory field inBoundLane.
   */
  public j2375.dsrc.asncode.dsrc.IntersectionAccessPoint inBoundLane;

  /**
   * <BR> desired entry approach or lane
   * optional field outBoundLane.
   */
  public j2375.dsrc.asncode.dsrc.IntersectionAccessPoint outBoundLane;

  /**
   * <BR> desired exit approach or lane
   * <BR> the values zero is used to indicate 
   * <BR> intent to stop within the intersection
   * optional field regional.
   */
  public Regional regional;

  /**
   * class definition of the regional field.
   */
  public static class Regional extends fr.marben.asnsdk.japi.spe.SequenceOfValue
  {
    /**
     * class definition of the SEQUENCE field.
     */
    public static class SEQUENCE extends fr.marben.asnsdk.japi.spe.SequenceValue
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
       *  Constructs a newly allocated SEQUENCE.
       */
      public SEQUENCE ()
      {
        super();
      };

      /**
       *  Gets the value of a component from this SEQUENCE.
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
       *  Creates a newly allocated component value from this SEQUENCE.
       *  this value is created for temporary use to solve atNotations
       *  This method is only for ASNSDK internal use.
       *  @param context a fr.marben.asnsdk.japi.Context.
       *  @param field the named type of this SEQUENCE.
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
       *  Creates and sets a newly allocated component value from this SEQUENCE.
       *  This method is only for ASNSDK internal use.
       *  @param context a fr.marben.asnsdk.japi.Context.
       *  @param field the named type of this SEQUENCE.
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
     *  Constructs a newly allocated Regional.
     */
    public Regional ()
    {
      super();
    };

    /**
     *  Constructs a newly allocated Regional with the given list.
     *  @param list the list used to initialize this Regional.
     */
    public Regional (java.util.List list)
    {
      super(list);
    };
    
    /**
     *  Creates and appends a newly allocated component value from 
     *  this Regional.
     *  This method is only for ASNSDK internal use. 
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type of this Regional.
     *  @return a value from a class implementing de IValue interface.
     */
    public fr.marben.asnsdk.japi.vi.IValue asnAddNewSetSeqOfValue(
                          fr.marben.asnsdk.japi.Context context,
                          fr.marben.asnsdk.japi.vi.ISetSeqOfNamedType field)
    {
          j2375.dsrc.asncode.dsrc.SignalRequest.Regional.SEQUENCE value = new j2375.dsrc.asncode.dsrc.SignalRequest.Regional.SEQUENCE();
          this.valueList.add(value);
          return value;
    }
  }

  /**
   *  Constructs a newly allocated SignalRequest.
   */
  public SignalRequest ()
  {
    super();
  };

  /**
   *  Gets the value of a component from this SignalRequest.
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
       return this.id;
     case 1 :
       return this.requestID;
     case 2 :
       return this.requestType;
     case 3 :
       return this.inBoundLane;
     case 4 :
       return this.outBoundLane;
     case 5 :
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated component value from this SignalRequest.
   *  this value is created for temporary use to solve atNotations
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this SignalRequest.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return new j2375.dsrc.asncode.dsrc.IntersectionReferenceID();
     case 1 :
       return new j2375.dsrc.asncode.dsrc.RequestID();
     case 2 :
       return new j2375.dsrc.asncode.dsrc.PriorityRequestType();
     case 3 :
       return new j2375.dsrc.asncode.dsrc.IntersectionAccessPoint();
     case 4 :
       return new j2375.dsrc.asncode.dsrc.IntersectionAccessPoint();
     case 5 :
       return new Regional();
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this SignalRequest.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this SignalRequest.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       this.id = new j2375.dsrc.asncode.dsrc.IntersectionReferenceID();
       return this.id;
     case 1 :
       this.requestID = new j2375.dsrc.asncode.dsrc.RequestID();
       return this.requestID;
     case 2 :
       this.requestType = new j2375.dsrc.asncode.dsrc.PriorityRequestType();
       return this.requestType;
     case 3 :
       this.inBoundLane = new j2375.dsrc.asncode.dsrc.IntersectionAccessPoint();
       return this.inBoundLane;
     case 4 :
       this.outBoundLane = new j2375.dsrc.asncode.dsrc.IntersectionAccessPoint();
       return this.outBoundLane;
     case 5 :
       this.regional = new Regional();
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Gets a group value from the SignalRequest.
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
   *  Creates a newly allocated group value of the SignalRequest.
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
   *  Creates and sets a newly allocated group value of the SignalRequest.
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
    return 180;
  }

}