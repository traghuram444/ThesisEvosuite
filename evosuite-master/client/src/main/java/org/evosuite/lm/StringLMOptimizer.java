/**
 * Copyright (C) 2010-2018 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * This file is part of EvoSuite.
 *
 * EvoSuite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * EvoSuite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with EvoSuite. If not, see <http://www.gnu.org/licenses/>.
 */
package org.evosuite.lm;

import java.io.IOException;

import org.evosuite.Properties;
import org.evosuite.testcase.ValueMinimizer;
import org.evosuite.testcase.variable.ConstantValue;

/**
 * Uses a language model to locate more readable alternatives
 * to strings generated by Evosuite.
 */
public class StringLMOptimizer {

	private String originalString;
	private ConstantValue constantValue;

	private LangModel languageModel;



    ValueMinimizer.Minimization objective;

	public StringLMOptimizer(ConstantValue constantValue, ValueMinimizer.Minimization objective) {
		// this.statement = originalStatement;
		this.constantValue = constantValue;
        this.objective = objective;

        this.originalString = (String)constantValue.getValue();

		try {
			languageModel = new LangModel(Properties.LM_SRC);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}






    /**
     * Attempt to generate a more readable replacement for the original string.
     * Uses a 1+1 EA to mutate the string with random suffixes generated from the language model. If a mutation
     * yields a greater score according to the model (almost inevitable) AND doesn't result in a reduction in the objective
     * value, the mutated string becomes the new value.
     */
	public String optimize() {
        LanguageModelSearch search = new LanguageModel11EA(constantValue, objective);
        return search.optimise();
	}
	
}