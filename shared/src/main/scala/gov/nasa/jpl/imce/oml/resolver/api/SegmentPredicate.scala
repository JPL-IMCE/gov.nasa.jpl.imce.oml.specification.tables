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

package gov.nasa.jpl.imce.oml.resolver.api

/*
 * An OML SegmentPredicate wraps a reference to an OML Term used as a predicate for an OML ChainRule.
 */
trait SegmentPredicate
  extends ElementCrossReferenceTuple
{
  val bodySegment: RuleBodySegment
  val predicate: scala.Option[Predicate]
  val reifiedRelationshipSource: scala.Option[ReifiedRelationship]
  val reifiedRelationshipInverseSource: scala.Option[ReifiedRelationship]
  val reifiedRelationshipTarget: scala.Option[ReifiedRelationship]
  val reifiedRelationshipInverseTarget: scala.Option[ReifiedRelationship]
  val unreifiedRelationshipInverse: scala.Option[UnreifiedRelationship]

  def termPredicate
  (): scala.Option[Term]
  def moduleContext
  ()(implicit extent: Extent): scala.Option[Module]
  override val uuid: taggedTypes.SegmentPredicateUUID
}

object SegmentPredicate {

  def moduleContext
  (s: SegmentPredicate, ext: Extent)
  : scala.Option[Module]
  = s.moduleContext()(ext)

}
