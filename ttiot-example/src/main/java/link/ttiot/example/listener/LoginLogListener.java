/**
 * Copyright(c) link.ttiot & shijun All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Author: shijun (conttononline@outlook.com)
 */

package link.ttiot.example.listener;

import link.ttiot.broker.context.protocol.mqtt.MqttApplicationListener;
import link.ttiot.broker.eventor.connect.MqttConnectEvent;
import link.ttiot.broker.service.DeviceService;
import link.ttiot.broker.service.SessionService;
import link.ttiot.common.ioc.annotation.Inject;
import link.ttiot.common.ioc.annotation.Listener;

/**
 * @author: shijun
 * @date: 2019-05-06
 * @description:
 */
@Listener(asynchronous = true)
public class LoginLogListener extends MqttApplicationListener<MqttConnectEvent> {

    @Override
    public void onApplicationEvent(MqttConnectEvent mqttConnectEvent) {
        DbDemo.saveLogin(mqttConnectEvent.getTimestamp(), mqttConnectEvent.getDevName(), mqttConnectEvent.getTenantId());
    }
}
