/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

 
package gov.nasa.jpl.imce.oml.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}
import scala.Predef.ArrowAssoc

/**
  * @param uuid[1,1]
  * @param tboxUUID[1,1]
  * @param subPropertyUUID[1,1]
  * @param superPropertyUUID[1,1]
  */
@JSExportTopLevel("SubObjectPropertyOfAxiom")
case class SubObjectPropertyOfAxiom
(
  @(JSExport @field) override val uuid: taggedTypes.SubObjectPropertyOfAxiomUUID,
  @(JSExport @field) override val tboxUUID: taggedTypes.TerminologyBoxUUID,
  @(JSExport @field) val subPropertyUUID: taggedTypes.UnreifiedRelationshipUUID,
  @(JSExport @field) val superPropertyUUID: taggedTypes.UnreifiedRelationshipUUID
) extends ElementCrossReferenceTuple with TermAxiom {
  // Ctor(uuidWithContainer)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    tboxUUID: taggedTypes.TerminologyBoxUUID,
    subPropertyUUID: taggedTypes.UnreifiedRelationshipUUID,
    superPropertyUUID: taggedTypes.UnreifiedRelationshipUUID)
  = this(
      taggedTypes.subObjectPropertyOfAxiomUUID(oug.namespaceUUID(
        "SubObjectPropertyOfAxiom",
        "tbox" -> tboxUUID,
        "subProperty" -> subPropertyUUID,
        "superProperty" -> superPropertyUUID).toString),
      tboxUUID,
      subPropertyUUID,
      superPropertyUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, tboxUUID, subPropertyUUID, superPropertyUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: SubObjectPropertyOfAxiom =>
  	  (this.uuid == that.uuid) &&
  	  (this.tboxUUID == that.tboxUUID)  &&
  	  (this.subPropertyUUID == that.subPropertyUUID)  &&
  	  (this.superPropertyUUID == that.superPropertyUUID) 
    case _ =>
      false
  }
  
}

@JSExportTopLevel("SubObjectPropertyOfAxiomHelper")
object SubObjectPropertyOfAxiomHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "SubObjectPropertyOfAxioms.json"

  implicit val decodeSubObjectPropertyOfAxiom: Decoder[SubObjectPropertyOfAxiom]
  = Decoder.instance[SubObjectPropertyOfAxiom] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.SubObjectPropertyOfAxiomUUID]
    	  tboxUUID <- c.downField("tboxUUID").as[taggedTypes.TerminologyBoxUUID]
    	  subPropertyUUID <- c.downField("subPropertyUUID").as[taggedTypes.UnreifiedRelationshipUUID]
    	  superPropertyUUID <- c.downField("superPropertyUUID").as[taggedTypes.UnreifiedRelationshipUUID]
    	} yield SubObjectPropertyOfAxiom(
    	  uuid,
    	  tboxUUID,
    	  subPropertyUUID,
    	  superPropertyUUID
    	)
  }
  
  implicit val encodeSubObjectPropertyOfAxiom: Encoder[SubObjectPropertyOfAxiom]
  = new Encoder[SubObjectPropertyOfAxiom] {
    override final def apply(x: SubObjectPropertyOfAxiom): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeSubObjectPropertyOfAxiomUUID(x.uuid)),
    	  ("tboxUUID", taggedTypes.encodeTerminologyBoxUUID(x.tboxUUID)),
    	  ("subPropertyUUID", taggedTypes.encodeUnreifiedRelationshipUUID(x.subPropertyUUID)),
    	  ("superPropertyUUID", taggedTypes.encodeUnreifiedRelationshipUUID(x.superPropertyUUID))
    )
  }

  @JSExport
  def toJSON(c: SubObjectPropertyOfAxiom)
  : String
  = encodeSubObjectPropertyOfAxiom(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : SubObjectPropertyOfAxiom
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeSubObjectPropertyOfAxiom(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}
