import org.wso2.siddhi.core.query.selector.attribute.aggregator.AvgAttributeAggregator;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.Attribute.Type;

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
 * 
 * SWNV - sliding window normalized value log(last value)*lastvalue/mean( value over sliding window)
 */

public class SWNVAggrigator extends AvgAttributeAggregator{
	private long lastValue; 
	@Override
	public Type getReturnType() {
		return Attribute.Type.DOUBLE;
	}

	@Override
	public Object processAdd(Object data) {
		lastValue = (Long)data;
		System.out.print("A>");
		return calcuateSpike(lastValue, (Double)super.processAdd(data));
	}

	@Override
	public Object processAdd(Object[] data) {
		lastValue = (Long)data[data.length-1];
		System.out.print("AB>");
		return calcuateSpike(lastValue, (Double)super.processAdd(data));
	}

	@Override
	public Object processRemove(Object data) {
		System.out.print("R>");
		return calcuateSpike(lastValue, (Double)super.processRemove(data));
	}

	@Override
	public Object processRemove(Object[] data) {
		System.out.print("RB>");
		return calcuateSpike(lastValue, (Double)super.processRemove(data));
	}
	
	private Double calcuateSpike(long lastValue, double avg){
		System.out.println(lastValue + " "+ avg);
		return (Double)(lastValue/avg);
	}
}
