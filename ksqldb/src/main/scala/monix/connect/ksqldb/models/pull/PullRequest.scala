/*
 * Copyright (c) 2020-2021 by The Monix Connect Project Developers.
 * See the project homepage at: https://connect.monix.io
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
 */

package monix.connect.ksqldb.models.pull

import tethys._
import tethys.derivation.semiauto._

/**
  * Model for representing a pull query request
  * @param sql KSQL pull query string
  * @param properties properties for pull query
  *
  * @author Andrey Romanov
  */
case class PullRequest(sql: String, properties: Map[String, String])

object PullRequest {

  implicit val reader: JsonReader[PullRequest] = jsonReader[PullRequest]
  implicit val writer: JsonWriter[PullRequest] = jsonWriter[PullRequest]

}
