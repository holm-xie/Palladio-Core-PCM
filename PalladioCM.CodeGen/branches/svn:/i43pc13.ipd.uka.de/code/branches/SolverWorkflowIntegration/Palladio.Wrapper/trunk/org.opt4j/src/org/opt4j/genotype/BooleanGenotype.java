/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.genotype;

import java.util.ArrayList;

import org.opt4j.core.Genotype;

/**
 * The {@code BooleanGenotype} consists of Boolean values that can be used as a
 * {@code Genotype}.
 * 
 * @author lukasiewycz
 * 
 */
@SuppressWarnings("serial")
public class BooleanGenotype extends ArrayList<Boolean> implements ListGenotype {

	/**
	 * Constructs a {@code BooleanGenotype}.
	 */
	public BooleanGenotype() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.Genotype#newInstance()
	 */
	@SuppressWarnings("unchecked")
	public <G extends Genotype> G newInstance() {
		try {
			return (G) this.getClass().newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
