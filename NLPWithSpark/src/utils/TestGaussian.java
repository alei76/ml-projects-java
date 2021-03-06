/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package utils;

import org.apache.commons.math3.analysis.function.Gaussian;

public class TestGaussian {

	public static void main(String[] args) {
		Gaussian gaussian = new Gaussian(100, 50);
		for(int i=0;i<1000;i++){
			int x = 10*i;
			System.out.println(x+ " = "+ String.format("%.2f", 0.1+100*gaussian.value(x)));
		}

	}

}
