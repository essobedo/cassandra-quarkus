/*
 * Copyright DataStax, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.oss.quarkus.runtime.api.session;

import com.datastax.dse.driver.api.core.graph.GraphStatement;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.quarkus.runtime.api.reactive.MutinyContinuousReactiveResultSet;
import com.datastax.oss.quarkus.runtime.api.reactive.MutinyGraphReactiveResultSet;
import com.datastax.oss.quarkus.runtime.api.reactive.MutinyReactiveResultSet;
import edu.umd.cs.findbugs.annotations.NonNull;

public interface QuarkusCqlSession extends CqlSession {
  @NonNull
  @Override
  MutinyReactiveResultSet executeReactive(@NonNull String query);

  @NonNull
  @Override
  MutinyReactiveResultSet executeReactive(@NonNull Statement<?> statement);

  @NonNull
  @Override
  MutinyGraphReactiveResultSet executeReactive(@NonNull GraphStatement<?> statement);

  @NonNull
  @Override
  MutinyContinuousReactiveResultSet executeContinuouslyReactive(@NonNull String query);

  @NonNull
  @Override
  MutinyContinuousReactiveResultSet executeContinuouslyReactive(@NonNull Statement<?> statement);
}