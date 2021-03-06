/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cyclop.model;

/** @author Maciej Miklas */
public enum CassandraVersion {
	VER_1_2(1.2), VER_2_0(2.0), VER_2_1(2.1), VER_MAX(Double.MAX_VALUE);

	double version;

	private CassandraVersion(double version) {
		this.version = version;
	}

	public boolean after(CassandraVersion ver) {
		return version > ver.version;
	}

	public boolean before(CassandraVersion ver) {
		return version < ver.version;
	}
	
	public boolean min(CassandraVersion ver) {
		return version >= ver.version;
	}

	public boolean max(CassandraVersion ver) {
		return version <= ver.version;
	}

	public boolean within(CassandraVersion from, CassandraVersion to) {
		verifyFromTo(from, to);
		return version >= from.version && version <= to.version;
	}

	public boolean between(CassandraVersion from, CassandraVersion to) {
		verifyFromTo(from, to);
		return version > from.version && version < to.version;
	}

	private void verifyFromTo(CassandraVersion from, CassandraVersion to) {
		if (from.version > to.version) {
			throw new IllegalArgumentException("CassandraVersion -> from.version < to.version");
		}
	}
}
